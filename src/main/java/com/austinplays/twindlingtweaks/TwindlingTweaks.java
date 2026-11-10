package com.austinplays.twindlingtweaks;

import com.austinplays.twindlingtweaks.block.ModBlocks;
import com.austinplays.twindlingtweaks.block.entity.ModBlockEntities;
import com.austinplays.twindlingtweaks.block.entity.ModEntities;
import com.austinplays.twindlingtweaks.entity.client.renderers.boat.ModBoatRenderer;
import com.austinplays.twindlingtweaks.entity.client.renderers.boat.ModBoatRenderer2;
import com.austinplays.twindlingtweaks.entity.client.renderers.throwable.MudBallProjectileRenderer;
import com.austinplays.twindlingtweaks.item.ModItems;
import com.austinplays.twindlingtweaks.item.custom.tabs.ModCreativeModeTab;
import com.austinplays.twindlingtweaks.loot.ModLootModifiers;
import com.austinplays.twindlingtweaks.recipes.ModRecipes;
import com.austinplays.twindlingtweaks.screen.ModMenuTypes;
import com.austinplays.twindlingtweaks.screen.crusher.CrusherScreen;
import com.austinplays.twindlingtweaks.screen.filterer.FiltererScreen;
import com.austinplays.twindlingtweaks.screen.obsidian_forger.ObsidianForgerScreen;
import com.austinplays.twindlingtweaks.screen.pasteurizer.PasteurizerScreen;
import com.austinplays.twindlingtweaks.sound.ModSounds;
import com.austinplays.twindlingtweaks.util.ModWoodTypes;
import com.austinplays.twindlingtweaks.world.biome.ModBiomes;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BedRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.ShulkerBoxRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.SheepRenderer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MultiNoiseBiomeSourceParameterList;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

@Mod(TwindlingTweaks.MOD_ID)
public class TwindlingTweaks {
    public static final String MOD_ID = "twindlingtweaks";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(Registries.BIOME, MOD_ID);

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
        ModBiomes.registerBiomes();
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

            EntityRenderers.register(ModEntities.MUD_BALL.value(), MudBallProjectileRenderer::new);

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