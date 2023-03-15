package net.dctime.lawsandtheorems.event.nature_log_item.client;

import net.dctime.lawsandtheorems.LawsAndTheorems;
import net.dctime.lawsandtheorems.register.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = LawsAndTheorems.MODID, value = Dist.CLIENT, bus = Bus.FORGE)
public class NatureLogForgeClientEvents
{
    @SubscribeEvent
    public static void NatureLogItemThrown(EntityEvent event)
    {
        if (event.getEntity() instanceof ItemEntity)
        {
            ItemEntity itemEntity = (ItemEntity) event.getEntity();
            if (itemEntity.level.isClientSide() && itemEntity.getItem().is(ModItems.NATURE_LOG.get()) && itemEntity.getAge() > 50)
            {
                itemEntity.level.addAlwaysVisibleParticle
                (
                    ParticleTypes.FALLING_WATER,
                    true,
                    itemEntity.getX(),
                    itemEntity.getY(),
                    itemEntity.getZ(),
                    0,
                    0,
                    0
                );
            }
        }

    }
}
