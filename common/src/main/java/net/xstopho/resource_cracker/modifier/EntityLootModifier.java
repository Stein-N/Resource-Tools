package net.xstopho.resource_cracker.modifier;

import net.xstopho.resource_cracker.config.CrackerConfig;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import net.xstopho.resourcelibrary.modifier.LootTableModifier;
import net.xstopho.resourcelibrary.modifier.loot_tables.EntityLootTables;

public class EntityLootModifier {

    public static void init(LootTableModifier modifier) {
        modifier.addLoot(ItemRegistry.GARLIC, 1f, CrackerConfig.GARLIC_FROM_ZOMBIE.get().floatValue(), EntityLootTables.ZOMBIE);
        modifier.addLoot(ItemRegistry.NUGGET_COPPER, 1f, 4f, CrackerConfig.NUGGET_COPPER.get().floatValue(), EntityLootTables.ZOMBIE);

        modifier.addLoot(ItemRegistry.MATERIAL_DUST_SULFUR, 1f, CrackerConfig.SULFUR_FROM_CREEPER.get().floatValue(), EntityLootTables.CREEPER);
        modifier.addLoot(ItemRegistry.MATERIAL_DUST_SALTPETER, 1f, CrackerConfig.SALTPETER_FROM_CREEPER.get().floatValue(), EntityLootTables.CREEPER);
    }
}