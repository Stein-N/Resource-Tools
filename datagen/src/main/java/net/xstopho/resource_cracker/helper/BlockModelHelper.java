package net.xstopho.resource_cracker.helper;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.blockstates.Variant;
import net.minecraft.client.data.models.blockstates.VariantProperties;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.xstopho.resource_cracker.CrackerConstants;

import java.util.Optional;

public class BlockModelHelper {
    public static void createSpringBlock(BlockModelGenerators generator, Block block, ResourceLocation fluid) {
        TextureMapping map = new TextureMapping();

        map.put(TextureSlot.INSIDE, fluid);

        ResourceLocation model = new ModelTemplate(Optional.of(CrackerConstants.of("block/spring_block")), Optional.empty(), TextureSlot.INSIDE)
                                    .create(block, map, generator.modelOutput);
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
}
