package net.dctime.lawsandtheorems.eulers_number_item.client;

import net.dctime.lawsandtheorems.register.ModParticleTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = "lawsandtheorems", value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EularFlameModEvent
{
    @SubscribeEvent
    public static void registerEularFlame(RegisterParticleProvidersEvent event)
    {
        System.out.println("REGISTERED");
        // the second parameter is a functional interface.
        // Types defines the network stuff while provider gives the particles features
        event.register(ModParticleTypes.EULARS_FLAME.get(), EularFlameParticle.Provider::new);
        event.register(ModParticleTypes.IMAGINARY_NUMBER_PARTICLE.get(), EularFlameParticle.Provider::new);
    }


}
