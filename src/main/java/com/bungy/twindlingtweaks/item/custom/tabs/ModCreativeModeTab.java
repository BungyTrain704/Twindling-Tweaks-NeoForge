package com.bungy.twindlingtweaks.item.custom.tabs;

import com.bungy.twindlingtweaks.TwindlingTweaks;
import com.bungy.twindlingtweaks.block.ModBlocks;
import com.bungy.twindlingtweaks.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TwindlingTweaks.MOD_ID);

    public static final Supplier<CreativeModeTab> TWINDLING_TWEAKS_FOODSTUFFS = CREATIVE_MODE_TABS.register("twindling_tweaks_foodstuffs",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TOMATO.get()))
                    .title(Component.translatable("creativetab.twindlingtweaks.twindling_tweaks_foodstuffs"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.GOAT_MILK.get());
                        pOutput.accept(ModItems.ORANGE_SEED_MILK.get());
                        pOutput.accept(ModItems.IRON_INFUSED_MILK.get());
                        pOutput.accept(ModItems.DIAMOND_INFUSED_MILK.get());
                        pOutput.accept(ModItems.SALAD_TOPPINGS.get());
                        pOutput.accept(ModItems.SPRING_SALAD_TOPPINGS.get());
                        pOutput.accept(ModItems.SPECIAL_SALAD_TOPPINGS.get());
                        pOutput.accept(ModItems.SALAD.get());
                        pOutput.accept(ModItems.SPRING_SALAD.get());
                        pOutput.accept(ModItems.SPECIAL_SALAD.get());
                        pOutput.accept(ModItems.RANCH_BOTTLE.get());
                        pOutput.accept(ModItems.KETCHUP_BOTTLE.get());
                        pOutput.accept(ModItems.CRUSHED_TOMATO_BOTTLE.get());
                        pOutput.accept(ModItems.CRUSHED_TOMATO.get());
                        pOutput.accept(ModItems.VEGETABLE_OIL.get());
                        pOutput.accept(ModItems.HEARTY_STEW.get());
                        pOutput.accept(ModItems.GOAT_CHEESE.get());
                        pOutput.accept(ModItems.SLICED_GOAT_CHEESE.get());
                        pOutput.accept(ModItems.GOAT_BUTTER.get());
                        pOutput.accept(ModItems.GOAT_ICE_CREAM.get());
                        pOutput.accept(ModItems.VANILLA_GOAT_YOGURT.get());
                        pOutput.accept(ModItems.GOAT_CAKE_ITEM.get());
                        pOutput.accept(ModItems.CUCUMBER_SEEDS.get());
                        pOutput.accept(ModItems.CUCUMBER.get());
                        pOutput.accept(ModItems.LETTUCE_SEEDS.get());
                        pOutput.accept(ModItems.LETTUCE.get());
                        pOutput.accept(ModItems.ORANGE_SEEDS.get());
                        pOutput.accept(ModItems.ORANGE.get());
                        pOutput.accept(ModItems.TOMATO_SEEDS.get());
                        pOutput.accept(ModItems.TOMATO.get());
                        pOutput.accept(ModItems.BROCCOLI_SEEDS.get());
                        pOutput.accept(ModItems.BROCCOLI.get());
                        pOutput.accept(ModItems.CORN_SEEDS.get());
                        pOutput.accept(ModItems.CORN.get());
                        pOutput.accept(ModItems.BLUEBERRIES.get());
                        pOutput.accept(ModItems.RASPBERRIES.get());
                        pOutput.accept(ModItems.BANANA.get());
                        pOutput.accept(ModItems.BANANA_SANDWICH.get());
                        pOutput.accept(ModItems.BOILED_EGG.get());
                        pOutput.accept(ModItems.FRIED_EGG.get());
                        pOutput.accept(ModItems.SALTED_RAW_BEEF.get());
                        pOutput.accept(ModItems.SALTED_RAW_CHICKEN.get());
                        pOutput.accept(ModItems.SALTED_RAW_PORKCHOP.get());
                        pOutput.accept(ModItems.SALTED_RAW_MUTTON.get());
                        pOutput.accept(ModItems.SALTED_RAW_RABBIT.get());
                        pOutput.accept(ModItems.SALTED_RAW_COD.get());
                        pOutput.accept(ModItems.SALTED_RAW_SALMON.get());
                        pOutput.accept(ModItems.BREAD_SLICE.get());
                        pOutput.accept(ModItems.TOAST.get());
                        pOutput.accept(ModItems.BERRY_TOAST.get());
                        pOutput.accept(ModItems.BERRY_BOWL.get());
                        pOutput.accept(ModItems.CROUTON.get());
                        pOutput.accept(ModItems.POTATO_BITS.get());
                        pOutput.accept(ModItems.SALTED_POTATO_CHIPS.get());
                        pOutput.accept(ModItems.STEAK_LETTUCE_SANDWICH.get());
                        pOutput.accept(ModItems.TOASTED_STEAK_LETTUCE_SANDWICH.get());
                        pOutput.accept(ModItems.CHEESE_MEAT_SANDWICH.get());
                        pOutput.accept(ModItems.VEGAN_SANDWICH.get());
                        pOutput.accept(ModItems.MEATY_SANDWICH.get());
                        pOutput.accept(ModItems.LUMINIUM_APPLE.get());

                    })
                    .build());

    public static final Supplier<CreativeModeTab> TWINDLING_TWEAKS_WOODSTUFFS = CREATIVE_MODE_TABS.register("twindling_tweaks_woodstuffs",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.RED_MAPLE_LOG.get()))
                    .title(Component.translatable("creativetab.twindlingtweaks.twindling_tweaks_woodstuffs"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.CATALPA_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_CATALPA_LOG.get());
                        pOutput.accept(ModBlocks.CATALPA_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_CATALPA_WOOD.get());
                        pOutput.accept(ModBlocks.CATALPA_PLANKS.get());
                        pOutput.accept(ModBlocks.CATALPA_LEAVES.get());
                        pOutput.accept(ModBlocks.CATALPA_FLOWERS.get());
                        pOutput.accept(ModBlocks.CATALPA_SAPLING.get());
                        pOutput.accept(ModBlocks.CATALPA_STAIRS.get());
                        pOutput.accept(ModBlocks.CATALPA_SLAB.get());
                        pOutput.accept(ModBlocks.CATALPA_DOOR.get());
                        pOutput.accept(ModBlocks.CATALPA_TRAPDOOR.get());
                        pOutput.accept(ModBlocks.CATALPA_BUTTON.get());
                        pOutput.accept(ModBlocks.CATALPA_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.CATALPA_FENCE.get());
                        pOutput.accept(ModBlocks.CATALPA_FENCE_GATE.get());
                        pOutput.accept(ModItems.CATALPA_SIGN.get());
                        pOutput.accept(ModItems.CATALPA_HANGING_SIGN.get());
                        pOutput.accept(ModItems.CATALPA_BOAT.get());
                        pOutput.accept(ModItems.CATALPA_CHEST_BOAT.get());
                        pOutput.accept(ModBlocks.RED_MAPLE_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_RED_MAPLE_LOG.get());
                        pOutput.accept(ModBlocks.RED_MAPLE_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_RED_MAPLE_WOOD.get());
                        pOutput.accept(ModBlocks.RED_MAPLE_PLANKS.get());
                        pOutput.accept(ModBlocks.RED_MAPLE_LEAVES.get());
                        pOutput.accept(ModBlocks.RED_MAPLE_SAPLING.get());
                        pOutput.accept(ModBlocks.RED_MAPLE_STAIRS.get());
                        pOutput.accept(ModBlocks.RED_MAPLE_SLAB.get());
                        pOutput.accept(ModBlocks.RED_MAPLE_DOOR.get());
                        pOutput.accept(ModBlocks.RED_MAPLE_TRAPDOOR.get());
                        pOutput.accept(ModBlocks.RED_MAPLE_BUTTON.get());
                        pOutput.accept(ModBlocks.RED_MAPLE_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.RED_MAPLE_FENCE.get());
                        pOutput.accept(ModBlocks.RED_MAPLE_FENCE_GATE.get());
                        pOutput.accept(ModItems.RED_MAPLE_SIGN.get());
                        pOutput.accept(ModItems.RED_MAPLE_HANGING_SIGN.get());
                        pOutput.accept(ModItems.RED_MAPLE_BOAT.get());
                        pOutput.accept(ModItems.RED_MAPLE_CHEST_BOAT.get());
                        pOutput.accept(ModBlocks.BANANA_LEAVES.get());
                        pOutput.accept(ModBlocks.BANANA_SAPLING.get());

                    })
                    .build());

    public static final Supplier<CreativeModeTab> TWINDLING_TWEAKS_ORES = CREATIVE_MODE_TABS.register("twindling_tweaks_ores",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RAW_ALLUMINITE.get()))
                    .title(Component.translatable("creativetab.twindlingtweaks.twindling_tweaks_ores"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.MUD_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_MUD_ORE.get());
                        pOutput.accept(ModItems.MUD_BALL.get());
                        pOutput.accept(ModBlocks.SUGAR_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_SUGAR_ORE.get());
                        pOutput.accept(ModItems.UNFILTERED_SUGAR.get());
                        pOutput.accept(ModBlocks.SALT_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_SALT_ORE.get());
                        pOutput.accept(ModItems.SALT_ROCK.get());
                        pOutput.accept(ModBlocks.ALLUMINITE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_ALLUMINITE_ORE.get());
                        pOutput.accept(ModItems.RAW_ALLUMINITE.get());
                        pOutput.accept(ModBlocks.LUMINIUM_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_LUMINIUM_ORE.get());
                        pOutput.accept(ModItems.UNPROCESSED_LUMINIUM_CHUNK.get());


                    })
                    .build());

    public static final Supplier<CreativeModeTab> TWINDLING_TWEAKS_BLOCKS = CREATIVE_MODE_TABS.register("twindling_tweaks_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.ALLUMINITE_BLOCK.get()))
                    .title(Component.translatable("creativetab.twindlingtweaks.twindling_tweaks_blocks"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.DRIED_MUD_BLOCK.get());
                        pOutput.accept(ModBlocks.COMPRESSED_MUD_BLOCK.get());
                        pOutput.accept(ModBlocks.MUD_DOOR.get());
                        pOutput.accept(ModBlocks.MUD_TRAPDOOR.get());
                        pOutput.accept(ModBlocks.UNFILTERED_SUGAR_BLOCK.get());
                        pOutput.accept(ModBlocks.SUGAR_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_ALLUMINITE_BLOCK.get());
                        pOutput.accept(ModBlocks.ALLUMINITE_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_LUMINIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.LUMINIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.BLUE_DIRT.get());
                        pOutput.accept(ModBlocks.BLUE_DIRT_PATH.get());
                        pOutput.accept(ModBlocks.YELLOW_DIRT.get());
                        pOutput.accept(ModBlocks.YELLOW_DIRT_PATH.get());
                        pOutput.accept(ModBlocks.RED_DIRT.get());
                        pOutput.accept(ModBlocks.RED_DIRT_PATH.get());
                        pOutput.accept(ModBlocks.ALLUMIN_LUMINIUM_DIRT.get());
                        pOutput.accept(ModBlocks.ALLUMIN_LUMINIUM_DIRT_PATH.get());
                        pOutput.accept(ModBlocks.COARSE_DIRT_PATH.get());
                        pOutput.accept(ModBlocks.ROOTED_DIRT_PATH.get());
                        pOutput.accept(ModBlocks.SOUL_SAND_PATH.get());
                        pOutput.accept(ModBlocks.SOUL_SOIL_PATH.get());

                    })
                    .build());

    public static final Supplier<CreativeModeTab> TWINDLING_TWEAKS_FUNCTIONAL_BLOCKS = CREATIVE_MODE_TABS.register("twindling_tweaks_functional_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.CRUSHER.get()))
                    .title(Component.translatable("creativetab.twindlingtweaks.twindling_tweaks_functional_blocks"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.OBSIDIAN_FORGER.get());
                        pOutput.accept(ModBlocks.FILTERER.get());
                        pOutput.accept(ModBlocks.CRUSHER.get());
                        pOutput.accept(ModBlocks.PASTEURIZER.get());
                        pOutput.accept(ModBlocks.SPEEDY_FARMLAND.get());
                        pOutput.accept(ModBlocks.FLASH_FARMLAND.get());
                        pOutput.accept(ModBlocks.FIERY_FARMLAND.get());
                        pOutput.accept(ModBlocks.TWINDLING_TWEAKS_FARMLAND.get());

                    })
                    .build());

    public static final Supplier<CreativeModeTab> TWINDLING_TWEAKS_TOOLS_AND_ARMOR = CREATIVE_MODE_TABS.register("twindling_tweaks_tools_and_armor",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ALLUMINITE_PICKAXE.get()))
                    .title(Component.translatable("creativetab.twindlingtweaks.twindling_tweaks_tools_and_armor"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.ALLUMINITE_HELMET.get());
                        pOutput.accept(ModItems.ALLUMINITE_CHESTPLATE.get());
                        pOutput.accept(ModItems.ALLUMINITE_LEGGINGS.get());
                        pOutput.accept(ModItems.ALLUMINITE_BOOTS.get());
                        pOutput.accept(ModItems.ALLUMINITE_SWORD.get());
                        pOutput.accept(ModItems.ALLUMINITE_AXE.get());
                        pOutput.accept(ModItems.ALLUMINITE_PICKAXE.get());
                        pOutput.accept(ModItems.ALLUMINITE_SHOVEL.get());
                        pOutput.accept(ModItems.ALLUMINITE_HOE.get());
                        pOutput.accept(ModItems.OBSIDIAN_HELMET.get());
                        pOutput.accept(ModItems.OBSIDIAN_CHESTPLATE.get());
                        pOutput.accept(ModItems.OBSIDIAN_LEGGINGS.get());
                        pOutput.accept(ModItems.OBSIDIAN_BOOTS.get());
                        pOutput.accept(ModItems.OBSIDIAN_SWORD.get());
                        pOutput.accept(ModItems.OBSIDIAN_AXE.get());
                        pOutput.accept(ModItems.OBSIDIAN_PICKAXE.get());
                        pOutput.accept(ModItems.OBSIDIAN_SHOVEL.get());
                        pOutput.accept(ModItems.OBSIDIAN_HOE.get());
                        pOutput.accept(ModItems.COOKING_KNIFE.get());
                        pOutput.accept(ModItems.STONE_HAMMER.get());
                        pOutput.accept(ModItems.IRON_HAMMER.get());
                        pOutput.accept(ModItems.DIAMOND_HAMMER.get());
                        pOutput.accept(ModItems.OBSIDIAN_HAMMER.get());

                    })
                    .build());

    public static final Supplier<CreativeModeTab> TWINDLING_TWEAKS_INGREDIENTS = CREATIVE_MODE_TABS.register("twindling_tweaks_ingredients",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.DIAMOND_POWDER.get()))
                    .title(Component.translatable("creativetab.twindlingtweaks.twindling_tweaks_ingredients"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.DRIED_MUD_BALL.get());
                        pOutput.accept(ModItems.SALT.get());
                        pOutput.accept(ModItems.ALLUMINITE_NUGGET.get());
                        pOutput.accept(ModItems.ALLUMINITE_INGOT.get());
                        pOutput.accept(ModItems.ALLUMINITE_ROD.get());
                        pOutput.accept(ModItems.ALLUMINITE_ROD_SHARD.get());
                        pOutput.accept(ModItems.REINFORCED_ALLUMINITE_INGOT.get());
                        pOutput.accept(ModItems.UNSTABLE_ALLUMINITE_INGOT.get());
                        pOutput.accept(ModItems.LUMINIUM_CHUNK.get());
                        pOutput.accept(ModItems.RAW_LUMINIUM.get());
                        pOutput.accept(ModItems.LUMINIUM_GEM.get());
                        pOutput.accept(ModItems.REINFORCED_LUMINIUM_GEM.get());
                        pOutput.accept(ModBlocks.REINFORCED_OBSIDIAN.get());
                        pOutput.accept(ModItems.IRON_CHUNKS.get());
                        pOutput.accept(ModItems.IRON_POWDER.get());
                        pOutput.accept(ModItems.DIAMOND_CHUNKS.get());
                        pOutput.accept(ModItems.DIAMOND_POWDER.get());
                        pOutput.accept(ModItems.EMPTY_CHARM.get());
                        pOutput.accept(ModItems.BASIC_DIRT_CHARM.get());
                        pOutput.accept(ModItems.BASIC_DIRT_PATH_CHARM.get());
                        pOutput.accept(ModItems.ADVANCED_DIRT_PATH_CHARM.get());
                        pOutput.accept(ModItems.BLUE_DIRT_CHARM.get());
                        pOutput.accept(ModItems.BLUE_DIRT_PATH_CHARM.get());
                        pOutput.accept(ModItems.YELLOW_DIRT_CHARM.get());
                        pOutput.accept(ModItems.YELLOW_DIRT_PATH_CHARM.get());
                        pOutput.accept(ModItems.RED_DIRT_CHARM.get());
                        pOutput.accept(ModItems.RED_DIRT_PATH_CHARM.get());
                        pOutput.accept(ModItems.ALLUMIN_LUMINIUM_DIRT_CHARM.get());
                        pOutput.accept(ModItems.ALLUMIN_LUMINIUM_DIRT_PATH_CHARM.get());
                        pOutput.accept(ModItems.MYSTICAL_DISC_FRAGMENT.get());
                        pOutput.accept(ModItems.MYSTICAL_MUSIC_DISC.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
