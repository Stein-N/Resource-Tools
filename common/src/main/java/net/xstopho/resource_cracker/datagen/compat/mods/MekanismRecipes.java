package net.xstopho.resource_cracker.datagen.compat.mods;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Items;
import net.xstopho.resource_cracker.datagen.compat.ModBaseRecipes;

public class MekanismRecipes extends ModBaseRecipes {

    public MekanismRecipes(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        super(provider, "mekanism", recipeOutput);
    }

    @Override
    public void generate() {
        defineRecipe("dirty_dust_copper", "clump_copper");
        defineRecipe("dirty_dust_gold", "clump_gold");
        defineRecipe("dirty_dust_iron", "clump_iron");
        defineRecipe("dirty_dust_lead", "clump_lead");
        defineRecipe("dirty_dust_osmium", "clump_osmium");
        defineRecipe("dirty_dust_tin", "clump_tin");
        defineRecipe("dirty_dust_uranium", "clump_uranium");
        defineRecipe("dust_bronze", "ingot_bronze");
        defineRecipe("dust_coal", Items.COAL);
        defineRecipe("dust_fluorite", "fluorite_gem");
        defineRecipe(Items.GLOWSTONE_DUST, "ingot_refined_glowstone");
        defineRecipe("dust_lapis_lazuli", Items.LAPIS_LAZULI);
        defineRecipe("dust_lead", "ingot_lead");
        defineRecipe("dust_osmium", "ingot_osmium");
        defineRecipe("dust_quartz", Items.QUARTZ);
        defineRecipe("dust_refined_obsidian", "ingot_refined_obsidian");
        defineRecipe("dust_steel", "ingot_steel");
        defineRecipe("dust_tin", "ingot_tin");
        defineRecipe("dust_uranium", "ingot_uranium");
    }
}