package net.dctime.lawsandtheorems.networking.packets;


import java.util.function.Supplier;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;

public class EulersFlameMeetsNatureLogParticlePacket
{
    private double x;
    private double y;
    private double z;

    public EulersFlameMeetsNatureLogParticlePacket(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public EulersFlameMeetsNatureLogParticlePacket(FriendlyByteBuf buffer)
    {
        this.x = buffer.readDouble();
        this.y = buffer.readDouble();
        this.z = buffer.readDouble();
    }

    public void encode(FriendlyByteBuf buffer)
    {
        buffer.writeDouble(x);
        buffer.writeDouble(y);
        buffer.writeDouble(z);
    }
    
    public void handling(Supplier<NetworkEvent.Context> context)
    {
        context.get().enqueueWork(() -> 
        {
            // TODO: This works but unsafeRunWhenOn is dead, test where is runs
            System.out.println("AH");
            // Make sure its on the PHYSICAL client
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> EulersFlameMeetsNatureLogParticlePacket.ClientPacket.handlePacket(context, x, y, z));
        });

        context.get().setPacketHandled(true);
    }

    protected class ClientPacket
    {
        public static void handlePacket(Supplier<NetworkEvent.Context> context, double x, double y, double z)
        {
            // Client Side
            context.get().getSender().level.addAlwaysVisibleParticle(ParticleTypes.SMOKE, false, x, y, z, 0, 0, 0);
            
        }
    }
}
