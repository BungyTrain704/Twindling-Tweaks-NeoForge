package com.austinplays.twindlingtweaks.datagen;

import com.austinplays.twindlingtweaks.TwindlingTweaks;
import com.austinplays.twindlingtweaks.block.ModBlocks;
import com.austinplays.twindlingtweaks.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;

import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(
            PackOutput output,
            CompletableFuture<HolderLookup.Provider> lookupProvider,
            ExistingFileHelper existingFileHelper
    ) {
        super(output, lookupProvider, TwindlingTweaks.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ALLUMINITE_BLOCK.get(),
                        ModBlocks.RAW_ALLUMINITE_BLOCK.get(),
                        ModBlocks.ALLUMINITE_ORE.get(),
                        ModBlocks.DEEPSLATE_ALLUMINITE_ORE.get(),
                        ModBlocks.LUMINIUM_ORE.get(),
                        ModBlocks.DEEPSLATE_LUMINIUM_ORE.get(),
                        ModBlocks.MUD_ORE.get(),
                        ModBlocks.DEEPSLATE_MUD_ORE.get(),
                        ModBlocks.LUMINIUM_BLOCK.get(),
                        ModBlocks.RAW_LUMINIUM_BLOCK.get(),
                        ModBlocks.CRUSHER.get(),
                        ModBlocks.FILTERER.get(),
                        ModBlocks.OBSIDIAN_FORGER.get(),
                        ModBlocks.REINFORCED_OBSIDIAN.get(),
                        ModBlocks.SUGAR_ORE.get(),
                        ModBlocks.DEEPSLATE_SUGAR_ORE.get(),
                        ModBlocks.SALT_ORE.get(),
                        ModBlocks.DEEPSLATE_SALT_ORE.get(),
                        ModBlocks.COMPRESSED_MUD_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.UNFILTERED_SUGAR_BLOCK.get(),
                        ModBlocks.SUGAR_BLOCK.get(),
                        ModBlocks.DRIED_MUD_BLOCK.get(),
                        ModBlocks.MUD_BLOCK.get(),
                        ModBlocks.SPEEDY_FARMLAND.get(),
                        ModBlocks.BLUE_DIRT.get(),
                        ModBlocks.BLUE_DIRT_PATH.get(),
                        ModBlocks.FIERY_FARMLAND.get(),
                        ModBlocks.RED_DIRT.get(),
                        ModBlocks.RED_DIRT_PATH.get(),
                        ModBlocks.TWINDLING_TWEAKS_FARMLAND.get(),
                        ModBlocks.ALLUMIN_LUMINIUM_DIRT.get(),
                        ModBlocks.ALLUMIN_LUMINIUM_DIRT_PATH.get(),
                        ModBlocks.FLASH_FARMLAND.get(),
                        ModBlocks.YELLOW_DIRT.get(),
                        ModBlocks.YELLOW_DIRT_PATH.get(),
                        ModBlocks.COARSE_DIRT_PATH.get(),
                        ModBlocks.ROOTED_DIRT_PATH.get(),
                        ModBlocks.SOUL_SAND_PATH.get(),
                        ModBlocks.SOUL_SOIL_PATH.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.MUD_DOOR.get(),
                        ModBlocks.MUD_TRAPDOOR.get(),
                        ModBlocks.CATALPA_LOG.get(),
                        ModBlocks.STRIPPED_CATALPA_LOG.get(),
                        ModBlocks.CATALPA_WOOD.get(),
                        ModBlocks.STRIPPED_CATALPA_WOOD.get(),
                        ModBlocks.CATALPA_DOOR.get(),
                        ModBlocks.CATALPA_TRAPDOOR.get(),
                        ModBlocks.CATALPA_FENCE.get(),
                        ModBlocks.CATALPA_FENCE_GATE.get(),
                        ModBlocks.CATALPA_SIGN.get(),
                        ModBlocks.CATALPA_WALL_SIGN.get(),
                        ModBlocks.CATALPA_HANGING_SIGN.get(),
                        ModBlocks.CATALPA_WALL_HANGING_SIGN.get(),
                        ModBlocks.CATALPA_BUTTON.get(),
                        ModBlocks.CATALPA_PRESSURE_PLATE.get(),
                        ModBlocks.CATALPA_STAIRS.get(),
                        ModBlocks.CATALPA_SLAB.get(),
                        ModBlocks.RED_MAPLE_LOG.get(),
                        ModBlocks.STRIPPED_RED_MAPLE_LOG.get(),
                        ModBlocks.RED_MAPLE_WOOD.get(),
                        ModBlocks.STRIPPED_RED_MAPLE_WOOD.get(),
                        ModBlocks.RED_MAPLE_DOOR.get(),
                        ModBlocks.RED_MAPLE_TRAPDOOR.get(),
                        ModBlocks.RED_MAPLE_FENCE.get(),
                        ModBlocks.RED_MAPLE_FENCE_GATE.get(),
                        ModBlocks.RED_MAPLE_BUTTON.get(),
                        ModBlocks.RED_MAPLE_PRESSURE_PLATE.get(),
                        ModBlocks.RED_MAPLE_STAIRS.get(),
                        ModBlocks.RED_MAPLE_SLAB.get(),
                        ModBlocks.RED_MAPLE_SIGN.get(),
                        ModBlocks.RED_MAPLE_WALL_SIGN.get(),
                        ModBlocks.RED_MAPLE_HANGING_SIGN.get(),
                        ModBlocks.RED_MAPLE_WALL_HANGING_SIGN.get(),
                        ModBlocks.PASTEURIZER.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.SALT_ORE.get(),
                        ModBlocks.DEEPSLATE_SALT_ORE.get(),
                        ModBlocks.MUD_ORE.get(),
                        ModBlocks.DEEPSLATE_MUD_ORE.get(),
                        ModBlocks.SUGAR_ORE.get(),
                        ModBlocks.DEEPSLATE_SUGAR_ORE.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ALLUMINITE_BLOCK.get(),
                        ModBlocks.RAW_ALLUMINITE_BLOCK.get(),
                        ModBlocks.ALLUMINITE_ORE.get(),
                        ModBlocks.DEEPSLATE_ALLUMINITE_ORE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.OBSIDIAN_FORGER.get(),
                        ModBlocks.REINFORCED_OBSIDIAN.get());

        this.tag(ModTags.Blocks.NEEDS_OBSIDIAN_TOOL)
                .add(ModBlocks.LUMINIUM_BLOCK.get(),
                        ModBlocks.RAW_LUMINIUM_BLOCK.get(),
                        ModBlocks.LUMINIUM_ORE.get(),
                        ModBlocks.DEEPSLATE_LUMINIUM_ORE.get());

        this.tag(ModTags.Blocks.INCORRECT_FOR_OBSIDIAN_TOOL)
                .remove(ModTags.Blocks.INCORRECT_FOR_OBSIDIAN_TOOL);

        this.tag(Tags.Blocks.OBSIDIANS)
                .add(ModBlocks.REINFORCED_OBSIDIAN.get());

        this.tag(Tags.Blocks.OBSIDIANS_NORMAL)
                .add(ModBlocks.REINFORCED_OBSIDIAN.get());

        this.tag(Tags.Blocks.STRIPPED_LOGS)
                .add(ModBlocks.STRIPPED_CATALPA_LOG.get(),
                        ModBlocks.STRIPPED_RED_MAPLE_LOG.get());

        this.tag(Tags.Blocks.STRIPPED_WOODS)
                .add(ModBlocks.STRIPPED_CATALPA_WOOD.get(),
                        ModBlocks.STRIPPED_RED_MAPLE_WOOD.get());

        this.tag(Tags.Blocks.FENCES)
                .add(ModBlocks.CATALPA_FENCE.get(),
                        ModBlocks.RED_MAPLE_FENCE.get());

        this.tag(Tags.Blocks.FENCES_WOODEN)
                .add(ModBlocks.CATALPA_FENCE.get(),
                        ModBlocks.RED_MAPLE_FENCE.get());

        this.tag(Tags.Blocks.FENCE_GATES)
                .add(ModBlocks.CATALPA_FENCE_GATE.get(),
                        ModBlocks.RED_MAPLE_FENCE_GATE.get());

        this.tag(Tags.Blocks.FENCE_GATES_WOODEN)
                .add(ModBlocks.CATALPA_FENCE_GATE.get(),
                        ModBlocks.RED_MAPLE_FENCE_GATE.get());

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.CATALPA_FENCE.get(),
                        ModBlocks.RED_MAPLE_FENCE.get());

        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.CATALPA_FENCE_GATE.get(),
                        ModBlocks.RED_MAPLE_FENCE_GATE.get());

        this.tag(BlockTags.DOORS)
                .add(ModBlocks.CATALPA_DOOR.get(),
                        ModBlocks.RED_MAPLE_DOOR.get(),
                        ModBlocks.MUD_DOOR.get());

        this.tag(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.CATALPA_DOOR.get(),
                        ModBlocks.RED_MAPLE_DOOR.get());

        this.tag(BlockTags.MOB_INTERACTABLE_DOORS)
                .add(ModBlocks.CATALPA_DOOR.get(),
                        ModBlocks.RED_MAPLE_DOOR.get(),
                        ModBlocks.MUD_DOOR.get());

        this.tag(BlockTags.TRAPDOORS)
                .add(ModBlocks.CATALPA_TRAPDOOR.get(),
                        ModBlocks.RED_MAPLE_TRAPDOOR.get(),
                        ModBlocks.MUD_TRAPDOOR.get());

        this.tag(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.CATALPA_TRAPDOOR.get(),
                        ModBlocks.RED_MAPLE_TRAPDOOR.get());

        this.tag(BlockTags.BUTTONS)
                .add(ModBlocks.CATALPA_BUTTON.get(),
                        ModBlocks.RED_MAPLE_BUTTON.get());

        this.tag(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.CATALPA_BUTTON.get(),
                        ModBlocks.RED_MAPLE_BUTTON.get());

        this.tag(BlockTags.STAIRS)
                .add(ModBlocks.CATALPA_STAIRS.get(),
                        ModBlocks.RED_MAPLE_STAIRS.get());

        this.tag(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.CATALPA_STAIRS.get(),
                        ModBlocks.RED_MAPLE_STAIRS.get());

        this.tag(BlockTags.SLABS)
                .add(ModBlocks.CATALPA_SLAB.get(),
                        ModBlocks.RED_MAPLE_SLAB.get());

        this.tag(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.CATALPA_STAIRS.get(),
                        ModBlocks.RED_MAPLE_STAIRS.get());

        this.tag(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.CATALPA_PRESSURE_PLATE.get(),
                        ModBlocks.RED_MAPLE_PRESSURE_PLATE.get());

        this.tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.CATALPA_PRESSURE_PLATE.get(),
                        ModBlocks.RED_MAPLE_PRESSURE_PLATE.get());

        this.tag(BlockTags.SIGNS)
                .add(ModBlocks.CATALPA_SIGN.get(),
                        ModBlocks.RED_MAPLE_SIGN.get());

        this.tag(BlockTags.STANDING_SIGNS)
                .add(ModBlocks.CATALPA_SIGN.get(),
                        ModBlocks.RED_MAPLE_SIGN.get());

        this.tag(BlockTags.WALL_SIGNS)
                .add(ModBlocks.CATALPA_WALL_SIGN.get(),
                        ModBlocks.RED_MAPLE_WALL_SIGN.get());

        this.tag(BlockTags.WALL_HANGING_SIGNS)
                .add(ModBlocks.CATALPA_WALL_HANGING_SIGN.get(),
                        ModBlocks.RED_MAPLE_WALL_HANGING_SIGN.get());

        this.tag(BlockTags.ALL_SIGNS)
                .add(ModBlocks.CATALPA_SIGN.get(),
                        ModBlocks.CATALPA_WALL_SIGN.get(),
                        ModBlocks.RED_MAPLE_SIGN.get(),
                        ModBlocks.RED_MAPLE_WALL_SIGN.get());

        this.tag(BlockTags.ALL_HANGING_SIGNS)
                .add(ModBlocks.CATALPA_HANGING_SIGN.get(),
                        ModBlocks.CATALPA_WALL_HANGING_SIGN.get(),
                        ModBlocks.RED_MAPLE_HANGING_SIGN.get(),
                        ModBlocks.RED_MAPLE_WALL_HANGING_SIGN.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.CATALPA_LOG.get(),
                        ModBlocks.CATALPA_WOOD.get(),
                        ModBlocks.STRIPPED_CATALPA_LOG.get(),
                        ModBlocks.STRIPPED_CATALPA_WOOD.get(),
                        ModBlocks.RED_MAPLE_LOG.get(),
                        ModBlocks.RED_MAPLE_WOOD.get(),
                        ModBlocks.STRIPPED_RED_MAPLE_LOG.get(),
                        ModBlocks.STRIPPED_RED_MAPLE_WOOD.get());

        this.tag(BlockTags.LOGS)
                .add(ModBlocks.CATALPA_LOG.get(),
                        ModBlocks.CATALPA_WOOD.get(),
                        ModBlocks.STRIPPED_CATALPA_LOG.get(),
                        ModBlocks.STRIPPED_CATALPA_WOOD.get(),
                        ModBlocks.RED_MAPLE_LOG.get(),
                        ModBlocks.RED_MAPLE_WOOD.get(),
                        ModBlocks.STRIPPED_RED_MAPLE_LOG.get(),
                        ModBlocks.STRIPPED_RED_MAPLE_WOOD.get());

        this.tag(BlockTags.OVERWORLD_NATURAL_LOGS)
                .add(ModBlocks.CATALPA_LOG.get(),
                        ModBlocks.RED_MAPLE_LOG.get());

        this.tag(BlockTags.LEAVES)
                .add(ModBlocks.CATALPA_LEAVES.get(),
                        ModBlocks.RED_MAPLE_LEAVES.get());

        this.tag(ModTags.Blocks.CATALPA_LOGS)
                .add(ModBlocks.CATALPA_LOG.get(),
                        ModBlocks.STRIPPED_CATALPA_LOG.get(),
                        ModBlocks.CATALPA_WOOD.get(),
                        ModBlocks.STRIPPED_CATALPA_WOOD.get());

        this.tag(ModTags.Blocks.RED_MAPLE_LOGS)
                .add(ModBlocks.RED_MAPLE_LOG.get(),
                        ModBlocks.STRIPPED_RED_MAPLE_LOG.get(),
                        ModBlocks.RED_MAPLE_WOOD.get(),
                        ModBlocks.STRIPPED_RED_MAPLE_WOOD.get());

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.CATALPA_PLANKS.get(),
                        ModBlocks.RED_MAPLE_PLANKS.get());

        this.tag(BlockTags.STONE_ORE_REPLACEABLES)
                .add(ModBlocks.ALLUMINITE_ORE.get(),
                        ModBlocks.LUMINIUM_ORE.get(),
                        ModBlocks.SUGAR_ORE.get(),
                        ModBlocks.SALT_ORE.get(),
                        ModBlocks.MUD_ORE.get());

        this.tag(BlockTags.DEEPSLATE_ORE_REPLACEABLES)
                .add(ModBlocks.DEEPSLATE_ALLUMINITE_ORE.get(),
                        ModBlocks.DEEPSLATE_LUMINIUM_ORE.get(),
                        ModBlocks.DEEPSLATE_SUGAR_ORE.get(),
                        ModBlocks.DEEPSLATE_SALT_ORE.get(),
                        ModBlocks.DEEPSLATE_MUD_ORE.get());

        this.tag(ModTags.Blocks.ALLUMINITE_ORES)
                .add(ModBlocks.ALLUMINITE_ORE.get(),
                        ModBlocks.DEEPSLATE_ALLUMINITE_ORE.get());

        this.tag(ModTags.Blocks.LUMINIUM_ORES)
                .add(ModBlocks.LUMINIUM_ORE.get(),
                        ModBlocks.DEEPSLATE_LUMINIUM_ORE.get());

        this.tag(ModTags.Blocks.SUGAR_ORES)
                .add(ModBlocks.SUGAR_ORE.get(),
                        ModBlocks.DEEPSLATE_SUGAR_ORE.get());

        this.tag(ModTags.Blocks.SALT_ORES)
                .add(ModBlocks.SALT_ORE.get(),
                        ModBlocks.DEEPSLATE_SALT_ORE.get());

        this.tag(ModTags.Blocks.MUD_ORES)
                .add(ModBlocks.MUD_ORE.get(),
                        ModBlocks.DEEPSLATE_MUD_ORE.get());

        this.tag(BlockTags.DIRT)
                .add(ModBlocks.BLUE_DIRT.get(),
                        ModBlocks.YELLOW_DIRT.get(),
                        ModBlocks.RED_DIRT.get(),
                        ModBlocks.ALLUMIN_LUMINIUM_DIRT.get());

        this.tag(BlockTags.FLOWERS)
                .add(ModBlocks.CATALPA_FLOWERS.get());
    }
}
