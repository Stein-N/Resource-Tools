package net.xstopho.resource_cracker.datagen.helper;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.xstopho.resource_cracker.CrackerConstants;

import java.util.Optional;

public class ItemModelHelper {

    private static final ResourceLocation PARENT = ResourceLocation.fromNamespaceAndPath(CrackerConstants.MOD_ID, "item/in_hand/handheld_large");

    public static void createInHandItemModel(ItemModelGenerators generator, Item item) {
        new ModelTemplate(Optional.of(PARENT), Optional.empty(), TextureSlot.LAYER0)
                .create(modifyItemKey(item), TextureMapping.layer0(modifyItemKey(item)), generator.output);
    }

    private static ResourceLocation modifyItemKey(Item item) {
        ResourceLocation key = getItemKey(item);
        return ResourceLocation.fromNamespaceAndPath(key.getNamespace(), "item/in_hand/" + key.getPath());
    }

    private static ResourceLocation getItemKey(Item item) {
        return BuiltInRegistries.ITEM.getKey(item);
    }
}
