package net.xstopho.resource_cracker.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.DefaultResourceConditions;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.xstopho.resource_cracker.datagen.compat.mods.TechRebornRecipes;
import net.xstopho.resource_cracker.item.tags.CrackerItemTags;
import net.xstopho.resource_cracker.registries.ItemRegistry;

import java.util.concurrent.CompletableFuture;

public class RecipeProv extends FabricRecipeProvider {


    public RecipeProv(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(RecipeOutput output) {

        TechRebornRecipes.generate(withConditions(output, DefaultResourceConditions.allModsLoaded("techreborn")));

        CrackerRecipes.generateToolRecipes(output);
        CrackerRecipes.generateMaterialDustRecipes(output);
        CrackerRecipes.generateSpringBlockRecipes(output);
        CrackerRecipes.generateProcessingRecipes(output);
        CrackerRecipes.generateCompactingRecipes(output);
        CrackerRecipes.generateOtherRecipes(output);
    }
}
