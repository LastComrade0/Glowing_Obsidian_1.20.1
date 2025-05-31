package net.lastcomrade0.glowing_obsidian.datagen;

import net.lastcomrade0.glowing_obsidian.GlowingObsidian;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = GlowingObsidian.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGeneration {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        //Minecraft vanilla DataGenerator Class
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

//        ModBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
//                new ModBlockTagGenerator(packOutput, lookupProvider, existingFileHelper));
//
//        generator.addProvider(event.includeServer(), new ModItemModelProvider(packOutput, existingFileHelper));
//        generator.addProvider(event.includeServer(), new ModItemTagGenerator(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));
//        generator.addProvider(event.includeServer(), new ModGlobalLootProvider(packOutput));
//        generator.addProvider(event.includeServer(), ModLootTableProvider.create(packOutput));
        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput));
    }
}

