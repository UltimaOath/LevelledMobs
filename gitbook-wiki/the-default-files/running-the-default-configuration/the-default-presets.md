# The Default / Presets

## Presets

<details>

<summary>Click to view the entire Presets section of the Rules file:</summary>

{% code overflow="wrap" fullWidth="true" %}
```yaml
#   ---------------  -  ------------------------------
#        Section 01  |  Presets
#   ---------------  -  ------------------------------
#
presets:
#
#   ---------------  -  ------------------------------
#    Section 01 - A  |  Presets / Levelling Strategies
#   ---------------  -  ------------------------------
#
  lvlstrategy-random:
    name: 'LVL Strategy - Random'
    strategies:
      random: true

  lvlstrategy-weighted-random:
    name: 'LVL Strategy - Weighted Random'
    strategies:
      weighted-random: true

  lvlstrategy-distance-from-origin:
    name: 'LVL Strategy - Distance-from-Origin'
    strategies:
      distance-from-origin:
        origin-coordinates:
          x: spawn
          z: spawn
        buffer-distance: 250
        ringed-tiers: 150
      # Y-Height Modifier
        enable-height-modifier: true
        transition-y-height: 62
        y-height-period: 10
        level-multiplier: 0.05
        scale-increase-downward: true

  lvlstrategy-y-coordinate:
    name: 'LVL Strategy - Y-Coordinate'
    strategies:
      y-coordinate:
        start-height: 100
        period: 0
        end-height: 20


#
#   ---------------  -  ------------------------------
#    Section 01 - B  |  Presets / Level Modifiers
#   ---------------  -  ------------------------------
#
  lvlmodifier-player-variable:
    name: 'LVL Modifier - Player Variable'
    modifiers:
      player-variable-mod:
        player-variable: '%level%'
        player-variable-scale: 1.0`
        player-variable-tiers:
          '32-45': 9-17
          '24-31': 7-14
          '16-23': 5-11
          '8-15': 3-8
          '0-7': 1-5
          default: 1
        match-variable: false
        use-variable-as-max: false
        recheck-players: true
        decrease-level: true
        level-cap: 50
        preserve-entity: 60s

  lvlmodifier-random-variance:
    name: 'LVL Modifier - Random Level Variance'
    modifiers:
      random-variance-mod: 0-3

#
#   ---------------  -  ------------------------------
#    Section 01 - C  |  Presets / Challenge Difficulties
#   ---------------  -  ------------------------------
#
  challenge-vanilla:
    name: 'Vanilla Stat Challenge'
    settings:
      attribute-modifier:
        merge: false
        max-health: 0.0
        attack-damage: 0.0
        ranged-attack-damage: 0.0
        item-drop: 0.0
        xp-drop: 0.0

  challenge-bronze:
    name: 'Bronze Challenge'
    settings:
      attribute-modifier:
        merge: false
        max-health: 2.5
        attack-damage: 1.0
        ranged-attack-damage: 1.0
        item-drop: 3.0
        xp-drop: 5.0

  challenge-silver:
    name: 'Silver Challenge'
    settings:
      attribute-modifier:
        merge: false
        max-health: 5.0
        movement-speed: 0.15
        attack-damage: 2.25
        ranged-attack-damage: 2.25
        creeper-blast-damage: 0.75
        item-drop: 3.0
        xp-drop: 5.0
      # Special Multipliers (0.0 Min - 1.0 Max)
        armor-bonus: 0.2
        armor-toughness: 0.15

  challenge-gold:
    name: 'Gold Challenge'
    settings:
      attribute-modifier:
        merge: false
        max-health: 8.0
        movement-speed: 0.35
        attack-damage: 3.5
        ranged-attack-damage: 2.75
        creeper-blast-damage: 1.75
        follow-range: 0.25
        item-drop: 3.0
        xp-drop: 5.0
      # Special Multipliers (0.0 Min - 1.0 Max)
        armor-bonus: 0.3
        armor-toughness: 0.3
        attack-knockback: 0.5
        knockback-resistance: 0.5

  challenge-platinum:
    name: 'Platinum Challenge'
    settings:
      attribute-modifier:
        merge: false
        max-health: 15.0
        movement-speed: 1.0
        attack-damage: 5.0
        ranged-attack-damage: 4.0
        creeper-blast-damage: 2.5
        follow-range: 0.5
        item-drop: 3.0
        xp-drop: 5.0
      # Special Multipliers (0.0 Min - 1.0 Max)
        armor-bonus: 0.5
        armor-toughness: 0.5
        attack-knockback: 0.5
        knockback-resistance: 0.5
        zombie-spawn-reinforcements: 0.15

  challenge-formula:
    name: 'Custom Formula Challenge'
    settings:
      attribute-modifier:
        merge: false
        max-health: '%max-health% + (%level% * (%max-health% * 0.25))'
        movement-speed: '%movement-speed% + (%level% * (%movement-speed% * 0.025))'
        attack-damage: '%attack-damage% + (%level-ratio% * (%attack-damage% * 2))'
        ranged-attack-damage: '%ranged-attack-damage% + (%level-ratio% * (%attack-damage% * 2))'
        creeper-blast-damage: '(%creeper-blast-damage% * 2.5) / %level-ratio%'
        follow-range: '%follow-range% + (1.75 * %level%)'
        item-drop: '(%item-drop% * 2.5) / %level-ratio%'
        xp-drop: '(%xp-drop% * 3.5) / %level-ratio%'
      # Special Multipliers (0.0 Min - 1.0 Max)
        armor-bonus: '(%level-ratio% * (15 - %armor-bonus%)) / (15 - %armor-bonus%)'
        armor-toughness: '(%level-ratio% * (7 - %armor-toughness%)) / (7 - %armor-toughness%)'
        attack-knockback: '(%level-ratio% * (2 - %attack-knockback%)) / (2 - %attack-knockback%)'
        knockback-resistance: '(%level-ratio% * (0.25 - %knockback-resistance%)) / (0.25 - %knockback-resistance%)'
        zombie-spawn-reinforcements: '(%level-ratio% * (0.25 - %zombie-spawn-reinforcements%)) / (0.25 - %zombie-spawn-reinforcements%)'


#
#   ---------------  -  ------------------------------
#    Section 01 - D  |  Presets / Names and Nametags
#   ---------------  -  ------------------------------
#
  nametag-using-numbers:
    name: 'Nametag - Health Displayed with Numbers'
    settings:
      nametag: ' %tiered%Lvl %mob-lvl% &8&l༺ &f%displayname%&8 &8&l༻ &f%entity-health-rounded%&8/&f%entity-max-health-rounded% %tiered%%heart_symbol% '
      creature-death-nametag: '%tiered%Lvl %mob-lvl%&8 | &f%displayname%'

  nametag-using-indicator:
    name: 'Nametag - Health Displayed with Indicators'
    settings:
      nametag: ' %tiered%Lvl %mob-lvl% &8&l༺ &f%displayname%&8 &8&l༻ &r%health-indicator% '
      creature-death-nametag: '%tiered%Lvl %mob-lvl%&8 | &f%displayname%'
      health-indicator:
        indicator: '█'
        indicator-half: '▌'
        colored-tiers:
          tier-1: '&#22E76B' #Green
          tier-2: '&#528CFF' #Blue
          tier-3: '&#FFCD56' #Yellow
          tier-4: '&#FE803C' #Orange
          tier-5: '&#F2003D' #Red
          tier-6: '&#B447FF' #Purple
          default: '&#FFFFFF' #White
        scale: 8
        max: 5
        merge: true

  nametag-no-level-displayed:
    name: 'Nametag - No Level Tag Displayed'
    settings:
      nametag: ' &f%displayname%&8 %tiered%%heart_symbol% &f%entity-health-rounded% '
      creature-death-nametag: '&f%displayname% %tiered%%heart_symbol%'

  nametag-disabled:
    name: 'Nametag - Disabled'
    settings:
      nametag: disabled
      nametag-visibility-method: [ 'DISABLED' ]
      creature-death-nametag: '&f%displayname% %tiered%%heart_symbol%'

  custom-entity-names:
    name: 'Custom Entity Names'
    conditions:
      mob-customname-status: NOT_NAMETAGGED
    settings:
      entity-name-override:
        BABY_: ['Baby %displayname%']
        WITCH: ['Arcana', 'Winifred']
        HUSK: ['Dessicated Corpse', 'Dusty']
        BLAZE: ['Diablo', 'Mephisto', 'Baal']
        SKELETON: ['Skully']
        ENDERMAN: ['Slenderman']
        ENDER_DRAGON: ['Smaug', 'Ancient Dragon']
        PILLAGER: ['Raider', 'Barbarian']
        SLIME: ['Gelatinous Cube']
        MAGMA_CUBE: ['Magmar']
        WITHER: ['Lich']
        VILLAGER: ['Mike', 'Carol', 'Alice', 'Marcia', 'Jan', 'Cindy', 'Greg', 'Peter', 'Bobby']

  custom-death-messages:
    name: 'Custom Death Messages'
    settings:
      death-messages:
        5: ['%player% was killed by a %death_nametag%!']
        4: ['A %death_nametag% wrecked %player%!']
        3: ['A %death_nametag% slaughtered %player%!']
        2: ['%player% never stood a chance against a %death_nametag%']
        1: ['%player% Died | Brought to you by %death_nametag%']

  external-plugins:
    name: 'External Plugin Mobs'
    conditions:
      external-plugins:
        included-list: ['eco-bosses', 'mythic-mobs', 'elite-mobs', 'infernal-mobs', 'citizens', 'shop-keepers', 'simple-pets', 'elite-bosses', 'blood-night']
        #excluded-list: ['*']
```
{% endcode %}



</details>

***

## Presets: Levelling Strategies

<details>

<summary>Click to view all default Levelling Strategy Presets:</summary>

```yaml
#
#   ---------------  -  ------------------------------
#    Section 01 - A  |  Presets / Levelling Strategies
#   ---------------  -  ------------------------------
#
  lvlstrategy-random:
    name: 'LVL Strategy - Random'
    strategies:
      random: true

  lvlstrategy-weighted-random:
    name: 'LVL Strategy - Weighted Random'
    strategies:
      weighted-random: true

  lvlstrategy-distance-from-origin:
    name: 'LVL Strategy - Distance-from-Origin'
    strategies:
      distance-from-origin:
        origin-coordinates:
          x: spawn
          z: spawn
        buffer-distance: 250
        ringed-tiers: 150
      # Y-Height Modifier
        enable-height-modifier: true
        transition-y-height: 62
        y-height-period: 10
        level-multiplier: 0.05
        scale-increase-downward: true

  lvlstrategy-y-coordinate:
    name: 'LVL Strategy - Y-Coordinate'
    strategies:
      y-coordinate:
        start-height: 100
        period: 0
        end-height: 20
```

</details>

<details>

<summary>Click to review the preset: <code>lvlstrategy-random</code></summary>

{% code overflow="wrap" fullWidth="false" %}
```yaml
  lvlstrategy-random:
    name: 'LVL Strategy - Random'
    strategies:
      random: true
```
{% endcode %}

This preset strategy will use a true random selection between the established min and max level value.

</details>

<details>

<summary>Click to review the preset: <code>lvlstrategy-weighted-random</code></summary>

{% code overflow="wrap" %}
```yaml
  lvlstrategy-weighted-random:
    name: 'LVL Strategy - Weighted Random'
    strategies:
      weighted-random: true
```
{% endcode %}

This preset in similar to the random preset, however it factors in the weight of each number. The higher the number, the less likely it is to be applied; and vice versa.&#x20;

</details>

<details>

<summary>Click to review the preset: <code>lvlstrategy-distance-from-origin</code></summary>

{% code overflow="wrap" %}
```yaml
  lvlstrategy-distance-from-origin:
    name: 'LVL Strategy - Distance-from-Origin'
    strategies:
      distance-from-origin:
        origin-coordinates:
          x: spawn
          z: spawn
        buffer-distance: 250
        ringed-tiers: 150
      # Y-Height Modifier
        enable-height-modifier: true
        transition-y-height: 62
        y-height-period: 10
        level-multiplier: 0.05
        scale-increase-downward: true
```
{% endcode %}

This preset uses the distance from an established center-point to calculate the level. We use the established Spawn coordinates used by the Minecraft server. There is also a height component associated with the distance, where the higher you are the lower the level will be compared to the depths where the levels increase compared to the distance from the center-point at the transition zone of sea level in game.

</details>

<details>

<summary>Click to review the preset: <code>lvlstrategy-y-coordinate</code></summary>

{% code overflow="wrap" %}
```yaml
  lvlstrategy-y-coordinate:
    name: 'LVL Strategy - Y-Coordinate'
    strategies:
      y-coordinate:
        start-height: 100
        period: 0
        end-height: 20
```
{% endcode %}

This preset establishes that the lowest levels will be at the highest heights, while the highest levels will be in the lowest depths of the world.&#x20;

</details>

To view all details regarding the various **Strategies**, follow the link below:

{% content-ref url="../rules.yml/strategies.md" %}
[strategies.md](../rules.yml/strategies.md)
{% endcontent-ref %}



***

## Presets: Level Modifiers

<details>

<summary>Click to view all default Level Modifier Presets:</summary>

{% code overflow="wrap" %}
```yaml
#
#   ---------------  -  ------------------------------
#    Section 01 - B  |  Presets / Level Modifiers
#   ---------------  -  ------------------------------
#
  lvlmodifier-player-variable:
    name: 'LVL Modifier - Player Variable'
    modifiers:
      player-variable-mod:
        player-variable: '%level%'
        player-variable-scale: 1.0`
        player-variable-tiers:
          '32-45': 9-17
          '24-31': 7-14
          '16-23': 5-11
          '8-15': 3-8
          '0-7': 1-5
          default: 1
        match-variable: false
        use-variable-as-max: false
        recheck-players: true
        decrease-level: true
        level-cap: 50
        preserve-entity: 60s

  lvlmodifier-random-variance:
    name: 'LVL Modifier - Random Level Variance'
    modifiers:
      random-variance-mod: 0-3
```
{% endcode %}

</details>

<details>

<summary>Click to review the preset: <code>lvlmodifier-player-variable</code></summary>

{% code overflow="wrap" fullWidth="false" %}
```yaml
  lvlmodifier-player-variable:
    name: 'LVL Modifier - Player Variable'
    modifiers:
      player-variable-mod:
        player-variable: '%level%'
        player-variable-scale: 1.0`
        player-variable-tiers:
          '32-45': 9-17
          '24-31': 7-14
          '16-23': 5-11
          '8-15': 3-8
          '0-7': 1-5
          default: 1
        match-variable: false
        use-variable-as-max: false
        recheck-players: true
        decrease-level: true
        level-cap: 50
        preserve-entity: 60s
```
{% endcode %}

This preset controls the **Player Level Modifier** settings. This system allows you to combine the **PlaceholderAPI** \[**PAPI**] placeholder tags with various settings to adjust the levels of mobs on a per-player basis.

</details>

<details>

<summary>Click to review the preset: <code>lvlmodifier-random-variance</code></summary>

{% code overflow="wrap" fullWidth="false" %}
```yaml
  lvlmodifier-random-variance:
    name: 'LVL Modifier - Random Level Variance'
    modifiers:
      random-variance-mod: 0-3
```
{% endcode %}

This preset is more or less a random number generator, where it will generate a number randomly between the two set values.

</details>

To view all details regarding the various **Level Modifiers**, follow the link below:

{% content-ref url="../rules.yml/modifiers.md" %}
[modifiers.md](../rules.yml/modifiers.md)
{% endcontent-ref %}



***

## Presets: Challenge Difficulties

<details>

<summary>Click to view all default <strong>Challenge Difficulty Presets</strong>:</summary>

{% code overflow="wrap" %}
```yaml
#
#   ---------------  -  ------------------------------
#    Section 01 - C  |  Presets / Challenge Difficulties
#   ---------------  -  ------------------------------
#
  challenge-vanilla:
    name: 'Vanilla Stat Challenge'
    settings:
      attribute-modifier:
        merge: false
        max-health: 0.0
        attack-damage: 0.0
        ranged-attack-damage: 0.0
        item-drop: 0.0
        xp-drop: 0.0

  challenge-bronze:
    name: 'Bronze Challenge'
    settings:
      attribute-modifier:
        merge: false
        max-health: 2.5
        attack-damage: 1.0
        ranged-attack-damage: 1.0
        item-drop: 3.0
        xp-drop: 5.0

  challenge-silver:
    name: 'Silver Challenge'
    settings:
      attribute-modifier:
        merge: false
        max-health: 5.0
        movement-speed: 0.15
        attack-damage: 2.25
        ranged-attack-damage: 2.25
        creeper-blast-damage: 0.75
        item-drop: 3.0
        xp-drop: 5.0
      # Special Multipliers (0.0 Min - 1.0 Max)
        armor-bonus: 0.2
        armor-toughness: 0.15

  challenge-gold:
    name: 'Gold Challenge'
    settings:
      attribute-modifier:
        merge: false
        max-health: 8.0
        movement-speed: 0.35
        attack-damage: 3.5
        ranged-attack-damage: 2.75
        creeper-blast-damage: 1.75
        follow-range: 0.25
        item-drop: 3.0
        xp-drop: 5.0
      # Special Multipliers (0.0 Min - 1.0 Max)
        armor-bonus: 0.3
        armor-toughness: 0.3
        attack-knockback: 0.5
        knockback-resistance: 0.5

  challenge-platinum:
    name: 'Platinum Challenge'
    settings:
      attribute-modifier:
        merge: false
        max-health: 15.0
        movement-speed: 1.0
        attack-damage: 5.0
        ranged-attack-damage: 4.0
        creeper-blast-damage: 2.5
        follow-range: 0.5
        item-drop: 3.0
        xp-drop: 5.0
      # Special Multipliers (0.0 Min - 1.0 Max)
        armor-bonus: 0.5
        armor-toughness: 0.5
        attack-knockback: 0.5
        knockback-resistance: 0.5
        zombie-spawn-reinforcements: 0.15

  challenge-formula:
    name: 'Custom Formula Challenge'
    settings:
      attribute-modifier:
        merge: false
        max-health: '%max-health% + (%level% * (%max-health% * 0.25))'
        movement-speed: '%movement-speed% + (%level% * (%movement-speed% * 0.025))'
        attack-damage: '%attack-damage% + (%level-ratio% * (%attack-damage% * 2))'
        ranged-attack-damage: '%ranged-attack-damage% + (%level-ratio% * (%attack-damage% * 2))'
        creeper-blast-damage: '(%creeper-blast-damage% * 2.5) / %level-ratio%'
        follow-range: '%follow-range% + (1.75 * %level%)'
        item-drop: '(%item-drop% * 2.5) / %level-ratio%'
        xp-drop: '(%xp-drop% * 3.5) / %level-ratio%'
      # Special Multipliers (0.0 Min - 1.0 Max)
        armor-bonus: '(%level-ratio% * (15 - %armor-bonus%)) / (15 - %armor-bonus%)'
        armor-toughness: '(%level-ratio% * (7 - %armor-toughness%)) / (7 - %armor-toughness%)'
        attack-knockback: '(%level-ratio% * (2 - %attack-knockback%)) / (2 - %attack-knockback%)'
        knockback-resistance: '(%level-ratio% * (0.25 - %knockback-resistance%)) / (0.25 - %knockback-resistance%)'
        zombie-spawn-reinforcements: '(%level-ratio% * (0.25 - %zombie-spawn-reinforcements%)) / (0.25 - %zombie-spawn-reinforcements%)'
```
{% endcode %}

</details>

<details>

<summary>Click to review the preset: <code>challenge-vanilla</code></summary>

{% code overflow="wrap" fullWidth="false" %}
```yaml
  challenge-vanilla:
    name: 'Vanilla Stat Challenge'
    settings:
      attribute-modifier:
        merge: false
        max-health: 0.0
        attack-damage: 0.0
        ranged-attack-damage: 0.0
        item-drop: 0.0
        xp-drop: 0.0
```
{% endcode %}

This **Bronze Challenge Difficulty Preset** uses the original default attribute processing methodology; [click here for the math](./#attribute-modifier); though since all values are set to `0.0`, there is no effect.

This challenge is designed to provide no additional challenge at all. This simply provides a hooking method for mobs so that you can continue to provide them nametags or other customized drops since they are considered a 'levelled mob' even though the stat changes are all set to zero.

</details>

<details>

<summary>Click to review the preset: <code>challenge-bronze</code></summary>

{% code overflow="wrap" fullWidth="false" %}
```yaml
  challenge-bronze:
    name: 'Bronze Challenge'
    settings:
      attribute-modifier:
        merge: false
        max-health: 2.5
        attack-damage: 1.0
        ranged-attack-damage: 1.0
        item-drop: 3.0
        xp-drop: 5.0
```
{% endcode %}

This **Bronze Challenge Difficulty Preset** uses the original default attribute processing methodology; [click here for the math](./#attribute-modifier).

This challenge is designed to provide a very modest boost to mob attributes. Typically a player with any experience with Minecraft's hostile mobs will experience an effective skill challenge.

</details>

<details>

<summary>Click to review the preset: <code>challenge-silver</code></summary>

{% code overflow="wrap" fullWidth="false" %}
```yaml
  challenge-silver:
    name: 'Silver Challenge'
    settings:
      attribute-modifier:
        merge: false
        max-health: 5.0
        movement-speed: 0.15
        attack-damage: 2.25
        ranged-attack-damage: 2.25
        creeper-blast-damage: 0.75
        item-drop: 3.0
        xp-drop: 5.0
      # Special Multipliers (0.0 Min - 1.0 Max)
        armor-bonus: 0.2
        armor-toughness: 0.15
```
{% endcode %}

This **Silver Challenge Difficulty Preset** uses the original default attribute processing methodology; [click here for the math](./#attribute-modifier).

This challenge is the default challenge level used, and was designed for a Normal Minecraft difficulty to feel a bit harder than Hard Minecraft difficult. Typically a skilled player can manage the highest level mobs with average equipment and tools.

</details>

<details>

<summary>Click to review the preset: <code>challenge-gold</code></summary>

{% code overflow="wrap" fullWidth="false" %}
```yaml
  challenge-gold:
    name: 'Gold Challenge'
    settings:
      attribute-modifier:
        merge: false
        max-health: 8.0
        movement-speed: 0.35
        attack-damage: 3.5
        ranged-attack-damage: 2.75
        creeper-blast-damage: 1.75
        follow-range: 0.25
        item-drop: 3.0
        xp-drop: 5.0
      # Special Multipliers (0.0 Min - 1.0 Max)
        armor-bonus: 0.3
        armor-toughness: 0.3
        attack-knockback: 0.5
        knockback-resistance: 0.5
```
{% endcode %}

This **Gold Challenge Difficulty Preset** uses the original default attribute processing methodology; [click here for the math](./#attribute-modifier).

This challenge is designed to be above-average difficult. Typically a fully armored and weaponized player with enchantments could manage the higher level mobs.

</details>

<details>

<summary>Click to review the preset: <code>challenge-platinum</code></summary>

{% code overflow="wrap" fullWidth="false" %}
```yaml
  challenge-platinum:
    name: 'Platinum Challenge'
    settings:
      attribute-modifier:
        merge: false
        max-health: 15.0
        movement-speed: 1.0
        attack-damage: 5.0
        ranged-attack-damage: 4.0
        creeper-blast-damage: 2.5
        follow-range: 0.5
        item-drop: 3.0
        xp-drop: 5.0
      # Special Multipliers (0.0 Min - 1.0 Max)
        armor-bonus: 0.5
        armor-toughness: 0.5
        attack-knockback: 0.5
        knockback-resistance: 0.5
        zombie-spawn-reinforcements: 0.15
```
{% endcode %}

This **Platinum Challenge Difficulty Preset** uses the original default attribute processing methodology; [click here for the math](./#attribute-modifier).

This challenge is designed to be beyond hardcore. Typically a vanilla server will be unreasonably difficulty, so we recommend giving your players extra abilities or attributes to help survive through other plugins such as [AuraSkills](https://www.spigotmc.org/resources/auraskills-formerly-aurelium-skills.81069/) \[Free] or [McMMO](https://www.spigotmc.org/resources/official-mcmmo-original-author-returns.64348/) \[Paid].

</details>

<details>

<summary>Click to review the preset: <code>challenge-formula</code></summary>

{% code overflow="wrap" fullWidth="false" %}
```yaml
  challenge-formula:
    name: 'Custom Formula Challenge'
    settings:
      attribute-modifier:
        merge: false
        max-health: '%max-health% + (%level% * (%max-health% * 0.25))'
        movement-speed: '%movement-speed% + (%level% * (%movement-speed% * 0.025))'
        attack-damage: '%attack-damage% + (%level-ratio% * (%attack-damage% * 2))'
        ranged-attack-damage: '%ranged-attack-damage% + (%level-ratio% * (%attack-damage% * 2))'
        creeper-blast-damage: '(%creeper-blast-damage% * 2.5) / %level-ratio%'
        follow-range: '%follow-range% + (1.75 * %level%)'
        item-drop: '(%item-drop% * 2.5) / %level-ratio%'
        xp-drop: '(%xp-drop% * 3.5) / %level-ratio%'
      # Special Multipliers (0.0 Min - 1.0 Max)
        armor-bonus: '(%level-ratio% * (15 - %armor-bonus%)) / (15 - %armor-bonus%)'
        armor-toughness: '(%level-ratio% * (7 - %armor-toughness%)) / (7 - %armor-toughness%)'
        attack-knockback: '(%level-ratio% * (2 - %attack-knockback%)) / (2 - %attack-knockback%)'
        knockback-resistance: '(%level-ratio% * (0.25 - %knockback-resistance%)) / (0.25 - %knockback-resistance%)'
        zombie-spawn-reinforcements: '(%level-ratio% * (0.25 - %zombie-spawn-reinforcements%)) / (0.25 - %zombie-spawn-reinforcements%)'
```
{% endcode %}

This **Formula Challenge Difficulty Preset** allows you to use basic math functions combined with various internal-use placeholders to alter each attribute in a unique way.

The default formula provided offer a difficulty between _Silver_ and _Gold_ in play style.

This is an **ADVANCED FEATURE** and we will not provide support with regards to coming up with the mathematics for your specific server situation.

</details>



***

## Presets: Additional Options

<details>

<summary>Click to view all default <strong>Additional Presets</strong>:</summary>

{% code overflow="wrap" %}
```yaml
#
#   ---------------  -  ------------------------------
#    Section 01 - D  |  Presets / Additional Options
#   ---------------  -  ------------------------------
#
  nametag-using-numbers:
    name: 'Nametag - Health Displayed with Numbers'
    settings:
      nametag: ' %tiered%Lvl %mob-lvl% &8&l༺ &f%displayname%&8 &8&l༻ &f%entity-health-rounded%&8/&f%entity-max-health-rounded% %tiered%%heart_symbol% '
      creature-death-nametag: '%tiered%Lvl %mob-lvl%&8 | &f%displayname%'

  nametag-using-indicator:
    name: 'Nametag - Health Displayed with Indicators'
    settings:
      nametag: ' %tiered%Lvl %mob-lvl% &8&l༺ &f%displayname%&8 &8&l༻ &r%health-indicator% '
      creature-death-nametag: '%tiered%Lvl %mob-lvl%&8 | &f%displayname%'
      health-indicator:
        indicator: '█'
        indicator-half: '▌'
        colored-tiers:
          tier-1: '&#22E76B' #Green
          tier-2: '&#528CFF' #Blue
          tier-3: '&#FFCD56' #Yellow
          tier-4: '&#FE803C' #Orange
          tier-5: '&#F2003D' #Red
          tier-6: '&#B447FF' #Purple
          default: '&#FFFFFF' #White
        scale: 8
        max: 5
        merge: true

  nametag-no-level-displayed:
    name: 'Nametag - No Level Tag Displayed'
    settings:
      nametag: ' &f%displayname%&8 %tiered%%heart_symbol% &f%entity-health-rounded% '
      creature-death-nametag: '&f%displayname% %tiered%%heart_symbol%'

  nametag-disabled:
    name: 'Nametag - Disabled'
    settings:
      nametag: disabled
      nametag-visibility-method: [ 'DISABLED' ]
      creature-death-nametag: '&f%displayname% %tiered%%heart_symbol%'

  custom-entity-names:
    name: 'Custom Entity Names'
    conditions:
      mob-customname-status: NOT_NAMETAGGED
    settings:
      entity-name-override:
        BABY_: ['Baby %displayname%']
        WITCH: ['Arcana', 'Winifred']
        HUSK: ['Dessicated Corpse', 'Dusty']
        BLAZE: ['Diablo', 'Mephisto', 'Baal']
        SKELETON: ['Skully']
        ENDERMAN: ['Slenderman']
        ENDER_DRAGON: ['Smaug', 'Ancient Dragon']
        PILLAGER: ['Raider', 'Barbarian']
        SLIME: ['Gelatinous Cube']
        MAGMA_CUBE: ['Magmar']
        WITHER: ['Lich']
        VILLAGER: ['Mike', 'Carol', 'Alice', 'Marcia', 'Jan', 'Cindy', 'Greg', 'Peter', 'Bobby']

  custom-death-messages:
    name: 'Custom Death Messages'
    settings:
      death-messages:
        5: ['%player% was killed by a %death_nametag%!']
        4: ['A %death_nametag% wrecked %player%!']
        3: ['A %death_nametag% slaughtered %player%!']
        2: ['%player% never stood a chance against a %death_nametag%']
        1: ['%player% Died | Brought to you by %death_nametag%']

  external-plugins:
    name: 'External Plugin Mobs'
    conditions:
      external-plugins:
        included-list: ['eco-bosses', 'mythic-mobs', 'elite-mobs', 'infernal-mobs', 'citizens', 'shop-keepers', 'simple-pets', 'elite-bosses', 'blood-night']
        #excluded-list: ['*']
```
{% endcode %}

</details>

<details>

<summary>Click to review the preset: <code>nametag-using-numbers</code></summary>

{% code overflow="wrap" fullWidth="false" %}
```yaml
  nametag-using-numbers:
    name: 'Nametag - Health Displayed with Numbers'
    settings:
      nametag: ' %tiered%Lvl %mob-lvl% &8&l༺ &f%displayname%&8 &8&l༻ &f%entity-health-rounded%&8/&f%entity-max-health-rounded% %tiered%%heart_symbol% '
      creature-death-nametag: '%tiered%Lvl %mob-lvl%&8 | &f%displayname%'
```
{% endcode %}

This preset is the default **Nametag** arrangement, where it includes the mobs level, name, health remaining, and max health.

</details>

<details>

<summary>Click to review the preset: <code>nametag-using-indicator</code></summary>

{% code overflow="wrap" fullWidth="false" %}
```yaml
  nametag-using-indicator:
    name: 'Nametag - Health Displayed with Indicators'
    settings:
      nametag: ' %tiered%Lvl %mob-lvl% &8&l༺ &f%displayname%&8 &8&l༻ &r%health-indicator% '
      creature-death-nametag: '%tiered%Lvl %mob-lvl%&8 | &f%displayname%'
      health-indicator:
        indicator: '█'
        indicator-half: '▌'
        colored-tiers:
          tier-1: '&#22E76B' #Green
          tier-2: '&#528CFF' #Blue
          tier-3: '&#FFCD56' #Yellow
          tier-4: '&#FE803C' #Orange
          tier-5: '&#F2003D' #Red
          tier-6: '&#B447FF' #Purple
          default: '&#FFFFFF' #White
        scale: 8
        max: 5
        merge: true
```
{% endcode %}

This preset uses a custom **Nametag** feature which allows the inclusion of _visual health indicators_ to represent the health remaining of the mob.

</details>

<details>

<summary>Click to review the preset: <code>nametag-no-level-displayed</code></summary>

{% code overflow="wrap" fullWidth="false" %}
```yaml
  nametag-no-level-displayed:
    name: 'Nametag - No Level Tag Displayed'
    settings:
      nametag: ' &f%displayname%&8 %tiered%%heart_symbol% &f%entity-health-rounded% '
      creature-death-nametag: '&f%displayname% %tiered%%heart_symbol%'
```
{% endcode %}

This preset changes the **Nametag** of a mob to a minimized version which only includes the name of the mob and it's remaining health.

</details>

<details>

<summary>Click to review the preset: <code>nametag-disabled</code></summary>

{% code overflow="wrap" fullWidth="false" %}
```yaml
  nametag-disabled:
    name: 'Nametag - Disabled'
    settings:
      nametag: disabled
      nametag-visibility-method: [ 'DISABLED' ]
      creature-death-nametag: '&f%displayname% %tiered%%heart_symbol%'
```
{% endcode %}

This preset entirely disables the **Nametag** system as part of the levelling of a mob. This is useful if you do not want the nametag feature to apply to specific mobs, but you still wish for LevelledMobs to process and/or level those entities.

</details>

<details>

<summary>Click to review the preset: <code>custom-entity-names</code></summary>

{% code overflow="wrap" fullWidth="false" %}
```yaml
  custom-entity-names:
    name: 'Custom Entity Names'
    conditions:
      mob-customname-status: NOT_NAMETAGGED
    settings:
      entity-name-override:
        BABY_: ['Baby %displayname%']
        WITCH: ['Arcana', 'Winifred']
        HUSK: ['Dessicated Corpse', 'Dusty']
        BLAZE: ['Diablo', 'Mephisto', 'Baal']
        SKELETON: ['Skully']
        ENDERMAN: ['Slenderman']
        ENDER_DRAGON: ['Smaug', 'Ancient Dragon']
        PILLAGER: ['Raider', 'Barbarian']
        SLIME: ['Gelatinous Cube']
        MAGMA_CUBE: ['Magmar']
        WITHER: ['Lich']
        VILLAGER: ['Mike', 'Carol', 'Alice', 'Marcia', 'Jan', 'Cindy', 'Greg', 'Peter', 'Bobby']
```
{% endcode %}

This preset established a collection of randomly selected names for a variety of mobs to provide a unique selection of names to provide a spread of mob options.&#x20;

This preset is designed to work on entities which do not have a nametag applied, as to not interfere with player pet names or other plugins using the custom-name field.

Thanks to our donors for submitting entries for the new default names!

</details>

<details>

<summary>Click to review the preset: <code>custom-death-messages</code></summary>

{% code overflow="wrap" fullWidth="false" %}
```yaml
  custom-death-messages:
    name: 'Custom Death Messages'
    settings:
      death-messages:
        5: ['%player% was killed by a %death_nametag%!']
        4: ['A %death_nametag% wrecked %player%!']
        3: ['A %death_nametag% slaughtered %player%!']
        2: ['%player% never stood a chance against a %death_nametag%']
        1: ['%player% Died | Brought to you by %death_nametag%']
```
{% endcode %}

This preset establishes a weighted randomly selected set of customized messages sent to the player on their death from a levelled mob.

</details>

<details>

<summary>Click to review the preset: <code>external-plugins</code></summary>

{% code overflow="wrap" fullWidth="false" %}
```yaml
  external-plugins:
    name: 'External Plugin Mobs'
    conditions:
      external-plugins:
        included-list: ['eco-bosses', 'mythic-mobs', 'elite-mobs', 'infernal-mobs', 'citizens', 'shop-keepers', 'simple-pets', 'elite-bosses', 'blood-night']
        #excluded-list: ['*']
```
{% endcode %}

This preset connects to both internally supported plugins, as well as a few externally supported plugins from the `externalplugins.yml` file.

</details>



To view all details regarding the various **Challenge** types, or any **Nametag** or additional options, follow the link below:

{% content-ref url="../rules.yml/settings.md" %}
[settings.md](../rules.yml/settings.md)
{% endcontent-ref %}

