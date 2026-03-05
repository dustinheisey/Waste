import { flatten, isString, materials, resourceType, type MaterialCfg } from "hytale-generators";

export const treasures: Record<string, (MaterialCfg | string)[]> = {
  dump: ["Copper_Pipe", "Electrical_Wire", "Plumbing_Joint", "Rag", "Rope", "Tin_Foil"],
  patch: ["Fishing_Line", "Water_Bottle", "Bottle_Caps", "Empty_Chip_Bag", "Plastic_Bag", "Straw"],
  city: ["Amethyst_Ring", "Fabric_Scraps", "Fork", "Keychain", "Necklace", "Watch", "Toy"],
  factory: ["Aluminum_Can", "Bullet_Casing", "Circuit_Board", "Nail", "Scrap_Mechanism", "Scrap_Metal", "Wrench"]
};

const { treasure } = materials([
  {
    id: "Treasure",
    defaults: {
      categories: ["Items.Ingredients", "Waste.Treasures"],
      icon: true,
      baseModel: "Item",
      iconProperties: {
        Scale: 0.8,
        Rotation: [0, 0, 0],
        Translation: [-1, -16]
      }
    }
  }
]);

export const registerTreasures = () => {
  resourceType("Treasures").build();
  treasure
    .many(
      flatten(treasures).flatMap(item => {
        return [
          {
            id: isString(item) ? item : item.id,
            name: isString(item) ? item.replaceAll("_", " ") : item.id.replaceAll("_", " "),
            ...(isString(item) ? {} : item)
          }
        ];
      })
    )
    .build();
};
