package net.xstopho.resource_cracker.modifier;

import net.xstopho.resource_cracker.config.LootConfig;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import net.xstopho.resourcelibrary.modifier.LootTableModifier;
import net.xstopho.resourcelibrary.modifier.loot_tables.EntityLootTables;

import java.util.function.Supplier;

public class EntityLootModifier {

    private static final Supplier<Float> garlicFromZombie = () -> LootConfig.garlicFromZombie;
    private static final Supplier<Float> copperNuggetFromZombie = () -> LootConfig.copperNuggetFromZombie;
    private static final Supplier<Float> sulfurFromCreeper = () -> LootConfig.sulfurFromCreeper;
    private static final Supplier<Float> saltpeterFromCreeper = () -> LootConfig.saltpeterFromCreeper;

    public static void init(LootTableModifier modifier) {
        modifier.addItems(ItemRegistry.GARLIC, 1f, garlicFromZombie.get(), EntityLootTables.ZOMBIE);
        modifier.addItems(ItemRegistry.NUGGET_COPPER, 1f, 4f, copperNuggetFromZombie.get(), EntityLootTables.ZOMBIE);

        modifier.addItems(ItemRegistry.MATERIAL_DUST_SULFUR, 1f, sulfurFromCreeper.get(), EntityLootTables.CREEPER);
        modifier.addItems(ItemRegistry.MATERIAL_DUST_SALTPETER, 1f, saltpeterFromCreeper.get(), EntityLootTables.CREEPER);
    }
}