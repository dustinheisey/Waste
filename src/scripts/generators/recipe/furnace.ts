import {
  global,
  syncJson,
  toPascal,
  parseIngredient,
  type Ingredient,
} from "hytale-generators";

type FurnaceTier = 1 | 2;
export type FurnaceRecipeData = {
  Input: Ingredient[];
  PrimaryOutput: Ingredient;
  BenchRequirement: {
    Type: "Processing";
    Id: "Furnace";
    RequiredTierLevel: FurnaceTier;
  }[];
  TimeSeconds: number;
};

export interface FurnaceRecipeConfig {
  id: string;
  input: Ingredient[];
  output: Ingredient;
  tier?: FurnaceTier;
  time: number;
}

export class FurnaceRecipeBuilder {
  private config: Partial<FurnaceRecipeConfig> = {};

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
   * Sets the output for the recipe
   * @param output The output configuration
   * @returns The builder instance for chaining
   */
  output(output: string): this {
    this.config.output = parseIngredient(output);
    return this;
  }

  /**
   * Sets the tier in seconds for the recipe
   * @param tier The tier in seconds
   * @returns The builder instance for chaining
   */
  tier(tier: FurnaceTier): this {
    this.config.tier = tier;
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
    const { id, input, output, time, tier } = this
      .config as FurnaceRecipeConfig;

    syncJson<FurnaceRecipeData>(
      `${outDir}/Server/Item/Recipes/Furnace/Furnace_${id}`,
      toPascal({
        input,
        primaryOutput: output,
        benchRequirement: [
          {
            type: "Processing" as const,
            id: "Furnace" as const,
            requiredTierLevel: tier ?? 1,
          },
        ],
        timeSeconds: time,
      }),
    );
  }
}

/**
 * Factory function to create a new FurnaceRecipeBuilder
 * @param id The recipe ID
 * @returns A new builder instance
 */
export function furnace(id: string): FurnaceRecipeBuilder {
  return new FurnaceRecipeBuilder(id);
}
