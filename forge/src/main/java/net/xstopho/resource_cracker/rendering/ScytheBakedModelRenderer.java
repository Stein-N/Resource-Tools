package net.xstopho.resource_cracker.rendering;

import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.xstopho.resource_cracker.CrackerConstants;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class ScytheBakedModelRenderer {

    @SubscribeEvent
    public static void onRegisterModel(ModelEvent.RegisterAdditional event) {
        event.register(location("in_hand/scythe_copper"));
        event.register(location("in_hand/scythe_gold"));
        event.register(location("in_hand/scythe_iron"));
        event.register(location("in_hand/scythe_steel"));
        event.register(location("in_hand/scythe_diamond"));
        event.register(location("in_hand/scythe_netherite"));
    }

    @SubscribeEvent
    public static void onModelBakeEvent(ModelEvent.ModifyBakingResult event) {
        Map<ModelResourceLocation, BakedModel> map = event.getModels();

        map.put(location("scythe_copper"), new ScytheBakedModel("scythe_copper", map));
        map.put(location("scythe_gold"), new ScytheBakedModel("scythe_gold", map));
        map.put(location("scythe_iron"), new ScytheBakedModel("scythe_iron", map));
        map.put(location("scythe_steel"), new ScytheBakedModel("scythe_steel", map));
        map.put(location("scythe_diamond"), new ScytheBakedModel("scythe_diamond", map));
        map.put(location("scythe_netherite"), new ScytheBakedModel("scythe_netherite", map));
    }

    private static ModelResourceLocation location(String path) {
        return ModelResourceLocation.inventory(ResourceLocation.fromNamespaceAndPath(CrackerConstants.MOD_ID, path));
    }
}
