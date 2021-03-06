package me.lokka30.levelledmobs.rules;

import me.lokka30.levelledmobs.misc.Utils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Holds the values parsed from rules.yml used with the tiered
 * placeholder for nametags
 *
 * @author stumper66
 */
public class TieredColoringInfo implements Cloneable {
    public int minLevel;
    public int maxLevel;
    public String text;
    public boolean isDefault;

    public TieredColoringInfo(){}

    @NotNull
    public static TieredColoringInfo createDefault(final @NotNull String value){
        TieredColoringInfo coloringInfo = new TieredColoringInfo();
        coloringInfo.isDefault = true;
        coloringInfo.text = value;

        return coloringInfo;
    }

    @Nullable
    public static TieredColoringInfo createFromString(final @NotNull String key, final @NotNull String value){
        final String[] numbers = key.split("-");
        if (numbers.length != 2) {
            Utils.logger.warning("Invalid tiered coloring key: " + key);
            return null;
        }

        TieredColoringInfo coloringInfo = new TieredColoringInfo();

        for (int i = 0; i < 2; i++){
            final String num = numbers[i].trim();
            if (!Utils.isInteger(num)){
                Utils.logger.warning("Invalid number in tiered coloring key: " + key);
                return null;
            }

            if (i == 0) coloringInfo.minLevel = Integer.parseInt(num);
            else coloringInfo.maxLevel = Integer.parseInt(num);
        }

        coloringInfo.text = value;

        return coloringInfo;
    }

    public String toString(){
        if (isDefault)
            return this.text + "default&r";
        else
            return String.format("%s%s-%s&r", this.text, this.minLevel, this.maxLevel);
    }

    public TieredColoringInfo cloneItem() {
        TieredColoringInfo copy = null;
        try {
            copy = (TieredColoringInfo) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return copy;
    }
}
