import { buildingBlock } from "../generators/building-block.ts";
import { workbench, resourceType } from "hytale-generators";
import { builder } from "../generators/recipe/builder.ts";

export const colors = [
  "Black",
  "Blue",
  "Brown",
  "Cyan",
  "Gray",
  "Green",
  "Light_Blue",
  "Light_Gray",
  "Lime",
  "Magenta",
  "Orange",
  "Pink",
  "Purple",
  "Red",
  "White",
  "Yellow",
];

export function generateBuildingBlocks() {
  resourceType("Plastic_Blocks");
  // ? Garbage Patch
  buildingBlock(true, "Bricks_Plastic_Assorted")
    .name("Assorted Plastic Bricks")
    .color("#d83d05")
    .customModel("Blocks/Bricks_Plastic_Assorted.blockymodel")
    .customModelTexture("Blocks/Bricks_Plastic_Assorted.png")
    .resourceType("Plastic_Blocks")
    .build();

  buildingBlock(true, "Block_Plastic")
    .name("Plastic Block")
    .resourceType("Plastic_Blocks")
    .build();
  buildingBlock(true, "Bricks_Plastic")
    .name("Plastic Bricks")
    .resourceType("Plastic_Blocks")
    .build();

  colors.forEach((color) => {
    buildingBlock(true, `Block_Plastic_${color}`)
      .name(`${color} Plastic Block`)
      .resourceType("Plastic_Blocks")
      .build();
    buildingBlock(true, `Bricks_Plastic_${color}`)
      .name(`${color} Plastic Bricks`)
      .resourceType("Plastic_Blocks")
      .build();
  });

  // ? Recipes
  workbench(
    "Workbench_Block_Plastic",
    "Workbench_Crafting",
    ["6x $Wood_Trunk", "6x $Rock"],
    "Bench_Waste_Sorting",
    14,
  );

  builder(`Block_Plastic`)
    .input("Ingredient_Bar_Plastic")
    .output(`Block_Plastic`)
    .build();

  builder(`Brick_Plastic`)
    .input("$Plastic_Blocks")
    .output(`Bricks_Plastic`)
    .build();

  builder(`Block_Plastic_Assorted`)
    .input("$Plastic_Blocks")
    .output(`Bricks_Plastic_Assorted`)
    .build();

  colors.forEach((color) => {
    builder(`Block_Plastic_${color}`)
      .input("$Plastic_Blocks")
      .output(`Block_Plastic_${color}`)
      .build();
    builder(`Bricks_Plastic_${color}`)
      .input("$Plastic_Blocks")
      .output(`Bricks_Plastic_${color}`)
      .build();
  });
}
