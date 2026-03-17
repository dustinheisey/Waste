import type { MaterialCfg } from "hytale-generators";
import { materials, resourceType } from "hytale-generators";
import type { Cfg, HasRecipes } from "../index.types.ts";
import { recipes } from "../index.types.ts";

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

const wastes: Cfg<MaterialCfg & HasRecipes<"sorting">> = {
  dump: [
    {
      id: "Loose",
      name: "Waste",
      sorting: {
        output: [
          "Ingredient_Treasure_Copper_Pipe",
          "Ingredient_Treasure_Electrical_Wire",
          "Ingredient_Treasure_Tin_Foil",
          "Ingredient_Scrap_Rotten_Bone",
          "Ingredient_Scrap_Dirty_Rag",
          "Ingredient_Scrap_Dirty_Rope"
        ]
      }
    }
  ],
  patch: [
    {
      id: "Plastic",
      sorting: {
        output: [
          "Ingredient_Treasure_Fishing_Line",
          "Ingredient_Scrap_Dirty_Water_Bottle",
          "Ingredient_Treasure_Bottle_Caps",
          "Ingredient_Treasure_Empty_Chip_Bag",
          "Ingredient_Treasure_Plastic_Bag",
          "Ingredient_Treasure_Straw"
        ]
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
          "Ingredient_Scrap_Toy"
        ]
      }
    }
    // { id: "Glass", name: "Broken Glass", icon: false }
  ],
  toxicWastes: [
    {
      id: "Hazardous",
      sorting: {
        output: ["Ingredient_Scrap_Broken_Electronics", "2x Ingredient_Treasure_Hydrochloric_Acid"]
      }
    }
  ],
  factory: [
    {
      id: "Industrial",
      sorting: {
        output: [
          "Ingredient_Scrap_Rusty_Aluminum_Can",
          "Ingredient_Scrap_Rusty_Bullet_Casing",
          "Ingredient_Scrap_Rusty_Scrap_Metal",
          "Ingredient_Scrap_Rusty_Wrench",
          "Ingredient_Scrap_Rusty_Nail"
        ]
      }
    }
  ]
};

/** Registration for waste items, and waste items sorting recipes -> treasures */
export const registerWastes = () => {
  resourceType("Wastes").build();
  waste.many(wastes).build();
  recipes("Ingredient_Waste_", wastes);
};
