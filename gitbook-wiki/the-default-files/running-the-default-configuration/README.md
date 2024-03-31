---
layout:
  title:
    visible: true
  description:
    visible: false
  tableOfContents:
    visible: true
  outline:
    visible: true
  pagination:
    visible: true
---

# 🌟 Running the Default Configuration

## **The Default Rule and Presets**

<pre class="language-yaml" data-title="rules.yml" data-overflow="wrap"><code class="lang-yaml"><strong>#
</strong>#   ---------------  -  ------------------------------
#        Section 03  |  Set the Default Rule
#   ---------------  -  ------------------------------
#
default-rule:
  use-preset:
    #===== Choose a Challenge =====
    #- challenge-vanilla
    #- challenge-bronze
    - challenge-silver
    #- challenge-gold
    #- challenge-platinum
    #- challenge-formula
    
    #===== Choose Strategies =====
    #- lvlstrategy-random
    - lvlstrategy-weighted-random
    #- lvlstrategy-distance-from-origin
    - lvlstrategy-y-coordinate

    #===== Choose Modifiers =====
    - lvlmodifier-player-variable
    - lvlmodifier-random-variance

    #===== Choose Additional Options =====
    - nametag-using-numbers
    #- nametag-using-indicator
    #- nametag-no-level-displayed
    #- nametag-disabled
    #- custom-entity-names
    #- custom-death-messages
    #- external-plugins


#
#   ---------------  -  ------------------------------
#    Section 03 - A  |  Default Rule / Conditions
#   ---------------  -  ------------------------------
#
  conditions:
    worlds: ['*']
    #biomes: ['*']
    entities: ['*']

    mob-customname-status: EITHER
    mob-tamed-status: EITHER


#
#   ---------------  -  ------------------------------
#    Section 03 - B  |  Default Rule / Settings
#   ---------------  -  ------------------------------
#
  settings:
  # Core LevelledMobs Settings
    minLevel: 1
    maxLevel: 50

    construct-level: '(%weighted-random% / 2) + (%y-coordinate% / 5) + %player-variable-mod% + %random-variance-mod%'

  # CustomDrop Settings
    use-custom-item-drops-for-mobs: true

  # Additional Nametag Settings
    nametag-placeholder-levelled: ''
    nametag-placeholder-unlevelled: ''
    nametag-visible-time: 5s
    nametag-visibility-method: [ 'TARGETED', 'ATTACKED', 'TRACKING' ]

  # Adjusts the `%tiered%` placeholder
    tiered-coloring:
      1-09: '&#x26;#22E76B' #Green
      10-19: '&#x26;#528CFF' #Blue
      20-29: '&#x26;#FFCD56' #Yellow
      30-39: '&#x26;#F2003D' #Red
      40-49: '&#x26;#B447FF' #Purple
      50-50: '&#x26;#FFD700' #Gold
      default: '&#x26;#FFFFFF' #White

  # LevelledMobs Spawner Cube Settings
  # Use Command:  /lm spawner
    spawner-particles: 'SOUL'
    spawner-particles-count: 10

  # Level Inheritace Settings
    baby-mobs-inherit-adult-setting: true
    transforming-mobs-inherit-level: true
    riding-passengers-match-vehicle-level: false

  # Miscellaneous Settings
    multipliers:
      vanilla-bonus:
        excluded-list: ['LEADER_ZOMBIE_BONUS', 'RANDOM_SPAWN_BONUS']

    sunlight-intensity: 5
    creeper-max-damage-radius: 3
</code></pre>

The above set of code is copied from the `rules.yml` file for `v4.0.0 b1`.&#x20;



***

## The initial presets section

{% code overflow="wrap" %}
```yaml
  use-preset:
    #===== Choose a Challenge =====
    #- challenge-vanilla
    #- challenge-bronze
    - challenge-silver
    #- challenge-gold
    #- challenge-platinum
    #- challenge-formula
    
    #===== Choose Strategies =====
    #- lvlstrategy-random
    - lvlstrategy-weighted-random
    #- lvlstrategy-distance-from-origin
    - lvlstrategy-y-coordinate

    #===== Choose Modifiers =====
    - lvlmodifier-player-variable
    - lvlmodifier-random-variance

    #===== Choose Additional Options =====
    - nametag-using-numbers
    #- nametag-using-indicator
    #- nametag-no-level-displayed
    #- nametag-disabled
    #- custom-entity-names
    #- custom-death-messages
    #- external-plugins
```
{% endcode %}

Starting from the top section, we see a collection of various `use-preset:` options, most of which have been commented out. These make liberal use of the **Presets** section located in the area above the **Default Rule** to allow for quickly changing between a handful of both common and useful options; some being the same with different values, others offering optional features and a convenient way to apply them either in the **Default Rule** or **Custom Rules.**

In this instance, we have separated the various **Preset** types into four categories: _Challenges_, _Strategies_, _Modifiers_, and _Miscellaneous_.&#x20;

Under the _Challenges_ section, we have six degrees of play-tested challenge presets: _Vanilla_, _Bronze_, _Silver_ \[Default], _Gold_, _Platinum_, and _Formula_. These presets include the settings associated with altering the attributes of the entities, with _Vanilla_ representing zero change to the attributes; _Bronze_ containing modest increases; _Silver_, our default, being our middle ground between fun and challenge; _Gold_ often requires players to be fully armored and weaponized to take on, while _Platinum_ is made for the hardcore player or server which gives players non-vanilla abilities. _Formula_ is a new addition with LevelledMobs 4; creating a challenge on par with the _Gold_ challenge, but handled using our new custom formula mechanic, allowing you to use some degree of math to craft your own attribute changes.

The _Strategies_ section includes any enabled _Strategy_ which may be used to calculate the level of a mob. This section, in tandem with the _Modifiers_ section, produce internal-use placeholder tags associated with the relevant strategy. With LevelledMobs4, you can specify multiple running _strategies_ or _modifiers_ which can be combined together in multiple ways. We suggest using the `construct-level:` configuration setting (which is described here) to build your level exactly how you desire.

Beneath this section resides the _Miscellaneous_ options which include presets of optional features from the unique nametags, custom entity names, custom player-death messages, health indicator display, and more.



***

## The Construct-Level

New to LevelledMobs4, the Construct-Level setting allows you to take the output from various _Strategies_ or _Modifiers_ and incorporate basic math functions to produce a final level to apply. This feature allows you to have multiple strategies enabled at once, each providing their own numerical 'level' value, which can be put together how you choose. Using the default configuration (sampled below), we take the output from the enabled strategies **Weighted Random** and **Y-Coordinate** in the form of the placeholders of the same name, as well as the modifiers **Player Level** and **Random Variance** under their own placeholders, and using math combine the values to provide a unique levelling strategy.

If you do not specify the `construct-level:`, then the _strategies_ and _modifiers_ output will be combined together to produce the final applied level.&#x20;

{% code overflow="wrap" %}
```yaml
construct-level: '%distance-from-origin% + %weighted-random% + %player-variable-mod%' + %random-variance-mod%'
```
{% endcode %}



## The difference between attribute modification and level

There is an important distinction between levels, levelling, and the `minLevel` or `maxLevel` values; and the actual modification of the attributes of the mob.

When you establish the `minLevel` and `maxLevel`, you are telling LevelledMobs what the lowest and highest numerical level value can be for a mob. By default, under most instances, `minLevel` should probably remain at `1`, but there are valid reasons to have this value higher (perhaps you want mobs to all start out with an artificially higher starting increase to their attributes). As for `maxLevel`, that is far more subjective and dependent on how you want to stretch out the changes to the attributes for mobs. By default, we use `maxLevel: 50` which means that we stretch attribute changes from Level 1 to Level 50.&#x20;



## Attribute-Modifier

When you set an `attribute-modifier:` using the original LevelledMobs method (sampled below), then the plugin will use the value as the 'multiplier increase when at max level' and provide equal portions of that value to every level below maximum.

{% code overflow="wrap" %}
```yaml
    settings:
      attribute-modifier:
        max-health: 5.0
```
{% endcode %}

$$
f(x) = attribute + ((attribute * config) * (level / maxlevel))
$$



There are also several special multipliers, whose output must result in a value between `0.0` and `1.0` , due to the nature of how the attribute works in Minecraft. We use the following formula when using the original LevelledMobs method (sampled below) to apply the values these special attributes.

{% code overflow="wrap" %}
```yaml
      # Special Multipliers (0.0 Min - 1.0 Max)
        armor-bonus: 0.5
        armor-toughness: 0.5
        attack-knockback: 0.5
        knockback-resistance: 0.5
        zombie-spawn-reinforcements: 0.15
```
{% endcode %}

{% hint style="info" %}
&#x20;  Where `attribute.max` is populated by the following values:

```
armor-bonus: - 30.0
armor-toughness: - 20.0
attack_knockback: - 5.0
knockback_resistance: - 1.0
zombie-spawn-reinforcements: - 1.0
```
{% endhint %}

$$
f(x) = (level / maxlevel) * (attribute.max * config)
$$



However as part of LevelledMobs4, you can now use a basic mathematical formula to adjust the attribute (sampled below). Using this sample, we take the placeholder value of the same attribute, representing the base attribute value of the entity, and then add to this value the level times the their health multiplied by 0.25. The end result of this formula is that for each level, the health increases by 25% of the original entities' health value.

{% code overflow="wrap" %}
```yaml
    settings:
      attribute-modifier:
        max-health: '%max-health% + (%level% * (%max-health% * 0.25))'
```
{% endcode %}



***

##

## In the next section, we will explain how the Default Rule is applied as part of the default configuration.
