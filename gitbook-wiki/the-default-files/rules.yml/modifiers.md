# Modifiers

<details>

<summary>Click to view a comprehensive list of all <strong>Modifiers</strong></summary>

{% code overflow="wrap" %}
```yaml
modifiers:
  random-variance-mod: 
  player-variable-mod:  
```
{% endcode %}

</details>

***

## Random Variance (To be replaced with Placeholder mechanic)

{% code overflow="wrap" %}
```yaml
modifiers:
  random-variance-mod: 0-3
```
{% endcode %}

Essentially a random number generator. Will produce a random number between the ranged values.

Internal-Use Placeholder: `%random-variance-mod%`

<table data-full-width="false"><thead><tr><th width="251.00000000000006">Configuration</th><th>Description</th></tr></thead><tbody><tr><td><code>random-variance-mod:</code></td><td>Generates a random value between a min and max range.</td></tr></tbody></table>



## Player Variable

{% code overflow="wrap" %}
```yaml
modifiers:
  player-variable-mod:
    player-variable: '%level%'
    player-variable-scale: 1.0`
    player-variable-tiers:
      '32-45': 9-17
      '24-31': 7-14
      '16-23': 5-11
      '8-15': 3-8
      '0-7': 1-5
      default: 1
    match-variable: false
    use-variable-as-max: false
    recheck-players: false
    decrease-level: true
    level-cap: 50
    preserve-entity: 60s
```
{% endcode %}



**Note:** This Modifier contains additional settings within the `settings.yml` file.&#x20;

More information.
