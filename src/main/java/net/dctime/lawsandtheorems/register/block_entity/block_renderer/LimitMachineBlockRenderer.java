package net.dctime.lawsandtheorems.register.block_entity.block_renderer;

import net.dctime.lawsandtheorems.register.block_entity.LimitMachineBlockEntity;
import net.dctime.lawsandtheorems.register.geckolib_model.LimitMachineBlockModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class LimitMachineBlockRenderer extends GeoBlockRenderer<LimitMachineBlockEntity>
{

    public LimitMachineBlockRenderer()
    {
        super(new LimitMachineBlockModel());
    }
    
}
