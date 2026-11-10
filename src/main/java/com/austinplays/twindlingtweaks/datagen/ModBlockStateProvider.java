package com.austinplays.twindlingtweaks.datagen;

import com.austinplays.twindlingtweaks.TwindlingTweaks;
import com.austinplays.twindlingtweaks.block.ModBlocks;
import com.austinplays.twindlingtweaks.block.custom.bush.BlueberryBushBlock;
import com.austinplays.twindlingtweaks.block.custom.crops.*;
import com.google.common.collect.ImmutableMap;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.*;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {

    private final PackOutput packOutput; // store this!

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TwindlingTweaks.MOD_ID, exFileHelper);
        this.packOutput = output;
    }

    @Override
    protected void registerStatesAndModels() {
        //Planks have to be first, otherwise error
        blockWithItem(ModBlocks.CATALPA_PLANKS);
        blockWithItem(ModBlocks.RED_MAPLE_PLANKS);

        blockWithItem(ModBlocks.ALLUMINITE_BLOCK);
        blockWithItem(ModBlocks.RAW_ALLUMINITE_BLOCK);
        blockWithItem(ModBlocks.LUMINIUM_BLOCK);
        blockWithItem(ModBlocks.RAW_LUMINIUM_BLOCK);
        blockWithItem(ModBlocks.MUD_BLOCK);
        blockWithItem(ModBlocks.DRIED_MUD_BLOCK);
        blockWithItem(ModBlocks.COMPRESSED_MUD_BLOCK);
        blockWithItem(ModBlocks.BLUE_DIRT);
        blockWithItem(ModBlocks.YELLOW_DIRT);
        blockWithItem(ModBlocks.RED_DIRT);
        blockWithItem(ModBlocks.ALLUMIN_LUMINIUM_DIRT);
        blockWithItem(ModBlocks.SUGAR_BLOCK);
        blockWithItem(ModBlocks.UNFILTERED_SUGAR_BLOCK);
        blockWithItem(ModBlocks.REINFORCED_OBSIDIAN);

        blockWithItem(ModBlocks.ALLUMINITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ALLUMINITE_ORE);
        blockWithItem(ModBlocks.LUMINIUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_LUMINIUM_ORE);
        blockWithItem(ModBlocks.MUD_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_MUD_ORE);
        blockWithItem(ModBlocks.SUGAR_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SUGAR_ORE);
        blockWithItem(ModBlocks.SALT_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SALT_ORE);


        blockWithItem(ModBlocks.OBSIDIAN_FORGER);

        cubeWithCustomSides(ModBlocks.FILTERER.get(),
                modLoc("block/filterer_up"),
                modLoc("block/catalpa_planks"),
                modLoc("block/filterer_north"),
                modLoc("block/filterer_south"),
                modLoc("block/filterer_west"),
                modLoc("block/filterer_east"),
                modLoc("block/filterer_up")
        );
        cubeWithCustomSides(ModBlocks.CRUSHER.get(),
                modLoc("block/crusher_up"),
                ResourceLocation.fromNamespaceAndPath("minecraft", "block/iron_block"),
                modLoc("block/crusher_north"),
                modLoc("block/crusher_south"),
                modLoc("block/crusher_west"),
                modLoc("block/crusher_east"),
                modLoc("block/crusher_up")
        );
        cubeWithCustomSides(ModBlocks.PASTEURIZER.get(),
                modLoc("block/pasteurizer_up"),
                modLoc("block/red_maple_planks"),
                modLoc("block/pasteurizer_north"),
                modLoc("block/pasteurizer_south"),
                modLoc("block/pasteurizer_west"),
                modLoc("block/pasteurizer_east"),
                modLoc("block/pasteurizer_up")
        );

        stairsBlock(((StairBlock) ModBlocks.CATALPA_STAIRS.get()), blockTexture(ModBlocks.CATALPA_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.CATALPA_SLAB.get()), blockTexture(ModBlocks.CATALPA_PLANKS.get()), blockTexture(ModBlocks.CATALPA_PLANKS.get()));
        stairsBlock(((StairBlock) ModBlocks.RED_MAPLE_STAIRS.get()), blockTexture(ModBlocks.RED_MAPLE_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.RED_MAPLE_SLAB.get()), blockTexture(ModBlocks.RED_MAPLE_PLANKS.get()), blockTexture(ModBlocks.RED_MAPLE_PLANKS.get()));

        buttonBlock(((ButtonBlock) ModBlocks.CATALPA_BUTTON.get()), blockTexture(ModBlocks.CATALPA_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.CATALPA_PRESSURE_PLATE.get()), blockTexture(ModBlocks.CATALPA_PLANKS.get()));
        buttonBlock(((ButtonBlock) ModBlocks.RED_MAPLE_BUTTON.get()), blockTexture(ModBlocks.RED_MAPLE_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.RED_MAPLE_PRESSURE_PLATE.get()), blockTexture(ModBlocks.RED_MAPLE_PLANKS.get()));

        fenceBlock(((FenceBlock) ModBlocks.CATALPA_FENCE.get()), blockTexture(ModBlocks.CATALPA_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.CATALPA_FENCE_GATE.get()), blockTexture(ModBlocks.CATALPA_PLANKS.get()));
        fenceBlock(((FenceBlock) ModBlocks.RED_MAPLE_FENCE.get()), blockTexture(ModBlocks.RED_MAPLE_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.RED_MAPLE_FENCE_GATE.get()), blockTexture(ModBlocks.RED_MAPLE_PLANKS.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.CATALPA_DOOR.get()), modLoc("block/catalpa_door_bottom"), modLoc("block/catalpa_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.CATALPA_TRAPDOOR.get()), modLoc("block/catalpa_trapdoor"), true, "cutout");
        doorBlockWithRenderType(((DoorBlock) ModBlocks.MUD_DOOR.get()), modLoc("block/mud_door_bottom"), modLoc("block/mud_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.MUD_TRAPDOOR.get()), modLoc("block/mud_trapdoor"), true, "cutout");
        doorBlockWithRenderType(((DoorBlock) ModBlocks.RED_MAPLE_DOOR.get()), modLoc("block/red_maple_door_bottom"), modLoc("block/red_maple_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.RED_MAPLE_TRAPDOOR.get()), modLoc("block/red_maple_trapdoor"), true, "cutout");

        logBlock((RotatedPillarBlock) ModBlocks.CATALPA_LOG.get());
        axisBlock((RotatedPillarBlock) ModBlocks.CATALPA_WOOD.get(), blockTexture(ModBlocks.CATALPA_LOG.get()), blockTexture(ModBlocks.CATALPA_LOG.get()));
        logBlock((RotatedPillarBlock) ModBlocks.STRIPPED_CATALPA_LOG.get());
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_CATALPA_WOOD.get(), blockTexture(ModBlocks.STRIPPED_CATALPA_LOG.get()), blockTexture(ModBlocks.STRIPPED_CATALPA_LOG.get()));

        logBlock((RotatedPillarBlock) ModBlocks.RED_MAPLE_LOG.get());
        axisBlock((RotatedPillarBlock) ModBlocks.RED_MAPLE_WOOD.get(), blockTexture(ModBlocks.RED_MAPLE_LOG.get()), blockTexture(ModBlocks.RED_MAPLE_LOG.get()));
        logBlock((RotatedPillarBlock) ModBlocks.STRIPPED_RED_MAPLE_LOG.get());
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_RED_MAPLE_WOOD.get(), blockTexture(ModBlocks.STRIPPED_RED_MAPLE_LOG.get()), blockTexture(ModBlocks.STRIPPED_RED_MAPLE_LOG.get()));

        blockItem(ModBlocks.CATALPA_LOG);
        blockItem(ModBlocks.CATALPA_WOOD);
        blockItem(ModBlocks.STRIPPED_CATALPA_LOG);
        blockItem(ModBlocks.STRIPPED_CATALPA_WOOD);

        leavesBlock(ModBlocks.CATALPA_LEAVES);

        blockItem(ModBlocks.RED_MAPLE_LOG);
        blockItem(ModBlocks.RED_MAPLE_WOOD);
        blockItem(ModBlocks.STRIPPED_RED_MAPLE_LOG);
        blockItem(ModBlocks.STRIPPED_RED_MAPLE_WOOD);

        leavesBlock(ModBlocks.RED_MAPLE_LEAVES);

        dirtPathBlock(ModBlocks.BLUE_DIRT_PATH.get());
        dirtPathBlock(ModBlocks.YELLOW_DIRT_PATH.get());
        dirtPathBlock(ModBlocks.RED_DIRT_PATH.get());
        dirtPathBlock(ModBlocks.ALLUMIN_LUMINIUM_DIRT_PATH.get());

        dirtPathBlock(ModBlocks.COARSE_DIRT_PATH.get());
        dirtPathBlock(ModBlocks.ROOTED_DIRT_PATH.get());
        dirtPathBlock(ModBlocks.SOUL_SAND_PATH.get());
        dirtPathBlock(ModBlocks.SOUL_SOIL_PATH.get());

        farmlandBlock(ModBlocks.SPEEDY_FARMLAND.get(),
                modLoc("block/speedy_farmland"),
                modLoc("block/speedy_farmland_moist"),
                modLoc("block/blue_dirt"));

        farmlandBlock(ModBlocks.FLASH_FARMLAND.get(),
                modLoc("block/flash_farmland"),
                modLoc("block/flash_farmland_moist"),
                modLoc("block/yellow_dirt"));

        farmlandBlock(ModBlocks.FIERY_FARMLAND.get(),
                modLoc("block/fiery_farmland"),
                modLoc("block/fiery_farmland_moist"),
                modLoc("block/red_dirt"));

        farmlandBlock(ModBlocks.TWINDLING_TWEAKS_FARMLAND.get(),
                modLoc("block/twindling_tweaks_farmland"),
                modLoc("block/twindling_tweaks_farmland_moist"),
                modLoc("block/combined_dirt"));

        cakeBlock(ModBlocks.GOAT_CAKE.get(), "goat_cake");

        signBlock(((StandingSignBlock) ModBlocks.CATALPA_SIGN.get()), ((WallSignBlock) ModBlocks.CATALPA_WALL_SIGN.get()),
                blockTexture(ModBlocks.CATALPA_PLANKS.get()));
        signBlock(((StandingSignBlock) ModBlocks.RED_MAPLE_SIGN.get()), ((WallSignBlock) ModBlocks.RED_MAPLE_WALL_SIGN.get()),
                blockTexture(ModBlocks.RED_MAPLE_PLANKS.get()));

        hangingSignBlock(ModBlocks.CATALPA_HANGING_SIGN.get(), ModBlocks.CATALPA_WALL_HANGING_SIGN.get(), blockTexture(ModBlocks.CATALPA_PLANKS.get()));
        saplingBlock(ModBlocks.CATALPA_SAPLING);
        hangingSignBlock(ModBlocks.RED_MAPLE_HANGING_SIGN.get(), ModBlocks.RED_MAPLE_WALL_HANGING_SIGN.get(), blockTexture(ModBlocks.RED_MAPLE_PLANKS.get()));
        saplingBlock(ModBlocks.RED_MAPLE_SAPLING);

        saplingBlock(ModBlocks.BANANA_SAPLING);
        bananaLeavesBlock();

        makeBush(((SweetBerryBushBlock) ModBlocks.BLUEBERRY_BUSH.get()), "blueberry_bush_stage", "blueberry_bush_stage");
        makeBush(((SweetBerryBushBlock) ModBlocks.RASPBERRY_BUSH.get()), "raspberry_bush_stage", "raspberry_bush_stage");

        makeCucumberCrop(((CropBlock) ModBlocks.CUCUMBER_SEEDS_BLOCK.get()), "cucumber_seeds_stage", "cucumber_seeds_stage");
        makeTomatoCrop(((CropBlock) ModBlocks.TOMATO_SEEDS_BLOCK.get()), "tomato_seeds_stage", "tomato_seeds_stage");
        makeLettuceCrop(((CropBlock) ModBlocks.LETTUCE_SEEDS_BLOCK.get()), "lettuce_seeds_stage", "lettuce_seeds_stage");
        makeOrangeCrop(((CropBlock) ModBlocks.ORANGE_SEEDS_BLOCK.get()), "orange_seeds_stage", "orange_seeds_stage");
        makeBroccoliCrop(((CropBlock) ModBlocks.BROCCOLI_SEEDS_BLOCK.get()), "broccoli_seeds_stage", "broccoli_seeds_stage");
        makeCornCrop(((CropBlock) ModBlocks.CORN_SEEDS_BLOCK.get()), "corn_seeds_stage", "corn_seeds_stage");
    }

    public void cakeBlock(Block block, String textureBaseName) {
        for (int i = 0; i <= 6; i++) {
            String suffix = i == 0 ? "" : "_slice" + i;
            String modelName = name(block) + suffix;

            String parent = i == 0 ? "block/cake" : "block/cake_slice" + i;
            models().withExistingParent(modelName, mcLoc(parent))
                    .texture("bottom", modLoc("block/" + textureBaseName + "_bottom"))
                    .texture("top", modLoc("block/" + textureBaseName + "_top"))
                    .texture("side", modLoc("block/" + textureBaseName + "_side"))
                    .texture("inside", modLoc("block/" + textureBaseName + "_inner"));
        }

        getVariantBuilder(block).forAllStates(state -> {
            int bites = state.getValue(CakeBlock.BITES);
            ResourceLocation model = modLoc("block/" + name(block) + (bites == 0 ? "" : "_slice" + bites));
            return ConfiguredModel.builder()
                    .modelFile(models().getExistingFile(model))
                    .build();
        });
    }

    public void farmlandBlock(Block block, ResourceLocation dryTop, ResourceLocation moistTop, ResourceLocation side) {
        ModelFile dryModel = models().withExistingParent(name(block), mcLoc("block/template_farmland"))
                .texture("top", dryTop)
                .texture("dirt", side)
                .texture("particle", dryTop);

        ModelFile moistModel = models().withExistingParent(name(block) + "_moist", mcLoc("block/template_farmland"))
                .texture("top", moistTop)
                .texture("dirt", side)
                .texture("particle", moistTop);

        getVariantBuilder(block).forAllStates(state -> {
            int moisture = state.getValue(FarmBlock.MOISTURE);
            return ConfiguredModel.builder()
                    .modelFile(moisture > 0 ? moistModel : dryModel)
                    .build();
        });
    }

    private void bananaLeavesBlock() {
        Block block = ModBlocks.BANANA_LEAVES.get();

        // Generate 4 different models
        for (int i = 0; i < 4; i++) {
            String modelName = "banana_leaves_" + i;
            models().cubeAll(modelName, modLoc("block/" + modelName));
        }

        getVariantBuilder(block)
                .partialState().setModels(
                        ConfiguredModel.builder()
                                .modelFile(models().getExistingFile(modLoc("block/banana_leaves_0"))).weight(1).nextModel()
                                .modelFile(models().getExistingFile(modLoc("block/banana_leaves_1"))).weight(1).nextModel()
                                .modelFile(models().getExistingFile(modLoc("block/banana_leaves_2"))).weight(1).nextModel()
                                .modelFile(models().getExistingFile(modLoc("block/banana_leaves_3"))).weight(1)
                                .build()
                );
    }

    private void dirtPathBlock(Block block) {
        String name = key(block).getPath();
        String baseName = name.replace("_path", "");

        ResourceLocation bottomTexture = modLoc("block/" + baseName);

        if (baseName.equals("dirt") || baseName.equals("coarse_dirt") ||
                baseName.equals("rooted_dirt") || baseName.equals("soul_sand") ||
                baseName.equals("soul_soil")) {
            bottomTexture = mcLoc("block/" + baseName);
        }

        ModelFile model = models().withExistingParent(name, mcLoc("block/dirt_path"))
                .texture("top", modLoc("block/" + name + "_top"))
                .texture("side", modLoc("block/" + name + "_side"))
                .texture("bottom", bottomTexture)
                .texture("particle", bottomTexture);

        simpleBlock(block, model);
    }

    private void carpetBlock(Block block, String woolTextureName) {
        ResourceLocation woolTexture = modLoc("block/" + woolTextureName);

        ModelFile model = models().withExistingParent(
                name(block),
                mcLoc("block/carpet")
        ).texture("wool", woolTexture);

        simpleBlock(block, model);

        simpleBlockItem(block, model);
    }

    private void glass(DeferredBlock<Block> block) {
        String name = block.getId().getPath();

        simpleBlockWithItem(block.get(),
                models().cubeAll(name, modLoc("block/" + name)));
    }

    private void glassPane(DeferredBlock<Block> block) {
        String name = block.getId().getPath();
        String base = name.replace("_pane", "");

        paneBlock(
                (IronBarsBlock) block.get(),
                modLoc("block/" + base),
                modLoc("block/" + name + "_top")
        );
    }

    private void glazedTerracotta(DeferredBlock<Block> block) {
        String name = block.getId().getPath();

        ModelFile model = models().withExistingParent(name,
                        mcLoc("block/template_glazed_terracotta"))
                .texture("pattern", modLoc("block/" + name));

        horizontalBlock(block.get(), model);
    }

    private void candle(DeferredBlock<Block> block) {
        String name = block.getId().getPath();

        // --- MODEL GENERATION ----------------------------------------------------

        ModelFile[] unlit = new ModelFile[4];
        ModelFile[] lit = new ModelFile[4];

        for (int i = 1; i <= 4; i++) {

            // Correct vanilla parent names
            String vanillaBase = switch (i) {
                case 1 -> "candle_one_candle";
                case 2 -> "candle_two_candles";
                case 3 -> "candle_three_candles";
                case 4 -> "candle_four_candles";
                default -> throw new IllegalStateException();
            };

            // Unlit model
            unlit[i - 1] = models()
                    .withExistingParent(name + "_" + i, mcLoc("block/" + vanillaBase))
                    .texture("all", modLoc("block/" + name));

            // Lit model
            lit[i - 1] = models()
                    .withExistingParent(name + "_" + i + "_lit", mcLoc("block/" + vanillaBase + "_lit"))
                    .texture("all", modLoc("block/" + name + "_lit"));
        }

        // Item model = unlit single candle (vanilla behavior)
        simpleBlockItem(block.get(), unlit[0]);

        // --- BLOCKSTATE GENERATION ----------------------------------------------

        getVariantBuilder(block.get()).forAllStates(state -> {
            int count = state.getValue(CandleBlock.CANDLES);
            boolean isLit = state.getValue(CandleBlock.LIT);
            boolean waterlogged = state.getValue(BlockStateProperties.WATERLOGGED);

            // Waterlogged candles use the SAME model — vanilla does not change geometry
            ModelFile model = isLit ? lit[count - 1] : unlit[count - 1];

            return ConfiguredModel.builder()
                    .modelFile(model)
                    .build();
        });
    }

    private void bed(String name, Block block) {
        // Vanilla bed blockstate is special — we generate a simple placeholder
        // Mixins will override the renderer anyway.
        simpleBlock(block);
    }

    private void shulkerBox(String name, Block block) {
        // Shulker boxes use entity models, not block models.
        // We generate a placeholder blockstate.
        simpleBlock(block);
    }

    public void makeCucumberCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> CucumberStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] CucumberStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((CucumberPlantBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, "block/" + textureName + state.getValue(((CucumberPlantBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    public void makeTomatoCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> TomatoStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] TomatoStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((TomatoPlantBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, "block/" + textureName + state.getValue(((TomatoPlantBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    public void makeLettuceCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> LettuceStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] LettuceStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((LettucePlantBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, "block/" + textureName + state.getValue(((LettucePlantBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    public void makeOrangeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> OrangeStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] OrangeStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((OrangePlantBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, "block/" + textureName + state.getValue(((OrangePlantBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    public void makeBroccoliCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> BroccoliStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] BroccoliStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((BroccoliPlantBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, "block/" + textureName + state.getValue(((BroccoliPlantBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    public void makeCornCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> CornStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] CornStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((CornPlantBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, "block/" + textureName + state.getValue(((CornPlantBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    public void makeBush(SweetBerryBushBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().cross(modelName + state.getValue(BlueberryBushBlock.AGE),
                ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, "block/" + textureName + state.getValue(BlueberryBushBlock.AGE))).renderType("cutout"));

        return models;
    }


    private void cubeWithCustomSides(Block block,
                                     ResourceLocation up, ResourceLocation down,
                                     ResourceLocation north, ResourceLocation south,
                                     ResourceLocation west, ResourceLocation east,
                                     ResourceLocation particle) {

        String name = key(block).getPath();

        ModelFile model = models().cube(name, down, up, north, south, west, east);
        getVariantBuilder(block).partialState().setModels(new ConfiguredModel(model));
        simpleBlockItem(block, model); // Also generates block item model
    }

    private void saplingBlock(DeferredBlock<? extends Block> blockHolder) {
        Block block = blockHolder.get();
        simpleBlock(block,
                models().cross(BuiltInRegistries.BLOCK.getKey(block).getPath(), blockTexture(block)).renderType("cutout"));
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        hangingSignBlock(signBlock, wallSignBlock, sign);
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }


    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }

    private void leavesBlock(DeferredBlock<? extends Block> blockHolder) {
        Block block = blockHolder.get();
        simpleBlockWithItem(block,
                models().singleTexture(
                        BuiltInRegistries.BLOCK.getKey(block).getPath(),
                        ResourceLocation.parse("minecraft:block/leaves"),
                        "all",
                        blockTexture(block)
                ).renderType("cutout")
        );
    }

    private void blockItem(DeferredBlock<? extends Block> blockHolder) {
        Block block = blockHolder.get();
        simpleBlockItem(block,
                new ModelFile.UncheckedModelFile(
                        TwindlingTweaks.MOD_ID + ":block/" + BuiltInRegistries.BLOCK.getKey(block).getPath()
                )
        );
    }

    private void blockWithItem(DeferredBlock<? extends Block> blockHolder) {
        Block block = blockHolder.get();
        simpleBlockWithItem(block, cubeAll(block));
    }
}