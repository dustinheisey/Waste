package com.inconvenientdev.waste.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class GarbageBlock extends Block {
  public GarbageBlock(Properties properties) {
    super(properties);
  }

  @Override
  public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
    if(!pLevel.isClientSide()) {
      if(pEntity instanceof LivingEntity livingEntity) {
        if(!livingEntity.hasItemInSlot(EquipmentSlot.FEET)) {
        livingEntity.hurt(new DamageSource("StepOnGarbage"), 1);
        }
      }
    }
    super.stepOn(pLevel, pPos, pState, pEntity);
  }
}
