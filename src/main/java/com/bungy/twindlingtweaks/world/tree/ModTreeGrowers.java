package com.bungy.twindlingtweaks.world.tree;

import com.bungy.twindlingtweaks.TwindlingTweaks;
import com.bungy.twindlingtweaks.world.feature.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower CATALPA = new TreeGrower(TwindlingTweaks.MOD_ID + ":catalpa",
            Optional.empty(), Optional.of(ModConfiguredFeatures.CATALPA_KEY), Optional.empty());

    public static final TreeGrower RED_MAPLE = new TreeGrower(TwindlingTweaks.MOD_ID + ":red_maple",
            Optional.empty(), Optional.of(ModConfiguredFeatures.RED_MAPLE_KEY), Optional.empty());

    public static final TreeGrower BANANA = new TreeGrower(TwindlingTweaks.MOD_ID + ":banana",
            Optional.empty(), Optional.of(ModConfiguredFeatures.BANANA_KEY), Optional.empty());
}
