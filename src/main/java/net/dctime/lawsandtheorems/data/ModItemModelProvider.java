package net.dctime.lawsandtheorems.data;

import net.dctime.lawsandtheorems.register.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider
{

    public ModItemModelProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper)
    {
        super(output, modid, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        this.basicItem(ModItems.THE_NUMBER_E.get());
        this.basicItem(ModItems.NATURE_LOG.get());
    }
    
}
