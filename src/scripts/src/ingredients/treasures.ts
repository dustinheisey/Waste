import { resourceType } from "hytale-generators";
import { treasures } from "../../generators/ingredient.ts";

export const garbagePatchTreasures = [
  "Fishing_Line",
  "Water_Bottle",
  "Bottle_Caps",
  "Empty_Chip_Bag",
  "Plastic_Bag",
  "Straw",
];

export const dumpTreasures = [
  "Copper_Pipe",
  "Electrical_Wire",
  "Plumbing_Joint",
  "Rag",
  "Rope",
  "Tin_Foil",
];

export const cityTreasures = [
  "Amethyst_Ring",
  "Clothing_Scraps",
  "Fork",
  "Keychain",
  "Necklace",
  "Watch",
];

export const factoryTreasures = [
  "Aluminum_Can",
  "Bullet_Casing",
  "Circuit_Board",
  "Nail",
  "Scrap_Mechanism",
  "Scrap_Metal",
  "Wrench",
];

export function generateTreasures() {
  resourceType("Treasures");

  // ? Dump
  treasures(true, [
    ...dumpTreasures,
    ...garbagePatchTreasures,
    ...cityTreasures,
    ...factoryTreasures,
  ]);
}
