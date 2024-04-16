# 🌟 settings.yml

<details>

<summary>Click to view a comprehensive list of all options within Settings.YML</summary>

```yaml
#
#   ---------------  -  ------------------------------
#        Section 01  |  Settings
#   ---------------  -  ------------------------------

# ||  ADVANCED USERS ONLY | DEBUG
# ||  Do not touch this unless a LM developer tells you to.
# ||  These settings print a lot of 'behind the scenes'
# ||  information about LevelledMobs' operations to the console.
# ||  With LevelledMobs4, we suggest using the command: /lm debug
debug-entity-damage: false
debug-misc: [ ]

# ||  This is a good update checker - it doesn't freeze
# ||  your server startup since it is asynchronous, it
# ||  only speaks if it found an update, and it only runs
# ||  once every server startup. Pointless to disable.
use-update-checker: true

# ||  ADVANCED USERS ONLY
# ||  If your server software (e.g. Paper) has
# ||  the Adventure library in it, then LevelledMobs
# ||  will use it, so long this setting is enabled.
# ||  CraftBukkit and Spigot servers do not have
# ||  this library, although PaperMC servers and
# ||  all PaperMC forks (Airplane, etc) do.
# ||  It is recommended that you keep this enabled.
use-adventure: true

# ||  ADVANCED USERS ONLY
# ||  Do not touch this unless a LM developer tells you to.
# ||  If your server software (e.g. Paper) has the Adventure
# ||  Library in it, then you can change this to false and
# ||  use MiniMessage for nametag parsing.
use-legacy-serializer: true

# ||  ADVANCED USERS ONLY
# ||  Do not touch this unless a LM developer tells you to.
# ||  This system controls the repeating asynchronous listener which
# ||  maintains the accuracy of levelling and nametag information.
# ||  This is very important and resource sensitive, so it is not
# ||  suggested to alter these settings without testing beforehand.
# ||  This system acts as a garbage collection and verification
# ||  mechanism, as well as a form of 'rechecking' entities to ensure
# ||  they follow the rules of the system.
async-task-update-period: 3
async-task-max-blocks-from-player: 320

# ||  ADVANCED USERS ONLY
# ||  Do not touch this unless a LM developer tells you to.
# ||  Enables the on-spawn listener to apply levels to entities.
# ||  If false, entities will no longer be levelled when they spawn in.
level-mobs-upon-spawn: true

# ||  ADVANCED USERS ONLY
# ||  Do not touch this unless a LM developer tells you to.
# ||  Enables the on-load listener to apply levels to entities once
# ||  a chunk has been loaded. If false, this listener will be disabled.
ensure-mobs-are-levelled-on-chunk-load: true

# ||  ADVANCED USERS ONLY
# ||  Do not touch this unless a LM developer tells you to.
# ||  This controls the mob processing delay (in in-game ticks)
# ||  after a mob is marked to be levelled. Note, that there is
# ||  a 1 tick delay in addition to this setting.
mob-process-delay: 0

# ||  ADVANCED USERS ONLY
# ||  Do not touch this unless a LM developer tells you to.
# ||  Should nametag packets be ignored if the mob has died?
assert-entity-validity-with-nametag-packets: true

# ||  When player kill exceed amount of levelled mobs in
# ||  a chunk(within given period). Should we send message
# ||  to player to inform him?
exceed-kill-in-chunk-message: true

# ||  This sets a hard limit on the number of entities
# ||  you can summon using the LevelledMobs summon command.
# ||  This is to prevent accidental crashes.
customize-summon-command-limit: 10

# ||  What is the max distance the summon command will
# ||  spawn mobs away from players?
summon-command-spawn-max-distance-from-player: 5

# ||  What is the min distance the summon command will
# ||  spawn mobs away from players?
summon-command-spawn-min-distance-from-player: 3

# ||  Do not touch this unless a LM developer tells you to.
# ||  This sets a hard limit on the number of times a command
# ||  being 'dropped' from the Custom Drops system can be
# ||  performed in a loop. This is to prevent accidental crashes.
customcommand-amount-limit: 100

# ||  When set to true, nametags will show the mob name
# ||  translated to your client language settings.
# ||  However some older or hacked clients do not support
# ||  this and will show the translation key instead.
use-translation-components: true

# ||  These settings pertian to Player Levelling, which sets
# ||  the updating period for the Player Levelling tasks.
player-levelling-relevel-min-time: 5s

# ||  This setting determines how far away an entity can be
# ||  for it to register under `%levelledmobs_mob-target%`.
nametag-placeholder-maxblocks: 30

# ||  What conditions should a mob have in order for the
# ||  LevelledMobs kill command to 'skip' it (not kill the mob)?
kill-skip-conditions:
  is-nametagged: true
  is-tamed: true
  is-leashed: true
  is-transforming: true
  is-villager: true
  entitytype:
    included-groups: ['all_passive_mobs']
    included-list: ['']

# ||  Should mob heads be multiplied by LevelledMobs'
# ||  drop multiplier? A considerable amount of servers
# ||  have heads in their economies, so it is set to false
# ||  by default as to not harm their economies.
mobs-multiply-head-drops: false

# ||  When set to true, every mob is checked to make sure it has
# ||  the latest rules applied by comparing a stored hash string.
check-mob-hash: true

# ||  When using the LM Summon command should it print the results
# ||  in the console or player that executed the command
print-lm-summon-results: true

# ||  ADVANCED USERS ONLY
# ||  The amount of time that should elapse before
# ||  the LEW (LivingEntityWrapper) cache is cleared.
lew-cache-clear-period: 3m

# ||  This setting will exclude players who are in creative
# ||  mode when the Player Level Modifier is determining values.
exclude-players-in-creative: false
```

</details>

## Should LM stop sending packets if an entity has died?

```yaml
assert-entity-validity-with-nametag-packets: true
```

* `true` - Once an entity has reached zero health, packets for that entity will no longer be sent.
* `false` - Once an entity has reached zero health, LM may send extra packets to try make sure the entity's nametag data (such as their health) is accurate.

This setting attempts to fix a compatibility issue with ViaBackwards where VB detects LM sending name tag packets of entities which are dead.

It is not recommended that you change this setting unless you understand exactly what you are doing.



## Automatic Asynchronous Nametag and Level Updater

```yaml
async-task-update-period: 3
async-task-max-blocks-from-player: 320
```

This setting will check the the area within X blocks of a player, where X is the `async-task-max-blocks-from-player:`, for any entities which should have been levelled, LM nametagged, or are missing attributes for whatever reason.

The `async-task-update-period:` is counted in seconds.



## Customize Summon Command Limit

```yaml
customize-summon-command-limit: 10
```

This setting will forcibly limit the number of entities which can be summoned with LM's `/lm summon` command per use.

This is used to help prevent any accidents or overloading your server with countless entity summons.



## Head Drop Multiplier

```yaml
mobs-multiply-head-drops: false
```

* `true` - Mob head item drops **will not** be multiplied if they otherwise would be.
* `false` - Mob head item drops **will** be multiplied as if they were any other material drop.

On some servers, heads are considered too valuable of a resource to be multiplied alongside the other drops of an entity. This setting allows you to decide whether you want to allow these drops to multiply alongside everything else that would have dropped.



## Customize Command Drop Limiters

```yaml
customcommand-amount-limit: 100
```

This helps to prevent any accidental crashes through an entity running more commands than your server can handle upon death. This will set a hard-limit on any custom commands dropped through the Custom Drops system, overriding any set `amount:` which is above this value.



## Mob Processing Delay

```yaml
mob-process-delay: 0
```

This will add an additional amount of delay, counted in ticks, before LM begins to process the entity. Adding delay is only useful in situations where other plugins need time to process before LM applies any values.

It is not recommended that you change this setting.



## Summon Command Spawn-Distance-from-Player

```yaml
summon-command-spawn-max-distance-from-player: 5
```

This will determine the maximum distance from a player an entity will spawn when you utilize `/lm summon <quantity> <entity> <level> here`.

```yaml
summon-command-spawn-min-distance-from-player: 3
```

This will determine the minimum distance from a player an entity will spawn when you utilize `/lm summon <quantity> <entity> <level> here`.



## Kill-Skip Conditions

```yaml
kill-skip-conditions:
  is-nametagged: true
  is-tamed: true
  is-leashed: true
  is-transforming: true
  is-villager: true
  entitytype:
    included-groups: ['all_passive_mobs']
    included-list: ['']
```

For each kill-skip condition above:

* `true` - Entities under that condition **will** be skipped during LM's kill command.
* `false` - Entities under that condition **will not** be skipped during LM's kill command.

You can also specify specific mob types in a similar fashion to the **Condition** check for `entities`.\
These will specify what entities are skipped when you utilize `/lm kill`.\
This is useful to prevent any pets or other unintended entity deaths.\
It is recommended that you do not adjust these settings without knowing what you are doing.



## Use Translation Components

```yaml
use-translation-components: true
```

* `true` - Any default entity names will be displayed to the player in the native language used in the players' client.
* `false` - Some older and customized clients do not support this feature, so you may disable this if your servers' environment requires this circumvention.

This system provides a quality of life mechanism and should be enabled in most situations; this feature does not exist in older Minecraft clients and some customized clients, and can result in broken names being displayed to the player. Should your server necessitate this kind of circumvention, then by disabling this feature you are instead referencing an internal table of English names. You can still modify the name of entities via the `apply-setting: entity-name-override:` feature of the `rules.yml`.



## Verify Entities on Chunk Load

```yaml
ensure-mobs-are-levelled-on-chunk-load: true
```

* `true` - Loaded chunks nearby players will be checked for any entities which are missing a level which should not be.
* `false` - Entities which were not levelled for whatever reason will not be double-checked.

This system acts like a janitor, checking loaded chunks nearby players for any entities which should be levelled and are not.

It is recommended that you do not change this setting if you do not understand its effects.



## Print LM Summon Command Results to Console/Player

```yaml
print-lm-summon-results: true
```

* `true` - When enabled, use of the LM Summon Command will be output into console.
* `false` - When disabled, use of the LM Summon Command will not be output into console.

This setting manages whether the LM Summon Command output text will be displayed in the console or not. Disabling this setting might be useful if you utilize the command regularly or repeatedly which might fill the console with notices.



## Level Entities on Spawn

```yaml
level-mobs-upon-spawn: true
```

* `true` - Once an entity has been spawned into the world, LM will immediately attempt to apply a level to the entity.
* `false` - Entities will not receive a level until they either take damage from a player or have targeted a player.



## Chunk Kill Count System

```yaml
exceed-kill-in-chunk-message: true
```

* `true` - When the chunk kill count system is enabled and reaches the threshold for max deaths a chunk, a message will be sent to the player that killed the mob.
* `false` - No messages will be sent to any players for the chunk kill count system.



## Check Mob Rule Hash

```yaml
check-mob-hash: true
```

Mobs which have been levelled by LevelledMobs will receive a uniquely generated hash key. This key is unique to the settings and layout of your `rules.yml` and is generated during server startup and any `/lm reload` thereafter. This setting handles what the listener will do when it detects a hash key that does not match to the current rules hash key. This task is performed during the automatic asynchronous tasks ping (default of six seconds) as well as when chunks are loaded and the level verification listener is performing. It is recommended that you do not change this setting as this resolves a long-standing issue of outdated levelled mobs existing in long-forgotten unloaded chunks.

* `true` - When an entity is determined to have a missing or invalid hash key, the entity will immediately be re-evaluated using the current rules arrangement and receive an updated hash key.
* `false` - Entities will not be re-evaluated if there is a missing or invalid hash key. This means that entities which had become unloaded during a previous hash of the rules will not be re-evaluated once they become reloaded.



## Player Levelling Strategy Settings

```yaml
player-levelling-relevel-min-time: 5s
```

`player-levelling-relevel-min-time:` represents the time, in milliseconds, before an entity is updated against the nearest player. Setting this to `0` will prevent any relevelling.

These settings revolve around the levelling modifier known as **Player Variable Modifier**.



## Nametag Placeholder Distance

```yaml
nametag-placeholder-maxblocks: 30
```

`nametag-placeholder-maxblocks:` represents the the maximum distance from the player an entity can be to be registered under `%levelledmobs_mob-target%`.



## Updates and Debug Settings

```yaml
use-update-checker: true
debug-entity-damage: false
debug-misc: [ '' ]
file-version: 30
```

`use-update-checker:` When set to `true`, this will notify you once at server startup whether you have an up-to-date version of LM.

`debug-entity-damage:` When set to `true`, this will display detailed attribute information in-game when you hit an entity.

`debug-misc:` Refer to [settings.yml/Debug-Misc](https://github.com/lokka30/LevelledMobs/wiki/Documentation---Debug-Misc) for further details.

`file-version:` This value represents the config processing version. Do not alter this value, or you may break your plugin and configs.



## LivingEntityWrapper \[LEW] Cache Settings

```yaml
lew-cache-clear-period: 3m
```

This establishes the timetable on which any stagnant or expired LEW which were not cleared automatically are cleared by force. This is to help prevent any memory issues. It is not recommended that you change this setting.



## Exclude Creative-Mode Players from PVM

```yaml
exclude-players-in-creative: false
```

* `true` - A player in Creative mode in-game will not be counted when the Player Variable Modifier updates any mob values.
* `false` - The player can be in Creative or Survival mode.
