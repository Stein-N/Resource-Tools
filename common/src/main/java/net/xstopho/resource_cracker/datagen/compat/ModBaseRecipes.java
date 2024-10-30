package net.xstopho.resource_cracker.datagen.compat;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import net.xstopho.resource_cracker.CrackerConstants;
import net.xstopho.resource_cracker.item.tags.CrackerItemTags;
import net.xstopho.resourcelibrary.util.TagUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public abstract class ModBaseRecipes {

    private final HolderGetter<Item> provider;
    private final RecipeOutput recipeOutput;
    private final String modId;

    public ModBaseRecipes(HolderLookup.Provider provider, String modId, RecipeOutput recipeOutput) {
        this.provider = provider.lookupOrThrow(Registries.ITEM);
        this.modId = modId;
        this.recipeOutput = recipeOutput;
    }

    public abstract void generate();

    public void defineRecipe(String result, String input) {
        if (!checkRegistryForItems(result, input)) return;

        defineRecipe(getItem(result), getItem(input), 2);
    }

    public void defineRecipe(String result, ItemLike input) {
        if (!checkRegistryForItems(result)) return;

        defineRecipe(getItem(result), input, 2);
    }

    public void defineRecipe(ItemLike result, String input) {
        if (!checkRegistryForItems(input)) return;

        defineRecipe(result, getItem(input), 2);
    }

    public void defineRecipe(ItemLike result, ItemLike input) {
        defineRecipe(result, input, 2);
    }

    public void defineRecipe(ItemLike result, TagKey<Item> input) {
        defineRecipe(result, input, 2);
    }

    public void defineRecipe(String result, TagKey<Item> input) {
        if (!checkRegistryForItems(result)) return;

        defineRecipe(getItem(result), input, 2);
    }

    public void defineRecipe(String result, String input, int amount) {
        if (!checkRegistryForItems(result, input)) return;

        defineRecipe(getItem(result), getItem(input), amount);
    }

    public void defineRecipe(String result, ItemLike input, int amount) {
        if (!checkRegistryForItems(result)) return;

        defineRecipe(getItem(result), input, amount);
    }

    public void defineRecipe(ItemLike result, String input, int amount) {
        if (!checkRegistryForItems(input)) return;

        defineRecipe(result, getItem(input), amount);
    }

    public void defineRecipe(String result, TagKey<Item> input, int amount) {
        if (!checkRegistryForItems(result)) return;

        defineRecipe(getItem(result), input, amount);
    }

    public void defineRecipe(ItemLike result, ItemLike input, int amount) {
        ShapelessRecipeBuilder.shapeless(this.provider, RecipeCategory.MISC, result, amount)
                .requires(CrackerItemTags.CRACK_HAMMER)
                .requires(input)
                .unlockedBy("has_crack_hammer", has(CrackerItemTags.CRACK_HAMMER))
                .save(this.recipeOutput, path(this.modId + "/" + getSimpleRecipeName(result)));
    }
    public void defineRecipe(ItemLike result, TagKey<Item> input, int amount) {
        ShapelessRecipeBuilder.shapeless(this.provider, RecipeCategory.MISC, result, amount)
                .requires(CrackerItemTags.CRACK_HAMMER)
                .requires(input)
                .unlockedBy("has_crack_hammer", has(CrackerItemTags.CRACK_HAMMER))
                .save(this.recipeOutput, path(this.modId + "/" + getSimpleRecipeName(result)));
    }

    private Criterion<InventoryChangeTrigger.TriggerInstance> has(TagKey<Item> tagKey) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(this.provider, tagKey));
    }

    private Criterion<InventoryChangeTrigger.TriggerInstance> inventoryTrigger(ItemPredicate.Builder... builders) {
        return inventoryTrigger(Arrays.stream(builders).map(ItemPredicate.Builder::build).toArray(ItemPredicate[]::new));
    }

    private Criterion<InventoryChangeTrigger.TriggerInstance> inventoryTrigger(ItemPredicate... itemPredicates) {
        return CriteriaTriggers.INVENTORY_CHANGED.createCriterion(new InventoryChangeTrigger.TriggerInstance(Optional.empty(), InventoryChangeTrigger.TriggerInstance.Slots.ANY, List.of(itemPredicates)));
    }

    private ResourceKey<Recipe<?>> path(String path) {
        return ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(CrackerConstants.MOD_ID, path));
    }

    private String getSimpleRecipeName(ItemLike itemLike) {
        return BuiltInRegistries.ITEM.getKey(itemLike.asItem()).getPath();
    }

    private boolean checkRegistry(String itemName) {
        return BuiltInRegistries.ITEM.containsKey(getLocation(itemName));
    }

    private boolean checkRegistryForItems(String... itemNames) {
        for (String name : itemNames) {
            if (!checkRegistry(name)) {
                CrackerConstants.LOGGER.error("Item Registry does not contain '{}', the Recipe is skipped!", getLocation(name));
                return false;
            }
        }
        return true;
    }

    private Item getItem(String id) {
        return BuiltInRegistries.ITEM.get(getLocation(id)).get().value();
    }

    private ResourceLocation getLocation(String itemName) {
        return ResourceLocation.fromNamespaceAndPath(this.modId, itemName);
    }

    public static TagKey<Item> createTag(String id) {
        return TagUtil.createItemTag(id);
    }
}
