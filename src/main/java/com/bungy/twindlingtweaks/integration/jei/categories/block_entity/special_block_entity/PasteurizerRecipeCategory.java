package com.bungy.twindlingtweaks.integration.jei.categories.block_entity.special_block_entity;

import com.bungy.twindlingtweaks.TwindlingTweaks;
import com.bungy.twindlingtweaks.block.ModBlocks;
import com.bungy.twindlingtweaks.integration.jei.JEITwindlingTweaksPlugin;
import com.bungy.twindlingtweaks.recipes.be_recipes.PasteurizerRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class PasteurizerRecipeCategory implements IRecipeCategory<PasteurizerRecipe> {
    public final static ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, "pasteurizing");
    public final static ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, "textures/gui/pasteurizer_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public PasteurizerRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.PASTEURIZER.get()));
    }

    @Override
    public RecipeType<PasteurizerRecipe> getRecipeType() {
        return JEITwindlingTweaksPlugin.PASTEURIZING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Pasteurizer");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, PasteurizerRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 80, 11).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 59)
                .addItemStack(recipe.getResultItem(RegistryAccess.EMPTY))
                .addRichTooltipCallback((slotIndex, tooltip) -> {
                    tooltip.add(Component.literal("§7Depends on player's potion effects"));
                });
    }
    }