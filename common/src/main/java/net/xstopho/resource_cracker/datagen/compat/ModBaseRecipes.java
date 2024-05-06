package net.xstopho.resource_cracker.datagen.compat;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.xstopho.resource_cracker.datagen.CrackerBaseRecipes;
import net.xstopho.resource_cracker.item.tags.CrackerItemTags;

import java.util.function.Consumer;

public class ModBaseRecipes extends CrackerBaseRecipes {

    private static Consumer<FinishedRecipe> conditionalOutput;
    private static String modId;

    public static void setConstants(String id, Consumer<FinishedRecipe> output) {
        modId = id; conditionalOutput = output;
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
                .requires(Ingredient.of(CrackerItemTags.CRACK_HAMMER))
                .requires(input)
                .unlockedBy("has_crack_hammer", has(input))
                .save(conditionalOutput, location(modId + "/" + getSimpleRecipeName(output) + "_from_" +getSimpleRecipeName(input)));
    }

    public static void defineRecipe(ItemLike output, TagKey<Item> input) {
        defineRecipe(output, input, 1);
    }

    public static void defineRecipe(String output, TagKey<Item> input) {
        defineRecipe(item(output), input, 1);
    }

    public static void defineRecipe(String output, TagKey<Item> input, int amount) {
        defineRecipe(item(output), input, amount);
    }

    public static void defineRecipe(ItemLike output, TagKey<Item> input, int amount) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, output, amount)
                .requires(Ingredient.of(CrackerItemTags.CRACK_HAMMER))
                .requires(input)
                .unlockedBy("has_crack_hammer", has(input))
                .save(conditionalOutput, location(modId + "/" + getSimpleRecipeName(output) + "_from_tag_input"));
    }

    private static Item item(String id) {
        ResourceLocation location = new ResourceLocation(modId, id);
        if (BuiltInRegistries.ITEM.containsKey(location)) return BuiltInRegistries.ITEM.get(location);
        else throw new IllegalStateException("Item Registry missing the following entry: " + location);
    }

    public static TagKey<Item> createTag(String id) {
        return TagKey.create(Registries.ITEM, new ResourceLocation("c", id));
    }
}
