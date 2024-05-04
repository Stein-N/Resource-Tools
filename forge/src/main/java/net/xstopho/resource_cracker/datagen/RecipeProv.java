package net.xstopho.resource_cracker.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.concurrent.CompletableFuture;

public class RecipeProv extends RecipeProvider {


    public RecipeProv(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, provider);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        CrackerRecipes.generateToolRecipes(output);
        CrackerRecipes.generateMaterialDustRecipes(output);
        CrackerRecipes.generateSpringBlockRecipes(output);
        CrackerRecipes.generateProcessingRecipes(output);
        CrackerRecipes.generateCompactingRecipes(output);
        CrackerRecipes.generateOtherRecipes(output);
    }
}