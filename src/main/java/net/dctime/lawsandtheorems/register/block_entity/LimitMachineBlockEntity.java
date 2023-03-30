package net.dctime.lawsandtheorems.register.block_entity;

import net.dctime.lawsandtheorems.register.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager.ControllerRegistrar;
import software.bernie.geckolib.util.GeckoLibUtil;

public class LimitMachineBlockEntity extends BlockEntity implements GeoBlockEntity
{
    private final AnimatableInstanceCache CACHE = GeckoLibUtil.createInstanceCache(this);

    public LimitMachineBlockEntity(BlockPos pPos, BlockState pBlockState)
    {
        super(ModBlockEntityTypes.LIMIT_MACHINE_BLOCK_ENTITY.get(), pPos, pBlockState);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache()
    {
        return this.CACHE;
    }

    @Override
    public void registerControllers(ControllerRegistrar arg0)
    {
        //TODO
    }
    
}
