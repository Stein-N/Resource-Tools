package net.xstopho.resource_cracker.datagen;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.xstopho.resourcelibrary.items.tags.TagHelper;

public class ModItemTags {

    public static final TagKey<Item> CRACK_HAMMER = TagHelper.createPlatformTag("tools/crack_hammer");
    public static final TagKey<Item> CHISEL = createTag("tools/chisel");
    public static final TagKey<Item> SCYTHE = createTag("tools/scythe");
    public static final TagKey<Item> CRACK_HAMMER_INGREDIENTS = createTag("tools/crack_hammer/crafting_ingredients");
    public static final TagKey<Item> SCYTHE_INGREDIENTS = createTag("tools/scythe/crafting_ingredients");

    public static final TagKey<Item> COAL_DUSTS = createTag("dusts/coal");
    public static final TagKey<Item> CARBON_DUSTS = createTag("dusts/carbon");
    public static final TagKey<Item> COPPER_DUSTS = createTag("dusts/copper");
    public static final TagKey<Item> IRON_DUSTS = createTag("dusts/iron");

    public static final TagKey<Item> GOLD_DUSTS = createTag("dusts/gold");
    public static final TagKey<Item> DIAMOND_DUSTS = createTag("dusts/diamond");
    public static final TagKey<Item> EMERALD_DUSTS = createTag("dusts/emerald");
    public static final TagKey<Item> SULFUR_DUSTS = createTag("dusts/sulfur");

    public static final TagKey<Item> SALTPETER_DUSTS = createTag("dusts/saltpeter");
    public static final TagKey<Item> STEEL_DUSTS = createTag("dusts/steel");
    public static final TagKey<Item> NETHERITE_SCRAP_DUSTS = createTag("dusts/netherite_scrap");
    public static final TagKey<Item> NETHERITE_DUSTS = createTag("dusts/netherite");

    public static final TagKey<Item> DIAMOND_NUGGETS = createTag("nuggets/diamond");
    public static final TagKey<Item> EMERALD_NUGGETS = createTag("nuggets/emerald");
    public static final TagKey<Item> COPPER_NUGGETS = createTag("nuggets/copper");
    public static final TagKey<Item> STEEL_INGOTS = createTag("ingots/steel");

    public static final TagKey<Item> STEEL_BLOCKS = createTag("blocks/steel");

    public static TagKey<Item> createTag(String id) {
        return TagHelper.createPlatformTag(id);
    }
}
