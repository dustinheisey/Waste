package com.inconvenientdev.waste.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TrashBlock extends Block {

  // Define a 1-pixel-high voxel shape for trash blocks
  private static final VoxelShape SHAPE = Shapes.box(0, 0, 0, 1, 1 / 16.0, 1); // 1-pixel height


  public TrashBlock(Properties properties) {
    super(properties);
  }

  @Override
  public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
    return SHAPE;
  }
}
