package net.xstopho.resource_cracker.datagen;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;

public class Recipes extends BaseRecipes {

    public static void generateToolRecipes(RecipeOutput output, TagKey<Item> tagKey) {
        /* Crack Hammer */
        crackHammerRecipe(output, ItemRegistry.CRACK_HAMMER_COPPER.get(), Items.COPPER_INGOT, tagKey);
        crackHammerRecipe(output, ItemRegistry.CRACK_HAMMER_GOLD.get(), Items.GOLD_INGOT, tagKey);
        crackHammerRecipe(output, ItemRegistry.CRACK_HAMMER_IRON.get(), Items.IRON_INGOT, tagKey);
        crackHammerRecipe(output, ItemRegistry.CRACK_HAMMER_DIAMOND.get(), Items.DIAMOND, tagKey);
        crackHammerRecipe(output, ItemRegistry.CRACK_HAMMER_STEEL.get(), ItemRegistry.STEEL_INGOT.get(), tagKey);
        netheriteUpgrade(output, ItemRegistry.CRACK_HAMMER_NETHERITE.get(), ItemRegistry.CRACK_HAMMER_DIAMOND.get());

        /*  Chisel  */
        chiselRecipe(output, ItemRegistry.CHISEL_COPPER.get(), Items.COPPER_INGOT);
        chiselRecipe(output, ItemRegistry.CHISEL_GOLD.get(), Items.GOLD_INGOT);
        chiselRecipe(output, ItemRegistry.CHISEL_IRON.get(), Items.IRON_INGOT);
        chiselRecipe(output, ItemRegistry.CHISEL_DIAMOND.get(), Items.DIAMOND);
        chiselRecipe(output, ItemRegistry.CHISEL_STEEL.get(), ItemRegistry.STEEL_INGOT.get());
        netheriteUpgrade(output, ItemRegistry.CHISEL_NETHERITE.get(), ItemRegistry.CHISEL_DIAMOND.get());

        /* Scythe */
        scytheRecipe(output, ItemRegistry.SCYTHE_COPPER.get(), Items.COPPER_INGOT, tagKey);
        scytheRecipe(output, ItemRegistry.SCYTHE_IRON.get(), Items.IRON_INGOT, tagKey);
        scytheRecipe(output, ItemRegistry.SCYTHE_GOLD.get(), Items.GOLD_INGOT, tagKey);
        scytheRecipe(output, ItemRegistry.SCYTHE_STEEL.get(), ItemRegistry.STEEL_INGOT.get(), tagKey);
        scytheRecipe(output, ItemRegistry.SCYTHE_DIAMOND.get(), Items.DIAMOND, tagKey);
        netheriteUpgrade(output, ItemRegistry.SCYTHE_NETHERITE.get(), ItemRegistry.SCYTHE_DIAMOND.get());
    }

    public static void generateMaterialDustRecipes(RecipeOutput output, TagKey<Item> tagKey) {
        materialDustRecipe(output, ItemRegistry.MATERIAL_DUST_CARBON.get(), Items.CHARCOAL, 2, tagKey);
        materialDustRecipe(output, ItemRegistry.MATERIAL_DUST_COPPER.get(), Items.RAW_COPPER, 2, tagKey);
        materialDustRecipe(output, ItemRegistry.MATERIAL_DUST_IRON.get(), Items.RAW_IRON, 2, tagKey);
        materialDustRecipe(output, ItemRegistry.MATERIAL_DUST_GOLD.get(), Items.RAW_GOLD, 2, tagKey);

        materialDustRecipe(output, ItemRegistry.MATERIAL_DUST_COPPER.get(), Items.COPPER_INGOT, 1, tagKey);
        materialDustRecipe(output, ItemRegistry.MATERIAL_DUST_IRON.get(), Items.IRON_INGOT, 1, tagKey);
        materialDustRecipe(output, ItemRegistry.MATERIAL_DUST_GOLD.get(), Items.GOLD_INGOT, 1, tagKey);
        materialDustRecipe(output, ItemRegistry.MATERIAL_DUST_STEEL.get(), ItemRegistry.STEEL_INGOT.get(), 1, tagKey);
        materialDustRecipe(output, ItemRegistry.MATERIAL_DUST_DIAMOND.get(), Items.DIAMOND, 1, tagKey);
        materialDustRecipe(output, ItemRegistry.MATERIAL_DUST_NETHERITE.get(), Items.NETHERITE_INGOT, 1, tagKey);
        materialDustRecipe(output, ItemRegistry.MATERIAL_DUST_EMERALD.get(), Items.EMERALD, 1, tagKey);

        materialDustRecipe(output, ItemRegistry.MATERIAL_DUST_DIAMOND.get(), Items.DIAMOND_ORE, 2, tagKey);
        materialDustRecipe(output, ItemRegistry.MATERIAL_DUST_DIAMOND.get(), Items.DEEPSLATE_DIAMOND_ORE, 2, tagKey);
        materialDustRecipe(output, ItemRegistry.MATERIAL_DUST_EMERALD.get(), Items.EMERALD_ORE, 2, tagKey);
        materialDustRecipe(output, ItemRegistry.MATERIAL_DUST_EMERALD.get(), Items.DEEPSLATE_EMERALD_ORE, 2, tagKey);
        materialDustRecipe(output, ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP.get(), Items.ANCIENT_DEBRIS, 2, tagKey);
    }

    public static void generateSpringBlockRecipes(RecipeOutput output, TagKey<Item> tagKey) {
        springBlockRecipe(output, BlockRegistry.WATER_SPRING_BLOCK.get(), Items.WATER_BUCKET, tagKey);
        springBlockRecipe(output, BlockRegistry.LAVA_SPRING_BLOCK.get(), Items.LAVA_BUCKET, tagKey);
    }

    public static void generateProcessingRecipes(RecipeOutput output) {
        processingRecipes(output, ItemRegistry.MATERIAL_DUST_COPPER.get(), Items.COPPER_INGOT, true, true, false, true);
        processingRecipes(output, ItemRegistry.MATERIAL_DUST_IRON.get(), Items.IRON_INGOT, true, true, false, true);
        processingRecipes(output, ItemRegistry.MATERIAL_DUST_GOLD.get(), Items.GOLD_INGOT, true, true, false, true);
        processingRecipes(output, ItemRegistry.MATERIAL_DUST_DIAMOND.get(), Items.DIAMOND, true, true, false, true);
        processingRecipes(output, ItemRegistry.MATERIAL_DUST_EMERALD.get(), Items.EMERALD, true, true, false, true);
        processingRecipes(output, ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP.get(), Items.NETHERITE_SCRAP, true, true, false, true);
        processingRecipes(output, ItemRegistry.MATERIAL_DUST_STEEL.get(), ItemRegistry.STEEL_INGOT.get(), true, true, false, true);
        processingRecipes(output, ItemRegistry.GARLIC.get(), ItemRegistry.MATERIAL_DUST_SULFUR.get(), true, true, false, true);
        processingRecipes(output, Items.ROTTEN_FLESH, Items.LEATHER, true, true, false, true);

        blastingRecipe(output, ItemRegistry.MATERIAL_DUST_NETHERITE.get(), Items.NETHERITE_INGOT);
        smokingRecipe(output, Items.ROTTEN_FLESH, ItemRegistry.BEEF_JERKY.get());
    }

    public static void generateCompactingRecipes(RecipeOutput output) {
        compressionRecipe(output, BlockRegistry.STEEL_BLOCK.get(), ItemRegistry.STEEL_INGOT.get(), true, true);
        compressionRecipe(output, Items.DIAMOND, ItemRegistry.NUGGET_DIAMOND.get(), true, false);
        compressionRecipe(output, Items.EMERALD, ItemRegistry.NUGGET_EMERALD.get(), true, false);
        compressionRecipe(output, Items.COPPER_INGOT, ItemRegistry.NUGGET_COPPER.get(), true, true);
    }

    public static void generateOtherRecipes(RecipeOutput output) {
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
}