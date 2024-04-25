package net.xstopho.resource_cracker.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.xstopho.resource_cracker.Constants;
import net.xstopho.resource_cracker.registries.ItemRegistry;

import java.util.concurrent.CompletableFuture;

public class RecipeProv extends RecipeProvider implements IConditionBuilder {


    public RecipeProv(PackOutput output, CompletableFuture<HolderLookup.Provider> holderLookup) {
        super(output, holderLookup);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {

        Recipes.generateToolRecipes(output, ModItemTags.CRAFTING_INGREDIENTS);
        Recipes.generateMaterialDustRecipes(output, ModItemTags.CRACK_HAMMER);
        Recipes.generateSpringBlockRecipes(output, ModItemTags.STEEL_BLOCKS);
        Recipes.generateProcessingRecipes(output);
        Recipes.generateCompactingRecipes(output);

        // Mod Recipes
        //AE2Recipes.generate(new ConditionalRecipeOutput(output, getConditions(modLoaded("ae2"))));

        // Netherite Dust Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.MATERIAL_DUST_NETHERITE.get(), 1)
                .pattern("AAA").pattern("AGG").pattern("GG ")
                .define('A', ModItemTags.NETHERITE_SCRAP_DUSTS)
                .define('G', ModItemTags.GOLD_DUSTS)
                .unlockedBy(getHasName(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP.get()), has(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP.get()))
                .save(output, location("crafting/" + getSimpleRecipeName(ItemRegistry.MATERIAL_DUST_NETHERITE.get())));

        // Steeldust Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.MATERIAL_DUST_STEEL.get(), 2)
                .pattern("II").pattern("SS")
                .define('I', ModItemTags.IRON_DUSTS)
                .define('S', ModItemTags.COAL_DUSTS)
                .unlockedBy(getHasName(ItemRegistry.MATERIAL_DUST_IRON.get()), has(ItemRegistry.MATERIAL_DUST_IRON.get()))
                .save(output, location("crafting/" + getSimpleRecipeName(ItemRegistry.MATERIAL_DUST_STEEL.get())));

        // Slimeball Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SLIME_BALL, 3)
                .pattern("HGS")
                .define('H', Items.HONEYCOMB)
                .define('G', Items.GREEN_DYE)
                .define('S', ModItemTags.SALTPETER_DUSTS)
                .unlockedBy(getHasName(ItemRegistry.MATERIAL_DUST_SALTPETER.get()), has(ItemRegistry.MATERIAL_DUST_SALTPETER.get()))
                .save(output, location("crafting/" + getSimpleRecipeName(Items.SLIME_BALL)));

        // Gunpowder Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.GUNPOWDER, 3)
                .pattern("SPC").define('C', Items.CHARCOAL)
                .define('P', ModItemTags.SALTPETER_DUSTS)
                .define('S', ModItemTags.SULFUR_DUSTS)
                .unlockedBy(getHasName(ItemRegistry.MATERIAL_DUST_SALTPETER.get()), has(ItemRegistry.MATERIAL_DUST_SALTPETER.get()))
                .save(output, location("crafting/" + getSimpleRecipeName(Items.GUNPOWDER)));
    }

    static ResourceLocation location(String path) {
        return new ResourceLocation(Constants.MOD_ID, path);
    }

    static ICondition[] getConditions(ICondition... conditions) {
        ICondition[] con = new ICondition[conditions.length];
        System.arraycopy(conditions, 0, con, 0, con.length);
        return con;
    }
}