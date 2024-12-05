package net.xstopho.resource_cracker;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.xstopho.resource_cracker.config.CrackerConfig;
import net.xstopho.resource_cracker.modifier.LootModifier;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.CreativeTabRegistry;
import net.xstopho.resource_cracker.registries.ItemModelRenderRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import net.xstopho.resourceconfigapi.api.ConfigRegistry;

@Mod(CrackerConstants.MOD_ID)
public class ResourceCracker {

    public ResourceCracker() {
        ConfigRegistry.register(CrackerConstants.MOD_ID, CrackerConfig.BUILDER, true);

        BlockRegistry.init();
        ItemRegistry.init();
        CreativeTabRegistry.init();

        LootModifier.init();
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ResourceCrackerClient {

        @SubscribeEvent
        public static void renderSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.GARLIC_CROP.get(), RenderType.cutout());
        }
    }
}
