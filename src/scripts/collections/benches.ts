import type { BenchCfg } from "hytale-generators";
import { bench, flatten, hitbox } from "hytale-generators";
import type { Cfg, HasRecipes } from "../index.types.ts";
import { recipes } from "../index.types.ts";

const benches: Cfg<BenchCfg & { hitbox: number[] } & HasRecipes<"workbench">> = {
  dump: [
    {
      id: "Bench_Waste_Sorting",
      name: "Waste Sorting Bench",
      description: "Used to sort waste and find treasures amidst the refuse.",
      color: "#6e4a2f",
      filterValidIngredients: true,
      outputSlotsCount: 6,
      hitbox: [0, 1],
      icon: true,
      workbench: {
        input: ["6x $Wood_Trunk", "6x $Rock"],
        categories: ["Workbench_Crafting"],
      }
    }
  ]
};

/** Registration for crafting benches */
export const registerBenches = () => {
  bench.many(benches).build();
  flatten(benches).forEach(cfg => {
    hitbox(cfg.id).min(cfg.hitbox[0]).max(cfg.hitbox[1]).build();
  });
  recipes("", benches);
};
