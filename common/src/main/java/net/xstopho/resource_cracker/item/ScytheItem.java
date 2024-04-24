package net.xstopho.resource_cracker.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.xstopho.resource_cracker.config.Config;

import java.util.List;
import java.util.UUID;

public class ScytheItem extends SwordItem {
    public static final UUID BASE_ENTITY_REACH_UUID = UUID.nameUUIDFromBytes("BASE_ENTITY_INTERACTION_RANGE_UUID".getBytes());
    public static final UUID BASE_BLOCK_REACH_UUID = UUID.nameUUIDFromBytes("BASE_BLOCK_INTERACTION_REACH_UUID".getBytes());
    private static final int radius = Config.SCYTHE_RADIUS.get();

    public ScytheItem(Tier tier, int attackDamage, float attackSpeed) {
        super(tier, new Properties()
                .attributes(createAttributes(tier, attackDamage, attackSpeed)
                        .withModifierAdded(Attributes.BLOCK_INTERACTION_RANGE, new AttributeModifier(BASE_BLOCK_REACH_UUID, "bonus", 1,
                                AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                        .withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE, new AttributeModifier(BASE_ENTITY_REACH_UUID, "bonus", 1,
                                AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        assert context.getPlayer() != null;
        Player player = context.getPlayer();

        if (player.isSpectator() || player.isCreative()) {
            return InteractionResult.PASS;
        }

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
            context.getItemInHand().hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
            return InteractionResult.SUCCESS;
        }

        return  InteractionResult.PASS;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> tooltip, TooltipFlag tooltipFlag) {
        tooltip.add(Component.translatable("item.scythe.tooltip").withStyle(ChatFormatting.GOLD));
        tooltip.add(Component.translatable("item.scythe.tooltip.radius").withStyle(ChatFormatting.GOLD)
                .append(Component.literal(String.valueOf(radius)).withStyle(ChatFormatting.RED)));

        super.appendHoverText(itemStack, tooltipContext, tooltip, tooltipFlag);
    }
}
