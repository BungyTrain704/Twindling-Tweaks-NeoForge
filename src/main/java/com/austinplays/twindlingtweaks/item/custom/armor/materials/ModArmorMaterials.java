package com.austinplays.twindlingtweaks.item.custom.armor.materials;

import com.austinplays.twindlingtweaks.TwindlingTweaks;
import com.austinplays.twindlingtweaks.item.ModItems;
import com.austinplays.twindlingtweaks.util.ModTags;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {
    public static final ArmorMaterial ALLUMINITE_ARMOR_MATERIAL = new ArmorMaterial(1200,
            Util.make(new EnumMap<>(ArmorType.class), attribute -> {
                attribute.put(ArmorType.BOOTS, 4);
                attribute.put(ArmorType.LEGGINGS, 6);
                attribute.put(ArmorType.CHESTPLATE, 6);
                attribute.put(ArmorType.HELMET, 5);
                attribute.put(ArmorType.BODY, 14);
            }), 16, SoundEvents.ARMOR_EQUIP_DIAMOND,
            2f, 0.1f, ModTags.Items.ALLUMINITE_REPAIRABLE, ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, "alluminite"));

    public static final ArmorMaterial OBSIDIAN_ARMOR_MATERIAL = new ArmorMaterial(2000,
            Util.make(new EnumMap<>(ArmorType.class), attribute -> {
                attribute.put(ArmorType.BOOTS, 5);
                attribute.put(ArmorType.LEGGINGS, 6);
                attribute.put(ArmorType.CHESTPLATE, 7);
                attribute.put(ArmorType.HELMET, 5);
                attribute.put(ArmorType.BODY, 18);
            }), 16, SoundEvents.ARMOR_EQUIP_NETHERITE,
            2f, 0.1f, ModTags.Items.OBSIDIAN_REPAIRABLE, ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, "obsidian"));
}