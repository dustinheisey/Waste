import type { MaterialCfg } from "hytale-generators";
import { flatten, materials, resourceType } from "hytale-generators";
import { recipes, type Cfg, type HasRecipes } from "../index.types.ts";

export const registerTreasures = () => {
  const { treasure } = materials([
    {
      id: "Treasure",
      defaults: {
        categories: ["Items.Ingredients", "Waste.Treasures"],
        icon: true,
        baseModel: "Item",
        resourceType: "Treasures",
        iconProperties: {
          Scale: 0.8,
          Rotation: [0, 0, 0],
          Translation: [-1, -16]
        }
      }
    }
  ]);

  const treasures: Cfg<MaterialCfg & HasRecipes<"salvage" | "furnace" | "alchemy" | "builders">> = {
    dump: [
      {
        id: "Copper_Pipe",
        salvage: { output: "2x Ingredient_Dust_Copper" },
        furnace: { output: "Ingredient_Bar_Copper" }
      },
      {
        id: "Electrical_Wire",
        salvage: { output: "2x Ingredient_Dust_Copper" },
        furnace: { output: "Ingredient_Bar_Copper" }
      },
      {
        id: "Rag",
        salvage: { output: "Ingredient_Fabric_Scrap_Linen" }
      },
      {
        id: "Rope",
        salvage: { output: "3x Ingredient_Fibre" }
      },
      {
        id: "Tin_Foil",
        salvage: { output: "2x Ingredient_Dust_Tin" },
        furnace: { output: "Ingredient_Bar_Tin" }
      }
    ],
    patch: [
      {
        id: "Water_Bottle",
        salvage: { output: "2x Ingredient_Dust_Plastic" },
        furnace: { output: "Ingredient_Bar_Plastic" }
      },
      {
        id: "Fishing_Line",
        salvage: { output: "2x Ingredient_Dust_Plastic" },
        furnace: { output: "Ingredient_Bar_Plastic" }
      },
      {
        id: "Bottle_Caps",
        salvage: { output: "2x Ingredient_Dust_Plastic" },
        furnace: { output: "Ingredient_Bar_Plastic" }
      },
      {
        id: "Empty_Chip_Bag",
        salvage: { output: "2x Ingredient_Dust_Plastic" },
        furnace: { output: "Ingredient_Bar_Plastic" }
      },
      {
        id: "Plastic_Bag",
        salvage: { output: "2x Ingredient_Dust_Plastic" },
        furnace: { output: "Ingredient_Bar_Plastic" }
      },
      {
        id: "Straw",
        salvage: { output: "2x Ingredient_Dust_Plastic" },
        furnace: { output: "Ingredient_Bar_Plastic" }
      },
      { id: "Softened_Plastic" }
    ],
    city: [
      {
        id: "Amethyst_Ring",
        salvage: { output: "2x Ingredient_Dust_Silicon" },
        furnace: { output: "Ingredient_Bar_Silicon" }
      },
      {
        id: "Fork",
        salvage: { output: "2x Ingredient_Dust_Silver" },
        furnace: { output: "Ingredient_Bar_Silver" }
      },
      {
        id: "Keychain",
        salvage: { output: "2x Ingredient_Dust_Silver" },
        furnace: { output: "Ingredient_Bar_Silver" }
      },
      {
        id: "Necklace",
        salvage: { output: "2x Ingredient_Dust_Silver" },
        furnace: { output: "Ingredient_Bar_Silver" }
      },
      {
        id: "Watch",
        salvage: { output: "2x Ingredient_Dust_Silver" },
        furnace: { output: "Ingredient_Bar_Silver" }
      },
      {
        id: "Fabric_Scraps",
        furnace: { output: "Ingredient_Bar_Fabric" }
      },
      {
        id: "Camera_Lens_Frame"
      },
      {
        id: "Empty_Ink_Tube"
      }
    ],
    toxicWastes: [
      { id: "Hydrochloric_Acid" },
      {
        id: "Scrap_Mechanism",
        salvage: { output: "2x Ingredient_Dust_Bronze" },
        furnace: { output: "Ingredient_Bar_Bronze" }
      },
      { id: "Rubber_Sheet" }
    ],
    factory: [
      {
        id: "Aluminum_Can",
        salvage: { output: "2x Ingredient_Dust_Aluminum" },
        furnace: { output: "Ingredient_Bar_Aluminum" }
      },
      {
        id: "Bullet_Casing",
        salvage: { output: "2x Ingredient_Dust_Iron" },
        furnace: { output: "Ingredient_Bar_Iron" }
      },
      {
        id: "Nail",
        salvage: { output: "2x Ingredient_Dust_Iron" },
        furnace: { output: "Ingredient_Bar_Iron" }
      },
      {
        id: "Scrap_Metal",
        salvage: { output: "2x Ingredient_Dust_Iron" },
        furnace: { output: "Ingredient_Bar_Iron" }
      },
      {
        id: "Wrench",
        salvage: { output: "2x Ingredient_Dust_Iron" },
        furnace: { output: "Ingredient_Bar_Iron" }
      }
    ],
    trashTowers: [
      {
        id: "Plumbing_Joint",
        salvage: { output: "2x Ingredient_Dust_Lead" },
        furnace: { output: "Ingredient_Bar_Lead" }
      }
    ]
  };

  resourceType("Treasures").build();
  treasure
    .many(
      flatten(treasures).flatMap(treasure => {
        return [
          {
            ...treasure,
            name: treasure.id.replaceAll("_", " ")
          }
        ];
      })
    )
    .build();
  recipes("Ingredient_Treasure_", treasures);
};
