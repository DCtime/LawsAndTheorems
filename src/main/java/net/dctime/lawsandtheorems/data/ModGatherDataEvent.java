package net.dctime.lawsandtheorems.data;


import java.util.List;

import net.dctime.lawsandtheorems.LawsAndTheorems;
import net.dctime.lawsandtheorems.data.providers.client.ModBlockStateProvider;
import net.dctime.lawsandtheorems.data.providers.client.ModEnUsLanguageProvider;
import net.dctime.lawsandtheorems.data.providers.client.ModItemModelProvider;
import net.dctime.lawsandtheorems.data.providers.client.ModSoundDefinitionProvider;
import net.dctime.lawsandtheorems.data.providers.server.ModAdvancementProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = LawsAndTheorems.MODID, bus = Bus.MOD)
public class ModGatherDataEvent 
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        // run dataGen to generate json files
        DataGenerator dataProvider = event.getGenerator();
        ExistingFileHelper efh = event.getExistingFileHelper();
        PackOutput output = dataProvider.getPackOutput();

        dataProvider.addProvider(event.includeClient(), new ModItemModelProvider(output, LawsAndTheorems.MODID, efh));
        dataProvider.addProvider(event.includeClient(), new ModEnUsLanguageProvider(output, LawsAndTheorems.MODID, "en_us"));
        dataProvider.addProvider(event.includeClient(), new ModSoundDefinitionProvider(output, LawsAndTheorems.MODID, efh));
        dataProvider.addProvider(event.includeServer(), new ModAdvancementProvider(output, event.getLookupProvider(), efh, List.of(new ModAdvancementProvider.ModAdvancementGenerator())));
        dataProvider.addProvider(event.includeClient(), new ModBlockStateProvider(output, LawsAndTheorems.MODID, efh));
    }
    
}
