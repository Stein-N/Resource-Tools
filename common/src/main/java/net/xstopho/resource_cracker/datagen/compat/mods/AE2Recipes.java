package net.xstopho.resource_cracker.datagen.compat.mods;

import net.minecraft.data.recipes.FinishedRecipe;
import net.xstopho.resource_cracker.datagen.compat.ModBaseRecipes;

import java.util.function.Consumer;

public class AE2Recipes extends ModBaseRecipes {
    public static void generate(Consumer<FinishedRecipe> output) {
        setConstants("ae2", output);

        defineRecipe("certus_quartz_dust", "certus_quartz_crystal");
        defineRecipe("certus_quartz_dust", "charged_certus_quartz_crystal");
        defineRecipe("fluix_dust", "fluix_crystal");
        defineRecipe("sky_dust", "sky_stone_block");
    }
}
