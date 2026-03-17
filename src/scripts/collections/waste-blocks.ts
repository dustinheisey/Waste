import { blockSet, flatten } from "hytale-generators";
import type { WasteBlockCfg } from "../generators/waste-block.ts";
import { wasteBlock } from "../generators/waste-block.ts";
import type { Cfg } from "../index.types.ts";

const wasteBlocks: Cfg<WasteBlockCfg> = {
  dump: [
    {
      id: "Loose",
      icon: true,
      color: "#3d3e3e",
      categories: ["Blocks.Soils"],
      gatherType: "Soils",
      transition: true
    },
    {
      id: "Dense",
      icon: true,
      color: "#3d3e3e",
      categories: ["Blocks.Soils"],
      gatherType: "Soils",
      transition: true,
      dropQuantity: 2
    },
    {
      id: "Compacted",
      icon: true,
      color: "#3d3e3e",
      categories: ["Blocks.Rocks"],
      dropQuality: 2,
      dropQuantity: 3
    },
    {
      id: "Ultra_Compacted",
      icon: true,
      color: "#3d3e3e",
      categories: ["Blocks.Rocks"],
      dropQuality: 4,
      dropQuantity: 4
    },
    {
      id: "Solid",
      icon: true,
      color: "#3d3e3e",
      categories: ["Blocks.Rocks"],
      dropQuality: 5,
      dropQuantity: 5
    }
  ],
  patch: [
    {
      id: "Plastic",
      icon: true,
      color: "#37689F",
      categories: ["Blocks.Soils"],
      gatherType: "Soils",
      drops: "Ingredient_Waste_Plastic"
    }
  ],
  city: [
    {
      id: "Consumer",
      icon: true,
      color: "#824A3C",
      categories: ["Blocks.Soils"],
      gatherType: "Soils",
      drops: "Ingredient_Waste_Consumer"
    }
  ],
  toxicWastes: [
    {
      id: "Hazardous",
      icon: true,
      color: "#877633",
      categories: ["Blocks.Woods"],
      model: "Blocks/Waste_Block_Hazardous",
      texture: "Blocks/Waste_Block_Hazardous",
      drops: "Ingredient_Waste_Hazardous"
    }
  ],
  factory: [
    {
      id: "Industrial",
      icon: true,
      color: "#7D4E42",
      categories: ["Blocks.Rocks"],
      drops: "Ingredient_Waste_Industrial"
    }
  ]
};

/** Registration for waste blocks and waste item drops */
export const registerWasteBlocks = () => {
  // ? Registration
  blockSet("Waste").includeBlockGroups(["Waste_Block*"]).build();
  wasteBlock.many(flatten(wasteBlocks)).build();
};
