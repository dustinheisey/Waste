package com.inconvenientdev.waste.common.item;

import java.util.function.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class TrashItem extends Item {

  private final Supplier<Block> trashBlockSupplier; // Reference to the corresponding block via Supplier

  public TrashItem(Properties properties, Supplier<Block> trashBlockSupplier) {
    super(properties);
    this.trashBlockSupplier = trashBlockSupplier; // Use a Supplier for the block reference
  }

  @Override
  public InteractionResult useOn(UseOnContext context) {
    BlockPos pos = context.getClickedPos();
    Direction direction = context.getClickedFace();
    BlockPos placePos = pos.relative(direction);

    BlockState state = trashBlockSupplier.get().defaultBlockState(); // Get the block from the supplier
    if (context.getLevel().isEmptyBlock(placePos)) {
      context.getLevel().setBlock(placePos, state, 3);
      context.getItemInHand().shrink(1); // Decrease the item stack size by 1
      return InteractionResult.SUCCESS;
    }

    return InteractionResult.FAIL;
  }
}
