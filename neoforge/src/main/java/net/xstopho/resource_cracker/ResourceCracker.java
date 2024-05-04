package net.xstopho.resource_cracker;

import net.neoforged.fml.common.Mod;
import net.xstopho.resource_config_api.api.ConfigRegistry;
import net.xstopho.resource_cracker.config.CrackerConfig;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.CreativeTabRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;

@Mod(CrackerConstants.MOD_ID)
public class ResourceCracker {

    public ResourceCracker() {
        ConfigRegistry.register(CrackerConstants.MOD_ID, CrackerConfig.BUILDER);

        BlockRegistry.init();
        ItemRegistry.init();
        CreativeTabRegistry.init();
    }
}
