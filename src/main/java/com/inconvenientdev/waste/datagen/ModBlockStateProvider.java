package com.inconvenientdev.waste.datagen;

import com.inconvenientdev.waste.Waste;
import com.inconvenientdev.waste.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {

  public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
    super(gen, Waste.MOD_ID, exFileHelper);
  }

  @Override
  protected void registerStatesAndModels() {
    // Automatically generate block states for all blocks in ModBlocks
    ModBlocks.BLOCKS.getEntries()
      .forEach(block -> {
        String blockName = block.getId().getPath();
        simpleBlock(block.get());
      });
  }
}
