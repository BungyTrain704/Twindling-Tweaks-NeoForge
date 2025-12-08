package com.bungy.twindlingtweaks.block;

import com.bungy.twindlingtweaks.TwindlingTweaks;
import com.bungy.twindlingtweaks.block.custom.be_blocks.CrusherBlock;
import com.bungy.twindlingtweaks.block.custom.be_blocks.FiltererBlock;
import com.bungy.twindlingtweaks.block.custom.be_blocks.ObsidianForgerBlock;
import com.bungy.twindlingtweaks.block.custom.be_blocks.special.PasteurizerBlock;
import com.bungy.twindlingtweaks.block.custom.bush.BlueberryBushBlock;
import com.bungy.twindlingtweaks.block.custom.bush.RaspberryBushBlock;
import com.bungy.twindlingtweaks.block.custom.cake.ModCakeBlock;
import com.bungy.twindlingtweaks.block.custom.crops.*;
import com.bungy.twindlingtweaks.block.custom.farmland.ModFarmlandBlock;
import com.bungy.twindlingtweaks.block.custom.farmland.ModFarmlandBlock2;
import com.bungy.twindlingtweaks.block.custom.farmland.ModFarmlandBlock3;
import com.bungy.twindlingtweaks.block.custom.farmland.ModFarmlandBlock4;
import com.bungy.twindlingtweaks.block.custom.fuel.ModFuelBlockItem;
import com.bungy.twindlingtweaks.block.custom.hanging_sign.ModHangingSignBlock;
import com.bungy.twindlingtweaks.block.custom.hanging_sign.ModHangingSignBlock2;
import com.bungy.twindlingtweaks.block.custom.hanging_sign.wall.ModWallHangingSignBlock;
import com.bungy.twindlingtweaks.block.custom.hanging_sign.wall.ModWallHangingSignBlock2;
import com.bungy.twindlingtweaks.block.custom.leaf.BananaLeavesBlock;
import com.bungy.twindlingtweaks.block.custom.path.*;
import com.bungy.twindlingtweaks.block.custom.sign.ModStandingSignBlock;
import com.bungy.twindlingtweaks.block.custom.sign.ModStandingSignBlock2;
import com.bungy.twindlingtweaks.block.custom.sign.wall.ModWallSignBlock;
import com.bungy.twindlingtweaks.block.custom.sign.wall.ModWallSignBlock2;
import com.bungy.twindlingtweaks.block.custom.wood.ModFlammableRotatedPillarBlock;
import com.bungy.twindlingtweaks.item.ModItems;
import com.bungy.twindlingtweaks.util.ModWoodTypes;
import com.bungy.twindlingtweaks.world.tree.ModTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TwindlingTweaks.MOD_ID);

    public static final DeferredBlock<Block> MUD_BLOCK = registerBlock("mud_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SLIME_BLOCK).strength(0.5F)));

    public static final DeferredBlock<Block> DRIED_MUD_BLOCK = registerBlock("dried_mud_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD).strength(1F)));

    public static final DeferredBlock<Block> COMPRESSED_MUD_BLOCK = registerLesserFuelBlock("compressed_mud_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS).strength(2F)));

    public static final DeferredBlock<Block> MUD_DOOR = registerFuelBlock("mud_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS).sound(SoundType.MUD).strength(1F).noOcclusion()));

    public static final DeferredBlock<Block> MUD_TRAPDOOR = registerFuelBlock("mud_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS).sound(SoundType.MUD).strength(0.8F).noOcclusion()));

    public static final DeferredBlock<Block> RED_MAPLE_LOG = registerFuelBlock("red_maple_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).strength(1F)));
    public static final DeferredBlock<Block> RED_MAPLE_WOOD = registerFuelBlock("red_maple_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(1F)));
    public static final DeferredBlock<Block> STRIPPED_RED_MAPLE_LOG = registerFuelBlock("stripped_red_maple_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).strength(1F)));
    public static final DeferredBlock<Block> STRIPPED_RED_MAPLE_WOOD = registerFuelBlock("stripped_red_maple_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).strength(1F)));
    public static final DeferredBlock<Block> RED_MAPLE_PLANKS = registerFuelBlock("red_maple_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(1F)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            });

    public static final DeferredBlock<Block> RED_MAPLE_LEAVES = registerBlock("red_maple_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }
            });

    public static final DeferredBlock<Block> RED_MAPLE_SAPLING = registerLesserFuelBlock("red_maple_sapling",
            () -> new SaplingBlock(ModTreeGrowers.RED_MAPLE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final DeferredBlock<Block> RED_MAPLE_STAIRS = registerFuelBlock("red_maple_stairs",
            () -> new StairBlock(ModBlocks.RED_MAPLE_PLANKS.value().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2F)));

    public static final DeferredBlock<Block> RED_MAPLE_SLAB = registerFuelBlock("red_maple_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2F)));

    public static final DeferredBlock<Block> RED_MAPLE_BUTTON = registerLesserFuelBlock("red_maple_button",
            () -> new ButtonBlock(BlockSetType.OAK, 30,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).sound(SoundType.WOOD).strength(2F)));

    public static final DeferredBlock<Block> RED_MAPLE_PRESSURE_PLATE = registerFuelBlock("red_maple_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2F)));

    public static final DeferredBlock<Block> RED_MAPLE_FENCE = registerFuelBlock("red_maple_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2F)));

    public static final DeferredBlock<Block> RED_MAPLE_FENCE_GATE = registerFuelBlock("red_maple_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.RED_MAPLE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2F)));

    public static final DeferredBlock<Block> RED_MAPLE_DOOR = registerFuelBlock("red_maple_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2F).noOcclusion()));

    public static final DeferredBlock<Block> RED_MAPLE_TRAPDOOR = registerFuelBlock("red_maple_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2F).noOcclusion()));

    public static final DeferredBlock<Block> RED_MAPLE_SIGN = BLOCKS.register("red_maple_sign",
            () -> new ModStandingSignBlock2(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.RED_MAPLE));

    public static final DeferredBlock<Block> RED_MAPLE_WALL_SIGN = BLOCKS.register("red_maple_wall_sign",
            () -> new ModWallSignBlock2(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.RED_MAPLE));

    public static final DeferredBlock<Block> RED_MAPLE_HANGING_SIGN = BLOCKS.register("red_maple_hanging_sign",
            () -> new ModHangingSignBlock2(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.RED_MAPLE));

    public static final DeferredBlock<Block> RED_MAPLE_WALL_HANGING_SIGN = BLOCKS.register("red_maple_wall_hanging_sign",
            () -> new ModWallHangingSignBlock2(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.RED_MAPLE));

    public static final DeferredBlock<Block> CATALPA_PLANKS = registerFuelBlock("catalpa_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(1F)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            });

    public static final DeferredBlock<Block> CATALPA_SIGN = BLOCKS.register("catalpa_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.CATALPA));

    public static final DeferredBlock<Block> CATALPA_WALL_SIGN = BLOCKS.register("catalpa_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.CATALPA));

    public static final DeferredBlock<Block> CATALPA_HANGING_SIGN = BLOCKS.register("catalpa_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.CATALPA));

    public static final DeferredBlock<Block> CATALPA_WALL_HANGING_SIGN = BLOCKS.register("catalpa_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.CATALPA));

    public static final DeferredBlock<Block> GOAT_CAKE = BLOCKS.register("goat_cake",
            () -> new ModCakeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE)));

    public static final DeferredBlock<Block> CATALPA_STAIRS = registerFuelBlock("catalpa_stairs",
            () -> new StairBlock(ModBlocks.CATALPA_PLANKS.value().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2F)));

    public static final DeferredBlock<Block> CATALPA_SLAB = registerFuelBlock("catalpa_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2F)));

    public static final DeferredBlock<Block> CATALPA_BUTTON = registerLesserFuelBlock("catalpa_button",
            () -> new ButtonBlock(BlockSetType.OAK, 30,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).sound(SoundType.WOOD).strength(2F)));

    public static final DeferredBlock<Block> CATALPA_PRESSURE_PLATE = registerFuelBlock("catalpa_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2F)));

    public static final DeferredBlock<Block> CATALPA_FENCE = registerFuelBlock("catalpa_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2F)));

    public static final DeferredBlock<Block> CATALPA_FENCE_GATE = registerFuelBlock("catalpa_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.CATALPA, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2F)));

    public static final DeferredBlock<Block> CATALPA_DOOR = registerFuelBlock("catalpa_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2F).noOcclusion()));

    public static final DeferredBlock<Block> CATALPA_TRAPDOOR = registerFuelBlock("catalpa_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2F).noOcclusion()));

    public static final DeferredBlock<Block> CATALPA_SAPLING = registerLesserFuelBlock("catalpa_sapling",
            () -> new SaplingBlock(ModTreeGrowers.CATALPA, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));


    public static final DeferredBlock<Block> CATALPA_LOG = registerFuelBlock("catalpa_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).strength(1F)));
    public static final DeferredBlock<Block> CATALPA_WOOD = registerFuelBlock("catalpa_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(1F)));
    public static final DeferredBlock<Block> STRIPPED_CATALPA_LOG = registerFuelBlock("stripped_catalpa_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).strength(1F)));
    public static final DeferredBlock<Block> STRIPPED_CATALPA_WOOD = registerFuelBlock("stripped_catalpa_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).strength(1F)));



    public static final DeferredBlock<Block> CATALPA_LEAVES = registerBlock("catalpa_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }
            });

    public static final DeferredBlock<Block> CATALPA_FLOWERS = registerBlock("catalpa_flowers",
            () -> new PinkPetalsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_PETALS).noOcclusion()));

    public static final DeferredBlock<Block> BANANA_LEAVES = registerBlock("banana_leaves",
            () -> new BananaLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }
            });

    public static final DeferredBlock<Block> BANANA_SAPLING = registerLesserFuelBlock("banana_sapling",
            () -> new SaplingBlock(ModTreeGrowers.BANANA, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final DeferredBlock<Block> REINFORCED_OBSIDIAN = registerBlock("reinforced_obsidian",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN).strength(12F).explosionResistance(1200F).sound(SoundType.ANVIL)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> CRUSHER = registerBlock("crusher",
            () -> new CrusherBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).sound(SoundType.LODESTONE)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> FILTERER = registerBlock("filterer",
            () -> new FiltererBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(4F).explosionResistance(6.8F).sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> PASTEURIZER = registerBlock("pasteurizer",
            () -> new PasteurizerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(3F).explosionResistance(3.5F).sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> OBSIDIAN_FORGER = registerBlock("obsidian_forger",
            () -> new ObsidianForgerBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.REINFORCED_OBSIDIAN.value()).strength(12F).explosionResistance(1200F).sound(SoundType.ANVIL)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> UNFILTERED_SUGAR_BLOCK = registerBlock("unfiltered_sugar_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT).strength(0.5F)));

    public static final DeferredBlock<Block> SUGAR_BLOCK = registerBlock("sugar_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SAND).strength(0.4F)) {
            });

    public static final DeferredBlock<Block> ALLUMINITE_BLOCK = registerBlock("alluminite_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).strength(2F).sound(SoundType.BASALT)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> RAW_ALLUMINITE_BLOCK = registerBlock("raw_alluminite_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK).strength(2F).sound(SoundType.BASALT)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> MUD_ORE = registerBlock("mud_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(0.9F)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> DEEPSLATE_MUD_ORE = registerBlock("deepslate_mud_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(1.1F)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> SUGAR_ORE = registerBlock("sugar_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(0.9F)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> DEEPSLATE_SUGAR_ORE = registerBlock("deepslate_sugar_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(1.1F)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> SALT_ORE = registerBlock("salt_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(0.7F)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> DEEPSLATE_SALT_ORE = registerBlock("deepslate_salt_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(0.9F)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> ALLUMINITE_ORE = registerBlock("alluminite_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(1.6F).sound(SoundType.BASALT)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> DEEPSLATE_ALLUMINITE_ORE = registerBlock("deepslate_alluminite_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(2.4F).sound(SoundType.BASALT)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> LUMINIUM_ORE = registerBlock("luminium_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(2.3F).sound(SoundType.BONE_BLOCK)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> DEEPSLATE_LUMINIUM_ORE = registerBlock("deepslate_luminium_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).strength(3.1F).sound(SoundType.BONE_BLOCK)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> LUMINIUM_BLOCK = registerBlock("luminium_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).strength(6F).sound(SoundType.BONE_BLOCK)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> RAW_LUMINIUM_BLOCK = registerBlock("raw_luminium_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK).strength(5F).sound(SoundType.BONE_BLOCK)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> BLUE_DIRT = registerBlock("blue_dirt",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));

    public static final DeferredBlock<Block> BLUE_DIRT_PATH = registerBlock("blue_dirt_path",
            () -> new ModDirtPathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT_PATH)));

    public static final DeferredBlock<Block> SPEEDY_FARMLAND = registerBlock("speedy_farmland",
            () -> new ModFarmlandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT).randomTicks(), ModBlocks.BLUE_DIRT.value()));

    public static final DeferredBlock<Block> YELLOW_DIRT = registerBlock("yellow_dirt",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));

    public static final DeferredBlock<Block> YELLOW_DIRT_PATH = registerBlock("yellow_dirt_path",
            () -> new ModDirtPathBlock2(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT_PATH)));

    public static final DeferredBlock<Block> FLASH_FARMLAND = registerBlock("flash_farmland",
            () -> new ModFarmlandBlock2(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT).randomTicks(), ModBlocks.YELLOW_DIRT.value()));

    public static final DeferredBlock<Block> RED_DIRT = registerBlock("red_dirt",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));

    public static final DeferredBlock<Block> RED_DIRT_PATH = registerBlock("red_dirt_path",
            () -> new ModDirtPathBlock3(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT_PATH)));

    public static final DeferredBlock<Block> FIERY_FARMLAND = registerBlock("fiery_farmland",
            () -> new ModFarmlandBlock3(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT).randomTicks(), ModBlocks.RED_DIRT.value()));

    public static final DeferredBlock<Block> ALLUMIN_LUMINIUM_DIRT = registerBlock("combined_dirt",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));

    public static final DeferredBlock<Block> ALLUMIN_LUMINIUM_DIRT_PATH = registerBlock("combined_dirt_path",
            () -> new ModDirtPathBlock4(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT_PATH)));

    public static final DeferredBlock<Block> TWINDLING_TWEAKS_FARMLAND = registerBlock("twindling_tweaks_farmland",
            () -> new ModFarmlandBlock4(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT).randomTicks(), ModBlocks.ALLUMIN_LUMINIUM_DIRT.value()));

    public static final DeferredBlock<Block> COARSE_DIRT_PATH = registerBlock("coarse_dirt_path",
            () -> new ModDirtPathBlock5(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT_PATH).sound(SoundType.GRASS)));

    public static final DeferredBlock<Block> ROOTED_DIRT_PATH = registerBlock("rooted_dirt_path",
            () -> new ModDirtPathBlock6(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT_PATH).sound(SoundType.ROOTED_DIRT)));

    public static final DeferredBlock<Block> SOUL_SAND_PATH = registerBlock("soul_sand_path",
            () -> new ModDirtPathBlock7(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT_PATH).sound(SoundType.SOUL_SAND)));

    public static final DeferredBlock<Block> SOUL_SOIL_PATH = registerBlock("soul_soil_path",
            () -> new ModDirtPathBlock8(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT_PATH).sound(SoundType.SOUL_SOIL)));

    public static final DeferredBlock<Block> CUCUMBER_SEEDS_BLOCK = registerBlockWithoutBlockItem("cucumber_seeds",
            () -> new CucumberPlantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noOcclusion()));

    public static final DeferredBlock<Block> LETTUCE_SEEDS_BLOCK = registerBlockWithoutBlockItem("lettuce_seeds",
            () -> new LettucePlantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noOcclusion()));

    public static final DeferredBlock<Block> ORANGE_SEEDS_BLOCK = registerBlockWithoutBlockItem("orange_seeds",
            () -> new OrangePlantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noOcclusion()));

    public static final DeferredBlock<Block> TOMATO_SEEDS_BLOCK = registerBlockWithoutBlockItem("tomato_seeds",
            () -> new TomatoPlantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noOcclusion()));

    public static final DeferredBlock<Block> BROCCOLI_SEEDS_BLOCK = registerBlockWithoutBlockItem("broccoli_seeds",
            () -> new BroccoliPlantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noOcclusion()));

    public static final DeferredBlock<Block> CORN_SEEDS_BLOCK = registerBlockWithoutBlockItem("corn_seeds",
            () -> new CornPlantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noOcclusion()));

    public static final DeferredBlock<Block> BLUEBERRY_BUSH = BLOCKS.register("blueberry_bush",
            () -> new BlueberryBushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH)));

    public static final DeferredBlock<Block> RASPBERRY_BUSH = BLOCKS.register("raspberry_bush",
            () -> new RaspberryBushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH)));


    private static <T extends Block> DeferredBlock<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> DeferredItem<Item> registerBlockItem(String name, Supplier<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends Block> DeferredItem<Item> registerFuelBlockItem(String name, DeferredBlock<T> block) {
        // ModItems.ITEMS is a DeferredRegister.Items, so .register(...) returns a DeferredItem<Item>
        return ModItems.ITEMS.register(name, () -> new ModFuelBlockItem(block.get(), new Item.Properties(), 300));
    }

    private static <T extends Block> DeferredItem<Item> registerLesserFuelBlockItem(String name, DeferredBlock<T> block) {
        return ModItems.ITEMS.register(name, () -> new ModFuelBlockItem(block.get(), new Item.Properties(), 100));
    }
    private static <T extends Block> DeferredBlock<T> registerFuelBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerFuelBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> DeferredBlock<T> registerLesserFuelBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerLesserFuelBlockItem(name, toReturn);
        return toReturn;
    }

    public static void register(IEventBus eventBus) {BLOCKS.register(eventBus);
    }
}