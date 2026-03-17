import { flatten, materials, resourceType, type MaterialCfg } from "hytale-generators";
import type { Cfg, HasRecipes } from "../index.types.ts";
import { recipes } from "../index.types.ts";

export const scraps: Cfg<MaterialCfg & HasRecipes<"salvage" | "furnace" | "alchemy">> = {
  dump: [
    {
      id: "Rotten_Bone",
      alchemy: {
        categories: ["Alchemy_Potions_Misc"],
        input: ["Ingredient_Scrap_Rotten_Bone", "Ingredient_Water_Essence"],
        output: "Ingredient_Treasure_Bone"
      }
    },
    {
      id: "Dirty_Rag",
      alchemy: {
        categories: ["Alchemy_Potions_Misc"],
        input: ["Ingredient_Scrap_Dirty_Rag", "Ingredient_Water_Essence"],
        output: "Ingredient_Treasure_Rag"
      }
    },
    {
      id: "Dirty_Rope",
      alchemy: {
        categories: ["Alchemy_Potions_Misc"],
        input: ["Ingredient_Scrap_Dirty_Rope", "Ingredient_Water_Essence"],
        output: "Ingredient_Treasure_Rope"
      }
    }
  ],
  patch: [
    {
      id: "Dirty_Water_Bottle",
      alchemy: {
        categories: ["Alchemy_Potions_Misc"],
        input: ["Ingredient_Scrap_Dirty_Water_Bottle", "Ingredient_Water_Essence"],
        output: "Ingredient_Treasure_Water_Bottle"
      }
    }
  ],
  city: [
    {
      id: "Toy",
      salvage: { output: "2x Ingredient_Treasure_Fabric_Scraps" }
    }
  ],
  toxicWastes: [
    {
      id: "Broken_Electronics",
      salvage: {
        output: ["Ingredient_Scrap_Broken_Circuit_Board", "Ingredient_Scrap_Broken_Keyboard"]
      }
    },
    {
      id: "Broken_Circuit_Board",
      salvage: { output: ["Ingredient_Treasure_Scrap_Mechanism"] }
    },
    {
      id: "Broken_Keyboard",
      salvage: { output: ["Ingredient_Treasure_Rubber_Sheet"] }
    }
  ],
  factory: [
    {
      id: "Rusty_Aluminum_Can",
      alchemy: {
        categories: ["Alchemy_Potions_Misc"],
        input: ["Ingredient_Scrap_Rusty_Aluminum_Can", "Ingredient_Water_Essence"],
        output: "Ingredient_Treasure_Aluminum_Can"
      },
      salvage: { output: ["2x Ingredient_Dust_Rusty_Aluminum"] },
      furnace: { output: ["Ingredient_Bar_Rusty_Aluminum"] }
    },
    {
      id: "Rusty_Bullet_Casing",
      alchemy: {
        categories: ["Alchemy_Potions_Misc"],
        input: ["Ingredient_Scrap_Rusty_Bullet_Casing", "Ingredient_Water_Essence"],
        output: "Ingredient_Treasure_Bullet_Casing"
      },
      salvage: { output: ["2x Ingredient_Dust_Rusty_Iron"] },
      furnace: { output: ["Ingredient_Bar_Rusty_Iron"] }
    },
    {
      id: "Rusty_Scrap_Metal",
      alchemy: {
        categories: ["Alchemy_Potions_Misc"],
        input: ["Ingredient_Scrap_Rusty_Scrap_Metal", "Ingredient_Water_Essence"],
        output: "Ingredient_Treasure_Scrap_Metal"
      },
      salvage: { output: ["2x Ingredient_Dust_Rusty_Iron"] },
      furnace: { output: ["Ingredient_Bar_Rusty_Iron"] }
    },
    {
      id: "Rusty_Wrench",
      alchemy: {
        categories: ["Alchemy_Potions_Misc"],
        input: ["Ingredient_Scrap_Rusty_Wrench", "Ingredient_Water_Essence"],
        output: "Ingredient_Treasure_Wrench"
      },
      salvage: { output: ["2x Ingredient_Dust_Rusty_Iron"] },
      furnace: { output: ["Ingredient_Bar_Rusty_Iron"] }
    },
    {
      id: "Rusty_Nail",
      alchemy: {
        categories: ["Alchemy_Potions_Misc"],
        input: ["Ingredient_Scrap_Rusty_Nail", "Ingredient_Water_Essence"],
        output: "Ingredient_Treasure_Nail"
      },
      salvage: { output: ["2x Ingredient_Dust_Rusty_Iron"] },
      furnace: { output: ["Ingredient_Bar_Rusty_Iron"] }
    }
  ]
};

const { scrap } = materials([
  {
    id: "Scrap",
    defaults: {
      categories: ["Items.Ingredients", "Waste.Scraps"],
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

/** Registration for scraps and scraps -> material recipes */
export const registerScraps = () => {
  resourceType("Scraps").build();
  scrap
    .many(
      flatten(scraps).flatMap(item => {
        return [
          {
            ...item,
            name: item.id.replaceAll("_", " ")
          }
        ];
      })
    )
    .build();
  recipes("Ingredient_Scrap_", scraps);
};
