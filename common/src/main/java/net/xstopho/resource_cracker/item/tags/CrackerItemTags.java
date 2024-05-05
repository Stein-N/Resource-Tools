package net.xstopho.resource_cracker.item.tags;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.xstopho.resourcelibrary.items.tags.TagHelper;

public class CrackerItemTags {

    // General Tags
    public static final TagKey<Item> DUSTS = createTag("dusts", "dusts");
    public static final TagKey<Item> NUGGETS = createTag("nuggets", "nuggets");
    public static final TagKey<Item> INGOTS = createTag("nuggets", "ingots");
    public static final TagKey<Item> FOODS = createTag("foods", "foods");
    public static final TagKey<Item> TOOLS = createTag("tools", "tools");
    public static final TagKey<Item> ENCHANTABLES = createTag("enchantables", "enchantables");

    // Mod specific Tags
    public static final TagKey<Item> CRACK_HAMMER = createTag("crack_hammer","tools/crack_hammer");
    public static final TagKey<Item> CHISEL = createTag("chisel", "tools/chisel");
    public static final TagKey<Item> SCYTHE = createTag("scythe", "tools/scythe");
    public static final TagKey<Item> CRACK_HAMMER_INGREDIENTS = createTag("crack_hammer_crafting_ingredient", "tools/crack_hammer/crafting_ingredients");
    public static final TagKey<Item> SCYTHE_INGREDIENTS = createTag("scythe_crafting_ingredients", "tools/scythe/crafting_ingredients");

    public static final TagKey<Item> COAL_DUSTS = createTag("coal_dusts", "dusts/coal");
    public static final TagKey<Item> CARBON_DUSTS = createTag("carbon_dusts", "dusts/carbon");
    public static final TagKey<Item> COPPER_DUSTS = createTag("copper_dusts", "dusts/copper");
    public static final TagKey<Item> IRON_DUSTS = createTag("iron_dusts", "dusts/iron");

    public static final TagKey<Item> GOLD_DUSTS = createTag("gold_dusts", "dusts/gold");
    public static final TagKey<Item> DIAMOND_DUSTS = createTag("diamond_dusts", "dusts/diamond");
    public static final TagKey<Item> EMERALD_DUSTS = createTag("emerald_dusts", "dusts/emerald");
    public static final TagKey<Item> SULFUR_DUSTS = createTag("sulfur_dusts", "dusts/sulfur");

    public static final TagKey<Item> SALTPETER_DUSTS = createTag("saltpeter_dusts", "dusts/saltpeter");
    public static final TagKey<Item> STEEL_DUSTS = createTag("steel_dusts", "dusts/steel");
    public static final TagKey<Item> NETHERITE_SCRAP_DUSTS = createTag("netherite_scrap_dusts", "dusts/netherite_scrap");
    public static final TagKey<Item> NETHERITE_DUSTS = createTag("netherite_dusts", "dusts/netherite");

    public static final TagKey<Item> DIAMOND_NUGGETS = createTag("diamond_nuggets", "nuggets/diamond");
    public static final TagKey<Item> EMERALD_NUGGETS = createTag("emerald_nuggets", "nuggets/emerald");
    public static final TagKey<Item> COPPER_NUGGETS = createTag("copper_nuggets", "nuggets/copper");
    public static final TagKey<Item> STEEL_INGOTS = createTag("steel_ingots", "ingots/steel");

    public static final TagKey<Item> STEEL_BLOCKS = createTag("steel_blocks", "blocks/steel");
    public static final TagKey<Item> GARLIC = createTag("garlic", "foods/garlic");
    public static final TagKey<Item> BEEF_JERKY = createTag("beef_jerky", "foods/beef_jerky");

    public static TagKey<Item> createTag(String fabric, String forge) {
        return TagHelper.createPlatformTag(fabric, forge);
    }
}
