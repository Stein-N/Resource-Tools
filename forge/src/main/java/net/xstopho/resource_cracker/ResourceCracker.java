package net.xstopho.resource_cracker;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.xstopho.resource_config_api.api.ConfigRegistry;
import net.xstopho.resource_cracker.config.CrackerConfig;
import net.xstopho.resource_cracker.modifier.LootModifier;
import net.xstopho.resource_cracker.registries.AttributeRegistry;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.CreativeTabRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import net.xstopho.resource_cracker.rendering.ScytheBakedModelRenderer;

@Mod(CrackerConstants.MOD_ID)
public class ResourceCracker {

    public ResourceCracker() {
        ConfigRegistry.register(CrackerConstants.MOD_ID, CrackerConfig.BUILDER);

        AttributeRegistry.init();

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

        @SubscribeEvent
        public static void modelRegistry(ModelEvent.RegisterAdditional event) {
            ScytheBakedModelRenderer.onRegisterModel(event);
        }

        @SubscribeEvent
        public static void renderModel(ModelEvent.ModifyBakingResult event) {
            ScytheBakedModelRenderer.onModelBakeEvent(event);
        }
    }
}
