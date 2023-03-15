package net.dctime.lawsandtheorems.data.providers.server;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import net.dctime.lawsandtheorems.LawsAndTheorems;
import net.dctime.lawsandtheorems.register.ModItems;
import net.dctime.lawsandtheorems.register.citeria.ModCriteriaTrigger;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.EntityPredicate.Composite;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

public class ModAdvancementProvider extends ForgeAdvancementProvider
{
    
    
    public ModAdvancementProvider(PackOutput output, CompletableFuture<Provider> registries,
            ExistingFileHelper existingFileHelper, List<AdvancementGenerator> subProviders)
    {
        super(output, registries, existingFileHelper, subProviders);
    }

    public static class ModAdvancementGenerator implements ForgeAdvancementProvider.AdvancementGenerator
    {
        @Override
        public void generate(Provider registries, Consumer<Advancement> saver, ExistingFileHelper existingFileHelper)
        {
            Advancement.Builder.advancement().display(
                new DisplayInfo(new ItemStack(ModItems.THE_NUMBER_E.get()),
                Component.translatable("advancement.lawsandtheorems.letter_from_nowhere.title"),
                Component.translatable("advancement.lawsandtheorems.letter_from_nowhere.description"),
                new ResourceLocation("minecraft:textures/block/quartz_block_side.png"),
                FrameType.CHALLENGE,
                true,
                true,
                false
            )).addCriterion(
                "meets",
                // idk why to make it so ugly
                new ModCriteriaTrigger.ModCriteriaTriggerInstance(new ResourceLocation(LawsAndTheorems.MODID, "eulers_number_meet_nature_log"), Composite.ANY)
                ).save(saver, "letters_from_nowhere"); // save file name
        }
    }
}
