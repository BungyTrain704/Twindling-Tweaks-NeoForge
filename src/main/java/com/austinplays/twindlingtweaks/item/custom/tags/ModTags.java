package com.austinplays.twindlingtweaks.item.custom.tags;

import com.austinplays.twindlingtweaks.TwindlingTweaks;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    // Prevent instantiation
    private ModTags() {}

    public static class Items {
        public static final TagKey<Item> ABOVE_STONE_HAMMERS = tag("above_stone_hammers");
        public static final TagKey<Item> ABOVE_IRON_HAMMERS = tag("above_iron_hammers");
        public static final TagKey<Item> ABOVE_DIAMOND_HAMMERS = tag("above_diamond_hammers");
        public static final TagKey<Item> ABOVE_OBSIDIAN_HAMMERS = tag("above_obsidian_hammers");

        public static final TagKey<Item> KNIVES = tag("knives");

        public static final TagKey<Item> CATALPA_LOGS = tag("catalpa_logs");
        public static final TagKey<Item> RED_MAPLE_LOGS = tag("red_maple_logs");

        private static TagKey<Item> tag(String name) {
            return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, name));
        }
    }

    public static class Blocks {

        public static final TagKey<Block> CATALPA_LOGS = tag("catalpa_logs");
        public static final TagKey<Block> RED_MAPLE_LOGS = tag("red_maple_logs");

        private static TagKey<Block> tag(String name) {
            return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, name));
        }
    }
}