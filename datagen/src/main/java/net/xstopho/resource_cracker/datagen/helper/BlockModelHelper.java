package net.xstopho.resource_cracker.datagen.helper;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.blockstates.Variant;
import net.minecraft.client.data.models.blockstates.VariantProperties;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class BlockModelHelper {

    public static void createSpringBlock(BlockModelGenerators generator, Block block) {
        TextureMapping map = new TextureMapping();

        map.put(TextureSlot.FRONT, modifyBlockKey(block, ""));
        map.put(TextureSlot.SIDE, modifyBlockKey(block, "_side"));
        map.put(TextureSlot.TOP, modifyBlockKey(block, "_side"));

        ResourceLocation model = ModelTemplates.CUBE_ORIENTABLE.create(block, map, generator.modelOutput);
        generator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block).with(createPropertyDispatch(model)));
    }

    private static PropertyDispatch createPropertyDispatch(ResourceLocation model) {
        return PropertyDispatch.property(BlockStateProperties.HORIZONTAL_FACING)
                .select(Direction.NORTH, Variant.variant()
                        .with(VariantProperties.MODEL, model))
                .select(Direction.EAST, Variant.variant()
                        .with(VariantProperties.MODEL, model)
                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.SOUTH, Variant.variant()
                        .with(VariantProperties.MODEL, model)
                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.WEST, Variant.variant()
                        .with(VariantProperties.MODEL, model)
                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270));
    }

    private static ResourceLocation modifyBlockKey(Block block, String texturePosition) {
        ResourceLocation key = getBlockKey(block);
        return ResourceLocation.fromNamespaceAndPath(key.getNamespace(), "block/" + key.getPath() + texturePosition);
    }

    private static ResourceLocation getBlockKey(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }
}
