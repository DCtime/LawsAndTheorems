package net.dctime.lawsandtheorems;


import net.minecraft.data.DataGenerator;
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
        DataGenerator dataProvider = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
    }
    
}
