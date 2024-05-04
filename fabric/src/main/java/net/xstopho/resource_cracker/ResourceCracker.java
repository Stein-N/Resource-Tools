package net.xstopho.resource_cracker;

import net.fabricmc.api.ModInitializer;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.CreativeTabRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;

public class ResourceCracker implements ModInitializer {
    @Override
    public void onInitialize() {
        BlockRegistry.init();
        ItemRegistry.init();
        CreativeTabRegistry.init();
    }
}
