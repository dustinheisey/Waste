package com.inconvenientdev.waste.datagen;

import com.inconvenientdev.waste.Waste;
import com.inconvenientdev.waste.block.ModBlocks;
import java.util.Map;
import java.util.function.Supplier;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider {

  public ModBlockTagsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
    super(generator, Waste.MOD_ID, existingFileHelper); // Replace with your actual mod ID
  }

  @Override
  protected void addTags() {
    // Automatically generate tags based on the tool and mining level data from ModBlocks
    for (Map.Entry<Supplier<? extends Block>, ModBlocks.ToolData> entry : ModBlocks.TOOL_DATA.entrySet()) {
      Supplier<? extends Block> blockSupplier = entry.getKey();
      ModBlocks.ToolData toolData = entry.getValue();
      addBlockTag(blockSupplier, toolData.tool, toolData.miningLevel);
    }
  }

  // Unified function for adding blocks to both the tool and mining level tags
  private void addBlockTag(Supplier<? extends Block> blockSupplier, String tool, String miningLevel) {
    // Add the block to the correct tool tag
    switch (tool) {
      case "pickaxe":
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(blockSupplier.get());
        break;
      case "axe":
        tag(BlockTags.MINEABLE_WITH_AXE).add(blockSupplier.get());
        break;
      case "shovel":
        tag(BlockTags.MINEABLE_WITH_SHOVEL).add(blockSupplier.get());
        break;
      case "hoe":
        tag(BlockTags.MINEABLE_WITH_HOE).add(blockSupplier.get());
        break;
      default:
        throw new IllegalArgumentException("Invalid tool type: " + tool);
    }

    // Set the block's mining level if it's provided
    if (miningLevel != null) {
      setMiningLevel(blockSupplier, miningLevel);
    }
  }

  // Helper method to set the required mining level
  private void setMiningLevel(Supplier<? extends Block> blockSupplier, String miningLevel) {
    switch (miningLevel) {
      case "stone":
        tag(BlockTags.NEEDS_STONE_TOOL).add(blockSupplier.get());
        break;
      case "iron":
        tag(BlockTags.NEEDS_IRON_TOOL).add(blockSupplier.get());
        break;
      case "diamond":
        tag(BlockTags.NEEDS_DIAMOND_TOOL).add(blockSupplier.get());
        break;
      default:
        throw new IllegalArgumentException("Invalid mining level: " + miningLevel);
    }
  }
}
