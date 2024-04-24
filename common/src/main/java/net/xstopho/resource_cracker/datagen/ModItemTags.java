package net.xstopho.resource_cracker.datagen;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.xstopho.resource_cracker.service.Services;

public class ModItemTags {

    public static final TagKey<Item> CRACK_HAMMER = createTags("crack_hammers","tools/crack_hammers");
    public static final TagKey<Item> CHISEL = createTags("chisel", "tools/chisel");
    public static final TagKey<Item> SCYTHE = createTags("scythe", "tools/scythe");
    public static final TagKey<Item> CRAFTING_INGREDIENTS = createTags("crafting_ingredients", "tools/crafting_ingredients");

    public static final TagKey<Item> COAL_DUSTS = createTags("coal_dusts", "dusts/coal");
    public static final TagKey<Item> CARBON_DUSTS = createTags("carbon_dusts", "dusts/carbon");
    public static final TagKey<Item> COPPER_DUSTS = createTags("copper_dusts", "dusts/copper");
    public static final TagKey<Item> IRON_DUSTS = createTags("iron_dusts", "dusts/iron");

    public static final TagKey<Item> GOLD_DUSTS = createTags("gold_dusts", "dusts/gold");
    public static final TagKey<Item> DIAMOND_DUSTS = createTags("diamond_dusts", "dusts/diamond");
    public static final TagKey<Item> EMERALD_DUSTS = createTags("emerald_dusts", "dusts/emerald");
    public static final TagKey<Item> SULFUR_DUSTS = createTags("sulfur_dusts", "dusts/sulfur");

    public static final TagKey<Item> SALTPETER_DUSTS = createTags("saltpeter_dusts", "dusts/saltpeter");
    public static final TagKey<Item> STEEL_DUSTS = createTags("steel_dusts", "dusts/steel");
    public static final TagKey<Item> NETHERITE_SCRAP_DUSTS = createTags("netherite_scrap_dusts", "dusts/netherite_scrap");
    public static final TagKey<Item> NETHERITE_DUSTS = createTags("netherite_dusts", "dusts/netherite");

    public static final TagKey<Item> DIAMOND_NUGGETS = createTags("diamond_nuggets", "nuggets/diamond");
    public static final TagKey<Item> EMERALD_NUGGETS = createTags("emerald_nuggets", "nuggets/emerald");
    public static final TagKey<Item> COPPER_NUGGETS = createTags("copper_nuggets", "nuggets/copper");
    public static final TagKey<Item> STEEL_INGOTS = createTags("steel_ingots", "ingots/steel");

    public static final TagKey<Item> STEEL_BLOCKS = createTags("steel_blocks", "blocks/steel");

    public static TagKey<Item> createTags(String fabric, String forge) {
        return switch (Services.PLATFORM) {
            case FABRIC -> fabricTag(fabric);
            case FORGE, NEOFORGE -> forgeTag(forge);
            default -> throw new IllegalStateException("No Loader found");
        };
    }

    public static TagKey<Item> fabricTag(String id) {
        return TagKey.create(Registries.ITEM, new ResourceLocation("c", id));
    }

    public static TagKey<Item> forgeTag(String id) {
        return TagKey.create(Registries.ITEM, new ResourceLocation("forge", id));
    }
}
