package com.inconvenientdev.waste.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {

  public static final CreativeModeTab WASTE_TAB = new CreativeModeTab(
    "wastetab"
  ) {
    @Override
    public ItemStack makeIcon() {
      return new ItemStack(ModItems.GARBAGE.get());
    }
  };
}
