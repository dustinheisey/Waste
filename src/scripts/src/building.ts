import { buildingBlock } from "../generators/building-block.ts";
export function generateBuildingBlocks() {
  // ? Garbage Patch
  buildingBlock(true, "Bricks_Plastic_Assorted")
    .name("Assorted Plastic Bricks")
    .color("#d83d05")
    .customModel("Blocks/Bricks_Plastic_Assorted.blockymodel")
    .customModelTexture("Blocks/Bricks_Plastic_Assorted.png")
    .build();

  buildingBlock(true, "Block_Plastic").name("Plastic Block").build();
  buildingBlock(true, "Bricks_Plastic").name("Plastic Bricks").build();

  [
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
  ].forEach((color) => {
    buildingBlock(true, `Block_Plastic_${color}`)
      .name(`${color} Plastic Block`)
      .build();
    buildingBlock(true, `Bricks_Plastic_${color}`)
      .name(`${color} Plastic Bricks`)
      .build();
  });
}
