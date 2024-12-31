package net.xstopho.resource_cracker;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.ItemModelRenderRegistry;

public class ResourceCrackerClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        CrackerConstants.clientInit();

        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.GARLIC_CROP.get(), RenderType.cutout());
    }
}
