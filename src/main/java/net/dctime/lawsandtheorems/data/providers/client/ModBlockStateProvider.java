package net.dctime.lawsandtheorems.data.providers.client;

import net.dctime.lawsandtheorems.LawsAndTheorems;
import net.dctime.lawsandtheorems.register.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider
{

    public ModBlockStateProvider(PackOutput output, String modid, ExistingFileHelper exFileHelper)
    {
        super(output, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        ModelFile model = new ModelFile(new ResourceLocation(LawsAndTheorems.MODID, "block/limit_machine_block")) {

            @Override
            protected boolean exists()
            {
                return true;
            }
            
        };
        this.simpleBlock(ModBlocks.LIMIT_MACHINE_BLOCK.get(), model);
    }
}
