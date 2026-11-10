package com.austinplays.twindlingtweaks.screen;

import com.austinplays.twindlingtweaks.TwindlingTweaks;
import com.austinplays.twindlingtweaks.screen.crusher.CrusherMenu;
import com.austinplays.twindlingtweaks.screen.filterer.FiltererMenu;
import com.austinplays.twindlingtweaks.screen.obsidian_forger.ObsidianForgerMenu;
import com.austinplays.twindlingtweaks.screen.pasteurizer.PasteurizerMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, TwindlingTweaks.MOD_ID);

    public static final DeferredHolder<MenuType<?>, MenuType<CrusherMenu>> CRUSHER_MENU =
            registerMenuType("crusher_menu", CrusherMenu::new);

    public static final DeferredHolder<MenuType<?>, MenuType<FiltererMenu>> FILTERER_MENU =
            registerMenuType("filterer_menu", FiltererMenu::new);

    public static final DeferredHolder<MenuType<?>, MenuType<ObsidianForgerMenu>> OBSIDIAN_FORGER_MENU =
            registerMenuType("obsidian_forger_menu", ObsidianForgerMenu::new);

    public static final DeferredHolder<MenuType<?>, MenuType<PasteurizerMenu>> PASTEURIZER_MENU =
            registerMenuType("pasteurizer_menu", PasteurizerMenu::new);

    private static <T extends AbstractContainerMenu> DeferredHolder<MenuType<?>, MenuType<T>> registerMenuType(String name,
                                                                                                               IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IMenuTypeExtension.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}