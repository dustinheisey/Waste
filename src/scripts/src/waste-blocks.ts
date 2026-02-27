import { blockSet } from "../generators/block-set.ts";
import { wasteBlock } from "../generators/waste-block.ts";

export function generateWasteBlocks() {
  blockSet("Waste").includeBlockTypes(["Waste_Block*"]).build();

  // ? Dump
  wasteBlock(true, "Loose")
    .categories(["Blocks.Soils"])
    .gatherType("Soils")
    .transition()
    .build();

  wasteBlock(true, "Dense")
    .categories(["Blocks.Soils"])
    .gatherType("Soils")
    .transition()
    .dropQuantity(2)
    .build();

  wasteBlock(true, "Compacted")
    .categories(["Blocks.Rocks"])
    .dropQuality(2)
    .dropQuantity(3)
    .build();

  wasteBlock(true, "Ultra_Compacted")
    .categories(["Blocks.Rocks"])
    .dropQuality(4)
    .dropQuantity(4)
    .build();

  wasteBlock(true, "Solid")
    .categories(["Blocks.Rocks"])
    .dropQuality(5)
    .dropQuantity(5)
    .build();

  // TODO: Builder workbench recipes convert waste items back to blocks

  // ? Garbage Patch
  wasteBlock(true, "Plastic")
    .categories(["Blocks.Soils"])
    .gatherType("Soils")
    .drop("Ingredient_Waste_Plastic")
    .color("#37689F")
    .build();
}
