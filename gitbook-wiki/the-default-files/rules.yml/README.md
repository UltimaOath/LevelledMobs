# 🌟 rules.yml

The **Rules** file allows you to craft truly modular **Custom Rules** which either modify or extend the **Default Rule** which is applied at the start of LevelledMobs' processing cycles.

The file is broken into three major sections: **Presets**, **Default Rule**, and **Custom Rules**.&#x20;

This documentation is meant to provide a general understanding of each of these sections.



## Modular Options

The entire premise of LevelledMobs3+ has been it's use of a _modular option_ system consisting of three main components: **Conditions**, **Strategies**, and **Settings**. Each of these **Modular Options** are documented in their own sections. The premise behind how LevelledMobs functions is that you instruct how it will level mobs with a baseline setup established through the **Default Rule**.

These instructions are given in the form of _conditions_, _strategies_, and _settings_. You need to first **Condition** what LevelledMobs would consider a valid target. This might including limiting the _worlds_ or _entities_ which are affected, or targeting mobs from specific external plugins.

Then you should establish your **Settings**, or how you want LevelledMobs to modify these mobs. This typically includes a max level, nametag, custom drops, etc.

Finally, you need to establish your **Strategy**, which will provide LevelledMobs the tools to determine how to assign a level to the mob to get the process of attribute and equipment modifications rolling.&#x20;



## Presets

LevelledMobs allows you to craft certain sets of configuration options into reusable sets known as **Presets**. These **Presets** can be applied within either the **Default Rule** or any **Custom Rules** utilizing the `use-preset:` configuration option.

Here is an sample of the **Presets** section of the config, including all potential pieces of the preset, as it is formatted within the `rules.yml`.

{% code title="rules.yml" overflow="wrap" %}
```yaml
presets:
  preset-Name:
    name: 'Preset Name or Description'
    conditions: 
      x: 
    strategies: 
      x:
    settings: 
      x: 
```
{% endcode %}

The `presets:` section of the `rules.yml` covers the upper third of the file, and we use this section by default to populate many of the **Default Rule** and **Custom Rules**. This area is meant to be an aid in preventing duplicate configration options being applied in a similar but redundant way over multiple **Custom Rules**. You do not need to use the **Presets**, but it's highly recommended and it gives you an easy to reference area for over 90% of our features which are included out-of-the-box.&#x20;

Referencing the code above:

<table data-header-hidden><thead><tr><th width="206"></th><th></th></tr></thead><tbody><tr><td><code>presets:</code></td><td>The start of the <strong>Presets</strong> section of the file.</td></tr><tr><td><code>preset-Name:</code></td><td>The unique name of the <em>preset</em>, to be referenced in <code>use-preset:</code>.</td></tr><tr><td><code>name:</code></td><td>The unique description or name of the <em>preset</em>, only used for debug.</td></tr><tr><td><code>conditions:</code><br><code>strategies:</code><br><code>settings:</code></td><td>The possible options which can be included as part of the <em>preset</em>. Any one or combination of these <strong>Modular Options</strong> are acceptable pieces of any <em>preset</em>. </td></tr><tr><td><code>x:</code></td><td>Any sub-setting of the respective <strong>Modular Options</strong>. </td></tr></tbody></table>

You can apply a **Preset** to either the **Default Rule** or to any **Custom Rule** via the `use-preset:` configuration option. Below are samples of both usages:

<pre class="language-yaml" data-overflow="wrap"><code class="lang-yaml"><strong>default-rule:
</strong>  use-preset:
    - presetName
    - otherPresetName  
<strong>
</strong><strong>custom-rules:
</strong>  - enabled: true
    name: 'Sample of Custom Rule Presets'
    use-preset: presetName, otherPresetName
</code></pre>



## Default Rule

LevelledMobs requires the **Default Rule** to be populated with certain minimal information in order to have a minimum amount of functionality. By default, we use the **Presets** system to populate many of these options. The plugin needs to know what _world_ and what _mobs_ the plugin can function on; by default if no _world_ or _mob_ is specified, then the system will presume it does not have access to any _world_ or _mob_, effectively disabling it.

The second necessary information would be at least one enabled _levelling strategy_. This will inform LevelledMobs how it will calculate the level output for each mob.

The final necessary information would be the min-level (suggested to be `1`) and max-level of the mob and any attribute-modifiers that would apply.

There are several other optional but suggested features that we encourage you to have enabled by default, such as some form of nametag or the Custom Drops system.

Here is a sample of what a **Default Rule** might look like with all the minimum information populated:

{% code overflow="wrap" %}
```yaml
default-rule:
  conditions:
    worlds:
      included-list: ['*']
    entities:
      included-list: ['*']
  strategies:
    weighted-random: true
  settings:
    minLevel: 1
    maxLevel: 25
    attribute-modifier:
      max-health: 5.0
      movement-speed: 0.15
      attack-damage: 2.25
      item-drop: 3
      xp-drop: 5
    nametag: '&8&l༺ &f%displayname%&8 | &f%entity-health-rounded% &8&l༻'
```
{% endcode %}



## Custom Rules

LevelledMobs comes out-of-the-box with several **Custom Rules** which were enabled by default.

This plugin has many years of player-tested and developer experiences under it's belt, allowing us to craft a configuration which casts the widest net from the start in terms of challenge spread and feature-set. Some of the default custom rules are designed to reduce the challenge of certain mobs that are themselves challenging even under vanilla conditions, or to customize the boss and mini-boss type mobs, or to monitor mob farming and reduce boosted drops accordingly. All of these tests are done under Minecraft's Normal difficulty under average server conditions.

Here is a sample of what any **Custom Rules** might look like with the all possible options:

{% code overflow="wrap" %}
```yaml
custom-rules:
  - enabled: true
    name: ''
    use-preset: 
    conditions: 
      x:
    strategies: 
      x: 
    settings:
      x:  
```
{% endcode %}



Referencing the code above:

<table data-header-hidden><thead><tr><th width="206"></th><th></th></tr></thead><tbody><tr><td><code>custom-rules:</code></td><td>The start of the <strong>Custom Rules</strong> section of the file.</td></tr><tr><td><code>- enabled:</code></td><td>Marks the start of a new <strong>Custom Rule</strong>.<br>Allows for a rule to be enabled or disabled quickly.</td></tr><tr><td><code>name:</code></td><td>The unique description or name of the <em>custom rule</em>, only used for debug.</td></tr><tr><td><code>use-preset:</code></td><td>Include any <em>preset</em> of the <strong>Presets</strong> section.</td></tr><tr><td><code>conditions:</code><br><code>strategies:</code><br><code>settings:</code></td><td>The possible options which can be included as part of the <em>preset</em>. Any one or combination of these <strong>Modular Options</strong> are acceptable pieces of any <em>preset</em>. </td></tr><tr><td><code>x:</code></td><td>Any sub-setting of the respective <strong>Modular Options</strong>. </td></tr></tbody></table>



## Included and Excluded Lists

Several **Modular Option Conditions** can be expressed by using various _included_ and _excluded_ list or group options.

The sample below represents all possible list options:

{% code overflow="wrap" %}
```yaml
conditions:
  x: 
    included-group: ['']
    included-list: ['']
    excluded-group: ['']
    excluded-list: ['']
    merge: false
```
{% endcode %}

These list options are fairly simple to read. You can specify either one _included list_ or _excluded list_ and one _included group_ or _excluded groups_ when using the lists (only `entities:` and `biomes:` accept _group_ type lists).

If you use both `included-list:` and `excluded-list:` as part of the same `conditions:` check, then the `included-list:` will be read and `excluded-list:` will be ignored, as only listening to the _included list_ is more explicit. Below are several examples of to use a list-option:



**Example:** If you want the Condition to check whether an entity is a zombie, husk, or skeleton, you would use the `included-list:`, meaning the list will only allow those which you have approved to meet the Condition.

{% code overflow="wrap" %}
```yaml
conditions:
  entities:
    included-list: ['ZOMBIE', 'HUSK', 'SKELETON']
```
{% endcode %}



**Example:** If you want the Condition to apply to all worlds, except for the default world\_the\_end, then you would use `excluded-list:`, meaning the list will allow all worlds except for the world you excluded from meeting the Condition.

{% code overflow="wrap" %}
```yaml
conditions:
  worlds:
    excluded-list: ['world_the_end']
```
{% endcode %}



**Example:** If you want the Condition to apply to the `all_passive_mobs` group, but want to skip the birds, the bees, donkeys, and mules, you would use a combination of `includeded-groups:`, `excluded-groups:`, and `excluded-list:`.\
First you would allow the all passive mobs group to meet the Condition check, then remove the all flying mobs group to cover the birds and bees, then you would remove the individual entities of the donkeys and mules.

{% code overflow="wrap" %}
```yaml
conditions:
  entities:
    included-groups: ['all_passive_mobs']
    excluded-groups: ['all_flying_mobs']
    excluded-list: ['DONKEY', 'MULE']
```
{% endcode %}



You can also include `merge: true` alongside any listed entry, which would mean that the custom rule will accept any other `conditions:` of the same defined type from the `default-rule:` as a part of the acceptable conditions. It will also accept any prior custom rule's `conditions:` of the same defined type where the same entity successfully took on that rules' settings before proceeding.

This essentially means that any list option which uses `merge: true` is taking the `conditions:` set for that setting in the rule, as well as any previously successful application of that condition on the same entity, and combine the list of `included-list:` and `excluded-list:` options into one larger list. This is a more advanced-user option and not recommended for the average user.

