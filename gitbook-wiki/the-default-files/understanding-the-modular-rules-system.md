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

# 🌟 Understanding the Modular Rules System

LevelledMobs' `rules.yml` file allows you to craft a truly modular **Custom Rules** which either modify or extend the **Default Rule** that are applied to any and all mobs.\
\
The rules file is broken into three major sections: **Presets**, **Default Rule**, and **Custom Rules.**\
\
**Th**e main features come from _establishing the **default rule**_ which applies the base level of information to LevelledMobs, limiting it's scope from the start to specific worlds or entities, or to establish a base level of changes to mobs.\
An example of this might be to only allow all hostile mobs to become a levelled mob by default, and only in the Overworld.\
\
Then by _adding exceptions to the **default rule** in the form of **custom rules**_, you can create a conditioned set of checks which can apply changes to the **default rule**.\
An example of this might be to create a **custom rule** which checks for the Ender Dragon, then gives it a unique set of attribute modifiers compared to what other mobs would receive from the **default rule**; as well you could also configure it so that the dragon is given a special loot table to reward the slayer.\
\
Finally we created the **presets** section so that any frequently referenced conditions or settings can be quickly added to the **default** or **custom rule(s)** to help reduce the size of the file, though you do not have to reference or include the preset section at all so long as you have manually written in your conditions and settings where they're needed for how you'd like your server to be setup.



## What is the Default Rule?

As we said in the previous paragraphs, the **Default Rule** is how you tell LevelledMobs what core limitations you want to run the plugin by, as well as how you'd desire the majority of your mobs to be handled.&#x20;

By the default configuration, we cast a wide net and extend open arms to attempt to level every entity we can identify. We check for every entity, in every world, from any supported plugin, whether they are nametagged or a pet. If we can identify it, we will attempt to level them first according to the **Default Rule**. But you do not need to follow this method for your server.

You can make it so that LevelledMobs is entirely disabled in every world, for every mob, by default. That means for any entity you want to level you'd need to specify all the necessary information for that entity via the **Custom Rules** section.

You can also limit LevelledMobs to just a specific set of worlds, or to certain mobs or mob-groups. That way we don't interfere with your lobby or mining worlds. It's entirely up to you; though of course the default settings themselves have been play-tested and tweaked over four years of the plugins' development.



## What exactly does the default configuration do?
