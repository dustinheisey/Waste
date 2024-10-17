package com.inconvenientdev.waste.item;

import java.util.function.Supplier;

import static com.inconvenientdev.waste.Waste.REGISTRATE;

import com.inconvenientdev.waste.block.ModBlocks;
import com.inconvenientdev.waste.item.custom.TrashItem;
import com.inconvenientdev.waste.item.custom.armor.ModArmorMaterials;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModItems {

  public static final ItemEntry<TrashItem> AMETHYST_RING = registerTrashItem("amethyst_ring", () -> ModBlocks.AMETHYST_RING_BLOCK.get());
  public static final ItemEntry<TrashItem> BATTERY = registerTrashItem("battery", () -> ModBlocks.BATTERY_BLOCK.get());
  public static final ItemEntry<TrashItem> BULLET = registerTrashItem("bullet", () -> ModBlocks.BULLET_BLOCK.get());
  public static final ItemEntry<TrashItem> CAMERA_FILM = registerTrashItem("film", () -> ModBlocks.FILM_BLOCK.get());
  public static final ItemEntry<TrashItem> CAR_PART = registerTrashItem("car_part", () -> ModBlocks.CAR_PART_BLOCK.get());
  public static final ItemEntry<TrashItem> CIRCUIT_BOARD = registerTrashItem("circuit_board", () -> ModBlocks.CIRCUIT_BOARD_BLOCK.get());
  public static final ItemEntry<TrashItem> COPPER_TUBING = registerTrashItem("copper_tubing", () -> ModBlocks.COPPER_TUBING_BLOCK.get());
  public static final ItemEntry<TrashItem> ELECTRICAL_WIRE = registerTrashItem("electrical_wire", () -> ModBlocks.ELECTRICAL_WIRE_BLOCK.get());
  public static final ItemEntry<TrashItem> FORK = registerTrashItem("fork", () -> ModBlocks.FORK_BLOCK.get());
  public static final ItemEntry<TrashItem> KEY_CHAIN = registerTrashItem("key_chain", () -> ModBlocks.KEY_CHAIN_BLOCK.get());
  public static final ItemEntry<TrashItem> LIGHT_BULB = registerTrashItem("light_bulb", () -> ModBlocks.LIGHT_BULB_BLOCK.get());
  public static final ItemEntry<TrashItem> SYRINGE = registerTrashItem("syringe", () -> ModBlocks.SYRINGE_BLOCK.get());
  public static final ItemEntry<TrashItem> NAIL = registerTrashItem("nail", () -> ModBlocks.NAIL_BLOCK.get());
  public static final ItemEntry<TrashItem> NECKLACE = registerTrashItem("necklace", () -> ModBlocks.NECKLACE_BLOCK.get());
  public static final ItemEntry<TrashItem> PAINT_CAN = registerTrashItem("paint_can", () -> ModBlocks.PAINT_CAN_BLOCK.get());
  public static final ItemEntry<TrashItem> PIPE = registerTrashItem("pipe", () -> ModBlocks.PIPE_BLOCK.get());
  public static final ItemEntry<TrashItem> PLUMBING_JOINT = registerTrashItem("plumbing_joint", () -> ModBlocks.PLUMBING_JOINT_BLOCK.get());
  public static final ItemEntry<TrashItem> RADIO = registerTrashItem("radio", () -> ModBlocks.RADIO_BLOCK.get());
  public static final ItemEntry<TrashItem> SCRAP_METAL = registerTrashItem("scrap_metal", () -> ModBlocks.SCRAP_METAL_BLOCK.get());
  public static final ItemEntry<TrashItem> TIN_CAN = registerTrashItem("tin_can", () -> ModBlocks.TIN_CAN_BLOCK.get());
  public static final ItemEntry<TrashItem> TIN_FOIL = registerTrashItem("tin_foil", () -> ModBlocks.TIN_FOIL_BLOCK.get());
  public static final ItemEntry<TrashItem> TOY = registerTrashItem("toy", () -> ModBlocks.TOY_BLOCK.get());
  public static final ItemEntry<TrashItem> WATCH = registerTrashItem("watch", () -> ModBlocks.WATCH_BLOCK.get());
  public static final ItemEntry<TrashItem> WRENCH = registerTrashItem("wrench", () -> ModBlocks.WRENCH_BLOCK.get());

  public static final ItemEntry<Item> GARBAGE = REGISTRATE.get().item("garbage", Item::new).register();

  // Scrap Armor
  public static final ItemEntry<ArmorItem> SCRAP_HELMET = REGISTRATE.get()
      .item("scrap_helmet", props -> new ArmorItem(ModArmorMaterials.SCRAP, EquipmentSlot.HEAD, props))
      .register();

  public static final ItemEntry<ArmorItem> SCRAP_CHESTPLATE = REGISTRATE.get()
      .item("scrap_chestplate", props -> new ArmorItem(ModArmorMaterials.SCRAP, EquipmentSlot.CHEST, props))
      .register();

  public static final ItemEntry<ArmorItem> SCRAP_LEGGINGS = REGISTRATE.get()
      .item("scrap_leggings", props -> new ArmorItem(ModArmorMaterials.SCRAP, EquipmentSlot.LEGS, props))
      .register();

  public static final ItemEntry<ArmorItem> SCRAP_BOOTS = REGISTRATE.get()
      .item("scrap_boots", props -> new ArmorItem(ModArmorMaterials.SCRAP, EquipmentSlot.FEET, props))
      .register();
  // Gas Mask
  public static final ItemEntry<Item> FILTER_CASING = REGISTRATE.get().item("filter_casing", Item::new).register();
  public static final ItemEntry<Item> CHARCOAL_FILTER = REGISTRATE.get().item("charcoal_filter", Item::new).register();
  public static final ItemEntry<Item> LEATHER_FACEPLATE = REGISTRATE.get().item("leather_faceplate", Item::new).register();
  public static final ItemEntry<Item> LEATHER_STRAPS = REGISTRATE.get().item("leather_straps", Item::new).register();
  public static final ItemEntry<Item> BROKEN_GOGGLES = REGISTRATE.get().item("broken_goggles", Item::new).register();
  public static final ItemEntry<Item> LEATHER_GAS_MASK = REGISTRATE.get().item("leather_gas_mask", Item::new).register();

  public static ItemEntry<TrashItem> registerTrashItem(String name, Supplier<Block> blockSupplier) {
    return REGISTRATE.get().item(name, props -> new TrashItem(props, blockSupplier)).register();
  }

  public static void register() {}
}
