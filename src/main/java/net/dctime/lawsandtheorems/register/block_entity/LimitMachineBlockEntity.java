package net.dctime.lawsandtheorems.register.block_entity;

import net.dctime.lawsandtheorems.register.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class LimitMachineBlockEntity extends BlockEntity
{
    public LimitMachineBlockEntity(BlockPos pPos, BlockState pBlockState)
    {
        super(ModBlockEntityTypes.LIMIT_MACHINE_BLOCK_ENTITY.get(), pPos, pBlockState);
    }
    
}
