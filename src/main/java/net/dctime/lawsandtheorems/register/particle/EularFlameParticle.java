package net.dctime.lawsandtheorems.register.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.Nullable;

public class EularFlameParticle extends TextureSheetParticle
{
    protected EularFlameParticle(ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed, SpriteSet spriteSet)
    {
        super(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed);

        this.friction = 0.8F;
        this.xd = pXSpeed;
        this.yd = pYSpeed;
        this.zd = pZSpeed;
        this.quadSize *= 0.85f;
        this.lifetime = 20;
        setSpriteFromAge(spriteSet);
        pickSprite(spriteSet);
        setAlpha(1);

    }

    @Override
    public void tick()
    {
        super.tick();
        setAlpha(1-(float)age/getLifetime());
    }

    @Override
    public ParticleRenderType getRenderType()
    {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    // The Provider provides the particles rendering features
    public static class Provider implements ParticleProvider<SimpleParticleType>
    {
        private final SpriteSet spriteSet;
        public Provider(SpriteSet spriteSet)
        {
            this.spriteSet = spriteSet;
        }

        @Nullable
        @Override
        public Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed)
        {
            return new EularFlameParticle(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed, spriteSet);
        }
    }
}
