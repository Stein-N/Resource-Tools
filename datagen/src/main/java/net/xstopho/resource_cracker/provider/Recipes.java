package net.xstopho.resource_cracker.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Items;
import net.xstopho.resource_cracker.helper.BaseRecipes;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;

import java.util.concurrent.CompletableFuture;

public class Recipes extends BaseRecipes {
    public Recipes(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    public void createRecipes() {
        /////////////
        //  Tools  //
        /////////////
        /* Crack Hammer */
        crackHammerRecipe(ItemRegistry.CRACK_HAMMER_COPPER.get(), Items.COPPER_INGOT);
        crackHammerRecipe(ItemRegistry.CRACK_HAMMER_GOLD.get(), Items.GOLD_INGOT);
        crackHammerRecipe(ItemRegistry.CRACK_HAMMER_IRON.get(), Items.IRON_INGOT);
        crackHammerRecipe(ItemRegistry.CRACK_HAMMER_DIAMOND.get(), Items.DIAMOND);
        crackHammerRecipe(ItemRegistry.CRACK_HAMMER_STEEL.get(), ItemRegistry.STEEL_INGOT.get());
        smithingUpgrade(ItemRegistry.CRACK_HAMMER_NETHERITE.get(), ItemRegistry.CRACK_HAMMER_DIAMOND.get(), Items.NETHERITE_INGOT);

        /*  Chisel  */
        chiselRecipe(ItemRegistry.CHISEL_COPPER.get(), Items.COPPER_INGOT);
        chiselRecipe(ItemRegistry.CHISEL_GOLD.get(), Items.GOLD_INGOT);
        chiselRecipe(ItemRegistry.CHISEL_IRON.get(), Items.IRON_INGOT);
        chiselRecipe(ItemRegistry.CHISEL_DIAMOND.get(), Items.DIAMOND);
        chiselRecipe(ItemRegistry.CHISEL_STEEL.get(), ItemRegistry.STEEL_INGOT.get());
        smithingUpgrade(ItemRegistry.CHISEL_NETHERITE.get(), ItemRegistry.CHISEL_DIAMOND.get(), Items.NETHERITE_INGOT);

        /* Scythe */
        scytheRecipe(ItemRegistry.SCYTHE_COPPER.get(), Items.COPPER_INGOT);
        scytheRecipe(ItemRegistry.SCYTHE_IRON.get(), Items.IRON_INGOT);
        scytheRecipe(ItemRegistry.SCYTHE_GOLD.get(), Items.GOLD_INGOT);
        scytheRecipe(ItemRegistry.SCYTHE_STEEL.get(), ItemRegistry.STEEL_INGOT.get());
        scytheRecipe(ItemRegistry.SCYTHE_DIAMOND.get(), Items.DIAMOND);
        smithingUpgrade(ItemRegistry.SCYTHE_NETHERITE.get(), ItemRegistry.SCYTHE_DIAMOND.get(), Items.NETHERITE_INGOT);

        ////////////////////////
        //   Material Dusts   //
        ////////////////////////
        materialDustRecipe(ItemRegistry.MATERIAL_DUST_CARBON.get(), Items.CHARCOAL, 2);
        materialDustRecipe(ItemRegistry.MATERIAL_DUST_COPPER.get(), Items.RAW_COPPER, 2);
        materialDustRecipe(ItemRegistry.MATERIAL_DUST_IRON.get(), Items.RAW_IRON, 2);
        materialDustRecipe(ItemRegistry.MATERIAL_DUST_GOLD.get(), Items.RAW_GOLD, 2);

        materialDustRecipe(ItemRegistry.MATERIAL_DUST_COPPER.get(), Items.COPPER_INGOT, 1);
        materialDustRecipe(ItemRegistry.MATERIAL_DUST_IRON.get(), Items.IRON_INGOT, 1);
        materialDustRecipe(ItemRegistry.MATERIAL_DUST_GOLD.get(), Items.GOLD_INGOT, 1);
        materialDustRecipe(ItemRegistry.MATERIAL_DUST_STEEL.get(), ItemRegistry.STEEL_INGOT.get(), 1);
        materialDustRecipe(ItemRegistry.MATERIAL_DUST_DIAMOND.get(), Items.DIAMOND, 1);
        materialDustRecipe(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP.get(), Items.NETHERITE_SCRAP, 1);
        materialDustRecipe(ItemRegistry.MATERIAL_DUST_NETHERITE.get(), Items.NETHERITE_INGOT, 1);
        materialDustRecipe(ItemRegistry.MATERIAL_DUST_EMERALD.get(), Items.EMERALD, 1);

        materialDustRecipe(ItemRegistry.MATERIAL_DUST_DIAMOND.get(), Items.DIAMOND_ORE, 2);
        materialDustRecipe(ItemRegistry.MATERIAL_DUST_DIAMOND.get(), Items.DEEPSLATE_DIAMOND_ORE, 2);
        materialDustRecipe(ItemRegistry.MATERIAL_DUST_EMERALD.get(), Items.EMERALD_ORE, 2);
        materialDustRecipe(ItemRegistry.MATERIAL_DUST_EMERALD.get(), Items.DEEPSLATE_EMERALD_ORE, 2);
        materialDustRecipe(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP.get(), Items.ANCIENT_DEBRIS, 2);

        ////////////////
        //   Blocks   //
        ////////////////
        springBlockRecipe(BlockRegistry.WATER_SPRING_BLOCK.get(), Items.WATER_BUCKET);
        springBlockRecipe(BlockRegistry.LAVA_SPRING_BLOCK.get(), Items.LAVA_BUCKET);

        ////////////////
        //  Smelting  //
        ////////////////
        smeltingRecipe(Items.COPPER_INGOT, ItemRegistry.MATERIAL_DUST_COPPER.get());
        smeltingRecipe(Items.IRON_INGOT, ItemRegistry.MATERIAL_DUST_IRON.get());
        smeltingRecipe(Items.GOLD_INGOT, ItemRegistry.MATERIAL_DUST_GOLD.get());
        smeltingRecipe(ItemRegistry.STEEL_INGOT.get(), ItemRegistry.MATERIAL_DUST_STEEL.get());
        smeltingRecipe(ItemRegistry.MATERIAL_DUST_SULFUR.get(), ItemRegistry.GARLIC.get());
        smeltingRecipe(Items.LEATHER, Items.ROTTEN_FLESH);

        ////////////////
        //  Blasting  //
        ////////////////
        blastingRecipe(Items.COPPER_INGOT, ItemRegistry.MATERIAL_DUST_COPPER.get());
        blastingRecipe(Items.IRON_INGOT, ItemRegistry.MATERIAL_DUST_IRON.get());
        blastingRecipe(Items.GOLD_INGOT, ItemRegistry.MATERIAL_DUST_GOLD.get());
        blastingRecipe(Items.DIAMOND, ItemRegistry.MATERIAL_DUST_DIAMOND.get());
        blastingRecipe(Items.EMERALD, ItemRegistry.MATERIAL_DUST_EMERALD.get());
        blastingRecipe(Items.NETHERITE_SCRAP, ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP.get());
        blastingRecipe(Items.NETHERITE_INGOT, ItemRegistry.MATERIAL_DUST_NETHERITE.get());
        blastingRecipe(ItemRegistry.STEEL_INGOT.get(), ItemRegistry.MATERIAL_DUST_STEEL.get());
        blastingRecipe(ItemRegistry.GARLIC.get(), ItemRegistry.MATERIAL_DUST_SULFUR.get());
        blastingRecipe(Items.LEATHER, Items.ROTTEN_FLESH);

        ////////////////
        //  Campfire  //
        ////////////////
        campfireRecipe(ItemRegistry.MATERIAL_DUST_SULFUR.get(), ItemRegistry.GARLIC.get());
        campfireRecipe(Items.LEATHER, Items.ROTTEN_FLESH);

        ///////////////
        //  Smoking  //
        ///////////////
        smokingRecipe(ItemRegistry.BEEF_JERKY.get(), Items.ROTTEN_FLESH);

        ///////////////////
        //  Compressing  //
        ///////////////////
        compressRecipe(BlockRegistry.STEEL_BLOCK.get(), ItemRegistry.STEEL_INGOT.get());
        compressRecipe(Items.DIAMOND, ItemRegistry.NUGGET_DIAMOND.get());
        compressRecipe(Items.EMERALD, ItemRegistry.NUGGET_EMERALD.get());
        compressRecipe(Items.COPPER_INGOT, ItemRegistry.NUGGET_COPPER.get());

        /////////////////////
        //  Decompressing  //
        /////////////////////
        decompressRecipe(ItemRegistry.STEEL_INGOT.get(), BlockRegistry.STEEL_BLOCK.get());
        decompressRecipe(ItemRegistry.NUGGET_COPPER.get(), Items.COPPER_INGOT);
    }
}