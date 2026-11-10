package com.austinplays.twindlingtweaks.util;

import com.austinplays.twindlingtweaks.TwindlingTweaks;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_ALLUMINITE_TOOL = createTag("needs_alluminite_tool");
        public static final TagKey<Block> INCORRECT_FOR_ALLUMINITE_TOOL = createTag("incorrect_for_alluminite_tool");

        public static final TagKey<Block> NEEDS_OBSIDIAN_TOOL = createTag("needs_obsidian_tool");
        public static final TagKey<Block> INCORRECT_FOR_OBSIDIAN_TOOL = createTag("incorrect_for_obsidian_tool");

        public static final TagKey<Block> ALLUMINITE_ORES = createTag("alluminite_ores");
        public static final TagKey<Block> LUMINIUM_ORES = createTag("luminium_ores");
        public static final TagKey<Block> SUGAR_ORES = createTag("sugar_ores");
        public static final TagKey<Block> SALT_ORES = createTag("salt_ores");
        public static final TagKey<Block> MUD_ORES = createTag("mud_ores");

        public static final TagKey<Block> CATALPA_LOGS = createTag("catalpa_logs");
        public static final TagKey<Block> RED_MAPLE_LOGS = createTag("red_maple_logs");
    }

    public static class Items {
        public static final TagKey<Item> ALLUMINITE_ORES = createTag("alluminite_ores");
        public static final TagKey<Item> LUMINIUM_ORES = createTag("luminium_ores");
        public static final TagKey<Item> SUGAR_ORES = createTag("sugar_ores");
        public static final TagKey<Item> SALT_ORES = createTag("salt_ores");
        public static final TagKey<Item> MUD_ORES = createTag("mud_ores");

        public static final TagKey<Item> CATALPA_LOGS = createTag("catalpa_logs");
        public static final TagKey<Item> RED_MAPLE_LOGS = createTag("red_maple_logs");

        public static final TagKey<Item> KNIVES = createTag("knives");

        public static final TagKey<Item> HAMMERS = createTag("hammers");

        public static final TagKey<Item> ABOVE_STONE_HAMMERS = createTag("above_stone_hammers");
        public static final TagKey<Item> ABOVE_IRON_HAMMERS = createTag("above_iron_hammers");
        public static final TagKey<Item> ABOVE_DIAMOND_HAMMERS = createTag("above_diamond_hammers");
        public static final TagKey<Item> ABOVE_OBSIDIAN_HAMMERS = createTag("above_obsidian_hammers");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, name));
        }
    }

    private static TagKey<Block> createTag(String name) {
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, name));
    }
}