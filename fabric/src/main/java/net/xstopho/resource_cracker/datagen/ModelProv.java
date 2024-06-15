package net.xstopho.resource_cracker.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.xstopho.resource_cracker.CrackerConstants;
import net.xstopho.resource_cracker.block.GarlicCropBlock;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import net.xstopho.resourcelibrary.datagen.ResourceModelProvider;

import java.util.Optional;

public class ModelProv extends ResourceModelProvider {
    public ModelProv(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators block) {

        block.createCropBlock(BlockRegistry.GARLIC_CROP.get(), GarlicCropBlock.AGE, 0, 1, 2, 3, 4, 5);
        block.createTrivialCube(BlockRegistry.STEEL_BLOCK.get());

        createHorizontalBlock(block, BlockRegistry.LAVA_SPRING_BLOCK.get());
        createHorizontalBlock(block, BlockRegistry.WATER_SPRING_BLOCK.get());
    }

    @Override
    public void generateItemModels(ItemModelGenerators item) {
        item.generateFlatItem(ItemRegistry.CRACK_HAMMER_COPPER.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.CRACK_HAMMER_GOLD.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.CRACK_HAMMER_IRON.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.CRACK_HAMMER_DIAMOND.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.CRACK_HAMMER_NETHERITE.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.CRACK_HAMMER_STEEL.get(), ModelTemplates.FLAT_ITEM);

        item.generateFlatItem(ItemRegistry.CHISEL_COPPER.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.CHISEL_GOLD.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.CHISEL_IRON.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.CHISEL_DIAMOND.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.CHISEL_NETHERITE.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.CHISEL_STEEL.get(), ModelTemplates.FLAT_ITEM);

        item.generateFlatItem(ItemRegistry.SCYTHE_COPPER.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        item.generateFlatItem(ItemRegistry.SCYTHE_IRON.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        item.generateFlatItem(ItemRegistry.SCYTHE_GOLD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        item.generateFlatItem(ItemRegistry.SCYTHE_STEEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        item.generateFlatItem(ItemRegistry.SCYTHE_DIAMOND.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        item.generateFlatItem(ItemRegistry.SCYTHE_NETHERITE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        item.generateFlatItem(ItemRegistry.MATERIAL_DUST_COPPER.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.MATERIAL_DUST_IRON.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.MATERIAL_DUST_GOLD.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.MATERIAL_DUST_DIAMOND.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.MATERIAL_DUST_STEEL.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.MATERIAL_DUST_CARBON.get(), ModelTemplates.FLAT_ITEM);

        item.generateFlatItem(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.MATERIAL_DUST_NETHERITE.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.MATERIAL_DUST_EMERALD.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.MATERIAL_DUST_SALTPETER.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.MATERIAL_DUST_SULFUR.get(), ModelTemplates.FLAT_ITEM);

        item.generateFlatItem(ItemRegistry.STEEL_INGOT.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.NUGGET_DIAMOND.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.NUGGET_COPPER.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.NUGGET_EMERALD.get(), ModelTemplates.FLAT_ITEM);

        item.generateFlatItem(ItemRegistry.BEEF_JERKY.get(), ModelTemplates.FLAT_ITEM);

        inHandModel(item, ItemRegistry.SCYTHE_COPPER.get());
        inHandModel(item, ItemRegistry.SCYTHE_GOLD.get());
        inHandModel(item, ItemRegistry.SCYTHE_IRON.get());
        inHandModel(item, ItemRegistry.SCYTHE_STEEL.get());
        inHandModel(item, ItemRegistry.SCYTHE_DIAMOND.get());
        inHandModel(item, ItemRegistry.SCYTHE_NETHERITE.get());
    }

    void inHandModel(ItemModelGenerators generators, Item item) {
        createInHandItemModel(generators, item, ResourceLocation.fromNamespaceAndPath(CrackerConstants.MOD_ID, "item/in_hand/handheld_large"));
    }
}
