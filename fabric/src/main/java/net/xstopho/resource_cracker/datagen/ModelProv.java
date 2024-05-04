package net.xstopho.resource_cracker.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.xstopho.resource_cracker.CrackerConstants;
import net.xstopho.resource_cracker.block.GarlicCropBlock;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;

import java.util.Optional;

public class ModelProv extends FabricModelProvider {
    public ModelProv(FabricDataOutput output) {
        super(output);
    }

    private BlockModelGenerators generators;

    @Override
    public void generateBlockStateModels(BlockModelGenerators block) {
    generators = block;

        block.createCropBlock(BlockRegistry.GARLIC_CROP.get(), GarlicCropBlock.AGE, 0, 1, 2, 3, 4, 5);
        block.createTrivialCube(BlockRegistry.STEEL_BLOCK.get());

        createFurnaceLikeBlock(BlockRegistry.LAVA_SPRING_BLOCK.get(), "lava_spring_block", "spring_side", "spring_side");
        createFurnaceLikeBlock(BlockRegistry.WATER_SPRING_BLOCK.get(), "water_spring_block", "spring_side", "spring_side");
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
    }

    private void createFurnaceLikeBlock(Block block, String modelName, String sideTexture, String topTexture) {
        TextureMapping map = new TextureMapping();
        Optional<ResourceLocation> parent = Optional.of(new ResourceLocation("block/orientable"));

        map.put(TextureSlot.FRONT, blockLoc(modelName + "_front"));
        map.put(TextureSlot.SIDE, blockLoc(sideTexture));
        map.put(TextureSlot.TOP, blockLoc(topTexture));

        ResourceLocation model = new ModelTemplate(parent, Optional.empty(), TextureSlot.FRONT, TextureSlot.SIDE, TextureSlot.TOP)
                .create(blockLoc(modelName), map, generators.modelOutput);
        generators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, model));
    }

    private ResourceLocation blockLoc(String id) {
        return new ResourceLocation(CrackerConstants.MOD_ID, "block/" + id);
    }
}
