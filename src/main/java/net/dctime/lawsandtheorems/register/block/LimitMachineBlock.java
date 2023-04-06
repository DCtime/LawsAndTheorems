package net.dctime.lawsandtheorems.register.block;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public class LimitMachineBlock extends Block
{
    public static final DirectionProperty FACING = DirectionProperty.create("direction", Direction.Plane.HORIZONTAL);
    
    public LimitMachineBlock(Properties pProperties)
    {
        super(pProperties);
        this.registerDefaultState(
            this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
        );
    }

    @Override
    protected void createBlockStateDefinition(Builder<Block, BlockState> pBuilder)
    {
        super.createBlockStateDefinition(pBuilder);

        pBuilder.add(FACING);
    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer,
            ItemStack pStack)
    {
        super.setPlacedBy(pLevel, pPos, pState, pPlacer, pStack);

        if (pPlacer != null)
        {
            System.out.println("States:" + pState.getValue(FACING));
            System.out.println("X:" + pPos.getX() + ", Z:" + pPos.getZ());
            System.out.println("X:" + pPlacer.getX() + ", Z:" + pPlacer.getZ());

            // Z big => north
            // Z small => SOUTH 
            // X big => EAST
            // X small => WEST
            float x_distance = Math.abs((float)pPlacer.getX() - pPos.getX());
            float z_distance = Math.abs((float)pPlacer.getZ() - pPos.getZ());

            if (z_distance > x_distance)
            {
                if (pPlacer.getZ() < pPos.getZ())
                {
                    pLevel.setBlockAndUpdate(pPos, pState.setValue(FACING, Direction.NORTH));
                }
                else
                {
                    pLevel.setBlockAndUpdate(pPos, pState.setValue(FACING, Direction.SOUTH));
                }
            }
            else
            {
                if (pPlacer.getX() < pPos.getX())
                {
                    pLevel.setBlockAndUpdate(pPos, pState.setValue(FACING, Direction.EAST));
                }
                else
                {
                    pLevel.setBlockAndUpdate(pPos, pState.setValue(FACING, Direction.WEST));
                }
            }
        }
    }
}
