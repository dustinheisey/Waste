package com.inconvenientdev.waste.block;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import com.inconvenientdev.waste.Waste;
import com.inconvenientdev.waste.item.ModCreativeModeTab;
import com.inconvenientdev.waste.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Waste.MOD_ID);

  // Sets and Maps to track block data for various providers
  public static final Set<Supplier<? extends Block>> BLOCKS_WITH_ITEM_MODELS = new HashSet<>();
  public static final Set<Supplier<? extends Block>> BLOCKS_FOR_BLOCKSTATES = new HashSet<>();
  public static final Set<Supplier<? extends Block>> BLOCKS_FOR_LOOT_TABLES = new HashSet<>();
  public static final Map<RegistryObject<Block>, String> BLOCK_LANG_TITLES = new HashMap<>();
  public static final Map<Supplier<? extends Block>, ToolData> TOOL_DATA = new HashMap<>();

  // Register blocks using a helper method for reuse
  public static final RegistryObject<Block> WASTE = registerBlock(
    "waste",
    "Waste",
    Material.DIRT,
    0.4f,
    ModCreativeModeTab.WASTE_TAB,
    "shovel",
    null
  );
  public static final RegistryObject<Block> DENSE_WASTE = registerBlock(
    "dense_waste",
    "Dense Waste",
    Material.STONE,
    0.5f,
    ModCreativeModeTab.WASTE_TAB,
    "pickaxe",
    "stone"
  );
  public static final RegistryObject<Block> COMPACTED_WASTE = registerBlock(
    "compacted_waste",
    "Compacted Waste",
    Material.STONE,
    0.7f,
    ModCreativeModeTab.WASTE_TAB,
    "pickaxe",
    "iron"
  );
  public static final RegistryObject<Block> ULTRA_COMPACTED_WASTE = registerBlock(
    "ultra_compacted_waste",
    "Ultra Compacted Waste",
    Material.STONE,
    0.8f,
    ModCreativeModeTab.WASTE_TAB,
    "pickaxe",
    "diamond"
  );
  public static final RegistryObject<Block> SOLID_WASTE = registerBlock(
    "solid_waste",
    "Solid Waste",
    Material.STONE,
    1.0f,
    ModCreativeModeTab.WASTE_TAB,
    "pickaxe",
    "diamond"
  );

  // Overloaded block registration method, handles tool, mining level, and adds blocks to various sets
  private static <T extends Block> RegistryObject<T> registerBlock(
    String name,
    String langTitle,
    Material material,
    float strength,
    CreativeModeTab tab,
    String tool,
    String miningLevel
  ) {
    RegistryObject<T> block = (RegistryObject<T>) registerBlock(name, () -> new Block(BlockBehaviour.Properties.of(material).strength(strength)), tab);

    // Add block to respective data tracking sets
    BLOCKS_WITH_ITEM_MODELS.add(block); // Track blocks for item block models
    BLOCKS_FOR_BLOCKSTATES.add(block); // Track blocks for blockstates
    BLOCKS_FOR_LOOT_TABLES.add(block); // Track blocks for loot tables
    BLOCK_LANG_TITLES.put((RegistryObject<Block>) block, langTitle); // Track blocks for lang generation
    TOOL_DATA.put(block, new ToolData(tool, miningLevel)); // Store tool and mining level data

    return block;
  }

  // Generic block registration helper
  private static <T extends Block> RegistryObject<T> registerBlock(
    String name,
    Supplier<T> block,
    CreativeModeTab tab
  ) {
    RegistryObject<T> toReturn = BLOCKS.register(name, block);
    registerBlockItem(name, toReturn, tab);
    return toReturn;
  }

  // BlockItem registration
  private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
    ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
  }

  public static void register(IEventBus eventBus) {
    BLOCKS.register(eventBus);
  }

  // Class to store tool and mining level data
  public static class ToolData {

    public final String tool;
    public final String miningLevel;

    public ToolData(String tool, String miningLevel) {
      this.tool = tool;
      this.miningLevel = miningLevel;
    }
  }
}
