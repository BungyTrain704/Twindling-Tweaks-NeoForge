package com.austinplays.twindlingtweaks.item.custom.armor.tiers;

import com.austinplays.twindlingtweaks.block.ModBlocks;
import com.austinplays.twindlingtweaks.item.ModItems;
import com.austinplays.twindlingtweaks.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

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
