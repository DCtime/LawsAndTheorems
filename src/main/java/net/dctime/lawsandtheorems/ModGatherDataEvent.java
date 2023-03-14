package net.dctime.lawsandtheorems;


import net.dctime.lawsandtheorems.eulers_number_item.client.EulersNumberItemModelProvider;
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

        dataProvider.addProvider(event.includeClient(), new EulersNumberItemModelProvider(output, LawsAndTheorems.MODID, efh));

    }
    
}
