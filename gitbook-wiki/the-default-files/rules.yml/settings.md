# Settings

<details>

<summary>Click to view a comprehensive list of all <strong>Settings</strong></summary>

{% code overflow="wrap" %}
```yaml
settings:
# Core Levelling Setings
  minLevel: 1
  maxLevel: 50
  construct-level: '%weighted-random%'

# Nametag related Settings
  nametag: ' %tiered%Lvl %mob-lvl% &8&l༺ &f%displayname%&8 &8&l༻ &f%entity-health-rounded%&8/&f%entity-max-health-rounded% %tiered%%heart_symbol% '
  nametag-visible-time: 5s
  nametag-placeholder-unlevelled: ''
  nametag-placeholder-levelled: ''
  nametag-visibility-method: ['TARGETED', 'TRACKING', 'ATTACKED']
  creature-death-nametag: '%tiered%Lvl %mob-lvl%&8 | &f%displayname%'
  death-messages:
    1: ['%player% was killed by %death_nametag%!']

# Custom Name Settings
  entity-name-override:
    SKELETON: 'Jack Skellington'
    all_entities: 'Spawner %displayname%'

  entity-name-override:
    LVL-LVL:
      SKELETON: ['Verta Brae', 'Billy Bones']

# Nametag Health Indicator Settings
  health-indicator:
    indicator: '█'
    indicator-half: '▌'
    scale: 4
    max: 5
    colored-tiers:
      tier-1: '&#22E76B' #Green
      tier-2: '&#528CFF' #Blue
      tier-3: '&#FFCD56' #Yellow
      tier-4: '&#FE803C' #Orange
      tier-5: '&#F2003D' #Red
      tier-6: '&#B447FF' #Purple
      tier-X: '#COLOR' # Example Syntax
      default: '&#FFFFFF' #White
    merge: true

# CustomDrop Settings
  use-custom-item-drops-for-mobs: true
  use-droptable-id: ''

# Level Inheritace Settings
  baby-mobs-inherit-adult-setting: true
  transforming-mobs-inherit-level: true
  riding-passengers-match-vehicle-level: false

# Custom Mob Attribute Settings
  creeper-max-damage-radius: 3
  attribute-modifier:
#   Stacked Multipliers Method
    use-stacked: true
    max-health: ['5.0', 'STACKED']
#   Custom Formula Method
    max-health: '%max-health% + (%level% * %max-health% * 0.25)'
#   Default Multiplier Method
    max-health: 5.0
    movement-speed: 0.15
    attack-damage: 2.25
    ranged-attack-damage: 2.0
    creeper-blast-damage: 1.0
    follow-range: 0
    item-drop: 3
    xp-drop: 5
#   Special Multipliers (0.0 Min - 1.0 Max)
    armor-bonus: 0.25
    armor-toughness: 0.15
    attack-knockback: 0.25
    knockback-resistance: 0.2
    zombie-spawn-reinforcements: 0.25

  attribute-modifier:
    vanilla-bonus: ['']
 
  attribute-modifier:
    custom-attribute-modifier:
      EntityType:
        max-health: 5.0
        movement-speed: 0.15
        attack-damage: 2.25
        ranged-attack-damage: 2.0
        creeper-blast-damage: 1.0
        item-drop: 3
        xp-drop: 5

# Deaths in Chunks Settings
  maximum-death-in-chunk-threshold: 0
  max-adjacent-chunks: 3
  chunk-max-cooldown-seconds: 300
  disable-vanilla-drops-on-chunk-max: false
  disable-item-boost-on-chunk-max: true
  disable-xp-boost-on-chunk-max: true

# Miscellaneous Settings
  nbt-data: ''
  sunlight-intensity: 5

  tiered-coloring:
    1-5: '&#22E76B' #Green
    6-10: '&#528CFF' #Blue
    11-15: '&#FFCD56' #Yellow
    16-20: '&#F2003D' #Red
    21-25: '&#B447FF' #Purple
    X-Y: '#COLOR' # Example Syntax
    default: '&#FFFFFF' #White

  spawner-particles: 'SOUL'
  spawner-particles-count: 10

  lock-entity: false
```
{% endcode %}

</details>

***

<table data-full-width="true"><thead><tr><th width="319">Modular Option Settings</th><th>Description</th></tr></thead><tbody><tr><td><code>minLevel:</code><br><code>maxLevel:</code></td><td>Establishes the Minimum and maximum level used by the program when processing strategies, modifiers, or construct-level.</td></tr><tr><td><code>construct-level:</code></td><td>More details on this setting <a href="../running-the-default-configuration/#the-construct-level">are found here</a>.</td></tr><tr><td><code>nametag:</code></td><td>Populates the nametag field of the levelled mob.</td></tr><tr><td><code>nametag-visiblity-time:</code></td><td>Sets how long a nametag will remain visible if an action activated the nametag on a temporary setting (IE 'attacked'). </td></tr><tr><td><code>nametag-placeholder-unlevelled:</code><br><code>nametag-placeholder-levelled:</code></td><td>Populates what the nametag field would be for the specific placeholder tag associated with this setting (<code>%levelledmobs_mob-target%</code>), when a player is hovered over a levelled or unlevelled mob.</td></tr><tr><td><code>nametag-visibility-method:</code></td><td>Sets how the nametag can be made visible to the players.<br><br><code>TARGETED</code> - When an entity has targeted a player with Line of Sight.<br><code>ATTACKED</code> - When a Player attacks an entity.<br><code>TRACKING</code> - When an entity is actively tracking a targeted player (Follow Range).<br><code>ALWAYS_ON</code> - The Nametag remains visible, even through blocks.<br><code>MELEE</code> - The Nametag is only visible in melee range.<br><code>DISABLED</code> - The Nametag is disabled.</td></tr><tr><td><code>creature-death-nametag:</code></td><td>This represents the name used whenever a player is killed by a levelled mob.</td></tr><tr><td><code>death-messages:</code></td><td>This represents the beginning of the Death Messages tree, where you define the settings to alter the messages sent to players when they are killed an an entity. You would set the chance of the message being used by changing the number on the left, while including your altered message on the right.</td></tr><tr><td><code>entity-name-override:</code></td><td></td></tr><tr><td><code>health-indicator:</code> | <code>indicator:</code>, <code>indicator-half:</code>, <code>scale:</code>, <code>max:</code>, <code>colored-tiers:</code></td><td></td></tr><tr><td><code>use-custom-item-drops-for-mobs:</code></td><td></td></tr><tr><td><code>use-droptable-id:</code></td><td></td></tr><tr><td><code>baby-mobs-inherit-adult-setting:</code></td><td></td></tr><tr><td><code>transforming-mobs-inherit-level:</code></td><td></td></tr><tr><td><code>riding-passengers-match-vehicle-level:</code></td><td></td></tr><tr><td><code>creeper-max-damage-radius:</code></td><td></td></tr><tr><td><code>attribute-modifier:</code> | <code>use-stacked:</code>, <code>max-health</code>, <code>movement-speed:</code>, <code>attack-damage:</code>, <code>ranged-attack-damage:</code>, <code>creeper-blast-damage:</code>, <code>follow-range:</code>, <code>item-drop:</code>, <code>xp-drop:</code>, <code>armor-bonus:</code>, <code>armor-toughness:</code>, <code>attack-knockback:</code>, <code>knockback-resistance:</code>, <code>zombie-spawn-reinforcements:</code>, <code>vanilla-bonus:</code>, <code>custom-attribute-modifier:</code></td><td></td></tr><tr><td><code>maximum-death-in-chunk-threshold:</code>, <code>max-adjacent-chunks:</code>, <code>chunk-max-cooldown-seconds:</code>, <code>disable-vanilla-drops-on-chunk-max:</code>, <code>disable-item-boost-on-chunk-max:</code>. <code>disable-xp-boost-on-chunk-max:</code></td><td></td></tr><tr><td><code>nbt-data:</code></td><td></td></tr><tr><td><code>sunlight-intensity:</code></td><td></td></tr><tr><td><code>tiered-coloring:</code></td><td></td></tr><tr><td><code>spawner-particles:</code>, <code>spawner-particles-count:</code></td><td></td></tr><tr><td><code>lock-entity:</code></td><td></td></tr></tbody></table>

