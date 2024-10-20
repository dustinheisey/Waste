package com.inconvenientdev.waste.common;

import java.util.function.Supplier;

import static com.inconvenientdev.waste.Waste.REGISTRATE;

import com.inconvenientdev.waste.common.block.*;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.client.model.generators.ConfiguredModel;

public class WasteBlocks {

  public static final BlockEntry<TrashBlock> AMETHYST_RING_BLOCK = registerTrash("amethyst_ring_block", () -> WasteItems.AMETHYST_RING.get());
  public static final BlockEntry<TrashBlock> BATTERY_BLOCK = registerTrash("battery_block", () -> WasteItems.BATTERY.get());
  public static final BlockEntry<TrashBlock> BULLET_BLOCK = registerTrash("bullet_block", () -> WasteItems.BULLET.get());
  public static final BlockEntry<TrashBlock> FILM_BLOCK = registerTrash("film_block", () -> WasteItems.CAMERA_FILM.get());
  public static final BlockEntry<TrashBlock> CAR_PART_BLOCK = registerTrash("car_part_block", () -> WasteItems.CAR_PART.get());
  public static final BlockEntry<TrashBlock> CIRCUIT_BOARD_BLOCK = registerTrash("circuit_board_block", () -> WasteItems.CIRCUIT_BOARD.get());
  public static final BlockEntry<TrashBlock> COPPER_TUBING_BLOCK = registerTrash("copper_tubing_block", () -> WasteItems.COPPER_TUBING.get());
  public static final BlockEntry<TrashBlock> ELECTRICAL_WIRE_BLOCK = registerTrash("electrical_wire_block", () -> WasteItems.ELECTRICAL_WIRE.get());
  public static final BlockEntry<TrashBlock> FORK_BLOCK = registerTrash("fork_block", () -> WasteItems.FORK.get());
  public static final BlockEntry<TrashBlock> KEY_CHAIN_BLOCK = registerTrash("key_chain_block", () -> WasteItems.KEY_CHAIN.get());
  public static final BlockEntry<TrashBlock> LIGHT_BULB_BLOCK = registerTrash("light_bulb_block", () -> WasteItems.LIGHT_BULB.get());
  public static final BlockEntry<TrashBlock> SYRINGE_BLOCK = registerTrash("syringe_block", () -> WasteItems.SYRINGE.get());
  public static final BlockEntry<TrashBlock> NAIL_BLOCK = registerTrash("nail_block", () -> WasteItems.NAIL.get());
  public static final BlockEntry<TrashBlock> NECKLACE_BLOCK = registerTrash("necklace_block", () -> WasteItems.NECKLACE.get());
  public static final BlockEntry<TrashBlock> PAINT_CAN_BLOCK = registerTrash("paint_can_block", () -> WasteItems.PAINT_CAN.get());
  public static final BlockEntry<TrashBlock> PIPE_BLOCK = registerTrash("pipe_block", () -> WasteItems.PIPE.get());
  public static final BlockEntry<TrashBlock> PLUMBING_JOINT_BLOCK = registerTrash("plumbing_joint_block", () -> WasteItems.PLUMBING_JOINT.get());
  public static final BlockEntry<TrashBlock> RADIO_BLOCK = registerTrash("radio_block", () -> WasteItems.RADIO.get());
  public static final BlockEntry<TrashBlock> SCRAP_METAL_BLOCK = registerTrash("scrap_metal_block", () -> WasteItems.SCRAP_METAL.get());
  public static final BlockEntry<TrashBlock> TIN_CAN_BLOCK = registerTrash("tin_can_block", () -> WasteItems.TIN_CAN.get());
  public static final BlockEntry<TrashBlock> TIN_FOIL_BLOCK = registerTrash("tin_foil_block", () -> WasteItems.TIN_FOIL.get());
  public static final BlockEntry<TrashBlock> WRENCH_BLOCK = registerTrash("wrench_block", () -> WasteItems.WRENCH.get());
  public static final BlockEntry<TrashBlock> WATCH_BLOCK = registerTrash("watch_block", () -> WasteItems.WATCH.get());
  public static final BlockEntry<TrashBlock> TOY_BLOCK = registerTrash("toy_block", () -> WasteItems.TOY.get());

  public static final BlockEntry<RustyCabinetBlock> RUSTY_CABINET = REGISTRATE.get().block("rusty_cabinet", RustyCabinetBlock::new)
      .initialProperties(() -> Blocks.CHEST)
      .blockstate((ctx, prov) -> prov.getVariantBuilder(ctx.get()).forAllStates(state -> {
        return ConfiguredModel.builder()
            .modelFile(prov.models()
                .withExistingParent("rusty_cabinet", prov.mcLoc("block/cube"))
                .texture("particle", prov.modLoc("block/rusty_cabinet_front")) // Particle texture (front)
                .texture("down", prov.modLoc("block/rusty_cabinet_side")) // Bottom
                .texture("up", prov.modLoc("block/rusty_cabinet_side"))   // Top
                .texture("north", prov.modLoc("block/rusty_cabinet_front")) // Front
                .texture("south", prov.modLoc("block/rusty_cabinet_side"))  // Back
                .texture("west", prov.modLoc("block/rusty_cabinet_side"))   // Left side
                .texture("east", prov.modLoc("block/rusty_cabinet_side")))  // Right side
            .build();
      }))
      .simpleItem()
      .properties(p -> p.strength(2.0f).sound(SoundType.WOOD))
      .register();

  public static final BlockEntry<AbandonedCrateBlock> ABANDONED_CRATE = REGISTRATE.get().block("abandoned_crate", AbandonedCrateBlock::new)
      .initialProperties(() -> Blocks.GRAVEL)
      .simpleItem()
      .properties(p -> p.color(MaterialColor.COLOR_LIGHT_GRAY)
          .requiresCorrectToolForDrops()
          .sound(SoundType.GRAVEL))
      .tag(BlockTags.NEEDS_STONE_TOOL)
      .tag(BlockTags.MINEABLE_WITH_SHOVEL)
      .register();

  public static final BlockEntry<TimeCapsuleBlock> TIME_CAPSULE = REGISTRATE.get().block("time_capsule", TimeCapsuleBlock::new)
      .initialProperties(() -> Blocks.CHEST)
      .blockstate((ctx, prov) -> prov.simpleBlock(ctx.get(), prov.models()
          .withExistingParent("time_capsule", prov.mcLoc("block/block"))
          .texture("particle", prov.modLoc("block/time_capsule"))
          .element()
          .from(1, 0, 1) // Adjusted dimensions
          .to(15, 14, 15)
          .allFaces((dir, face) -> face.texture("#particle"))
          .end()))
      .simpleItem()
      .properties(p -> p.strength(0.2f).sound(SoundType.METAL))
      .register();
  public static final BlockEntry<Block> ASSORTED_PLASTIC = REGISTRATE.get().block("assorted_plastic", Block::new)
      .initialProperties(() -> Blocks.GRAVEL)
      .simpleItem()
      .properties(p -> p.color(MaterialColor.COLOR_LIGHT_GRAY)
          .requiresCorrectToolForDrops()
          .sound(SoundType.GRAVEL))
      .tag(BlockTags.NEEDS_STONE_TOOL)
      .tag(BlockTags.MINEABLE_WITH_SHOVEL)
      .register();
  public static final BlockEntry<GarbageBlock> WASTE = REGISTRATE.get().block("waste", GarbageBlock::new)
      .initialProperties(() -> Blocks.GRAVEL)
      .simpleItem()
      .properties(p -> p.color(MaterialColor.COLOR_LIGHT_GRAY)
          .requiresCorrectToolForDrops()
          .sound(SoundType.GRAVEL))
      .tag(BlockTags.NEEDS_STONE_TOOL)
      .tag(BlockTags.MINEABLE_WITH_SHOVEL)
      .register();
  public static final BlockEntry<Block> DENSE_WASTE = REGISTRATE.get().block("dense_waste", Block::new)
      .initialProperties(() -> Blocks.GRAVEL)
      .simpleItem()
      .properties(p -> p.color(MaterialColor.COLOR_LIGHT_GRAY)
          .requiresCorrectToolForDrops()
          .sound(SoundType.GRAVEL))
      .tag(BlockTags.NEEDS_STONE_TOOL)
      .tag(BlockTags.MINEABLE_WITH_SHOVEL)
      .register();
  public static final BlockEntry<Block> COMPACTED_WASTE = REGISTRATE.get().block("compacted_waste", Block::new)
      .initialProperties(() -> Blocks.STONE)
      .simpleItem()
      .properties(p -> p.color(MaterialColor.COLOR_LIGHT_GRAY)
          .requiresCorrectToolForDrops()
          .sound(SoundType.STONE))
      .tag(BlockTags.NEEDS_STONE_TOOL)
      .tag(BlockTags.MINEABLE_WITH_PICKAXE)
      .register();
  public static final BlockEntry<Block> ULTRA_COMPACTED_WASTE = REGISTRATE.get().block("ultra_compacted_waste", Block::new)
      .initialProperties(() -> Blocks.DEEPSLATE)
      .simpleItem()
      .properties(p -> p.color(MaterialColor.COLOR_GRAY)
          .requiresCorrectToolForDrops()
          .sound(SoundType.DEEPSLATE))
      .tag(BlockTags.NEEDS_DIAMOND_TOOL)
      .tag(BlockTags.MINEABLE_WITH_PICKAXE)
      .register();
  public static final BlockEntry<Block> SOLID_WASTE = REGISTRATE.get().block("solid_waste", Block::new)
      .initialProperties(() -> Blocks.OBSIDIAN)
      .simpleItem()
      .properties(p -> p.color(MaterialColor.COLOR_BLACK)
          .requiresCorrectToolForDrops()
          .sound(SoundType.DEEPSLATE))
      .tag(BlockTags.NEEDS_DIAMOND_TOOL)
      .tag(BlockTags.MINEABLE_WITH_PICKAXE)
      .register();

  public static BlockEntry<TrashBlock> registerTrash(String name, Supplier<Item> itemSupplier) {
    return REGISTRATE.get().block(name, TrashBlock::new)
        .initialProperties(() -> Blocks.IRON_BLOCK)
        .blockstate((ctx, prov) -> prov.simpleBlock(ctx.get(), prov.models()
            .withExistingParent(name, prov.mcLoc("block/block"))
            .texture("particle", prov.modLoc("block/" + name))
            .element()
            .from(0, 0, 0) // 1-pixel height
            .to(16, 1, 16) // Covers the whole block but only 1 pixel high
            .allFaces((dir, face) -> face.texture("#particle"))
            .end()))
        .loot((p, b) -> p.dropOther(b, itemSupplier.get()))
        .simpleItem()
        .properties(p -> p.noCollission()
            .strength(0.2f)
            .sound(SoundType.METAL))
        .register();
  }


  public static void register() {}
}
