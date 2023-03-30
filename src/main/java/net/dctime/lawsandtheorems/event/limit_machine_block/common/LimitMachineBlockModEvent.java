package net.dctime.lawsandtheorems.event.limit_machine_block.common;

import net.dctime.lawsandtheorems.register.ModBlockEntityTypes;
import net.dctime.lawsandtheorems.register.block_entity.block_renderer.LimitMachineBlockRenderer;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "lawsandtheorems", bus = Mod.EventBusSubscriber.Bus.MOD)
public class LimitMachineBlockModEvent
{
    @SubscribeEvent
    public static void registerLimitMachineBlockRendererEvent(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerBlockEntityRenderer(ModBlockEntityTypes.LIMIT_MACHINE_BLOCK_ENTITY.get(), ctx -> new LimitMachineBlockRenderer());
    }
}
