package com.austinplays.twindlingtweaks.datagen;

import com.austinplays.twindlingtweaks.TwindlingTweaks;
import com.austinplays.twindlingtweaks.block.ModBlocks;
import com.austinplays.twindlingtweaks.item.ModItems;
import com.austinplays.twindlingtweaks.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
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

        this.tag(ItemTags.VILLAGER_PLANTABLE_SEEDS)
                .add(ModItems.CUCUMBER_SEEDS.get(),
                        ModItems.TOMATO_SEEDS.get(),
                        ModItems.LETTUCE_SEEDS.get(),
                        ModItems.ORANGE_SEEDS.get(),
                        ModItems.BROCCOLI_SEEDS.get(),
                        ModItems.CORN_SEEDS.get());

        this.tag(Tags.Items.BUCKETS)
                .add(ModItems.ORANGE_SEED_MILK.get(),
                        ModItems.IRON_INFUSED_MILK.get(),
                        ModItems.DIAMOND_INFUSED_MILK.get(),
                        ModItems.GOAT_MILK.get());

        this.tag(Tags.Items.BUCKETS_MILK)
                .add(ModItems.ORANGE_SEED_MILK.get(),
                        ModItems.IRON_INFUSED_MILK.get(),
                        ModItems.DIAMOND_INFUSED_MILK.get(),
                        ModItems.GOAT_MILK.get());

        this.tag(Tags.Items.CROPS)
                .add(ModItems.CUCUMBER.get(),
                        ModItems.TOMATO.get(),
                        ModItems.LETTUCE.get(),
                        ModItems.ORANGE.get(),
                        ModItems.CORN.get(),
                        ModItems.BROCCOLI.get());

        this.tag(Tags.Items.DUSTS)
                .add(ModItems.IRON_POWDER.get(),
                        ModItems.DIAMOND_POWDER.get(),
                        ModItems.ORANGE_SEED_POWDER.get());

        this.tag(Tags.Items.EGGS)
                .add(ModItems.FRIED_EGG.get(),
                        ModItems.BOILED_EGG.get());

        this.tag(Tags.Items.FENCE_GATES)
                .add(ModBlocks.CATALPA_FENCE_GATE.get().asItem(),
                        ModBlocks.RED_MAPLE_FENCE_GATE.get().asItem());

        this.tag(Tags.Items.FENCE_GATES_WOODEN)
                .add(ModBlocks.CATALPA_FENCE_GATE.get().asItem(),
                        ModBlocks.RED_MAPLE_FENCE_GATE.get().asItem());

        this.tag(Tags.Items.FENCES)
                .add(ModBlocks.CATALPA_FENCE.get().asItem(),
                        ModBlocks.RED_MAPLE_FENCE.get().asItem());

        this.tag(Tags.Items.FENCES_WOODEN)
                .add(ModBlocks.CATALPA_FENCE.get().asItem(),
                        ModBlocks.RED_MAPLE_FENCE.get().asItem());

        this.tag(Tags.Items.FOODS)
                .add(ModItems.LETTUCE.get(),
                        ModItems.TOMATO.get(),
                        ModItems.CUCUMBER.get(),
                        ModItems.ORANGE.get(),
                        ModItems.CORN.get(),
                        ModItems.BROCCOLI.get(),
                        ModItems.SALAD.get(),
                        ModItems.SPRING_SALAD.get(),
                        ModItems.SPECIAL_SALAD.get(),
                        ModItems.DRIED_MUD_BALL.get(),
                        ModItems.CROUTON.get(),
                        ModItems.BANANA.get(),
                        ModItems.LUMINIUM_APPLE.get(),
                        ModItems.CRUSHED_TOMATO.get(),
                        ModItems.BREAD_SLICE.get(),
                        ModItems.TOAST.get(),
                        ModItems.GOAT_CHEESE.get(),
                        ModItems.SLICED_GOAT_CHEESE.get(),
                        ModItems.GOAT_BUTTER.get(),
                        ModItems.GOAT_ICE_CREAM.get(),
                        ModItems.GOAT_CAKE_ITEM.get(),
                        ModItems.VANILLA_GOAT_YOGURT.get(),
                        ModItems.BERRY_BOWL.get(),
                        ModItems.BERRY_TOAST.get(),
                        ModItems.BLUEBERRIES.get(),
                        ModItems.RASPBERRIES.get(),
                        ModItems.STEAK_LETTUCE_SANDWICH.get(),
                        ModItems.TOASTED_STEAK_LETTUCE_SANDWICH.get(),
                        ModItems.CHEESE_MEAT_SANDWICH.get(),
                        ModItems.MEATY_SANDWICH.get(),
                        ModItems.VEGAN_SANDWICH.get(),
                        ModItems.BANANA_SANDWICH.get(),
                        ModItems.HEARTY_STEW.get(),
                        ModItems.SALTED_RAW_BEEF.get(),
                        ModItems.SALTED_RAW_CHICKEN.get(),
                        ModItems.SALTED_RAW_PORKCHOP.get(),
                        ModItems.SALTED_RAW_MUTTON.get(),
                        ModItems.SALTED_RAW_RABBIT.get(),
                        ModItems.SALTED_RAW_COD.get(),
                        ModItems.SALTED_RAW_SALMON.get(),
                        ModItems.BOILED_EGG.get(),
                        ModItems.FRIED_EGG.get(),
                        ModItems.SALTED_POTATO_CHIPS.get());

        this.tag(Tags.Items.FOODS_BERRY)
                .add(ModItems.SPRING_SALAD.get(),
                        ModItems.BERRY_BOWL.get(),
                        ModItems.BERRY_TOAST.get(),
                        ModItems.BLUEBERRIES.get(),
                        ModItems.RASPBERRIES.get());

        this.tag(Tags.Items.FOODS_BREAD)
                .add(ModItems.CROUTON.get(),
                        ModItems.BREAD_SLICE.get(),
                        ModItems.TOAST.get(),
                        ModItems.BERRY_TOAST.get(),
                        ModItems.STEAK_LETTUCE_SANDWICH.get(),
                        ModItems.TOASTED_STEAK_LETTUCE_SANDWICH.get(),
                        ModItems.CHEESE_MEAT_SANDWICH.get(),
                        ModItems.MEATY_SANDWICH.get(),
                        ModItems.VEGAN_SANDWICH.get(),
                        ModItems.BANANA_SANDWICH.get());

        this.tag(Tags.Items.FOODS_EDIBLE_WHEN_PLACED)
                .add(ModItems.GOAT_CAKE_ITEM.get());

        this.tag(Tags.Items.FOODS_FRUIT)
                .add(ModItems.TOMATO.get(),
                        ModItems.ORANGE.get(),
                        ModItems.BANANA.get(),
                        ModItems.LUMINIUM_APPLE.get(),
                        ModItems.CRUSHED_TOMATO.get(),
                        ModItems.BLUEBERRIES.get(),
                        ModItems.RASPBERRIES.get());

        this.tag(Tags.Items.FOODS_RAW_FISH)
                .add(ModItems.SALTED_RAW_COD.get(),
                        ModItems.SALTED_RAW_SALMON.get());

        this.tag(Tags.Items.FOODS_RAW_MEAT)
                .add(ModItems.SALTED_RAW_BEEF.get(),
                        ModItems.SALTED_RAW_CHICKEN.get(),
                        ModItems.SALTED_RAW_PORKCHOP.get(),
                        ModItems.SALTED_RAW_MUTTON.get(),
                        ModItems.SALTED_RAW_RABBIT.get());

        this.tag(Tags.Items.FOODS_GOLDEN)
                .add(ModItems.LUMINIUM_APPLE.get());

        this.tag(Tags.Items.FOODS_SOUP)
                .add(ModItems.HEARTY_STEW.get());

        this.tag(Tags.Items.FOODS_VEGETABLE)
                .add(ModItems.LETTUCE.get(),
                        ModItems.CUCUMBER.get(),
                        ModItems.CORN.get(),
                        ModItems.BROCCOLI.get());

        this.tag(Tags.Items.GEMS)
                .add(ModItems.LUMINIUM_GEM.get(),
                        ModItems.REINFORCED_LUMINIUM_GEM.get());

        this.tag(Tags.Items.INGOTS)
                .add(ModItems.ALLUMINITE_INGOT.get(),
                        ModItems.REINFORCED_ALLUMINITE_INGOT.get(),
                        ModItems.UNSTABLE_ALLUMINITE_INGOT.get());

        this.tag(Tags.Items.MELEE_WEAPON_TOOLS)
                .add(ModItems.ALLUMINITE_SWORD.get(),
                        ModItems.OBSIDIAN_SWORD.get());

        this.tag(Tags.Items.MINING_TOOL_TOOLS)
                .add(ModItems.ALLUMINITE_AXE.get(),
                        ModItems.ALLUMINITE_PICKAXE.get(),
                        ModItems.ALLUMINITE_SHOVEL.get(),
                        ModItems.ALLUMINITE_HOE.get(),
                        ModItems.OBSIDIAN_AXE.get(),
                        ModItems.OBSIDIAN_PICKAXE.get(),
                        ModItems.OBSIDIAN_SHOVEL.get(),
                        ModItems.OBSIDIAN_HOE.get());

        this.tag(Tags.Items.MUSIC_DISCS)
                .add(ModItems.MYSTICAL_MUSIC_DISC.get());

        this.tag(Tags.Items.NUGGETS)
                .add(ModItems.ALLUMINITE_NUGGET.get());

        this.tag(Tags.Items.OBSIDIANS)
                .add(ModBlocks.REINFORCED_OBSIDIAN.get().asItem());

        this.tag(Tags.Items.OBSIDIANS_NORMAL)
                .add(ModBlocks.REINFORCED_OBSIDIAN.get().asItem());

        this.tag(Tags.Items.ORES)
                .add(ModBlocks.ALLUMINITE_ORE.get().asItem(),
                        ModBlocks.DEEPSLATE_ALLUMINITE_ORE.get().asItem(),
                        ModBlocks.LUMINIUM_ORE.get().asItem(),
                        ModBlocks.DEEPSLATE_LUMINIUM_ORE.get().asItem(),
                        ModBlocks.MUD_ORE.get().asItem(),
                        ModBlocks.DEEPSLATE_MUD_ORE.get().asItem(),
                        ModBlocks.SUGAR_ORE.get().asItem(),
                        ModBlocks.DEEPSLATE_SUGAR_ORE.get().asItem(),
                        ModBlocks.SALT_ORE.get().asItem(),
                        ModBlocks.DEEPSLATE_SALT_ORE.get().asItem());

        this.tag(Tags.Items.ORES_IN_GROUND_STONE)
                .add(ModBlocks.ALLUMINITE_ORE.get().asItem(),
                        ModBlocks.LUMINIUM_ORE.get().asItem(),
                        ModBlocks.MUD_ORE.get().asItem(),
                        ModBlocks.SUGAR_ORE.get().asItem(),
                        ModBlocks.SALT_ORE.get().asItem());

        this.tag(Tags.Items.ORES_IN_GROUND_DEEPSLATE)
                .add(ModBlocks.DEEPSLATE_ALLUMINITE_ORE.get().asItem(),
                        ModBlocks.DEEPSLATE_LUMINIUM_ORE.get().asItem(),
                        ModBlocks.DEEPSLATE_MUD_ORE.get().asItem(),
                        ModBlocks.DEEPSLATE_SUGAR_ORE.get().asItem(),
                        ModBlocks.DEEPSLATE_SALT_ORE.get().asItem());

        this.tag(Tags.Items.RAW_MATERIALS)
                .add(ModItems.RAW_ALLUMINITE.get(),
                        ModItems.RAW_LUMINIUM.get(),
                        ModItems.UNPROCESSED_LUMINIUM_CHUNK.get(),
                        ModItems.LUMINIUM_CHUNK.get());

        this.tag(Tags.Items.RODS)
                .add(ModItems.ALLUMINITE_ROD.get());

        this.tag(Tags.Items.SEEDS)
                .add(ModItems.CUCUMBER_SEEDS.get(),
                        ModItems.TOMATO_SEEDS.get(),
                        ModItems.LETTUCE_SEEDS.get(),
                        ModItems.ORANGE_SEEDS.get(),
                        ModItems.CORN_SEEDS.get(),
                        ModItems.BROCCOLI_SEEDS.get());

        this.tag(Tags.Items.STRIPPED_LOGS)
                .add(ModBlocks.STRIPPED_CATALPA_LOG.get().asItem(),
                        ModBlocks.STRIPPED_RED_MAPLE_LOG.get().asItem());

        this.tag(Tags.Items.STRIPPED_WOODS)
                .add(ModBlocks.STRIPPED_CATALPA_WOOD.get().asItem(),
                        ModBlocks.STRIPPED_RED_MAPLE_WOOD.get().asItem());

        this.tag(Tags.Items.TOOLS)
                .add(ModItems.ALLUMINITE_SWORD.get(),
                        ModItems.ALLUMINITE_AXE.get(),
                        ModItems.ALLUMINITE_PICKAXE.get(),
                        ModItems.ALLUMINITE_SHOVEL.get(),
                        ModItems.ALLUMINITE_HOE.get(),
                        ModItems.OBSIDIAN_SWORD.get(),
                        ModItems.OBSIDIAN_AXE.get(),
                        ModItems.OBSIDIAN_PICKAXE.get(),
                        ModItems.OBSIDIAN_SHOVEL.get(),
                        ModItems.OBSIDIAN_HOE.get());

        this.tag(ItemTags.SIGNS)
                .add(ModItems.CATALPA_SIGN.get(),
                        ModItems.RED_MAPLE_SIGN.get());

        this.tag(ItemTags.HANGING_SIGNS)
                .add(ModItems.CATALPA_HANGING_SIGN.get(),
                        ModItems.RED_MAPLE_HANGING_SIGN.get());

        this.tag(ItemTags.DOORS)
                .add(ModBlocks.CATALPA_DOOR.get().asItem(),
                        ModBlocks.RED_MAPLE_DOOR.get().asItem(),
                        ModBlocks.MUD_DOOR.get().asItem());

        this.tag(ItemTags.WOODEN_DOORS)
                .add(ModBlocks.CATALPA_DOOR.get().asItem(),
                        ModBlocks.RED_MAPLE_DOOR.get().asItem());

        this.tag(ItemTags.TRAPDOORS)
                .add(ModBlocks.CATALPA_TRAPDOOR.get().asItem(),
                        ModBlocks.RED_MAPLE_TRAPDOOR.get().asItem(),
                        ModBlocks.MUD_TRAPDOOR.get().asItem());

        this.tag(ItemTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.CATALPA_TRAPDOOR.get().asItem(),
                        ModBlocks.RED_MAPLE_TRAPDOOR.get().asItem());

        this.tag(ItemTags.BUTTONS)
                .add(ModBlocks.CATALPA_BUTTON.get().asItem(),
                        ModBlocks.RED_MAPLE_BUTTON.get().asItem());

        this.tag(ItemTags.WOODEN_BUTTONS)
                .add(ModBlocks.CATALPA_BUTTON.get().asItem(),
                        ModBlocks.RED_MAPLE_BUTTON.get().asItem());

        this.tag(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.CATALPA_PRESSURE_PLATE.get().asItem(),
                        ModBlocks.RED_MAPLE_PRESSURE_PLATE.get().asItem());

        this.tag(ItemTags.SLABS)
                .add(ModBlocks.CATALPA_SLAB.get().asItem(),
                        ModBlocks.RED_MAPLE_SLAB.get().asItem());

        this.tag(ItemTags.WOODEN_SLABS)
                .add(ModBlocks.CATALPA_SLAB.get().asItem(),
                        ModBlocks.RED_MAPLE_SLAB.get().asItem());

        this.tag(ItemTags.STAIRS)
                .add(ModBlocks.CATALPA_STAIRS.get().asItem(),
                        ModBlocks.RED_MAPLE_STAIRS.get().asItem());

        this.tag(ItemTags.WOODEN_STAIRS)
                .add(ModBlocks.CATALPA_STAIRS.get().asItem(),
                        ModBlocks.RED_MAPLE_STAIRS.get().asItem());

        this.tag(ItemTags.FENCES)
                .add(ModBlocks.CATALPA_FENCE.get().asItem(),
                        ModBlocks.RED_MAPLE_FENCE.get().asItem());

        this.tag(ItemTags.WOODEN_FENCES)
                .add(ModBlocks.CATALPA_FENCE.get().asItem(),
                        ModBlocks.RED_MAPLE_FENCE.get().asItem());

        this.tag(ItemTags.FENCE_GATES)
                .add(ModBlocks.CATALPA_FENCE_GATE.get().asItem(),
                        ModBlocks.RED_MAPLE_FENCE_GATE.get().asItem());

        this.tag(ItemTags.LEAVES)
                .add(ModBlocks.CATALPA_LEAVES.get().asItem(),
                        ModBlocks.RED_MAPLE_LEAVES.get().asItem());

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

        this.tag(ModTags.Items.CATALPA_LOGS)
                .add(ModBlocks.CATALPA_LOG.get().asItem(),
                        ModBlocks.STRIPPED_CATALPA_LOG.get().asItem(),
                        ModBlocks.CATALPA_WOOD.get().asItem(),
                        ModBlocks.STRIPPED_CATALPA_WOOD.get().asItem());

        this.tag(ModTags.Items.RED_MAPLE_LOGS)
                .add(ModBlocks.RED_MAPLE_LOG.get().asItem(),
                        ModBlocks.STRIPPED_RED_MAPLE_LOG.get().asItem(),
                        ModBlocks.RED_MAPLE_WOOD.get().asItem(),
                        ModBlocks.STRIPPED_RED_MAPLE_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.CATALPA_PLANKS.get().asItem())
                .add(ModBlocks.RED_MAPLE_PLANKS.get().asItem());

        this.tag(ModTags.Items.ALLUMINITE_REPAIRABLE)
                .add(ModItems.REINFORCED_ALLUMINITE_INGOT.get());

        this.tag(ModTags.Items.OBSIDIAN_REPAIRABLE)
                .add(ModBlocks.REINFORCED_OBSIDIAN.get().asItem());

        this.tag(ItemTags.MEAT)
                .add(ModItems.SALTED_RAW_BEEF.get(),
                        ModItems.SALTED_RAW_CHICKEN.get(),
                        ModItems.SALTED_RAW_PORKCHOP.get(),
                        ModItems.SALTED_RAW_MUTTON.get(),
                        ModItems.SALTED_RAW_COD.get(),
                        ModItems.SALTED_RAW_SALMON.get());

        this.tag(ModTags.Items.ALLUMINITE_ORES)
                .add(ModBlocks.ALLUMINITE_ORE.get().asItem(),
                        ModBlocks.DEEPSLATE_ALLUMINITE_ORE.get().asItem());

        this.tag(ModTags.Items.LUMINIUM_ORES)
                .add(ModBlocks.LUMINIUM_ORE.get().asItem(),
                        ModBlocks.DEEPSLATE_LUMINIUM_ORE.get().asItem());

        this.tag(ModTags.Items.SUGAR_ORES)
                .add(ModBlocks.SUGAR_ORE.get().asItem(),
                        ModBlocks.DEEPSLATE_SUGAR_ORE.get().asItem());

        this.tag(ModTags.Items.SALT_ORES)
                .add(ModBlocks.SALT_ORE.get().asItem(),
                        ModBlocks.DEEPSLATE_SALT_ORE.get().asItem());

        this.tag(ModTags.Items.MUD_ORES)
                .add(ModBlocks.MUD_ORE.get().asItem(),
                        ModBlocks.DEEPSLATE_MUD_ORE.get().asItem());

        this.tag(ItemTags.DIRT)
                .add(ModBlocks.BLUE_DIRT.get().asItem())
                .add(ModBlocks.YELLOW_DIRT.get().asItem())
                .add(ModBlocks.RED_DIRT.get().asItem())
                .add(ModBlocks.ALLUMIN_LUMINIUM_DIRT.get().asItem());

        this.tag(ItemTags.BOATS)
                .add(ModItems.CATALPA_BOAT.get(),
                        ModItems.RED_MAPLE_BOAT.get());

        this.tag(ItemTags.CHEST_BOATS)
                .add(ModItems.CATALPA_CHEST_BOAT.get(),
                        ModItems.RED_MAPLE_CHEST_BOAT.get());

        this.tag(ModTags.Items.KNIVES)
                .add(ModItems.COOKING_KNIFE.get());

        this.tag(ModTags.Items.HAMMERS)
                .add(ModItems.STONE_HAMMER.get(),
                        ModItems.IRON_HAMMER.get(),
                        ModItems.DIAMOND_HAMMER.get(),
                        ModItems.OBSIDIAN_HAMMER.get());

        this.tag(ModTags.Items.ABOVE_STONE_HAMMERS)
                .add(ModItems.STONE_HAMMER.get(),
                        ModItems.IRON_HAMMER.get(),
                        ModItems.DIAMOND_HAMMER.get(),
                        ModItems.OBSIDIAN_HAMMER.get());

        this.tag(ModTags.Items.ABOVE_IRON_HAMMERS)
                .add(ModItems.IRON_HAMMER.get(),
                        ModItems.DIAMOND_HAMMER.get(),
                        ModItems.OBSIDIAN_HAMMER.get());

        this.tag(ModTags.Items.ABOVE_DIAMOND_HAMMERS)
                .add(ModItems.DIAMOND_HAMMER.get(),
                        ModItems.OBSIDIAN_HAMMER.get());

        this.tag(ModTags.Items.ABOVE_OBSIDIAN_HAMMERS)
                .add(ModItems.OBSIDIAN_HAMMER.get());

        this.tag(ItemTags.SWORDS)
                .add(ModItems.ALLUMINITE_SWORD.get(),
                        ModItems.OBSIDIAN_SWORD.get());

        this.tag(ItemTags.SWORD_ENCHANTABLE)
                .add(ModItems.ALLUMINITE_SWORD.get(),
                        ModItems.OBSIDIAN_SWORD.get());

        this.tag(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                .add(ModItems.ALLUMINITE_SWORD.get(),
                        ModItems.OBSIDIAN_SWORD.get(),
                        ModItems.ALLUMINITE_AXE.get(),
                        ModItems.OBSIDIAN_AXE.get(),
                        ModItems.COOKING_KNIFE.get());

        this.tag(ItemTags.WEAPON_ENCHANTABLE)
                .add(ModItems.ALLUMINITE_SWORD.get(),
                        ModItems.OBSIDIAN_SWORD.get(),
                        ModItems.ALLUMINITE_AXE.get(),
                        ModItems.OBSIDIAN_AXE.get(),
                        ModItems.COOKING_KNIFE.get());

        this.tag(ItemTags.FIRE_ASPECT_ENCHANTABLE)
                .add(ModItems.ALLUMINITE_SWORD.get(),
                        ModItems.OBSIDIAN_SWORD.get(),
                        ModItems.ALLUMINITE_AXE.get(),
                        ModItems.OBSIDIAN_AXE.get());

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

        this.tag(ItemTags.MINING_ENCHANTABLE)
                .add(ModItems.ALLUMINITE_PICKAXE.get(),
                        ModItems.OBSIDIAN_PICKAXE.get(),
                        ModItems.ALLUMINITE_AXE.get(),
                        ModItems.OBSIDIAN_AXE.get(),
                        ModItems.ALLUMINITE_SHOVEL.get(),
                        ModItems.OBSIDIAN_SHOVEL.get(),
                        ModItems.ALLUMINITE_HOE.get(),
                        ModItems.OBSIDIAN_HOE.get());

        this.tag(ItemTags.MINING_LOOT_ENCHANTABLE)
                .add(ModItems.ALLUMINITE_PICKAXE.get(),
                        ModItems.OBSIDIAN_PICKAXE.get(),
                        ModItems.ALLUMINITE_AXE.get(),
                        ModItems.OBSIDIAN_AXE.get(),
                        ModItems.ALLUMINITE_SHOVEL.get(),
                        ModItems.OBSIDIAN_SHOVEL.get(),
                        ModItems.ALLUMINITE_HOE.get(),
                        ModItems.OBSIDIAN_HOE.get());

        this.tag(ItemTags.ARMOR_ENCHANTABLE)
                .add(ModItems.ALLUMINITE_HELMET.get(),
                        ModItems.OBSIDIAN_HELMET.get(),
                        ModItems.ALLUMINITE_CHESTPLATE.get(),
                        ModItems.OBSIDIAN_CHESTPLATE.get(),
                        ModItems.ALLUMINITE_LEGGINGS.get(),
                        ModItems.OBSIDIAN_LEGGINGS.get(),
                        ModItems.ALLUMINITE_BOOTS.get(),
                        ModItems.OBSIDIAN_BOOTS.get());

        this.tag(ItemTags.DURABILITY_ENCHANTABLE)
                .add(ModItems.ALLUMINITE_HELMET.get(),
                        ModItems.OBSIDIAN_HELMET.get(),
                        ModItems.ALLUMINITE_CHESTPLATE.get(),
                        ModItems.OBSIDIAN_CHESTPLATE.get(),
                        ModItems.ALLUMINITE_LEGGINGS.get(),
                        ModItems.OBSIDIAN_LEGGINGS.get(),
                        ModItems.ALLUMINITE_BOOTS.get(),
                        ModItems.OBSIDIAN_BOOTS.get(),
                        ModItems.ALLUMINITE_PICKAXE.get(),
                        ModItems.OBSIDIAN_PICKAXE.get(),
                        ModItems.ALLUMINITE_AXE.get(),
                        ModItems.OBSIDIAN_AXE.get(),
                        ModItems.ALLUMINITE_SHOVEL.get(),
                        ModItems.OBSIDIAN_SHOVEL.get(),
                        ModItems.ALLUMINITE_HOE.get(),
                        ModItems.OBSIDIAN_HOE.get(),
                        ModItems.ALLUMINITE_SWORD.get(),
                        ModItems.OBSIDIAN_SWORD.get(),
                        ModItems.COOKING_KNIFE.get(),
                        ModItems.STONE_HAMMER.get(),
                        ModItems.IRON_HAMMER.get(),
                        ModItems.DIAMOND_HAMMER.get(),
                        ModItems.OBSIDIAN_HAMMER.get());

        this.tag(ItemTags.VANISHING_ENCHANTABLE)
                .add(ModItems.ALLUMINITE_HELMET.get(),
                        ModItems.OBSIDIAN_HELMET.get(),
                        ModItems.ALLUMINITE_CHESTPLATE.get(),
                        ModItems.OBSIDIAN_CHESTPLATE.get(),
                        ModItems.ALLUMINITE_LEGGINGS.get(),
                        ModItems.OBSIDIAN_LEGGINGS.get(),
                        ModItems.ALLUMINITE_BOOTS.get(),
                        ModItems.OBSIDIAN_BOOTS.get(),
                        ModItems.ALLUMINITE_PICKAXE.get(),
                        ModItems.OBSIDIAN_PICKAXE.get(),
                        ModItems.ALLUMINITE_AXE.get(),
                        ModItems.OBSIDIAN_AXE.get(),
                        ModItems.ALLUMINITE_SHOVEL.get(),
                        ModItems.OBSIDIAN_SHOVEL.get(),
                        ModItems.ALLUMINITE_HOE.get(),
                        ModItems.OBSIDIAN_HOE.get(),
                        ModItems.ALLUMINITE_SWORD.get(),
                        ModItems.OBSIDIAN_SWORD.get(),
                        ModItems.COOKING_KNIFE.get(),
                        ModItems.STONE_HAMMER.get(),
                        ModItems.IRON_HAMMER.get(),
                        ModItems.DIAMOND_HAMMER.get(),
                        ModItems.OBSIDIAN_HAMMER.get());

        this.tag(ItemTags.EQUIPPABLE_ENCHANTABLE)
                .add(ModItems.ALLUMINITE_HELMET.get(),
                        ModItems.OBSIDIAN_HELMET.get(),
                        ModItems.ALLUMINITE_CHESTPLATE.get(),
                        ModItems.OBSIDIAN_CHESTPLATE.get(),
                        ModItems.ALLUMINITE_LEGGINGS.get(),
                        ModItems.OBSIDIAN_LEGGINGS.get(),
                        ModItems.ALLUMINITE_BOOTS.get(),
                        ModItems.OBSIDIAN_BOOTS.get());

        this.tag(ItemTags.HEAD_ARMOR)
                .add(ModItems.ALLUMINITE_HELMET.get(),
                        ModItems.OBSIDIAN_HELMET.get());

        this.tag(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(ModItems.ALLUMINITE_HELMET.get(),
                        ModItems.OBSIDIAN_HELMET.get());

        this.tag(ItemTags.CHEST_ARMOR)
                .add(ModItems.ALLUMINITE_CHESTPLATE.get(),
                        ModItems.OBSIDIAN_CHESTPLATE.get());

        this.tag(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .add(ModItems.ALLUMINITE_CHESTPLATE.get(),
                        ModItems.OBSIDIAN_CHESTPLATE.get());

        this.tag(ItemTags.LEG_ARMOR)
                .add(ModItems.ALLUMINITE_LEGGINGS.get(),
                        ModItems.OBSIDIAN_LEGGINGS.get());

        this.tag(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .add(ModItems.ALLUMINITE_LEGGINGS.get(),
                        ModItems.OBSIDIAN_LEGGINGS.get());

        this.tag(ItemTags.FOOT_ARMOR)
                .add(ModItems.ALLUMINITE_BOOTS.get(),
                        ModItems.OBSIDIAN_BOOTS.get());

        this.tag(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .add(ModItems.ALLUMINITE_BOOTS.get(),
                        ModItems.OBSIDIAN_BOOTS.get());

        this.tag(ItemTags.FLOWERS)
                .add(ModBlocks.CATALPA_FLOWERS.get().asItem());
    }
}