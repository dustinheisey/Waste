import type { Child, Flatten } from "hytale-generators";
import { categories } from "hytale-generators";

const categoryTypes: Flatten<Child> = [
  "Wastes",
  "Scraps",
  "Treasures",
  { id: "Materials", icon: "Items-Ingredients" },
  { id: "Tools", icon: "Bench" },
  "Blocks"
];

/** Registration for creative mode categories */
export const registerCategories = () => {
  categories().children(categoryTypes).build();
};
