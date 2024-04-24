package net.xstopho.resource_cracker.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Items;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;

import java.util.concurrent.CompletableFuture;

public class ItemTagProv extends FabricTagProvider.ItemTagProvider {
    public ItemTagProv(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        getOrCreateTagBuilder(ModItemTags.CRACK_HAMMER)
                .add(ItemRegistry.CRACK_HAMMER_COPPER.get(), ItemRegistry.CRACK_HAMMER_GOLD.get(), ItemRegistry.CRACK_HAMMER_IRON.get(),
                        ItemRegistry.CRACK_HAMMER_STEEL.get(), ItemRegistry.CRACK_HAMMER_DIAMOND.get(), ItemRegistry.CRACK_HAMMER_NETHERITE.get());

        getOrCreateTagBuilder(ModItemTags.CHISEL)
                .add(ItemRegistry.CHISEL_COPPER.get(), ItemRegistry.CHISEL_GOLD.get(), ItemRegistry.CHISEL_IRON.get(),
                        ItemRegistry.CHISEL_STEEL.get(), ItemRegistry.CHISEL_DIAMOND.get(), ItemRegistry.CHISEL_NETHERITE.get());

        getOrCreateTagBuilder(ModItemTags.SCYTHE)
                .add(ItemRegistry.SCYTHE_COPPER.get(), ItemRegistry.SCYTHE_GOLD.get(), ItemRegistry.SCYTHE_IRON.get(),
                        ItemRegistry.SCYTHE_STEEL.get(), ItemRegistry.SCYTHE_DIAMOND.get(), ItemRegistry.SCYTHE_NETHERITE.get());

        getOrCreateTagBuilder(ModItemTags.CRAFTING_INGREDIENTS)
                .add(Items.STRING, Items.LEATHER, Items.RABBIT_HIDE);

        getOrCreateTagBuilder(ModItemTags.COAL_DUSTS).add(ItemRegistry.MATERIAL_DUST_CARBON.get());
        getOrCreateTagBuilder(ModItemTags.CARBON_DUSTS).add(ItemRegistry.MATERIAL_DUST_CARBON.get());
        getOrCreateTagBuilder(ModItemTags.COPPER_DUSTS).add(ItemRegistry.MATERIAL_DUST_COPPER.get());
        getOrCreateTagBuilder(ModItemTags.IRON_DUSTS).add(ItemRegistry.MATERIAL_DUST_IRON.get());

        getOrCreateTagBuilder(ModItemTags.GOLD_DUSTS).add(ItemRegistry.MATERIAL_DUST_GOLD.get());
        getOrCreateTagBuilder(ModItemTags.DIAMOND_DUSTS).add(ItemRegistry.MATERIAL_DUST_DIAMOND.get());
        getOrCreateTagBuilder(ModItemTags.EMERALD_DUSTS).add(ItemRegistry.MATERIAL_DUST_EMERALD.get());
        getOrCreateTagBuilder(ModItemTags.SULFUR_DUSTS).add(ItemRegistry.MATERIAL_DUST_SULFUR.get());

        getOrCreateTagBuilder(ModItemTags.SALTPETER_DUSTS).add(ItemRegistry.MATERIAL_DUST_SALTPETER.get());
        getOrCreateTagBuilder(ModItemTags.STEEL_DUSTS).add(ItemRegistry.MATERIAL_DUST_STEEL.get());
        getOrCreateTagBuilder(ModItemTags.NETHERITE_SCRAP_DUSTS).add(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP.get());
        getOrCreateTagBuilder(ModItemTags.NETHERITE_DUSTS).add(ItemRegistry.MATERIAL_DUST_NETHERITE.get());

        getOrCreateTagBuilder(ModItemTags.DIAMOND_NUGGETS).add(ItemRegistry.NUGGET_DIAMOND.get());
        getOrCreateTagBuilder(ModItemTags.EMERALD_NUGGETS).add(ItemRegistry.NUGGET_EMERALD.get());
        getOrCreateTagBuilder(ModItemTags.COPPER_NUGGETS).add(ItemRegistry.NUGGET_COPPER.get());
        getOrCreateTagBuilder(ModItemTags.STEEL_INGOTS).add(ItemRegistry.STEEL_INGOT.get());

        getOrCreateTagBuilder(ModItemTags.STEEL_BLOCKS).add(BlockRegistry.STEEL_BLOCK.get().asItem());
    }
}
