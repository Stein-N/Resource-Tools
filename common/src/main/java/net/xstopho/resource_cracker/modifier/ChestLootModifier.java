package net.xstopho.resource_cracker.modifier;

import net.xstopho.resource_cracker.config.CrackerConfig;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import net.xstopho.resourcelibrary.modifier.LootTableModifier;
import net.xstopho.resourcelibrary.modifier.loot_tables.ChestLootTables;

public class ChestLootModifier {

    public static void init(LootTableModifier modifier) {
        modifier.addItems(ItemRegistry.MATERIAL_DUST_SULFUR, 6f, CrackerConfig.SULFUR.get().floatValue(),
                ChestLootTables.RUINED_PORTAL, ChestLootTables.BASTION_OTHER, ChestLootTables.BASTION_BRIDGE, ChestLootTables.NETHER_BRIDGE,
                ChestLootTables.VILLAGE_DESERT_HOUSE);

        modifier.addItems(ItemRegistry.MATERIAL_DUST_SALTPETER, 1f, 6f, CrackerConfig.SALTPETER.get().floatValue(),
                ChestLootTables.RUINED_PORTAL, ChestLootTables.BASTION_OTHER, ChestLootTables.BASTION_BRIDGE, ChestLootTables.NETHER_BRIDGE,
                ChestLootTables.DESERT_PYRAMID, ChestLootTables.VILLAGE_DESERT_HOUSE);

        modifier.addItems(ItemRegistry.MATERIAL_DUST_COPPER, 1f, 6f, CrackerConfig.DUST_COPPER.get().floatValue(),
                ChestLootTables.VILLAGE_ARMORER, ChestLootTables.VILLAGE_TOOLSMITH, ChestLootTables.VILLAGE_WEAPONSMITH, ChestLootTables.ABANDONED_MINESHAFT);

        modifier.addItems(ItemRegistry.MATERIAL_DUST_GOLD, 1f, 6f, CrackerConfig.DUST_COPPER.get().floatValue(),
                ChestLootTables.VILLAGE_ARMORER, ChestLootTables.VILLAGE_TOOLSMITH, ChestLootTables.VILLAGE_WEAPONSMITH, ChestLootTables.ABANDONED_MINESHAFT);

        modifier.addItems(ItemRegistry.MATERIAL_DUST_IRON, 1f, 6f, CrackerConfig.DUST_COPPER.get().floatValue(),
                ChestLootTables.VILLAGE_ARMORER, ChestLootTables.VILLAGE_TOOLSMITH, ChestLootTables.VILLAGE_WEAPONSMITH, ChestLootTables.ABANDONED_MINESHAFT);

        modifier.addItems(ItemRegistry.MATERIAL_DUST_EMERALD, 1f, 3f, CrackerConfig.DUST_EMERALD.get().floatValue(),
                ChestLootTables.SHIPWRECK_TREASURE, ChestLootTables.ABANDONED_MINESHAFT);

        modifier.addItems(ItemRegistry.MATERIAL_DUST_DIAMOND, 1f, 3, CrackerConfig.DUST_DIAMOND.get().floatValue(),
                ChestLootTables.SHIPWRECK_TREASURE, ChestLootTables.ABANDONED_MINESHAFT);

        modifier.addItems(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP, 1f, 2f, CrackerConfig.DUST_NETHERITE_SCRAP.get().floatValue(),
                ChestLootTables.RUINED_PORTAL, ChestLootTables.BASTION_OTHER, ChestLootTables.BASTION_BRIDGE, ChestLootTables.NETHER_BRIDGE,
                ChestLootTables.ANCIENT_CITY, ChestLootTables.ANCIENT_CITY_ICE_BOX);

        modifier.addItems(ItemRegistry.MATERIAL_DUST_NETHERITE, 1f, 2f, CrackerConfig.DUST_NETHERITE.get().floatValue(),
                ChestLootTables.RUINED_PORTAL, ChestLootTables.BASTION_OTHER, ChestLootTables.BASTION_BRIDGE, ChestLootTables.NETHER_BRIDGE,
                ChestLootTables.ANCIENT_CITY, ChestLootTables.ANCIENT_CITY_ICE_BOX);

        modifier.addItems(ItemRegistry.NUGGET_DIAMOND, 1f, 4f, CrackerConfig.NUGGET_DIAMOND.get().floatValue(),
                ChestLootTables.DESERT_PYRAMID, ChestLootTables.SHIPWRECK_TREASURE, ChestLootTables.ABANDONED_MINESHAFT,
                ChestLootTables.ANCIENT_CITY, ChestLootTables.ANCIENT_CITY_ICE_BOX);

        modifier.addItems(ItemRegistry.NUGGET_EMERALD, 1f, 4f, CrackerConfig.NUGGET_EMERALD.get().floatValue(),
                ChestLootTables.DESERT_PYRAMID, ChestLootTables.SHIPWRECK_TREASURE, ChestLootTables.ABANDONED_MINESHAFT,
                ChestLootTables.ANCIENT_CITY, ChestLootTables.ANCIENT_CITY_ICE_BOX);

        modifier.addItems(ItemRegistry.NUGGET_COPPER, 1f, 9f, CrackerConfig.NUGGET_COPPER.get().floatValue(),
                ChestLootTables.ABANDONED_MINESHAFT, ChestLootTables.BASTION_BRIDGE, ChestLootTables.BASTION_OTHER,
                ChestLootTables.DESERT_PYRAMID, ChestLootTables.PILLAGER_OUTPOST, ChestLootTables.RUINED_PORTAL,
                ChestLootTables.VILLAGE_TOOLSMITH);

        modifier.addItems(ItemRegistry.GARLIC, 1f, 6f, CrackerConfig.GARLIC.get().floatValue(),
                ChestLootTables.SPAWN_BONUS_CHEST, ChestLootTables.ABANDONED_MINESHAFT);

        modifier.addItems(ItemRegistry.CRACK_HAMMER_COPPER, 1f, CrackerConfig.HAMMER_COPPER.get().floatValue(),
                ChestLootTables.SPAWN_BONUS_CHEST);

        modifier.addItems(ItemRegistry.CRACK_HAMMER_IRON, 1f, CrackerConfig.HAMMER_IRON.get().floatValue(),
                ChestLootTables.SPAWN_BONUS_CHEST, ChestLootTables.VILLAGE_ARMORER, ChestLootTables.VILLAGE_TOOLSMITH, ChestLootTables.VILLAGE_WEAPONSMITH);

        modifier.addItems(ItemRegistry.CRACK_HAMMER_STEEL, 1f, CrackerConfig.HAMMER_STEEL.get().floatValue(),
                ChestLootTables.VILLAGE_ARMORER, ChestLootTables.VILLAGE_TOOLSMITH, ChestLootTables.VILLAGE_WEAPONSMITH);
    }
}