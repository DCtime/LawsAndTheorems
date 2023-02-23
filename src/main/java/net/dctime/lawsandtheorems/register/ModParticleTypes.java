package net.dctime.lawsandtheorems.register;

import net.dctime.lawsandtheorems.LawsAndTheorems;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticleTypes
{
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPE_DEFERRED_REGISTER =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, LawsAndTheorems.MODID);

    public static final SimpleParticleType EULARS_FLAME_SIMPLE_PARTICLE_TYPE
            = new SimpleParticleType(true);
    public static final SimpleParticleType IMAGINARY_NUMBER_SIMPLE_PARTICLE_TYPE =
            new SimpleParticleType(true);

    public static final RegistryObject<ParticleType<SimpleParticleType>> EULARS_FLAME =
            PARTICLE_TYPE_DEFERRED_REGISTER.register("eulars_flame_particle", () -> EULARS_FLAME_SIMPLE_PARTICLE_TYPE);
    public static final RegistryObject<ParticleType<SimpleParticleType>> IMAGINARY_NUMBER_PARTICLE =
            PARTICLE_TYPE_DEFERRED_REGISTER.register("imaginary_number_particle", () -> IMAGINARY_NUMBER_SIMPLE_PARTICLE_TYPE);

    public static void register(IEventBus eventBus)
    {
        PARTICLE_TYPE_DEFERRED_REGISTER.register(eventBus);
    }
}
