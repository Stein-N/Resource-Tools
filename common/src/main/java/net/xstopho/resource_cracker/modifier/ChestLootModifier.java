package net.xstopho.resource_cracker.modifier;

import net.xstopho.resource_cracker.config.LootConfig;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import net.xstopho.resourcelibrary.modifier.LootTableModifier;
import net.xstopho.resourcelibrary.modifier.loot_tables.ChestLootTables;

import java.util.function.Supplier;

public class ChestLootModifier {

    private static final Supplier<Float> sulfur = () -> LootConfig.sulfur;
    private static final Supplier<Float> saltpeter = () -> LootConfig.saltpeter;
    private static final Supplier<Float> copperDust = () -> LootConfig.copperDust;
    private static final Supplier<Float> copperNugget = () -> LootConfig.copperNugget;
    private static final Supplier<Float> copperHammer = () -> LootConfig.copperHammer;
    private static final Supplier<Float> goldDust = () -> LootConfig.goldDust;
    private static final Supplier<Float> ironDust = () -> LootConfig.ironDust;
    private static final Supplier<Float> ironHammer = () -> LootConfig.ironHammer;
    private static final Supplier<Float> steelHammer = () -> LootConfig.steelHammer;
    private static final Supplier<Float> steelIngot = () -> LootConfig.steelIngot;
    private static final Supplier<Float> steelDust = () -> LootConfig.steelDust;
    private static final Supplier<Float> emeraldDust = () -> LootConfig.emeraldDust;
    private static final Supplier<Float> emeraldNugget = () -> LootConfig.emeraldNugget;
    private static final Supplier<Float> diamondDust = () -> LootConfig.diamondDust;
    private static final Supplier<Float> diamondNugget = () -> LootConfig.diamondNugget;
    private static final Supplier<Float> netheriteScrapDust = () -> LootConfig.netheriteScrapDust;
    private static final Supplier<Float> netheriteDust = () -> LootConfig.netheriteDust;
    private static final Supplier<Float> garlic = () -> LootConfig.garlic;

    public static void init(LootTableModifier modifier) {
        modifier.addItems(ItemRegistry.MATERIAL_DUST_SULFUR, 6f, sulfur.get(),
                ChestLootTables.RUINED_PORTAL,
                ChestLootTables.BASTION_OTHER,
                ChestLootTables.BASTION_BRIDGE,
                ChestLootTables.NETHER_BRIDGE,
                ChestLootTables.VILLAGE_DESERT_HOUSE);

        modifier.addItems(ItemRegistry.MATERIAL_DUST_SALTPETER, 1f, 6f, saltpeter.get(),
                ChestLootTables.RUINED_PORTAL,
                ChestLootTables.BASTION_OTHER,
                ChestLootTables.BASTION_BRIDGE,
                ChestLootTables.NETHER_BRIDGE,
                ChestLootTables.DESERT_PYRAMID,
                ChestLootTables.VILLAGE_DESERT_HOUSE);

        modifier.addItems(ItemRegistry.MATERIAL_DUST_COPPER, 1f, 6f, copperDust.get(),
                ChestLootTables.VILLAGE_ARMORER,
                ChestLootTables.VILLAGE_TOOLSMITH,
                ChestLootTables.VILLAGE_WEAPONSMITH,
                ChestLootTables.ABANDONED_MINESHAFT);

        modifier.addItems(ItemRegistry.MATERIAL_DUST_GOLD, 1f, 6f, goldDust.get(),
                ChestLootTables.VILLAGE_ARMORER,
                ChestLootTables.VILLAGE_TOOLSMITH,
                ChestLootTables.VILLAGE_WEAPONSMITH,
                ChestLootTables.ABANDONED_MINESHAFT);

        modifier.addItems(ItemRegistry.MATERIAL_DUST_IRON, 1f, 6f, ironDust.get(),
                ChestLootTables.VILLAGE_ARMORER,
                ChestLootTables.VILLAGE_TOOLSMITH,
                ChestLootTables.VILLAGE_WEAPONSMITH,
                ChestLootTables.ABANDONED_MINESHAFT);

        modifier.addItems(ItemRegistry.MATERIAL_DUST_EMERALD, 1f, 3f, emeraldDust.get(),
                ChestLootTables.SHIPWRECK_TREASURE,
                ChestLootTables.ABANDONED_MINESHAFT);

        modifier.addItems(ItemRegistry.MATERIAL_DUST_DIAMOND, 1f, 3, diamondDust.get(),
                ChestLootTables.SHIPWRECK_TREASURE,
                ChestLootTables.ABANDONED_MINESHAFT);

        modifier.addItems(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP, 1f, 2f, netheriteScrapDust.get(),
                ChestLootTables.RUINED_PORTAL,
                ChestLootTables.BASTION_OTHER,
                ChestLootTables.BASTION_BRIDGE,
                ChestLootTables.NETHER_BRIDGE,
                ChestLootTables.ANCIENT_CITY,
                ChestLootTables.ANCIENT_CITY_ICE_BOX);

        modifier.addItems(ItemRegistry.MATERIAL_DUST_NETHERITE, 1f, 2f, netheriteDust.get(),
                ChestLootTables.RUINED_PORTAL,
                ChestLootTables.BASTION_OTHER,
                ChestLootTables.BASTION_BRIDGE,
                ChestLootTables.NETHER_BRIDGE,
                ChestLootTables.ANCIENT_CITY,
                ChestLootTables.ANCIENT_CITY_ICE_BOX);

        modifier.addItems(ItemRegistry.NUGGET_DIAMOND, 1f, 4f, diamondNugget.get(),
                ChestLootTables.DESERT_PYRAMID,
                ChestLootTables.SHIPWRECK_TREASURE,
                ChestLootTables.ABANDONED_MINESHAFT,
                ChestLootTables.ANCIENT_CITY,
                ChestLootTables.ANCIENT_CITY_ICE_BOX);

        modifier.addItems(ItemRegistry.NUGGET_EMERALD, 1f, 4f, emeraldNugget.get(),
                ChestLootTables.DESERT_PYRAMID,
                ChestLootTables.SHIPWRECK_TREASURE,
                ChestLootTables.ABANDONED_MINESHAFT,
                ChestLootTables.ANCIENT_CITY,
                ChestLootTables.ANCIENT_CITY_ICE_BOX);

        modifier.addItems(ItemRegistry.NUGGET_COPPER, 1f, 9f, copperNugget.get(),
                ChestLootTables.ABANDONED_MINESHAFT,
                ChestLootTables.BASTION_BRIDGE,
                ChestLootTables.BASTION_OTHER,
                ChestLootTables.DESERT_PYRAMID,
                ChestLootTables.PILLAGER_OUTPOST,
                ChestLootTables.RUINED_PORTAL,
                ChestLootTables.VILLAGE_TOOLSMITH);

        modifier.addItems(ItemRegistry.GARLIC, 1f, 6f, garlic.get(),
                ChestLootTables.SPAWN_BONUS_CHEST,
                ChestLootTables.ABANDONED_MINESHAFT);

        modifier.addItems(ItemRegistry.CRACK_HAMMER_COPPER, 1f, copperHammer.get(),
                ChestLootTables.SPAWN_BONUS_CHEST);

        modifier.addItems(ItemRegistry.CRACK_HAMMER_IRON, 1f, ironHammer.get(),
                ChestLootTables.SPAWN_BONUS_CHEST,
                ChestLootTables.VILLAGE_ARMORER,
                ChestLootTables.VILLAGE_TOOLSMITH,
                ChestLootTables.VILLAGE_WEAPONSMITH);

        modifier.addItems(ItemRegistry.CRACK_HAMMER_STEEL, 1f, steelHammer.get(),
                ChestLootTables.VILLAGE_ARMORER,
                ChestLootTables.VILLAGE_TOOLSMITH,
                ChestLootTables.VILLAGE_WEAPONSMITH);

        modifier.addItems(ItemRegistry.STEEL_INGOT, 1f, 2f, steelIngot.get(),
                ChestLootTables.ABANDONED_MINESHAFT,
                ChestLootTables.VILLAGE_ARMORER,
                ChestLootTables.VILLAGE_TOOLSMITH,
                ChestLootTables.VILLAGE_WEAPONSMITH);

        modifier.addItems(ItemRegistry.MATERIAL_DUST_STEEL, 1f, 2f, steelDust.get(),
                ChestLootTables.ABANDONED_MINESHAFT,
                ChestLootTables.VILLAGE_ARMORER,
                ChestLootTables.VILLAGE_TOOLSMITH,
                ChestLootTables.VILLAGE_WEAPONSMITH);
    }
}