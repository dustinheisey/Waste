package com.inconvenientdev.waste.item;

import static com.inconvenientdev.waste.Waste.REGISTRATE;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

public class ModItems {

  public static final ItemEntry<Item> GARBAGE = REGISTRATE.get().item("garbage", Item::new).register();
  public static final ItemEntry<Item> AMETHYST_RING = REGISTRATE.get().item("amethyst_ring", Item::new).register();
  public static final ItemEntry<Item> BATTERY = REGISTRATE.get().item("battery", Item::new).register();
  public static final ItemEntry<Item> BULLET = REGISTRATE.get().item("bullet", Item::new).register();
  public static final ItemEntry<Item> CAMERA_FILM = REGISTRATE.get().item("camera_film", Item::new).register();
  public static final ItemEntry<Item> CAR_PART = REGISTRATE.get().item("car_part", Item::new).register();
  public static final ItemEntry<Item> CIRCUIT_BOARD = REGISTRATE.get().item("circuit_board", Item::new).register();
  public static final ItemEntry<Item> COPPER_TUBING = REGISTRATE.get().item("copper_tubing", Item::new).register();
  public static final ItemEntry<Item> ELECTRICAL_WIRING = REGISTRATE.get().item("electrical_wiring", Item::new).register();
  public static final ItemEntry<Item> FORK = REGISTRATE.get().item("fork", Item::new).register();
  public static final ItemEntry<Item> KEY_CHAIN = REGISTRATE.get().item("key_chain", Item::new).register();
  public static final ItemEntry<Item> LIGHT_BULB = REGISTRATE.get().item("light_bulb", Item::new).register();
  public static final ItemEntry<Item> MEDICAL_EQUIPMENT = REGISTRATE.get().item("medical_equipment", Item::new).register();
  public static final ItemEntry<Item> NAIL = REGISTRATE.get().item("nail", Item::new).register();
  public static final ItemEntry<Item> NECKLACE = REGISTRATE.get().item("necklace", Item::new).register();
  public static final ItemEntry<Item> PAINT_CAN = REGISTRATE.get().item("paint_can", Item::new).register();
  public static final ItemEntry<Item> PIPE = REGISTRATE.get().item("pipe", Item::new).register();
  public static final ItemEntry<Item> PLUMBING_JOINT = REGISTRATE.get().item("plumbing_joint", Item::new).register();
  public static final ItemEntry<Item> RADIO = REGISTRATE.get().item("radio", Item::new).register();
  public static final ItemEntry<Item> SCRAP_METAL = REGISTRATE.get().item("scrap_metal", Item::new).register();
  public static final ItemEntry<Item> TIN_CAN = REGISTRATE.get().item("tin_can", Item::new).register();
  public static final ItemEntry<Item> TIN_FOIL = REGISTRATE.get().item("tin_foil", Item::new).register();
  public static final ItemEntry<Item> TOY = REGISTRATE.get().item("toy", Item::new).register();
  public static final ItemEntry<Item> WATCH = REGISTRATE.get().item("watch", Item::new).register();
  public static final ItemEntry<Item> WRENCH = REGISTRATE.get().item("wrench", Item::new).register();

  // Scrap Armor
  public static final ItemEntry<Item> SCRAP_HELMET = REGISTRATE.get().item("scrap_helmet", Item::new).register();
  public static final ItemEntry<Item> SCRAP_CHESTPLATE = REGISTRATE.get().item("scrap_chestplate", Item::new).register();
  public static final ItemEntry<Item> SCRAP_LEGGINGS = REGISTRATE.get().item("scrap_leggings", Item::new).register();
  public static final ItemEntry<Item> SCRAP_BOOTS = REGISTRATE.get().item("scrap_boots", Item::new).register();

  // Gas Mask
  public static final ItemEntry<Item> FILTER_CASING = REGISTRATE.get().item("filter_casing", Item::new).register();
  public static final ItemEntry<Item> CHARCOAL_FILTER = REGISTRATE.get().item("charcoal_filter", Item::new).register();
  public static final ItemEntry<Item> LEATHER_FACEPLATE = REGISTRATE.get().item("leather_faceplate", Item::new).register();
  public static final ItemEntry<Item> LEATHER_STRAPS = REGISTRATE.get().item("leather_straps", Item::new).register();
  public static final ItemEntry<Item> BROKEN_GOGGLES = REGISTRATE.get().item("broken_goggles", Item::new).register();
  public static final ItemEntry<Item> LEATHER_GAS_MASK = REGISTRATE.get().item("leather_gas_mask", Item::new).register();

  public static void register() {}
}
