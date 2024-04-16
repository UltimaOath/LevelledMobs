---
description: Describing the installation process.
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

# 🤖 Installation

Note: The difference between being **Compatible** and providing **Support**:\
\
If an option is **Supported**, that simply means that our staff will be willing to resolve an issue, bug, or question concerning that option should a solution be available. It means that we intend for our plugin to be **Supported**, or functional, for the listed option. It does not mean that we can provide an answer to every possible combination of issues which may be occurring on your server.\
\
If an option is **Compatible**, that simply relays to you the degree to which you should expect our plugin to function while on your server without issues or errors. We cannot account for every situation, but if an option is listed as having a high degree of **Compatibility**, then you should expect that plugin to function as intended on your server. If you are experiencing an issue with a listed compatible option, we recommend first investigating if other plugins may be causing an issue. You can do this by running your testing server with just LevelledMobs and see if the issue is reproducible. If it is not, then return more plugins to the server until you have discovered the incompatible plugin. If this does not resolve the issue, then you might suggest submitting the question to the [ArcanePlugins Support Discord](https://discord.gg/arcaneplugins-752310043214479462).



## Are you running a compatible server software?

<table data-full-width="false"><thead><tr><th width="128" align="center">Server</th><th width="139" align="center">Compatibility</th><th width="104" align="center">Support</th><th>Notes</th></tr></thead><tbody><tr><td align="center">PaperMC</td><td align="center"><img src="../.gitbook/assets/image (5).png" alt="" data-size="line"></td><td align="center"><img src="../.gitbook/assets/image (5).png" alt="" data-size="line"></td><td>* Recommended Software</td></tr><tr><td align="center">Folia</td><td align="center"><img src="../.gitbook/assets/image (5).png" alt="" data-size="line"></td><td align="center"><img src="../.gitbook/assets/image (5).png" alt="" data-size="line"></td><td></td></tr><tr><td align="center">PurpurMC</td><td align="center"><img src="../.gitbook/assets/image (5).png" alt="" data-size="line"></td><td align="center"><img src="../.gitbook/assets/image (5).png" alt="" data-size="line"></td><td></td></tr><tr><td align="center">SpigotMC</td><td align="center"><img src="../.gitbook/assets/image (6).png" alt="" data-size="line"></td><td align="center"><img src="../.gitbook/assets/image (5).png" alt="" data-size="line"></td><td>Limited compatibility; some optional features require PaperMC or a fork thereof.</td></tr><tr><td align="center">Mod or Hybrid Servers:<br><br>Mohist; Arclight; Cauldron; Magma; etc.</td><td align="center"><img src="../.gitbook/assets/image (6).png" alt="" data-size="line"></td><td align="center"><img src="../.gitbook/assets/image (7).png" alt="" data-size="line"></td><td><strong>The Bukkit API was never written to accommodate mods!</strong><br>These server software often require changing core functionality which plugin developers, including ourselves, rely on for their plugins to work. They also are prone to generating unreproducible, unpredictable, situation or user-specific bugs which are more or less unfixable.</td></tr></tbody></table>

In general, we aim to support **PaperMC** over any other plugin software. We do strive to provide support for **SpigotMC** as well, though some optional features are unavailable to those users.



## Are you running a supported Minecraft version?

<table data-full-width="false"><thead><tr><th width="181" align="center">Minecraft Version</th><th width="146" align="center">Compatibility</th><th width="101" align="center">Support</th><th>Notes</th></tr></thead><tbody><tr><td align="center">1.15 and before</td><td align="center"><img src="../.gitbook/assets/image (7).png" alt="" data-size="line"></td><td align="center"><img src="../.gitbook/assets/image (7).png" alt="" data-size="line"></td><td>Support and Compatibility dropped with <code>3.1.0 b473</code></td></tr><tr><td align="center">1.16 - 1.17</td><td align="center"><img src="../.gitbook/assets/image (6).png" alt="" data-size="line"></td><td align="center"><img src="../.gitbook/assets/image (7).png" alt="" data-size="line"></td><td>Support and Compatibility dropped with <code>4.0.0 b1</code></td></tr><tr><td align="center">1.18 - 1.19</td><td align="center"><img src="../.gitbook/assets/image (5).png" alt="" data-size="line"></td><td align="center"><img src="../.gitbook/assets/image (5).png" alt="" data-size="line"></td><td>* Support may be dropped in favor of 1.20+ in the future</td></tr><tr><td align="center">1.20 to latest</td><td align="center"><img src="../.gitbook/assets/image (5).png" alt="" data-size="line"></td><td align="center"><img src="../.gitbook/assets/image (5).png" alt="" data-size="line"></td><td></td></tr></tbody></table>

In general, we attempt to commit to a two-version layer of compatibility. That means whatever version of Minecraft is currently available, plus the previous two versions. For example, for **Minecraft 1.20** support, we intend to also provide support for **Minecraft 1.18-1.19** as well. This cannot always be the case, and sometimes there is compatibility beyond the two-versions. Users are always notified if there is a change worth noting.&#x20;



## Are you running the correct Java version?

We currently require users to be running **Java 17** or higher. As of **Minecraft 1.16**, servers have been required to have at least **Java 17**, so this should not be an issue. Our support staff will not assist in managing your Java installation, as there are many free tutorials available on the internet.&#x20;

As of [**Minecraft Snapshot 24w14a \[pre-1.20.5\]**](https://www.minecraft.net/en-us/article/minecraft-snapshot-24w14a), the base game requires **Java 21** or higher to function. This will almost certainly apply to the final release version. If you intend to use LevelledMobs 4, and intend to use 1.20+ Minecraft servers, then it's highly suggested you use **Java 21** or higher.

Our staff recommend using [**OpenJDK**](https://openjdk.org/). It provides an implementation of the Java Standard software for your Java installation requirements. It is both _free_ and _open-source_, and the code is derived directly from the GPL-licensed binaries which are also _open-source_.



## Did you install any plugins with known issues?

We have discovered over several years that there are certain specific and non-specific plugins which either fail entirely, cause inconsistencies with LevelledMobs, break native features we use or cause unintended effects. Some of these issues contain solutions, some do not. It is not for us to resolve every potential issue with every plugin on the internet; even though we make the effort all the time.



<table><thead><tr><th width="168">Plugin / *Type</th><th width="156" align="center">Issue Severity</th><th>Notes</th></tr></thead><tbody><tr><td><a href="https://www.spigotmc.org/resources/official-mcmmo-original-author-returns.64348/">mcMMO</a></td><td align="center"><img src="../.gitbook/assets/image (8).png" alt="" data-size="line"></td><td>This plugin contains it's own mob health bar function which should be disabled if you use LevelledMobs' nametag feature to prevent double nametags.</td></tr><tr><td><a href="https://www.spigotmc.org/resources/conxeptworks-legacy-model-engine-1-16-5-1-20-4.79477/">ModelEngine</a></td><td align="center"><img src="../.gitbook/assets/image (9).png" alt="" data-size="line"></td><td>This plugin will obscure the nametag we send to a mob. This is typically because the models used by this plugin do not contain a standard nametag position.  There are ways to create nametags within this plugin, and other than the missing nametags the entities are still being levelled according to the rules.</td></tr><tr><td>* Holograms</td><td align="center"><img src="../.gitbook/assets/image (9).png" alt="" data-size="line"></td><td>Plugins which send false holograms centered on mobs or within their custom-name field will interfere with our own nametag features. We utilize false packets to send nametag information directly to the players' client. Anything which interferes with this process may affect the nametags of entities.</td></tr><tr><td>* Stackers</td><td align="center"><img src="../.gitbook/assets/image (10).png" alt="" data-size="line"></td><td>Any plugin stacker which stacks mob entities together will simply not function with LevelledMobs. Most of the time, after the first mob is killed, one of two things occur: either LevelledMobs isn't informed of a new mob existing and so the new mob is not levelled, or the new mob will be reprocessed as if it's an entirely different entity because it's essentially spawning in a new mob under different conditions. <br>They do not provide any resource management improvements in todays' age, especially if using PaperMC.</td></tr></tbody></table>



## Did you install LevelledMobs in the proper location?

You might think it would be obvious, if you made it this far, that you should know where you install plugins you download for your Minecraft server. To be very clear: the LevelledMobs `.jar` file needs to be placed inside the `/plugins/` folder of your Minecraft server's root location. If your server installation doesn't have a `/plugins/` folder, then it has either not been installed properly or you are not running a compatible or supported server software. Please diagnose this issue yourself.



## \[Optional] Did you install any supported plugins?

We provide multiple optional features and functionalities through integrations with several different plugins. There are also some extended-feature plugins created by our own ArcanePlugins Developers which provide expanded abilities within CustomDrops and beyond. If you want to use these optional features, you need to install the latest version of the respective plugin.

<table data-full-width="false"><thead><tr><th width="220">Plugin</th><th>Accessible Features</th></tr></thead><tbody><tr><td>:: Official Addon ::<br><a href="https://www.spigotmc.org/resources/lm-items.102081/">LM Items</a></td><td>When using CustomDrops, when using this plugin, you may connect the CustomDrops system to many various popular item creation plugins. For more information, check out the wiki for LM Items.</td></tr><tr><td>:: Official Addon ::<br><a href="https://www.spigotmc.org/resources/armorplaceholders.108890/">Armor Placeholders</a></td><td>*Requires PlaceholderAPI<br>Armor Placeholders generates a numerical value based on the equipment the player is wearing, taking into account enchantments and damage, and scoring these items based on configurable values. Use with Player Level Modifier to bump the challenge based on the players' armor skills.</td></tr><tr><td>:: 3rd Party Support ::<br><a href="https://www.spigotmc.org/resources/mobhunting.3582/">MobHunting</a></td><td>Through MobHunting, you can earn more money from killing higher level mobs.</td></tr><tr><td>:: 3rd Party Support ::<br><a href="https://www.spigotmc.org/resources/money-from-mobs-1-12-1-17.79137/">Money From Mobs</a></td><td>Through Money From Mobs, you can earn more money from killing higher level mobs.</td></tr><tr><td><a href="https://www.spigotmc.org/resources/placeholderapi.6245/">PlaceholderAPI</a></td><td>Using PlaceholderAPI [PAPI] tags; useful for Player Level Modifier application.</td></tr><tr><td><a href="https://www.spigotmc.org/resources/nbt-api.7939/">NBT-API</a></td><td>When using the option <code>apply-settings:</code> <code>nbt-data:</code> to apply NBT data directly to mobs at the time of levelling.</td></tr><tr><td><a href="https://dev.bukkit.org/projects/worldguard">WorldGuard</a></td><td>When using the option <code>conditions:</code> <code>worldguard-regions</code> to condition against the WorldGuard region where the entity existed at the time of levelling.</td></tr></tbody></table>



## \[Optional] Did you install any integrated plugins?

These are plugins which we have written a special condition check for, whether **internal hard-coded support** for more complicated plugins, or **external hand-crafted support** through the new LevelledMobs4 `externalplugins.yml` file, which allows you to write your own 3rd party plugin support condition checks based on commonly used data storage and searching features.

<table><thead><tr><th width="204">Plugin</th><th width="164" align="center">Int/Ext Support</th><th>Notes</th></tr></thead><tbody><tr><td><a href="https://www.spigotmc.org/resources/%E2%9A%94-mythicmobs-free-version-%E2%96%BAthe-1-custom-mob-creator%E2%97%84.5702/">MythicMobs</a> <a data-footnote-ref href="#user-content-fn-1">**</a></td><td align="center">Internal</td><td></td></tr><tr><td><a href="https://www.spigotmc.org/resources/infernal-mobs.2156/">InfernalMobs</a></td><td align="center">External</td><td>Uses: <code>metadata</code>; Key: <code>infernalMetadata</code></td></tr><tr><td><a href="https://www.spigotmc.org/resources/%E2%9A%94elitemobs%E2%9A%94.40090/">EliteMobs</a></td><td align="center">Internal</td><td></td></tr><tr><td><a href="https://www.spigotmc.org/resources/shopkeepers.80756/">Shopkeepers</a></td><td align="center">External</td><td>Uses <code>metadata</code>; Key: <code>shopkeeper</code></td></tr><tr><td><a href="https://www.spigotmc.org/resources/citizens.13811/">Citizens</a> <a data-footnote-ref href="#user-content-fn-2">*</a></td><td align="center">Internal</td><td></td></tr><tr><td><a href="https://www.spigotmc.org/resources/30-sale-%E2%8F%B3-ecomobs-%E2%AD%95-create-custom-mobs-%E2%9C%85-custom-mob-ai-%E2%9C%A8-natural-spawns-custom-model-support.86576/">EcoMobs</a> <a data-footnote-ref href="#user-content-fn-3">*</a></td><td align="center">External</td><td>Uses <code>PDC</code>; Key: <code>boss</code></td></tr><tr><td><a href="https://www.spigotmc.org/resources/simplepets.100106/">SimplePets</a> <a data-footnote-ref href="#user-content-fn-4">*</a></td><td align="center">Internal</td><td></td></tr><tr><td><a href="https://www.spigotmc.org/resources/blood-night-spice-up-your-nights.85095/">BloodNight</a></td><td align="center">External</td><td>Uses <code>PDC</code>; Key: <code>mobtype</code></td></tr></tbody></table>



## Everything good so far? Proceed to Errors and Running LM!

[^1]: Premium and Free Option available

[^2]: Premium only

[^3]: Premium only

[^4]: Premium only
