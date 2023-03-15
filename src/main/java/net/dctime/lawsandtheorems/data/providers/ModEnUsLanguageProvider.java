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

        this.add("sounds.lawsandtheorems.eulers_number_burning.subtitle", "Eulers Number Burning");
        this.add("sounds.lawsandtheorems.nature_log_splashing.subtitle", "Nature Log Splashing");
        this.add("sounds.lawsandtheorems.mind_blowing.subtitle", "Mind Blowing");
        this.add("item_group.lawsandtheorems.creativemodtab", "Laws and Theorems");
        this.add("advancement.lawsandtheorems.letter_from_nowhere.title", "Letters From Nowhere");
        this.add("advancement.lawsandtheorems.letter_from_nowhere.description", "Solve a problem by using e^lnx = x");
    }
    
}
