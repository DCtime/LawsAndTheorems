package net.dctime.lawsandtheorems;

import net.dctime.lawsandtheorems.register.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = LawsAndTheorems.MODID, bus = Bus.MOD)
public class ModCreativeModTabEvent
{
    @SubscribeEvent
    public static void makeCreativeModTab(CreativeModeTabEvent.Register event)
    {
        event.registerCreativeModeTab(new ResourceLocation(LawsAndTheorems.MODID, "creativemodtab"), (builder) -> 
            builder.title(Component.translatable("item_group." + LawsAndTheorems.MODID + ".creativemodtab"))
            .icon(() -> new ItemStack(ModItems.THE_NUMBER_E.get()))
            .displayItems((pEnableFeatures, pOutput, pDisplayOperatorCreativeTab) -> 
            {
                pOutput.accept(ModItems.NATURE_LOG.get());
                pOutput.accept(ModItems.THE_NUMBER_E.get());
            })
        );
    }
}