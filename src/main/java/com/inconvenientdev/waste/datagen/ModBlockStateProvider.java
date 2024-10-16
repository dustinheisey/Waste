package com.inconvenientdev.waste.datagen;

import com.inconvenientdev.waste.Waste;
import com.inconvenientdev.waste.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {

  public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
    super(gen, Waste.MOD_ID, exFileHelper);
  }

  @Override
  protected void registerStatesAndModels() {
    // Automatically generate block states for all blocks in ModBlocks except fluid blocks
    ModBlocks.BLOCKS.getEntries()
        .forEach(block -> {
          Block blockInstance = block.get();

          // Check if the block is not a fluid block
          if (!(blockInstance instanceof LiquidBlock)) {
            String blockName = block.getId().getPath();
            simpleBlock(blockInstance);
          }
        });
  }
}
