package com.inconvenientdev.waste.common;

import java.util.function.Supplier;

import static com.inconvenientdev.waste.Waste.REGISTRATE;

import com.inconvenientdev.waste.common.item.FuelItem;
import com.inconvenientdev.waste.common.item.TooltipItem;
import com.inconvenientdev.waste.common.item.TrashItem;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class WasteItems {
  // Simple
  public static final ItemEntry<Item>
      FILTER_CASING = simple("filter_casing"),
      CHARCOAL_FILTER = simple("charcoal_filter"),
      LEATHER_FACEPLATE = simple("leather_faceplate"),
      LEATHER_STRAPS = simple("leather_straps"),
      BROKEN_GOGGLES = simple("broken_goggles"),
      GARBAGE = simple("garbage");

  // Tooltip
  public static final ItemEntry<TooltipItem>
      LEATHER_GAS_MASK = tooltip(
      "leather_gas_mask",
      "Leather Gas Mask",
      "A protective mask crafted from leather.",
      "Allows you to breathe in the industrial waste biome without taking damage.\nUse it to explore hazardous areas safely."
  );

  // Trash
  public static final ItemEntry<TrashItem>
      AMETHYST_RING = trash("amethyst_ring", () -> WasteBlocks.AMETHYST_RING_BLOCK.get()),
      BATTERY = trash("battery", () -> WasteBlocks.BATTERY_BLOCK.get()),
      BULLET = trash("bullet", () -> WasteBlocks.BULLET_BLOCK.get()),
      CAMERA_FILM = trash("film", () -> WasteBlocks.FILM_BLOCK.get()),
      CAR_PART = trash("car_part", () -> WasteBlocks.CAR_PART_BLOCK.get()),
      CIRCUIT_BOARD = trash("circuit_board", () -> WasteBlocks.CIRCUIT_BOARD_BLOCK.get()),
      COPPER_TUBING = trash("copper_tubing", () -> WasteBlocks.COPPER_TUBING_BLOCK.get()),
      ELECTRICAL_WIRE = trash("electrical_wire", () -> WasteBlocks.ELECTRICAL_WIRE_BLOCK.get()),
      FORK = trash("fork", () -> WasteBlocks.FORK_BLOCK.get()),
      KEY_CHAIN = trash("key_chain", () -> WasteBlocks.KEY_CHAIN_BLOCK.get()),
      LIGHT_BULB = trash("light_bulb", () -> WasteBlocks.LIGHT_BULB_BLOCK.get()),
      SYRINGE = trash("syringe", () -> WasteBlocks.SYRINGE_BLOCK.get()),
      NAIL = trash("nail", () -> WasteBlocks.NAIL_BLOCK.get()),
      NECKLACE = trash("necklace", () -> WasteBlocks.NECKLACE_BLOCK.get()),
      PAINT_CAN = trash("paint_can", () -> WasteBlocks.PAINT_CAN_BLOCK.get()),
      PIPE = trash("pipe", () -> WasteBlocks.PIPE_BLOCK.get()),
      PLUMBING_JOINT = trash("plumbing_joint", () -> WasteBlocks.PLUMBING_JOINT_BLOCK.get()),
      RADIO = trash("radio", () -> WasteBlocks.RADIO_BLOCK.get()),
      SCRAP_METAL = trash("scrap_metal", () -> WasteBlocks.SCRAP_METAL_BLOCK.get()),
      TIN_CAN = trash("tin_can", () -> WasteBlocks.TIN_CAN_BLOCK.get()),
      TIN_FOIL = trash("tin_foil", () -> WasteBlocks.TIN_FOIL_BLOCK.get()),
      TOY = trash("toy", () -> WasteBlocks.TOY_BLOCK.get()),
      WATCH = trash("watch", () -> WasteBlocks.WATCH_BLOCK.get()),
      WRENCH = trash("wrench", () -> WasteBlocks.WRENCH_BLOCK.get());

  // Armors
  public static final ItemEntry<ArmorItem>[]
      SCRAP_ARMORS = armor("scrap", WasteArmors.SCRAP);

  // Foods
  public static final ItemEntry<Item>
    JERKY = food("jerky", 3, 0.3F, "Zombie Jerky");

  // Fuel Items
  public static ItemEntry<FuelItem>
      OLD_TIRE = fuel("old_tire", 32000, "Old Tire"),
      OILY_RAG = fuel("oily_rag", 64000, "Oily Rag");


  // Helper Methods
  private static ItemEntry<Item> simple(String name) {
    return REGISTRATE.get().item(name, Item::new)
        .register();
  }
  private static ItemEntry<Item> simple(String name, String langTitle) {
    return REGISTRATE.get().item(name, Item::new)
        .lang(langTitle)
        .register();
  }

  private static ItemEntry<TooltipItem> tooltip(String name, String langTitle, String tooltip, String shiftTooltip) {
    return REGISTRATE.get().item(name, TooltipItem::new)
        .onRegister(i -> i.setTooltip(tooltip))
        .onRegister(i -> i.setShiftTooltip(shiftTooltip))
        .lang(langTitle)
        .register();
  }

  private static ItemEntry<FuelItem> fuel(String name, int burnTime) {
    return REGISTRATE.get().item(name, FuelItem::new)
        .onRegister(i -> i.setBurnTime(burnTime))
        .register();
  }
  private static ItemEntry<FuelItem> fuel(String name, int burnTime, String langTitle) {
    return REGISTRATE.get().item(name, FuelItem::new)
        .onRegister(i -> i.setBurnTime(burnTime))
        .lang(langTitle)
        .register();
  }

  private static ItemEntry<ArmorItem>[] armor(String name, ArmorMaterial armor) {
    ItemEntry<ArmorItem> HELMET = REGISTRATE.get()
        .item(name + "_helmet", props -> new ArmorItem(armor, EquipmentSlot.HEAD, props))
        .register();
    ItemEntry<ArmorItem> CHESTPLATE = REGISTRATE.get()
        .item(name + "_chestplate", props -> new ArmorItem(armor, EquipmentSlot.CHEST, props))
        .register();
    ItemEntry<ArmorItem> LEGGINGS = REGISTRATE.get()
        .item(name + "_leggings", props -> new ArmorItem(armor, EquipmentSlot.LEGS, props))
        .register();
    ItemEntry<ArmorItem> BOOTS = REGISTRATE.get()
        .item(name + "_boots", props -> new ArmorItem(armor, EquipmentSlot.FEET, props))
        .register();

    return new ItemEntry[]{HELMET, CHESTPLATE, LEGGINGS, BOOTS};
  }

  public static ItemEntry<TrashItem> trash(String name, Supplier<Block> blockSupplier) {
    return REGISTRATE.get().item(name, props -> new TrashItem(props, blockSupplier)).register();
  }
  public static ItemEntry<Item> food(String name, int nutrition, float saturation, String langTitle) {
    return REGISTRATE.get().item(name, Item::new)
        .properties(p -> p.food(new FoodProperties.Builder().nutrition(nutrition)
            .saturationMod(saturation)
            .build()))
        .lang(langTitle)
        .register();
  }

  public static void register() {}
}
