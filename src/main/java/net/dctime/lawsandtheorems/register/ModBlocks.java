package net.dctime.lawsandtheorems.register;

import net.dctime.lawsandtheorems.LawsAndTheorems;
import net.dctime.lawsandtheorems.register.block.LimitMachineBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks
{
    public static final DeferredRegister<Block> DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, LawsAndTheorems.MODID);

    public static final RegistryObject<Block> LIMIT_MACHINE_BLOCK = DEFERRED_REGISTER.register("limit_machine_block",
        () -> new LimitMachineBlock(BlockBehaviour.Properties.of(Material.STONE).noOcclusion()));
 
    public static void register(IEventBus eventBus)
    {
        DEFERRED_REGISTER.register(eventBus);
    }

}
