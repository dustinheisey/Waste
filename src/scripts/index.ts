import {
  categories,
  setGlobal,
  syncPublic,
  resourceType,
  workbench,
} from "hytale-generators";
import { hitbox } from "./generators/hitbox.ts";
import { blockSet } from "./generators/block-set.ts";
import { wastes, treasures } from "./generators/ingredient.ts";
import { wasteBlock } from "./generators/waste-block.ts";
import { bench } from "./generators/bench.ts";
import { furnace } from "./generators/recipe/furnace.ts";
import { salvage } from "./generators/recipe/salvage.ts";
import { sorting } from "./generators/recipe/sorting.ts";

setGlobal({ modId: "Waste", outDir: "../main/resources" });

syncPublic();

categories([
  { id: "Waste", icon: "Wastes" },
  { id: "Treasure", icon: "Treasures" },
  "Tools",
]);

resourceType("Treasures");
resourceType("Wastes");

wasteBlock(true, "Loose")
  .categories(["Blocks.Soils"])
  .gatherType("Soils")
  .transition()
  .build();

wasteBlock(true, "Dense")
  .categories(["Blocks.Soils"])
  .gatherType("Soils")
  .transition()
  .dropQuantity(2)
  .build();

wasteBlock(true, "Compacted")
  .categories(["Blocks.Rocks"])
  .dropQuality(2)
  .dropQuantity(3)
  .build();

wasteBlock(true, "Ultra_Compacted")
  .categories(["Blocks.Rocks"])
  .dropQuality(4)
  .dropQuantity(4)
  .build();

wasteBlock(true, "Solid")
  .categories(["Blocks.Rocks"])
  .dropQuality(5)
  .dropQuantity(5)
  .build();

wastes(true, [{ id: "Waste", name: "Waste" }]);

treasures(true, [
  "Aluminum_Can",
  "Amethyst_Ring",
  "Bullet_Casing",
  "Circuit_Board",
  "Clothing_Scraps",
  "Copper_Pipe",
  "Electrical_Wire",
  "Fishing_Line",
  "Fork",
  "Keychain",
  "Nail",
  "Necklace",
  "Plumbing_Joint",
  "Rag",
  "Rope",
  "Scrap_Mechanism",
  "Scrap_Metal",
  "Tin_Foil",
  "Watch",
  "Water_Bottle",
  "Wrench",
]);

bench(true, "Bench_Waste_Sorting")
  .name("Waste Sorting Bench")
  .description("Used to sort waste and find treasures amidst the refuse.")
  .build();

workbench(
  "Workbench_Bench_Waste_Sorting",
  "Workbench_Crafting",
  ["6x $Wood_Trunk", "6x $Rock"],
  "Bench_Waste_Sorting",
  14,
);

furnace("Copper_Pipe")
  .input("Ingredient_Treasure_Copper_Pipe")
  .output("Ingredient_Bar_Copper")
  .time(14)
  .build();

furnace("Electrical_Wire")
  .input("Ingredient_Treasure_Electrical_Wire")
  .output("Ingredient_Bar_Copper")
  .time(14)
  .build();

furnace("Plumbing_Joint")
  .input("Ingredient_Treasure_Plumbing_Joint")
  .output("Ingredient_Bar_Iron")
  .time(14)
  .build();

furnace("Tin_Foil")
  .input("Ingredient_Treasure_Tin_Foil")
  .output("Ingredient_Bar_Tin")
  .time(14)
  .build();

salvage("Rag")
  .input("Ingredient_Treasure_Rag")
  .output("Ingredient_Fabric_Scrap_Linen")
  .time(4)
  .build();
salvage("Rope")
  .input("Ingredient_Treasure_Rope")
  .output("3x Ingredient_Fibre")
  .time(4)
  .build();

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

blockSet("Waste").includeBlockTypes(["Waste_Block*"]).build();
hitbox("Bench_Waste_Sorting").build();
