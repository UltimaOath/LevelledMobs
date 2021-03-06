package me.lokka30.levelledmobs.rules.strategies;

import me.lokka30.levelledmobs.misc.LivingEntityWrapper;

/**
 * Interface for the various levelling systems
 *
 * @author lokka30
 */
public interface LevellingStrategy {
    int generateLevel(final LivingEntityWrapper lmEntity, final int minLevel, final int maxLevel);
    void mergeRule(final LevellingStrategy levellingStrategy);
    LevellingStrategy cloneItem();
}