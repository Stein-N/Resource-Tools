package net.xstopho.resource_cracker.modifier;

import net.minecraft.world.level.block.Blocks;
import net.xstopho.resource_cracker.config.CrackerConfig;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import net.xstopho.resourcelibrary.modifier.LootTableModifier;

public class BlockLootModifier {

    public static void init(LootTableModifier modifier) {
        modifier.addItems(ItemRegistry.NUGGET_DIAMOND, 1f, 3f, CrackerConfig.DIAMOND_NUGGET_FROM_DIAMOND_ORE.get().floatValue(),
                Blocks.DIAMOND_ORE.getLootTable().get(), Blocks.DEEPSLATE_DIAMOND_ORE.getLootTable().get());

        modifier.addItems(ItemRegistry.NUGGET_DIAMOND, 1f, CrackerConfig.DIAMOND_NUGGET_FROM_COAL_ORE.get().floatValue(),
                Blocks.COAL_ORE.getLootTable().get(), Blocks.DEEPSLATE_COAL_ORE.getLootTable().get());

        modifier.addItems(ItemRegistry.NUGGET_EMERALD, 1f, 4f, CrackerConfig.EMERALD_NUGGET_FROM_ORE.get().floatValue(),
                Blocks.EMERALD_ORE.getLootTable().get(), Blocks.DEEPSLATE_EMERALD_ORE.getLootTable().get());

        modifier.addItems(ItemRegistry.NUGGET_COPPER, 1f, 6f, CrackerConfig.COPPER_NUGGET_FROM_ORE.get().floatValue(),
                Blocks.COPPER_ORE.getLootTable().get(), Blocks.DEEPSLATE_COPPER_ORE.getLootTable().get());
    }
}