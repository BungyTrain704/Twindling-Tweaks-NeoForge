package com.bungy.twindlingtweaks.util;

import com.bungy.twindlingtweaks.TwindlingTweaks;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {
    public static final WoodType RED_MAPLE = WoodType.register(new WoodType(TwindlingTweaks.MOD_ID + ":red_maple", BlockSetType.OAK));
    public static final WoodType CATALPA = WoodType.register(new WoodType(TwindlingTweaks.MOD_ID + ":catalpa", BlockSetType.OAK));
}