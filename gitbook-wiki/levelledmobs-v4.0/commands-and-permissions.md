---
description: Still being updated!
---

# 🔑 Commands and Permissions

<details>

<summary><strong>/lm debug</strong></summary>

To understand your _set-debug_ options, refer to the [Debugging](debugging.md) section of the wiki.

* `/lm debug chunk-kill-count reset` \
  Resets chunk kill count system to zero.
* `/lm debug create-zip` \
  Provides method to create a debug zip file for developers to review. Requires `confirm` statement to perform.
* `/lm debug disable` \
  `/lm debug disable-all` \
  Disables the **Debug** system output.
* `/lm debug enable <set-debug>` \
  Enables a singular _debug filter_ which will respect any `filter-results` settings.
* `/lm debug enable-all` \
  Enables all _debug filters_ which will respect filter-results except for _set-debug_.
* `/lm debug enable-timer <time>` \
  Enables the **Debug** system for a set period of time which will respect any `filter-results` settings.&#x20;
* `/lm debug filter-results`&#x20;
  * `... clear-all-filters` \
    Clears any established `filter-result` settings, resetting to default state.
  * `... listen-for <both|success|failure>` \
    Establish how **Debug** will consider the output of any _set-debug_ option based on whether the event _succeeded_, _failed_, or if _either_ occurred.&#x20;
  * `... set-debug <add|clear|remove> <set-debug>` \
    Establish what **Debug** options will be considered. You can _add_ or _remove_ a _set-debug_, or _clear_ all values for _set-debug_ filter.
  * `... set-distance-from-players <distance>` \
    Establish how far away from any player the activated **Debug** options will listen for mobs to conduct any activated debug options measured in blocks.
  * `... set-entities <add|clear|remove> <entity>` \
    Establish what mobs will be considered. You can _add_ or _remove_ a mob, or _clear_ all mobs from the filter.
  * `... set-players <add|clear|remove> <player>` \
    Establish what players around which the debug will be performed. If no player specified, the command initiator will be the player used. You can _add_ or _remove_ a player, or _clear_ all players from the filter.
  * `... set-rules <add|clear|remove> <rule>` \
    Establish what rules will be listened for when they are processed, either failed or successful. You can _add_ or _remove_ a rule, or _clear_ all rules from the filter.
  * `... set-y-height <clear|max-y-height|min-y-height> <height>` \
    Establish a min or max Y-Height, restricting the **Debug** options to the height range.
* `/lm debug lew-clear` \
  Clears the LivingEntityWrapper \[LEW] class.
* `/lm debug lew-debug` \
  Outputs the current LivingEntityWrapper \[LEW] state.

</details>

<details>

<summary><strong>/lm info</strong></summary>

**LevelledMobs v4**\
_The Ultimate Mob Levelling Solution_

Maintainers: Penalbuffalo, lokka30, and UltimaOath\
Check [Developers and Contributors](../credits-and-misc/developers-and-contributors.md) for more details!

</details>

<details>

<summary><strong>/lm kill</strong></summary>

* `/lm kill all`&#x20;
  * `... <world> <flag>` \
    When killing _all_ mobs, you can specify what _worlds_ or additional _flags_ you want to apply to the kill-all command. \
    The `flag` setting refers to possible flags to add ot the kill-all.
    * `/nodrops`   |   Will not cause the entities' drops to happen when they are killed.
    * `/levels <range>`   |   Will limit the kill command to the specified level range.
* `/lm kill near <amount>` \
  Kills all levelled mobs within the specified blocks of the player.

</details>

<details>

<summary><strong>/lm reload</strong></summary>

Performs a reload of the LevelledMobs plugin, including reprocessing the configuration files.

</details>

<details>

<summary><strong>/lm rules</strong></summary>

* `/lm rules force-all` \
  Force LevelledMobs to perform a reload, and then to reprocess all loaded mobs to ensure they are matching the latest rules and settings.
* `/lm rules <help-discord|help-wiki>` \
  Provides links to the Support Discord and the LevelledMobs4 Wiki.
* `/lm rules reset <challenge>` \
  Provides an easy to use reset mechanism which allows you to preset the enabled difficulty of the default rules configuration file. Requires `confirm` statement to perform.
* `/lm rules show-all <console>` \
  Will output all registered **Presets**, **Default Rule**, and **Custom Rules**. Adding `console` to the end of the command will instead output the results to console (recommended, many lines of text).
* `/lm rules show-effective <console> <looking-at>` \
  Will output the effective rules of the nearest mob to the player within ten blocks. Adding `console` to the end of the command will instead output the results to console (recommended, many lines of text). Adding `looking-at` to the end of the command will limit the commands' reach to whichever mob you were looking at with your crosshairs.
* `/lm rules show-rule <rule> <console>` \
  Will output the details registerred by LevelledMobs concerning the specified `rule`. Adding `console` to the end of the command will instead output the results to console (recommended, can be many lines of text).
* `/lm rules show-temp-disabled` \
  If a **Custom Rule** has been disabled due to a _cooldown_ condition, it will be listed here.

</details>

<details>

<summary><strong>/lm spawner</strong></summary>

* `/lm spawner create` \
  This is the start of the LevelledMobs Spawner creator. It requires at minimum the `/minlevel`, `/maxlevel`, and `/spawntype` flags for the Spawner to function.\
  You can also reference the `/name` flag of the spawner in the **Rules** file via the `spawner-name:` condition.\
  You can append any number of flags listed below to the end of the command, in any order.
  * `/minlevel <amount>` \
    The min-level of any mob spawned from this spawner.
  * `/maxlevel <amount>` \
    The max-level of any mob spawned from this spawner.
  * `/name <name>` \
    The name of the spawner cube for use in **Rules** file.
  * `/lore <text>` \
    Add lore to any item that can accept lore. To add a newline, use `\n`.
  * `/nolore`\
    Removes the lore from the item.
  * `/customdropid <id>` \
    Add a `drop-table` from the **Custom Drops** system.
  * `/spawntype <entity>` \
    The mob which this spawner will spawn.
  * `/delay <amount>` \
    Sets the spawners' delay, measured in ticks.
  * `/maxnearbyentities <amount>` \
    Sets the maximum number of spawned entities which can be within the spawning range of the spawner.&#x20;
  * `/minspawndelay <amount>` \
    Sets the minimum spawner delay, measured in ticks.
  * `/maxspawndelay <amount>` \
    Sets the maximum spawner delay, measured in ticks.
  * `/requiredplayerrange <amount>` \
    Sets the minimum distance the player must be from the spawner for it to activate.
  * `/spawncount <amount>` \
    Sets the number of mobs which will spawn at each successful spawn event.
  * `/spawnrange <amount>` \
    Sets the maximum distance away from the spawner cube that mobs will be spawned.
  * `/giveplayer <player>` \
    Gives the set player one of the created spawners. If no player specified, will be given to the command executor.&#x20;
* `/lm spawner info <on|off>` \
  Displays information about LevelledMobs Spawner Cubes when right clicked and set to `on`. When `off`, no information will be sent.
* `/lm spawner copy <on|off>` \
  Will duplicate the LevelledMobs Spawner Cube when right clicked and set to `on`. When `off`, no copy will be produced.&#x20;

</details>

<details>

<summary><strong>/lm spawner-egg</strong></summary>

* Coming Soon

</details>

<details>

<summary><strong>/lm summon (Coming Soon)</strong></summary>

* Coming Soon

</details>

