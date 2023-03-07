package net.dctime.lawsandtheorems.register;

import net.dctime.lawsandtheorems.register.citeria.ModCriteriaTrigger;
import net.minecraft.advancements.CriteriaTriggers;

public class ModTriggers 
{
    public static final ModCriteriaTrigger EULERS_NUMBER_MEET_NATURE_LOG = new ModCriteriaTrigger("eulers_number_meet_nature_log");

    public static void init()
    {
        CriteriaTriggers.register(EULERS_NUMBER_MEET_NATURE_LOG);
    }
    
    
}
