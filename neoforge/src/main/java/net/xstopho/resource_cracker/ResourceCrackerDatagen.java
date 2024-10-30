package net.xstopho.resource_cracker;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.xstopho.resource_cracker.datagen.*;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = CrackerConstants.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ResourceCrackerDatagen {

    @SubscribeEvent
    public static void data(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new CrackerRecipes.Runner(output, provider));
        generator.addProvider(event.includeServer(), LootProv.create(output, provider));
        generator.addProvider(event.includeServer(), new BlockStateProv(output, fileHelper));
        generator.addProvider(event.includeServer(), new ItemModelProv(output, fileHelper));

        BlockTagProv blockTags = generator.addProvider(event.includeServer(), new BlockTagProv(output, provider, fileHelper));
        generator.addProvider(event.includeServer(), new ItemTagProv(output, provider, blockTags.contentsGetter(), fileHelper));
    }
}
