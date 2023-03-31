package net.dctime.lawsandtheorems.register.block_entity.block_renderer;

import javax.annotation.Nullable;

import net.dctime.lawsandtheorems.register.block_entity.LimitMachineBlockEntity;
import net.dctime.lawsandtheorems.register.geckolib_model.LimitMachineBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class LimitMachineBlockRenderer extends GeoBlockRenderer<LimitMachineBlockEntity>
{

    public LimitMachineBlockRenderer()
    {
        super(new LimitMachineBlockModel());
    }

    @Override
    public RenderType getRenderType(LimitMachineBlockEntity animatable, ResourceLocation texture,
            @Nullable MultiBufferSource bufferSource, float partialTick)
    {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }
    
}
