package com.inconvenientdev.waste.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RustyCabinetBlock extends Block {

  private static final VoxelShape SHAPE = Shapes.box(0, 0, 0, 1, 1, 1); // Full block, adjust for different shape

  public RustyCabinetBlock(Properties properties) {
    super(properties);
  }

  @Override
  public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
    return SHAPE;
  }

  // Implement additional behavior, like storage functionality
}
