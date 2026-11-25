package com.austinplays.twindlingtweaks.block;

import com.austinplays.twindlingtweaks.TwindlingTweaks;
import com.austinplays.twindlingtweaks.block.custom.be_blocks.CrusherBlock;
import com.austinplays.twindlingtweaks.block.custom.be_blocks.FiltererBlock;
import com.austinplays.twindlingtweaks.block.custom.be_blocks.ObsidianForgerBlock;
import com.austinplays.twindlingtweaks.block.custom.be_blocks.special.PasteurizerBlock;
import com.austinplays.twindlingtweaks.block.custom.bush.BlueberryBushBlock;
import com.austinplays.twindlingtweaks.block.custom.bush.RaspberryBushBlock;
import com.austinplays.twindlingtweaks.block.custom.cake.ModCakeBlock;
import com.austinplays.twindlingtweaks.block.custom.crops.*;
import com.austinplays.twindlingtweaks.block.custom.farmland.ModFarmlandBlock;
import com.austinplays.twindlingtweaks.block.custom.farmland.ModFarmlandBlock2;
import com.austinplays.twindlingtweaks.block.custom.farmland.ModFarmlandBlock3;
import com.austinplays.twindlingtweaks.block.custom.farmland.ModFarmlandBlock4;
import com.austinplays.twindlingtweaks.block.custom.fuel.ModFuelBlockItem;
import com.austinplays.twindlingtweaks.block.custom.hanging_sign.ModHangingSignBlock;
import com.austinplays.twindlingtweaks.block.custom.hanging_sign.ModHangingSignBlock2;
import com.austinplays.twindlingtweaks.block.custom.hanging_sign.wall.ModWallHangingSignBlock;
import com.austinplays.twindlingtweaks.block.custom.hanging_sign.wall.ModWallHangingSignBlock2;
import com.austinplays.twindlingtweaks.block.custom.leaf.BananaLeavesBlock;
import com.austinplays.twindlingtweaks.block.custom.path.*;
import com.austinplays.twindlingtweaks.block.custom.sign.ModStandingSignBlock;
import com.austinplays.twindlingtweaks.block.custom.sign.ModStandingSignBlock2;
import com.austinplays.twindlingtweaks.block.custom.sign.wall.ModWallSignBlock;
import com.austinplays.twindlingtweaks.block.custom.sign.wall.ModWallSignBlock2;
import com.austinplays.twindlingtweaks.block.custom.wood.ModFlammableRotatedPillarBlock;
import com.austinplays.twindlingtweaks.item.ModItems;
import com.austinplays.twindlingtweaks.util.ModWoodTypes;
import com.austinplays.twindlingtweaks.world.tree.ModTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TwindlingTweaks.MOD_ID);

    public static final DeferredBlock<Block> MUD_BLOCK = registerBlock("mud_block",
            (properties) -> new Block(properties.mapColor(MapColor.GRASS).friction(0.8F).sound(SoundType.SLIME_BLOCK).noOcclusion()));

    public static final DeferredBlock<Block> DRIED_MUD_BLOCK = registerBlock("dried_mud_block",
            (properties) -> new Block(properties.mapColor(MapColor.TERRACOTTA_CYAN).sound(SoundType.MUD).strength(1F)));

    public static final DeferredBlock<Block> COMPRESSED_MUD_BLOCK = registerGreaterFuelBlock("compressed_mud_block",
            (properties) -> new Block(properties.mapColor(MapColor.TERRACOTTA_CYAN).sound(SoundType.MUD)));

    public static final DeferredBlock<Block> MUD_DOOR = registerFuelBlock("mud_door",
                (properties) -> new DoorBlock(BlockSetType.OAK, properties.mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().sound(SoundType.MUD).strength(1F).noOcclusion()));

    public static final DeferredBlock<Block> MUD_TRAPDOOR = registerFuelBlock("mud_trapdoor",
            (properties) -> new TrapDoorBlock(BlockSetType.OAK, properties.mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().sound(SoundType.MUD).strength(0.8F).noOcclusion()));

    public static final DeferredBlock<Block> RED_MAPLE_LOG = registerFuelBlock("red_maple_log",
            (properties) -> new ModFlammableRotatedPillarBlock(properties.mapColor(MapColor.WOOD).mapColor(MapColor.PODZOL).sound(SoundType.WOOD).strength(1F)));
    public static final DeferredBlock<Block> RED_MAPLE_WOOD = registerFuelBlock("red_maple_wood",
            (properties) -> new ModFlammableRotatedPillarBlock(properties.mapColor(MapColor.WOOD).mapColor(MapColor.PODZOL).sound(SoundType.WOOD).strength(1F)));
    public static final DeferredBlock<Block> STRIPPED_RED_MAPLE_LOG = registerFuelBlock("stripped_red_maple_log",
            (properties) -> new ModFlammableRotatedPillarBlock(properties.mapColor(MapColor.WOOD).mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(1F)));
    public static final DeferredBlock<Block> STRIPPED_RED_MAPLE_WOOD = registerFuelBlock("stripped_red_maple_wood",
            (properties) -> new ModFlammableRotatedPillarBlock(properties.mapColor(MapColor.WOOD).mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(1F)));
    public static final DeferredBlock<Block> RED_MAPLE_PLANKS = registerFuelBlock("red_maple_planks",
            (properties) -> new Block(properties.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).ignitedByLava().strength(1F)) {
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
            (properties) -> new LeavesBlock(properties.sound(SoundType.GRASS)) {
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
            (properties) -> new SaplingBlock(ModTreeGrowers.RED_MAPLE, properties.mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));

    public static final DeferredBlock<Block> RED_MAPLE_STAIRS = registerFuelBlock("red_maple_stairs",
            (properties) -> new StairBlock(ModBlocks.RED_MAPLE_PLANKS.value().defaultBlockState(),
                    properties.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).ignitedByLava().strength(2F)));

    public static final DeferredBlock<Block> RED_MAPLE_SLAB = registerFuelBlock("red_maple_slab",
            (properties) -> new SlabBlock(properties.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).ignitedByLava().strength(2F)));

    public static final DeferredBlock<Block> RED_MAPLE_BUTTON = registerLesserFuelBlock("red_maple_button",
            (properties) -> new ButtonBlock(BlockSetType.OAK, 30,
                   properties.noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY).sound(SoundType.WOOD).strength(2F)));

    public static final DeferredBlock<Block> RED_MAPLE_PRESSURE_PLATE = registerFuelBlock("red_maple_pressure_plate",
            (properties) -> new PressurePlateBlock(BlockSetType.OAK, properties.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).ignitedByLava().strength(2F)));

    public static final DeferredBlock<Block> RED_MAPLE_FENCE = registerFuelBlock("red_maple_fence",
            (properties) -> new FenceBlock(properties.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).ignitedByLava().strength(2F)));

    public static final DeferredBlock<Block> RED_MAPLE_FENCE_GATE = registerFuelBlock("red_maple_fence_gate",
            (properties) -> new FenceGateBlock(ModWoodTypes.RED_MAPLE, properties.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).ignitedByLava().strength(2F)));

    public static final DeferredBlock<Block> RED_MAPLE_DOOR = registerFuelBlock("red_maple_door",
            (properties) -> new DoorBlock(BlockSetType.OAK, properties.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).ignitedByLava().strength(2F).noOcclusion()));

    public static final DeferredBlock<Block> RED_MAPLE_TRAPDOOR = registerFuelBlock("red_maple_trapdoor",
            (properties) -> new TrapDoorBlock(BlockSetType.OAK, properties.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).ignitedByLava().strength(2F).noOcclusion()));

    public static final DeferredBlock<Block> RED_MAPLE_SIGN = BLOCKS.registerBlock("red_maple_sign",
            (properties) -> new ModStandingSignBlock2(properties.mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava(), ModWoodTypes.RED_MAPLE));

    public static final DeferredBlock<Block> RED_MAPLE_WALL_SIGN = BLOCKS.registerBlock("red_maple_wall_sign",
            (properties) -> new ModWallSignBlock2(properties.mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava(), ModWoodTypes.RED_MAPLE));

    public static final DeferredBlock<Block> RED_MAPLE_HANGING_SIGN = BLOCKS.registerBlock("red_maple_hanging_sign",
            (properties) -> new ModHangingSignBlock2((properties.mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()), ModWoodTypes.RED_MAPLE));

    public static final DeferredBlock<Block> RED_MAPLE_WALL_HANGING_SIGN = BLOCKS.registerBlock("red_maple_wall_hanging_sign",
            (properties) -> new ModWallHangingSignBlock2((properties.mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()), ModWoodTypes.RED_MAPLE));

    public static final DeferredBlock<Block> CATALPA_PLANKS = registerFuelBlock("catalpa_planks",
            (properties) -> new Block(properties.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).ignitedByLava().strength(1F)) {
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

    public static final DeferredBlock<Block> CATALPA_SIGN = BLOCKS.registerBlock("catalpa_sign",
            (properties) -> new ModStandingSignBlock((properties.mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()), ModWoodTypes.CATALPA));

    public static final DeferredBlock<Block> CATALPA_WALL_SIGN = BLOCKS.registerBlock("catalpa_wall_sign",
            (properties) -> new ModWallSignBlock((properties.mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()), ModWoodTypes.CATALPA));

    public static final DeferredBlock<Block> CATALPA_HANGING_SIGN = BLOCKS.registerBlock("catalpa_hanging_sign",
            (properties) -> new ModHangingSignBlock((properties.mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()), ModWoodTypes.CATALPA));

    public static final DeferredBlock<Block> CATALPA_WALL_HANGING_SIGN = BLOCKS.registerBlock("catalpa_wall_hanging_sign",
            (properties) -> new ModWallHangingSignBlock((properties.mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()), ModWoodTypes.CATALPA));

    public static final DeferredBlock<Block> GOAT_CAKE = registerBlockWithoutBlockItem("goat_cake",
            (properties) -> new ModCakeBlock(properties.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));

    public static final DeferredBlock<Block> CATALPA_STAIRS = registerFuelBlock("catalpa_stairs",
            (properties) -> new StairBlock(ModBlocks.CATALPA_PLANKS.value().defaultBlockState(),
                    properties.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).ignitedByLava().strength(2F)));

    public static final DeferredBlock<Block> CATALPA_SLAB = registerFuelBlock("catalpa_slab",
            (properties) -> new SlabBlock(properties.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).ignitedByLava().strength(2F)));

    public static final DeferredBlock<Block> CATALPA_BUTTON = registerLesserFuelBlock("catalpa_button",
            (properties) -> new ButtonBlock(BlockSetType.OAK, 30,
                    properties.noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY).sound(SoundType.WOOD).strength(2F)));

    public static final DeferredBlock<Block> CATALPA_PRESSURE_PLATE = registerFuelBlock("catalpa_pressure_plate",
            (properties) -> new PressurePlateBlock(BlockSetType.OAK, properties.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).ignitedByLava().strength(2F)));

    public static final DeferredBlock<Block> CATALPA_FENCE = registerFuelBlock("catalpa_fence",
            (properties) -> new FenceBlock(properties.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).ignitedByLava().strength(2F)));

    public static final DeferredBlock<Block> CATALPA_FENCE_GATE = registerFuelBlock("catalpa_fence_gate",
            (properties) -> new FenceGateBlock(ModWoodTypes.CATALPA, properties.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).ignitedByLava().strength(2F)));

    public static final DeferredBlock<Block> CATALPA_DOOR = registerFuelBlock("catalpa_door",
            (properties) -> new DoorBlock(BlockSetType.OAK, properties.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).ignitedByLava().strength(2F).noOcclusion()));

    public static final DeferredBlock<Block> CATALPA_TRAPDOOR = registerFuelBlock("catalpa_trapdoor",
            (properties) -> new TrapDoorBlock(BlockSetType.OAK, properties.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).ignitedByLava().strength(2F).noOcclusion()));

    public static final DeferredBlock<Block> CATALPA_SAPLING = registerLesserFuelBlock("catalpa_sapling",
            (properties) -> new SaplingBlock(ModTreeGrowers.CATALPA, properties.mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));


    public static final DeferredBlock<Block> CATALPA_LOG = registerFuelBlock("catalpa_log",
            (properties) -> new ModFlammableRotatedPillarBlock((properties.mapColor(MapColor.WOOD).mapColor(MapColor.PODZOL).sound(SoundType.WOOD).strength(1F))));
    public static final DeferredBlock<Block> CATALPA_WOOD = registerFuelBlock("catalpa_wood",
            (properties) -> new ModFlammableRotatedPillarBlock((properties.mapColor(MapColor.WOOD).mapColor(MapColor.PODZOL).sound(SoundType.WOOD).strength(1F))));
    public static final DeferredBlock<Block> STRIPPED_CATALPA_LOG = registerFuelBlock("stripped_catalpa_log",
            (properties) -> new ModFlammableRotatedPillarBlock((properties.mapColor(MapColor.WOOD).mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(1F))));
    public static final DeferredBlock<Block> STRIPPED_CATALPA_WOOD = registerFuelBlock("stripped_catalpa_wood",
            (properties) -> new ModFlammableRotatedPillarBlock((properties.mapColor(MapColor.WOOD).mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(1F))));



    public static final DeferredBlock<Block> CATALPA_LEAVES = registerBlock("catalpa_leaves",
            (properties) -> new LeavesBlock(properties.sound(SoundType.GRASS)) {
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
            (properties) -> new PinkPetalsBlock(properties.mapColor(MapColor.PLANT).noCollission().sound(SoundType.PINK_PETALS).pushReaction(PushReaction.DESTROY).noOcclusion()));

    public static final DeferredBlock<Block> BANANA_LEAVES = registerBlock("banana_leaves",
            (properties) -> new BananaLeavesBlock(properties.sound(SoundType.GRASS)) {
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
            (properties) -> new SaplingBlock(ModTreeGrowers.BANANA, properties.mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));

    public static final DeferredBlock<Block> REINFORCED_OBSIDIAN = registerBlock("reinforced_obsidian",
            (properties) -> new Block(properties.mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(12F).explosionResistance(1200F).sound(SoundType.ANVIL)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> CRUSHER = registerBlock("crusher",
            (properties) -> new CrusherBlock(properties.mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.LODESTONE)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> FILTERER = registerBlock("filterer",
            (properties) -> new FiltererBlock(properties.mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE).requiresCorrectToolForDrops().strength(4F).explosionResistance(6.8F).sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> PASTEURIZER = registerBlock("pasteurizer",
            (properties) -> new PasteurizerBlock(properties.mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE).requiresCorrectToolForDrops().strength(3F).explosionResistance(3.5F).sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> OBSIDIAN_FORGER = registerBlock("obsidian_forger",
            (properties) -> new ObsidianForgerBlock(properties.mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(12F).explosionResistance(1200F).sound(SoundType.ANVIL)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> UNFILTERED_SUGAR_BLOCK = registerBlock("unfiltered_sugar_block",
            (properties) -> new Block(properties.mapColor(MapColor.DIRT).strength(0.5F).sound(SoundType.GRAVEL).strength(0.5F)));

    public static final DeferredBlock<Block> SUGAR_BLOCK = registerBlock("sugar_block",
            (properties) -> new Block(properties.mapColor(MapColor.SAND).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND).strength(0.4F)) {
            });

    public static final DeferredBlock<Block> ALLUMINITE_BLOCK = registerBlock("alluminite_block",
            (properties) -> new Block(properties.mapColor(MapColor.DIAMOND).requiresCorrectToolForDrops().strength(2F).sound(SoundType.BASALT)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> RAW_ALLUMINITE_BLOCK = registerBlock("raw_alluminite_block",
            (properties) -> new Block(properties.mapColor(MapColor.GOLD).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2F).sound(SoundType.BASALT)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> MUD_ORE = registerBlock("mud_ore",
            (properties) -> new Block(properties.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(0.9F)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> DEEPSLATE_MUD_ORE = registerBlock("deepslate_mud_ore",
            (properties) -> new Block(properties.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(1.1F)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> SUGAR_ORE = registerBlock("sugar_ore",
            (properties) -> new Block(properties.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(0.9F)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> DEEPSLATE_SUGAR_ORE = registerBlock("deepslate_sugar_ore",
            (properties) -> new Block(properties.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(1.1F)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> SALT_ORE = registerBlock("salt_ore",
            (properties) -> new Block(properties.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(0.7F)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> DEEPSLATE_SALT_ORE = registerBlock("deepslate_salt_ore",
            (properties) -> new Block(properties.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(0.9F)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> ALLUMINITE_ORE = registerBlock("alluminite_ore",
            (properties) -> new Block(properties.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(1.6F).sound(SoundType.BASALT)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> DEEPSLATE_ALLUMINITE_ORE = registerBlock("deepslate_alluminite_ore",
            (properties) -> new Block(properties.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.4F).sound(SoundType.BASALT)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> LUMINIUM_ORE = registerBlock("luminium_ore",
            (properties) -> new Block(properties.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.3F).sound(SoundType.BONE_BLOCK)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> DEEPSLATE_LUMINIUM_ORE = registerBlock("deepslate_luminium_ore",
            (properties) -> new Block(properties.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(3.1F).sound(SoundType.BONE_BLOCK)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> LUMINIUM_BLOCK = registerBlock("luminium_block",
            (properties) -> new Block(properties.mapColor(MapColor.DIAMOND).requiresCorrectToolForDrops().strength(6F).sound(SoundType.BONE_BLOCK)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> RAW_LUMINIUM_BLOCK = registerBlock("raw_luminium_block",
            (properties) -> new Block(properties.mapColor(MapColor.GOLD).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5F).sound(SoundType.BONE_BLOCK)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> BLUE_DIRT = registerBlock("blue_dirt",
            (properties) -> new Block(properties.mapColor(MapColor.DIRT).strength(0.5F).sound(SoundType.GRAVEL)));

    public static final DeferredBlock<Block> BLUE_DIRT_PATH = registerBlock("blue_dirt_path",
            (properties) -> new ModDirtPathBlock(properties.mapColor(MapColor.DIRT).strength(0.65F).sound(SoundType.GRASS)));

    public static final DeferredBlock<Block> SPEEDY_FARMLAND = registerBlock("speedy_farmland",
            (properties) -> new ModFarmlandBlock(properties.mapColor(MapColor.DIRT).strength(0.5F).sound(SoundType.GRAVEL).randomTicks(), ModBlocks.BLUE_DIRT.value()));

    public static final DeferredBlock<Block> YELLOW_DIRT = registerBlock("yellow_dirt",
            (properties) -> new Block(properties.mapColor(MapColor.DIRT).strength(0.5F).sound(SoundType.GRAVEL)));

    public static final DeferredBlock<Block> YELLOW_DIRT_PATH = registerBlock("yellow_dirt_path",
            (properties) -> new ModDirtPathBlock2(properties.mapColor(MapColor.DIRT).strength(0.65F).sound(SoundType.GRASS)));

    public static final DeferredBlock<Block> FLASH_FARMLAND = registerBlock("flash_farmland",
            (properties) -> new ModFarmlandBlock2(properties.mapColor(MapColor.DIRT).strength(0.5F).sound(SoundType.GRAVEL).randomTicks(), ModBlocks.YELLOW_DIRT.value()));

    public static final DeferredBlock<Block> RED_DIRT = registerBlock("red_dirt",
            (properties) -> new Block(properties.mapColor(MapColor.DIRT).strength(0.5F).sound(SoundType.GRAVEL)));

    public static final DeferredBlock<Block> RED_DIRT_PATH = registerBlock("red_dirt_path",
            (properties) -> new ModDirtPathBlock3(properties.mapColor(MapColor.DIRT).strength(0.65F).sound(SoundType.GRASS)));

    public static final DeferredBlock<Block> FIERY_FARMLAND = registerBlock("fiery_farmland",
            (properties) -> new ModFarmlandBlock3(properties.mapColor(MapColor.DIRT).strength(0.5F).sound(SoundType.GRAVEL).randomTicks(), ModBlocks.RED_DIRT.value()));

    public static final DeferredBlock<Block> ALLUMIN_LUMINIUM_DIRT = registerBlock("combined_dirt",
            (properties) -> new Block(properties.mapColor(MapColor.DIRT).strength(0.5F).sound(SoundType.GRAVEL)));

    public static final DeferredBlock<Block> ALLUMIN_LUMINIUM_DIRT_PATH = registerBlock("combined_dirt_path",
            (properties) -> new ModDirtPathBlock4(properties.mapColor(MapColor.DIRT).strength(0.65F).sound(SoundType.GRASS)));

    public static final DeferredBlock<Block> TWINDLING_TWEAKS_FARMLAND = registerBlock("twindling_tweaks_farmland",
            (properties) -> new ModFarmlandBlock4(properties.mapColor(MapColor.DIRT).strength(0.5F).sound(SoundType.GRAVEL).randomTicks(), ModBlocks.ALLUMIN_LUMINIUM_DIRT.value()));

    public static final DeferredBlock<Block> COARSE_DIRT_PATH = registerBlock("coarse_dirt_path",
            (properties) -> new ModDirtPathBlock5(properties.mapColor(MapColor.DIRT).strength(0.65F).sound(SoundType.GRASS)));

    public static final DeferredBlock<Block> ROOTED_DIRT_PATH = registerBlock("rooted_dirt_path",
            (properties) -> new ModDirtPathBlock6(properties.mapColor(MapColor.DIRT).strength(0.65F).sound(SoundType.ROOTED_DIRT)));

    public static final DeferredBlock<Block> SOUL_SAND_PATH = registerBlock("soul_sand_path",
            (properties) -> new ModDirtPathBlock7(properties.mapColor(MapColor.DIRT).strength(0.65F).sound(SoundType.SOUL_SAND)));

    public static final DeferredBlock<Block> SOUL_SOIL_PATH = registerBlock("soul_soil_path",
            (properties) -> new ModDirtPathBlock8(properties.mapColor(MapColor.DIRT).strength(0.65F).sound(SoundType.SOUL_SOIL)));

    public static final DeferredBlock<Block> CUCUMBER_SEEDS_BLOCK = registerBlockWithoutBlockItem("cucumber_seeds",
            (properties) -> new CucumberPlantBlock(properties.mapColor(MapColor.COLOR_YELLOW).mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY).noOcclusion()));

    public static final DeferredBlock<Block> LETTUCE_SEEDS_BLOCK = registerBlockWithoutBlockItem("lettuce_seeds",
            (properties) -> new LettucePlantBlock(properties.mapColor(MapColor.COLOR_YELLOW).mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY).noOcclusion()));

    public static final DeferredBlock<Block> ORANGE_SEEDS_BLOCK = registerBlockWithoutBlockItem("orange_seeds",
            (properties) -> new OrangePlantBlock(properties.mapColor(MapColor.COLOR_YELLOW).mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY).noOcclusion()));

    public static final DeferredBlock<Block> TOMATO_SEEDS_BLOCK = registerBlockWithoutBlockItem("tomato_seeds",
            (properties) -> new TomatoPlantBlock(properties.mapColor(MapColor.COLOR_YELLOW).mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY).noOcclusion()));

    public static final DeferredBlock<Block> BROCCOLI_SEEDS_BLOCK = registerBlockWithoutBlockItem("broccoli_seeds",
            (properties) -> new BroccoliPlantBlock(properties.mapColor(MapColor.COLOR_YELLOW).mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY).noOcclusion()));

    public static final DeferredBlock<Block> CORN_SEEDS_BLOCK = registerBlockWithoutBlockItem("corn_seeds",
            (properties) -> new CornPlantBlock(properties.mapColor(MapColor.COLOR_YELLOW).mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY).noOcclusion()));

    public static final DeferredBlock<Block> BLUEBERRY_BUSH = registerBlock("blueberry_bush",
            (properties) -> new BlueberryBushBlock(properties.mapColor(MapColor.PLANT).randomTicks().noCollission().sound(SoundType.SWEET_BERRY_BUSH).pushReaction(PushReaction.DESTROY)));

    public static final DeferredBlock<Block> RASPBERRY_BUSH = registerBlock("raspberry_bush",
            (properties) -> new RaspberryBushBlock(properties.mapColor(MapColor.PLANT).randomTicks().noCollission().sound(SoundType.SWEET_BERRY_BUSH).pushReaction(PushReaction.DESTROY)));


    private static <T extends Block> DeferredBlock<T> registerBlockWithoutBlockItem(String name, Function<BlockBehaviour.Properties, T> function) {
        return BLOCKS.registerBlock(name, function);
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(
            String name,
            Function<BlockBehaviour.Properties, T> function
    ) {
        DeferredBlock<T> toReturn =
                BLOCKS.registerBlock(name, function);

        registerBlockItem(name, toReturn);

        return toReturn;
    }

    private static <T extends Block> DeferredItem<Item> registerBlockItem(String name, Supplier<T> block) {
        return ModItems.ITEMS.registerItem(name, (properties) -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }

    private static <T extends Block> DeferredItem<Item> registerFuelBlockItem(String name, DeferredBlock<T> block) {
        // ModItems.ITEMS is a DeferredRegister.Items, so .register(...) returns a DeferredItem<Item>
        return ModItems.ITEMS.registerItem(name, (properties) -> new ModFuelBlockItem(block.get(), properties.useBlockDescriptionPrefix(), 300));
    }

    private static <T extends Block> DeferredItem<Item> registerLesserFuelBlockItem(String name, DeferredBlock<T> block) {
        return ModItems.ITEMS.registerItem(name, (properties) -> new ModFuelBlockItem(block.get(), properties.useBlockDescriptionPrefix(), 100));
    }
    private static <T extends Block> DeferredItem<Item> registerGreaterFuelBlockItem(String name, DeferredBlock<T> block) {
        return ModItems.ITEMS.registerItem(name, (properties) -> new ModFuelBlockItem(block.get(), properties.useBlockDescriptionPrefix(), 1800));
    }
    private static <T extends Block> DeferredBlock<T> registerFuelBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerFuelBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> DeferredBlock<T> registerLesserFuelBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerLesserFuelBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> DeferredBlock<T> registerGreaterFuelBlock(
            String name,
            Function<BlockBehaviour.Properties, T> function
    ) {
        DeferredBlock<T> toReturn =
                BLOCKS.registerBlock(name, function);

        registerGreaterFuelBlockItem(name, toReturn);

        return toReturn;
    }

    public static void register(IEventBus eventBus) { BLOCKS.register(eventBus);
    }
}