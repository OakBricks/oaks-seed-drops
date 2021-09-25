package org.oakbricks.seeddrops;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import java.lang.Number;

@Config(name = OakSeedDrops.MOD_ID)
public class OakSeedDropsConfig implements ConfigData {
    @ConfigEntry.Gui.CollapsibleObject
    Rolls rolls = new Rolls();
    Chances chances = new Chances();
    
    static class Rolls {
        int carrot_rolls = 0;
        int potato_rolls = 0;
        int beetroot_seeds_rolls = 0;
        int pumpkin_seeds_rolls = 0;
        int melon_seeds_rolls = 0;
        int wheat_seeds_booster_rolls = 0;
    }
    static class Chances {
        float carrot_chances = 0;
        float potato_chances = 0;
        float beetroot_seeds_chances = 0;
        float pumpkin_seeds_chances = 0;
        float melon_seeds_chances = 0;
        float wheat_seeds_booster_chances = 0;
    }
}