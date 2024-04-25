package net.xstopho.resource_cracker;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.xstopho.resource_config_api.api.ConfigRegistry;
import net.xstopho.resource_cracker.config.Config;
import net.xstopho.resource_cracker.modifier.LootModifier;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.ItemGroupRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import net.xstopho.resource_cracker.rendering.ScytheInHandModel;

@Mod(Constants.MOD_ID)
public class ResourceCracker {

    public ResourceCracker() {
        ConfigRegistry.register(Constants.MOD_ID, Config.BUILDER);

        ItemRegistry.init();
        BlockRegistry.init();
        ItemGroupRegistry.init();

        LootModifier.init();

        Constants.LOG.info("Initialisation finished!");
    }

    @EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ResourceCrackerClient {

        @SubscribeEvent
        public static void renderSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.GARLIC_CROP.get(), RenderType.cutout());
        }

        @SubscribeEvent
        public static void modelRegistry(ModelEvent.RegisterAdditional event) {
            ScytheInHandModel.onRegisterModel(event);
        }

        @SubscribeEvent
        public static void renderModel(ModelEvent.ModifyBakingResult event) {
            ScytheInHandModel.onModelBakeEvent(event);
        }
    }
}