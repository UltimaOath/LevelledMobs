# Modifiers

<details>

<summary>Click to view a comprehensive list of all <strong>Modifiers</strong></summary>

{% code overflow="wrap" %}
```yaml
modifiers:
  custom-formula: 
  player-variable-mod:  
```
{% endcode %}

</details>

***

## Custom Formula

{% code overflow="wrap" %}
```yaml
modifiers:
  custom:
    formula: '1 * %mob-lvl%'
  custom_uniqueName:
    formula: '1 + %mob-lvl%'
```
{% endcode %}

Allows for the creation of various `custom_` placeholders. Generate these placeholders by performing basic math functions combined with internal placeholders.

<table data-full-width="false"><thead><tr><th width="251.00000000000006">Configuration</th><th>Description</th></tr></thead><tbody><tr><td><code>custom:</code></td><td>The placeholder is populated by the name of the <code>custom_</code> modifier. For example, <code>custom_uniqueName</code> would produce the placeholder <code>%custom_uniqueName%</code>.</td></tr><tr><td><code>formula:</code></td><td>This is the field where basic math calculations can take place using internal-use placeholders.</td></tr></tbody></table>



## Player Variable

{% code overflow="wrap" %}
```yaml
modifiers:
  player-variable-mod:
    player-variable: '%level%'
    player-variable-scale: 1.0
    player-variable-tiers:
      '31-45': 3-7
      '16-30': 2-5
      '0-15': 1-3
      default: 1
    match-variable: false
    use-variable-as-max: false
    recheck-players: true
    decrease-level: true
    level-cap: 25
    preserve-entity: 5s
```
{% endcode %}



**Note:** This Modifier contains additional settings within the `settings.yml` file.&#x20;

The Player Variable Modifier allows you to establish predetermined outputs based on external use placeholders and a few internal-use placeholders.&#x20;

<table data-full-width="false"><thead><tr><th width="251.00000000000006">Configuration</th><th>Description</th></tr></thead><tbody><tr><td><code>random:</code></td><td>When set to <code>true</code>, enables the Random Levelling Strategy</td></tr></tbody></table>
