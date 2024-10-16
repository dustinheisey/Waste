package com.inconvenientdev.waste.block;

import static com.inconvenientdev.waste.Waste.REGISTRATE;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MaterialColor;

public class ModBlocks {

  public static final BlockEntry<Block> WASTE = REGISTRATE.get().block("waste", Block::new)
    .initialProperties(() -> Blocks.GRAVEL)
    .simpleItem()
    .properties(p -> p.color(MaterialColor.COLOR_LIGHT_GRAY)
        .requiresCorrectToolForDrops()
        .sound(SoundType.GRAVEL))
    .tag(BlockTags.NEEDS_STONE_TOOL)
    .tag(BlockTags.MINEABLE_WITH_SHOVEL)
    .register();

  public static final BlockEntry<Block> DENSE_WASTE = REGISTRATE.get().block("dense_waste", Block::new)
      .initialProperties(() -> Blocks.GRAVEL)
      .simpleItem()
      .properties(p -> p.color(MaterialColor.COLOR_LIGHT_GRAY)
          .requiresCorrectToolForDrops()
          .sound(SoundType.GRAVEL))
      .tag(BlockTags.NEEDS_STONE_TOOL)
      .tag(BlockTags.MINEABLE_WITH_SHOVEL)
      .register();

  public static final BlockEntry<Block> COMPACTED_WASTE = REGISTRATE.get().block("compacted_waste", Block::new)
      .initialProperties(() -> Blocks.STONE)
      .simpleItem()
      .properties(p -> p.color(MaterialColor.COLOR_LIGHT_GRAY)
          .requiresCorrectToolForDrops()
          .sound(SoundType.STONE))
      .tag(BlockTags.NEEDS_STONE_TOOL)
      .tag(BlockTags.MINEABLE_WITH_PICKAXE)
      .register();

  public static final BlockEntry<Block> ULTRA_COMPACTED_WASTE = REGISTRATE.get().block("ultra_compacted_waste", Block::new)
      .initialProperties(() -> Blocks.DEEPSLATE)
      .simpleItem()
      .properties(p -> p.color(MaterialColor.COLOR_GRAY)
          .requiresCorrectToolForDrops()
          .sound(SoundType.DEEPSLATE))
      .tag(BlockTags.NEEDS_DIAMOND_TOOL)
      .tag(BlockTags.MINEABLE_WITH_PICKAXE)
      .register();

  public static final BlockEntry<Block> SOLID_WASTE = REGISTRATE.get().block("solid_waste", Block::new)
      .initialProperties(() -> Blocks.OBSIDIAN)
      .simpleItem()
      .properties(p -> p.color(MaterialColor.COLOR_BLACK)
          .requiresCorrectToolForDrops()
          .sound(SoundType.DEEPSLATE))
      .tag(BlockTags.NEEDS_DIAMOND_TOOL)
      .tag(BlockTags.MINEABLE_WITH_PICKAXE)
      .register();

  public static void register() {}
}
