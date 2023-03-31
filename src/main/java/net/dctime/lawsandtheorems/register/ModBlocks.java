package net.dctime.lawsandtheorems.register;

import net.dctime.lawsandtheorems.LawsAndTheorems;
import net.dctime.lawsandtheorems.register.block.LimitMachineBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCK_DEFERRED_REGISTER =
        DeferredRegister.create(ForgeRegistries.BLOCKS, LawsAndTheorems.MODID);

    public static final RegistryObject<Block> LIMIT_MACHINE_BLOCK = 
        BLOCK_DEFERRED_REGISTER.register("limit_machine_block", () -> new LimitMachineBlock(Properties.of(Material.METAL).noOcclusion()));

    public static void register(IEventBus eventBus)
    {
        BLOCK_DEFERRED_REGISTER.register(eventBus);
    }
}
