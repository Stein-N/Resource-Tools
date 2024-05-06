package net.xstopho.resource_cracker.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.DefaultResourceConditions;
import net.minecraft.data.recipes.FinishedRecipe;
import net.xstopho.resource_cracker.datagen.compat.mods.AE2Recipes;
import net.xstopho.resource_cracker.datagen.compat.mods.TechRebornRecipes;

import java.util.function.Consumer;

public class RecipeProv extends FabricRecipeProvider {


    public RecipeProv(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> output) {

        AE2Recipes.generate(withConditions(output, DefaultResourceConditions.allModsLoaded("ae2")));
        TechRebornRecipes.generate(withConditions(output, DefaultResourceConditions.allModsLoaded("techreborn")));

        CrackerRecipes.generateToolRecipes(output);
        CrackerRecipes.generateMaterialDustRecipes(output);
        CrackerRecipes.generateSpringBlockRecipes(output);
        CrackerRecipes.generateProcessingRecipes(output);
        CrackerRecipes.generateCompactingRecipes(output);
        CrackerRecipes.generateOtherRecipes(output);
    }
}
