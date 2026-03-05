import type { Flatten, HasFilter, MaterialCfg } from "hytale-generators";
import { flatten, furnace, isString, materials, resourceType, salvage } from "hytale-generators";
import { treasures } from "./treasures.ts";

type MetalCfg = Flatten<
  MaterialCfg & { onlyRecipes?: boolean; dustFrom?: string[]; barFrom?: string[] } & HasFilter<"bar" | "dust">
>;

const metals: MetalCfg = [
  {
    id: "Copper",
    onlyRecipes: true,
    dustFrom: ["Ingredient_Treasure_Copper_Pipe", "Ingredient_Treasure_Electrical_Wire"],
    barFrom: ["Ingredient_Treasure_Copper_Pipe", "Ingredient_Treasure_Electrical_Wire", "Ingredient_Dust_Copper"]
  },
  {
    id: "Iron",
    onlyRecipes: true,
    dustFrom: ["Ingredient_Treasure_Plumbing_Joint"],
    barFrom: ["Ingredient_Treasure_Plumbing_Joint", "Ingredient_Dust_Iron"]
  },
  {
    id: "Tin",
    onlyRecipes: true,
    dustFrom: ["Ingredient_Treasure_Tin_Foil"],
    barFrom: ["Ingredient_Treasure_Tin_Foil", "Ingredient_Dust_Tin"]
  },
  {
    id: "Plastic",
    color: "#37689F",
    dustFrom: [
      ...treasures.patch.map(treasure => `Ingredient_Treasure_${isString(treasure) ? treasure : treasure.id}`)
    ],
    barFrom: [
      ...treasures.patch.map(treasure => `Ingredient_Treasure_${isString(treasure) ? treasure : treasure.id}`),
      "Ingredient_Dust_Plastic"
    ]
  },
  {
    id: "Fabric",
    include: ["bar"],
    color: "#742729",
    baseMask: "Dark",
    barFrom: ["Ingredient_Treasure_Fabric_Scraps"]
  },
  {
    id: "Silver",
    onlyRecipes: true,
    dustFrom: [
      "Ingredient_Treasure_Fork",
      "Ingredient_Treasure_Keychain",
      "Ingredient_Treasure_Necklace",
      "Ingredient_Treasure_Watch"
    ],
    barFrom: [
      "Ingredient_Treasure_Fork",
      "Ingredient_Treasure_Keychain",
      "Ingredient_Treasure_Necklace",
      "Ingredient_Treasure_Watch",
      "Ingredient_Dust_Silver"
    ]
  },
  {
    id: "Silicon",
    onlyRecipes: true,
    dustFrom: ["Ingredient_Treasure_Amethyst_Ring"],
    barFrom: ["Ingredient_Treasure_Amethyst_Ring", "Ingredient_Dust_Silicon"]
  }
];

const { bar, dust } = materials([
  {
    id: "Bar",
    defaults: {
      categories: ["Items.Ingredients", "Waste.Materials"],
      icon: true,
      model: "Resources/Materials/Ingot",
      resourceType: "Metal_Bars",
      baseName: "Ingot"
    }
  },
  { id: "Dust", defaults: { categories: ["Items.Ingredients", "Waste.Materials"], icon: true } }
]);

export const registerMetals = () => {
  const register = metals.filter(metal => !metal.onlyRecipes);
  const bars = register.filter(metal =>
    metal.include ? metal.include.includes("bar") : metal.exclude ? !metal.exclude.includes("bar") : metal
  );
  const dusts = register.filter(metal =>
    metal.include ? metal.include.includes("dust") : metal.exclude ? !metal.exclude.includes("dust") : metal
  );
  resourceType("Dusts").build();
  bar.many(bars).build();
  dust.many(dusts).build();

  salvage
    .many([
      ...flatten(metals).flatMap(item => {
        if (!item.dustFrom) return [];
        return item.dustFrom.map(input => ({
          id: `Dust_${item.id}_From_${input.replace("Ingredient_Treasure_", "")}`,
          input: input,
          output: `2x Ingredient_Dust_${item.id}`,
          time: 4
        }));
      })
    ])
    .build();

  furnace
    .many(
      flatten(metals).flatMap(item => {
        if (!item.barFrom) return [];
        return item.barFrom.map(input => ({
          id: `Bar_${item.id}_From_${input.replace("Ingredient_Treasure_", "").replace("Ingredient_", "")}`,
          input: input,
          output: `Ingredient_Bar_${item.id}`,
          time: 14
        }));
      })
    )
    .build();
};
