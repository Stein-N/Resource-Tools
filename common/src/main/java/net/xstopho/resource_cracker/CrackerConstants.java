package net.xstopho.resource_cracker;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.xstopho.resource_cracker.item.tags.CrackerItemTags;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import net.xstopho.resourcelibrary.util.TagUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrackerConstants {
    public static final String MOD_ID = "resource_cracker";
    public static final String MOD_NAME = "Resource Cracker/Tools";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static final ToolMaterial STEEL = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 450,
            6.0F, 2.0F, 14, TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "ingots/steel")));
}
