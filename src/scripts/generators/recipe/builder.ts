import {
  global,
  syncJson,
  toPascal,
  parseIngredient,
  type Ingredient,
} from "hytale-generators";

export type BuilderRecipeData = {
  Input: Ingredient[];
  PrimaryOutput: Ingredient;
  BenchRequirement: {
    type: "StructuralCrafting";
    id: "Builders";
  }[];
};

export interface BuilderRecipeConfig {
  id: string;
  input: Ingredient[];
  primaryOutput: Ingredient;
}

export class BuilderRecipeBuilder {
  private config: Partial<BuilderRecipeConfig> = {};

  constructor(id: string) {
    this.config.id = id;
  }

  /**
   * Sets the input items for the recipe
   * @param input The input items configuration
   * @returns The builder instance for chaining
   */
  input(input: string): this {
    this.config.input = [parseIngredient(input)];
    return this;
  }

  /**
   * Sets the primaryOutput for the recipe
   * @param primaryOutput The primaryOutput configuration
   * @returns The builder instance for chaining
   */
  output(primaryOutput: string): this {
    this.config.primaryOutput = parseIngredient(primaryOutput);
    return this;
  }

  /**
   * Builds and outputs the recipe configuration
   * This method will sync the JSON file
   */
  build(): void {
    const { outDir } = global();
    const { id, input, primaryOutput } = this.config as BuilderRecipeConfig;

    syncJson<BuilderRecipeData>(
      `${outDir}/Server/Item/Recipes/Builder/Builder_${id}`,
      toPascal({
        input,
        primaryOutput,
        benchRequirement: [
          {
            type: "StructuralCrafting",
            id: "Builders",
          },
        ],
      }),
    );
  }
}

/**
 * Factory function to create a new BuilderRecipeBuilder
 * @param id The recipe ID
 * @returns A new builder instance
 */
export function builder(id: string): BuilderRecipeBuilder {
  return new BuilderRecipeBuilder(id);
}
