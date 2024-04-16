# The Default / Default Rule

## Condition Checks

{% code overflow="wrap" %}
```yaml
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
```
{% endcode %}

As part of the **Default Rule**, you need to establish the core set of conditions under which LevelledMobs can function. This includes at minimum the _worlds_ and _entities_ which you want LevelledMobs to function. If no world is specified, then as a protective measure LevelledMobs will presume it does not have access to any world; The same will apply to entities.

We also offer options to help identify either pets via the `mob-tamed-status` condition, or whether a mob has a nametag or custom-name applied via the `mob-customname-status` condition.

## The Applied Settings

{% code overflow="wrap" %}
```yaml
#
#   ---------------  -  ------------------------------
#    Section 03 - B  |  Default Rule / Settings
#   ---------------  -  ------------------------------
#
  settings:
  # Core LevelledMobs Settings
    minLevel: 1
    maxLevel: 50

    construct-level: '%distance-from-origin% + %weighted-random% + %player-variable-mod% + %custom_special% + %rand_-5_5%'

  # CustomDrop Settings
    use-custom-item-drops-for-mobs: true

  # Additional Nametag Settings
    nametag-placeholder-levelled: ''
    nametag-placeholder-unlevelled: ''
    nametag-visible-time: 5s
    nametag-visibility-method: [ 'TARGETED', 'ATTACKED', 'TRACKING' ]

  # Adjusts the `%tiered%` and `%health-indicator-color%` placeholders
    tiered-coloring:
      1-09: '&#22E76B' #Green
      10-19: '&#528CFF' #Blue
      20-29: '&#FFCD56' #Yellow
      30-39: '&#F2003D' #Red
      40-49: '&#B447FF' #Purple
      50-50: '&#FFD700' #Gold
      default: '&#FFFFFF' #White
      
    health-indicator:
      colored-tiers:
        tier-1: '&#22E76B' #Green
        tier-2: '&#528CFF' #Blue
        tier-3: '&#FFCD56' #Yellow
        tier-4: '&#FE803C' #Orange
        tier-5: '&#F2003D' #Red
        tier-6: '&#B447FF' #Purple
        default: '&#B447FF' #White
      scale: 5
      max: 5

  # LevelledMobs Spawner Cube Settings
  # Use Command:  /lm spawner
    spawner-particles: 'SOUL'
    spawner-particles-count: 10

    baby-mobs-inherit-adult-setting: true
    transforming-mobs-inherit-level: true
    riding-passengers-match-vehicle-level: false

  # Miscellaneous Settings
    multipliers:
      vanilla-bonus:
        excluded-list: ['LEADER_ZOMBIE_BONUS', 'RANDOM_SPAWN_BONUS']

    sunlight-intensity: 5
    creeper-max-damage-radius: 3
```
{% endcode %}

Here is where you would apply the default settings for the mobs conditioned to receive a level earlier.&#x20;

You would also include any `attribute-modifiers` you wanted to apply under `settings:` as well, however we used the **Presets** section to include an appropriate _Challenge_ which includes these configuration options.

After establishing the level range, and the construct-level, we have a list of multiple optional settings to apply various changes to how LevelledMobs functions; from enabling the Custom Drops system, to managing the level inheritance of certain mobs, etc.&#x20;



***

From here we are going to make several modifications to the **Default Rule** by creating multiple **Custom Rules** based on a variety of conditions, and explain why we made these decisions os you can decide if the default configuration is right for you and how you might make the changes you desire to make it perfect.



## In the next section, we will explain each of the **Custom Rules** as part of the default configuration.
