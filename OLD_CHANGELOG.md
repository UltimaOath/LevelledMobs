# Old Changelog
Differences:
* The new changelog is formatted with Markdown. The old changelog is unformatted.
* The old versions contained 'SNAPSHOT' and 'RELEASE', the new versions will only attach a 'PRE', 'ALPHA' or 'BETA' suffix where necessary. Stable versions will not have a suffix.

```
v1.34.0-RELEASE:
    Before I show the changelog, I need to give a big thank you to deiphiz for their contribution this update. Not only are his contributions brilliant, I didn't have to fix or tweak a single line of code he'd made.
    If you are a user who wants nametags or health name tag plugins to work (which quite a lot of you are), he's got you sorted this update!
    - Important | File 'settings.yml' has updated, its version is now '20'. Please reset or merge your current file.
    - Addition (deiphiz) | New config option to toggle if nametags update when a mob's health is updated. This option is called 'update-nametag-health'. This is now disabled by default, and I have removed the health bar placeholders from the mob name tag by default (although they are still available!). This means that you can now use name tags and health indicator plugins such as 'BeautyIndicator' to show health bars on mobs. A lot of users have been requesting this and my brain was uncapable of thinking of this simple fix.
    - Addition (deiphiz) | New config option 'start-distance' under 'spawn-distance-levelling'. This option allows you to set a value where distance from spawn levelling will begin. For example, if you only wanted distance from spawn levelling to start its action 5,000 blocks from spawn, then you can now do that!
    - Fix | Forgot to cache the nametag config option. Fixed now. :)

v1.33.9-RELEASE:
- Addition | You can now use 'BABY_ZOMBIE' type in Blacklisted Entities and Blacklist Override parts of the settings.yml :) Suggested by The8BitBuilder.
- Improvement | Little bit of code cleanup in CreatureSpawnListener

v1.33.8-RELEASE:
- Improvement | Plugin now supports 1.16.1.
- Improvement | Compiled in Minecraft 1.16.1
- Improvement | Made the compatibility checker's supported version a list so multiple versions can be considered supported
- Improvement | Added '1.16' to the supported versions on startup

v1.33.7-RELEASE:
- Improvement | Updated libraries as they were a few versions behind.
- Improvement | Reload command now initiates the whole file loading process instead of just reloading the cache. (Req by leasoncre)

v1.33.6-RELEASE:
- Improvement, Fix | Added PhantomLib to the plugin.yml depend list. Should fix the error on startup for some users.


v1.33.5-RELEASE:
Important Information:
- New dependency: PhantomLib.
- The settings file has been updated to ver 19. You can now allow passive mobs to have changed movement speeds (disabled by default), and there are extra comments to help users who need it.
- The settings file no longer reloads itself, this is to substantially increase performance. Use '/lm reload' to reload the settings file to memory now.
- New permissions 'levelledmobs.reload', 'levelledmobs.summon'

Notable Changes:
- Addition | Now caching the Settings file! LM will no longer have to access your disk several times when a mob spawns.
- Addition | Added an option to the config to allow passive mobs to have their movement speeds changed.
- Addition | Added '/lm' and '/lvlmobs' aliases to '/levelledmobs' for easier command usage.
- Addition | Added '/lm reload' to reload the settings.yml file to memory. permission is 'levelledmobs.reload'
- Improvement | Entity names now have spaces where necessary and each word is capitalized. e.g. 'CAVE_SPIDER' used to translate to 'Cavespider', it is now 'Cave Spider'.
- Improvement | Changed the default fine tuning multipliers to tone them down so they're not so overpowered

Other Changes:
- Addition | Added more information to the debug functionality (base values of attributes)
- Addition | Started work on a '/lm summon' command. It is not functional yet as the levelling system needs to be revised for this to be added. Permission is 'levelledmobs.summon'. Requested by leasoncre.
- Improvement | Removed multiple methods in favour of using PhantomLib's methods.
- Improvement | Updated dependencies
- Improvement | Removed 'instance.levelManager' access in LevelManager, e.g. 'instance.levelManager.isLevellable' becomes 'isLevellable'
- Improvement | Fixed typo in WorldGuardManager line 50
- Improvement | Unimportant changes to the '/levelledmobs' command, messages in particular.
- Improvement | Moved 'getMinLevel' and 'getMaxLevel' methods from LevelManager to FileCache + improved its code.
- Improvement | Renamed a few methods in Utils class
- Fix | all '/lm' commands saying 'for a list of commands' message
- Fix | world and entitytype overrides not checking if they're enabled before scanning for their presence

1.32.1-RELEASE
- Fix | No longer attempts to apply levels to Citizen NPCs


1.32.0-RELEASE
- Important Note | 'settings.yml' was updated to version 18. I have only touched the 'variance' part of the settings file.
- Improvement | Redone the 'variance' part of the 'distance from spawn levelling' system. The code is far simpler, more configurable, and it won't break the plugin anymore.

1.31.0-RELEASE
- Important Note | 'settings.yml' was updated to version 17. I recommend backing up your previous settings file and reconfiguring the latest one.
- Addition | Requested feature 'entity-name-override' has been added to the settings file, you can change the entity's name in their nametag. e.g. 'Creeper' to 'Kaboom!'
- Addition | Requested feature 'entitytype-level-override' has been added to the settings file, you can specify min&max level per entity type, e.g. zombie lower levels
- Addition | Requested feature 'world-level-override' has been added to the settings file, you can specify min&max level per world, e.g. nether has higher levels
- Fix | Attempted to allow Ender Dragons to be levelled
- Fix | Attempted fix at stopping already levelled mobs from being levelled again (safari nets, portal duping, ..)
- Improvement | Removed duplicate check for if the 'level' namespacedkey is not null
- Improvement | Changed part of the methods which determine a mob's level
- Improvement | Tinkered with the settings file to improve a few setting names and comments
- Improvement | Removed 'server is running supported version' message, useless
- Improvement | Replaced underscores in mob names with a space
- Improvement | A bunch of small quality-aimed changes not worth mentioning. :)

1.30.1-RELEASE
- Fixed error on load when WorldGuard is not installed

1.30.0-RELEASE
- Tried another method to help with SafariNet compatibility
- Updated bStats (v1.5 -> v1.7)

1.30.0-RELEASE
notes:
- Added extra bit in the version number for the 'build' version.
- no file changes.
changes:
- Tried another method of adding compatibility between Mob Catcher plugins (such as SafariNets).
- Shortened the 'Unsupported version' message, and switched it from a 'Warning' to a 'Info' log.
- Bunch of code changes.
 - Renamed Commands and Listener classes to more appropriate names.
 - Removed statics use in EVERY class.
 - Used lowercase 'levelledmobs' instead of 'LevelledMobs' for command
 - Changed code comments where necessary

1.29-RELEASE
notes:
- When a mob spawns, LM now checks if it is already levelled. This should provide compatibility to plugins such as Safari Net.

1.28-RELEASE
note:
- This release wasn't tested, please use with caution.
- I recommend installing this on a test server and ensuring the plugin works properly before installing it on a server where there is too much to lose.

file changes:
- settings.yml (now version 16)
 - added ranged damage multiplier

changes:
- [#56] Added 'ranged damage multiplier' with a default value of 1.1
 - Projectiles, such as arrows from skeletons, did too much damage. Requested by SpigotMC user Velerium.
- [#44] Added 'blacklisted types override', which forces mobs to be levelled, regardless of their status in 'blacklisted types' and if 'level passive' is false.
 - 'SHULKER' is added by default, as for some reason they aren't considered a hostile mob.
- [#55] Updated libraries (LightningStorage 3.0.6 -> 3.0.9)

1.27
- [#43] blacklists can now use the term 'ALL' to block all possible values.
- [#53] attempted fix at stopping players from being considered levellable
- [#49] checks if events are cancelled before proceeding. could fix potential issues

1.26
- added ranged damage
- [issue #41] fixed portals doubling attributes
- [issue #38] fixed mob equipment multiplying

1.25
- fixed nether portals duping mob attribs

1.24
notable:
- [pull #40] worldguard region levelling added by Eyrian
- [pull #39] update nametags on health regain by konsolas

other:
- moved LevelManager to utils package
- renamed a bunch of listener classes to correspond to their events

1.23
- [pull #35] using XP multiplier method from pull request by Eyrian
 - Added XP drop multiplier (configurable)
- Removed RELEASE tag from versions, which is unnecessary.
- Fixed a typo in /levelledMobs info.
- Source now includes changelog file.

1.22-RELEASE
- Fixed max stack size not being taken into consideration when multiplying drops
- Fixed incorrect failsafe-default in drop multiplier
- Cleaned up code quite a bit
 - added a new class, LevelManager, to centralise some of the tasks.
 - Moved some math to the Utils class. Currently it's a whole bunch of static methods, but I plan on soon changing that.

1.21-RELEASE
 Big thanks to Eyrian for once again making a great contribution to the plugin. I highly appreciate people putting in contributions to help me maintain the plugin whilst I'm learning Java and struggling with time.
- [pull #34] merged pull request by Eyrian
 - [issue #4] Added a drops multiplier, as suggested by Dralga ツ#1339
   Eyrian has added in a 'drops multiplier', meaning, as a mob's level increases, their drops do too.
   This multiplier is customisable in the settings file. The default value should be good - send me a message if you've found something that you recon would be better as a default value.
 - Renamed 'LTagUpdate' to 'LMobDamage' to better represent what the class does.
- added a new subcommand, /levelledMobs info. neatens up the main command more.
- added more to the code comments. tried my best to explain my class naming convention and how to use the file library. i'm surprised Eyrian managed to figure it out without any input from me whatsoever.
- added more to the config comments.
- settings.yml was updated to version 13.

1.20-release
- merged pull request by Eyrian
 - Distance from spawn levelling is added. highly configurable.
- added heaps of code comments to help you guys understand what's going on. plan on cleaning up the code too.
- changed the random integer method for generating a mob level.
 - should have fixed level being 1 more than it should be (Remii on Discord)
- added CustomName to debug and spiced up the colours a little more

1.19-release
- updated libraries
 - fixed dependency issue: file system console spam issue
- fixed name not being updated when zombie villager is cured

1.18-release
 - updated libraries

1.17-release
fixed file system

1.16-RELEASE:
notable changes: [?]
- Mob attributes were given the wrong value. The 'multipliers' section of the settings didn't really function like multipliers, but now they do.
 - Thus the values have been drastically lowered.
 - It is very important you replace the old values with these ones.
 - These values have been tried and tested by me for a while with all ten mob levels working well.
- [issue #27] added multiworld support for newly spawned mobs.
- [issue #28] you can now exclude mob spawners from creating levelled mobs.
- improved the file management system.

file changes: [1]
- settings.yml, now version 11

other changes: [?]
- code changes:
 - updated checkCompatibility() method.
 - added Utils class to have a universal area to access recommended versions for the server and plugin files.

------------- made the changelog simpler. sort the changes when writing the description on spigot instead -----------------

1.15-RELEASE:
notable changes: [0]
- [issue #22] fixed wrong attribute multiplier being checked

file changes: [1]
- settings.yml, now version 10

other changes: [0]
- ...


1.13-SNAPSHOT:
notable changes: [1]
- fixed incompatibility with PhantomCombat
- added /levelledmobs killall [world]
- added permission 'levelledmobs.killall'
- you can now edit the default mob damage (as vanilla one is too easy)

file changes: [1]
- settings.yml, now version 9

other changes:
- some code cleanup
- relocating shaded libraries in pom.xml, for storage and stats
- underscores in settings replaced with dashes for consistency

1.12-snapshot:
notable changes:
- mobs's health now set to their max health, not old max health.

file changes:
- none

other changes:
- none


1.11-SNAPSHOT:
notable changes:
- can toggle levelling of passive mobs.
- can remove creature's nametag on death which should clean up death messages. disabled by default.
- updated the default creature nametag.
- new placeholders for creature nametags: %health% and %max_health%.
- changed layout of settings slightly.
- better utilisation of the file library - settings values now have defaults built in, in case of a bad file



1.10-SNAPSHOT:

notable changes:
- compiled against 1.15.2
- created wiki
- added blacklisted types
- changed recommended version to 1.15, as it should work perfectly fine.

1.9-SNAPSHOT
- Added min and max level in settings.
- changed the level generator method
- upped settings version to 6
- changed plugin.yml website to spigot page

1.8-SNAPSHOT
- updater working.


1.7-SNAPSHOT
insignificant stuff:
- plugin.yml adjustment
- recommendedSettingsVer moved to loadFiles()
important stuff:
- added nametag to settings
- added bStats metrics
- upped settings version
- released to spigotmc!

1.6-SNAPSHOT
- added update checker class.
- small plugin.yml adjustment
- small settings.yml adjustment

1.5-SNAPSHOT
- added 0.5 to default attack damage. settings value stacks with it.
- adjusted code comments.
- adjusted command /levelledmobs.
- removed messages.yml and data.json. they're not needed yet.

1.4-SNAPSHOT
- only hostiles get movement speed changed. otherwise players can hunt level 10 horses and fly over the hills and far away
- adjusted default values
- upped settings ver to 3

1.3-SNAPSHOT
- fixed settings ver
- fixed attack damage attribute error for passive/ranged entities

1.2-SNAPSHOT
- Added config version checker
- Upped settings ver to 2

1.1-SNAPSHOT
- Added levelled mobs function.
- Small updates to settings file.
- switched back to bukkit's normal logger. no onEnable/onDisable spam.

file changes:
- upped settings version to 8

other changes:
- added a debug function for development and bug checking. sends various information to OP players on entity attack.
- internal changes to how mobs levels are stored and named
- sets entity's health to their max health

1.0-SNAPSHOT
- Initial release. Base programming, doesn't include levelled mobs function.
```