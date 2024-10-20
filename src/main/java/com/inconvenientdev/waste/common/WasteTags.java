package com.inconvenientdev.waste.common;

import com.inconvenientdev.waste.Waste;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class WasteTags {
  public static class Blocks {
    public static final TagKey<Block> WASTE = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(Waste.MOD_ID, "waste"));
  }

  public static class Items {
    public static final TagKey<Item> TRASH = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Waste.MOD_ID, "trash"));
  }
}
