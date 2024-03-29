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
\scriptsize f(pre.result) = 
((((transition.y.height - mob.y.height) / y.height.period) * level.multiplier) * spawn.distance.level)
$$

$$
\footnotesize f(post.result) = 
round(pre.result) + spawn.distance.level
$$

<table data-full-width="false"><thead><tr><th width="251.00000000000006">Configuration</th><th>Description</th></tr></thead><tbody><tr><td><code>distance-from-origin:</code></td><td>Initiates the Distance-from-Origin Levelling Strategy.</td></tr><tr><td><code>origin-coordinates:</code></td><td>Initiates the section where you can specify the <code>x:</code> or <code>z:</code> coordinate of the center-point which is referenced by this <strong>Strategy</strong>.</td></tr><tr><td><code>buffer-distance:</code></td><td>Represents the buffer zone between the center-point coordinates and the number of blocks measured away from that center-point where the mobs will be the lowest level applied to them. Good for providing a safer initial zone.</td></tr><tr><td><code>ringed-tiers:</code></td><td>The rings formed by this Strategy are circular and concentric.<br>After the <code>buffer-distance</code> has been reached, a new measurement will take place from the edge of the <code>buffer-distance</code> ring for the number of blocks specified in this coordinate. For each ring extending out from the first <code>ringed-tiers</code> ring, the level value of mobs will be increased by one.</td></tr><tr><td><code>enable-height-modifier:</code></td><td>When set to <code>true</code>, enables the Blended Distance Modifier associated with the Distance-from-Origin Levelling Strategy.<br>This adds a Y-Height component when determining the distance from the center-point coordinates.<br>Changing to <code>false</code> will disable this feature, and all subsequent configuration options will be ignored.</td></tr><tr><td><code>transition-y-height:</code></td><td>The Y-Height coordinate where the Distance-from-Origin Levelling Strategy would apply exactly, and where the transition line between a level increase or decrease trend would occur if the Blended Distance Modifier is enabled.</td></tr><tr><td><code>y-height-period:</code></td><td>The number of blocks from the <code>transition-y-height</code> before a <code>level-multiplier</code> is applied.</td></tr><tr><td><code>level-multiplier:</code></td><td>The multiplier value applied to the expected Distance-from-Origin Levelling Strategy level value. The value is applied exponentially across each instance of the <code>y-height-period</code> in either direction of the <code>transition-y-height</code>.<br><strong>For example</strong>, a higher <code>y-height-period</code> value and lower <code>level-multiplier</code> would result in a slow buildup until you reach about half way to the maximum level, and then a sharper increase as you get further out.</td></tr><tr><td><code>scale-increase-downward:</code></td><td>When set to <code>true</code>, the effect of the Blended Distance Modifier will be so that the increases in levels are applied as the player ventures from the <code>transition-y-height</code> down into caves; while the level value would decrease as the player ventured into the mountains above the same Y-Height coordinate.<br>Changing to <code>false</code> will reverse the effect.</td></tr></tbody></table>



## Y-Coordinate

{% code overflow="wrap" %}
```yaml
strategies:
  y-coordinate:
    start-height: 100
    period: 0
    end-height: 20
```
{% endcode %}

This strategy considered the current Y-Height of the mob being processed and will provide them a level value based on that height value. The lowest level applied to the mob is from all blocks at the `start-height` and higher, while the highest level applies to the mob who is from all blocks at the `end-height` and lower. When the `period` value is any value other than zero, then the `end-height` is ignored and instead the level will move for every `period` blocks in the direction specified.

<table data-full-width="false"><thead><tr><th width="251.00000000000006">Configuration</th><th>Description</th></tr></thead><tbody><tr><td><code>y-coordinate:</code></td><td>Initiates the Y-Coordinate Levelling Strategy.</td></tr><tr><td><code>start-height:</code></td><td>The starting Y-Height coordinate, where the blocks from this height and higher are at the lowest level.</td></tr><tr><td><code>period:</code></td><td>The number of blocks from <code>start-height</code> where the level will increase per instance of the <code>period</code>. <code>end-height</code> is ignored.</td></tr><tr><td><code>end-height:</code></td><td>The ending Y-Height coordinate, where the blocks from this height and lower are at the highest level.</td></tr></tbody></table>

