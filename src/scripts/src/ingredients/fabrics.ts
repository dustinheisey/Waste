import { salvage } from "../../generators/recipe/salvage.ts";

export function generateFabrics() {
  // ? Recipes
  salvage("Treasure_Rag")
    .input("Ingredient_Treasure_Rag")
    .output("Ingredient_Fabric_Scrap_Linen")
    .time(4)
    .build();

  salvage("Treasure_Rope")
    .input("Ingredient_Treasure_Rope")
    .output("3x Ingredient_Fibre")
    .time(4)
    .build();
}
