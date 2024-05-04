package net.xstopho.resource_cracker.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.xstopho.resource_cracker.CrackerConstants;
import net.xstopho.resource_cracker.block.GarlicCropBlock;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resourcelibrary.registration.RegistryObject;

import java.util.function.Function;

public class BlockStateProv extends BlockStateProvider {

    public BlockStateProv(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CrackerConstants.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        createTrivialCube(BlockRegistry.STEEL_BLOCK);
        createGarlicCrop((CropBlock) BlockRegistry.GARLIC_CROP.get(), "garlic_crop_stage", "garlic_crop_stage");

        simpleBlock(BlockRegistry.LAVA_SPRING_BLOCK.get(), createFurnaceModel("lava_spring_block", "spring_side", "spring_side"));
        simpleBlock(BlockRegistry.WATER_SPRING_BLOCK.get(), createFurnaceModel("water_spring_block", "spring_side", "spring_side"));
    }

    private void createGarlicCrop(CropBlock cropBlock, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> cropStates(state, cropBlock, modelName, textureName);

        getVariantBuilder(cropBlock).forAllStates(function);
    }

    private ConfiguredModel[] cropStates(BlockState state, CropBlock cropBlock, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((GarlicCropBlock) cropBlock).getAgeProperty()),
                new ResourceLocation(CrackerConstants.MOD_ID, "block/" + textureName + state.getValue(((GarlicCropBlock) cropBlock).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void createTrivialCube(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }

    private ConfiguredModel[] createFurnaceModel(String modelName, String sideTexture, String topTexture) {
        ConfiguredModel[] model = new ConfiguredModel[1];
        model[0] = new ConfiguredModel(models().orientable(modelName, loc(sideTexture), loc(modelName + "_front"),
                loc(topTexture)).renderType("solid"));
        return model;
    }

    private ResourceLocation loc(String id) {
        return new ResourceLocation(CrackerConstants.MOD_ID, "block/" + id);
    }
}
