package com.austinplays.twindlingtweaks.item.custom.tools;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

public class HammerItem extends TieredItem {
    public static final ResourceLocation ATTACK_DAMAGE_ID = ResourceLocation.fromNamespaceAndPath("twindlingtweaks", "hammer_attack_damage");
    public static final ResourceLocation ATTACK_SPEED_ID = ResourceLocation.fromNamespaceAndPath("twindlingtweaks", "hammer_attack_speed");

    private final float attackDamage;
    private final float attackSpeed;

    public HammerItem(Tier tier, float attackDamage, float attackSpeed, Item.Properties properties) {
        super(tier, properties);
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
    }

    @Override
    public ItemAttributeModifiers getDefaultAttributeModifiers() {
        return ItemAttributeModifiers.builder()
                .add(Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(ATTACK_DAMAGE_ID,attackDamage + this.getTier().getAttackDamageBonus(), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ATTACK_SPEED,
                        new AttributeModifier(ATTACK_SPEED_ID, attackSpeed, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .build();
    }
    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack stack) {
        ItemStack newStack = stack.copy();

        // Safely damage the item without involving a player entity
        newStack.setDamageValue(stack.getDamageValue() + 10);

        // If it's now broken, don't return it
        if (newStack.getDamageValue() >= newStack.getMaxDamage()) {
            return ItemStack.EMPTY;
        }

        return newStack;
    }
}