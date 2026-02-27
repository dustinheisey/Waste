import { workbench } from "hytale-generators";
import { hitbox } from "../generators/hitbox.ts";
import { bench } from "../generators/bench.ts";

export function generateBenches() {
  // ? Waste Sorting Bench
  bench(true, "Bench_Waste_Sorting")
    .name("Waste Sorting Bench")
    .description("Used to sort waste and find treasures amidst the refuse.")
    .build();

  hitbox("Bench_Waste_Sorting").build();

  workbench(
    "Workbench_Bench_Waste_Sorting",
    "Workbench_Crafting",
    ["6x $Wood_Trunk", "6x $Rock"],
    "Bench_Waste_Sorting",
    14,
  );

  // ? Industrial Waste Sorter
}
