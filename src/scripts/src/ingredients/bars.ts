import { ingot } from "hytale-generators";
import { furnace } from "../../generators/recipe/furnace.ts";
import { garbagePatchTreasures } from "./treasures.ts";

export function generateBars() {
  // ? Registration
  ingot({
    id: "Plastic",
    icon: true,
    color: "#37689F",
    categories: ["Items.Ingredients", "Waste.Materials"],
  });

  // ? Recipes
  ["Treasure_Copper_Pipe", "Treasure_Electrical_Wire", "Dust_Copper"].forEach(
    (ingredient) => {
      furnace(ingredient)
        .input(`Ingredient_${ingredient}`)
        .output("Ingredient_Bar_Copper")
        .time(14)
        .build();
    },
  );

  ["Treasure_Plumbing_Joint", "Dust_Iron"].forEach((ingredient) => {
    furnace(ingredient)
      .input(`Ingredient_${ingredient}`)
      .output("Ingredient_Bar_Iron")
      .time(14)
      .build();
  });

  ["Treasure_Tin_Foil", "Dust_Tin"].forEach((ingredient) => {
    furnace(ingredient)
      .input(`Ingredient_${ingredient}`)
      .output("Ingredient_Bar_Tin")
      .time(14)
      .build();
  });

  garbagePatchTreasures.forEach((ingredient) => {
    furnace(`Treasure_${ingredient}`)
      .input(`Ingredient_Treasure_${ingredient}`)
      .output("Ingredient_Bar_Plastic")
      .time(14)
      .build();
  });

  furnace("Dust_Plastic")
    .input("Ingredient_Dust_Plastic")
    .output("Ingredient_Bar_Plastic")
    .time(14)
    .build();
}
