package net.dctime.lawsandtheorems.register.geckolib_model;

import net.dctime.lawsandtheorems.LawsAndTheorems;
import net.dctime.lawsandtheorems.register.block_entity.LimitMachineBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class LimitMachineBlockModel extends GeoModel<LimitMachineBlockEntity>
{
    private static final ResourceLocation MODEL_LOCATION = new ResourceLocation(LawsAndTheorems.MODID, "geo/limit_machine_block.geo.json");
    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(LawsAndTheorems.MODID, "textures/block/limit_machine_block.png");
    private static final ResourceLocation ANIMATION_LOCATION = new ResourceLocation(LawsAndTheorems.MODID, "animations/limit_machine_block.animation.json");

    @Override
    public ResourceLocation getModelResource(LimitMachineBlockEntity animatable)
    {
        return MODEL_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(LimitMachineBlockEntity animatable)
    {
        return TEXTURE_LOCATION;
    }

    @Override
    public ResourceLocation getAnimationResource(LimitMachineBlockEntity animatable)
    {
        return ANIMATION_LOCATION;
    }
    
}
