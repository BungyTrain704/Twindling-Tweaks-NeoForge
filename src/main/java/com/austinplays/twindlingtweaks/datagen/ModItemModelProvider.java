package com.austinplays.twindlingtweaks.datagen;

import com.austinplays.twindlingtweaks.TwindlingTweaks;
import com.austinplays.twindlingtweaks.block.ModBlocks;
import com.austinplays.twindlingtweaks.item.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.minecraft.world.item.equipment.trim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TwindlingTweaks.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Replace all DeferredHolder<Item> with DeferredHolder<Item>
        simpleItem(ModItems.UNSTABLE_ALLUMINITE_INGOT);
        simpleItem(ModItems.REINFORCED_ALLUMINITE_INGOT);
        simpleItem(ModItems.ALLUMINITE_INGOT);
        simpleItem(ModItems.ALLUMINITE_NUGGET);
        simpleItem(ModItems.ALLUMINITE_ROD_SHARD);
        simpleItem(ModItems.RAW_ALLUMINITE);
        simpleItem(ModItems.RAW_LUMINIUM);
        simpleItem(ModItems.UNPROCESSED_LUMINIUM_CHUNK);
        simpleItem(ModItems.LUMINIUM_CHUNK);
        simpleItem(ModItems.LUMINIUM_GEM);
        simpleItem(ModItems.REINFORCED_LUMINIUM_GEM);
        simpleItem(ModItems.IRON_CHUNKS);
        simpleItem(ModItems.DIAMOND_CHUNKS);
        simpleItem(ModItems.DIAMOND_POWDER);
        simpleItem(ModItems.IRON_POWDER);
        simpleItem(ModItems.MUD_BALL);
        simpleItem(ModItems.DRIED_MUD_BALL);
        simpleItem(ModItems.UNFILTERED_SUGAR);
        simpleItem(ModItems.SALT_ROCK);
        simpleItem(ModItems.SALT);
        simpleItem(ModItems.ORANGE_SEED_POWDER);
        simpleItem(ModItems.ORANGE_SEED_MILK);
        simpleItem(ModItems.IRON_INFUSED_MILK);
        simpleItem(ModItems.DIAMOND_INFUSED_MILK);

        simpleItem(ModItems.LUMINIUM_APPLE);
        simpleItem(ModItems.SALAD_TOPPINGS);
        simpleItem(ModItems.SALAD);
        simpleItem(ModItems.RANCH_BOTTLE);
        simpleItem(ModItems.KETCHUP_BOTTLE);
        simpleItem(ModItems.CRUSHED_TOMATO);
        simpleItem(ModItems.CRUSHED_TOMATO_BOTTLE);
        simpleItem(ModItems.VEGETABLE_OIL);
        simpleItem(ModItems.HEARTY_STEW);
        simpleItem(ModItems.BOILED_EGG);
        simpleItem(ModItems.SALTED_RAW_BEEF);
        simpleItem(ModItems.SALTED_RAW_PORKCHOP);
        simpleItem(ModItems.SALTED_RAW_CHICKEN);
        simpleItem(ModItems.SALTED_RAW_MUTTON);
        simpleItem(ModItems.SALTED_RAW_RABBIT);
        simpleItem(ModItems.SALTED_RAW_COD);
        simpleItem(ModItems.SALTED_RAW_SALMON);
        simpleItem(ModItems.BREAD_SLICE);
        simpleItem(ModItems.TOAST);
        simpleItem(ModItems.GOAT_MILK);
        simpleItem(ModItems.GOAT_CHEESE);
        simpleItem(ModItems.SLICED_GOAT_CHEESE);
        simpleItem(ModItems.GOAT_ICE_CREAM);
        simpleItem(ModItems.GOAT_BUTTER);
        simpleItem(ModItems.VANILLA_GOAT_YOGURT);
        simpleItem(ModItems.CUCUMBER);
        simpleItem(ModItems.TOMATO);
        simpleItem(ModItems.LETTUCE);
        simpleItem(ModItems.ORANGE);
        simpleItem(ModItems.BROCCOLI);
        simpleItem(ModItems.CORN);
        simpleItem(ModItems.CROUTON);
        simpleItem(ModItems.STEAK_LETTUCE_SANDWICH);
        simpleItem(ModItems.TOASTED_STEAK_LETTUCE_SANDWICH);
        simpleItem(ModItems.CHEESE_MEAT_SANDWICH);
        simpleItem(ModItems.VEGAN_SANDWICH);
        simpleItem(ModItems.MEATY_SANDWICH);
        simpleItem(ModItems.POTATO_BITS);
        simpleItem(ModItems.SALTED_POTATO_CHIPS);
        simpleItem(ModItems.FRIED_EGG);
        simpleItem(ModItems.BLUEBERRIES);
        simpleItem(ModItems.RASPBERRIES);
        simpleItem(ModItems.BANANA);
        simpleItem(ModItems.BANANA_SANDWICH);
        simpleItem(ModItems.BERRY_BOWL);
        simpleItem(ModItems.BERRY_TOAST);
        simpleItem(ModItems.SPRING_SALAD_TOPPINGS);
        simpleItem(ModItems.SPRING_SALAD);
        simpleItem(ModItems.SPECIAL_SALAD_TOPPINGS);
        simpleItem(ModItems.SPECIAL_SALAD);

        simpleItem(ModItems.CUCUMBER_SEEDS);
        simpleItem(ModItems.TOMATO_SEEDS);
        simpleItem(ModItems.LETTUCE_SEEDS);
        simpleItem(ModItems.BROCCOLI_SEEDS);
        simpleItem(ModItems.CORN_SEEDS);
        simpleItem(ModItems.ORANGE_SEEDS);

        simpleItem(ModItems.GOAT_CAKE_ITEM);

        simpleItem(ModItems.MYSTICAL_MUSIC_DISC);
        simpleItem(ModItems.MYSTICAL_DISC_FRAGMENT);

        simpleItem(ModItems.EMPTY_SCHEMATIC);
        simpleItem(ModItems.BASIC_DIRT_SCHEMATIC);
        simpleItem(ModItems.BLUE_DIRT_SCHEMATIC);
        simpleItem(ModItems.YELLOW_DIRT_SCHEMATIC);
        simpleItem(ModItems.RED_DIRT_SCHEMATIC);
        simpleItem(ModItems.ALLUMIN_LUMINIUM_DIRT_SCHEMATIC);
        simpleItem(ModItems.BASIC_DIRT_PATH_SCHEMATIC);
        simpleItem(ModItems.ADVANCED_DIRT_PATH_SCHEMATIC);
        simpleItem(ModItems.BLUE_DIRT_PATH_SCHEMATIC);
        simpleItem(ModItems.YELLOW_DIRT_PATH_SCHEMATIC);
        simpleItem(ModItems.RED_DIRT_PATH_SCHEMATIC);
        simpleItem(ModItems.ALLUMIN_LUMINIUM_DIRT_PATH_SCHEMATIC);

        basicItem(ModBlocks.CATALPA_DOOR.asItem());
        basicItem(ModBlocks.RED_MAPLE_DOOR.asItem());
        basicItem(ModBlocks.MUD_DOOR.asItem());

        fenceItem(ModBlocks.CATALPA_FENCE, ModBlocks.CATALPA_PLANKS);
        buttonItem(ModBlocks.CATALPA_BUTTON, ModBlocks.CATALPA_PLANKS);
        fenceItem(ModBlocks.RED_MAPLE_FENCE, ModBlocks.RED_MAPLE_PLANKS);
        buttonItem(ModBlocks.RED_MAPLE_BUTTON, ModBlocks.RED_MAPLE_PLANKS);

        evenSimplerBlockItem(ModBlocks.CATALPA_STAIRS);
        evenSimplerBlockItem(ModBlocks.CATALPA_SLAB);
        evenSimplerBlockItem(ModBlocks.CATALPA_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.CATALPA_FENCE_GATE);
        evenSimplerBlockItem(ModBlocks.RED_MAPLE_STAIRS);
        evenSimplerBlockItem(ModBlocks.RED_MAPLE_SLAB);
        evenSimplerBlockItem(ModBlocks.RED_MAPLE_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.RED_MAPLE_FENCE_GATE);

        trapdoorItem(ModBlocks.CATALPA_TRAPDOOR);
        trapdoorItem(ModBlocks.RED_MAPLE_TRAPDOOR);
        trapdoorItem(ModBlocks.MUD_TRAPDOOR);

        handheldItem(ModItems.ALLUMINITE_SWORD);
        handheldItem(ModItems.ALLUMINITE_PICKAXE);
        handheldItem(ModItems.ALLUMINITE_AXE);
        handheldItem(ModItems.ALLUMINITE_SHOVEL);
        handheldItem(ModItems.ALLUMINITE_HOE);
        handheldItem(ModItems.OBSIDIAN_SWORD);
        handheldItem(ModItems.OBSIDIAN_PICKAXE);
        handheldItem(ModItems.OBSIDIAN_AXE);
        handheldItem(ModItems.OBSIDIAN_SHOVEL);
        handheldItem(ModItems.OBSIDIAN_HOE);
        handheldItem(ModItems.OBSIDIAN_HAMMER);
        handheldItem(ModItems.STONE_HAMMER);
        handheldItem(ModItems.IRON_HAMMER);
        handheldItem(ModItems.DIAMOND_HAMMER);
        handheldItem(ModItems.ALLUMINITE_ROD);
        handheldItem(ModItems.COOKING_KNIFE);

        trimmedArmorItem(ModItems.ALLUMINITE_HELMET);
        trimmedArmorItem(ModItems.ALLUMINITE_CHESTPLATE);
        trimmedArmorItem(ModItems.ALLUMINITE_LEGGINGS);
        trimmedArmorItem(ModItems.ALLUMINITE_BOOTS);
        trimmedArmorItem(ModItems.OBSIDIAN_HELMET);
        trimmedArmorItem(ModItems.OBSIDIAN_CHESTPLATE);
        trimmedArmorItem(ModItems.OBSIDIAN_LEGGINGS);
        trimmedArmorItem(ModItems.OBSIDIAN_BOOTS);

        simpleItem(ModItems.CATALPA_SIGN);
        simpleItem(ModItems.CATALPA_HANGING_SIGN);
        simpleItem(ModItems.RED_MAPLE_SIGN);
        simpleItem(ModItems.RED_MAPLE_HANGING_SIGN);

        simpleItem(ModItems.CATALPA_BOAT);
        simpleItem(ModItems.CATALPA_CHEST_BOAT);
        simpleItem(ModItems.RED_MAPLE_BOAT);
        simpleItem(ModItems.RED_MAPLE_CHEST_BOAT);

        saplingItem(ModBlocks.CATALPA_SAPLING);
        saplingItem(ModBlocks.RED_MAPLE_SAPLING);
        saplingItem(ModBlocks.BANANA_SAPLING);

        basicItem(ModBlocks.CATALPA_FLOWERS.getId());

        bananaLeavesItem();

        evenSimplerBlockItem(ModBlocks.BLUE_DIRT_PATH);
        evenSimplerBlockItem(ModBlocks.YELLOW_DIRT_PATH);
        evenSimplerBlockItem(ModBlocks.RED_DIRT_PATH);
        evenSimplerBlockItem(ModBlocks.ALLUMIN_LUMINIUM_DIRT_PATH);

        evenSimplerBlockItem(ModBlocks.COARSE_DIRT_PATH);
        evenSimplerBlockItem(ModBlocks.ROOTED_DIRT_PATH);
        evenSimplerBlockItem(ModBlocks.SOUL_SAND_PATH);
        evenSimplerBlockItem(ModBlocks.SOUL_SOIL_PATH);

        evenSimplerBlockItem(ModBlocks.SPEEDY_FARMLAND);
        evenSimplerBlockItem(ModBlocks.FLASH_FARMLAND);
        evenSimplerBlockItem(ModBlocks.FIERY_FARMLAND);
        evenSimplerBlockItem(ModBlocks.TWINDLING_TWEAKS_FARMLAND);
    }
    private void trimmedArmorItem(DeferredItem<? extends Item> itemDeferredHolder) {
        final String MOD_ID = TwindlingTweaks.MOD_ID; // Change this to your mod id

        if(itemDeferredHolder.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, value) -> {
                float trimValue = value;

                String armorType = "";
                if(armorItem.toString().contains("helmet")) {
                    armorType = "helmet";
                } else if(armorItem.toString().contains("chestplate")) {
                    armorType = "chestplate";
                } else if(armorItem.toString().contains("leggings")) {
                    armorType = "leggings";
                } else if(armorItem.toString().contains("boots")) {
                    armorType = "boots";
                }

                String armorItemPath = armorItem.toString();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.parse(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemDeferredHolder.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace()  + ":item/" + trimNameResLoc.getPath()))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(MOD_ID,
                                        "item/" + itemDeferredHolder.getId().getPath()));
            });
        }
    }

    private void bedItem(DeferredItem<Item> item) {
        String name = item.getId().getPath();

        getBuilder(name)
                .parent(getExistingFile(mcLoc("item/template_bed")))
                .texture("texture", modLoc("entity/bed/" + name));
    }




    private ItemModelBuilder saplingItem(DeferredBlock<? extends Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID,"block/" + item.getId().getPath()));
    }

    private void bananaLeavesItem() {
        withExistingParent(
                ModBlocks.BANANA_LEAVES.getId().getPath(),
                modLoc("block/banana_leaves_0")
        );
    }

    private ItemModelBuilder simpleItem(DeferredItem<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(DeferredBlock<? extends Block> block) {
        this.withExistingParent(TwindlingTweaks.MOD_ID + ":" + BuiltInRegistries.BLOCK.getKey(block.get()).getPath(),
                modLoc("block/" + BuiltInRegistries.BLOCK.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(DeferredBlock<? extends Block> block) {
        this.withExistingParent(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(),
                modLoc("block/" + BuiltInRegistries.BLOCK.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(DeferredBlock<? extends Block> block, DeferredBlock<? extends Block> baseBlock) {
        this.withExistingParent(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, "block/" + BuiltInRegistries.BLOCK.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(DeferredBlock<? extends Block> block, DeferredBlock<? extends Block> baseBlock) {
        this.withExistingParent(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, "block/" + BuiltInRegistries.BLOCK.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(DeferredBlock<? extends Block> block, DeferredBlock<? extends Block> baseBlock) {
        this.withExistingParent(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, "block/" + BuiltInRegistries.BLOCK.getKey(baseBlock.get()).getPath()));
    }

    private void shulkerBoxItem(DeferredBlock<Block> item) {
        String name = item.getId().getPath();

        withExistingParent(name, mcLoc("item/shulker_box"));
    }

    private ItemModelBuilder handheldItem(DeferredItem<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(DeferredItem<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItemBlockTexture(DeferredBlock<? extends Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID,"block/" + item.getId().getPath()));
    }
}