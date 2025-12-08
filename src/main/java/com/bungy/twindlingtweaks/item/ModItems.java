package com.bungy.twindlingtweaks.item;

import com.bungy.twindlingtweaks.TwindlingTweaks;
import com.bungy.twindlingtweaks.block.ModBlocks;
import com.bungy.twindlingtweaks.entity.custom.boat.ModBoatEntity;
import com.bungy.twindlingtweaks.entity.custom.boat.ModBoatEntity2;
import com.bungy.twindlingtweaks.item.custom.armor.ModArmorItem;
import com.bungy.twindlingtweaks.item.custom.armor.materials.ModArmorMaterials;
import com.bungy.twindlingtweaks.item.custom.armor.tiers.ModTiers;
import com.bungy.twindlingtweaks.item.custom.boat.ModBoatItem;
import com.bungy.twindlingtweaks.item.custom.boat.ModBoatItem2;
import com.bungy.twindlingtweaks.item.custom.food.ModFoods;
import com.bungy.twindlingtweaks.item.custom.milk.ModMilkBucketItem;
import com.bungy.twindlingtweaks.item.custom.milk.ModMilkBucketItem2;
import com.bungy.twindlingtweaks.item.custom.milk.ModMilkBucketItem3;
import com.bungy.twindlingtweaks.item.custom.milk.ModMilkBucketItem4;
import com.bungy.twindlingtweaks.item.custom.sign.ModSignItem;
import com.bungy.twindlingtweaks.item.custom.sign.hanging.ModHangingSignItem;
import com.bungy.twindlingtweaks.item.custom.tools.HammerItem;
import com.bungy.twindlingtweaks.item.custom.tools.KnifeItem;
import com.bungy.twindlingtweaks.sound.ModSounds;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TwindlingTweaks.MOD_ID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final DeferredItem<Item> STONE_HAMMER = ITEMS.register("stone_hammer",
            () -> new HammerItem(Tiers.STONE, 7.0F, -3.6F, new Item.Properties()
                    .durability(600)));

    public static final DeferredItem<Item> IRON_HAMMER = ITEMS.register("iron_hammer",
            () -> new HammerItem(Tiers.IRON, 7.0F, -3.6F, new Item.Properties()
                    .durability(900)));

    public static final DeferredItem<Item> DIAMOND_HAMMER = ITEMS.register("diamond_hammer",
            () -> new HammerItem(Tiers.DIAMOND, 7.0F, -3.6F, new Item.Properties()
                    .durability(1400)));

    public static final DeferredItem<Item> OBSIDIAN_HAMMER = ITEMS.register("obsidian_hammer",
            () -> new HammerItem(ModTiers.OBSIDIAN, 16.0F, -3.9F, new Item.Properties()
                    .durability(3000)));

    public static final DeferredItem<Item> COOKING_KNIFE = ITEMS.register("cooking_knife",
            () -> new KnifeItem(Tiers.IRON, 3, -2.3F, new Item.Properties()));

    public static final DeferredItem<Item> MUD_BALL = ITEMS.register("mud_ball",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> DRIED_MUD_BALL = ITEMS.register("dried_mud_ball",
            () -> new Item(new Item.Properties().food(ModFoods.DRIED_MUD_BALL)));

    public static final DeferredItem<Item> UNPROCESSED_LUMINIUM_CHUNK = ITEMS.register("unprocessed_luminium_chunk",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> LUMINIUM_CHUNK = ITEMS.register("luminium_chunk",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_LUMINIUM = ITEMS.register("raw_luminium",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> LUMINIUM_GEM = ITEMS.register("luminium_gem",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> REINFORCED_LUMINIUM_GEM = ITEMS.register("reinforced_luminium_gem",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> LUMINIUM_APPLE = ITEMS.register("luminium_apple",
            () -> new Item(new Item.Properties().food(ModFoods.LUMINIUM_APPLE)));

    public static final DeferredItem<Item> RAW_ALLUMINITE = ITEMS.register("raw_alluminite",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ALLUMINITE_INGOT = ITEMS.register("alluminite_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> UNSTABLE_ALLUMINITE_INGOT = ITEMS.register("unstable_alluminite_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ALLUMINITE_NUGGET = ITEMS.register("alluminite_nugget",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> REINFORCED_ALLUMINITE_INGOT = ITEMS.register("reinforced_alluminite_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ALLUMINITE_SWORD = ITEMS.register("alluminite_sword",
            () -> new SwordItem(ModTiers.ALLUMINITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.ALLUMINITE, 7, -2.2f))));
    public static final DeferredItem<Item> ALLUMINITE_AXE = ITEMS.register("alluminite_axe",
            () -> new AxeItem(ModTiers.ALLUMINITE, new Item.Properties().attributes(AxeItem.createAttributes
                    (ModTiers.ALLUMINITE, 9, -3.1f))));
    public static final DeferredItem<Item> ALLUMINITE_PICKAXE = ITEMS.register("alluminite_pickaxe",
            () -> new PickaxeItem(ModTiers.ALLUMINITE, new Item.Properties().attributes
                    (PickaxeItem.createAttributes(ModTiers.ALLUMINITE, 4, -2.3f))));
    public static final DeferredItem<Item> ALLUMINITE_SHOVEL = ITEMS.register("alluminite_shovel",
            () -> new ShovelItem(ModTiers.ALLUMINITE, new Item.Properties().attributes(ShovelItem.createAttributes
                    (ModTiers.ALLUMINITE, 3, -2.3f))));
    public static final DeferredItem<Item> ALLUMINITE_HOE = ITEMS.register("alluminite_hoe",
            () -> new HoeItem(ModTiers.ALLUMINITE, new Item.Properties().attributes
                    (HoeItem.createAttributes(ModTiers.ALLUMINITE, 3, -2.3f))));

    public static final DeferredItem<Item> ALLUMINITE_HELMET = ITEMS.register("alluminite_helmet",
            () -> new ModArmorItem(ModArmorMaterials.ALLUMINITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(20))));
    public static final DeferredItem<Item> ALLUMINITE_CHESTPLATE = ITEMS.register("alluminite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ALLUMINITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(20))));
    public static final DeferredItem<Item> ALLUMINITE_LEGGINGS = ITEMS.register("alluminite_leggings",
            () -> new ArmorItem(ModArmorMaterials.ALLUMINITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(20))));
    public static final DeferredItem<Item> ALLUMINITE_BOOTS = ITEMS.register("alluminite_boots",
            () -> new ArmorItem(ModArmorMaterials.ALLUMINITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(20))));


    public static final DeferredItem<Item> OBSIDIAN_HELMET = ITEMS.register("obsidian_helmet",
            () -> new ModArmorItem(ModArmorMaterials.OBSIDIAN_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(41))));
    public static final DeferredItem<Item> OBSIDIAN_CHESTPLATE = ITEMS.register("obsidian_chestplate",
            () -> new ArmorItem(ModArmorMaterials.OBSIDIAN_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(41))));
    public static final DeferredItem<Item> OBSIDIAN_LEGGINGS = ITEMS.register("obsidian_leggings",
            () -> new ArmorItem(ModArmorMaterials.OBSIDIAN_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(41))));
    public static final DeferredItem<Item> OBSIDIAN_BOOTS = ITEMS.register("obsidian_boots",
            () -> new ArmorItem(ModArmorMaterials.OBSIDIAN_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(41))));


    public static final DeferredItem<Item> OBSIDIAN_SWORD = ITEMS.register("obsidian_sword",
            () -> new SwordItem(ModTiers.OBSIDIAN, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.OBSIDIAN, 8, -2.3f))));
    public static final DeferredItem<Item> OBSIDIAN_AXE = ITEMS.register("obsidian_axe",
            () -> new AxeItem(ModTiers.OBSIDIAN, new Item.Properties().attributes(AxeItem.createAttributes
                    (ModTiers.OBSIDIAN, 11, -3.3f))));
    public static final DeferredItem<Item> OBSIDIAN_PICKAXE = ITEMS.register("obsidian_pickaxe",
            () -> new PickaxeItem(ModTiers.OBSIDIAN, new Item.Properties().attributes
                    (PickaxeItem.createAttributes(ModTiers.OBSIDIAN, 4, -2.5f))));
    public static final DeferredItem<Item> OBSIDIAN_SHOVEL = ITEMS.register("obsidian_shovel",
            () -> new ShovelItem(ModTiers.OBSIDIAN, new Item.Properties().attributes(ShovelItem.createAttributes
                    (ModTiers.OBSIDIAN, 3, -2.5f))));
    public static final DeferredItem<Item> OBSIDIAN_HOE = ITEMS.register("obsidian_hoe",
            () -> new HoeItem(ModTiers.OBSIDIAN, new Item.Properties().attributes
                    (HoeItem.createAttributes(ModTiers.OBSIDIAN, 3, -2.5f))));

    public static final DeferredItem<Item> ALLUMINITE_ROD = ITEMS.register("alluminite_rod",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ALLUMINITE_ROD_SHARD = ITEMS.register("alluminite_rod_shard",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> EMPTY_CHARM = ITEMS.register("empty_charm",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BASIC_DIRT_CHARM = ITEMS.register("basic_dirt_charm",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BASIC_DIRT_PATH_CHARM = ITEMS.register("basic_dirt_path_charm",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ADVANCED_DIRT_PATH_CHARM = ITEMS.register("advanced_dirt_path_charm",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BLUE_DIRT_CHARM = ITEMS.register("blue_dirt_charm",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BLUE_DIRT_PATH_CHARM = ITEMS.register("blue_dirt_path_charm",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> YELLOW_DIRT_CHARM = ITEMS.register("yellow_dirt_charm",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> YELLOW_DIRT_PATH_CHARM = ITEMS.register("yellow_dirt_path_charm",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RED_DIRT_CHARM = ITEMS.register("red_dirt_charm",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RED_DIRT_PATH_CHARM = ITEMS.register("red_dirt_path_charm",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ALLUMIN_LUMINIUM_DIRT_CHARM = ITEMS.register("combined_dirt_charm",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ALLUMIN_LUMINIUM_DIRT_PATH_CHARM = ITEMS.register("combined_dirt_path_charm",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> UNFILTERED_SUGAR = ITEMS.register("unfiltered_sugar",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SALT_ROCK = ITEMS.register("salt_rock",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SALT = ITEMS.register("salt",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ORANGE_SEED_POWDER = ITEMS.register("orange_seed_powder",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ORANGE_SEED_MILK = ITEMS.register("orange_seed_milk_bucket",
            () -> new ModMilkBucketItem(new Item.Properties()));

    public static final DeferredItem<Item> SALAD_TOPPINGS = ITEMS.register("salad_toppings",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SPRING_SALAD_TOPPINGS = ITEMS.register("spring_salad_toppings",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SPECIAL_SALAD_TOPPINGS = ITEMS.register("special_salad_toppings",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RANCH_BOTTLE = ITEMS.register("ranch_bottle",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> KETCHUP_BOTTLE = ITEMS.register("ketchup_bottle",
            () -> new PotionItem(new Item.Properties().food(ModFoods.KETCHUP_BOTTLE)));

    public static final DeferredItem<Item> CRUSHED_TOMATO = ITEMS.register("crushed_tomato",
            () -> new Item(new Item.Properties().food(ModFoods.CRUSHED_TOMATO)));

    public static final DeferredItem<Item> CRUSHED_TOMATO_BOTTLE = ITEMS.register("crushed_tomato_bottle",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BREAD_SLICE = ITEMS.register("bread_slice",
            () -> new Item(new Item.Properties().food(ModFoods.BREAD_SLICE)));

    public static final DeferredItem<Item> VEGETABLE_OIL = ITEMS.register("vegetable_oil",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> HEARTY_STEW = ITEMS.register("hearty_stew",
            () -> new Item(new Item.Properties().food(ModFoods.HEARTY_STEW).stacksTo(1)));

    public static final DeferredItem<Item> BOILED_EGG = ITEMS.register("boiled_egg",
            () -> new Item(new Item.Properties().food(ModFoods.BOILED_EGG).stacksTo(16)));

    public static final DeferredItem<Item> FRIED_EGG = ITEMS.register("fried_egg",
            () -> new Item(new Item.Properties().food(ModFoods.BOILED_EGG).stacksTo(16))); // All egg variants have same ModFoods

    public static final DeferredItem<Item> SALTED_RAW_BEEF = ITEMS.register("salted_raw_beef",
            () -> new Item(new Item.Properties().food(ModFoods.SALTED_RAW_BEEF)));

    public static final DeferredItem<Item> SALTED_RAW_PORKCHOP = ITEMS.register("salted_raw_porkchop",
            () -> new Item(new Item.Properties().food(ModFoods.SALTED_RAW_PORKCHOP)));

    public static final DeferredItem<Item> SALTED_RAW_CHICKEN = ITEMS.register("salted_raw_chicken",
            () -> new Item(new Item.Properties().food(ModFoods.SALTED_RAW_CHICKEN)));

    public static final DeferredItem<Item> SALTED_RAW_MUTTON = ITEMS.register("salted_raw_mutton",
            () -> new Item(new Item.Properties().food(ModFoods.SALTED_RAW_MUTTON)));

    public static final DeferredItem<Item> SALTED_RAW_RABBIT = ITEMS.register("salted_raw_rabbit",
            () -> new Item(new Item.Properties().food(ModFoods.SALTED_RAW_RABBIT)));

    public static final DeferredItem<Item> SALTED_RAW_COD = ITEMS.register("salted_raw_cod",
            () -> new Item(new Item.Properties().food(ModFoods.SALTED_RAW_COD)));

    public static final DeferredItem<Item> SALTED_RAW_SALMON = ITEMS.register("salted_raw_salmon",
            () -> new Item(new Item.Properties().food(ModFoods.SALTED_RAW_SALMON)));

    public static final DeferredItem<Item> TOAST = ITEMS.register("toast",
            () -> new Item(new Item.Properties().food(ModFoods.TOAST)));

    public static final DeferredItem<Item> POTATO_BITS = ITEMS.register("potato_bits",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SALTED_POTATO_CHIPS = ITEMS.register("chips",
            () -> new Item(new Item.Properties().food(ModFoods.CHIPS)));

    public static final DeferredItem<Item> IRON_CHUNKS = ITEMS.register("iron_chunks",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> IRON_POWDER = ITEMS.register("iron_powder",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> IRON_INFUSED_MILK = ITEMS.register("iron_milk_bucket",
            () -> new ModMilkBucketItem2(new Item.Properties()));

    public static final DeferredItem<Item> DIAMOND_CHUNKS = ITEMS.register("diamond_chunks",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> DIAMOND_POWDER = ITEMS.register("diamond_dust",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> DIAMOND_INFUSED_MILK = ITEMS.register("diamond_milk_bucket",
            () -> new ModMilkBucketItem3(new Item.Properties()));

    public static final DeferredItem<Item> GOAT_MILK = ITEMS.register("goat_milk",
            () -> new ModMilkBucketItem4(new Item.Properties()));

    public static final DeferredItem<Item> GOAT_CHEESE = ITEMS.register("goat_cheese",
            () -> new Item(new Item.Properties().food(ModFoods.GOAT_CHEESE)));

    public static final DeferredItem<Item> SLICED_GOAT_CHEESE = ITEMS.register("sliced_goat_cheese",
            () -> new Item(new Item.Properties().food(ModFoods.SLICED_GOAT_CHEESE)));

    public static final DeferredItem<Item> GOAT_BUTTER = ITEMS.register("goat_butter",
            () -> new Item(new Item.Properties().food(ModFoods.GOAT_BUTTER)));

    public static final DeferredItem<Item> GOAT_ICE_CREAM = ITEMS.register("goat_ice_cream",
            () -> new Item(new Item.Properties().food(ModFoods.GOAT_ICE_CREAM)));

    public static final DeferredItem<Item> VANILLA_GOAT_YOGURT = ITEMS.register("vanilla_goat_yogurt",
            () -> new Item(new Item.Properties().food(ModFoods.VANILLA_GOAT_YOGURT)));

    public static final DeferredItem<Item> GOAT_CAKE_ITEM = ITEMS.register("goat_cake",
            () -> new BlockItem(ModBlocks.GOAT_CAKE.get(), new Item.Properties()));

    public static final DeferredItem<Item> CATALPA_SIGN = ITEMS.register("catalpa_sign",
            () -> new ModSignItem(new Item.Properties().stacksTo(16), ModBlocks.CATALPA_SIGN.get(), ModBlocks.CATALPA_WALL_SIGN.get(),
                    200));
    public static final DeferredItem<Item> CATALPA_HANGING_SIGN = ITEMS.register("catalpa_hanging_sign",
            () -> new ModHangingSignItem(ModBlocks.CATALPA_HANGING_SIGN.get(), ModBlocks.CATALPA_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16),
                    200));

    public static final DeferredItem<Item> RED_MAPLE_SIGN = ITEMS.register("red_maple_sign",
            () -> new ModSignItem(new Item.Properties().stacksTo(16), ModBlocks.RED_MAPLE_SIGN.get(), ModBlocks.RED_MAPLE_WALL_SIGN.get(),
                    200));
    public static final DeferredItem<Item> RED_MAPLE_HANGING_SIGN = ITEMS.register("red_maple_hanging_sign",
            () -> new ModHangingSignItem(ModBlocks.RED_MAPLE_HANGING_SIGN.get(), ModBlocks.RED_MAPLE_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16),
                    200));

    public static final DeferredItem<Item> CUCUMBER = ITEMS.register("cucumber",
            () -> new Item(new Item.Properties().food(ModFoods.CUCUMBER)));

    public static final DeferredItem<Item> STEAK_LETTUCE_SANDWICH = ITEMS.register("steak_lettuce_sandwich",
            () -> new Item(new Item.Properties().food(ModFoods.STEAK_LETTUCE_SANDWICH)));

    public static final DeferredItem<Item> TOASTED_STEAK_LETTUCE_SANDWICH = ITEMS.register("sl_sandwich_toasted",
            () -> new Item(new Item.Properties().food(ModFoods.TOASTED_STEAK_LETTUCE_SANDWICH)));

    public static final DeferredItem<Item> CHEESE_MEAT_SANDWICH = ITEMS.register("cheese_meat_sandwich",
            () -> new Item(new Item.Properties().food(ModFoods.CHEESE_MEAT_SANDWICH)));

    public static final DeferredItem<Item> VEGAN_SANDWICH = ITEMS.register("vegan_sandwich",
            () -> new Item(new Item.Properties().food(ModFoods.VEGAN_SANDWICH)));

    public static final DeferredItem<Item> MEATY_SANDWICH = ITEMS.register("meaty_sandwich",
            () -> new Item(new Item.Properties().food(ModFoods.MEATY_SANDWICH)));

    public static final DeferredItem<Item> CROUTON = ITEMS.register("crouton",
            () -> new Item(new Item.Properties().food(ModFoods.CROUTON)));

    public static final DeferredItem<Item> LETTUCE = ITEMS.register("lettuce",
            () -> new Item(new Item.Properties().food(ModFoods.LETTUCE)));

    public static final DeferredItem<Item> ORANGE = ITEMS.register("orange",
            () -> new Item(new Item.Properties().food(ModFoods.ORANGE)));

    public static final DeferredItem<Item> TOMATO = ITEMS.register("tomato",
            () -> new Item(new Item.Properties().food(ModFoods.TOMATO)));

    public static final DeferredItem<Item> BROCCOLI = ITEMS.register("broccoli",
            () -> new Item(new Item.Properties().food(ModFoods.BROCCOLI)));

    public static final DeferredItem<Item> CORN = ITEMS.register("corn",
            () -> new Item(new Item.Properties().food(ModFoods.CORN)));

    public static final DeferredItem<Item> SALAD = ITEMS.register("salad",
            () -> new Item(new Item.Properties().food(ModFoods.SALAD).stacksTo(1)));

    public static final DeferredItem<Item> SPRING_SALAD = ITEMS.register("spring_salad",
            () -> new Item(new Item.Properties().food(ModFoods.SPRING_SALAD).stacksTo(1)));

    public static final DeferredItem<Item> SPECIAL_SALAD = ITEMS.register("special_salad",
            () -> new Item(new Item.Properties().food(ModFoods.SPECIAL_SALAD).stacksTo(1)));

    public static final DeferredItem<Item> BERRY_BOWL = ITEMS.register("berry_bowl",
            () -> new Item(new Item.Properties().food(ModFoods.BERRY_BOWL)));

    public static final DeferredItem<Item> BERRY_TOAST = ITEMS.register("berry_toast",
            () -> new Item(new Item.Properties().food(ModFoods.BERRY_TOAST)));

    public static final DeferredItem<Item> BANANA = ITEMS.register("banana",
       () -> new Item(new Item.Properties().food(ModFoods.BANANA)));

    public static final DeferredItem<Item> BANANA_SANDWICH = ITEMS.register("banana_sandwich",
            () -> new Item(new Item.Properties().food(ModFoods.BANANA_SANDWICH)));

    public static final DeferredItem<Item> CUCUMBER_SEEDS = ITEMS.register("cucumber_seeds",
            () -> new ItemNameBlockItem(ModBlocks.CUCUMBER_SEEDS_BLOCK.get(),
                    new Item.Properties()));

    public static final DeferredItem<Item> LETTUCE_SEEDS = ITEMS.register("lettuce_seeds",
            () -> new ItemNameBlockItem(ModBlocks.LETTUCE_SEEDS_BLOCK.get(),
                    new Item.Properties()));

    public static final DeferredItem<Item> ORANGE_SEEDS = ITEMS.register("orange_seeds",
            () -> new ItemNameBlockItem(ModBlocks.ORANGE_SEEDS_BLOCK.get(),
                    new Item.Properties()));

    public static final DeferredItem<Item> TOMATO_SEEDS = ITEMS.register("tomato_seeds",
            () -> new ItemNameBlockItem(ModBlocks.TOMATO_SEEDS_BLOCK.get(),
                    new Item.Properties()));

    public static final DeferredItem<Item> BROCCOLI_SEEDS = ITEMS.register("broccoli_seeds",
            () -> new ItemNameBlockItem(ModBlocks.BROCCOLI_SEEDS_BLOCK.get(),
                    new Item.Properties()));

    public static final DeferredItem<Item> CORN_SEEDS = ITEMS.register("corn_seeds",
            () -> new ItemNameBlockItem(ModBlocks.CORN_SEEDS_BLOCK.get(),
                    new Item.Properties()));

    public static final DeferredItem<Item> BLUEBERRIES = ITEMS.register("blueberries",
            () -> new ItemNameBlockItem(ModBlocks.BLUEBERRY_BUSH.get(),
                    new Item.Properties().food(ModFoods.BLUEBERRY)));

    public static final DeferredItem<Item> RASPBERRIES = ITEMS.register("raspberries",
            () -> new ItemNameBlockItem(ModBlocks.RASPBERRY_BUSH.get(),
                    new Item.Properties().food(ModFoods.RASPBERRY)));


    public static final DeferredItem<Item> CATALPA_BOAT = ITEMS.register("catalpa_boat",
            () -> new ModBoatItem(false, ModBoatEntity.Type.CATALPA, new Item.Properties().stacksTo(1), 200));
    public static final DeferredItem<Item> CATALPA_CHEST_BOAT = ITEMS.register("catalpa_chest_boat",
            () -> new ModBoatItem(true, ModBoatEntity.Type.CATALPA, new Item.Properties().stacksTo(1), 200));

    public static final DeferredItem<Item> RED_MAPLE_BOAT = ITEMS.register("red_maple_boat",
            () -> new ModBoatItem2(false, ModBoatEntity2.Type.RED_MAPLE, new Item.Properties().stacksTo(1), 200));
    public static final DeferredItem<Item> RED_MAPLE_CHEST_BOAT = ITEMS.register("red_maple_chest_boat",
            () -> new ModBoatItem2(true, ModBoatEntity2.Type.RED_MAPLE, new Item.Properties().stacksTo(1), 200));

    public static final DeferredItem<Item> MYSTICAL_MUSIC_DISC = ITEMS.register("mystical_cd",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.MYSTICAL_KEY).stacksTo(1)));

    public static final DeferredItem<Item> MYSTICAL_DISC_FRAGMENT = ITEMS.register("disc_fragment_m",
            () -> new DiscFragmentItem(new Item.Properties()));
}