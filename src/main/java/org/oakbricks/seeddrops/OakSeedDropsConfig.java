package org.oakbricks.seeddrops;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = OakSeedDrops.MOD_ID)
class OakSeedDropsConfig implements ConfigData {
    
    @ConfigEntry.Gui.CollapsibleObject
    InnerStuff drops = new InnerStuff();
    
    static class InnerStuff {
        int carrot_rolls = 0;
        int potato_rolls = 0;
        int beetroot_seeds_rolls = 0;
        int pumpkin_seeds_rolls = 0;
        int melon_seeds_rolls = 0;
        int wheat_seeds_booster_rolls = 0;
    }
}