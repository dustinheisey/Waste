import {
  blockSet,
  flatten,
  isString,
  materials,
  resourceType,
  type Flatten,
  type MaterialCfg
} from "hytale-generators";
import { sorting, type SimpleSortingRecipeCfg } from "../generators/sorting.ts";
import { wasteBlock, type WasteBlockCfg } from "../generators/waste-block.ts";

type Waste = (MaterialCfg & { sorting?: SimpleSortingRecipeCfg }) | string;
type WasteBlock = WasteBlockCfg & { sorting?: SimpleSortingRecipeCfg };

const wastes: Flatten<Waste> = {
  dump: [
    {
      id: "Loose",
      name: "Waste",
      sorting: {
        output: [
          "Ingredient_Treasure_Copper_Pipe",
          "Ingredient_Treasure_Electrical_Wire",
          "Ingredient_Treasure_Tin_Foil",
          "Ingredient_Treasure_Plumbing_Joint",
          "Ingredient_Treasure_Rag",
          "Ingredient_Treasure_Rope"
        ],
        time: 4
      }
    }
  ],
  patch: [
    {
      id: "Plastic",
      sorting: {
        output: [
          "Ingredient_Treasure_Fishing_Line",
          "Ingredient_Treasure_Water_Bottle",
          "Ingredient_Treasure_Bottle_Caps",
          "Ingredient_Treasure_Empty_Chip_Bag",
          "Ingredient_Treasure_Plastic_Bag",
          "Ingredient_Treasure_Straw"
        ],
        time: 8
      }
    }
  ],
  city: [
    {
      id: "Consumer",
      sorting: {
        output: [
          "Ingredient_Treasure_Fork",
          "Ingredient_Treasure_Watch",
          "Ingredient_Treasure_Necklace",
          "Ingredient_Treasure_Keychain",
          "Ingredient_Treasure_Amethyst_Ring",
          "Ingredient_Treasure_Toy"
        ],
        time: 8
      }
    }
    // { id: "Glass", name: "Broken Glass", icon: false }
  ]
  // toxicWastes: [{id: "Hazardous", icon: false}],
  // factory: [{id: "Industrial", icon: false}]
};

const wasteBlocks: Flatten<WasteBlock> = [
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
  },
  {
    id: "Plastic",
    icon: true,
    color: "#37689F",
    categories: ["Blocks.Soils"],
    gatherType: "Soils",
    drops: "Ingredient_Waste_Plastic"
  },
  {
    id: "Consumer",
    icon: true,
    color: "#37689F",
    categories: ["Blocks.Soils"],
    gatherType: "Soils",
    drops: "Ingredient_Waste_Consumer"
  }
];

const { waste } = materials([
  {
    id: "Waste",
    defaults: {
      categories: ["Items.Ingredients", "Waste.Wastes"],
      icon: true,
      baseModel: "Item",
      iconProperties: {
        Scale: 0.8,
        Rotation: [0, 0, 0],
        Translation: [-1, -16]
      }
    }
  }
]);

export const registerWastes = () => {
  blockSet("Waste").includeBlockGroups(["Waste_Block*"]).build();
  resourceType("Wastes").build();
  waste.many(wastes).build();
  wasteBlock.many(wasteBlocks).build();
  sorting
    .many(
      flatten(wastes).flatMap(item =>
        !isString(item) && item.sorting
          ? [
              {
                id: `Waste_${item.id}`,
                input: `6x Ingredient_Waste_${item.id}`,
                ...item.sorting
              }
            ]
          : []
      )
    )
    .build();
};
