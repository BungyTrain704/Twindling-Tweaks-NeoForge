package com.austinplays.twindlingtweaks.item.custom.armor.tiers;

import com.austinplays.twindlingtweaks.util.ModTags;
import net.minecraft.world.item.ToolMaterial;

public class ModTiers {
    public static final ToolMaterial ALLUMINITE = new ToolMaterial(
            ModTags.Blocks.INCORRECT_FOR_ALLUMINITE_TOOL, 1500, 8.4f, 0, 15,
            ModTags.Items.ALLUMINITE_REPAIRABLE);

    public static final ToolMaterial OBSIDIAN = new ToolMaterial(
            ModTags.Blocks.INCORRECT_FOR_OBSIDIAN_TOOL, 3000, 10f, 0, 30,
            ModTags.Items.OBSIDIAN_REPAIRABLE);
}
