import type { MaterialCfg } from "hytale-generators";
import { flatten, materials, resourceType } from "hytale-generators";
import type { Cfg, HasRecipes } from "../index.types.ts";
import { hasColor, recipes } from "../index.types.ts";

const { bar } = materials([
  {
    id: "Bar",
    defaults: {
      categories: ["Items.Ingredients", "Waste.Materials"],
      icon: true,
      model: "Resources/Materials/Ingot",
      resourceType: "Metal_Bars",
      baseName: "Ingot"
    }
  }
]);

const bars: Cfg<MaterialCfg & HasRecipes<"furnace" | "builders">> = {
  patch: [
    {
      id: "Plastic",
      color: "#37689F",
      builders: {
        output: "Block_Plastic"
      }
    }
  ],
  city: [
    {
      id: "Fabric",
      color: "#742729",
      baseMask: "Dark",
      builders: {
        output: "Bricks_Fabric_Assorted"
      }
    }
  ],
  factory: [
    {
      id: "Rusty_Iron",
      color: "#7D4E42",
      baseMask: "Dark"
    },
    {
      id: "Rusty_Aluminum",
      color: "#7D4E42"
    },
    {
      id: "Refractory_Brick",
      color: "#5B401D",
      baseMask: "Dark",
      builders: {
        output: "Block_Refractory"
      }
    },
    {
      id: "High_Refractory_Brick",
      baseMask: "Dark",
      color: "#5B413F",
      builders: {
        output: "Block_High_Refractory"
      }
    }
  ]
};

/** Registration for bars and dust -> bar recipes */
export const registerBars = () => {
  const register = flatten(bars).filter(hasColor);
  resourceType("Dusts").build();
  bar.many(register).build();
  recipes("Ingredient_Bar_", bars);
};
