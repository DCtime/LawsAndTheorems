package net.dctime.lawsandtheorems.nature_log_item.server;


import java.util.List;

import net.dctime.lawsandtheorems.LawsAndTheorems;
import net.dctime.lawsandtheorems.networking.ModNetworkHandler;
import net.dctime.lawsandtheorems.networking.packets.EulersFlameMeetsNatureLogParticlePacket;
import net.dctime.lawsandtheorems.register.ModItems;
import net.dctime.lawsandtheorems.register.ModSoundEvents;
import net.dctime.lawsandtheorems.register.ModTriggers;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.TickEvent.ServerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.PacketDistributor;

@Mod.EventBusSubscriber(modid = LawsAndTheorems.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class NatureLogForgeServerEvent
{
    @SubscribeEvent
    public static void natureLogItemEntityInWorld(ServerTickEvent event)
    {
        for (ServerLevel level : event.getServer().getAllLevels())
        {
            if (!level.isClientSide())
            {
                for (Entity entity : level.getAllEntities())
                {
                    if (entity instanceof ItemEntity && ((ItemEntity) entity).getItem().is(ModItems.NATURE_LOG.get()))
                    {
                        if ((int)(Math.random()*100) == 0)
                        {
                            entity.playSound(ModSoundEvents.NATURE_LOG_SPLASHING.get());
                        }
                        
                        List<Entity> nearbyEntities = entity.level.getEntities
                        (
                            entity,
                            new AABB(entity.getX()-0.3, entity.getY()-0.3, entity.getZ()-0.3, entity.getX()+0.3, entity.getY()+0.3, entity.getZ()+0.3),
                            (player) -> true
                        );

                        for (int index = 0; index < nearbyEntities.size(); index++)
                        {
                            if (nearbyEntities.get(index) instanceof ItemEntity && ((ItemEntity)nearbyEntities.get(index)).getItem().is(ModItems.THE_NUMBER_E.get()))
                            {
                                Entity targetEntity = nearbyEntities.get(index);
                                if (targetEntity.getLevel() instanceof ServerLevel)
                                {
                                    ServerLevel serverLevel = (ServerLevel) targetEntity.getLevel();
                                    serverLevel.sendParticles(ParticleTypes.SONIC_BOOM, entity.getX(), entity.getY()+1, entity.getZ(), 1, 0, 0, 0, 0);
                                    serverLevel.sendParticles(ParticleTypes.FLASH, entity.getX(), entity.getY()+1, entity.getZ(), 1, 0, 0, 0, 0);
                                    for (int counter = 0; counter < 100; counter++)
                                    {
                                        serverLevel.sendParticles(ParticleTypes.DRAGON_BREATH, entity.getX()-1.5+Math.random()*3, entity.getY()+1+Math.random()*3, entity.getZ()-1.5+Math.random()*3, 1, 
                                            Math.random(), Math.random(), Math.random(), Math.random());
                                    }
                                    
                                }

                                ItemEntity eulers_number_in_reaction = ((ItemEntity) nearbyEntities.get(index));
                                ItemStack eulers_number_after_reaction = eulers_number_in_reaction.copy().getItem();
                                eulers_number_after_reaction.shrink(1);
                                eulers_number_in_reaction.setItem(eulers_number_after_reaction);

                                ItemEntity natural_log_in_reaction = ((ItemEntity) entity);
                                ItemStack natural_log_after_reaction = natural_log_in_reaction.copy().getItem();
                                natural_log_after_reaction.shrink(1);
                                natural_log_in_reaction.setItem(natural_log_after_reaction);

                                if (((ItemEntity) entity).getThrowingEntity() instanceof ServerPlayer)
                                {
                                    ServerPlayer player;
                                    player = ((ServerPlayer)((ItemEntity) entity).getThrowingEntity());
                                    ModNetworkHandler.CHANNEL_INSTANCE.send(PacketDistributor.PLAYER.with(() -> player),
                                        new EulersFlameMeetsNatureLogParticlePacket(player.getX(), player.getY(), player.getZ()));

                                    ModTriggers.EULERS_NUMBER_MEET_NATURE_LOG.trigger(player);
                                }
                            }
                        }
                        
                    }
                }
            }
        }
    }
}
