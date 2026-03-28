import { categories } from "hytale-generators";

/** Registration for creative mode categories */
export const registerCategories = () => {
  categories()
    .children([
      "Wastes",
      "Scraps",
      "Treasures",
      { id: "Materials", icon: "Items-Ingredients" },
      { id: "Tools", icon: "Bench" },
      "Blocks"
    ])
    .build();
};
