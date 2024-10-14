package com.inconvenientdev.waste.item;

import com.inconvenientdev.waste.Waste;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
    ForgeRegistries.ITEMS,
    Waste.MOD_ID
  );

  public static final RegistryObject<Item> GARBAGE = ITEMS.register(
    "garbage",
    () -> new Item(new Item.Properties().tab(ModCreativeModeTab.WASTE_TAB))
  );

  public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
  }
}
