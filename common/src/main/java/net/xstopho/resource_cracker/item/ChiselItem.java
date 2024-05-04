package net.xstopho.resource_cracker.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.xstopho.resource_cracker.config.CrackerConfig;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;

public class ChiselItem extends Item {
    public static final Random rnd = new Random();

    public ChiselItem(int durability) {
        super(new Properties().durability(durability));
    }

    @NotNull
    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (context.getPlayer() == null) return InteractionResult.FAIL;

        Block block = context.getLevel().getBlockState(context.getClickedPos()).getBlock();
        BlockPos pos = context.getClickedPos().relative(context.getClickedFace());

        if (block.equals(Blocks.BRICKS) && rnd.nextFloat() <= CrackerConfig.SALTPETER_FROM_BRICKS.get()) {
            Containers.dropItemStack(context.getLevel(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemRegistry.MATERIAL_DUST_SALTPETER.get()));
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
