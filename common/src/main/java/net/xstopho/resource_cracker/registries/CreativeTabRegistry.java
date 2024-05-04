package net.xstopho.resource_cracker.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.xstopho.resource_cracker.CrackerConstants;
import net.xstopho.resourcelibrary.registration.RegistryObject;
import net.xstopho.resourcelibrary.registration.RegistryProvider;

public class CreativeTabRegistry {

    private static final RegistryProvider<CreativeModeTab> CREATIVE_TABS = RegistryProvider.get(Registries.CREATIVE_MODE_TAB, CrackerConstants.MOD_ID);

    public static final RegistryObject<CreativeModeTab> RESOURCE_CRACKER = CREATIVE_TABS.register("item_group",
            () -> CreativeModeTab.builder(null, -1).title(Component.translatable("item_group.resource_cracker"))
                    .icon(() -> new ItemStack(Items.DIAMOND)).displayItems((itemDisplayParameters, output) -> {

                    }).build());

    public static void init() {}
}
