package net.xstopho.resource_cracker.helper;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.xstopho.resource_cracker.CrackerConstants;
import net.xstopho.resource_cracker.item.tags.CrackerItemTags;

import java.util.concurrent.CompletableFuture;

public abstract class BaseRecipes extends RecipeProvider {

    private RecipeOutput recipeOutput;
    public BaseRecipes(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    public abstract void createRecipes();

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        this.recipeOutput = recipeOutput;
        this.createRecipes();
    }

    public void crackHammerRecipe(ItemLike output, ItemLike input) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
                .pattern(" IT")
                .pattern(" SI")
                .pattern("S  ")
                .define('T', CrackerItemTags.CRACK_HAMMER_INGREDIENTS)
                .define('S', Items.STICK).define('I', input)
                .unlockedBy(getHasName(input), has(input))
                .save(recipeOutput, path("tools/crack_hammer/" + getSimpleRecipeName(output)));
    }

    public void chiselRecipe(ItemLike output, ItemLike input) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
                .pattern(" I")
                .pattern("S ")
                .define('I', input).define('S', Items.STICK)
                .unlockedBy(getHasName(input), has(input))
                .save(recipeOutput, path("tools/chisel/" + getSimpleRecipeName(output)));
    }

    public void scytheRecipe(ItemLike output, ItemLike input) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
                .pattern("IIT")
                .pattern(" SI")
                .pattern("S  ")
                .define('T', CrackerItemTags.SCYTHE_INGREDIENTS)
                .define('S', Items.STICK).define('I', input)
                .unlockedBy(getHasName(input), has(input))
                .save(recipeOutput, path("tools/scythe/" + getSimpleRecipeName(output)));
    }

    public void netheriteUpgrade(Item output, ItemLike input) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(input), Ingredient.of(Items.NETHERITE_INGOT), RecipeCategory.TOOLS, output)
                .unlocks(getHasName(input), has(input))
                .save(recipeOutput, path("smithing/" + getSimpleRecipeName(output)));
    }

    public void springBlockRecipe(ItemLike output, ItemLike input) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, output, 1)
                .pattern("SSS")
                .pattern("SBS")
                .pattern("SSS")
                .define('S', CrackerItemTags.STEEL_INGOTS)
                .define('B', input)
                .unlockedBy(getHasName(input), has(input))
                .save(recipeOutput, path("blocks/" + getSimpleRecipeName(output)));
    }

    public void materialDustRecipe(ItemLike output, ItemLike input, int outputAmount) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, output, outputAmount)
                .requires(CrackerItemTags.CRACK_HAMMER)
                .requires(input)
                .unlockedBy(getHasName(input), has(input))
                .save(recipeOutput, path("material_dusts/" + getConversionRecipeName(output, input)));
    }

    public void compressRecipe(ItemLike output, ItemLike input) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, output)
                .requires(input, 9)
                .unlockedBy(getHasName(input), has(input))
                .save(recipeOutput, path("compress/" + getConversionRecipeName(output, input)));
    }

    public void decompressRecipe(ItemLike output, ItemLike input) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, output, 9)
                .requires(input)
                .unlockedBy(getHasName(input), has(input))
                .save(recipeOutput, path("decompress/" + getConversionRecipeName(output, input)));
    }

    public void smeltingRecipe(ItemLike input, ItemLike output) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), RecipeCategory.MISC, output, 0.7f, 200)
                .unlockedBy(getHasName(input), has(input))
                .save(recipeOutput, path("smelting/" + getSimpleRecipeName(output)));
    }

    public void blastingRecipe(ItemLike input, ItemLike output) {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(input), RecipeCategory.MISC, output, 0.7f, 100)
                .unlockedBy(getHasName(input), has(input))
                .save(recipeOutput, path("blasting/" + getSimpleRecipeName(output)));
    }

    public void smokingRecipe(ItemLike input, ItemLike output) {
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(input), RecipeCategory.MISC, output, 0.7f, 150)
                .unlockedBy(getHasName(input), has(input))
                .save(recipeOutput, path("smoking/" + getSimpleRecipeName(output)));
    }

    public void campfireRecipe(ItemLike input, ItemLike output) {
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(input), RecipeCategory.MISC, output, 0.7f, 600)
                .unlockedBy(getHasName(input), has(input))
                .save(recipeOutput, path("campfire/" + getSimpleRecipeName(output)));
    }

    public void smithingUpgrade(Item output, ItemLike upgradeItem, ItemLike upgradeMaterial) {
        SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.of(upgradeItem), Ingredient.of(upgradeMaterial),
                RecipeCategory.TOOLS, output)
                .unlocks(getHasName(upgradeMaterial), has(upgradeMaterial))
                .save(recipeOutput, path("smithing/" + getSimpleRecipeName(output)));
    }

    public ResourceLocation path(String path) {
        return ResourceLocation.fromNamespaceAndPath(CrackerConstants.MOD_ID, path);
    }
}
