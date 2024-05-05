package net.xstopho.resource_cracker.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.xstopho.resource_cracker.block.base.SpringBlock;

public class WaterSpringBlock extends SpringBlock {

    public WaterSpringBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        Item itemInHand = player.getItemInHand(hand).getItem();

        if (itemInHand.equals(Items.BUCKET) && !player.isCreative()) return addOrDropItem(player, new ItemStack(Items.WATER_BUCKET));
        if (itemInHand.equals(Items.GLASS_BOTTLE) && !player.isCreative()) return addOrDropItem(player, PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER));

        return InteractionResult.PASS;
    }
}
