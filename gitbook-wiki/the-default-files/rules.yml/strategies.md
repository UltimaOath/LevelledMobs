# Strategies

<details>

<summary>Click to view a comprehensive list of all <strong>Strategies</strong></summary>

{% code overflow="wrap" %}
```yaml
strategies:
  random: 
  weighted-random: 
  distance-from-origin: 
  y-coodinate: 
```
{% endcode %}

</details>

***



## True Random

{% code overflow="wrap" %}
```yaml
strategies:
  random: true
```
{% endcode %}

Just as described, a truly random selection between the min-level and max-level.

<table data-full-width="false"><thead><tr><th width="251.00000000000006">Configuration</th><th>Description</th></tr></thead><tbody><tr><td><code>random:</code></td><td>When set to <code>true</code>, enables the Random Levelling Strategy</td></tr></tbody></table>



## Weighted Random

{% code overflow="wrap" %}
```yaml
strategies:
  weighted-random: true
# or
  weighted-random:
    1-10: 3
    11-30: 2
    31-50: 1
```
{% endcode %}

**Note:** You may simply set `weighted-random: true` and it will use the min-level and max-level to generate a weighted random, where the lowest levels are the most likely to appear, while the highest are least likely.

**Example:** The above weighted random will generate a list of numbers, using the 'weight' value listed on the right to increase or decrease the chance of the level being randomly selected.\
1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 8, 8, 9, 10

<table data-full-width="false"><thead><tr><th width="251.00000000000006">Configuration</th><th>Description</th></tr></thead><tbody><tr><td><code>weighted-random:</code></td><td>When set to <code>true</code>, enables the Weighted Random Levelling Strategy</td></tr><tr><td>Ex: <code>1-10: 3</code></td><td>The value on the left represents the possible applied level range; the value on the right represents the weight of that range of levels. The higher the weight, the more likely the range.</td></tr></tbody></table>



## Distance-from-Origin

{% code overflow="wrap" %}
```yaml
strategies:
  distance-from-origin:
    origin-coordinates:
      x: spawn
      z: spawn
    buffer-distance: 250
    ringed-tiers: 150
  # Y-Height Modifier
    enable-height-modifier: true
    transition-y-height: 62
    y-height-period: 10
    level-multiplier: 0.05
    scale-increase-downward: true
```
{% endcode %}

**Note**: When using the `enable-height-modifier:` feature, the settings which follow this configuration option are part of the same system. The system uses the following formula to derive the final applied level:



$$
\footnotesize f(pre.result) = 
round(pre.result) + spawn.distance.level
$$

<table data-full-width="false"><thead><tr><th width="251.00000000000006">Configuration</th><th>Description</th></tr></thead><tbody><tr><td><code>distance-from-origin:</code></td><td>When set to <code>true</code>, enables the Distance-from-Origin Levelling Strategy</td></tr><tr><td>Coming soon</td><td>Coming soon</td></tr></tbody></table>















