package com.bungy.twindlingtweaks.datagen;

import com.bungy.twindlingtweaks.TwindlingTweaks;
import com.bungy.twindlingtweaks.block.ModBlocks;
import com.bungy.twindlingtweaks.datagen.builder.CrusherRecipeBuilder;
import com.bungy.twindlingtweaks.datagen.builder.FiltererRecipeBuilder;
import com.bungy.twindlingtweaks.datagen.builder.ObsidianForgerRecipeBuilder;
import com.bungy.twindlingtweaks.datagen.builder.PasteurizerRecipeBuilder;
import com.bungy.twindlingtweaks.item.ModItems;
import com.bungy.twindlingtweaks.item.custom.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        generateVanillaCraftingRecipes(output);
        generateVanillaSmeltingRecipes(output);
        generateFiltererRecipes(output);
        generateCrusherRecipes(output);
        generateObsidianForgerRecipes(output);
        generatePasteurizerDummyRecipe(output);
    }

    private void generateVanillaCraftingRecipes(RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMPTY_CHARM.get())
                .pattern("IDI")
                .pattern("GAG")
                .pattern("IDI")
                .define('A', ModItems.ALLUMINITE_NUGGET.get())
                .define('I', Items.IRON_INGOT)
                .define('G', Items.GOLD_INGOT)
                .define('D', Items.DIAMOND)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ADVANCED_DIRT_PATH_CHARM.get())
                .pattern("LLL")
                .pattern("LCL")
                .pattern("LLL")
                .define('L', Items.LAPIS_LAZULI)
                .define('C', ModItems.BASIC_DIRT_PATH_CHARM.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BASIC_DIRT_CHARM.get())
                .pattern("DMD")
                .pattern("RCR")
                .pattern("DMD")
                .define('C', ModItems.EMPTY_CHARM.get())
                .define('D', Items.DIRT)
                .define('R', Items.ROOTED_DIRT)
                .define('M', ModBlocks.DRIED_MUD_BLOCK.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BLUE_DIRT_CHARM.get())
                .pattern("LLL")
                .pattern("DCD")
                .pattern("AAA")
                .define('C', ModItems.BASIC_DIRT_CHARM.get())
                .define('L', Blocks.LAPIS_BLOCK)
                .define('D', Items.DIAMOND)
                .define('A', ModItems.REINFORCED_ALLUMINITE_INGOT.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.YELLOW_DIRT_CHARM.get())
                .pattern("AHA")
                .pattern("PCB")
                .pattern("GLG")
                .define('C', ModItems.BLUE_DIRT_CHARM.get())
                .define('G', Blocks.GOLD_BLOCK)
                .define('A', Items.AMETHYST_SHARD)
                .define('H', Items.GOLDEN_HELMET)
                .define('P', Items.GOLDEN_CHESTPLATE)
                .define('L', Items.GOLDEN_LEGGINGS)
                .define('B', Items.GOLDEN_BOOTS)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RED_DIRT_CHARM.get())
                .pattern("RLR")
                .pattern("NCN")
                .pattern("RRR")
                .define('C', ModItems.YELLOW_DIRT_CHARM.get())
                .define('R', Blocks.REDSTONE_BLOCK)
                .define('N', Blocks.RED_NETHER_BRICKS)
                .define('L', ModItems.REINFORCED_LUMINIUM_GEM.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALLUMIN_LUMINIUM_DIRT_CHARM.get())
                .pattern("LBL")
                .pattern("LCL")
                .pattern("AAA")
                .define('C', ModItems.RED_DIRT_CHARM.get())
                .define('B', ModBlocks.LUMINIUM_BLOCK.get())
                .define('L', ModItems.REINFORCED_LUMINIUM_GEM.get())
                .define('A', ModItems.REINFORCED_ALLUMINITE_INGOT.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STONE_HAMMER.get())
                .pattern("RRR")
                .pattern("RSR")
                .pattern(" S ")
                .define('R', ItemTags.STONE_TOOL_MATERIALS)
                .define('S', Items.STICK)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.IRON_HAMMER.get())
                .pattern("III")
                .pattern("ISI")
                .pattern(" S ")
                .define('I', Items.IRON_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.DIAMOND_HAMMER.get())
                .pattern("DDD")
                .pattern("DSD")
                .pattern(" S ")
                .define('D', Items.DIAMOND)
                .define('S', Items.STICK)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.OBSIDIAN_HAMMER.get())
                .pattern("UUU")
                .pattern("RAR")
                .pattern(" A ")
                .define('U', ModItems.UNSTABLE_ALLUMINITE_INGOT.get())
                .define('R', ModBlocks.REINFORCED_OBSIDIAN.get())
                .define('A', ModItems.ALLUMINITE_ROD.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, Items.ENCHANTED_GOLDEN_APPLE)
                .pattern("GGG")
                .pattern("GAG")
                .pattern("GGG")
                .define('G', Blocks.GOLD_BLOCK)
                .define('A', Items.APPLE)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.LUMINIUM_APPLE.get())
                .pattern("###")
                .pattern("#-#")
                .pattern("###")
                .define('#', ModBlocks.LUMINIUM_BLOCK.get())
                .define('-', Items.GOLDEN_APPLE)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ORANGE_SEED_MILK.get())
                .requires(ModItems.ORANGE_SEED_POWDER.get())
                .requires(Items.MILK_BUCKET)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.IRON_INFUSED_MILK.get())
                .pattern("III")
                .pattern("IMI")
                .pattern("III")
                .define('I', ModItems.IRON_POWDER.get())
                .define('M', Items.MILK_BUCKET)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.DIAMOND_INFUSED_MILK.get())
                .pattern("DDD")
                .pattern("DMD")
                .pattern("DDD")
                .define('D', ModItems.DIAMOND_POWDER.get())
                .define('M', Items.MILK_BUCKET)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ALLUMINITE_SWORD.get())
                .pattern("A")
                .pattern("A")
                .pattern("R")
                .define('R', ModItems.ALLUMINITE_ROD.get())
                .define('A', ModItems.REINFORCED_ALLUMINITE_INGOT.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ALLUMINITE_AXE.get())
                .pattern("AA")
                .pattern("AR")
                .pattern(" R")
                .define('R', ModItems.ALLUMINITE_ROD.get())
                .define('A', ModItems.REINFORCED_ALLUMINITE_INGOT.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ALLUMINITE_PICKAXE.get())
                .pattern("AAA")
                .pattern(" R ")
                .pattern(" R ")
                .define('R', ModItems.ALLUMINITE_ROD.get())
                .define('A', ModItems.REINFORCED_ALLUMINITE_INGOT.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ALLUMINITE_SHOVEL.get())
                .pattern("A")
                .pattern("R")
                .pattern("R")
                .define('R', ModItems.ALLUMINITE_ROD.get())
                .define('A', ModItems.REINFORCED_ALLUMINITE_INGOT.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ALLUMINITE_HOE.get())
                .pattern("AA")
                .pattern(" R")
                .pattern(" R")
                .define('R', ModItems.ALLUMINITE_ROD.get())
                .define('A', ModItems.REINFORCED_ALLUMINITE_INGOT.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.OBSIDIAN_SWORD.get())
                .pattern("A")
                .pattern("A")
                .pattern("R")
                .define('R', Items.STICK)
                .define('A', ModBlocks.REINFORCED_OBSIDIAN.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.OBSIDIAN_AXE.get())
                .pattern("AA")
                .pattern("AR")
                .pattern(" R")
                .define('R', Items.STICK)
                .define('A', ModBlocks.REINFORCED_OBSIDIAN.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.OBSIDIAN_PICKAXE.get())
                .pattern("AAA")
                .pattern(" R ")
                .pattern(" R ")
                .define('R', Items.STICK)
                .define('A', ModBlocks.REINFORCED_OBSIDIAN.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.OBSIDIAN_SHOVEL.get())
                .pattern("A")
                .pattern("R")
                .pattern("R")
                .define('R', Items.STICK)
                .define('A', ModBlocks.REINFORCED_OBSIDIAN.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.OBSIDIAN_HOE.get())
                .pattern("AA")
                .pattern(" R")
                .pattern(" R")
                .define('R', Items.STICK)
                .define('A', ModBlocks.REINFORCED_OBSIDIAN.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.REINFORCED_ALLUMINITE_INGOT.get(), 2)
                .pattern("IAI")
                .pattern("AAA")
                .pattern("IAI")
                .define('I', Items.IRON_INGOT)
                .define('A', ModItems.ALLUMINITE_INGOT.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALLUMINITE_ROD.get(), 2)
                .pattern("AAA")
                .pattern("RSR")
                .pattern("AAA")
                .define('R', ModItems.REINFORCED_ALLUMINITE_INGOT.get())
                .define('S', Items.STICK)
                .define('A', ModItems.ALLUMINITE_ROD_SHARD.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALLUMINITE_ROD_SHARD.get(), 3)
                .pattern("III")
                .pattern("ISA")
                .pattern("AAA")
                .define('I', Items.IRON_INGOT)
                .define('S', Items.STICK)
                .define('A', ModItems.ALLUMINITE_INGOT.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COOKING_KNIFE.get())
                .pattern("I  ")
                .pattern(" I ")
                .pattern("  S")
                .define('I', Items.IRON_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MYSTICAL_DISC_FRAGMENT.get())
                .pattern("AAA")
                .pattern("ALA")
                .pattern("AAA")
                .define('A', ModItems.ALLUMINITE_NUGGET.get())
                .define('L', ModItems.REINFORCED_LUMINIUM_GEM.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MYSTICAL_MUSIC_DISC.get())
                .requires(ModItems.MYSTICAL_DISC_FRAGMENT.get(), 8)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MUD_DOOR.get(), 3)
                .pattern("DD")
                .pattern("MM")
                .pattern("DD")
                .define('D', ModItems.DRIED_MUD_BALL.get())
                .define('M', ModBlocks.MUD_BLOCK.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MUD_TRAPDOOR.get(), 3)
                .pattern("DMD")
                .pattern("DMD")
                .define('D', ModItems.DRIED_MUD_BALL.get())
                .define('M', ModBlocks.MUD_BLOCK.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        nineBlockStorageRecipes(output, ModBlocks.COMPRESSED_MUD_BLOCK.get(), ModItems.DRIED_MUD_BALL.get());

        nineBlockStorageRecipes(output, ModBlocks.RAW_ALLUMINITE_BLOCK.get(), ModItems.RAW_ALLUMINITE.get());
        nineBlockStorageRecipes(output, ModBlocks.ALLUMINITE_BLOCK.get(), ModItems.ALLUMINITE_INGOT.get());

        nineBlockStorageRecipes(output, ModBlocks.RAW_LUMINIUM_BLOCK.get(), ModItems.RAW_LUMINIUM.get());
        nineBlockStorageRecipes(output, ModBlocks.LUMINIUM_BLOCK.get(), ModItems.LUMINIUM_GEM.get());

        nineBlockStorageRecipes(output, ModBlocks.SUGAR_BLOCK.get(), Items.SUGAR);
        nineBlockStorageRecipes(output, ModBlocks.UNFILTERED_SUGAR_BLOCK.get(), ModItems.UNFILTERED_SUGAR.get());

        twoByTwoPacker(output, RecipeCategory.MISC, ModBlocks.MUD_BLOCK.get(), ModItems.MUD_BALL.get());
        twoByTwoPacker(output, RecipeCategory.MISC, ModBlocks.DRIED_MUD_BLOCK.get(), ModItems.DRIED_MUD_BALL.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RAW_LUMINIUM.get())
                .pattern("ADA")
                .pattern("LLL")
                .pattern("ALA")
                .define('L', ModItems.LUMINIUM_CHUNK.get())
                .define('D', Items.DIAMOND)
                .define('A', ModItems.ALLUMINITE_NUGGET.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.UNSTABLE_ALLUMINITE_INGOT.get())
                .pattern("LOL")
                .pattern("ORO")
                .pattern("LOL")
                .define('R', ModItems.REINFORCED_ALLUMINITE_INGOT.get())
                .define('L', ModItems.REINFORCED_LUMINIUM_GEM.get())
                .define('O', ModBlocks.REINFORCED_OBSIDIAN.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALLUMINITE_INGOT.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ALLUMINITE_NUGGET.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ALLUMINITE_NUGGET.get(), 9)
                .requires(ModItems.ALLUMINITE_INGOT.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_DIRT_PATH.get(), 6)
                .requires(ModBlocks.BLUE_DIRT.get())
                .requires(ModItems.BLUE_DIRT_PATH_CHARM.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.YELLOW_DIRT_PATH.get(), 6)
                .requires(ModBlocks.YELLOW_DIRT.get())
                .requires(ModItems.YELLOW_DIRT_PATH_CHARM.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_DIRT_PATH.get(), 6)
                .requires(ModBlocks.RED_DIRT.get())
                .requires(ModItems.RED_DIRT_PATH_CHARM.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ALLUMIN_LUMINIUM_DIRT_PATH.get(), 12)
                .requires(ModBlocks.ALLUMIN_LUMINIUM_DIRT.get())
                .requires(ModItems.ALLUMIN_LUMINIUM_DIRT_PATH_CHARM.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COARSE_DIRT_PATH.get(), 6)
                .requires(Blocks.COARSE_DIRT, 3)
                .requires(ModItems.BASIC_DIRT_PATH_CHARM.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ROOTED_DIRT_PATH.get(), 6)
                .requires(Blocks.ROOTED_DIRT, 3)
                .requires(ModItems.BASIC_DIRT_PATH_CHARM.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_SAND_PATH.get(), 9)
                .requires(Blocks.SOUL_SAND, 3)
                .requires(ModItems.ADVANCED_DIRT_PATH_CHARM.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_SOIL_PATH.get(), 9)
                .requires(Blocks.SOUL_SOIL, 3)
                .requires(ModItems.ADVANCED_DIRT_PATH_CHARM.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Blocks.DIRT_PATH, 6)
                .requires(Blocks.DIRT, 3)
                .requires(ModItems.BASIC_DIRT_PATH_CHARM.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_DIRT.get(), 4)
                .pattern(" A ")
                .pattern("DCD")
                .pattern(" A ")
                .define('C', ModItems.BLUE_DIRT_CHARM.get())
                .define('D', Items.DIAMOND)
                .define('A', ModItems.REINFORCED_ALLUMINITE_INGOT.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SPEEDY_FARMLAND.get())
                .pattern(" A ")
                .pattern("RBR")
                .pattern(" R ")
                .define('B', ModBlocks.BLUE_DIRT.get())
                .define('A', ModBlocks.ALLUMINITE_BLOCK.get())
                .define('R', ModItems.REINFORCED_ALLUMINITE_INGOT.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.YELLOW_DIRT.get(), 4)
                .pattern(" B ")
                .pattern("ICI")
                .pattern(" B ")
                .define('C', ModItems.YELLOW_DIRT_CHARM.get())
                .define('B', Blocks.GOLD_BLOCK)
                .define('I', Items.GOLD_INGOT)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FLASH_FARMLAND.get())
                .pattern(" I ")
                .pattern("GYG")
                .pattern(" G ")
                .define('Y', ModBlocks.YELLOW_DIRT.get())
                .define('I', Items.GOLD_INGOT)
                .define('G', Blocks.GOLD_BLOCK)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_DIRT.get(), 4)
                .pattern(" B ")
                .pattern("BCB")
                .pattern(" B ")
                .define('C', ModItems.RED_DIRT_CHARM.get())
                .define('B', Blocks.REDSTONE_BLOCK)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIERY_FARMLAND.get())
                .pattern(" R ")
                .pattern("NDN")
                .pattern(" R ")
                .define('D', ModBlocks.RED_DIRT.get())
                .define('R', Blocks.REDSTONE_BLOCK)
                .define('N', Blocks.RED_NETHER_BRICKS)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ALLUMIN_LUMINIUM_DIRT.get(), 6)
                .pattern(" R ")
                .pattern("BCB")
                .pattern(" R ")
                .define('C', ModItems.ALLUMIN_LUMINIUM_DIRT_CHARM.get())
                .define('B', ModBlocks.LUMINIUM_BLOCK.get())
                .define('R', ModItems.REINFORCED_LUMINIUM_GEM.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TWINDLING_TWEAKS_FARMLAND.get())
                .pattern(" A ")
                .pattern("LDL")
                .pattern(" A ")
                .define('D', ModBlocks.ALLUMIN_LUMINIUM_DIRT.get())
                .define('A', ModItems.REINFORCED_ALLUMINITE_INGOT.get())
                .define('L', ModBlocks.LUMINIUM_BLOCK.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_FORGER.get())
                .pattern("OCO")
                .pattern("CDC")
                .pattern("OCO")
                .define('D', Items.DIAMOND)
                .define('C', Blocks.CRYING_OBSIDIAN)
                .define('O', Blocks.OBSIDIAN)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FILTERER.get())
                .pattern("IPI")
                .pattern("PAP")
                .pattern("IPI")
                .define('P', ModBlocks.CATALPA_PLANKS.get())
                .define('I', Items.IRON_INGOT)
                .define('A', ModItems.REINFORCED_ALLUMINITE_INGOT.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRUSHER.get())
                .pattern("IOI")
                .pattern("GAG")
                .pattern("IOI")
                .define('A', ModItems.REINFORCED_ALLUMINITE_INGOT.get())
                .define('O', ModBlocks.REINFORCED_OBSIDIAN.get())
                .define('I', Blocks.IRON_BLOCK)
                .define('G', Blocks.GOLD_BLOCK)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PASTEURIZER.get())
                .pattern("RHR")
                .pattern("HCH")
                .pattern("RCR")
                .define('R', ModBlocks.RED_MAPLE_PLANKS.get())
                .define('H', Blocks.HAY_BLOCK)
                .define('C', Blocks.COAL_BLOCK)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.FRIED_EGG.get())
                .requires(Items.EGG)
                .requires(ModItems.VEGETABLE_OIL.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.STEAK_LETTUCE_SANDWICH.get())
                .requires(ModItems.LETTUCE.get())
                .requires(ModItems.BREAD_SLICE.get(), 2)
                .requires(ModItems.KETCHUP_BOTTLE.get())
                .requires(Items.COOKED_BEEF)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.TOASTED_STEAK_LETTUCE_SANDWICH.get())
                .requires(ModItems.LETTUCE.get())
                .requires(ModItems.TOAST.get(), 2)
                .requires(ModItems.KETCHUP_BOTTLE.get())
                .requires(Items.COOKED_BEEF)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.VEGAN_SANDWICH.get())
                .requires(ModItems.LETTUCE.get())
                .requires(ModItems.BREAD_SLICE.get(), 2)
                .requires(ModItems.KETCHUP_BOTTLE.get())
                .requires(ModItems.CUCUMBER.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.BANANA_SANDWICH.get())
                .requires(ModItems.BANANA.get(), 2)
                .requires(ModItems.BREAD_SLICE.get(), 2)
                .requires(ModItems.GOAT_BUTTER.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHEESE_MEAT_SANDWICH.get())
                .requires(ModItems.GOAT_CHEESE.get())
                .requires(ModItems.BREAD_SLICE.get(), 2)
                .requires(ModItems.GOAT_BUTTER.get())
                .requires(Items.COOKED_BEEF)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.MEATY_SANDWICH.get())
                .requires(Items.COOKED_PORKCHOP)
                .requires(ModItems.BREAD_SLICE.get(), 2)
                .requires(ModItems.KETCHUP_BOTTLE.get())
                .requires(Items.COOKED_BEEF)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.GOAT_CAKE_ITEM.get())
                .pattern("MMM")
                .pattern("SES")
                .pattern("WWW")
                .define('M', ModItems.GOAT_MILK.get())
                .define('S', ModBlocks.SUGAR_BLOCK.get())
                .define('W', Items.WHEAT)
                .define('E', Items.EGG)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.SALTED_POTATO_CHIPS.get())
                .pattern(" S ")
                .pattern("SPS")
                .pattern(" S ")
                .define('P', ModItems.POTATO_BITS.get())
                .define('S', ModItems.SALT.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SALAD_TOPPINGS.get())
                .requires(ModItems.LETTUCE.get())
                .requires(ModItems.TOMATO.get())
                .requires(ModItems.CUCUMBER.get())
                .requires(ModItems.CROUTON.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SALAD.get())
                .requires(Items.BOWL)
                .requires(ModItems.SALAD_TOPPINGS.get())
                .requires(ModItems.RANCH_BOTTLE.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SPECIAL_SALAD_TOPPINGS.get())
                .requires(ModItems.LETTUCE.get())
                .requires(ModItems.TOMATO.get())
                .requires(ModItems.ORANGE.get())
                .requires(ModItems.CROUTON.get())
                .requires(ModItems.CORN.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SPECIAL_SALAD.get())
                .requires(Items.BOWL)
                .requires(ModItems.SPECIAL_SALAD_TOPPINGS.get())
                .requires(ModItems.RANCH_BOTTLE.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SPRING_SALAD_TOPPINGS.get())
                .requires(ModItems.LETTUCE.get())
                .requires(ModItems.CROUTON.get())
                .requires(ModItems.TOMATO.get())
                .requires(ModItems.ORANGE.get())
                .requires(ModItems.BOILED_EGG.get())
                .requires(ModItems.BANANA.get())
                .requires(ModItems.BLUEBERRIES.get())
                .requires(ModItems.RASPBERRIES.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SPRING_SALAD.get())
                .requires(Items.BOWL)
                .requires(ModItems.SPRING_SALAD_TOPPINGS.get())
                .requires(ModItems.RANCH_BOTTLE.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.HEARTY_STEW.get())
                .requires(Items.BOWL)
                .requires(ModItems.IRON_INFUSED_MILK.get())
                .requires(Items.POTATO)
                .requires(Items.COOKED_BEEF)
                .requires(ModItems.SALT.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.BERRY_BOWL.get())
                .requires(ModItems.BLUEBERRIES.get())
                .requires(Items.BOWL)
                .requires(ModItems.RASPBERRIES.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.BERRY_TOAST.get())
                .requires(ModItems.BLUEBERRIES.get())
                .requires(ModItems.TOAST.get())
                .requires(ModItems.RASPBERRIES.get())
                .requires(ModItems.COOKING_KNIFE.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.RANCH_BOTTLE.get())
                .requires(Items.GLASS_BOTTLE)
                .requires(Items.MILK_BUCKET)
                .requires(Items.WHEAT_SEEDS)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.VEGETABLE_OIL.get())
                .requires(Items.GLASS_BOTTLE)
                .requires(ModItems.CRUSHED_TOMATO.get())
                .requires(ModItems.LETTUCE.get())
                .requires(ModItems.SALT.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CRUSHED_TOMATO_BOTTLE.get())
                .requires(Items.GLASS_BOTTLE)
                .requires(ModItems.CRUSHED_TOMATO.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SLICED_GOAT_CHEESE.get(), 3)
                .requires(ModItems.GOAT_CHEESE.get())
                .requires(ModItems.COOKING_KNIFE.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.BREAD_SLICE.get(), 8)
                .requires(Items.BREAD)
                .requires(ModItems.COOKING_KNIFE.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SALTED_RAW_BEEF.get())
                .requires(Items.BEEF)
                .requires(ModItems.SALT.get(), 2)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SALTED_RAW_CHICKEN.get())
                .requires(Items.CHICKEN)
                .requires(ModItems.SALT.get(), 2)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SALTED_RAW_COD.get())
                .requires(Items.COD)
                .requires(ModItems.SALT.get(), 2)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SALTED_RAW_MUTTON.get())
                .requires(Items.MUTTON)
                .requires(ModItems.SALT.get(), 2)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SALTED_RAW_PORKCHOP.get())
                .requires(Items.PORKCHOP)
                .requires(ModItems.SALT.get(), 2)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SALTED_RAW_RABBIT.get())
                .requires(Items.RABBIT)
                .requires(ModItems.SALT.get(), 2)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SALTED_RAW_SALMON.get())
                .requires(Items.SALMON)
                .requires(ModItems.SALT.get(), 2)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Blocks.CLAY, 6)
                .requires(Items.CLAY_BALL, 4)
                .requires(ModItems.BASIC_DIRT_CHARM.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Blocks.COARSE_DIRT, 10)
                .requires(Blocks.GRAVEL, 4)
                .requires(ModItems.BASIC_DIRT_CHARM.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Blocks.ROOTED_DIRT, 8)
                .requires(Blocks.MANGROVE_ROOTS)
                .requires(Blocks.DIRT, 3)
                .requires(ModItems.BASIC_DIRT_CHARM.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Blocks.MUD, 12)
                .requires(ModBlocks.MUD_BLOCK.get(), 3)
                .requires(ModBlocks.DRIED_MUD_BLOCK.get())
                .requires(ModItems.BASIC_DIRT_CHARM.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        woodenBoat(output, ModItems.CATALPA_BOAT.get(), ModBlocks.CATALPA_PLANKS.get());
        chestBoat(output, ModItems.CATALPA_CHEST_BOAT.get(), ModItems.CATALPA_BOAT.get());

        stairBuilder(ModBlocks.CATALPA_STAIRS.get(), Ingredient.of(ModBlocks.CATALPA_PLANKS)).group("catalpa")
                .unlockedBy("has_catalpa", has(ModBlocks.CATALPA_PLANKS)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CATALPA_SLAB.get(), ModBlocks.CATALPA_PLANKS.get());

        buttonBuilder(ModBlocks.CATALPA_BUTTON.get(), Ingredient.of(ModBlocks.CATALPA_PLANKS.get())).group("catalpa")
                .unlockedBy("has_catalpa", has(ModBlocks.CATALPA_PLANKS.get())).save(output);
        pressurePlate(output, ModBlocks.CATALPA_PRESSURE_PLATE.get(), ModBlocks.CATALPA_PLANKS.get());

        fenceBuilder(ModBlocks.CATALPA_FENCE.get(), Ingredient.of(ModBlocks.CATALPA_PLANKS.get())).group("catalpa")
                .unlockedBy("has_catalpa", has(ModBlocks.CATALPA_PLANKS.get())).save(output);
        fenceGateBuilder(ModBlocks.CATALPA_FENCE_GATE.get(), Ingredient.of(ModBlocks.CATALPA_PLANKS.get())).group("catalpa")
                .unlockedBy("has_catalpa", has(ModBlocks.CATALPA_PLANKS.get())).save(output);

        doorBuilder(ModBlocks.CATALPA_DOOR.get(), Ingredient.of(ModBlocks.CATALPA_PLANKS.get())).group("catalpa")
                .unlockedBy("has_catalpa", has(ModBlocks.CATALPA_PLANKS.get())).save(output);
        trapdoorBuilder(ModBlocks.CATALPA_TRAPDOOR.get(), Ingredient.of(ModBlocks.CATALPA_PLANKS.get())).group("catalpa")
                .unlockedBy("has_catalpa", has(ModBlocks.CATALPA_PLANKS.get())).save(output);

        planksFromLog(output, ModBlocks.CATALPA_PLANKS.get(), ModTags.Items.CATALPA_LOGS, 4);
        woodFromLogs(output, ModBlocks.CATALPA_WOOD.get(), ModBlocks.CATALPA_LOG.get());

        woodenBoat(output, ModItems.RED_MAPLE_BOAT.get(), ModBlocks.RED_MAPLE_PLANKS.get());
        chestBoat(output, ModItems.RED_MAPLE_CHEST_BOAT.get(), ModItems.RED_MAPLE_BOAT.get());

        stairBuilder(ModBlocks.RED_MAPLE_STAIRS.get(), Ingredient.of(ModBlocks.RED_MAPLE_PLANKS)).group("red_maple")
                .unlockedBy("has_red_maple", has(ModBlocks.RED_MAPLE_PLANKS)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_MAPLE_SLAB.get(), ModBlocks.RED_MAPLE_PLANKS.get());

        buttonBuilder(ModBlocks.RED_MAPLE_BUTTON.get(), Ingredient.of(ModBlocks.RED_MAPLE_PLANKS.get())).group("red_maple")
                .unlockedBy("has_red_maple", has(ModBlocks.RED_MAPLE_PLANKS.get())).save(output);
        pressurePlate(output, ModBlocks.RED_MAPLE_PRESSURE_PLATE.get(), ModBlocks.RED_MAPLE_PLANKS.get());

        fenceBuilder(ModBlocks.RED_MAPLE_FENCE.get(), Ingredient.of(ModBlocks.RED_MAPLE_PLANKS.get())).group("red_maple")
                .unlockedBy("has_red_maple", has(ModBlocks.RED_MAPLE_PLANKS.get())).save(output);
        fenceGateBuilder(ModBlocks.RED_MAPLE_FENCE_GATE.get(), Ingredient.of(ModBlocks.RED_MAPLE_PLANKS.get())).group("red_maple")
                .unlockedBy("has_red_maple", has(ModBlocks.RED_MAPLE_PLANKS.get())).save(output);

        doorBuilder(ModBlocks.RED_MAPLE_DOOR.get(), Ingredient.of(ModBlocks.RED_MAPLE_PLANKS.get())).group("red_maple")
                .unlockedBy("has_red_maple", has(ModBlocks.RED_MAPLE_PLANKS.get())).save(output);
        trapdoorBuilder(ModBlocks.RED_MAPLE_TRAPDOOR.get(), Ingredient.of(ModBlocks.RED_MAPLE_PLANKS.get())).group("red_maple")
                .unlockedBy("has_red_maple", has(ModBlocks.RED_MAPLE_PLANKS.get())).save(output);

        signBuilder(ModBlocks.RED_MAPLE_SIGN.get(), Ingredient.of(ModBlocks.RED_MAPLE_PLANKS.get()));
        hangingSign(output, ModBlocks.RED_MAPLE_HANGING_SIGN.get(), ModBlocks.STRIPPED_RED_MAPLE_LOG.get());

        planksFromLog(output, ModBlocks.RED_MAPLE_PLANKS.get(), ModTags.Items.RED_MAPLE_LOGS, 4);
        woodFromLogs(output, ModBlocks.RED_MAPLE_WOOD.get(), ModBlocks.RED_MAPLE_LOG.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ALLUMINITE_BOOTS.get())
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.REINFORCED_ALLUMINITE_INGOT.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ALLUMINITE_LEGGINGS.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.REINFORCED_ALLUMINITE_INGOT.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ALLUMINITE_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.REINFORCED_ALLUMINITE_INGOT.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ALLUMINITE_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .define('A', ModItems.REINFORCED_ALLUMINITE_INGOT.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.OBSIDIAN_BOOTS.get())
                .pattern("A A")
                .pattern("A A")
                .define('A', ModBlocks.REINFORCED_OBSIDIAN.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.OBSIDIAN_LEGGINGS.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModBlocks.REINFORCED_OBSIDIAN.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.OBSIDIAN_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModBlocks.REINFORCED_OBSIDIAN.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.OBSIDIAN_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .define('A', ModBlocks.REINFORCED_OBSIDIAN.get())
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output);
    }

    private void generateVanillaSmeltingRecipes(RecipeOutput output) {
        fromSmelting(output, ModBlocks.RAW_ALLUMINITE_BLOCK, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ALLUMINITE_BLOCK,
                0.25f, 110, "alluminite");
        fromBlasting(output, ModBlocks.RAW_ALLUMINITE_BLOCK, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ALLUMINITE_BLOCK,
                0.25f, 80, "alluminite");

        fromSmelting(output, ModItems.RAW_ALLUMINITE, RecipeCategory.MISC, ModItems.ALLUMINITE_INGOT,
                0.25f, 90, "alluminite");
        fromBlasting(output, ModItems.RAW_ALLUMINITE, RecipeCategory.MISC, ModItems.ALLUMINITE_INGOT,
                0.25f, 75, "alluminite");

        fromSmelting(output, ModItems.MUD_BALL, RecipeCategory.MISC, ModItems.DRIED_MUD_BALL,
                0.25f, 140, "mud");
        fromBlasting(output, ModItems.MUD_BALL, RecipeCategory.MISC, ModItems.DRIED_MUD_BALL,
                0.25f, 70, "mud");

        fromSmelting(output, ModBlocks.MUD_BLOCK, RecipeCategory.MISC, ModBlocks.DRIED_MUD_BLOCK,
                0.25f, 180, "mud");
        fromBlasting(output, ModBlocks.MUD_BLOCK, RecipeCategory.MISC, ModBlocks.DRIED_MUD_BLOCK,
                0.25f, 90, "mud");

        fromSmelting(output, Items.EGG, RecipeCategory.FOOD, ModItems.BOILED_EGG,
                0.25f, 200, "salad_ingredients");
        fromSmoking(output, Items.EGG, RecipeCategory.FOOD, ModItems.BOILED_EGG,
                0.25f, 100, "salad_ingredients");

        fromSmelting(output, Items.BREAD, RecipeCategory.FOOD, ModItems.CROUTON,
                0.25f, 180, "salad_ingredients");
        fromSmoking(output, Items.BREAD, RecipeCategory.FOOD, ModItems.CROUTON,
                0.25f, 90, "salad_ingredients");
        fromCampfireCooking(output, Items.BREAD, RecipeCategory.FOOD, ModItems.CROUTON,
                0.25f, 565, "salad_ingredients");

        fromSmelting(output, ModItems.BREAD_SLICE, RecipeCategory.FOOD, ModItems.TOAST,
                0.25f, 200, "sandwich_ingredients");
        fromSmoking(output, ModItems.BREAD_SLICE, RecipeCategory.FOOD, ModItems.TOAST,
                0.25f, 100, "sandwich_ingredients");
        fromCampfireCooking(output, ModItems.BREAD_SLICE, RecipeCategory.FOOD, ModItems.TOAST,
                0.25f, 600, "sandwich_ingredients");

        fromSmelting(output, ModItems.SALTED_RAW_BEEF, RecipeCategory.FOOD, Items.COOKED_BEEF,
                0.25f, 200, "salted_meats");
        fromSmoking(output, ModItems.SALTED_RAW_BEEF, RecipeCategory.FOOD, Items.COOKED_BEEF,
                0.25f, 100, "salted_meats");
        fromCampfireCooking(output, ModItems.SALTED_RAW_BEEF, RecipeCategory.FOOD, Items.COOKED_BEEF,
                0.25f, 600, "salted_meats");

        fromSmelting(output, ModItems.SALTED_RAW_CHICKEN, RecipeCategory.FOOD, Items.COOKED_CHICKEN,
                0.25f, 200, "salted_meats");
        fromSmoking(output, ModItems.SALTED_RAW_CHICKEN, RecipeCategory.FOOD, Items.COOKED_CHICKEN,
                0.25f, 100, "salted_meats");
        fromCampfireCooking(output, ModItems.SALTED_RAW_CHICKEN, RecipeCategory.FOOD, Items.COOKED_CHICKEN,
                0.25f, 600, "salted_meats");

        fromSmelting(output, ModItems.SALTED_RAW_PORKCHOP, RecipeCategory.FOOD, Items.COOKED_PORKCHOP,
                0.25f, 200, "salted_meats");
        fromSmoking(output, ModItems.SALTED_RAW_PORKCHOP, RecipeCategory.FOOD, Items.COOKED_PORKCHOP,
                0.25f, 100, "salted_meats");
        fromCampfireCooking(output, ModItems.SALTED_RAW_PORKCHOP, RecipeCategory.FOOD, Items.COOKED_PORKCHOP,
                0.25f, 600, "salted_meats");

        fromSmelting(output, ModItems.SALTED_RAW_MUTTON, RecipeCategory.FOOD, Items.COOKED_MUTTON,
                0.25f, 200, "salted_meats");
        fromSmoking(output, ModItems.SALTED_RAW_MUTTON, RecipeCategory.FOOD, Items.COOKED_MUTTON,
                0.25f, 100, "salted_meats");
        fromCampfireCooking(output, ModItems.SALTED_RAW_MUTTON, RecipeCategory.FOOD, Items.COOKED_MUTTON,
                0.25f, 600, "salted_meats");

        fromSmelting(output, ModItems.SALTED_RAW_SALMON, RecipeCategory.FOOD, Items.COOKED_SALMON,
                0.25f, 200, "salted_meats");
        fromSmoking(output, ModItems.SALTED_RAW_SALMON, RecipeCategory.FOOD, Items.COOKED_SALMON,
                0.25f, 100, "salted_meats");
        fromCampfireCooking(output, ModItems.SALTED_RAW_SALMON, RecipeCategory.FOOD, Items.COOKED_SALMON,
                0.25f, 600, "salted_meats");

        fromSmelting(output, ModItems.SALTED_RAW_COD, RecipeCategory.FOOD, Items.COOKED_COD,
                0.25f, 200, "salted_meats");
        fromSmoking(output, ModItems.SALTED_RAW_COD, RecipeCategory.FOOD, Items.COOKED_COD,
                0.25f, 100, "salted_meats");
        fromCampfireCooking(output, ModItems.SALTED_RAW_COD, RecipeCategory.FOOD, Items.COOKED_COD,
                0.25f, 600, "salted_meats");

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModTags.Items.CATALPA_LOGS), RecipeCategory.MISC,
                        Items.CHARCOAL,
                        5, 200).unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output, "charcoal_from_catalpa_logs");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModTags.Items.RED_MAPLE_LOGS), RecipeCategory.MISC,
                        Items.CHARCOAL,
                        5, 200).unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(output, "charcoal_from_red_maple_logs");

        fromSmelting(output, ModBlocks.COMPRESSED_MUD_BLOCK, RecipeCategory.BUILDING_BLOCKS, Blocks.TERRACOTTA,
                0.25f, 200, "others");

        fromSmelting(output, Blocks.RAW_IRON_BLOCK, RecipeCategory.BUILDING_BLOCKS, Blocks.IRON_BLOCK,
                0.25f, 100, "others");
        fromBlasting(output, Blocks.RAW_IRON_BLOCK, RecipeCategory.BUILDING_BLOCKS, Blocks.IRON_BLOCK,
                0.25f, 75, "others");

        fromSmelting(output, Blocks.RAW_GOLD_BLOCK, RecipeCategory.BUILDING_BLOCKS, Blocks.GOLD_BLOCK,
                0.25f, 100, "others");
        fromBlasting(output, Blocks.RAW_GOLD_BLOCK, RecipeCategory.BUILDING_BLOCKS, Blocks.GOLD_BLOCK,
                0.25f, 75, "others");

        fromSmelting(output, Blocks.RAW_COPPER_BLOCK, RecipeCategory.BUILDING_BLOCKS, Blocks.COPPER_BLOCK,
                0.25f, 100, "others");
        fromBlasting(output, Blocks.RAW_COPPER_BLOCK, RecipeCategory.BUILDING_BLOCKS, Blocks.COPPER_BLOCK,
                0.25f, 75, "others");
    }

    private void generateFiltererRecipes(RecipeOutput output) {
        FiltererRecipeBuilder.of(ModItems.BASIC_DIRT_CHARM.get(), ModItems.BASIC_DIRT_PATH_CHARM.get())
                .save(output, "basic_dirt_path_charm");

        FiltererRecipeBuilder.of(ModItems.BLUE_DIRT_CHARM.get(), ModItems.BLUE_DIRT_PATH_CHARM.get())
                .save(output, "blue_dirt_path_charm");

        FiltererRecipeBuilder.of(ModItems.YELLOW_DIRT_CHARM.get(), ModItems.YELLOW_DIRT_PATH_CHARM.get())
                .save(output, "yellow_dirt_path_charm");

        FiltererRecipeBuilder.of(ModItems.RED_DIRT_CHARM.get(), ModItems.RED_DIRT_PATH_CHARM.get())
                .save(output, "red_dirt_path_charm");

        FiltererRecipeBuilder.of(ModItems.ALLUMIN_LUMINIUM_DIRT_CHARM.get(), ModItems.ALLUMIN_LUMINIUM_DIRT_PATH_CHARM.get())
                .save(output, "combined_dirt_path_charm");

        FiltererRecipeBuilder.of(Blocks.OBSIDIAN.asItem(), Blocks.CRYING_OBSIDIAN.asItem())
                .save(output, "crying_obsidian");

        FiltererRecipeBuilder.of(ModItems.CRUSHED_TOMATO_BOTTLE.get(), ModItems.KETCHUP_BOTTLE.get())
                .save(output, "ketchup_bottle");

        FiltererRecipeBuilder.of(ModItems.UNPROCESSED_LUMINIUM_CHUNK.get(), ModItems.LUMINIUM_CHUNK.get())
                .save(output, "luminium_chunk");

        FiltererRecipeBuilder.of(ModItems.SALT_ROCK.get(), ModItems.SALT.get()).setAmount(2)
                .save(output, "salt");

        FiltererRecipeBuilder.of(ModItems.UNFILTERED_SUGAR.get(), Items.SUGAR).setAmount(2)
                .save(output, "sugar_filtered");

        FiltererRecipeBuilder.of(ModBlocks.UNFILTERED_SUGAR_BLOCK.get().asItem(),
                        ModBlocks.SUGAR_BLOCK.get().asItem())
                .save(output, "sugar_block_filtered");
    }

    private void generateCrusherRecipes(RecipeOutput output) {
        CrusherRecipeBuilder.of(
                ModTags.Items.ABOVE_IRON_HAMMERS,
                ModItems.ALLUMINITE_AXE.get(),
                ModItems.ALLUMINITE_ROD_SHARD.get()
        ).setAmount(3).save(output, "alluminite_rod_shard_from_axe");

        CrusherRecipeBuilder.of(
                ModTags.Items.ABOVE_IRON_HAMMERS,
                ModItems.ALLUMINITE_HOE.get(),
                ModItems.ALLUMINITE_ROD_SHARD.get()
        ).setAmount(3).save(output, "alluminite_rod_shard_from_hoe");

        CrusherRecipeBuilder.of(
                ModTags.Items.ABOVE_IRON_HAMMERS,
                ModItems.ALLUMINITE_PICKAXE.get(),
                ModItems.ALLUMINITE_ROD_SHARD.get()
        ).setAmount(3).save(output, "alluminite_rod_shard_from_pickaxe");

        CrusherRecipeBuilder.of(
                ModTags.Items.ABOVE_IRON_HAMMERS,
                ModItems.ALLUMINITE_SHOVEL.get(),
                ModItems.ALLUMINITE_ROD_SHARD.get()
        ).setAmount(3).save(output, "alluminite_rod_shard_from_shovel");

        CrusherRecipeBuilder.of(
                ModTags.Items.ABOVE_IRON_HAMMERS,
                ModItems.ALLUMINITE_SWORD.get(),
                ModItems.ALLUMINITE_ROD_SHARD.get()
        ).setAmount(3).save(output, "alluminite_rod_shard_from_sword");

        CrusherRecipeBuilder.of(
                ModTags.Items.ABOVE_STONE_HAMMERS,
                ModItems.ORANGE_SEEDS.get(),
                ModItems.ORANGE_SEED_POWDER.get()
        ).save(output, "orange_seed_powder");

        CrusherRecipeBuilder.of(
                ModTags.Items.ABOVE_IRON_HAMMERS,
                Items.DIAMOND,
                ModItems.DIAMOND_CHUNKS.get()
        ).save(output, "diamond_chunks");

        CrusherRecipeBuilder.of(
                ModTags.Items.ABOVE_OBSIDIAN_HAMMERS,
                ModItems.DIAMOND_CHUNKS.get(),
                ModItems.DIAMOND_POWDER.get()
        ).save(output, "diamond_dust");

        CrusherRecipeBuilder.of(
                ModTags.Items.ABOVE_IRON_HAMMERS,
                Items.IRON_INGOT,
                ModItems.IRON_CHUNKS.get()
        ).save(output, "iron_chunks");

        CrusherRecipeBuilder.of(
                ModTags.Items.ABOVE_IRON_HAMMERS,
                ModItems.IRON_CHUNKS.get(),
                ModItems.IRON_POWDER.get()
        ).save(output, "iron_powder");

        CrusherRecipeBuilder.of(
                ModTags.Items.ABOVE_STONE_HAMMERS,
                ModItems.TOMATO.get(),
                ModItems.CRUSHED_TOMATO.get()
        ).save(output, "crushed_tomato");

        CrusherRecipeBuilder.of(
                ModTags.Items.ABOVE_STONE_HAMMERS,
                Items.BAKED_POTATO,
                ModItems.POTATO_BITS.get()
        ).save(output, "potato_bits");
    }

    private void generateObsidianForgerRecipes(RecipeOutput output) {
        ObsidianForgerRecipeBuilder.of(
                ModTags.Items.ABOVE_DIAMOND_HAMMERS,
                ModBlocks.REINFORCED_OBSIDIAN.get().asItem(),
                ModItems.RAW_LUMINIUM.get(),
                ModItems.LUMINIUM_GEM.get()
        ).save(output, "luminium_gem");

        ObsidianForgerRecipeBuilder.of(
                ModTags.Items.ABOVE_DIAMOND_HAMMERS,
                ModBlocks.REINFORCED_OBSIDIAN.get().asItem(),
                ModItems.LUMINIUM_GEM.get(),
                ModItems.REINFORCED_LUMINIUM_GEM.get()
        ).save(output, "reinforced_luminium_gem");

        ObsidianForgerRecipeBuilder.of(
                ModTags.Items.ABOVE_DIAMOND_HAMMERS,
                Blocks.OBSIDIAN.asItem(),
                ModItems.REINFORCED_ALLUMINITE_INGOT.get(),
                ModBlocks.REINFORCED_OBSIDIAN.get().asItem()
        ).save(output, "reinforced_obsidian");
    }

    private void generatePasteurizerDummyRecipe(RecipeOutput output) {
        PasteurizerRecipeBuilder.of(ModItems.GOAT_MILK.get(), ModItems.GOAT_MILK.get())
                .save(output, "pasteurizer_dummy_recipe");
    }


    protected static void nineBlockStorageRecipes(RecipeOutput output, ItemLike block, ItemLike item) {
        nineBlockStorageRecipes(output, RecipeCategory.BUILDING_BLOCKS, item, RecipeCategory.MISC, block);
    }

    protected static void fromSmelting(RecipeOutput recipeOutput, ItemLike pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                       float pExperience, int pCookingTIme, String pGroup) {
        cooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void fromBlasting(RecipeOutput recipeOutput, ItemLike pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                       float pExperience, int pCookingTime, String pGroup) {
        cooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void fromSmoking(RecipeOutput recipeOutput, ItemLike pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        cooking(recipeOutput, RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_smoking");
    }

    protected static void fromCampfireCooking(RecipeOutput recipeOutput, ItemLike pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                              float pExperience, int pCookingTime, String pGroup) {
        cooking(recipeOutput, RecipeSerializer.CAMPFIRE_COOKING_RECIPE, CampfireCookingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_campfire_cooking");
    }

    protected static <T extends AbstractCookingRecipe> void cooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                    ItemLike pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        SimpleCookingRecipeBuilder.generic(Ingredient.of(pIngredients), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(recipeOutput, TwindlingTweaks.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(pIngredients));
    }
}