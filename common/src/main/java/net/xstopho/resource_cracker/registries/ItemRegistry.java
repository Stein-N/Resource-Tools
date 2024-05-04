package net.xstopho.resource_cracker.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.xstopho.resource_cracker.CrackerConstants;
import net.xstopho.resourcelibrary.registration.RegistryObject;
import net.xstopho.resourcelibrary.registration.RegistryProvider;

import java.util.function.Supplier;

public class ItemRegistry {

    public static final RegistryProvider<Item> ITEMS = RegistryProvider.get(Registries.ITEM, CrackerConstants.MOD_ID);

    public static final RegistryObject<Item> GARLIC = register("garlic", () -> new ItemNameBlockItem(BlockRegistry.GARLIC_CROP.get(), new Item.Properties()));

    private static RegistryObject<Item> register(String id, Supplier<Item> item) {
        return ITEMS.register(id, item);
    }

    private static RegistryObject<Item> register(String id) {
        return register(id, () -> new Item(new Item.Properties()));
    }

    public static void init() {}
}
