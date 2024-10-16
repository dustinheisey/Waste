package com.inconvenientdev.waste.item;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.inconvenientdev.waste.Waste;
import com.inconvenientdev.waste.fluid.ModFluids;
import com.inconvenientdev.waste.item.custom.TrashPickerItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Waste.MOD_ID);

  public static final Map<RegistryObject<Item>, String> ITEM_LANG_TITLES = new HashMap<>();
  public static final Set<RegistryObject<Item>> ITEMS_WITH_MODELS = new HashSet<>();

  // Register items using a concise method call
  public static final RegistryObject<Item> GARBAGE = registerItem("garbage", "Garbage");
  public static final RegistryObject<Item> AMETHYST_RING = registerItem("amethyst_ring", "Amethyst Ring");
  public static final RegistryObject<Item> BATTERY = registerItem("battery", "Dead Battery");
  public static final RegistryObject<Item> BULLET = registerItem("bullet", "Spent Bullet");
  public static final RegistryObject<Item> CAMERA_FILM = registerItem("camera_film", "Camera Film");
  public static final RegistryObject<Item> CAR_PART = registerItem("car_part", "Car Part");
  public static final RegistryObject<Item> CIRCUIT_BOARD = registerItem("circuit_board", "Circuit Board");
  public static final RegistryObject<Item> COPPER_TUBING = registerItem("copper_tubing", "Copper Tubing");
  public static final RegistryObject<Item> ELECTRICAL_WIRING = registerItem("electrical_wiring", "Electrical Wiring");
  public static final RegistryObject<Item> FORK = registerItem("fork", "Fork");
  public static final RegistryObject<Item> KEY_CHAIN = registerItem("key_chain", "Key Chain");
  public static final RegistryObject<Item> LIGHT_BULB = registerItem("light_bulb", "Broken Light Bulb");
  public static final RegistryObject<Item> MEDICAL_EQUIPMENT = registerItem("medical_equipment", "Syringe");
  public static final RegistryObject<Item> NAIL = registerItem("nail", "Rusty Nail");
  public static final RegistryObject<Item> NECKLACE = registerItem("necklace", "Necklace");
  public static final RegistryObject<Item> PAINT_CAN = registerItem("paint_can", "Rusty Paint Can");
  public static final RegistryObject<Item> PIPE = registerItem("pipe", "Pipe");
  public static final RegistryObject<Item> PLUMBING_JOINT = registerItem("plumbing_joint", "Plumbing Joint");
  public static final RegistryObject<Item> RADIO = registerItem("radio", "Broken Radio");
  public static final RegistryObject<Item> SCRAP_METAL = registerItem("scrap_metal", "Scrap Metal");
  public static final RegistryObject<Item> TIN_CAN = registerItem("tin_can", "Tin Can");
  public static final RegistryObject<Item> TIN_FOIL = registerItem("tin_foil", "Tin Foil");
  public static final RegistryObject<Item> TOY = registerItem("toy", "Old Toy");
  public static final RegistryObject<Item> WATCH = registerItem("watch", "Broken Watch");
  public static final RegistryObject<Item> WRENCH = registerItem("wrench", "Rusty Wrench");

  // Custom Items
  public static final RegistryObject<Item> TRASH_PICKER = registerTrashPickerItem("trash_picker", "Trash Picker");
  public static final RegistryObject<Item> DIRTY_WATER_BUCKET = registerBucketItem("dirty_water_bucket", ModFluids.DIRTY_WATER_FLUID, "Dirty Water");
  public static final RegistryObject<Item> TOXIC_WASTE_BUCKET = registerBucketItem("toxic_waste_bucket", ModFluids.TOXIC_WASTE_FLUID, "Toxic Waste");
  public static final RegistryObject<Item> SLUDGE_BUCKET = registerBucketItem("sludge_bucket", ModFluids.SLUDGE_FLUID, "Sludge");


  // General method to register items
  private static RegistryObject<Item> registerItem(String name, String langTitle) {
    RegistryObject<Item> item = ITEMS.register(name, () ->
      new Item(new Item.Properties().tab(ModCreativeModeTab.WASTE_TAB))
    );
    ITEM_LANG_TITLES.put(item, langTitle);
    ITEMS_WITH_MODELS.add(item);
    return item;
  }

  private static RegistryObject<Item> registerBucketItem(String name, RegistryObject<FlowingFluid> fluid, String langTitle) {
    RegistryObject<Item> item = ITEMS.register(name, () ->
        new BucketItem(fluid,
            new Item.Properties().tab(ModCreativeModeTab.WASTE_TAB).stacksTo(1))
    );

    ITEM_LANG_TITLES.put(item, "Bucket of " + langTitle);
    ITEMS_WITH_MODELS.add(item);
    return item;
  }

  private static RegistryObject<Item> registerTrashPickerItem(String name, String langTitle) {
    RegistryObject<Item> item = ITEMS.register(name, () ->
        new TrashPickerItem(new Item.Properties().tab(ModCreativeModeTab.WASTE_TAB))
    );
    ITEM_LANG_TITLES.put(item, langTitle);
    ITEMS_WITH_MODELS.add(item);
    return item;
  }

  public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
  }
}
