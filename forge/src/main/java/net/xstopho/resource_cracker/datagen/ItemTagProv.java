package net.xstopho.resource_cracker.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.xstopho.resource_cracker.Constants;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ItemTagProv extends ItemTagsProvider {


    public ItemTagProv(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, Constants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModItemTags.CRACK_HAMMER)
                .add(ItemRegistry.CRACK_HAMMER_COPPER.get(), ItemRegistry.CRACK_HAMMER_GOLD.get(), ItemRegistry.CRACK_HAMMER_IRON.get(),
                        ItemRegistry.CRACK_HAMMER_STEEL.get(), ItemRegistry.CRACK_HAMMER_DIAMOND.get(), ItemRegistry.CRACK_HAMMER_NETHERITE.get());

        this.tag(ModItemTags.CHISEL)
                .add(ItemRegistry.CHISEL_COPPER.get(), ItemRegistry.CHISEL_GOLD.get(), ItemRegistry.CHISEL_IRON.get(),
                        ItemRegistry.CHISEL_STEEL.get(), ItemRegistry.CHISEL_DIAMOND.get(), ItemRegistry.CHISEL_NETHERITE.get());

        this.tag(ModItemTags.SCYTHE)
                .add(ItemRegistry.SCYTHE_COPPER.get(), ItemRegistry.SCYTHE_GOLD.get(), ItemRegistry.SCYTHE_IRON.get(),
                        ItemRegistry.SCYTHE_STEEL.get(), ItemRegistry.SCYTHE_DIAMOND.get(), ItemRegistry.SCYTHE_NETHERITE.get());

        this.tag(ModItemTags.CRAFTING_INGREDIENTS)
                .add(Items.STRING, Items.LEATHER, Items.RABBIT_HIDE);

        this.tag(ModItemTags.COAL_DUSTS).add(ItemRegistry.MATERIAL_DUST_CARBON.get());
        this.tag(ModItemTags.CARBON_DUSTS).add(ItemRegistry.MATERIAL_DUST_CARBON.get());
        this.tag(ModItemTags.COPPER_DUSTS).add(ItemRegistry.MATERIAL_DUST_COPPER.get());
        this.tag(ModItemTags.IRON_DUSTS).add(ItemRegistry.MATERIAL_DUST_IRON.get());

        this.tag(ModItemTags.GOLD_DUSTS).add(ItemRegistry.MATERIAL_DUST_GOLD.get());
        this.tag(ModItemTags.DIAMOND_DUSTS).add(ItemRegistry.MATERIAL_DUST_DIAMOND.get());
        this.tag(ModItemTags.EMERALD_DUSTS).add(ItemRegistry.MATERIAL_DUST_EMERALD.get());
        this.tag(ModItemTags.SULFUR_DUSTS).add(ItemRegistry.MATERIAL_DUST_SULFUR.get());

        this.tag(ModItemTags.SALTPETER_DUSTS).add(ItemRegistry.MATERIAL_DUST_SALTPETER.get());
        this.tag(ModItemTags.STEEL_DUSTS).add(ItemRegistry.MATERIAL_DUST_STEEL.get());
        this.tag(ModItemTags.NETHERITE_SCRAP_DUSTS).add(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP.get());
        this.tag(ModItemTags.NETHERITE_DUSTS).add(ItemRegistry.MATERIAL_DUST_NETHERITE.get());

        this.tag(ModItemTags.DIAMOND_NUGGETS).add(ItemRegistry.NUGGET_DIAMOND.get());
        this.tag(ModItemTags.EMERALD_NUGGETS).add(ItemRegistry.NUGGET_EMERALD.get());
        this.tag(ModItemTags.COPPER_NUGGETS).add(ItemRegistry.NUGGET_COPPER.get());
        this.tag(ModItemTags.STEEL_INGOTS).add(ItemRegistry.STEEL_INGOT.get());

        this.tag(ModItemTags.STEEL_BLOCKS).add(BlockRegistry.STEEL_BLOCK.get().asItem());
    }
}
