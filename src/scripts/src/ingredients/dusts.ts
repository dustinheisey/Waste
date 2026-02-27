import { resourceType } from "hytale-generators";
import { dust } from "hytale-generators";
import { salvage } from "../../generators/recipe/salvage.ts";
import { garbagePatchTreasures } from "./treasures.ts";

export function generateDusts() {
  resourceType("Dusts");
  // ? Registration
  dust({
    icon: true,
    id: "Plastic",
    color: "#37689F",
    categories: ["Items.Ingredients", "Waste.Materials"],
  });

  // ? Recipes
  ["Treasure_Copper_Pipe", "Treasure_Electrical_Wire"].forEach((ingredient) => {
    salvage(ingredient)
      .input(`Ingredient_${ingredient}`)
      .output("2x Ingredient_Dust_Copper")
      .time(4)
      .build();
  });

  salvage("Treasure_Tin_Foil")
    .input("Ingredient_Treasure_Tin_Foil")
    .output("2x Ingredient_Dust_Tin")
    .time(4)
    .build();

  salvage("Treasure_Plumbing_Joint")
    .input("Ingredient_Treasure_Plumbing_Joint")
    .output("2x Ingredient_Dust_Iron")
    .time(4)
    .build();

  garbagePatchTreasures.forEach((ingredient) => {
    salvage(`Treasure_${ingredient}`)
      .input(`Ingredient_Treasure_${ingredient}`)
      .output("2x Ingredient_Dust_Plastic")
      .time(4)
      .build();
  });
}
