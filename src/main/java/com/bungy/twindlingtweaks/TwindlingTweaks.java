package com.bungy.twindlingtweaks;

import com.bungy.twindlingtweaks.block.ModBlocks;
import com.bungy.twindlingtweaks.block.entity.ModBlockEntities;
import com.bungy.twindlingtweaks.block.entity.ModEntities;
import com.bungy.twindlingtweaks.entity.client.renderers.boat.ModBoatRenderer;
import com.bungy.twindlingtweaks.entity.client.renderers.boat.ModBoatRenderer2;
import com.bungy.twindlingtweaks.item.ModItems;
import com.bungy.twindlingtweaks.item.custom.tabs.ModCreativeModeTab;
import com.bungy.twindlingtweaks.loot.ModLootModifiers;
import com.bungy.twindlingtweaks.recipes.ModRecipes;
import com.bungy.twindlingtweaks.screen.crusher.CrusherScreen;
import com.bungy.twindlingtweaks.screen.ModMenuTypes;
import com.bungy.twindlingtweaks.screen.filterer.FiltererScreen;
import com.bungy.twindlingtweaks.screen.obsidian_forger.ObsidianForgerScreen;
import com.bungy.twindlingtweaks.screen.pasteurizer.PasteurizerScreen;
import com.bungy.twindlingtweaks.sound.ModSounds;
import com.bungy.twindlingtweaks.util.ModWoodTypes;
import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

@Mod(TwindlingTweaks.MOD_ID)
public class TwindlingTweaks {
    public static final String MOD_ID = "twindlingtweaks";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static ResourceLocation modLoc(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    public TwindlingTweaks(IEventBus eventBus, ModContainer modContainer) {
        eventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);

        ModCreativeModeTab.register(eventBus);

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        ModSounds.register(eventBus);

        ModEntities.register(eventBus);

        ModLootModifiers.register(eventBus);
        ModBlockEntities.register(eventBus);

        ModMenuTypes.register(eventBus);
        ModRecipes.SERIALIZERS.register(eventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @EventBusSubscriber(modid = TwindlingTweaks.MOD_ID, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            Sheets.addWoodType(ModWoodTypes.RED_MAPLE);
            Sheets.addWoodType(ModWoodTypes.CATALPA);

            EntityRenderers.register(ModEntities.MOD_BOAT.value(), pContext -> new ModBoatRenderer(pContext, false));
            EntityRenderers.register(ModEntities.MOD_CHEST_BOAT.value(), pContext -> new ModBoatRenderer(pContext, true));

            EntityRenderers.register(ModEntities.MOD_BOAT_2.value(), pContext -> new ModBoatRenderer2(pContext, false));
            EntityRenderers.register(ModEntities.MOD_CHEST_BOAT_2.value(), pContext -> new ModBoatRenderer2(pContext, true));
        }

        @SubscribeEvent
        public static void onRegisterMenuScreens(RegisterMenuScreensEvent event) {
            event.register(ModMenuTypes.OBSIDIAN_FORGER_MENU.get(), ObsidianForgerScreen::new);
            event.register(ModMenuTypes.FILTERER_MENU.get(), FiltererScreen::new);
            event.register(ModMenuTypes.CRUSHER_MENU.get(), CrusherScreen::new);
            event.register(ModMenuTypes.PASTEURIZER_MENU.get(), PasteurizerScreen::new);
        }
    }
}