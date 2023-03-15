package net.dctime.lawsandtheorems.data.providers;

import net.dctime.lawsandtheorems.register.ModSoundEvents;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

public class ModSoundDefinitionProvider extends SoundDefinitionsProvider
{

    public ModSoundDefinitionProvider(PackOutput output, String modId, ExistingFileHelper helper)
    {
        super(output, modId, helper);
    }

    @Override
    public void registerSounds()
    {
        this.add(ModSoundEvents.EULARS_NUMBER_BURNING, definition().subtitle("Euler's Number Burning").with
        (
            sound("lawsandtheorems:eulers_number_burning/eulars_number_burning_1")
            .weight(1000),
            sound("lawsandtheorems:eulers_number_burning/eulars_number_burning_2")
            .weight(1000),
            sound("lawsandtheorems:eulers_number_burning/eulars_number_burning_3")
            .weight(1000),
            sound("lawsandtheorems:eulers_number_burning/eulars_number_burning_4")
            .weight(1000),
            sound("lawsandtheorems:eulers_number_burning/eulars_number_burning_5")
            .weight(1000),
            sound("lawsandtheorems:eulers_number_burning/eulars_number_burning_yee")
            .weight(1)
        ));

        this.add(ModSoundEvents.NATURE_LOG_SPLASHING, definition().subtitle("Nature Log Splashing").with
        (
            sound("lawsandtheorems:nature_log_splashing/nature_log_splashing_1"),
            sound("lawsandtheorems:nature_log_splashing/nature_log_splashing_2"),
            sound("lawsandtheorems:nature_log_splashing/nature_log_splashing_3"),
            sound("lawsandtheorems:nature_log_splashing/nature_log_splashing_4"),
            sound("lawsandtheorems:nature_log_splashing/nature_log_splashing_5") 
        ));

        this.add(ModSoundEvents.MIND_BLOWING, definition().subtitle("Mind Blowing").with
        (
            sound("lawsandtheorems:mind_blowing/mind_blowing_1"),
            sound("lawsandtheorems:mind_blowing/mind_blowing_2"),
            sound("lawsandtheorems:mind_blowing/mind_blowing_3"),
            sound("lawsandtheorems:mind_blowing/mind_blowing_4"),
            sound("lawsandtheorems:mind_blowing/mind_blowing_5")
        ));
    }
}
