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
        end-height: 40
    settings:
      construct-level: '%y-coordinate%'

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
      construct-level: '%distance-from-origin%'
```
{% endcode %}

These two custom rules are similar in function; each rule establishes a _condition_ check for the respective default Nether and The End world folder names. If the world the entity exists and matches this condition check, then this entity will use the established _strategy_ in the custom rule rather than what _strategy_ it was given prior to this rule applying. We also have to change the `construct-level:` to respect this change in _strategy_, since it would otherwise attempt to use the `construct-level:` established in the **Default Rule** which doesn't take into account the change in _strategy_.&#x20;

For the Nether world, we set it to use the **Y-Coordinate** levelling strategy, where the lowest levels will be at blocks 100 and higher; respecting Piglin farms on the bedrock ceiling. While the highest levels will be at blocks 40 and lower; meaning those mobs near the lava's surface will should be far stronger at the max level available to them.

As for the The End world, we set it to use the **Distance-From-Origin** levelling strategy, where you can establish a starting point and craft increasing rings of difficulty expanding out from that center-point. The settings used here reflect the starting point being the main End island at the Overworld teleporter, and the first level increase doesn't occur until you reach the first blocks of the expanded End realm.



## Modified Challenges and Nametags

{% code overflow="wrap" %}
```yaml
  - custom-rule: 'Mobs with Vanilla Stats and Minimized Nametag'
    is-enabled: true
    use-preset: challenge-vanilla, nametag-no-level-displayed
    conditions:
      entities:
        included-groups: [ 'all_passive_mobs' ]
        included-list: [ 'BABY_', 'WANDERING_TRADER', 'VILLAGER', 'ZOMBIE_VILLAGER', 'BAT' ]
        excluded-list: [ 'IRON_GOLEM' ]

  - custom-rule: 'Mobs with Modified Nametag Visibility'
    is-enabled: true
    conditions:
      entities:
        included-groups: [ 'all_passive_mobs' ]
        included-list: [ 'BAT' ]
    settings:
      nametag-visibility-method: [ 'MELEE', 'ATTACKED' ]

  - custom-rule: 'Bronze Challenge for Specific Mobs'
    is-enabled: true
    use-preset: challenge-bronze
    conditions:
      entities:
        allowed-groups: [ 'all_flying_mobs' ]
        allowed-list: [ 'ZOMBIFIED_PIGLIN', 'SHULKER', 'VEX', 'RAVAGER', 'PILLAGER' ]
    strategies:
      weighted-random: true
    settings:
      maxLevel: 10
      construct-level: '%weighted-random%'

  - custom-rule: 'Bronze Challenge and Minimized Nametag for Specific Mobs'
    is-enabled: true
    use-preset: challenge-bronze, nametag-no-level-displayed
    conditions:
      entities: [ 'ENDER_DRAGON', 'ELDER_GUARDIAN', 'WITHER', 'WARDEN', 'WITHER_SKELETON', 'IRON_GOLEM' ]
    strategies:
      weighted-random: true
    settings:
      maxLevel: 5
      construct-level: '%weighted-random%'

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

In the first custom rule, _Mobs with Vanilla Stats and Minimized Nametag_, the goal of this rule is to gather a collection of mobs which many servers would prefer to leave at vanilla settings; while still allowing the entities to receive the nametag and other features. If you notice, we explicitly exclude the `IRON_GOLEM` from the rule; that is because we will apply a future rule to this entity and do not want to add information from this first rule to that entity because it would have to be undone with a future rule.

In the second rule, we modify the nametag visibility of the nametags for all passive mobs and bats; leaving their nametags invisible unless you've attacked one or hovering over it with your cursor. This is to help prevent a field of nametags obscuring your vision when you have pens of dozens of the same animal in farm setups.&#x20;

In the third and fourth custom rule, we do virtually the same thing: For the listed set of entities we move them from the default _Silver Challenge_ to the _Bronze Challenge_. This is done by virtue that the listed mobs are either considered 'boss' or 'mini-boss' mobs, or present a unique challenge to the player in some fashion. To maintain their challenge we reduced the max-level and randomized their levelling with the **Weighted Random** levelling _strategy_. \
For the second of these rules, specific to the 'boss' or 'mini-boss' mobs, we also provide them a minimized nametag; hiding their level. This is done to give these entities an air of mystic and to demonstrate their uniqueness compared to your standard levelled mob.

The fifth rule allows you to set entity-specific attribute modifiers which would override any previous established attribute modifier value. This rule is important for the fairness of the average server. For example, the movement speed of Endermen, Endermite, and Silverfish are set to produce zero change regardless of the level. This is done because these entities already have a uniquely high movement speed by vanilla standards and increasing this further makes these mobs near impossible to hit, let alone defend against.&#x20;



## Farm and Spawner Cube Limiters

{% code overflow="wrap" %}
```yaml
  - custom-rule: 'Player Farm Item and XP Limiter'
    is-enabled: true
    apply-settings:
      maximum-death-in-chunk-threshold: 12
      max-adjacent-chunks: 3
      chunk-max-cooldown-seconds: 300s
      disable-vanilla-drops-on-chunk-max: false
      disable-item-boost-on-chunk-max: true
      disable-xp-boost-on-chunk-max: true

  - custom-rule: 'Spawner Cube Entities'
    is-enabled: true
    use-preset: challenge-bronze
    conditions:
      spawn-reasons: [ 'SPAWNER' ]
    strategies:
      weighted-random: true
    settings:
      maxLevel: 10
      construct-level: '%weighted-random%'
      attribute-modifier:
        max-health: 0.0 #For Farms
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
