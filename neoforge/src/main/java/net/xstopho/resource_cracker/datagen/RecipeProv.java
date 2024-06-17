package net.xstopho.resource_cracker.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.xstopho.resource_cracker.datagen.compat.mods.AE2Recipes;
import net.xstopho.resource_cracker.datagen.compat.mods.MekanismRecipes;

import java.util.concurrent.CompletableFuture;

public class RecipeProv extends RecipeProvider implements IConditionBuilder {


    public RecipeProv(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, provider);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {

        AE2Recipes.generate(output.withConditions(getConditions(modLoaded("ae2"))));
        MekanismRecipes.generate(output.withConditions(getConditions(modLoaded("mekanism"))));

        CrackerRecipes.generateToolRecipes(output);
        CrackerRecipes.generateMaterialDustRecipes(output);
        CrackerRecipes.generateSpringBlockRecipes(output);
        CrackerRecipes.generateProcessingRecipes(output);
        CrackerRecipes.generateCompactingRecipes(output);
        CrackerRecipes.generateOtherRecipes(output);
    }

    static ICondition[] getConditions(ICondition... conditions) {
        ICondition[] con = new ICondition[conditions.length];
        System.arraycopy(conditions, 0, con, 0, con.length);
        return con;
    }
}