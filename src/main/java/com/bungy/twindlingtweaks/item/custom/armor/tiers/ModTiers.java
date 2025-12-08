package com.bungy.twindlingtweaks.item.custom.armor.tiers;

import com.bungy.twindlingtweaks.block.ModBlocks;
import com.bungy.twindlingtweaks.item.ModItems;
import com.bungy.twindlingtweaks.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

import java.util.function.Supplier;

public class ModTiers {
    public static final Tier ALLUMINITE = new SimpleTier(
            ModTags.Blocks.INCORRECT_FOR_ALLUMINITE_TOOL, 1500, 8.4f, 0, 15,
            () -> Ingredient.of(ModItems.REINFORCED_ALLUMINITE_INGOT.get())
    ) {
    };

    public static final Tier OBSIDIAN = new SimpleTier(
            ModTags.Blocks.INCORRECT_FOR_OBSIDIAN_TOOL, 3000, 10f, 0, 30,
            () -> Ingredient.of(ModBlocks.REINFORCED_OBSIDIAN.get())
    );
}
