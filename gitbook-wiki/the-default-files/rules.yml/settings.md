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

<table data-full-width="true"><thead><tr><th width="319">Modular Option Settings</th><th>Description</th></tr></thead><tbody><tr><td><code>minLevel:</code><br><code>maxLevel:</code></td><td>Establishes the Minimum and maximum level used by the program when processing strategies, modifiers, or construct-level.</td></tr><tr><td><code>construct-level:</code></td><td>More details on this setting <a href="../running-the-default-configuration/#the-construct-level">are found here</a>.</td></tr><tr><td><code>nametag:</code></td><td>Populates the nametag field of the levelled mob.</td></tr><tr><td><code>nametag-visiblity-time:</code></td><td>Sets how long a nametag will remain visible if an action activated the nametag on a temporary setting (IE 'attacked'). </td></tr><tr><td><code>nametag-placeholder-unlevelled:</code><br><code>nametag-placeholder-levelled:</code></td><td>Populates what the nametag field would be for the specific placeholder tag associated with this setting (<code>%levelledmobs_mob-target%</code>), when a player is hovered over a levelled or unlevelled mob.</td></tr><tr><td><code>nametag-visibility-method:</code></td><td>Sets how the nametag can be made visible to the players.<br><br><code>TARGETED</code> - When an entity has targeted a player with Line of Sight.<br><code>ATTACKED</code> - When a Player attacks an entity.<br><code>TRACKING</code> - When an entity is actively tracking a targeted player (Follow Range).<br><code>ALWAYS_ON</code> - The Nametag remains visible, even through blocks.<br><code>MELEE</code> - The Nametag is only visible in melee range.<br><code>DISABLED</code> - The Nametag is disabled.</td></tr><tr><td><code>creature-death-nametag:</code></td><td>This represents the name used whenever a player is killed by a levelled mob.</td></tr><tr><td><code>death-messages:</code></td><td>This represents the beginning of the Death Messages tree, where you define the settings to alter the messages sent to players when they are killed an an entity. You would set the chance of the message being used by changing the number on the left, while including your altered message on the right.</td></tr><tr><td><code>entity-name-override:</code> | <code>LVL-LVL:</code>, <code>EntityType:</code>, <code>all_entities:</code></td><td>This allows you to create false names for entities; this does not override any custom-name fields.<br>This config option has multiple methods to implement it. You can use the single line item method, such as <code>SKELETON: 'Jack'</code>; multiple randomly selected options, such as <code>SKELETON: ['Jack', 'Sally', 'Sandy Claws']</code>; or checking levels of the mob prior to application.</td></tr><tr><td><code>health-indicator:</code> | <code>indicator:</code>, <code>indicator-half:</code>, <code>scale:</code>, <code>max:</code>, <code>colored-tiers:</code></td><td>These represent the Health Indicator visual aid system. Each setting maintains a different aspect of the feature: the <code>indicator</code> and <code>indicator-half</code> are the character representations of each of the 'health bars' of the entity. The indicator half is only used on the final bar. The <code>max</code> represents the number of <code>indicator</code> present per-bar of health, while <code>scale</code> represents how much health each <code>indicator</code> represents. Finally, <code>colored-tiers</code> allows for establishing different colors for each bar of health generated from the indicator, in ascending tiers of colors for higher health.</td></tr><tr><td><code>use-custom-item-drops-for-mobs:</code></td><td>When set to <code>true</code>, the mobs will use any applicable Custom Drops associated with it.</td></tr><tr><td><code>use-droptable-id:</code></td><td>This will apply a drop table identified in Custom Drops to a mob.</td></tr><tr><td><code>baby-mobs-inherit-adult-setting:</code></td><td>When set to <code>true</code>, both adult and baby variants of the mobs of the same EntityType will be considered the same. When <code>false</code>, adult and baby variants could be considered separate entities.<br>For example: <code>ZOMBIE</code> and <code>BABY_ZOMBIE</code></td></tr><tr><td><code>transforming-mobs-inherit-level:</code></td><td>When set to <code>true</code>, any entity which undergoes a transformation event will keep it's previous applied setting.<br>When set to <code>false</code>, the newly transformed entity will attempt to relevel itself under it's new status.<br>An example of a transformation event would be when a larger slime breaks into smaller slimes, or when a Villager transforms into a Zombie Villager and back again.</td></tr><tr><td><code>riding-passengers-match-vehicle-level:</code></td><td>When set to <code>true</code>, any entity which spawns as a <code>Passenger</code> combination will share the same level as generated by the lowest entity in the stack (the one moving the Passenger(s) around). Whatever level that lowest entity would have generated, the passengers will match that level. When set to <code>false</code>, each entity will generate it's own level based upon it's own levelling strategy.</td></tr><tr><td><code>creeper-max-damage-radius:</code></td><td>This represents the radius of a Creeper explosion.<br>Minecraft's vanilla value is <code>3</code>, a stronger middle ground would be <code>5</code>; anything higher than <code>10</code> is basically a nuke and is not recommended.</td></tr><tr><td><code>attribute-modifier:</code> | <code>use-stacked:</code>, <code>max-health</code>, <code>movement-speed:</code>, <code>attack-damage:</code>, <code>ranged-attack-damage:</code>, <code>creeper-blast-damage:</code>, <code>follow-range:</code>, <code>item-drop:</code>, <code>xp-drop:</code>, <code>armor-bonus:</code>, <code>armor-toughness:</code>, <code>attack-knockback:</code>, <code>knockback-resistance:</code>, <code>zombie-spawn-reinforcements:</code>, <code>vanilla-bonus:</code>, <code>custom-attribute-modifier:</code></td><td>This represents the beginning of the Attribute Modifiers system tree, where you can adjust the change in entity attributes based on their maximum level or any various formula.<br>The specified details for each attribute are detailed below.<br>For <code>xp-drop</code> or <code>item-drop</code>, having a value of <code>-1</code> will disable the dropping of the vanilla XP or Items respectively.</td></tr><tr><td><code>maximum-death-in-chunk-threshold:</code>, <code>max-adjacent-chunks:</code>, <code>chunk-max-cooldown-seconds:</code>, <code>disable-vanilla-drops-on-chunk-max:</code>, <code>disable-item-boost-on-chunk-max:</code>. <code>disable-xp-boost-on-chunk-max:</code></td><td>This represents the Deaths in Chunks system settings. These settings allow you to limit or shut off entirely the Custom Drops or Item/Experience Attribute Modifiers for any levelled mob which spawns within a specified area of chunks around a high-density death-zone. This is useful for player farm management, as well as limiting players from abusing the gain in item or experience drops.<br>The specified details for this system are detailed below.</td></tr><tr><td><code>nbt-data:</code></td><td>This config option requires the soft-dependency <a href="https://www.spigotmc.org/resources/nbt-api.7939/"><strong>NBT-API</strong></a> to function. This allows you to apply NBT tags to entities which have spawned. This <em>adds</em> the NBT tag to whatever list of NBT tags the mob already has (nothing is reset/overridden).<br>A useful toolset for crafting even more unique styles of entities.</td></tr><tr><td><code>sunlight-intensity:</code></td><td>This represents an additional damage amount applied to entities which burn in the sunlight. This is a useful tool to help kill off higher level entities whose health can exceed the damage of the sun.</td></tr><tr><td><code>tiered-coloring:</code> | <code>LVL-LVL:</code>, <code>default:</code></td><td>This represents the beginning of the Tiered Coloring system tree, where you define the settings necessary to utilize the <code>%tiered%</code> tag which can be used within the <code>nametag:</code> config option. To apply a color based on the current level of an entity.<br>You would establish a level range at <code>LVL-LVL:</code> and then either a Hex or Minecraft Color Code prefixed with an <code>&#x26;</code> in place of the <code>color</code>.<br>You can establish a <code>default:</code> color which would apply to any entity which has spawned or was summoned in a level range which is not already specified.</td></tr><tr><td><code>spawner-particles:</code>, <code>spawner-particles-count:</code></td><td>This applies only to LM Spawners, it is the particle effect and count used when a mob is spawned. Can be any value from the <a href="https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Particle.html">Minecraft Particle Javadocs</a>.</td></tr><tr><td><code>lock-entity:</code></td><td>When set to <code>true</code>, nametags and Custom Drop rules will be locked to the mob so it won't change even if a different rule would have applied changes to the mob later.</td></tr></tbody></table>



## Attribute Modifiers

The **Attribute Modifiers** of LevelledMobs are how the attributes themselves are edited. We provide three distinct methods to achieve this: _default_, _stacked_, and _custom_.&#x20;

The **Default** method is how LevelledMobs has always applied multipliers. Below represents the formula being used; the first being standard, the second being 'special':

$$
newAttr = origAttr + (( origAttr * configValue ) * ( mobLevel / maxLevel ))
$$

$$
newAttr = (mobLevel / maxLevel) * (attrMax * configValue)
$$

\* 'Special' refers to Special Attribute Modifiers which have a maximum in-game value compared to the others which do not.

***

The values of the formula above are:

{% code overflow="wrap" %}
```
newAttr     - The final applied attribute value.
origAttr    - The original attribute value assigned to mob.
configValue - The value taken from the Rules configuration.
mobLevel    - The current applied level of the mob.
maxLevel    - The maximum level the mob could receive as assigned from the Rules.
attrMax     - The maximum value of the attribute (Special Attributes only).
```
{% endcode %}

For Special Attributes, the `attrMax` or 'Attribute Maximum' represents the maximum value of this Minecraft attribute. These special modifiers are unique in that they have a specified cap value compared to the other non special modifiers which in theory have no cap. That means that these are setup to be a 'percent of max' setup. The values of this are as follows:

```
armor-bonus                 - 30.0
armor-toughness             - 20.0
attack-knockback            - 5.0
knockback-resistance        - 1.0
zombie-spawn-reinforcements - 1.0
```

An example of the syntax used to implement this method is as follows:

```yaml
max-health: 5.0
#OR
armor-bonus: 0.5
```

For the first line, the sample says that 'when at max level, give the entity a 5x or 500% increase in the max-health attribute'. Entities that are not at max level receive an equal portion based on the max level. For the second line, the sample says that 'when at max level, use 50% of the attributes' max value'. That is because it is a special attribute which had to be measured as a 'percent to max attribute value' rather than the standard method.

***

The **Stacked** method is an alternative default formula which allows you to say that, for every level the specified attribute would increase by a specified amount. This overrides the Special Attributes formula as well, however the cap imposed on each of the special attribute by Minecraft is still in force. An example of the syntax used to implement this method is as follows:

```yaml
max-health: ['5.0', 'STACKED']
```

***

The final newer method for attribute calculation is the **Custom** formula. This allows you to craft your own formula to determine how the attribute is modified. The value you're crafting is being added to the default applied amount, and makes heavy use of the Placeholders system to construct a fluid mix of numbers to form a final value in a similar way that Construct-Level builds the final applied level. An example of the syntax used to implement this method is as follows:

```yaml
max-health: '%max-health% + (%level% * (%max-health% * 0.25))'
```



## Deaths in Chunks System

This system contains a set of settings which control how it works.

```yaml
settings:
  maximum-death-in-chunk-threshold: 15
  max-adjacent-chunks: 5
  chunk-max-cooldown-seconds: 10m
  disable-vanilla-drops-on-chunk-max: false
  disable-item-boost-on-chunk-max: true
  disable-xp-boost-on-chunk-max: true
```

These settings allow LevelledMobs to limit or stop entirely the Custom Drops or Item and Experience boosts typically or otherwise given to a player in a certain area measured in chunks where there have been a higher than average number of mob deaths in the same chunk. This is typically done by player farms or other stationary or small area kill-zones. When any player breaches the threshold of mobs killed within the specified time in the same chunk, a cooldown timer will apply to the affected chunks and any specified adjacent chunks which will limit the drops and experience points of the mobs which die in those chunks until the cooldown expires and the chunk is reset.&#x20;
