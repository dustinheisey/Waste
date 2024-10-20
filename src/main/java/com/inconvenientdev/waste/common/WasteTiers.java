package com.inconvenientdev.waste.common;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class WasteTiers {
  public static final ForgeTier SCRAP_TIER =
      new ForgeTier(
          1,
          300,
          2.0F,
          1,
          4,
          BlockTags.NEEDS_STONE_TOOL,
          () -> Ingredient.of(WasteItems.SCRAP_METAL.get())
      );
}
