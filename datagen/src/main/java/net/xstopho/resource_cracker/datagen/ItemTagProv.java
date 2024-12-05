package net.xstopho.resource_cracker.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.xstopho.resource_cracker.item.tags.CrackerItemTags;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;

import java.util.concurrent.CompletableFuture;

public class ItemTagProv extends FabricTagProvider.ItemTagProvider {
    public ItemTagProv(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        getOrCreateTagBuilder(CrackerItemTags.CRACK_HAMMER)
                .add(ItemRegistry.CRACK_HAMMER_COPPER.get(), ItemRegistry.CRACK_HAMMER_GOLD.get(), ItemRegistry.CRACK_HAMMER_IRON.get(),
                        ItemRegistry.CRACK_HAMMER_STEEL.get(), ItemRegistry.CRACK_HAMMER_DIAMOND.get(), ItemRegistry.CRACK_HAMMER_NETHERITE.get());

        getOrCreateTagBuilder(CrackerItemTags.CHISEL)
                .add(ItemRegistry.CHISEL_COPPER.get(), ItemRegistry.CHISEL_GOLD.get(), ItemRegistry.CHISEL_IRON.get(),
                        ItemRegistry.CHISEL_STEEL.get(), ItemRegistry.CHISEL_DIAMOND.get(), ItemRegistry.CHISEL_NETHERITE.get());

        getOrCreateTagBuilder(CrackerItemTags.SCYTHE)
                .add(ItemRegistry.SCYTHE_COPPER.get(), ItemRegistry.SCYTHE_GOLD.get(), ItemRegistry.SCYTHE_IRON.get(),
                        ItemRegistry.SCYTHE_STEEL.get(), ItemRegistry.SCYTHE_DIAMOND.get(), ItemRegistry.SCYTHE_NETHERITE.get());

        getOrCreateTagBuilder(CrackerItemTags.CRACK_HAMMER_INGREDIENTS)
                .add(Items.STRING, Items.LEATHER, Items.RABBIT_HIDE);

        getOrCreateTagBuilder(CrackerItemTags.SCYTHE_INGREDIENTS)
                .add(Items.LEATHER, Items.RABBIT_HIDE);

        getOrCreateTagBuilder(CrackerItemTags.COAL_DUSTS).add(ItemRegistry.MATERIAL_DUST_CARBON.get());
        getOrCreateTagBuilder(CrackerItemTags.CARBON_DUSTS).add(ItemRegistry.MATERIAL_DUST_CARBON.get());
        getOrCreateTagBuilder(CrackerItemTags.COPPER_DUSTS).add(ItemRegistry.MATERIAL_DUST_COPPER.get());
        getOrCreateTagBuilder(CrackerItemTags.IRON_DUSTS).add(ItemRegistry.MATERIAL_DUST_IRON.get());

        getOrCreateTagBuilder(CrackerItemTags.GOLD_DUSTS).add(ItemRegistry.MATERIAL_DUST_GOLD.get());
        getOrCreateTagBuilder(CrackerItemTags.DIAMOND_DUSTS).add(ItemRegistry.MATERIAL_DUST_DIAMOND.get());
        getOrCreateTagBuilder(CrackerItemTags.EMERALD_DUSTS).add(ItemRegistry.MATERIAL_DUST_EMERALD.get());
        getOrCreateTagBuilder(CrackerItemTags.SULFUR_DUSTS).add(ItemRegistry.MATERIAL_DUST_SULFUR.get());

        getOrCreateTagBuilder(CrackerItemTags.SALTPETER_DUSTS).add(ItemRegistry.MATERIAL_DUST_SALTPETER.get());
        getOrCreateTagBuilder(CrackerItemTags.STEEL_DUSTS).add(ItemRegistry.MATERIAL_DUST_STEEL.get());
        getOrCreateTagBuilder(CrackerItemTags.NETHERITE_SCRAP_DUSTS).add(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP.get());
        getOrCreateTagBuilder(CrackerItemTags.NETHERITE_DUSTS).add(ItemRegistry.MATERIAL_DUST_NETHERITE.get());

        getOrCreateTagBuilder(CrackerItemTags.DIAMOND_NUGGETS).add(ItemRegistry.NUGGET_DIAMOND.get());
        getOrCreateTagBuilder(CrackerItemTags.EMERALD_NUGGETS).add(ItemRegistry.NUGGET_EMERALD.get());
        getOrCreateTagBuilder(CrackerItemTags.COPPER_NUGGETS).add(ItemRegistry.NUGGET_COPPER.get());
        getOrCreateTagBuilder(CrackerItemTags.STEEL_INGOTS).add(ItemRegistry.STEEL_INGOT.get());
        getOrCreateTagBuilder(CrackerItemTags.COPPER_INGOTS).add(Items.COPPER_INGOT);

        getOrCreateTagBuilder(CrackerItemTags.STEEL_BLOCKS).add(BlockRegistry.STEEL_BLOCK.get().asItem());

        getOrCreateTagBuilder(CrackerItemTags.COPPER_TOOL_MATERIALS).addTag(CrackerItemTags.COPPER_INGOTS);
        getOrCreateTagBuilder(CrackerItemTags.STEEL_TOOL_MATERIALS).addTag(CrackerItemTags.STEEL_INGOTS);

        getOrCreateTagBuilder(CrackerItemTags.DUSTS)
                .addTag(CrackerItemTags.COAL_DUSTS)
                .addTag(CrackerItemTags.CARBON_DUSTS)
                .addTag(CrackerItemTags.COPPER_DUSTS)
                .addTag(CrackerItemTags.IRON_DUSTS)
                .addTag(CrackerItemTags.GOLD_DUSTS)
                .addTag(CrackerItemTags.DIAMOND_DUSTS)
                .addTag(CrackerItemTags.EMERALD_DUSTS)
                .addTag(CrackerItemTags.SULFUR_DUSTS)
                .addTag(CrackerItemTags.SALTPETER_DUSTS)
                .addTag(CrackerItemTags.STEEL_DUSTS)
                .addTag(CrackerItemTags.NETHERITE_SCRAP_DUSTS)
                .addTag(CrackerItemTags.NETHERITE_DUSTS);

        getOrCreateTagBuilder(CrackerItemTags.NUGGETS)
                .addTag(CrackerItemTags.DIAMOND_NUGGETS)
                .addTag(CrackerItemTags.EMERALD_NUGGETS)
                .addTag(CrackerItemTags.COPPER_NUGGETS);

        getOrCreateTagBuilder(CrackerItemTags.INGOTS).add(ItemRegistry.STEEL_INGOT.get());
        getOrCreateTagBuilder(CrackerItemTags.GARLIC).add(ItemRegistry.GARLIC.get());
        getOrCreateTagBuilder(CrackerItemTags.BEEF_JERKY).add(ItemRegistry.BEEF_JERKY.get());
        getOrCreateTagBuilder(CrackerItemTags.FOODS).add(ItemRegistry.GARLIC.get(), ItemRegistry.BEEF_JERKY.get());

        getOrCreateTagBuilder(CrackerItemTags.TOOLS)
                .addTag(CrackerItemTags.CRACK_HAMMER)
                .addTag(CrackerItemTags.CHISEL)
                .addTag(CrackerItemTags.SCYTHE);

        getOrCreateTagBuilder(CrackerItemTags.ENCHANTABLES).addTag(CrackerItemTags.SCYTHE);

        getOrCreateTagBuilder(ItemTags.WEAPON_ENCHANTABLE).addTag(CrackerItemTags.SCYTHE);
        getOrCreateTagBuilder(ItemTags.SHARP_WEAPON_ENCHANTABLE).addTag(CrackerItemTags.SCYTHE);

        getOrCreateTagBuilder(ItemTags.VILLAGER_PLANTABLE_SEEDS).add(ItemRegistry.GARLIC.get());

        getOrCreateTagBuilder(ItemTags.BREAKS_DECORATED_POTS)
                .addTag(CrackerItemTags.SCYTHE)
                .addTag(CrackerItemTags.CHISEL)
                .addTag(CrackerItemTags.CRACK_HAMMER);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .addTag(CrackerItemTags.SCYTHE);
    }
}
