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

<table data-full-width="true"><thead><tr><th width="319">Modular Option Settings</th><th>Description</th></tr></thead><tbody><tr><td></td><td></td></tr><tr><td></td><td></td></tr><tr><td></td><td></td></tr><tr><td></td><td></td></tr><tr><td></td><td></td></tr></tbody></table>
