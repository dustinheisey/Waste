import type { MaterialCfg } from "hytale-generators";
import { flatten, materials, resourceType } from "hytale-generators";
import { hasColor, recipes, type Cfg, type HasRecipes } from "../index.types.ts";

/** Registration for dusts */
export const registerDusts = () => {
  const { dust } = materials([
    { id: "Dust", defaults: { categories: ["Items.Ingredients", "Waste.Components"], icon: true } }
  ]);

  const dusts: Cfg<MaterialCfg & HasRecipes<"furnace" | "builders">> = {
    dump: [
      {
        id: "Copper",
        furnace: { input: "Ingredient_Dust_Copper", output: "Ingredient_Bar_Copper" }
      },
      {
        id: "Tin",
        furnace: { input: "Ingredient_Dust_Tin", output: "Ingredient_Bar_Tin" }
      },
      { id: "Activated_Charcoal", icon: false, color: "#272727" },
      { id: "Wet_activated_Charcoal", icon: false, color: "#262626" },
      { id: "Charcoal", icon: false, color: "#2d2d2d" }
    ],
    patch: [
      {
        id: "Plastic",
        color: "#37689F",
        furnace: { output: "Ingredient_Bar_Plastic" }
      }
    ],
    city: [
      {
        id: "Silver",
        furnace: { input: "Ingredient_Dust_Silver", output: "Ingredient_Bar_Silver" }
      },
      {
        id: "Silicon",
        furnace: { input: "Ingredient_Dust_Silicon", output: "Ingredient_Bar_Silicon" }
      }
    ],
    toxicWastes: [
      {
        id: "Bronze",
        color: "#675035",
        furnace: { output: "Ingredient_Bar_Bronze" }
      },
      { id: "Salt", color: "#CECECC", icon: false },
      { id: "Lime", color: "#A8968C", icon: false },
      { id: "Flux", color: "#EBD8C1", icon: false }
    ],
    factory: [
      {
        id: "Rusty_Iron",
        color: "#7D4E42",
        baseMask: "Dark",
        furnace: { output: "Ingredient_Bar_Rusty_Iron" }
      },
      {
        id: "Rusty_Aluminum",
        color: "#7D4E42",
        furnace: { output: "Ingredient_Bar_Rusty_Aluminum" }
      },
      {
        id: "Aluminum",
        furnace: { input: "Ingredient_Dust_Aluminum", output: "Ingredient_Bar_Aluminum" }
      },
      {
        id: "Iron",
        furnace: { input: "Ingredient_Dust_Iron", output: "Ingredient_Bar_Iron" }
      }
    ],
    trashTowers: [
      {
        id: "Lead",
        furnace: { input: "Ingredient_Dust_Lead", output: "Ingredient_Bar_Lead" }
      }
    ]
  };

  resourceType("Dusts").build();
  dust.many(flatten(dusts).filter(hasColor)).build();
  recipes("Ingredient_Dust_", dusts);
};
