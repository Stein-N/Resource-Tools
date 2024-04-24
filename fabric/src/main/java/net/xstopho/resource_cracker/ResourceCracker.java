package net.xstopho.resource_cracker;

import net.fabricmc.api.ModInitializer;
import net.xstopho.resource_config_api.api.ConfigRegistry;
import net.xstopho.resource_cracker.config.Config;
import net.xstopho.resource_cracker.modifier.LootModifier;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.ItemGroupRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;

public class ResourceCracker implements ModInitializer {

    @Override
    public void onInitialize() {
        ConfigRegistry.register(Constants.MOD_ID, Config.BUILDER);

        BlockRegistry.init();
        ItemRegistry.init();
        ItemGroupRegistry.init();

        LootModifier.init();

        Constants.LOG.info("Initialisation finished!");
    }
}
