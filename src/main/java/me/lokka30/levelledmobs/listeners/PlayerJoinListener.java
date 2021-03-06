package me.lokka30.levelledmobs.listeners;

import me.lokka30.levelledmobs.LevelledMobs;
import me.lokka30.levelledmobs.misc.LivingEntityWrapper;
import me.lokka30.levelledmobs.misc.Utils;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

/**
 * Listens for when a player joins, leaves or changes worlds so that
 * send messages as needed, update nametags or track the player
 *
 * @author lokka30
 */
public class PlayerJoinListener implements Listener {

    private final LevelledMobs main;

    public PlayerJoinListener(final LevelledMobs main) {
        this.main = main;
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onJoin(@NotNull final PlayerJoinEvent event) {
        parseCompatibilityChecker(event.getPlayer());
        parseUpdateChecker(event.getPlayer());

        updateNametagsInWorldAsync(event.getPlayer(), event.getPlayer().getWorld().getEntities());

        if (main.migratedFromPre30 && event.getPlayer().isOp()){
            final List<String> msg = Collections.singletonList("You have migrated from an older version.  All settings have been reverted.  Please edit rules.yml");
            event.getPlayer().sendMessage(Utils.colorizeAllInList(msg).toString());
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    private void onPlayerQuitEvent(final PlayerQuitEvent event){
        if (main.papiManager != null)
            main.papiManager.playedLoggedOut(event.getPlayer());
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onChangeWorld(@NotNull final PlayerChangedWorldEvent event) {
        updateNametagsInWorldAsync(event.getPlayer(), event.getPlayer().getWorld().getEntities());
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onTeleport(@NotNull final PlayerTeleportEvent event) {
        if (event.getTo() != null && event.getTo().getWorld() != null)
            updateNametagsInWorldAsync(event.getPlayer(), event.getTo().getWorld().getEntities());
    }

    private void updateNametagsInWorldAsync(final Player player, final List<Entity> entities) {
        final BukkitRunnable runnable = new BukkitRunnable() {
            @Override
            public void run() {
                updateNametagsInWorld(player, entities);
            }
        };

        runnable.runTaskAsynchronously(main);
    }

    private void updateNametagsInWorld(final Player player, @NotNull final List<Entity> entities) {
        for (final Entity entity : entities) {
            if (!(entity instanceof LivingEntity)) continue;

            final LivingEntity livingEntity = (LivingEntity) entity;

            // mob must be alive
            if (!livingEntity.isValid()) continue;

            // mob must be levelled
            final LivingEntityWrapper lmEntity = new LivingEntityWrapper(livingEntity, main);
            if (!lmEntity.isLevelled()) continue;

            // public void updateNametagWithDelay(final LivingEntityWrapper lmEntity, final List<Player> playerList, final long delay) {
            main.levelManager.updateNametag(lmEntity, main.levelManager.getNametag(lmEntity, false), Collections.singletonList(player));
        }
    }

    void parseCompatibilityChecker(@NotNull final Player player) {
        // Player must have permission
        if (!player.hasPermission("levelledmobs.compatibility-notice")) return;

        // There must be possible incompatibilities
        if (main.incompatibilitiesAmount == 0) return;

        // Must be enabled in messages cfg
        if (!main.messagesCfg.getBoolean("other.compatibility-notice.enabled")) return;

        List<String> messages = main.messagesCfg.getStringList("other.compatibility-notice.messages");
        messages = Utils.replaceAllInList(messages, "%prefix%", main.configUtils.getPrefix());
        messages = Utils.replaceAllInList(messages, "%incompatibilities%", main.incompatibilitiesAmount + "");
        messages = Utils.colorizeAllInList(messages);
        messages.forEach(player::sendMessage);
    }

    void parseUpdateChecker(final Player player) {
        if (main.messagesCfg.getBoolean("other.update-notice.send-on-join", true) && player.hasPermission("levelledmobs.receive-update-notifications"))
            main.companion.updateResult.forEach(player::sendMessage);
    }
}
