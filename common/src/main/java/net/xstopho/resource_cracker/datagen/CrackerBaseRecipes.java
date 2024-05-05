package net.xstopho.resource_cracker.datagen;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.xstopho.resource_cracker.CrackerConstants;
import net.xstopho.resource_cracker.item.tags.CrackerItemTags;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class CrackerBaseRecipes {

    static void crackHammerRecipe(Consumer<FinishedRecipe> exporter, ItemLike output, ItemLike input) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
                .pattern(" IT")
                .pattern(" SI")
                .pattern("S  ")
                .define('T', CrackerItemTags.CRACK_HAMMER_INGREDIENTS)
                .define('S', Items.STICK).define('I', input)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("tools/crack_hammer/" + getSimpleRecipeName(output)));
    }

    static void chiselRecipe(Consumer<FinishedRecipe> exporter, ItemLike output, ItemLike input) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
                .pattern(" I")
                .pattern("S ")
                .define('I', input).define('S', Items.STICK)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("tools/chisel/" + getSimpleRecipeName(output)));
    }

    static void scytheRecipe(Consumer<FinishedRecipe> exporter, ItemLike output, ItemLike input) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
                .pattern("IIT")
                .pattern(" SI")
                .pattern("S  ")
                .define('T', CrackerItemTags.SCYTHE_INGREDIENTS)
                .define('S', Items.STICK).define('I', input)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("tools/scythe/" + getSimpleRecipeName(output)));
    }

    static void netheriteUpgrade(Consumer<FinishedRecipe> exporter, Item output, ItemLike input) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(input), Ingredient.of(Items.NETHERITE_INGOT), RecipeCategory.TOOLS, output)
                .unlocks(getHasName(input), has(input))
                .save(exporter, location("smithing/" + getSimpleRecipeName(output)));
    }

    static void springBlockRecipe(Consumer<FinishedRecipe> exporter, ItemLike output, ItemLike input) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, output, 1)
                .pattern("SSS")
                .pattern("SBS")
                .pattern("SSS")
                .define('S', CrackerItemTags.STEEL_INGOTS)
                .define('B', input)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("blocks/" + getSimpleRecipeName(output)));
    }

    static void materialDustRecipe(Consumer<FinishedRecipe> exporter, ItemLike output, ItemLike input, int outputAmount) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, output, outputAmount)
                .requires(CrackerItemTags.CRACK_HAMMER)
                .requires(input)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("material_dusts/" + getSimpleRecipeName(output) + "_from_" + getSimpleRecipeName(input)));
    }

    static void compressionRecipe(Consumer<FinishedRecipe> exporter, ItemLike output, ItemLike input, boolean compress, boolean decompress) {
        if (compress) {
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, output, 1)
                    .pattern("###").pattern("###").pattern("###")
                    .define('#', input).unlockedBy(getHasName(input), has(input))
                    .save(exporter, location("compress/" + getSimpleRecipeName(output) + "_from_" + getSimpleRecipeName(input)));
        }
        if (decompress) {
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, input, 9).requires(output)
                    .unlockedBy(getHasName(output), has(output))
                    .save(exporter, location("decompress/" + getSimpleRecipeName(input) + "_from_" + getSimpleRecipeName(output)));
        }
    }

    static void processingRecipes(Consumer<FinishedRecipe> exporter, ItemLike input, ItemLike output, boolean smelting, boolean blasting, boolean smoking, boolean campfire) {
        if (smelting) smeltingRecipe(exporter, input, output);
        if (blasting) blastingRecipe(exporter, input, output);
        if (smoking) smokingRecipe(exporter, input, output);
        if (campfire) campfireRecipe(exporter, input, output);

    }

    static void smeltingRecipe(Consumer<FinishedRecipe> exporter, ItemLike input, ItemLike output) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), RecipeCategory.MISC, output, 0.7f, 200)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("smelting/" + getSimpleRecipeName(output)));
    }

    static void blastingRecipe(Consumer<FinishedRecipe> exporter, ItemLike input, ItemLike output) {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(input), RecipeCategory.MISC, output, 0.7f, 100)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("blasting/" + getSimpleRecipeName(output)));
    }

    static void smokingRecipe(Consumer<FinishedRecipe> exporter, ItemLike input, ItemLike output) {
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(input), RecipeCategory.MISC, output, 0.7f, 150)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("smoking/" + getSimpleRecipeName(output)));
    }

    static void campfireRecipe(Consumer<FinishedRecipe> exporter, ItemLike input, ItemLike output) {
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(input), RecipeCategory.MISC, output, 0.7f, 600)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("campfire/" + getSimpleRecipeName(output)));
    }




    /**********************************************************************************/
    /*                          Here are only Helper Methods                          */
    /**********************************************************************************/
    public static InventoryChangeTrigger.TriggerInstance has(MinMaxBounds.Ints ints, ItemLike itemLike) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(new ItemLike[]{itemLike}).withCount(ints).build());
    }

    public static InventoryChangeTrigger.TriggerInstance has(ItemLike itemLike) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(new ItemLike[]{itemLike}).build());
    }

    public static InventoryChangeTrigger.TriggerInstance inventoryTrigger(ItemPredicate... itemPredicates) {
        return new InventoryChangeTrigger.TriggerInstance(ContextAwarePredicate.ANY, MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, itemPredicates);
    }

    public static String getHasName(ItemLike itemLike) {
        return "has_" + getItemName(itemLike);
    }

    public static String getItemName(ItemLike itemLike) {
        return BuiltInRegistries.ITEM.getKey(itemLike.asItem()).getPath();
    }

    public static String getSimpleRecipeName(ItemLike itemLike) {
        return getItemName(itemLike);
    }

    public static ResourceLocation location(String path) {
        return new ResourceLocation(CrackerConstants.MOD_ID, path);
    }
}
