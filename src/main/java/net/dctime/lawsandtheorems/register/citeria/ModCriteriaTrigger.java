package net.dctime.lawsandtheorems.register.citeria;

import com.google.gson.JsonObject;

import net.dctime.lawsandtheorems.LawsAndTheorems;
import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.SerializationContext;
import net.minecraft.advancements.critereon.EntityPredicate.Composite;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public class ModCriteriaTrigger extends SimpleCriterionTrigger<ModCriteriaTrigger.ModCriteriaTriggerInstance> {

    private ResourceLocation ID;

    public ModCriteriaTrigger(String name)
    {
        ID = new ResourceLocation(LawsAndTheorems.MODID, name);
    }

    @Override
    public ResourceLocation getId()
    {
        return ID;
    }

    @Override
    protected ModCriteriaTrigger.ModCriteriaTriggerInstance createInstance(JsonObject pJson, Composite pPlayer,
            DeserializationContext pContext)
    {
        return new ModCriteriaTriggerInstance(ID, pPlayer);
    }

    public void trigger(ServerPlayer player)
    {
        this.trigger(player, triggerInstance -> true);
    }

    public static class ModCriteriaTriggerInstance extends AbstractCriterionTriggerInstance
    {

        public ModCriteriaTriggerInstance(ResourceLocation pCriterion, Composite pPlayer)
        {
            super(pCriterion, pPlayer);
        }

        @Override
        public JsonObject serializeToJson(SerializationContext pConditions)
        {
            return super.serializeToJson(pConditions);
        }
        
    }
    
}
