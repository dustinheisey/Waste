import type { Child, Flatten } from "hytale-generators";
import { categories } from "hytale-generators";

const categoryTypes: Flatten<Child> = [
  "Wastes",
  "Treasures",
  { id: "Materials", icon: "Items-Ingredients" },
  { id: "Tools", icon: "Bench" },
  "Blocks"
];

export const registerCategories = () => {
  categories().children(categoryTypes).build();
};
