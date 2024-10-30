package net.xstopho.resource_cracker.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

public class RecipeProv extends RecipeProvider implements IConditionBuilder {


    public RecipeProv(HolderLookup.Provider p_360573_, RecipeOutput p_360872_) {
        super(p_360573_, p_360872_);
    }

    static ICondition[] getConditions(ICondition... conditions) {
        ICondition[] con = new ICondition[conditions.length];
        System.arraycopy(conditions, 0, con, 0, con.length);
        return con;
    }

    @Override
    protected void buildRecipes() {

    }
}