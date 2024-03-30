# 🔥 Debugging

Reference the [Command and Permissions](commands-and-permissions.md#lm-debug) page for the Debug command system.

## Set-Debug Options

* `apply_level_result` - When a level is applied
* `apply_multipliers` - When multipliers are applied
* `chunk_kill_count` - When the chunk kill max system activates
* `condition_biome_list` - When a biome condition is checked
* `condition_chance` - When a chance condition is checked
* `condition_custom_name` - When a custom name condition is checked
* `condition_entities_list` - When a entities condition is checked
* `condition_max_spawn_distance` - When a max spawn distance condition is checked
* `condition_maxlevel` - When a max-level condition is checked
* `condition_min_spawn_distance` - When a min spawn distance condition is checked
* `condition_minlevel` - When a min-level condition is checked
* `condition_mythicmobs_internal_name` - When a MythicMob internal name condition is checked
* `condition_permission` - When a permission condition is checked
* `condition_plugin_compat` - When a 3rd party plugin condition is checked
* `condition_spawn_reason` - When a spawn reason condition is checked
* `condition_spawner_name` - When a LM-Spawner cube name condition is checked
* `condition_wg_region` - When a WorldGuard region condition is checked
* `condition_wg_region_owner` - When a WorldGuard region owner condition is checked
* `condition_with_coordinates` - When a within-coordinate condition is checked
* `condition_world_list` - When a world condition is checked
* `condition_world_time_tick` - When a in-game-world-time condition is checked
* `condition_y_level` - When a y-height condition is checked
* `creeper_blast_radius` - When a creeper's blast radius is modified
* `custom_commands` - When a custom-command from Custom Drops is processed
* `custom_drops` - When a custom-drop from Custom Drops is processed
* `custom_equips` - When a custom-drop from Custom Drops is equipped to an entity
* `developer_lew_cache` - When the LivingEntityWrapper (LEW) is processing
* `entity_misc` - When a levelled entity transforms (villager to zombie-villager) or ages (baby zombie into adult zombie)
* `entity_spawn` - When an entity spawns and is recognized by LM
* `entity_tame` - When an entity is tamed
* `group_limits` - When a group-limit applies to Custom Drops being processed
* `lm_mob_spawner` - When an entity spawns from a LM-Spawner cube
* `mob_groups` - When an entity belongs to a custom mob-group
* `mob_hash` - When an entities rules-hash is processed
* `nbt_application` - When NBT-Data was processed with NBT-API
* `player_levelling` - When the Player Level Modifier processes
* `ranged_damage_modification` - When the ranged-attack-damage of a mob was processed
* `removed_multipliers` - When multipliers are removed
* `scoreboard_tags` - When a minecraft scoreboard condition is checked
* `set_levelled_item_drops` - When LM processes adjustments to item-drops
* `set_levelled_xp_drops` - When LM processes adjustments to xp-drops
* `setting_cooldown` - When a cooldown condition is checked
* `setting_stop_processing` - When LM is instructed to stop-processing via custom-rule
* `skylight_level` - When a skylight condition is checked
* `thread_locks` - Outputs internal thread-lock information

