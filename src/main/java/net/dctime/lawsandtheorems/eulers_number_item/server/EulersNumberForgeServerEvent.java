package net.dctime.lawsandtheorems.eulers_number_item.server;

import net.dctime.lawsandtheorems.LawsAndTheorems;
import net.dctime.lawsandtheorems.register.ModItems;
import net.dctime.lawsandtheorems.register.ModSoundEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraftforge.event.TickEvent.ServerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = LawsAndTheorems.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EulersNumberForgeServerEvent
{
    @SubscribeEvent
    public static void eulersNumberItemEntityInWorld(ServerTickEvent event)
    {
        for (ServerLevel level : event.getServer().getAllLevels())
        {
            if (!level.isClientSide())
            {
                for (Entity entity : level.getAllEntities())
                {
                    if (entity instanceof ItemEntity && ((ItemEntity) entity).getItem().is(ModItems.THE_NUMBER_E.get()))
                    {
                        if ((int)(Math.random()*1000) == 0)
                        {
                            entity.playSound(ModSoundEvents.EULARS_NUMBER_BURNING.get());
                        }
                    }
                }
            }
        }
    }
}
