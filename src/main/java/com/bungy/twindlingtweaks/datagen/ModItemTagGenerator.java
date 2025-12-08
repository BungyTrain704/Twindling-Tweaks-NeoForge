package com.bungy.twindlingtweaks.datagen;

import com.bungy.twindlingtweaks.TwindlingTweaks;
import com.bungy.twindlingtweaks.block.ModBlocks;
import com.bungy.twindlingtweaks.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, TwindlingTweaks.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ALLUMINITE_HELMET.get(),
                        ModItems.ALLUMINITE_CHESTPLATE.get(),
                        ModItems.ALLUMINITE_LEGGINGS.get(),
                        ModItems.ALLUMINITE_BOOTS.get(),
                        ModItems.OBSIDIAN_HELMET.get(),
                        ModItems.OBSIDIAN_CHESTPLATE.get(),
                        ModItems.OBSIDIAN_LEGGINGS.get(),
                        ModItems.OBSIDIAN_BOOTS.get());

        this.tag(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ModItems.MYSTICAL_MUSIC_DISC.get());

        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.CATALPA_LOG.get().asItem())
                .add(ModBlocks.CATALPA_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_CATALPA_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_CATALPA_WOOD.get().asItem())
                .add(ModBlocks.RED_MAPLE_LOG.get().asItem())
                .add(ModBlocks.RED_MAPLE_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_RED_MAPLE_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_RED_MAPLE_WOOD.get().asItem());

        this.tag(ItemTags.LOGS)
                .add(ModBlocks.CATALPA_LOG.get().asItem())
                .add(ModBlocks.CATALPA_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_CATALPA_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_CATALPA_WOOD.get().asItem())
                .add(ModBlocks.RED_MAPLE_LOG.get().asItem())
                .add(ModBlocks.RED_MAPLE_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_RED_MAPLE_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_RED_MAPLE_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.CATALPA_PLANKS.get().asItem())
                .add(ModBlocks.RED_MAPLE_PLANKS.get().asItem());

        this.tag(ItemTags.DIRT)
                .add(ModBlocks.BLUE_DIRT.get().asItem())
                .add(ModBlocks.YELLOW_DIRT.get().asItem())
                .add(ModBlocks.RED_DIRT.get().asItem())
                .add(ModBlocks.ALLUMIN_LUMINIUM_DIRT.get().asItem());

        this.tag(ItemTags.SWORDS)
                .add(ModItems.ALLUMINITE_SWORD.get(),
                        ModItems.OBSIDIAN_SWORD.get());

        this.tag(ItemTags.AXES)
                .add(ModItems.ALLUMINITE_AXE.get(),
                        ModItems.OBSIDIAN_AXE.get());

        this.tag(ItemTags.PICKAXES)
                .add(ModItems.ALLUMINITE_PICKAXE.get(),
                        ModItems.OBSIDIAN_PICKAXE.get());

        this.tag(ItemTags.SHOVELS)
                .add(ModItems.ALLUMINITE_SHOVEL.get(),
                        ModItems.OBSIDIAN_SHOVEL.get());

        this.tag(ItemTags.HOES)
                .add(ModItems.ALLUMINITE_HOE.get(),
                        ModItems.OBSIDIAN_HOE.get());

        this.tag(ItemTags.FLOWERS)
                .add(ModBlocks.CATALPA_FLOWERS.get().asItem());
    }
}