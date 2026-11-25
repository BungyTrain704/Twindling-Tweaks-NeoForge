package com.austinplays.twindlingtweaks.item;

import com.austinplays.twindlingtweaks.TwindlingTweaks;
import com.austinplays.twindlingtweaks.block.ModBlocks;
import com.austinplays.twindlingtweaks.entity.custom.boat.ModBoatEntity;
import com.austinplays.twindlingtweaks.entity.custom.boat.ModBoatEntity2;
import com.austinplays.twindlingtweaks.item.custom.armor.ModArmorItem;
import com.austinplays.twindlingtweaks.item.custom.armor.materials.ModArmorMaterials;
import com.austinplays.twindlingtweaks.item.custom.armor.tiers.ModTiers;
import com.austinplays.twindlingtweaks.item.custom.boat.ModBoatItem;
import com.austinplays.twindlingtweaks.item.custom.boat.ModBoatItem2;
import com.austinplays.twindlingtweaks.item.custom.food.ModFoods;
import com.austinplays.twindlingtweaks.item.custom.milk.ModMilkBucketItem;
import com.austinplays.twindlingtweaks.item.custom.milk.ModMilkBucketItem2;
import com.austinplays.twindlingtweaks.item.custom.milk.ModMilkBucketItem3;
import com.austinplays.twindlingtweaks.item.custom.milk.ModMilkBucketItem4;
import com.austinplays.twindlingtweaks.item.custom.sign.ModSignItem;
import com.austinplays.twindlingtweaks.item.custom.sign.hanging.ModHangingSignItem;
import com.austinplays.twindlingtweaks.item.custom.throwable.MudBallItem;
import com.austinplays.twindlingtweaks.item.custom.tools.HammerItem;
import com.austinplays.twindlingtweaks.item.custom.tools.KnifeItem;
import com.austinplays.twindlingtweaks.sound.ModSounds;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TwindlingTweaks.MOD_ID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final DeferredItem<Item> STONE_HAMMER =
            ITEMS.registerItem(
                    "stone_hammer",
                    properties -> new HammerItem(
                            ToolMaterial.STONE,
                            properties
                                    .durability(600)
                                    .attributes(
                                            ItemAttributeModifiers.builder()
                                                    .add(
                                                            Attributes.ATTACK_DAMAGE,
                                                            new AttributeModifier(
                                                                    HammerItem.ATTACK_DAMAGE_ID,
                                                                    7.0F + ToolMaterial.STONE.attackDamageBonus(),
                                                                    AttributeModifier.Operation.ADD_VALUE
                                                            ),
                                                            EquipmentSlotGroup.MAINHAND
                                                    )
                                                    .add(
                                                            Attributes.ATTACK_SPEED,
                                                            new AttributeModifier(
                                                                    HammerItem.ATTACK_SPEED_ID,
                                                                    -3.6F,
                                                                    AttributeModifier.Operation.ADD_VALUE
                                                            ),
                                                            EquipmentSlotGroup.MAINHAND
                                                    )
                                                    .build()
                                    )
                    )
            );

    public static final DeferredItem<Item> IRON_HAMMER =
            ITEMS.registerItem(
                    "iron_hammer",
                    properties -> new HammerItem(
                            ToolMaterial.IRON,
                            properties
                                    .durability(900)
                                    .attributes(
                                            ItemAttributeModifiers.builder()
                                                    .add(
                                                            Attributes.ATTACK_DAMAGE,
                                                            new AttributeModifier(
                                                                    HammerItem.ATTACK_DAMAGE_ID,
                                                                    7.0F + ToolMaterial.IRON.attackDamageBonus(),
                                                                    AttributeModifier.Operation.ADD_VALUE
                                                            ),
                                                            EquipmentSlotGroup.MAINHAND
                                                    )
                                                    .add(
                                                            Attributes.ATTACK_SPEED,
                                                            new AttributeModifier(
                                                                    HammerItem.ATTACK_SPEED_ID,
                                                                    -3.6F,
                                                                    AttributeModifier.Operation.ADD_VALUE
                                                            ),
                                                            EquipmentSlotGroup.MAINHAND
                                                    )
                                                    .build()
                                    )
                    )
            );

    public static final DeferredItem<Item> DIAMOND_HAMMER =
            ITEMS.registerItem(
                    "diamond_hammer",
                    properties -> new HammerItem(
                            ToolMaterial.DIAMOND,
                            properties
                                    .durability(1800)
                                    .attributes(
                                            ItemAttributeModifiers.builder()
                                                    .add(
                                                            Attributes.ATTACK_DAMAGE,
                                                            new AttributeModifier(
                                                                    HammerItem.ATTACK_DAMAGE_ID,
                                                                    7.0F + ToolMaterial.DIAMOND.attackDamageBonus(),
                                                                    AttributeModifier.Operation.ADD_VALUE
                                                            ),
                                                            EquipmentSlotGroup.MAINHAND
                                                    )
                                                    .add(
                                                            Attributes.ATTACK_SPEED,
                                                            new AttributeModifier(
                                                                    HammerItem.ATTACK_SPEED_ID,
                                                                    -3.6F,
                                                                    AttributeModifier.Operation.ADD_VALUE
                                                            ),
                                                            EquipmentSlotGroup.MAINHAND
                                                    )
                                                    .build()
                                    )
                    )
            );

    public static final DeferredItem<Item> OBSIDIAN_HAMMER =
            ITEMS.registerItem(
                    "obsidian_hammer",
                    properties -> new HammerItem(
                            ModTiers.OBSIDIAN,
                            properties
                                    .durability(4000)
                                    .attributes(
                                            ItemAttributeModifiers.builder()
                                                    .add(
                                                            Attributes.ATTACK_DAMAGE,
                                                            new AttributeModifier(
                                                                    HammerItem.ATTACK_DAMAGE_ID,
                                                                    16.0F + ModTiers.OBSIDIAN.attackDamageBonus(),
                                                                    AttributeModifier.Operation.ADD_VALUE
                                                            ),
                                                            EquipmentSlotGroup.MAINHAND
                                                    )
                                                    .add(
                                                            Attributes.ATTACK_SPEED,
                                                            new AttributeModifier(
                                                                    HammerItem.ATTACK_SPEED_ID,
                                                                    -3.9F,
                                                                    AttributeModifier.Operation.ADD_VALUE
                                                            ),
                                                            EquipmentSlotGroup.MAINHAND
                                                    )
                                                    .build()
                                    )
                    )
            );

    public static final DeferredItem<Item> COOKING_KNIFE =
            ITEMS.registerItem(
                    "cooking_knife",
                    properties -> new KnifeItem(
                            ToolMaterial.IRON,
                            properties
                                    .durability(800)
                                    .attributes(
                                            ItemAttributeModifiers.builder()
                                                    .add(
                                                            Attributes.ATTACK_DAMAGE,
                                                            new AttributeModifier(
                                                                    KnifeItem.ATTACK_DAMAGE_ID,
                                                                    3.0F + ToolMaterial.IRON.attackDamageBonus(),
                                                                    AttributeModifier.Operation.ADD_VALUE
                                                            ),
                                                            EquipmentSlotGroup.MAINHAND
                                                    )
                                                    .add(
                                                            Attributes.ATTACK_SPEED,
                                                            new AttributeModifier(
                                                                    KnifeItem.ATTACK_SPEED_ID,
                                                                    -2.3F,
                                                                    AttributeModifier.Operation.ADD_VALUE
                                                            ),
                                                            EquipmentSlotGroup.MAINHAND
                                                    )
                                                    .build()
                                    )
                    )
            );

    public static final DeferredItem<Item> MUD_BALL = ITEMS.registerItem("mud_ball",
            (properties) -> new MudBallItem(properties.stacksTo(32)));

    public static final DeferredItem<Item> DRIED_MUD_BALL = ITEMS.registerItem("dried_mud_ball",
            (properties) -> new Item(properties.food(ModFoods.DRIED_MUD_BALL, ModFoods.DRIED_MUD_BALL_EFFECT)));

    public static final DeferredItem<Item> UNPROCESSED_LUMINIUM_CHUNK = ITEMS.registerItem("unprocessed_luminium_chunk",
            Item::new);

    public static final DeferredItem<Item> LUMINIUM_CHUNK = ITEMS.registerItem("luminium_chunk",
            Item::new);

    public static final DeferredItem<Item> RAW_LUMINIUM = ITEMS.registerItem("raw_luminium",
            Item::new);

    public static final DeferredItem<Item> LUMINIUM_GEM = ITEMS.registerItem("luminium_gem",
            Item::new);

    public static final DeferredItem<Item> REINFORCED_LUMINIUM_GEM = ITEMS.registerItem("reinforced_luminium_gem",
            Item::new);

    public static final DeferredItem<Item> LUMINIUM_APPLE = ITEMS.registerItem("luminium_apple",
            (properties) -> new Item(properties.food(ModFoods.LUMINIUM_APPLE, ModFoods.LUMINIUM_APPLE_EFFECT)));

    public static final DeferredItem<Item> RAW_ALLUMINITE = ITEMS.registerItem("raw_alluminite",
            Item::new);

    public static final DeferredItem<Item> ALLUMINITE_INGOT = ITEMS.registerItem("alluminite_ingot",
            Item::new);

    public static final DeferredItem<Item> UNSTABLE_ALLUMINITE_INGOT = ITEMS.registerItem("unstable_alluminite_ingot",
            Item::new);

    public static final DeferredItem<Item> ALLUMINITE_NUGGET = ITEMS.registerItem("alluminite_nugget",
            Item::new);

    public static final DeferredItem<Item> REINFORCED_ALLUMINITE_INGOT = ITEMS.registerItem("reinforced_alluminite_ingot",
            Item::new);

    public static final DeferredItem<Item> ALLUMINITE_SWORD = ITEMS.registerItem("alluminite_sword",
            (properties) -> new SwordItem(ModTiers.ALLUMINITE, 7, -2.2f, properties));
    public static final DeferredItem<Item> ALLUMINITE_AXE = ITEMS.registerItem("alluminite_axe",
            (properties) -> new AxeItem(ModTiers.ALLUMINITE, 9, -3.1f, properties));
    public static final DeferredItem<Item> ALLUMINITE_PICKAXE = ITEMS.registerItem("alluminite_pickaxe",
            (properties) -> new PickaxeItem(ModTiers.ALLUMINITE, 4, -2.3f, properties));
    public static final DeferredItem<Item> ALLUMINITE_SHOVEL = ITEMS.registerItem("alluminite_shovel",
            (properties) -> new ShovelItem(ModTiers.ALLUMINITE, 3, -2.3f, properties));
    public static final DeferredItem<Item> ALLUMINITE_HOE = ITEMS.registerItem("alluminite_hoe",
            (properties) -> new HoeItem(ModTiers.ALLUMINITE, 3, -2.3f, properties));

    public static final DeferredItem<Item> ALLUMINITE_HELMET = ITEMS.registerItem("alluminite_helmet",
            (properties) -> new ModArmorItem(ModArmorMaterials.ALLUMINITE_ARMOR_MATERIAL, ArmorType.HELMET,
                    properties));
    public static final DeferredItem<Item> ALLUMINITE_CHESTPLATE = ITEMS.registerItem("alluminite_chestplate",
            (properties) -> new ArmorItem(ModArmorMaterials.ALLUMINITE_ARMOR_MATERIAL, ArmorType.CHESTPLATE,
                    properties));
    public static final DeferredItem<Item> ALLUMINITE_LEGGINGS = ITEMS.registerItem("alluminite_leggings",
            (properties) -> new ArmorItem(ModArmorMaterials.ALLUMINITE_ARMOR_MATERIAL, ArmorType.LEGGINGS,
                    properties));
    public static final DeferredItem<Item> ALLUMINITE_BOOTS = ITEMS.registerItem("alluminite_boots",
            (properties) -> new ArmorItem(ModArmorMaterials.ALLUMINITE_ARMOR_MATERIAL, ArmorType.BOOTS,
                    properties));


    public static final DeferredItem<Item> OBSIDIAN_HELMET = ITEMS.registerItem("obsidian_helmet",
            (properties) -> new ModArmorItem(ModArmorMaterials.OBSIDIAN_ARMOR_MATERIAL, ArmorType.HELMET,
                    properties));
    public static final DeferredItem<Item> OBSIDIAN_CHESTPLATE = ITEMS.registerItem("obsidian_chestplate",
            (properties) -> new ArmorItem(ModArmorMaterials.OBSIDIAN_ARMOR_MATERIAL, ArmorType.CHESTPLATE,
                    properties));
    public static final DeferredItem<Item> OBSIDIAN_LEGGINGS = ITEMS.registerItem("obsidian_leggings",
            (properties) -> new ArmorItem(ModArmorMaterials.OBSIDIAN_ARMOR_MATERIAL, ArmorType.LEGGINGS,
                    properties));
    public static final DeferredItem<Item> OBSIDIAN_BOOTS = ITEMS.registerItem("obsidian_boots",
            (properties) -> new ArmorItem(ModArmorMaterials.OBSIDIAN_ARMOR_MATERIAL, ArmorType.BOOTS,
                    properties));


    public static final DeferredItem<Item> OBSIDIAN_SWORD = ITEMS.registerItem("obsidian_sword",
            (properties) -> new SwordItem(ModTiers.OBSIDIAN, 8, -2.3f, properties));
    public static final DeferredItem<Item> OBSIDIAN_AXE = ITEMS.registerItem("obsidian_axe",
            (properties) -> new AxeItem(ModTiers.OBSIDIAN, 11, -3.3f, properties));
    public static final DeferredItem<Item> OBSIDIAN_PICKAXE = ITEMS.registerItem("obsidian_pickaxe",
            (properties) -> new PickaxeItem(ModTiers.OBSIDIAN, 4, -2.5f, properties));
    public static final DeferredItem<Item> OBSIDIAN_SHOVEL = ITEMS.registerItem("obsidian_shovel",
            (properties) -> new ShovelItem(ModTiers.OBSIDIAN, 3, -2.5f, properties));
    public static final DeferredItem<Item> OBSIDIAN_HOE = ITEMS.registerItem("obsidian_hoe",
            (properties) -> new HoeItem(ModTiers.OBSIDIAN, 3, -2.5f, properties));

    public static final DeferredItem<Item> ALLUMINITE_ROD = ITEMS.registerItem("alluminite_rod",
            Item::new);

    public static final DeferredItem<Item> ALLUMINITE_ROD_SHARD = ITEMS.registerItem("alluminite_rod_shard",
            Item::new);

    public static final DeferredItem<Item> EMPTY_SCHEMATIC = ITEMS.registerItem("empty_schematic",
            Item::new);

    public static final DeferredItem<Item> BASIC_DIRT_SCHEMATIC = ITEMS.registerItem("basic_dirt_schematic",
            Item::new);

    public static final DeferredItem<Item> BASIC_DIRT_PATH_SCHEMATIC = ITEMS.registerItem("basic_dirt_path_schematic",
            Item::new);

    public static final DeferredItem<Item> ADVANCED_DIRT_PATH_SCHEMATIC = ITEMS.registerItem("advanced_dirt_path_schematic",
            Item::new);

    public static final DeferredItem<Item> BLUE_DIRT_SCHEMATIC = ITEMS.registerItem("blue_dirt_schematic",
            Item::new);

    public static final DeferredItem<Item> BLUE_DIRT_PATH_SCHEMATIC = ITEMS.registerItem("blue_dirt_path_schematic",
            Item::new);

    public static final DeferredItem<Item> YELLOW_DIRT_SCHEMATIC = ITEMS.registerItem("yellow_dirt_schematic",
            Item::new);

    public static final DeferredItem<Item> YELLOW_DIRT_PATH_SCHEMATIC = ITEMS.registerItem("yellow_dirt_path_schematic",
            Item::new);

    public static final DeferredItem<Item> RED_DIRT_SCHEMATIC = ITEMS.registerItem("red_dirt_schematic",
            Item::new);

    public static final DeferredItem<Item> RED_DIRT_PATH_SCHEMATIC = ITEMS.registerItem("red_dirt_path_schematic",
            Item::new);

    public static final DeferredItem<Item> ALLUMIN_LUMINIUM_DIRT_SCHEMATIC = ITEMS.registerItem("combined_dirt_schematic",
            Item::new);

    public static final DeferredItem<Item> ALLUMIN_LUMINIUM_DIRT_PATH_SCHEMATIC = ITEMS.registerItem("combined_dirt_path_schematic",
            Item::new);

    public static final DeferredItem<Item> UNFILTERED_SUGAR = ITEMS.registerItem("unfiltered_sugar",
            Item::new);

    public static final DeferredItem<Item> SALT_ROCK = ITEMS.registerItem("salt_rock",
            Item::new);

    public static final DeferredItem<Item> SALT = ITEMS.registerItem("salt",
            Item::new);

    public static final DeferredItem<Item> ORANGE_SEED_POWDER = ITEMS.registerItem("orange_seed_powder",
            Item::new);

    public static final DeferredItem<Item> ORANGE_SEED_MILK = ITEMS.registerItem("orange_seed_milk_bucket",
            (properties) -> new ModMilkBucketItem(properties.stacksTo(1)));

    public static final DeferredItem<Item> SALAD_TOPPINGS = ITEMS.registerItem("salad_toppings",
            Item::new);

    public static final DeferredItem<Item> SPRING_SALAD_TOPPINGS = ITEMS.registerItem("spring_salad_toppings",
            Item::new);

    public static final DeferredItem<Item> SPECIAL_SALAD_TOPPINGS = ITEMS.registerItem("special_salad_toppings",
            Item::new);

    public static final DeferredItem<Item> RANCH_BOTTLE = ITEMS.registerItem("ranch_bottle",
            Item::new);

    public static final DeferredItem<Item> KETCHUP_BOTTLE = ITEMS.registerItem("ketchup_bottle",
            (properties) -> new PotionItem(properties.food(ModFoods.KETCHUP_BOTTLE)));

    public static final DeferredItem<Item> CRUSHED_TOMATO = ITEMS.registerItem("crushed_tomato",
            (properties) -> new Item(properties.food(ModFoods.CRUSHED_TOMATO)));

    public static final DeferredItem<Item> CRUSHED_TOMATO_BOTTLE = ITEMS.registerItem("crushed_tomato_bottle",
            Item::new);

    public static final DeferredItem<Item> BREAD_SLICE = ITEMS.registerItem("bread_slice",
            (properties) -> new Item(properties.food(ModFoods.BREAD_SLICE)));

    public static final DeferredItem<Item> VEGETABLE_OIL = ITEMS.registerItem("vegetable_oil",
            Item::new);

    public static final DeferredItem<Item> HEARTY_STEW = ITEMS.registerItem("hearty_stew",
            (properties) -> new Item(properties.food(ModFoods.HEARTY_STEW, ModFoods.HEARTY_STEW_EFFECT).stacksTo(1)));

    public static final DeferredItem<Item> BOILED_EGG = ITEMS.registerItem("boiled_egg",
            (properties) -> new Item(properties.food(ModFoods.BOILED_EGG).stacksTo(16)));

    public static final DeferredItem<Item> FRIED_EGG = ITEMS.registerItem("fried_egg",
            (properties) -> new Item(properties.food(ModFoods.BOILED_EGG).stacksTo(16))); // All egg variants have same ModFoods

    public static final DeferredItem<Item> SALTED_RAW_BEEF = ITEMS.registerItem("salted_raw_beef",
            (properties) -> new Item(properties.food(ModFoods.SALTED_RAW_BEEF)));

    public static final DeferredItem<Item> SALTED_RAW_PORKCHOP = ITEMS.registerItem("salted_raw_porkchop",
            (properties) -> new Item(properties.food(ModFoods.SALTED_RAW_PORKCHOP)));

    public static final DeferredItem<Item> SALTED_RAW_CHICKEN = ITEMS.registerItem("salted_raw_chicken",
            (properties) -> new Item(properties.food(ModFoods.SALTED_RAW_CHICKEN, ModFoods.SALTED_RAW_CHICKEN_EFFECT)));

    public static final DeferredItem<Item> SALTED_RAW_MUTTON = ITEMS.registerItem("salted_raw_mutton",
            (properties) -> new Item(properties.food(ModFoods.SALTED_RAW_MUTTON)));

    public static final DeferredItem<Item> SALTED_RAW_RABBIT = ITEMS.registerItem("salted_raw_rabbit",
            (properties) -> new Item(properties.food(ModFoods.SALTED_RAW_RABBIT)));

    public static final DeferredItem<Item> SALTED_RAW_COD = ITEMS.registerItem("salted_raw_cod",
            (properties) -> new Item(properties.food(ModFoods.SALTED_RAW_COD)));

    public static final DeferredItem<Item> SALTED_RAW_SALMON = ITEMS.registerItem("salted_raw_salmon",
            (properties) -> new Item(properties.food(ModFoods.SALTED_RAW_SALMON)));

    public static final DeferredItem<Item> TOAST = ITEMS.registerItem("toast",
            (properties) -> new Item(properties.food(ModFoods.TOAST)));

    public static final DeferredItem<Item> POTATO_BITS = ITEMS.registerItem("potato_bits",
            Item::new);

    public static final DeferredItem<Item> SALTED_POTATO_CHIPS = ITEMS.registerItem("chips",
            (properties) -> new Item(properties.food(ModFoods.CHIPS)));

    public static final DeferredItem<Item> IRON_CHUNKS = ITEMS.registerItem("iron_chunks",
            Item::new);

    public static final DeferredItem<Item> IRON_POWDER = ITEMS.registerItem("iron_powder",
            Item::new);

    public static final DeferredItem<Item> IRON_INFUSED_MILK = ITEMS.registerItem("iron_milk_bucket",
            (properties) -> new ModMilkBucketItem2(properties.stacksTo(1)));

    public static final DeferredItem<Item> DIAMOND_CHUNKS = ITEMS.registerItem("diamond_chunks",
            Item::new);

    public static final DeferredItem<Item> DIAMOND_POWDER = ITEMS.registerItem("diamond_dust",
            Item::new);

    public static final DeferredItem<Item> DIAMOND_INFUSED_MILK = ITEMS.registerItem("diamond_milk_bucket",
            (properties) -> new ModMilkBucketItem3(properties.stacksTo(1)));

    public static final DeferredItem<Item> GOAT_MILK = ITEMS.registerItem("goat_milk",
            (properties) -> new ModMilkBucketItem4(properties.stacksTo(1)));

    public static final DeferredItem<Item> GOAT_CHEESE = ITEMS.registerItem("goat_cheese",
            (properties) -> new Item(properties.food(ModFoods.GOAT_CHEESE)));

    public static final DeferredItem<Item> SLICED_GOAT_CHEESE = ITEMS.registerItem("sliced_goat_cheese",
            (properties) -> new Item(properties.food(ModFoods.SLICED_GOAT_CHEESE)));

    public static final DeferredItem<Item> GOAT_BUTTER = ITEMS.registerItem("goat_butter",
            (properties) -> new Item(properties.food(ModFoods.GOAT_BUTTER, ModFoods.GOAT_BUTTER_EFFECT)));

    public static final DeferredItem<Item> GOAT_ICE_CREAM = ITEMS.registerItem("goat_ice_cream",
            (properties) -> new Item(properties.food(ModFoods.GOAT_ICE_CREAM)));

    public static final DeferredItem<Item> VANILLA_GOAT_YOGURT = ITEMS.registerItem("vanilla_goat_yogurt",
            (properties) -> new Item(properties.food(ModFoods.VANILLA_GOAT_YOGURT, ModFoods.VANILLA_GOAT_YOGURT_EFFECT)));

    public static final DeferredItem<Item> GOAT_CAKE_ITEM =
            ITEMS.register(
                    "goat_cake",
                    id -> new BlockItem(
                            ModBlocks.GOAT_CAKE.value(),
                            new Item.Properties()
                                    .setId(ResourceKey.create(Registries.ITEM, id))
                    )
            );

    public static final DeferredItem<Item> CATALPA_SIGN = ITEMS.registerItem("catalpa_sign",
            (properties) -> new ModSignItem(properties.stacksTo(16), ModBlocks.CATALPA_SIGN.get(), ModBlocks.CATALPA_WALL_SIGN.get(),
                    200));
    public static final DeferredItem<Item> CATALPA_HANGING_SIGN = ITEMS.registerItem("catalpa_hanging_sign",
            (properties) -> new ModHangingSignItem(ModBlocks.CATALPA_HANGING_SIGN.get(), ModBlocks.CATALPA_WALL_HANGING_SIGN.get(), properties.stacksTo(16),
                    200));

    public static final DeferredItem<Item> RED_MAPLE_SIGN = ITEMS.registerItem("red_maple_sign",
            (properties) -> new ModSignItem(properties.stacksTo(16), ModBlocks.RED_MAPLE_SIGN.get(), ModBlocks.RED_MAPLE_WALL_SIGN.get(),
                    200));
    public static final DeferredItem<Item> RED_MAPLE_HANGING_SIGN = ITEMS.registerItem("red_maple_hanging_sign",
            (properties) -> new ModHangingSignItem(ModBlocks.RED_MAPLE_HANGING_SIGN.get(), ModBlocks.RED_MAPLE_WALL_HANGING_SIGN.get(), properties.stacksTo(16),
                    200));

    public static final DeferredItem<Item> CUCUMBER = ITEMS.registerItem("cucumber",
            (properties) -> new Item(properties.food(ModFoods.CUCUMBER, ModFoods.CUCUMBER_EFFECT)));

    public static final DeferredItem<Item> STEAK_LETTUCE_SANDWICH = ITEMS.registerItem("steak_lettuce_sandwich",
            (properties) -> new Item(properties.food(ModFoods.STEAK_LETTUCE_SANDWICH, ModFoods.STEAK_LETTUCE_SANDWICH_EFFECT)));

    public static final DeferredItem<Item> TOASTED_STEAK_LETTUCE_SANDWICH = ITEMS.registerItem("sl_sandwich_toasted",
            (properties) -> new Item(properties.food(ModFoods.TOASTED_STEAK_LETTUCE_SANDWICH, ModFoods.TOASTED_STEAK_LETTUCE_SANDWICH_EFFECT)));

    public static final DeferredItem<Item> CHEESE_MEAT_SANDWICH = ITEMS.registerItem("cheese_meat_sandwich",
            (properties) -> new Item(properties.food(ModFoods.CHEESE_MEAT_SANDWICH)));

    public static final DeferredItem<Item> VEGAN_SANDWICH = ITEMS.registerItem("vegan_sandwich",
            (properties) -> new Item(properties.food(ModFoods.VEGAN_SANDWICH, ModFoods.VEGAN_SANDWICH_EFFECT)));

    public static final DeferredItem<Item> MEATY_SANDWICH = ITEMS.registerItem("meaty_sandwich",
            (properties) -> new Item(properties.food(ModFoods.MEATY_SANDWICH, ModFoods.MEATY_SANDWICH_EFFECT)));

    public static final DeferredItem<Item> CROUTON = ITEMS.registerItem("crouton",
            (properties) -> new Item(properties.food(ModFoods.CROUTON)));

    public static final DeferredItem<Item> LETTUCE = ITEMS.registerItem("lettuce",
            (properties) -> new Item(properties.food(ModFoods.LETTUCE, ModFoods.LETTUCE_EFFECT)));

    public static final DeferredItem<Item> ORANGE = ITEMS.registerItem("orange",
            (properties) -> new Item(properties.food(ModFoods.ORANGE, ModFoods.ORANGE_EFFECT)));

    public static final DeferredItem<Item> TOMATO = ITEMS.registerItem("tomato",
            (properties) -> new Item(properties.food(ModFoods.TOMATO)));

    public static final DeferredItem<Item> BROCCOLI = ITEMS.registerItem("broccoli",
            (properties) -> new Item(properties.food(ModFoods.BROCCOLI)));

    public static final DeferredItem<Item> CORN = ITEMS.registerItem("corn",
            (properties) -> new Item(properties.food(ModFoods.CORN)));

    public static final DeferredItem<Item> SALAD = ITEMS.registerItem("salad",
            (properties) -> new Item(properties.food(ModFoods.SALAD, ModFoods.SALAD_EFFECT).stacksTo(1)));

    public static final DeferredItem<Item> SPRING_SALAD = ITEMS.registerItem("spring_salad",
            (properties) -> new Item(properties.food(ModFoods.SPRING_SALAD, ModFoods.SPRING_SALAD_EFFECT).stacksTo(1)));

    public static final DeferredItem<Item> SPECIAL_SALAD = ITEMS.registerItem("special_salad",
            (properties) -> new Item(properties.food(ModFoods.SPECIAL_SALAD, ModFoods.SPECIAL_SALAD_EFFECT).stacksTo(1)));

    public static final DeferredItem<Item> BERRY_BOWL = ITEMS.registerItem("berry_bowl",
            (properties) -> new Item(properties.food(ModFoods.BERRY_BOWL, ModFoods.BERRY_BOWL_EFFECT)));

    public static final DeferredItem<Item> BERRY_TOAST = ITEMS.registerItem("berry_toast",
            (properties) -> new Item(properties.food(ModFoods.BERRY_TOAST)));

    public static final DeferredItem<Item> BANANA = ITEMS.registerItem("banana",
       (properties) -> new Item(properties.food(ModFoods.BANANA)));

    public static final DeferredItem<Item> BANANA_SANDWICH = ITEMS.registerItem("banana_sandwich",
            (properties) -> new Item(properties.food(ModFoods.BANANA_SANDWICH)));

    public static final DeferredItem<Item> CUCUMBER_SEEDS = ITEMS.registerItem("cucumber_seeds",
            (properties) -> new BlockItem(ModBlocks.CUCUMBER_SEEDS_BLOCK.get(),
                    properties));

    public static final DeferredItem<Item> LETTUCE_SEEDS = ITEMS.registerItem("lettuce_seeds",
            (properties) -> new BlockItem(ModBlocks.LETTUCE_SEEDS_BLOCK.get(),
                    properties));

    public static final DeferredItem<Item> ORANGE_SEEDS = ITEMS.registerItem("orange_seeds",
            (properties) -> new BlockItem(ModBlocks.ORANGE_SEEDS_BLOCK.get(),
                    properties));

    public static final DeferredItem<Item> TOMATO_SEEDS = ITEMS.registerItem("tomato_seeds",
            (properties) -> new BlockItem(ModBlocks.TOMATO_SEEDS_BLOCK.get(),
                    properties));

    public static final DeferredItem<Item> BROCCOLI_SEEDS = ITEMS.registerItem("broccoli_seeds",
            (properties) -> new BlockItem(ModBlocks.BROCCOLI_SEEDS_BLOCK.get(),
                    properties));

    public static final DeferredItem<Item> CORN_SEEDS = ITEMS.registerItem("corn_seeds",
            (properties) -> new BlockItem(ModBlocks.CORN_SEEDS_BLOCK.get(),
                    properties));

    public static final DeferredItem<Item> BLUEBERRIES = ITEMS.registerItem("blueberries",
            (properties) -> new BlockItem(ModBlocks.BLUEBERRY_BUSH.get(),
                    properties.food(ModFoods.BLUEBERRY)));

    public static final DeferredItem<Item> RASPBERRIES = ITEMS.registerItem("raspberries",
            (properties) -> new BlockItem(ModBlocks.RASPBERRY_BUSH.get(),
                    properties.food(ModFoods.RASPBERRY)));


    public static final DeferredItem<Item> CATALPA_BOAT = ITEMS.registerItem("catalpa_boat",
            (properties) -> new ModBoatItem(false, ModBoatEntity.Type.CATALPA, properties.stacksTo(1), 200));
    public static final DeferredItem<Item> CATALPA_CHEST_BOAT = ITEMS.registerItem("catalpa_chest_boat",
            (properties) -> new ModBoatItem(true, ModBoatEntity.Type.CATALPA, properties.stacksTo(1), 200));

    public static final DeferredItem<Item> RED_MAPLE_BOAT = ITEMS.registerItem("red_maple_boat",
            (properties) -> new ModBoatItem2(false, ModBoatEntity2.Type.RED_MAPLE, properties.stacksTo(1), 200));
    public static final DeferredItem<Item> RED_MAPLE_CHEST_BOAT = ITEMS.registerItem("red_maple_chest_boat",
            (properties) -> new ModBoatItem2(true, ModBoatEntity2.Type.RED_MAPLE, properties.stacksTo(1), 200));

    public static final DeferredItem<Item> MYSTICAL_MUSIC_DISC = ITEMS.registerItem("mystical_cd",
            (properties) -> new Item(properties.jukeboxPlayable(ModSounds.MYSTICAL_KEY).stacksTo(1)));

    public static final DeferredItem<Item> MYSTICAL_DISC_FRAGMENT = ITEMS.registerItem("disc_fragment_m",
            (properties) -> new DiscFragmentItem(properties));
}