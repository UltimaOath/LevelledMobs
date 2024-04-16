# 🌟 customdrops.yml

## Custom Drops Configuration

LevelledMobs' `customdrops.yml` file allows you to build custom drops utilizing many different config options to create unique materials and custom commands to add to or replace an entity's drops.

[View Latest Default File](https://github.com/ArcanePlugins/LevelledMobs/blob/master/src/main/resources/customdrops.yml)

***

## Defaults:

These config options will apply to all drops constructed within CustomDrops _unless_ you have modified a drops' individual properties to override these default settings. Each of these must have a value in order for LM's CD to function properly, but once it is set here, you do not need to set it within your individual drops if the value would not change. These defaults apply to all systems within the CD file, including **Drop Tables**.

> #### For any value listed as a _percent_: `1.0` = 100% ; `0.0` = 0%

```yaml
defaults:
  chance: 0.2
  use-chunk-kill-max: true
  amount: 1
  minLevel: -1
  maxLevel: -1
  damage: 0
  custommodeldata: -1
  min-player-level: -1
  max-player-level: -1
  player-level-variable: ''
  player-level-match-value: ''
  nomultiplier: true
  nospawner: false
  equipped: 1.0
  equip-offhand: true
  equip-on-helmet: false
  override: false
  maxdropgroup: 1
  group-limits:
    cap-select: -1
    cap-per-item: -1
    cap-total: -1
    cap-equipped: -1
    retries: 0
  priority: 0
  player-caused: true
  item_flags: ''
  groupid: ''
  overall_chance: 0.0
  nbt-data: ''
  only-drop-if-equipped: false
  name: ''
  lore:
    - ''
    - ''
  enchantments:
    ENCHANTMENT: X
  enchantments:
    ENCHANTMENT:
      shuffle: false
      default: 1
      X: 0.5
  overall_permission: ['']
  permission: ['']
  cause-of-death: ['']
  run-on-spawn: false
  run-on-death: true
  delay: 0
```

<table><thead><tr><th width="204" align="center">Config Line Option</th><th>Description</th></tr></thead><tbody><tr><td align="center"><code>chance:</code></td><td>This represents the percent chance of an individual CD being dropped. Supports sliding values.</td></tr><tr><td align="center"><code>use-chunk-kill-max:</code></td><td>If the chunk kill count system is enabled in <code>rules.yml</code>, then setting this to true will cause the custom drop to not drop once the threshold has been met, until the cooldown time expires.</td></tr><tr><td align="center"><code>amount:</code></td><td>This represents the number of individual CD being dropped. This may be ranged, such as <code>1-3</code>, where a value is randomly selected from between the two min/max values.</td></tr><tr><td align="center"><code>minLevel:</code> <code>maxLevel:</code></td><td>This represents the minimum and maximum level required of the entity before an individual CD will drop.<br>Replace with <code>-1</code> to disable the particular level check.</td></tr><tr><td align="center"><code>damage:</code></td><td>The amount of damage the item will have. Can use a number or a number range. The higher the value, the more damaged it will be.</td></tr><tr><td align="center"><code>custommodeldata:</code></td><td>This is an advanced config option; This represents a custom model to apply to the material CD.</td></tr><tr><td align="center"><code>nomultiplier:</code></td><td>This represents the check whether a CD will or will not multiply according to the <code>item-drop:</code> value of the killed entity.</td></tr><tr><td align="center"><code>nospawner:</code></td><td>This represents the check whether a CD will or will not apply to an entity spawned by a Spawner Cube.</td></tr><tr><td align="center"><code>equipped:</code></td><td>This represents the percent chance of an individual CD being equipped by the entity if it is able to.<br>It will first attempt to place in the hands, then the skull, and otherwise will ignore if the entity could not normally equip an item (such as Silverfish). Supports sliding values.</td></tr><tr><td align="center"><code>equip-offhand:</code></td><td>If <code>equipped:</code> was successful, and this setting is <code>true</code>, then it will equip the item to the off-hand rather than primary if it is unoccupied.</td></tr><tr><td align="center"><code>equip-on-helmet:</code></td><td>When set to <code>true</code>, if an item successfully equipped to a mob, that mob will attempt to equip the item to their helmet slot.</td></tr><tr><td align="center"><code>name:</code></td><td>This represents the name to apply to the material drop when it is used on a <code>MATERIAL</code> or <code>PLAYER_HEAD</code> drop.<br>When used for a <code>customCommand</code>, it is merely a debug value.<br>You can use Minecraft's color code or if your server software supports it, HEX colors.</td></tr><tr><td align="center"><code>lore:</code></td><td>This structure of config options allows you to set multiple lines of lore to apply to a <code>MATERIAL</code> or <code>PLAYER_HEAD</code> drop.<br>You can use Minecraft's color code or if your server software supports it, HEX colors.</td></tr><tr><td align="center"><code>enchantments:</code><br><code>ENCHANTMENT:</code> <code>X</code><br><code>ENCHANTMENT:</code> <code>X: 0.5</code><br><code>shuffle:</code> <code>default:</code></td><td>This structure of config options allows you to apply enchantments to items.<br>Replace <code>ENCHANTMENT:</code> with the name of the enchantment, and replace <code>X</code> with the strength of that enchantment.<br>For example, <code>UNBREAKING: 2</code>.<br>You can also specify the chance of a specified enchantment level being applied to an item, by using <code>X: 0.5</code> beneath the <code>ENCHANTMENT:</code>; the <code>X</code> represents the strength of the enchantment, while the <code>0.5</code> represents the chance of that enchantment level being applied.<br>Within this section you can specify <code>shuffle: false</code>, which will process the enchantment level chances to apply in order rather than at random. The setting <code>default: X</code> will use the specified level if none of the enchantment level chances succeed.</td></tr><tr><td align="center"><code>override:</code></td><td>This will determine whether LM will process CD alongside the vanilla drops, or replace them entirely.</td></tr><tr><td align="center"><code>maxdropgroup:</code> <code>groupid:</code></td><td>Using <code>groupid:</code> within multiple items under the same <code>EntityType</code> or <code>drop-table:</code> will combine these CD into their own separately processed group. <code>maxdropgroup:</code> applies a limit to the number of selected items from the same groupid to be chosen for processing.</td></tr><tr><td align="center"><code>group-limits:</code><br><code>cap-select:</code><br><code>cap-per-item:</code><br><code>cap-total:</code><br><code>cap-equipped:</code><br><code>retries:</code></td><td>The <code>group-limits:</code> settings include multiple cap checks to apply to items within the same <code>groupid:</code>. If any setting within <code>group-limits:</code> is set, then any value for <code>maxdropgroup:</code> will be ignored.<br><code>cap-select:</code> functions identically to the current <code>maxdropgroup:</code> setting; a limit to the number of items from the same groupid which will be selected for drop-processing. For example, if three items share the same <code>groupid:</code>, and I set <code>cap-select: 1</code>, then only one of those items will be selected for potential drop-processing.<br><code>cap-per-item:</code> functions as a cap on the <code>amount:</code> of an item on a per-item basis. This is useful for when <code>retries:</code> are being used and you do not want the player to receive a lot of the same items.<br><code>cap-total:</code> functions as a cap on the total quantity of items which can be dropped from all sources combined within the same <code>groupid:</code>.<br><code>cap-equipped:</code> functions as a cap on the total number of items which an entity can successfully equip from the items within the same <code>groupid:</code>.<br><code>retries:</code> functions as a re-roll ability, telling LM to re-process the items within the same <code>groupid:</code> X additional times after the first attempt. This provides the ability for a group of items to be processed multiple times in order to increase the odds for a drop or equip event to occur.</td></tr><tr><td align="center"><code>priority:</code></td><td>By default, CD processes the drops in a similar fashion to how LM processes the rules tree.<br>By setting a <code>priority:</code> on an individual CD, you are letting certain items process first before others.</td></tr><tr><td align="center"><code>player-caused:</code></td><td>This represents the check on whether the entity's death was caused by a player, or whether it was environmental.<br>It is recommended that you do not change this from <code>true</code>, as making this <code>false</code> will cause any levelled entity who dies to potentially drop your special customized drops.</td></tr><tr><td align="center"><code>overall_chance:</code></td><td>This represents a percent chance of any of the EntityType's CD being processed at all. This only needs to be placed once for an EntityType, and if the chance fails, none of the CD for that EntityType will process. Supports sliding values.</td></tr><tr><td align="center"><code>nbt-data:</code></td><td>This allows you to specify any NBT data to apply to a material drop.<br><strong>NOTE:</strong> This requires the soft-dependency <a href="https://www.spigotmc.org/resources/nbt-api.7939/"><strong>NBT-API</strong></a><strong>.</strong></td></tr><tr><td align="center"><code>item_flags:</code></td><td>This allows you to specify the various <code>ITEM_FLAGS</code> that Minecraft provides to apply to materials.<br><code>HIDE_ATTRIBUTES</code> - Will hide attributes, like damage.<br><code>HIDE_DESTROYS</code> - Will hide what the Item can destroy.<br><code>HIDE_DYES</code> - Will hide the dye color applied to Item.<br><code>HIDE_ENCHANTS</code> - Will hide enchantments on Item.<br><code>HIDE_PLACED_ON</code> - Will hide where the Item can be placed.<br><code>HIDE_POTION_EFFECTS</code> - Will hide potion effects placed on the Item.<br><code>HIDE_UNBREAKABLE</code> - Will hide unbreakable status of Item.</td></tr><tr><td align="center"><code>only-drop-if-equipped:</code></td><td>This represents a check, if an Entity has <code>equipped:</code> the item successfully, whether the <code>chance:</code> to drop will apply. If set to <code>true</code>, then only if the item was successfully equipped will the <code>chance:</code> be attempted in the drop. If set to <code>false</code>, then the item will attempt to drop regardless of it's equipped status.</td></tr><tr><td align="center"><code>overall_permission:</code> <code>permission:</code></td><td>A <code>MODALLIST</code> config option; this represents a check against the nearest player to the entity, OR the player who killed an entity, depending on it's implementation. All permissions as registered as <code>levelledmobs.permission.&#x3C;node></code>, where <code>&#x3C;node></code> represents the value of this config. For example, if your permission was <code>levelledmobs.permission.vip</code>, you would configure it as such: <code>permission: ['vip']</code>. Using <code>overall_permission:</code> will apply to all items within the set, while <code>permission:</code> applies to each singular item.</td></tr><tr><td align="center"><code>cause-of-death:</code></td><td>A <code>MODALLIST</code> config option; this represents a check against how the entity was killed. This only takes into account the final blow, and will ignore <code>player-caused: true</code>, since the cause of death will not typically involve player interaction ('fire' dealing the damage, versus the player).</td></tr><tr><td align="center"><code>min-player-level:</code> <code>max-player-level:</code></td><td>This represents the minimum and maximum Minecraft level required of the Player before an individual CD will drop.<br>Replace with <code>-1</code> to disable this particular level check.</td></tr><tr><td align="center"><code>player-level-variable</code></td><td>If this config option is set, the above <code>min-player-level:</code> and <code>max-player-level:</code> will reference this variable instead of the player's Minecraft level. You can use any <code>PAPI</code> placeholder tag in this place similar to how the <code>Player Levelling</code> strategy uses the variable to generate levels.</td></tr><tr><td align="center"><code>player-level-match-value</code></td><td>If this config option is set, you can instead check for a text-based value from a a <code>PAPI</code> placeholder tag. This can still reference the above <code>min-player-level:</code> and <code>max-player-level:</code>. You can use any <code>PAPI</code> placeholder tag in this place similar to how the <code>Player Levelling</code> strategy uses the variable to generate levels. The tag will be checked against the <code>player-level-variable:</code>. This config option includes a wildcard ability to pull part of the output from the <code>player-level-variable:</code>. You can add a <code>*</code> as a prefix, suffix, or both to search for a partial match. For example, if the variable output was <code>Lvl 5 Zombie- S0hp</code>, I could search for <code>Zombie*</code> or <code>*Zombie*</code> to successfully match, as the word <code>Zombie</code> matches in part as a wildcard check. Under this example, searching for <code>Zombie</code> would fail to match, as the word in the output appears as <code>Zombie-</code> and the search parameters were for an exact-match.</td></tr><tr><td align="center"><code>external-amount</code></td><td>When used with LM Items Official Plugin, this sets the amount internally to the specified plugin</td></tr><tr><td align="center"><code>type</code></td><td>When used with LM Items Official Plugin, this sets the item type (currently only supported with MMOItems)</td></tr><tr><td align="center"><code>run-on-spawn</code></td><td>Applicable only to custom commands, determines if it will be executed when a mob spawns in</td></tr><tr><td align="center"><code>run-on-death</code></td><td>Applicable only to custom commands, determines if it will be executed when a mob dies</td></tr><tr><td align="center"><code>delay</code></td><td>Applicable only to custom commands, this is the number of ticks that will elapse before the command is executed</td></tr></tbody></table>

***

## Universal Groups:

LM includes several groups of entities which are bundled together in a convenient format. Each of these groups function as their own EntityType, applying to multiple entities at once. You can refer to the [EntityType Universal Groups](https://github.com/lokka30/LevelledMobs/wiki/Documentation---rules.yml#universal-mob-and-biome-groups) for the different types!

## Specified Mobs:

LM has listed all vanilla entities as of Minecraft 1.20 within the CD file. You should locate the entity you wish to modify instead of adding additional entities at other spots within the config, as they will most likely not process as expected. You may delete any entities you do not use if you so choose, as you can always add them back again later.

## Sliding Values

There are three options that support sliding values; `chance`, `equipped` and `overall_chance`. You can either use a decimal to represent a percent or assign tiers that represent a level range and an assignment range. The syntax is:

```yaml
chance:
  lvl-lvl: X-Y
```

On the left side you put the min and max levels that the tier can match, then on the right side put the min and max chance those level ranges will use; where the assigned value slides based on the level values assigned. If the mob level is between the min and max then it will use the assigned min and max assignment. For example:

```yaml
- IRON_SWORD:
    chance:
      1-10: 0.2-0.8
      11-20: 1.0
```

In the above example, level 1 mobs will have a 20% chance. Level 10 mobs will have 80% chance and any mob levels in between will scale accordingly. For mobs levelled 11 through 20, they will have a 100% chance. Any mob levels without an assignment will have 0% chance, such as level 21+ in the above example.

## Drop Tables

CD includes the Drop Table system, which allows you to construct groups of materials or custom commands which can be attached to any EntityType as a single line item utilizing `usedroptable: tableName`, helping to reduce any instances of duplicate drops covering multiple entities. This can also be used to craft 'tiered' drops.

```yaml
PUT_ENTITY_TYPE_HERE:
  - usedroptable: 'putTableNameHere'
```

When constructing drops with the Drop Table, you can replicate the same formatting used for any other drop, replacing the EntityType with the tableName.

**NOTE:** It is highly recommended that you instead use the **Rules** file to implement any drop table. It will provide far more accurate conditioning for when and how to apply drop tables.

## LM Items - External Plugin Support

If you want to use custom items from external plugins, take a look at LM Items.\
This plugin bridges the gap so you can use third party items natively.\
Download from [https://www.spigotmc.org/resources/lm-items.102081/](https://www.spigotmc.org/resources/lm-items.102081/)

An example of how LM Items improves your server: Adding Player Heads to mobs!

Here is an example of how to use the  `- HeadDatabase:` LM Items item-type.

```yaml
# Requires LM_Items Official Addon
  - HeadDatabase:61942:
      amount: 1
      chance: 1.0
```

You supply the skull ID number from [Minecraft Heads](https://minecraft-heads.com/), which is provided in the URL of the skull which you select, and append it to the `HeadDatabase:` item-type as shown above.\
For example, the url `https://minecraft-heads.com/custom-heads/humanoid/61942-demon-helmet` would have the ID `61942`.

## Materials, Commands, and Special Items

```yaml
- MATERIAL:

- ENCHANTED_BOOK:
    enchantments:
      ENCHANTMENT: X

- customCommand:
    command: ''
    command: ['', '']
    ranged_A: ''
    ranged_B: ''
    name: ''
```

`MATERIAL:` drops gather their config options from the Defaults section listed above. Any config option listed there can be used within any `MATERIAL:` or `customCommand` drop.

`customCommand:` tells CD that you wish to setup a command to process like any other drop.\
In order for this feature to function, it requires at minimum the `command:` config option with a valid console formatted command present.\
You can also use multiple commands at once by listing them as demonstrated above.\
An example of a valid command might be `effect give %player% strength %ranged_a% %ranged_b%`.\
The tags prefixed with `ranged_` are unique. These allow you to construct a random number generator to be used within commands as placeholders. The example config above demonstrates how you would utilize the ranged config option, appending an A/B/C/D, et cetera to the end of `ranged_` creates the tag, while the value represents a range of potential values which could be applied to the placeholder tag present in the individual command drop. Using the previous example command, with the `ranged_A: 1-2` and `ranged_B: 3-5`, then the first tag would be any value between 1-2, while the second would be any value between 3-5 when utilized within the command being activated.

`ENCHANTED_BOOK` is a special type of `MATERIAL` drop which will enable anvil-ready enchanted books by utilizing the `enchantments:` config option.
