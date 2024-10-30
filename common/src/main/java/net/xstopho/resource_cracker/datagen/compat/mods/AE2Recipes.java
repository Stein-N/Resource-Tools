package net.xstopho.resource_cracker.datagen.compat.mods;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;
import net.xstopho.resource_cracker.datagen.compat.ModBaseRecipes;

public class AE2Recipes extends ModBaseRecipes {

    public AE2Recipes(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        super(provider, "ae2", recipeOutput);
    }

    @Override
    public void generate() {
        defineRecipe("certus_quartz_dust", "certus_quartz_crystal");
        defineRecipe("certus_quartz_dust", "charged_certus_quartz_crystal");
        defineRecipe("fluix_dust", "fluix_crystal");
        defineRecipe("sky_dust", "sky_stone_block");
    }
}
