package net.dctime.lawsandtheorems.data.providers.client;

import net.dctime.lawsandtheorems.LawsAndTheorems;
import net.dctime.lawsandtheorems.register.ModBlocks;
import net.dctime.lawsandtheorems.register.block.LimitMachineBlock;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider
{
    ModelFile model = new ModelFile(new ResourceLocation(LawsAndTheorems.MODID, "block/limit_machine_block")) {

        @Override
        protected boolean exists()
        {
            return true;
        }
        
    };

    public ModBlockStateProvider(PackOutput output, String modid, ExistingFileHelper exFileHelper)
    {
        super(output, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        this.simpleBlockItem(ModBlocks.LIMIT_MACHINE_BLOCK.get(), model);

        this.getVariantBuilder(ModBlocks.LIMIT_MACHINE_BLOCK.get())
            .partialState()
            .with(LimitMachineBlock.FACING, Direction.NORTH)
                .modelForState()
                .modelFile(model)
                .addModel();

        this.getVariantBuilder(ModBlocks.LIMIT_MACHINE_BLOCK.get())
            .partialState()
            .with(LimitMachineBlock.FACING, Direction.WEST)
                .modelForState()
                .modelFile(model)
                .rotationY(90)
                .addModel();
        
        this.getVariantBuilder(ModBlocks.LIMIT_MACHINE_BLOCK.get())
            .partialState()
            .with(LimitMachineBlock.FACING, Direction.SOUTH)
                .modelForState()
                .modelFile(model)
                .rotationY(180)
                .addModel();
                
        this.getVariantBuilder(ModBlocks.LIMIT_MACHINE_BLOCK.get())
            .partialState()
            .with(LimitMachineBlock.FACING, Direction.EAST)
                .modelForState()
                .modelFile(model)
                .rotationY(270)
                .addModel();
    }
}
