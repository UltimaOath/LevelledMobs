# The Default / Custom Rules

Below will be a comprehensive listing of all **Custom Rules** applied with the default configuration files. These rules have been play-tested to be what we'd consider 'good choices' for the average server looking for a modest and unique challenge, but you are able to modify any rule listed below, craft your own rules using the same logic, or remove the custom rule(s) entirely keeping the **Default Rule** in charge.



***

## World Specific Levelling for Nether and The End

{% code overflow="wrap" %}
```yaml
  - custom-rule: 'Nether World Levelling Strategy'
    is-enabled: true
    conditions:
      worlds: 'world_nether'
    strategies:
      y-coordinate:
        start-height: 100
        period: 0
        end-height: 60
    settings:
      construct-level: '%y-coordinate% + %custom_nether%'

  - custom-rule: 'End World Levelling Strategy'
    is-enabled: true
    conditions:
      worlds: 'world_the_end'
    strategies:
      distance-from-origin:
        increase-level-distance: 200
        start-distance: 1000
        spawn-location:
          x: 0
          z: 0
    settings:
      construct-level: '%distance-from-origin% + %custom_end%'
```
{% endcode %}

These two custom rules are similar in function; each rule establishes a _condition_ check for the respective default Nether and The End world folder names. If the world the entity exists and matches this condition check, then this entity will use the established _strategy_ in the custom rule rather than what _strategy_ it was given prior to this rule applying. We also have to change the `construct-level:` to respect this change in _strategy_, since it would otherwise attempt to use the `construct-level:` established in the **Default Rule** which doesn't take into account the change in _strategy_. We incorporated a `custom_` placeholder tag which was created from the enabled **Default Rule** preset `lvlmodifier-custom-formula` providing a semi random modifier to the levels.

For the Nether world, we set it to use the **Y-Coordinate** levelling strategy, where the lowest levels will be at blocks 100 and higher; respecting Piglin farms on the bedrock ceiling. While the highest levels will be at blocks 40 and lower; meaning those mobs near the lava's surface will should be far stronger at the max level available to them.

As for the The End world, we set it to use the **Distance-From-Origin** levelling strategy, where you can establish a starting point and craft increasing rings of difficulty expanding out from that center-point. The settings used here reflect the starting point being the main End island at the Overworld teleporter, and the first level increase doesn't occur until you reach the first blocks of the expanded End realm.



## Modified Challenges and Nametags

{% code overflow="wrap" %}
```yaml
  - custom-rule: 'Bronze Challenge for Specific Mobs'
    is-enabled: true
    use-preset: challenge-bronze
    conditions:
      entities:
        included-groups: [ 'all_flying_mobs' ]
        included-list: [ 'ZOMBIFIED_PIGLIN', 'SHULKER', 'VEX', 'RAVAGER', 'HOGLIN', 'PILLAGER', 'WANDERING_TRADER', 'VILLAGER', 'ZOMBIE_VILLAGER', 'IRON_GOLEM', 'ENDER_DRAGON', 'ELDER_GUARDIAN', 'WITHER', 'WARDEN' ]

  - custom-rule: 'Vanilla Challenge for Specific Mobs'
    is-enabled: true
    use-preset: challenge-vanilla
    conditions:
      entities:
        included-groups: [ 'all_passive_mobs' ]
        included-list: [ 'BABY_' ]
        excluded-list: [ 'IRON_GOLEM' ]

  - custom-rule: 'Minimized Nametag for Specific Mobs'
    is-enabled: true
    use-preset: nametag-minimized
    conditions:
      entities:
        included-groups: [ 'all_passive_mobs' ]
        included-list: [ 'BABY_', 'WANDERING_TRADER', 'VILLAGER', 'ZOMBIE_VILLAGER', 'BAT', 'ENDER_DRAGON', 'ELDER_GUARDIAN', 'WITHER', 'WARDEN', 'IRON_GOLEM' ]

  - custom-rule: 'Reduced Nametag Visibility'
    is-enabled: true
    conditions:
      entities:
        included-groups: [ 'all_passive_mobs' ]
        included-list: [ 'BAT' ]
        excluded-list: [ 'IRON_GOLEM' ]
    settings:
      nametag-visibility-method: [ 'MELEE', 'ATTACKED' ]

  - custom-rule: 'Custom Attributes for Specific Mobs'
    is-enabled: true
    settings:
      attribute-modifier:
        custom-attribute-modifier:
          ENDERMAN:
            max-health: 0.5
            movement-speed: 0.0
          ENDERMITE:
            max-health: 0.5
            movement-speed: 0.0
          SILVERFISH:
            max-health: 0.5
            movement-speed: 0.0
          CREEPER:
            movement-speed: 0.05
```
{% endcode %}

These five custom rules achieve similar results: adjust the difficulty and levelling strategy of multiple mob types, as well as apply modified nametag settings to accommodate the adjusted stat changes.

In the first two custom rules, we simply set a reduced default challenge for a selected set of mobs. Some mobs take a single-step reduction (because their challenge is unique compared to average mobs, or they are boss/mini-boss mobs) or a two-step reduction down to vanilla stats. This is to allow all mobs to receive LevelledMobs functionality but without adjusting the stats for certain mobs which are farming specific or similar.

In the third and fourth custom rule, we change the nametags of these mobs. The first rule of this set we give mobs a reduced nametag which doesn't include their level output; useful for small-time mobs as well as 'special' boss/mini-boss mobs. The second rule reduces the visibility of nametags for passive mobs and similar, as to not overcrowd player farms with nametags.

The fifth rule allows you to set entity-specific attribute modifiers which would override any previous established attribute modifier value. This rule is important for the fairness of the average server. For example, the movement speed of Endermen, Endermite, and Silverfish are set to produce zero change regardless of the level. This is done because these entities already have a uniquely high movement speed by vanilla standards and increasing this further makes these mobs near impossible to hit, let alone defend against.&#x20;



## Farm and Spawner Cube Limiters

{% code overflow="wrap" %}
```yaml
  - custom-rule: 'Player Farm Item and XP Limiter'
    is-enabled: true
    settings:
      maximum-death-in-chunk-threshold: 15
      max-adjacent-chunks: 5
      chunk-max-cooldown-seconds: 10m
      disable-vanilla-drops-on-chunk-max: false
      disable-item-boost-on-chunk-max: true
      disable-xp-boost-on-chunk-max: true

  - custom-rule: 'Spawner Cube Entities'
    is-enabled: true
    use-preset: challenge-bronze
    conditions:
      spawn-reasons: [ 'SPAWNER' ]
    settings:
      entity-name-override:
        all_entities: 'Spawner %displayname%'
```
{% endcode %}

We do not want to break any servers' economy or farming setup by giving players an easy way to cheat the system. In an effort to help identify anyone taking advantage, or to provide a cooldown period generally for players gaining increased rewards, you have access to the **Deaths-in-Chunks Limiter**.\
This allows you to established how many levelled mobs it takes to trigger the limiter, how long the limiter will be enforced, how far away from the incident the limiter will apply, and to what extent the limiter will reduce or remove items entirely. \
For the default settings, we say that a player who kills twelve (12) levelled mobs in the same chunk in under five minutes (5m), then the chunk where the mobs killed exceeded the cap will be locked from receiving item or xp boosts normally provided by LevelledMobs; and that this same effect will apply to all adjacent chunks within three chunks of the original.&#x20;

The second rule allows better control over the entities which are produced from _Spawner Cubes_. This is both in fairness to the player and the server; to the player as these mobs can spawn at a rate and difficulty that is more difficult than intended to handle, and to the server as many players use _Spawner Cubes_ as part of their farming setup. While this rule does not remove the item-drop and xp-drop boost provided by the default configuration, it does use a reduced amount comparatively. This behavior can be edited by yourself to suit your servers' needs.



## Adding Armors and Weapons

{% code overflow="wrap" %}
```yaml
  - custom-rule: 'Armor and Weapons CustomDrop Table'
    is-enabled: true
    conditions:
      entities: [ 'ZOMBIE', 'HUSK', 'PIGLIN', 'ZOMBIFIED_PIGLIN' ]
    settings:
      use-droptable-id: armor_and_weapons
```
{% endcode %}

This rule uses the setting `use-droptable-id:` which connects to the Custom Drops system from the `customdrops.yml` file. This setting is referencing a Drop Table under `drop-table:` of the name `armor_and_weapons`, which exists in the default configuration. This drop table includes a low chance to apply two pieces of armor from a randomly selected set of four iron armors, as well as a similar low chance to give the mob a sword or axe. This rule only applies to a select few entities.\
Giving entities equipment is another way to spice up the challenge of a server without having to tweak the attributes of each and every mob.



## External Plugin Support

{% code overflow="wrap" %}
```yaml
  - custom-rule: 'External Plugins with Vanilla Stats and Minimized Nametags'
    is-enabled: true
    use-preset: challenge-vanilla, nametag-minimized
    conditions:
      external-plugins:
        included-list: ['eco-bosses', 'mythic-mobs', 'elite-mobs', 'infernal-mobs', 'citizens', 'shop-keepers', 'simple-pets', 'elite-bosses', 'blood-night']
        #excluded-list: ['*']
```
{% endcode %}

This custom rule connects to both internally supported plugins, as well as a few externally supported plugins from the `externalplugins.yml` file. It adds them to the approved list of levellable mobs, assigning them the minimized nametags and no stat changes by default.

