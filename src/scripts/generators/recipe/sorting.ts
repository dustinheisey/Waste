import {
  global,
  syncJson,
  toPascal,
  parseIngredient,
  type Ingredient,
} from "hytale-generators";

export type SortingRecipeData = {
  Input: Ingredient[];
  PrimaryOutput: Ingredient;
  Output: Ingredient[];
  BenchRequirement: {
    Type: "Processing";
    Id: "Bench_Waste_Sorting";
  }[];
  TimeSeconds: number;
};

export interface SortingRecipeConfig {
  id: string;
  input: Ingredient[];
  primaryOutput?: Ingredient;
  output: Ingredient[];
  time: number;
}

export class SortingRecipeBuilder {
  private config: Partial<SortingRecipeConfig> = {};

  constructor(id: string) {
    this.config.id = id;
  }

  /**
   * Sets the input items for the recipe
   * @param input The input items configuration
   * @returns The builder instance for chaining
   */
  input(input: string | string[]): this {
    this.config.input =
      typeof input === "string"
        ? [parseIngredient(input)]
        : input.map((put) => parseIngredient(put));
    return this;
  }

  /**
   * Sets the primary output for the recipe
   * @param primaryOutput The primary output configuration
   * @returns The builder instance for chaining
   */
  primaryOutput(primaryOutput: string): this {
    this.config.primaryOutput = parseIngredient(primaryOutput);
    return this;
  }

  /**
   * Sets the output items for the recipe
   * @param output The output items configuration
   * @returns The builder instance for chaining
   */
  output(output: string | string[]): this {
    this.config.output =
      typeof output === "string"
        ? [parseIngredient(output)]
        : output.map((put) => parseIngredient(put));
    return this;
  }

  /**
   * Sets the time in seconds for the recipe
   * @param timeSeconds The time in seconds
   * @param time
   * @returns The builder instance for chaining
   */
  time(time: number): this {
    this.config.time = time;
    return this;
  }

  /**
   * Builds and outputs the recipe configuration
   * This method will sync the JSON file
   */
  build(): void {
    const { outDir } = global();
    const { id, input, primaryOutput, output, time } = this
      .config as SortingRecipeConfig;

    syncJson<SortingRecipeData>(
      `${outDir}/Server/Item/Recipes/Sorting/Sorting_${id}`,
      toPascal({
        input,
        primaryOutput: primaryOutput ?? {
          itemId: "",
          quantity: 1,
        },
        output,
        benchRequirement: [
          {
            type: "Processing" as const,
            id: "Bench_Waste_Sorting" as const,
          },
        ],
        timeSeconds: time,
      }),
    );
  }
}

/**
 * Factory function to create a new SortingRecipeBuilder
 * @param id The recipe ID
 * @returns A new builder instance
 */
export function sorting(id: string): SortingRecipeBuilder {
  return new SortingRecipeBuilder(id);
}
