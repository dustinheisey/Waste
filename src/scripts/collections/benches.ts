import type { BenchCfg, Flatten, NoId, WorkbenchCfg } from "hytale-generators";
import { bench, flatten, hitbox, workbench } from "hytale-generators";

const benches: Flatten<BenchCfg & { hitbox: number[]; recipe: NoId<WorkbenchCfg> }> = [
  {
    id: "Bench_Waste_Sorting",
    name: "Waste Sorting Bench",
    description: "Used to sort waste and find treasures amidst the refuse.",
    color: "#6e4a2f",
    filterValidIngredients: true,
    outputSlotsCount: 6,
    hitbox: [0, 1],
    icon: true,
    recipe: {
      categories: ["Workbench_Crafting"],
      input: ["6x $Wood_Trunk", "6x $Rock"],
      output: "Bench_Waste_Sorting",
      time: 14
    }
  }
];

export const registerBenches = () => {
  flatten(benches).forEach(cfg => {
    bench.many([cfg]).build();
    hitbox(cfg.id).min(cfg.hitbox[0]).max(cfg.hitbox[1]).build();
    workbench.many([{ id: cfg.id, ...cfg.recipe }]).build();
  });
};
