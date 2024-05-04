package net.xstopho.resource_cracker.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.xstopho.resourcelibrary.items.RecipeRemainder;

import java.util.List;

public class CrackHammerItem extends RecipeRemainder {
    public CrackHammerItem(int durability) {
        super(new Properties().durability(durability));
    }

    @Override
    public ItemStack getRemainingItem(ItemStack itemStack) {
        if (itemStack.getDamageValue() < itemStack.getMaxDamage() -1) {
            ItemStack damaged = itemStack.copy();
            damaged.setDamageValue(itemStack.getDamageValue() + 1);
            return damaged;
        }

        return ItemStack.EMPTY;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> tooltip, TooltipFlag tooltipFlag) {
        tooltip.add(Component.translatable("item.crack_hammer.tooltip").withStyle(ChatFormatting.GOLD));

        super.appendHoverText(itemStack, tooltipContext, tooltip, tooltipFlag);
    }
}
