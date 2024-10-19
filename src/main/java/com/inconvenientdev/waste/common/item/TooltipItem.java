package com.inconvenientdev.waste.common.item;

import java.util.List;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class TooltipItem extends Item {
  private String tooltip = "";
  private String shiftTooltip = "";
  public TooltipItem(Properties pProperties) {
    super(pProperties);
  }

  public void setTooltip(String tooltip) {
    this.tooltip = tooltip;
  }

  public void setShiftTooltip(String shiftTooltip) {
    this.shiftTooltip = shiftTooltip;
  }

  @Override
  public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
    if(Screen.hasShiftDown()) {
      pTooltipComponents.add(new TranslatableComponent(this.shiftTooltip));
    } else {
      pTooltipComponents.add(new TranslatableComponent(this.tooltip));
      pTooltipComponents.add(new TranslatableComponent("Press SHIFT for more info."));

    }
  }
}
