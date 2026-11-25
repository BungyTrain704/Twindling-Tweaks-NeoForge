package com.austinplays.twindlingtweaks.item.custom.tools;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;

public class HammerItem extends Item {
    public static final ResourceLocation ATTACK_DAMAGE_ID = ResourceLocation.fromNamespaceAndPath("twindlingtweaks", "hammer_attack_damage");
    public static final ResourceLocation ATTACK_SPEED_ID = ResourceLocation.fromNamespaceAndPath("twindlingtweaks", "hammer_attack_speed");

    private final ToolMaterial tier;

    public HammerItem(
            ToolMaterial tier,
            Properties properties
    ) {
        super(properties);
        this.tier = tier;
    }

    public ToolMaterial getTier() {
        return tier;
    }

    @Override
    public boolean hurtEnemy(
            ItemStack stack,
            LivingEntity target,
            LivingEntity attacker
    ) {
        stack.hurtAndBreak(
                1,
                attacker,
                EquipmentSlot.MAINHAND
        );

        return true;
    }
}