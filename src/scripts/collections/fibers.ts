import type { NoId, SalvageRecipeCfg } from "hytale-generators";
import { salvage } from "hytale-generators";

const fibers: NoId<SalvageRecipeCfg>[] = [
  {
    input: "Rag",
    output: "Ingredient_Fabric_Scrap_Linen",
    time: 4
  },
  {
    input: "Rope",
    output: "3x Ingredient_Fibre",
    time: 4
  },
  {
    input: "Toy",
    output: "2x Ingredient_Treasure_Fabric_Scraps",
    time: 4
  }
];

export const registerFibers = () => {
  salvage
    .many(
      fibers.map(fiber => ({
        id: `${fiber.input}`,
        input: `Ingredient_Treasure_${fiber.input}`,
        output: fiber.output,
        time: fiber.time
      }))
    )
    .build();
};
