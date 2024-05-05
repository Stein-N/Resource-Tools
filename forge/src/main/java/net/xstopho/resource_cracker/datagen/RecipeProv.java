package net.xstopho.resource_cracker.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.function.Consumer;

public class RecipeProv extends RecipeProvider {

    public RecipeProv(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> output) {
        CrackerRecipes.generateToolRecipes(output);
        CrackerRecipes.generateMaterialDustRecipes(output);
        CrackerRecipes.generateSpringBlockRecipes(output);
        CrackerRecipes.generateProcessingRecipes(output);
        CrackerRecipes.generateCompactingRecipes(output);
        CrackerRecipes.generateOtherRecipes(output);
    }
}