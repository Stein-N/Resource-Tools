package net.xstopho.resource_cracker.datagen.helper;

import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.renderer.item.SelectItemModel;
import net.minecraft.client.renderer.item.properties.select.DisplayContext;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.xstopho.resource_cracker.CrackerConstants;

import java.util.List;
import java.util.Optional;

public class ItemModelHelper {

    private static final ResourceLocation PARENT_FLAT = ResourceLocation.withDefaultNamespace("item/handheld");
    private static final ResourceLocation PARENT_FLAT_LARGE = ResourceLocation.fromNamespaceAndPath(CrackerConstants.MOD_ID, "item/in_hand/handheld_large");

    public static void generateScytheModels(ItemModelGenerators generator, Item item) {
        createBaseModels(generator, item);
        generator.itemModelOutput.accept(item,
                ItemModelUtils.select(new DisplayContext(),
                        ItemModelUtils.plainModel(normalModelKey(item)),
                        new SelectItemModel.SwitchCase<>(
                                List.of(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND), ItemModelUtils.plainModel(inHandModelKey(item))
                        ),
                        new SelectItemModel.SwitchCase<>(
                                List.of(ItemDisplayContext.FIRST_PERSON_LEFT_HAND), ItemModelUtils.plainModel(inHandModelKey(item))
                        ),
                        new SelectItemModel.SwitchCase<>(
                                List.of(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND), ItemModelUtils.plainModel(inHandModelKey(item))
                        ),
                        new SelectItemModel.SwitchCase<>(
                                List.of(ItemDisplayContext.THIRD_PERSON_LEFT_HAND), ItemModelUtils.plainModel(inHandModelKey(item))
                        )
                ));
    }

    private static void createBaseModels(ItemModelGenerators generator, Item item) {
        new ModelTemplate(Optional.of(PARENT_FLAT), Optional.empty(), TextureSlot.LAYER0)
                .create(normalModelKey(item), TextureMapping.layer0(normalModelKey(item)), generator.modelOutput);

        new ModelTemplate(Optional.of(PARENT_FLAT_LARGE), Optional.empty(), TextureSlot.LAYER0)
                .create(inHandModelKey(item), TextureMapping.layer0(inHandModelKey(item)), generator.modelOutput);
    }

    private static ResourceLocation normalModelKey(Item item) {
        ResourceLocation key = getItemKey(item);
        return ResourceLocation.fromNamespaceAndPath(key.getNamespace(), "item/" + key.getPath());
    }

    private static ResourceLocation inHandModelKey(Item item) {
        ResourceLocation key = getItemKey(item);
        return ResourceLocation.fromNamespaceAndPath(key.getNamespace(), "item/in_hand/" + key.getPath());
    }

    private static ResourceLocation getItemKey(Item item) {
        return BuiltInRegistries.ITEM.getKey(item);
    }
}
