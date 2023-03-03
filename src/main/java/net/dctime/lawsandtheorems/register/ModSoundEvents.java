package net.dctime.lawsandtheorems.register;

import net.dctime.lawsandtheorems.LawsAndTheorems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSoundEvents 
{
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
        DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, LawsAndTheorems.MODID);

    public static final RegistryObject<SoundEvent> EULARS_NUMBER_BURNING = 
        SOUND_EVENTS.register("eulars_number_burning", 
        () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(LawsAndTheorems.MODID, "eulars_number_burning")));

    public static final RegistryObject<SoundEvent> NATURE_LOG_SPLASHING =
        SOUND_EVENTS.register("nature_log_splashing",
        () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(LawsAndTheorems.MODID, "nature_log_splashing")));

    public static final RegistryObject<SoundEvent> MIND_BLOWING = 
        SOUND_EVENTS.register("mind_blowing", 
        () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(LawsAndTheorems.MODID, "mind_blowing")));

    public static void register(IEventBus eventBus)
    {
        SOUND_EVENTS.register(eventBus);
    }
    
}
