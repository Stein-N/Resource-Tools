package net.xstopho.resource_cracker.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class ScytheItem extends SwordItem {
    public static final UUID BASE_ATTACK_KNOCKBACK_UUID = UUID.nameUUIDFromBytes("BASE_ATTACK_KNOCKBACK_UUID".getBytes());
    private static final int radius = 1;

    public ScytheItem(Tier tier, int attackDamage, float attackSpeed) {
        super(tier, attackDamage, attackSpeed, new Properties());

    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (context.getPlayer() == null) return InteractionResult.PASS;
        Player player = context.getPlayer();

        if (player.isSpectator() || player.isCreative()) return InteractionResult.PASS;

        BlockPos clickedPos = context.getClickedPos();
        BlockState clickedState = context.getLevel().getBlockState(clickedPos);

        if (clickedState.getBlock() instanceof CropBlock clickedCrop && clickedCrop.isMaxAge(clickedState)) {
            for (int x = -radius; x <= radius; x++) {
                for (int z = -radius; z <= radius; z++) {
                    BlockPos crop = clickedPos.offset(x, 0, z);
                    BlockState cropState = context.getLevel().getBlockState(crop);
                    if (cropState.getBlock() instanceof CropBlock replantCrop && replantCrop.isMaxAge(cropState)) {
                        context.getLevel().destroyBlock(crop, true, player);
                        context.getLevel().setBlockAndUpdate(crop, replantCrop.getStateForAge(0));
                    }
                }
            }
            context.getItemInHand().hurtAndBreak(1, player, entity -> entity.broadcastBreakEvent(entity.getUsedItemHand()));
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> attributes = ImmutableMultimap.builder();
        attributes.putAll(super.getDefaultAttributeModifiers(slot));
        attributes.put(Attributes.ATTACK_KNOCKBACK, new AttributeModifier(BASE_ATTACK_KNOCKBACK_UUID, "bonus", 1, AttributeModifier.Operation.ADDITION));
        return slot == EquipmentSlot.MAINHAND ? attributes.build() : super.getDefaultAttributeModifiers(slot);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag tooltipFlag) {
        tooltip.add(Component.translatable("item.scythe.tooltip").withStyle(ChatFormatting.GOLD));
        tooltip.add(Component.translatable("item.scythe.tooltip.radius").withStyle(ChatFormatting.GOLD)
                .append(Component.literal(String.valueOf(radius)).withStyle(ChatFormatting.RED)));

        super.appendHoverText(stack, level, tooltip, tooltipFlag);
    }
}
