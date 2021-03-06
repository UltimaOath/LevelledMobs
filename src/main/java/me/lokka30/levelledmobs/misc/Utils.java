package me.lokka30.levelledmobs.misc;

import me.lokka30.levelledmobs.LevelledMobs;
import me.lokka30.levelledmobs.rules.RulesManager;
import me.lokka30.microlib.MessageUtils;
import me.lokka30.microlib.MicroLogger;
import org.bukkit.block.Biome;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

/**
 * Holds common utilities
 *
 * @author lokka30, stumper66
 */
public final class Utils {

    /**
     * Use static methods, e.g. Utils.round, not new Utils().round for example.
     */
    private Utils() {
        throw new UnsupportedOperationException();
    }

    /**
     * Get a list of major Minecraft versions supported by LM.
     *
     * @return list
     */
    @NotNull
    public static List<String> getSupportedServerVersions() {
        return Arrays.asList("1.14", "1.15", "1.16");
    }

    @NotNull
    public static final MicroLogger logger = new MicroLogger("&b&lLevelledMobs: &7");

    /**
     * Rounds value to 2 decimal points.
     *
     * @param value value to round
     * @return rounded value
     */
    public static double round(final double value) {
        return Math.round(value * 100) / 100.00;
    }

    public static double round(final double value, final int digits) {
        final double scale = Math.pow(10, digits);
        return Math.round(value * scale) / scale;
    }

    /**
     * Replaces content of a message with case insensitivity.
     *
     * @param message     message that should be edited
     * @param replaceWhat the text to be replaced
     * @param replaceTo   the text to replace with
     * @return modified message
     * @author stumper66
     */
    @NotNull
    public static String replaceEx(@NotNull final String message, @NotNull final String replaceWhat, @NotNull final String replaceTo) {
        int count, position0, position1;
        count = position0 = 0;
        String upperString = message.toUpperCase();
        String upperPattern = replaceWhat.toUpperCase();
        int inc = (message.length() / replaceWhat.length()) *
                (replaceTo.length() - replaceWhat.length());
        char[] chars = new char[message.length() + Math.max(0, inc)];
        while ((position1 = upperString.indexOf(upperPattern, position0)) != -1) {
            for (int i = position0; i < position1; ++i)
                chars[count++] = message.charAt(i);
            for (int i = 0; i < replaceTo.length(); ++i)
                chars[count++] = replaceTo.charAt(i);
            position0 = position1 + replaceWhat.length();
        }
        if (position0 == 0) return message;
        for (int i = position0; i < message.length(); ++i)
            chars[count++] = message.charAt(i);

        return new String(chars, 0, count);
    }

    /**
     * Check if str is an integer
     *
     * @param str str to check
     * @return if str is an integer (e.g. "1234" = true, "hello" = false)
     */
    public static boolean isInteger(@Nullable final String str) {
        if (isNullOrEmpty(str)) return false;

        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static boolean isDouble(@Nullable final String str) {
        if (isNullOrEmpty(str)) return false;

        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static boolean isNullOrEmpty(@Nullable final String str) {
        return (str == null || str.isEmpty());
    }

    public static int getDefaultIfNull(@NotNull final YamlConfiguration cfg, @NotNull final String path, final int def) {
        return cfg.contains(path) ? cfg.getInt(path) : def;
    }

    public static int getDefaultIfNull(@NotNull final TreeMap<String, Integer> map, @NotNull final String item, final int def) {
        return map.getOrDefault(item, def);
    }

    @NotNull
    public static final List<String> oneToNine = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");

    @NotNull
    public static List<String> replaceAllInList(@NotNull final List<String> oldList, @NotNull final String replaceWhat, @NotNull final String replaceTo) {
        final List<String> newList = new ArrayList<>();
        for (final String string : oldList) {
            newList.add(string.replace(replaceWhat, replaceTo));
        }
        return newList;
    }

    @NotNull
    public static List<String> colorizeAllInList(@NotNull final List<String> oldList) {
        final List<String> newList = new ArrayList<>(oldList.size());

        for (final String string : oldList) {
            newList.add(MessageUtils.colorizeAll(string));
        }

        return newList;
    }

    /**
     * Sends a debug message to console if enabled in settings
     *
     * @param instance  LevelledMobs class
     * @param debugType Reference to whereabouts the debug log is called so that it can be traced back easily
     * @param msg       Message to help de-bugging
     */
    public static void debugLog(@NotNull final LevelledMobs instance, @NotNull final DebugType debugType, @NotNull final String msg) {
        if (instance.settingsCfg.getStringList("debug-misc").contains(debugType.toString())) {
            logger.info("&8[&bDebug: " + debugType + "&8]&7 " + msg);
        }
    }

    /**
     * If object1 is null, return object2
     *
     * @param object1 a nullable object
     * @param object2 a non-nullable object
     * @return object2 if object1 is null, otherwise, object1
     */
    public static Object getNonNull(@Nullable Object object1, @NotNull Object object2) {
        return object1 == null ? object2 : object1;
    }

    /**
     * Puts the string into lowercase and makes
     * every character that starts a word a
     * capital letter.
     * <p>
     * e.g. from: wiTheR sKeLeTOn
     * to: Wither Skeleton
     *
     * @param str string to capitalize
     * @return a string with each word capitalized
     */
    @NotNull
    public static String capitalize(@NotNull final String str) {
        final StringBuilder builder = new StringBuilder();
        final String[] words = str.toLowerCase(Locale.ROOT).split(" "); // each word separated from str
        for (int i = 0; i < words.length; i++) {
            final String word = words[i];
            if (word.isEmpty()) continue;

            builder.append(String.valueOf(word.charAt(0)).toUpperCase()); // capitalize first letter
            if (word.length() > 1)
                builder.append(word.substring(1)); // append the rest of the word

            // if there is another word to capitalize, then add a space
            if (i < words.length - 1)
                builder.append(" ");
        }

        return builder.toString();
    }

    public static boolean isLivingEntityInModalList(final CachedModalList<String> list, final LivingEntityWrapper lmEntity) {
        return isLivingEntityInModalList(list, lmEntity, false);
    }

    public static boolean isLivingEntityInModalList(@NotNull final CachedModalList<String> list, final LivingEntityWrapper lmEntity, final boolean checkBabyMobs) {
        if (list.allowAll) return true;
        if (list.excludeAll) return false;
        if (list.isEmpty()) return true;

        final String checkName = checkBabyMobs ?
                lmEntity.getNameIfBaby() :
                lmEntity.getTypeName();

        for (final String group : lmEntity.getApplicableGroups()) {
            if (list.excludedGroups.contains(group)) return false;
        }

        // for denies we'll check for both baby and adult variants regardless of baby-mobs-inherit-adult-setting
        if (list.excludedList.contains(lmEntity.getTypeName()) || list.excludedList.contains(lmEntity.getNameIfBaby()) ||
                lmEntity.isBabyMob() && list.excludedList.contains("baby_")) return false;

        for (final String group : lmEntity.getApplicableGroups()) {
            if (list.allowedGroups.contains(group)) return true;
        }

        return list.isBlacklist() || list.allowedList.contains(checkName) ||
                lmEntity.isBabyMob() && list.allowedList.contains("baby_");
    }

    public static boolean isBiomeInModalList(@NotNull final CachedModalList<Biome> list, final Biome biome, final RulesManager rulesManager) {
        if (list.allowAll) return true;
        if (list.excludeAll) return false;
        if (list.isEmpty()) return true;

        for (final String group : list.excludedGroups) {
            if (rulesManager.biomeGroupMappings.containsKey(group) &&
                    rulesManager.biomeGroupMappings.get(group).contains(biome.toString())) return false;
        }

        if (list.excludedList.contains(biome)) return false;

        for (final String group : list.allowedGroups) {
            if (rulesManager.biomeGroupMappings.containsKey(group) &&
                    rulesManager.biomeGroupMappings.get(group).contains(biome.toString()))
                return true;
        }

        return list.isBlacklist() || list.allowedList.contains(biome);
    }
}
