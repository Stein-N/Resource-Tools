package net.xstopho.resource_cracker.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

public class ModRecipes extends BaseRecipes{

    private static RecipeOutput conditionalOutput;
    private static String id;

    public static void setConstants(RecipeOutput output, String modId) {
        conditionalOutput = output;
        id = modId;
    }

    public static void defineRecipe(String output, String input) {
        defineRecipe(item(output), item(input), 1);
    }

    public static void defineRecipe(String output, ItemLike input) {
        defineRecipe(item(output), input, 1);
    }

    public static void defineRecipe(ItemLike output, String input) {
        defineRecipe(output, item(input), 1);
    }

    public static void defineRecipe(String output, String input, int amount) {
        defineRecipe(item(output), item(input), amount);
    }

    public static void defineRecipe(String output, ItemLike input, int amount) {
        defineRecipe(item(output), input, amount);
    }

    public static void defineRecipe(ItemLike output, String input, int amount) {
        defineRecipe(output, item(input), amount);
    }

    public static void defineRecipe(ItemLike output, ItemLike input, int amount) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, output, amount)
                .requires(Ingredient.of(ModItemTags.CRACK_HAMMER))
                .requires(input)
                .unlockedBy(getHasName(input), has(input))
                .save(conditionalOutput, location(id + "/" + getSimpleRecipeName(output) + "_from_" + getSimpleRecipeName(input)));
    }

    public static void defineRecipe(String output, TagKey<Item> input) {
        defineRecipe(item(output), input, 1);
    }

    public static void defineRecipe(ItemLike output, TagKey<Item> input) {
        defineRecipe(output, input, 1);
    }

    public static void defineRecipe(String output, TagKey<Item> input, int amount) {
        defineRecipe(item(output), input, amount);
    }

    public static void defineRecipe(ItemLike output, TagKey<Item> input, int amount) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, output, amount)
                .requires(Ingredient.of(ModItemTags.CRACK_HAMMER))
                .requires(input)
                .unlockedBy("has_crack_hammer", has(input))
                .save(conditionalOutput, location(id + "/" + getSimpleRecipeName(output) + "_from_tag_input"));
    }

    public static Item item(String itemId) {
        ResourceLocation location = new ResourceLocation(id, itemId);
        if (BuiltInRegistries.ITEM.containsKey(location)) return BuiltInRegistries.ITEM.get(location);
        else throw new IllegalArgumentException("Item Registry missing the following entry: " + location);
    }
}
