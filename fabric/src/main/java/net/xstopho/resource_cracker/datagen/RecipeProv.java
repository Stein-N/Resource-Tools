package net.xstopho.resource_cracker.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;
import net.xstopho.resource_cracker.datagen.compat.mods.TechRebornRecipes;

import java.util.concurrent.CompletableFuture;

public class RecipeProv extends FabricRecipeProvider {


    public RecipeProv(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput output) {

        TechRebornRecipes.generate(withConditions(output, ResourceConditions.allModsLoaded("techreborn")));

        CrackerRecipes.generateToolRecipes(output);
        CrackerRecipes.generateMaterialDustRecipes(output);
        CrackerRecipes.generateSpringBlockRecipes(output);
        CrackerRecipes.generateProcessingRecipes(output);
        CrackerRecipes.generateCompactingRecipes(output);
        CrackerRecipes.generateOtherRecipes(output);
    }
}
