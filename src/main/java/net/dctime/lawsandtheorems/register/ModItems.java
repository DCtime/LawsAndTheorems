package net.dctime.lawsandtheorems.register;

import net.dctime.lawsandtheorems.LawsAndTheorems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> ITEM_DEFERRED_REGISTER =
            DeferredRegister.create(ForgeRegistries.ITEMS, LawsAndTheorems.MODID);

    public static final RegistryObject<Item> THE_NUMBER_E =
        ITEM_DEFERRED_REGISTER.register("the_number_e", () -> new Item(
            new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> NATURE_LOG = 
        ITEM_DEFERRED_REGISTER.register("nature_log", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON)));

    public static void register(IEventBus eventBus)
    {
        ITEM_DEFERRED_REGISTER.register(eventBus);
    }
}
