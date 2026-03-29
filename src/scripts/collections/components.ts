import { flatten, materials, resourceType, type Flatten, type MaterialCfg } from "hytale-generators";
import { recipes, type HasRecipes } from "../index.types.ts";

/** Registration for waste items, and waste items sorting recipes -> treasures */
export const registerComponents = () => {
  const { component } = materials([
    {
      id: "Component",
      defaults: {
        categories: ["Items.Ingredients", "Waste.Components"],
        baseModel: "Item",
        baseName: "",
        icon: true,
        iconProperties: {
          Scale: 0.8,
          Rotation: [0, 0, 0],
          Translation: [-1, -16]
        }
      }
    }
  ]);

  // leahter sheet, large leather sheet
  const components: Flatten<MaterialCfg & HasRecipes<"armor">> = {
    goggles: [{ id: "Goggles", maxStack: 1 }, { id: "Goggle" }, { id: "Clear_Plastic_Lens" }],
    leatherStrap: [{ id: "Leather_Strap" }, { id: "Buckle" }, { id: "Leather_Strip" }, { id: "Leather_Sheet" }],
    maskBody: [
      {
        id: "Scrappy_Gas_Mask",
        maxStack: 1,
        armor: {
          categories: "Armor_Head",
          input: [
            "Ingredient_Component_Goggles",
            "2x Ingredient_Component_Leather_Strap",
            "Ingredient_Component_Mask_Body",
            "Ingredient_Component_Inhalation_Valve",
            "Ingredient_Component_Exhalation_Valve",
            "Ingredient_Component_Air_Filter"
          ],
          output: "Ingredient_Component_Scrappy_Gas_Mask"
        }
      },
      { id: "Mask_Body", maxStack: 1 },
      { id: "Mask_Lining", maxStack: 1 },
      { id: "Molded_Face_Shell", maxStack: 1 },
      { id: "Plastic_Clump" },
      { id: "Large_Leather_Sheet", icon: false },
      { id: "Prepared_Hide", icon: false },
      { id: "Scraped_Hide", icon: false },
      { id: "Soaked_Hide", icon: false },
      { id: "Salted_Hide", icon: false },
      { id: "Stitched_Hide", icon: false },
    ],
    valves: [{ id: "Inhalation_Valve" }, { id: "Exhalation_Valve" }, { id: "Rubber_Disk" }],
    airFilter: [
      { id: "Air_Filter", maxStack: 1 },
      { id: "Pre_Filter" },
      { id: "Charcoal_Filter" },
      { id: "Bronze_Filter_Casing" },
      { id: "Bronze_Disk" }
      // { id: "Bronze_Sheet" }
    ]
  };

  resourceType("Components").build();
  component.many(flatten(components)).build();
  recipes("", flatten(components));
};
