package me.lokka30.levelledmobs.commands.subcommands;

import me.lokka30.levelledmobs.LevelledMobs;
import me.lokka30.levelledmobs.managers.ExternalCompatibilityManager;
import me.lokka30.levelledmobs.misc.CachedModalList;
import me.lokka30.levelledmobs.misc.LivingEntityWrapper;
import me.lokka30.levelledmobs.misc.Utils;
import me.lokka30.levelledmobs.rules.RuleInfo;
import me.lokka30.microlib.MessageUtils;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * Shows the current rules as parsed from the various config files
 *
 * @author stumper66
 */
public class RulesSubcommand implements Subcommand {

    public RulesSubcommand(final LevelledMobs main){
        this.main = main;
    }

    private final LevelledMobs main;

    @Override
    public void parseSubcommand(final LevelledMobs main, @NotNull final CommandSender sender, final String label, final String[] args) {
        if (!sender.hasPermission("levelledmobs.command.rules")){
            main.configUtils.sendNoPermissionMsg(sender);
            return;
        }

        if (args.length == 1) {
            sender.sendMessage(MessageUtils.colorizeAll("&b&lLevelledMobs: &7Incomplete command"));
            return;
        }

        boolean showOnConsole = false;
        boolean findNearbyEntities = false;

        for (int i = 2; i < args.length; i++){
            if ("/console".equalsIgnoreCase(args[i]))
                showOnConsole = true;
            else if ("/near".equalsIgnoreCase(args[i]))
                findNearbyEntities = true;
        }

        if ("show_all".equalsIgnoreCase(args[1])) {
            if (sender instanceof Player)
                sender.sendMessage("Rules have been printed on the console");

            final StringBuilder sb = new StringBuilder();

            for (final String key : main.rulesParsingManager.rulePresets.keySet()) {
                final RuleInfo rpi = main.rulesParsingManager.rulePresets.get(key);
                sb.append("\n--------------------------------- Preset rule ----------------------------------\n");
                formatRulesVisually(rpi, sender, showOnConsole, Collections.singletonList("ruleIsEnabled"), sb);
            }

            sb.append("\n--------------------------------- Default values -------------------------------\n");
            formatRulesVisually(main.rulesParsingManager.defaultRule, sender, showOnConsole, null, sb);

            for (final RuleInfo rpi : main.rulesParsingManager.customRules) {
                sb.append("\n--------------------------------- Custom rule ----------------------------------\n");
                formatRulesVisually(rpi, sender, showOnConsole, null, sb);
            }
            sb.append("\n--------------------------------------------------------------------------------------");

            if (showOnConsole)
                Utils.logger.info(sb.toString());
            else
                sender.sendMessage(sb.toString());
        } else if ("show_effective".equalsIgnoreCase(args[1])) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("The command must be run by a player");
                return;
            }

            getMobBeingLookedAt((Player) sender, showOnConsole, findNearbyEntities);
        } else if ("show_rule".equalsIgnoreCase(args[1]))
            showRule(sender, args);
        else
            sender.sendMessage(MessageUtils.colorizeAll("&b&lLevelledMobs: &7Invalid command"));
    }

    private void showRule(final CommandSender sender, @NotNull final String[] args){
        if (args.length < 3){
            sender.sendMessage("Must specify a rule name.");
            return;
        }

        boolean showOnConsole = sender instanceof ConsoleCommandSender;

        String foundRule = null;
        final Map<String, RuleInfo> allRuleNames = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        for (final RuleInfo ruleInfo : main.rulesParsingManager.getAllRules())
            allRuleNames.put(ruleInfo.getRuleName().replace(" ", "_"), ruleInfo);

        final String lastArg = args[args.length - 1];
        String badRuleName = null;

        for (int i = 2; i < args.length; i++){
            final String arg = args[i].toLowerCase();

            if (foundRule == null && arg.length() > 0 && !arg.startsWith("/")) {
                if (allRuleNames.containsKey(arg))
                    foundRule = args[i];
                else if (badRuleName == null)
                    badRuleName = args[i];
            }

            if ("/console".equalsIgnoreCase(arg))
                showOnConsole = true;
        }

        if (badRuleName != null){
            sender.sendMessage("No rule was found with name " + badRuleName);
            return;
        }
        if (foundRule == null){
            sender.sendMessage("Must specify a rule name");
            return;
        }

        final RuleInfo rule = allRuleNames.get(foundRule);

        final StringBuilder sb = new StringBuilder();
        sb.append(MessageUtils.colorizeAll("Showing all values for rule: &b" + rule.getRuleName() + "&r\n"));

        formatRulesVisually(rule, sender, showOnConsole, Collections.singletonList("id"), sb);
        if (showOnConsole)
            Utils.logger.info(sb.toString());
        else
            sender.sendMessage(sb.toString());
    }

    private void getMobBeingLookedAt(@NotNull final Player player, final boolean showOnConsole, final boolean findNearbyEntities){
        LivingEntity livingEntity = null;
        final Location eye = player.getEyeLocation();
        SortedMap<Double, LivingEntity> entities = new TreeMap<>();

        for(final Entity entity : player.getNearbyEntities(10, 10, 10)){
            if (!(entity instanceof LivingEntity)) continue;

            LivingEntity le = (LivingEntity) entity;
            if (findNearbyEntities) {
                final double distance = le.getLocation().distanceSquared(player.getLocation());
                entities.put(distance, le);
            } else {
                final Vector toEntity = le.getEyeLocation().toVector().subtract(eye.toVector());
                double dot = toEntity.normalize().dot(eye.getDirection());
                if (dot >= 0.975D) {
                    livingEntity = le;
                    break;
                }
            }
        }

        if (!findNearbyEntities && livingEntity == null)
            player.sendMessage("Must be looking at a nearby entity");
        else if (findNearbyEntities && entities.isEmpty())
            player.sendMessage("No entities were found within a 10 block radius");
        else {
            if (findNearbyEntities)
                livingEntity = entities.get(entities.firstKey());

            createParticleEffect(livingEntity.getLocation());
            final LivingEntityWrapper lmEntity = new LivingEntityWrapper(livingEntity, main);

            String entityName = lmEntity.getTypeName();
            if (ExternalCompatibilityManager.hasMythicMobsInstalled() && ExternalCompatibilityManager.isMythicMob(lmEntity))
                entityName = ExternalCompatibilityManager.getMythicMobInternalName(lmEntity);
            //                                                                 0 1   2                3   4   5
            final String message = String.format("showing effective rules for: %s%s (%s) at location: %s, %s, %s",
                    lmEntity.isLevelled() ? "level " + lmEntity.getMobLevel() + " " : "",   // 0
                    entityName,                                                             // 1
                    lmEntity.getLivingEntity().getName(),                                   // 2
                    lmEntity.getLivingEntity().getLocation().getBlockX(),                   // 3
                    lmEntity.getLivingEntity().getLocation().getBlockY(),                   // 4
                    lmEntity.getLivingEntity().getLocation().getBlockZ()                    // 5
            );

            final StringBuilder sb = new StringBuilder();
            sb.append(message);

            player.sendMessage(sb.toString());
            if (!showOnConsole) sb.setLength(0);

            final BukkitRunnable runnable = new BukkitRunnable() {
                @Override
                public void run() {
                    showEffectiveValues(player, lmEntity, showOnConsole, sb);
                }
            };

            runnable.runTaskLater(main, 25);
        }
    }

    private void createParticleEffect(@NotNull final Location location){
        final World world = location.getWorld();
        if (world == null) return;

        final BukkitRunnable runnable = new BukkitRunnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        world.spawnParticle(Particle.SPELL, location, 20, 0, 0, 0, 0.1);
                        Thread.sleep(50);
                    }
                } catch (InterruptedException ignored) { }
            }
        };

        runnable.runTaskAsynchronously(main);
    }


    private void formatRulesVisually(@NotNull final RuleInfo pi, final CommandSender sender, final boolean showOnConsole, final List<String> excludedKeys, final StringBuilder sb){
        final SortedMap<String, String> values = new TreeMap<>();

        if (excludedKeys == null || !excludedKeys.contains("id")) {
            sb.append("id: ");
            sb.append(pi.getRuleName());
            sb.append("\n");
        }

        try {
            for(final Field f : pi.getClass().getDeclaredFields()) {
                if (!Modifier.isPublic(f.getModifiers())) continue;
                if (f.get(pi) == null) continue;
                if (f.getName().equals("ruleSourceNames")) continue;
                if (excludedKeys != null && excludedKeys.contains(f.getName())) continue;
                final Object value = f.get(pi);
                if (value.toString().equalsIgnoreCase("NOT_SPECIFIED")) continue;
                if (value.toString().equalsIgnoreCase("{}")) continue;
                if (value.toString().equalsIgnoreCase("[]")) continue;
                if (value.toString().equalsIgnoreCase("0")) continue;
                if (value.toString().equalsIgnoreCase("0.0")) continue;
                if (value.toString().equalsIgnoreCase("false")) continue;
                if (value.toString().equalsIgnoreCase("NONE")) continue;
                if (value instanceof CachedModalList<?>) {
                    CachedModalList<?> cml = (CachedModalList<?>) value;
                    if (cml.isEmpty() && !cml.allowAll && !cml.excludeAll) continue;
                }
                final String showValue = "&b" + f.getName() + "&r, value: &b" + value + "&r";
                values.put(f.getName(), showValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (final String key : values.keySet()){
            sb.append(MessageUtils.colorizeAll(values.get(key)));
            sb.append("\n");
        }

        sb.setLength(sb.length() - 1); // remove trailing newline
    }

    private void showEffectiveValues(final CommandSender sender, final @NotNull LivingEntityWrapper lmEntity, final boolean showOnConsole, final StringBuilder sb){
        final SortedMap<String, String> values = new TreeMap<>();
        final List<String> printedKeys = new LinkedList<>();
        final List<RuleInfo> effectiveRules = lmEntity.getApplicableRules();

        if (effectiveRules.isEmpty()){
            if (showOnConsole)
                Utils.logger.info(sb + "\nNo effective rules were found");
            else
                sender.sendMessage("No effective rules were found");
            return;
        }

        if (sb.length() > 0) sb.append("\n");

        try {
            for (int i = effectiveRules.size() - 1; i >= 0; i--) {
                final RuleInfo pi = effectiveRules.get(i);

                for (final Field f : pi.getClass().getDeclaredFields()) {
                    if (!Modifier.isPublic(f.getModifiers())) continue;
                    if (f.get(pi) == null) continue;
                    if (printedKeys.contains(f.getName())) continue;
                    if (f.getName().equals("ruleSourceNames")) continue;
                    final Object value = f.get(pi);
                    if (value instanceof Map && ((Map<?, ?>) value).isEmpty()) continue;
                    if (value instanceof List && ((List<?>) value).isEmpty()) continue;
                    if (value instanceof Enum &&
                            ("NONE".equals(value.toString()) || "NOT_SPECIFIED".equals(value.toString()))) continue;
                    if (f.getName().equals("ruleIsEnabled")) continue;

                    String showValue = f.getName() + ", value: " + value;
                    showValue += ", &1source: " + (
                            pi.ruleSourceNames.containsKey(f.getName()) ? pi.ruleSourceNames.get(f.getName()) : pi.getRuleName()
                    );
                    values.put(f.getName(), showValue);

                    printedKeys.add(f.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        final String fineTuning = "fine-tuning: " + (lmEntity.getFineTuningAttributes() == null ? "(null)" : lmEntity.getFineTuningAttributes().toString());
        sb.append(fineTuning);
        sb.append("&r\n");

        for (final String key : values.keySet()){
            sb.append(values.get(key));
            sb.append("&r\n");
        }

        sb.setLength(sb.length() - 1);

        if (showOnConsole)
            Utils.logger.info(sb.toString());
        else
            sender.sendMessage(MessageUtils.colorizeAll(sb.toString()));
    }

    @Override
    public List<String> parseTabCompletions(final LevelledMobs main, final CommandSender sender, @NotNull final String[] args) {
        if (!sender.hasPermission("levelledmobs.command.rules"))
            return null;

        final List<String> suggestions = new LinkedList<>();

        if (args.length == 2)
            return Arrays.asList("show_all", "show_effective", "show_rule");
        else if (args.length >= 3) {
            final boolean isShowRule = "show_rule".equalsIgnoreCase(args[1]);
            final boolean isEffective = "show_effective".equalsIgnoreCase(args[1]);
            boolean showOnConsole = false;
            boolean findNearbyEntities = false;
            boolean foundValue = false;
            final Set<String> allRuleNames = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
            for (final RuleInfo ruleInfo : main.rulesParsingManager.getAllRules())
                allRuleNames.add(ruleInfo.getRuleName().replace(" ", "_"));

            final String lastArg = args[args.length - 1];

            for (int i = 2; i < args.length; i++){
                final String arg = args[i].toLowerCase();

                if (arg.length() > 0 && !arg.startsWith("/") && allRuleNames.contains(arg))
                    foundValue = true;

                if ("/console".equalsIgnoreCase(arg))
                    showOnConsole = true;
                else if ("/near".equalsIgnoreCase(arg))
                    findNearbyEntities = true;
            }
            if (!showOnConsole) suggestions.add("/console");
            if (isEffective && !findNearbyEntities) suggestions.add("/near");
            if (isShowRule && !foundValue) suggestions.addAll(allRuleNames);
        }

        if (suggestions.isEmpty()) suggestions.add("");
        return suggestions;
    }
}
