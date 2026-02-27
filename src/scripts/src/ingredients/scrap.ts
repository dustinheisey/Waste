import { resourceType } from "hytale-generators";
import { scraps } from "../../generators/ingredient.ts";

export function generateScrap() {
  resourceType("Scraps");

  // ? Dump
  scraps(false, [
    "Broken_Hoe",
    "Broken_Pickaxe",
    "Broken_Picker",
    "Broken_Shovel",
    "Broken_Sword",
    "Dirty_Rag",
    "Dirty_Rope",
    "Old_Tire",
    "Rotten_Bone",
  ]);

  // ? Garbage Patch
  scraps(false, ["Dirty_Water_Bottle", "Empty_Chip_Bag", "Plastic_Bag"]);
}
