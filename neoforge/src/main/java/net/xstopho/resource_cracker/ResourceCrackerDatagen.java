package net.xstopho.resource_cracker;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
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
        PackOutput output = event.getGenerator().getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();

        event.addProvider(new CrackerRecipeProv.Runner(output, provider));
        event.addProvider(LootProv.create(output, provider));
        event.addProvider(new BlockStateProv(output, fileHelper));
        event.addProvider(new ItemModelProv(output, fileHelper));
        event.addProvider(new BlockTagProv(output, provider, fileHelper));
        event.addProvider(new ItemTagProv(output, provider, null, fileHelper));
    }
}
