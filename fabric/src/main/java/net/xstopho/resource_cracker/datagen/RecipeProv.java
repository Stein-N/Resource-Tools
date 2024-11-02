package net.xstopho.resource_cracker.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.xstopho.resource_cracker.datagen.compat.mods.TechRebornRecipes;

import java.util.concurrent.CompletableFuture;

public class RecipeProv extends FabricRecipeProvider {


    public RecipeProv(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        return new CrackerRecipeProv(provider, recipeOutput) {
            @Override
            public void buildRecipes() {
                super.buildRecipes();

                new TechRebornRecipes(provider, withConditions(recipeOutput, ResourceConditions.allModsLoaded("techreborn")));
            }
        };
    }

    @Override
    public String getName() {
        return "Recipe Provider";
    }
}
