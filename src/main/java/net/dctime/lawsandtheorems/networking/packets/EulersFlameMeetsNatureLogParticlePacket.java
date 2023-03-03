package net.dctime.lawsandtheorems.networking.packets;


import java.io.IOException;
import java.util.Optional;
import java.util.function.Supplier;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.dctime.lawsandtheorems.register.ModSoundEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.sounds.SoundSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;

public class EulersFlameMeetsNatureLogParticlePacket
{
    private static final Logger logger = LogUtils.getLogger();
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
            // Make sure its on the PHYSICAL client
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
                Minecraft minecraft = Minecraft.getInstance();
                // level might be null
                // if null it will yell loudly
                Optional<ClientLevel> serverLevel = Optional.of(minecraft.level);
                serverLevel.get().playLocalSound(x, y, z, ModSoundEvents.MIND_BLOWING.get(), SoundSource.PLAYERS, 1, 1, false);
            });
        });

        context.get().setPacketHandled(true);
    }
}
