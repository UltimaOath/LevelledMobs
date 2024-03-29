# Conditions

<details>

<summary>Click to view a comprehensive list of all <strong>Conditions</strong></summary>

{% code overflow="wrap" %}
```yaml
conditions: 
  spawn-reasons: ['']
  worldguard-regions: ['']
  worldguard-region-owners: ['']
  apply-above-y: 0
  apply-below-y: 0
  external-plugins: ['']
  biomes: ['']
  custom-names: ['']
  chance: 1.0
  entities: ['']
  maxLevel: 50
  minLevel: 1
  max-distance-from-spawn: 0
  min-distance-from-spawn: 0
  mob-customname-status: EITHER
  mob-tamed-status: EITHER
  mythicmobs-internal-names: ['']
  permission: ['']
  spawner-names: ['']
  scoreboard-tags: ['']
  stop-processing: true
  within-coordinates: 
    start-x: 0
    end-x: 0
    start-y: 0
    end-y: 0
    start-z: 0
    end-z: 0 
  worlds: ['']
  world-time-tick: ['']
  cooldown-duration: 10s
  cooldown-limit: 0
```
{% endcode %}

</details>

***

<table data-full-width="true"><thead><tr><th width="319">Modular Option Conditions</th><th>Description</th></tr></thead><tbody><tr><td><code>spawn-reasons:</code></td><td>Check against possible spawn reason flags.<br>You can reference <a href="https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/event/entity/CreatureSpawnEvent.SpawnReason.html">the SpigotMC javadocs</a> regarding <code>CreatureSpawnEvent.SpawnReason</code> for the different options. You may also use <code>LM_SUMMON</code> or <code>LM_SPAWNER</code>, referring to mobs created from the <code>/lm summon</code> or <code>/lm spawner</code> command.</td></tr><tr><td><code>worldguard-regions:</code><br><code>worldguard-region-owners:</code></td><td>Check against the WorldGuard region or region owner where the mob spawned.</td></tr><tr><td><code>apply-above-y:</code><br><code>apply-below-y:</code></td><td>Checks whether the mob is above or below a specific Y coordinate.</td></tr><tr><td><code>external-plugins:</code></td><td>Check against whether the spawned mob came from an internally or externally supported plugin.</td></tr><tr><td><code>biomes:</code></td><td>Check against the biome where the mob spawned.</td></tr><tr><td><code>custom-names:</code></td><td>Check against a mobs' Custom-Name when a level is first applied, presuming it has one.</td></tr><tr><td><code>chance:</code></td><td>Can be applied to a <strong>Custom Rule</strong> where the rule will only have the specified chance to apply the rule, otherwise it will be skipped.<br>By default, a rule without a specified chance will always process if it has been enabled.</td></tr><tr><td><code>entities:</code></td><td>Check against the mob which is being processed.</td></tr><tr><td><code>minLevel:</code><br><code>maxLevel:</code></td><td>Check against the level of the mob after it has been applied.<br>This check is only done for a handful of <strong>Settings</strong>, including Custom Drops.</td></tr><tr><td><code>min-distance-from-spawn:</code><br><code>max-distance-from-spawn:</code></td><td>Check against the minimum and maximum distance from the Minecraft server spawn coordinates where the mob spawned.</td></tr><tr><td><code>mob-customname-status:</code><br><code>mob-tamed-status:</code></td><td>Check against the Custom-Name or Tamed status of a mob.<br><br><code>NOT_SPECIFIED</code> / <code>EITHER</code> (Default)<br>Check is disabled / Check value does not matter<br><br><code>NAMETAGGED</code> / <code>TAMED</code><br>Checked mob must be either Nametagged or Tamed<br><br><code>NOT_NAMETAGGED</code> / <code>NOT_TAMED</code><br>Checked mob can not be either Nametagged or Tamed</td></tr><tr><td><code>mythicmobs-internal-names:</code></td><td>Check against the internal name used within the MythicMobs custom mob configuration file.</td></tr><tr><td><code>permission:</code></td><td>Check against the allowed permission nodes established for the nearest player to the entity, OR the player who killed an entity, depending on it's implementation. </td></tr><tr><td><code>spawner-names:</code></td><td>Check against the name of the <code>LM Spawner</code> which created the entity.</td></tr><tr><td><code>scoreboard-tags:</code></td><td>Check against any possible Minecraft Scoreboard tags applied to a mob, and whether those specified tags exist.</td></tr><tr><td><code>stop-processing:</code></td><td>Can be applied to a <strong>Custom Rule</strong> where the rule will cause future rule processing to cease upon activation of the <code>stop-processing:</code> setting.<br>By default, a rule without a specified stop-processing be processed from top down; starting with the Default Rule, then the first Custom Rule, and all subsequent rules in order.</td></tr><tr><td><code>within-coordinates:</code></td><td>This system allows you set the <code>start-</code> and <code>end-</code> coordinates to define a region within your world to apply a rule within. You can just specify a single axis to mark a single point or line; specify two axis to make a square along those two axis; or specify three to make a cuboid region. You can also place <code>'-'</code> or <code>'+'</code> as the <code>end-</code> of any coordinate and it will go from the <code>start-</code> value to infinity in the direction specified. Finally, if you specify a <code>start-</code> but do not specify an <code>end-</code>, then the <code>end-</code> will be the same value as the <code>start-</code>; and vice versa.</td></tr><tr><td><code>worlds:</code></td><td>Check against the world where the entity spawned.</td></tr><tr><td><code>world-time-tick:</code></td><td>Check against the current time of day in the world, represented by ticks. A 24 hour day in Minecraft is represented by a world-tick value between <code>0-24000</code>. You can get a <a href="https://minecraft.fandom.com/wiki/Daylight_cycle#24-hour_Minecraft_day">better sense of the time of by by referencing this link</a>. Only the Overworld has a 'time of day'.</td></tr><tr><td><code>cooldown-duration:</code><br><code>cooldown-limit:</code></td><td>Can be applied to a <strong>Custom Rule</strong> where the rule when successfully applied will count up from zero for each activation until it reaches the <code>cooldown-limit:</code>, then it will lock the rule from applying for the <code>cooldown-duration:</code> timer. Once the timer expires, the rule is unlocked and the limit count is reset.</td></tr></tbody></table>

