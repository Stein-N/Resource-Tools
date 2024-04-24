package net.xstopho.resource_cracker.food;

import net.minecraft.world.food.FoodProperties;

public class ConstantFoodProperties {
    public static final FoodProperties GARLIC = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f).build();
    public static final FoodProperties BEEF_JERKY = new FoodProperties.Builder().nutrition(8).saturationModifier(0.5f).build();
}
