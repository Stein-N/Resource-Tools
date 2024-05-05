package net.xstopho.resource_cracker;

import net.fabricmc.api.ModInitializer;
import net.xstopho.resource_config_api.api.ConfigRegistry;
import net.xstopho.resource_cracker.config.CrackerConfig;
import net.xstopho.resource_cracker.modifier.LootModifier;
import net.xstopho.resource_cracker.registries.AttributeRegistry;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.CreativeTabRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;

public class ResourceCracker implements ModInitializer {
    @Override
    public void onInitialize() {
        ConfigRegistry.register(CrackerConstants.MOD_ID, CrackerConfig.BUILDER);

        AttributeRegistry.init();

        BlockRegistry.init();
        ItemRegistry.init();
        CreativeTabRegistry.init();

        LootModifier.init();
    }
}
