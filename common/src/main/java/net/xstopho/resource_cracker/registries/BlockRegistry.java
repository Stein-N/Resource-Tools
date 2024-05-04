package net.xstopho.resource_cracker.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.xstopho.resource_cracker.CrackerConstants;
import net.xstopho.resource_cracker.block.GarlicCropBlock;
import net.xstopho.resourcelibrary.registration.RegistryObject;
import net.xstopho.resourcelibrary.registration.RegistryProvider;

import java.util.function.Supplier;

public class BlockRegistry {

    public static final RegistryProvider<Block> BLOCKS = RegistryProvider.get(Registries.BLOCK, CrackerConstants.MOD_ID);

    public static final RegistryObject<Block> GARLIC_CROP = BLOCKS.register("garlic_crop", () -> new GarlicCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POTATOES)));

    private static RegistryObject<Block> register(String id, Supplier<Block> block) {
        RegistryObject<Block> toReturn = BLOCKS.register(id, block);
        ItemRegistry.ITEMS.register(id, () -> new BlockItem(toReturn.get(), new Item.Properties()));
        return toReturn;
    }

    public static void init() {}
}
