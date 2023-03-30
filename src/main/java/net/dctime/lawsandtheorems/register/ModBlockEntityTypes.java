package net.dctime.lawsandtheorems.register;

import net.dctime.lawsandtheorems.LawsAndTheorems;
import net.dctime.lawsandtheorems.register.block_entity.LimitMachineBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntityTypes
{
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPE_DEFERRED_REGISTER = 
        DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, LawsAndTheorems.MODID);

    public static final RegistryObject<BlockEntityType<LimitMachineBlockEntity>> LIMIT_MACHINE_BLOCK_ENTITY =
        BLOCK_ENTITY_TYPE_DEFERRED_REGISTER.register("limit_machine_block_entity_type",
         () -> BlockEntityType.Builder.of(LimitMachineBlockEntity::new, ModBlocks.LIMIT_MACHINE_BLOCK.get()).build(null));
    
    public static void register(IEventBus eventBus)
    {
        BLOCK_ENTITY_TYPE_DEFERRED_REGISTER.register(eventBus);
    }
}
