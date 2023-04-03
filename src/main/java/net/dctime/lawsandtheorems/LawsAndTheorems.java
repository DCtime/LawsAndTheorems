package net.dctime.lawsandtheorems;

import com.mojang.logging.LogUtils;

import net.dctime.lawsandtheorems.networking.ModNetworkHandler;
import net.dctime.lawsandtheorems.register.ModBlocks;
import net.dctime.lawsandtheorems.register.ModItems;
import net.dctime.lawsandtheorems.register.ModParticleTypes;
import net.dctime.lawsandtheorems.register.ModSoundEvents;
import net.dctime.lawsandtheorems.register.ModTriggers;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(LawsAndTheorems.MODID)
public class LawsAndTheorems
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "lawsandtheorems";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    // This Constructor will be called when forge finds it when minecraft is loading
    public LawsAndTheorems()
    {
        // there are two event buses: ModEventBus(init) and MinecraftForge.EVENT_BUS(idk)

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(modEventBus);
        ModParticleTypes.register(modEventBus);
        ModSoundEvents.register(modEventBus);
        ModBlocks.register(modEventBus);
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    // commonSetup : For actions that are common to both physical client and server
    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        ModNetworkHandler.init();
        event.enqueueWork(() -> {
            ModTriggers.init();
        });
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
