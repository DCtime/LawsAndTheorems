package net.dctime.lawsandtheorems.data.providers;

import net.dctime.lawsandtheorems.register.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class ModEnUsLanguageProvider extends LanguageProvider
{

    public ModEnUsLanguageProvider(PackOutput output, String modid, String locale)
    {
        super(output, modid, locale);
    }

    @Override
    protected void addTranslations()
    {
        this.add(ModItems.THE_NUMBER_E.get(), "Euler's Number");
        this.add(ModItems.NATURE_LOG.get(), "Nature Log");
    }
    
}
