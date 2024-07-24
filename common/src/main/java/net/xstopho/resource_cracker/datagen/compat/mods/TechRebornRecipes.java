package net.xstopho.resource_cracker.datagen.compat.mods;

import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.xstopho.resource_cracker.datagen.compat.ModBaseRecipes;

public class TechRebornRecipes extends ModBaseRecipes {
    public static void generate(RecipeOutput output) {
        setConstants("techreborn", output);

        defineRecipe("aluminum_dust", "aluminum_storage_block", 9);
        defineRecipe("aluminum_dust", "aluminum_ingot");
        defineRecipe("amethyst_dust", Blocks.AMETHYST_BLOCK);
        defineRecipe("andesite_dust", Blocks.ANDESITE);
        defineRecipe("basalt_dust", createTag("basalt"));
        defineRecipe("bauxite_dust", createTag("ores/bauxite"));
        defineRecipe("brass_dust", "brass_storage_block", 9);
        defineRecipe("brass_dust", "brass_ingot");
        defineRecipe("bronze_dust", "bronze_storage_block", 9);
        defineRecipe("calcite_small_dust", Items.CONDUIT, 6);
        defineRecipe("calcite_dust", createTag("coral_blocks"));
        defineRecipe("chrome_dust", "chrome_storage_block", 9);
        defineRecipe("chrome_dust", "chrome_ingot");
        defineRecipe("cinnabar_dust", "cinnabar_ore");
        defineRecipe("clay_small_dust", Items.CLAY, 2);
        defineRecipe("coal_dust", Items.COAL_BLOCK, 9);
        defineRecipe("diorite_dust", Items.DIORITE);
        defineRecipe("electrum_dust", "electrum_storage_block", 9);
        defineRecipe("endstone_dust", Items.END_STONE);
        defineRecipe("ender_eye_dust", Items.ENDER_EYE);
        defineRecipe("ender_pearl_dust", Items.ENDER_PEARL);
        defineRecipe("flint_dust", Items.FLINT);
        defineRecipe("galena_dust", createTag("ores/galena"));
        defineRecipe("granite_dust", Items.GRANITE);
        defineRecipe("invar_dust", "invar_storage_block", 9);
        defineRecipe("invar_dust", "invar_ingot");
        defineRecipe("lazurite_small_dust", Items.LAPIS_LAZULI, 3);
        defineRecipe("netherrack_dust", Items.CRIMSON_NYLIUM);
        defineRecipe("netherrack_dust", Items.WARPED_NYLIUM);
        defineRecipe("netherrack_dust", Items.NETHERRACK);
        defineRecipe("nickel_dust", "nickel_storage_block", 9);
        defineRecipe("nickel_dust", "nickel_ingot");
        defineRecipe("obsidian_dust", Items.OBSIDIAN);
        defineRecipe("peridot_dust", "peridot_storage_block", 9);
        defineRecipe("peridot_dust", "peridot_gem");
        defineRecipe("peridot_dust", createTag("ores/peridot"));
        defineRecipe("platinum_dust", "platinum_storage_block", 9);
        defineRecipe("platinum_dust", "platinum_ingot");
        defineRecipe("pyrite_dust", "pyrite_ore");
        defineRecipe("quartz_dust", Items.QUARTZ_BLOCK, 4);
        defineRecipe("quartz_dust", Items.QUARTZ);
        defineRecipe("red_garnet_dust", "red_garnet_storage_block", 9);
        defineRecipe("red_garnet_dust", "red_garnet_gem");
        defineRecipe("ruby_dust", "ruby_storage_block", 9);
        defineRecipe("ruby_dust", "ruby_gem");
        defineRecipe("ruby_dust", createTag("ores/ruby"));
        defineRecipe("sapphire_dust", "sapphire_storage_block", 9);
        defineRecipe("sapphire_dust", "sapphire_gem");
        defineRecipe("sapphire_dust", createTag("ores/sapphire"));
        defineRecipe("sodalite_dust", createTag("ores/sodalite"));
        defineRecipe("sphalerite_dust", createTag("ores/sphalerite"));
        defineRecipe("titanium_dust", "titanium_storage_block", 9);
        defineRecipe("titanium_dust", "titanium_ingot");
        defineRecipe("yellow_garnet_dust", "yellow_garnet_storage_block", 9);
        defineRecipe("yellow_garnet_dust", "yellow_garnet_gem");
        defineRecipe("zinc_dust", "zinc_storage_block", 9);
        defineRecipe("zinc_dust", "zinc_ingot");

    }
}
