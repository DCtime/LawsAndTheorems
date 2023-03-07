package net.dctime.lawsandtheorems.networking;

import net.dctime.lawsandtheorems.networking.packets.EulersFlameMeetsNatureLogParticlePacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModNetworkHandler
{
    private static final String PROTOCOL_VERSION = "1";
    private static int id = 0;
    public static final SimpleChannel CHANNEL_INSTANCE = NetworkRegistry.newSimpleChannel
    (
        new ResourceLocation("lawsandtheorems", "network"),
        () -> PROTOCOL_VERSION,
        PROTOCOL_VERSION::equals,
        PROTOCOL_VERSION::equals
    ); 
    
    public static void init()
    {
        CHANNEL_INSTANCE.registerMessage
        (
            id++,
            EulersFlameMeetsNatureLogParticlePacket.class,
            // EulersFlameMeetsNatureLogParticlePacket::encode
            // equals
            // (EulersFlameMeetsNatureLogParticlePacket object, FriendlyTypeBuff buffer) -> object.encode(buffer)
            EulersFlameMeetsNatureLogParticlePacket::encode,
            EulersFlameMeetsNatureLogParticlePacket::new,
            EulersFlameMeetsNatureLogParticlePacket::handling
        );
    }
}
