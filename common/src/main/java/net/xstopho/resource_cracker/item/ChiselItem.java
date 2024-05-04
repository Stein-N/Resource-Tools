package net.xstopho.resource_cracker.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;

public class ChiselItem extends Item {
    public static final Random rnd = new Random();

    public ChiselItem(Properties properties) {
        super(properties);
    }

    @NotNull
    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (context.getPlayer() == null) return InteractionResult.FAIL;

        Block block = context.getLevel().getBlockState(context.getClickedPos()).getBlock();
        BlockPos pos = context.getClickedPos().relative(context.getClickedFace());

        //TODO: Add Config Value
        //TODO: Add Saltpeter as drop when implemented
        if (block.equals(Blocks.BRICKS) && rnd.nextFloat() <= .5f) {
            Containers.dropItemStack(context.getLevel(), pos.getX(), pos.getY(), pos.getZ(), Items.DIAMOND.getDefaultInstance());
        }

        context.getItemInHand().hurtAndBreak(1, context.getPlayer(), EquipmentSlot.MAINHAND);

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext ccontext, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("item.chisel.tooltip").withStyle(ChatFormatting.GOLD));

        super.appendHoverText(stack, ccontext, tooltip, flag);
    }
}
