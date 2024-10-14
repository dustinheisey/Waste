package com.inconvenientdev.waste.datagen.loot;

import com.inconvenientdev.waste.block.ModBlocks;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLoot {

  @Override
  protected void addTables() {
    this.dropSelf(ModBlocks.WASTE.get());
    this.dropSelf(ModBlocks.DENSE_WASTE.get());
    this.dropSelf(ModBlocks.COMPACTED_WASTE.get());
    this.dropSelf(ModBlocks.ULTRA_COMPACTED_WASTE.get());
    this.dropSelf(ModBlocks.SOLID_WASTE.get());
    //    this.add(ModBlocks.CITRINE_ORE.get(),
    //        (block) -> createOreDrop(ModBlocks.CITRINE_ORE.get(), ModItems.RAW_CITRINE.get()));
    //    this.dropOther(ModBlocks.EBONY_WALL_SIGN.get(), ModItems.EBONY_SIGN.get());
  }

  @Override
  protected Iterable<Block> getKnownBlocks() {
    return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
  }
}
