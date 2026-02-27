import { resourceType } from "hytale-generators";
import { wastes } from "../../generators/ingredient.ts";
import { sorting } from "../../generators/recipe/sorting.ts";

export function generateWastes() {
  // ? Resource Types
  resourceType("Wastes");

  // ? Registration
  wastes(true, [
    { id: "Waste", name: "Waste" },
    { id: "Plastic", name: "Plastic Waste" },
  ]);

  // ? Recipes
  sorting("Waste")
    .input("6x Ingredient_Waste_Waste")
    .output([
      "Ingredient_Treasure_Copper_Pipe",
      "Ingredient_Treasure_Electrical_Wire",
      "Ingredient_Treasure_Tin_Foil",
      "Ingredient_Treasure_Plumbing_Joint",
      "Ingredient_Treasure_Rag",
      "Ingredient_Treasure_Rope",
    ])
    .time(4)
    .build();

  sorting("Plastic")
    .input("6x Ingredient_Waste_Plastic")
    .output([
      "Ingredient_Treasure_Fishing_Line",
      "Ingredient_Treasure_Water_Bottle",
      "Ingredient_Treasure_Bottle_Caps",
      "Ingredient_Treasure_Empty_Chip_Bag",
      "Ingredient_Treasure_Plastic_Bag",
      "Ingredient_Treasure_Straw",
    ])
    .time(8)
    .build();
}
