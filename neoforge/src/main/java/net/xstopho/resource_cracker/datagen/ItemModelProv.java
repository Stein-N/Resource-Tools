package net.xstopho.resource_cracker.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.xstopho.resource_cracker.CrackerConstants;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import net.xstopho.resourcelibrary.registration.RegistryObject;

public class ItemModelProv extends ItemModelProvider {

    public ItemModelProv(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CrackerConstants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ItemRegistry.CRACK_HAMMER_COPPER);
        simpleItem(ItemRegistry.CRACK_HAMMER_GOLD);
        simpleItem(ItemRegistry.CRACK_HAMMER_IRON);
        simpleItem(ItemRegistry.CRACK_HAMMER_DIAMOND);
        simpleItem(ItemRegistry.CRACK_HAMMER_NETHERITE);
        simpleItem(ItemRegistry.CRACK_HAMMER_STEEL);

        simpleItem(ItemRegistry.CHISEL_COPPER);
        simpleItem(ItemRegistry.CHISEL_GOLD);
        simpleItem(ItemRegistry.CHISEL_IRON);
        simpleItem(ItemRegistry.CHISEL_DIAMOND);
        simpleItem(ItemRegistry.CHISEL_NETHERITE);
        simpleItem(ItemRegistry.CHISEL_STEEL);

        simpleItem(ItemRegistry.SCYTHE_COPPER);
        simpleItem(ItemRegistry.SCYTHE_GOLD);
        simpleItem(ItemRegistry.SCYTHE_IRON);
        simpleItem(ItemRegistry.SCYTHE_DIAMOND);
        simpleItem(ItemRegistry.SCYTHE_NETHERITE);
        simpleItem(ItemRegistry.SCYTHE_STEEL);

        simpleItem(ItemRegistry.MATERIAL_DUST_COPPER);
        simpleItem(ItemRegistry.MATERIAL_DUST_IRON);
        simpleItem(ItemRegistry.MATERIAL_DUST_GOLD);
        simpleItem(ItemRegistry.MATERIAL_DUST_DIAMOND);
        simpleItem(ItemRegistry.MATERIAL_DUST_STEEL);
        simpleItem(ItemRegistry.MATERIAL_DUST_CARBON);

        simpleItem(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP);
        simpleItem(ItemRegistry.MATERIAL_DUST_NETHERITE);
        simpleItem(ItemRegistry.MATERIAL_DUST_EMERALD);
        simpleItem(ItemRegistry.MATERIAL_DUST_SALTPETER);
        simpleItem(ItemRegistry.MATERIAL_DUST_SULFUR);

        simpleItem(ItemRegistry.STEEL_INGOT);
        simpleItem(ItemRegistry.NUGGET_COPPER);
        simpleItem(ItemRegistry.NUGGET_DIAMOND);
        simpleItem(ItemRegistry.NUGGET_EMERALD);

        simpleItem(ItemRegistry.BEEF_JERKY);
        simpleItem(ItemRegistry.GARLIC);

        itemWithParentBlock("lava_spring_block");
        itemWithParentBlock("water_spring_block");
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CrackerConstants.MOD_ID,"item/" + item.getId().getPath()));
    }

    private void itemWithParentBlock(String id) {
        withExistingParent(id, new ResourceLocation(CrackerConstants.MOD_ID, "block/" + id));
    }
}
