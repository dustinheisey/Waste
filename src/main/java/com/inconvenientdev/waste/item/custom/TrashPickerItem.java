package com.inconvenientdev.waste.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class TrashPickerItem extends Item {
  public TrashPickerItem(Properties pProperties) {
    super(pProperties);
  }

  @Override
  public InteractionResult useOn(UseOnContext pContext) {
    if (pContext.getLevel().isClientSide()) {
      return InteractionResult.SUCCESS;
    }

    Player player = pContext.getPlayer();
    BlockPos positionClicked = pContext.getClickedPos();
    BlockState blockState = pContext.getLevel().getBlockState(positionClicked);
    Block blockClicked = blockState.getBlock();

    if (isTrashBlock(blockClicked)) {
      if (player != null) {
        // Instantly mine the block and add it to the player's inventory
        pContext.getLevel().destroyBlock(positionClicked, false); // Destroy block without dropping it
        player.getInventory().add(blockClicked.asItem().getDefaultInstance()); // Add item to player's inventory

        // Optionally, notify the player
        player.sendMessage(new TranslatableComponent("item.inconvenientmod.trash_picker.found_trash"),
            player.getUUID());
      }
      // Damage the trash picker tool
      pContext.getItemInHand().hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(p.getUsedItemHand()));

      return InteractionResult.SUCCESS;
    }

    return InteractionResult.PASS;
  }

  private boolean isTrashBlock(Block block) {
    // List of blocks that the trash picker should instantly mine
    return block == Blocks.DIRT || block == Blocks.GRAVEL || block == Blocks.SAND || block == Blocks.STONE;
    // You can add more blocks relevant to your trash mod here
  }
}
