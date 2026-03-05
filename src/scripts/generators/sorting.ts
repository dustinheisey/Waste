import type { HasId, HasMultipleOutputs, HasSingleInput, HasTime } from "hytale-generators";
import { builder, json, parseIngredients } from "hytale-generators";

export type SortingRecipeCfg = HasId & HasSingleInput & HasMultipleOutputs & HasTime;
export type SimpleSortingRecipeCfg = Omit<SortingRecipeCfg, "id" | "input">;

export const sorting = builder({
  build: (cfg: SortingRecipeCfg) => {
    const { id, input, output, time } = cfg;
    json(`/Server/Item/Recipes/Sorting/Sorting_${id}`, {
      input: parseIngredients(input),
      primaryOutput: parseIngredients(output)[0],
      output: parseIngredients(output),
      benchRequirement: [
        {
          type: "Processing" as const,
          id: "Bench_Waste_Sorting" as const
        }
      ],
      timeSeconds: time
    });
  }
});
