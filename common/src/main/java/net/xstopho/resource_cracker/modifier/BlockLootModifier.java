package net.xstopho.resource_cracker.modifier;

import net.minecraft.world.level.block.Blocks;
import net.xstopho.resource_cracker.config.LootConfig;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import net.xstopho.resourcelibrary.modifier.LootTableModifier;

import java.util.function.Supplier;

public class BlockLootModifier {

    private static final Supplier<Float> diamondNuggetFromDiamondOre = () -> LootConfig.diamondNuggetFromDiamondOre;
    private static final Supplier<Float> diamondNuggetFromCoalOre = () -> LootConfig.diamondNuggetFromCoalOre;
    private static final Supplier<Float> emeraldNuggetFromOre = () -> LootConfig.emeraldNuggetFromOre;
    private static final Supplier<Float> copperNuggetFromOre = () -> LootConfig.copperNuggetFromOre;

    public static void init(LootTableModifier modifier) {
        modifier.addItems(ItemRegistry.NUGGET_DIAMOND, 1f, 3f, diamondNuggetFromDiamondOre.get(),
                Blocks.DIAMOND_ORE.getLootTable(), Blocks.DEEPSLATE_DIAMOND_ORE.getLootTable());

        modifier.addItems(ItemRegistry.NUGGET_DIAMOND, 1f, diamondNuggetFromCoalOre.get(),
                Blocks.COAL_ORE.getLootTable(), Blocks.DEEPSLATE_COAL_ORE.getLootTable());

        modifier.addItems(ItemRegistry.NUGGET_EMERALD, 1f, 4f, emeraldNuggetFromOre.get(),
                Blocks.EMERALD_ORE.getLootTable(), Blocks.DEEPSLATE_EMERALD_ORE.getLootTable());

        modifier.addItems(ItemRegistry.NUGGET_COPPER, 1f, 6f, copperNuggetFromOre.get(),
                Blocks.COPPER_ORE.getLootTable(), Blocks.DEEPSLATE_COPPER_ORE.getLootTable());
    }
}