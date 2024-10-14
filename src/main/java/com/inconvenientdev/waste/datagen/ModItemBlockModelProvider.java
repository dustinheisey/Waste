package com.inconvenientdev.waste.datagen;

import com.inconvenientdev.waste.Waste;
import com.inconvenientdev.waste.block.ModBlocks;
import java.util.function.Supplier;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemBlockModelProvider extends ItemModelProvider {

  public ModItemBlockModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
    super(generator, Waste.MOD_ID, existingFileHelper); // Replace with your actual mod ID
  }

  @Override
  protected void registerModels() {
    // Automatically generate item block models for all blocks stored in BLOCKS_WITH_ITEM_MODELS
    ModBlocks.BLOCKS_WITH_ITEM_MODELS.forEach(this::itemBlockModel);
  }

  // Utility method to create item models for blocks
  private void itemBlockModel(Supplier<? extends Block> blockSupplier) {
    String blockName = blockSupplier.get().getRegistryName().getPath();
    withExistingParent(blockName, modLoc("block/" + blockName));
  }
}
