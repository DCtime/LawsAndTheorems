package net.dctime.lawsandtheorems.register.block;

import javax.annotation.Nullable;

import net.dctime.lawsandtheorems.register.block_entity.LimitMachineBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class LimitMachineBlock extends Block implements EntityBlock
{
    public LimitMachineBlock(Properties pProperties)
    {
        super(pProperties);
    }

    @Override
    @Nullable
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState)
    {
        return new LimitMachineBlockEntity(pPos, pState);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState)
    {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }
}
