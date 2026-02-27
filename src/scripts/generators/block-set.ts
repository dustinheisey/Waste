import type { Pascal } from "hytale-generators";
import { global, syncJson, toPascal } from "hytale-generators";

export interface BlockSetConfig {
  id: string;
  includeAll?: boolean;
  includeBlockTypes?: string[] | null;
  excludeBlockTypes?: string[] | null;
  includeBlockGroups?: string[] | null;
  excludeBlockGroups?: string[] | null;
  includeHitboxTypes?: string[] | null;
  excludeHitboxTypes?: string[] | null;
  includeCategories?: string[][] | null;
  excludeCategories?: string[][] | null;
}

export type BlockSetData = Pascal<BlockSetConfig>;

/**
 * Builder class for creating blockSet configurations
 */
class BlockSetBuilder {
  private config: Partial<BlockSetConfig> = {};

  /**
   * Creates a new BlockSetBuilder instance
   * @param id
   * @returns A new builder instance
   */
  static create(id: string): BlockSetBuilder {
    return new BlockSetBuilder(id);
  }

  private constructor(id: string) {
    this.config.id = id;
  }

  /**
   * Sets whether to include all blocks
   * @param includeAll Whether to include all blocks
   * @returns The builder instance for chaining
   */
  includeAll(includeAll: boolean): this {
    this.config.includeAll = includeAll;
    return this;
  }

  /**
   * Sets the block types to include
   * @param blockTypes The block types to include
   * @returns The builder instance for chaining
   */
  includeBlockTypes(blockTypes: string[] | null): this {
    this.config.includeBlockTypes = blockTypes;
    return this;
  }

  /**
   * Sets the block types to exclude
   * @param blockTypes The block types to exclude
   * @returns The builder instance for chaining
   */
  excludeBlockTypes(blockTypes: string[] | null): this {
    this.config.excludeBlockTypes = blockTypes;
    return this;
  }

  /**
   * Sets the block groups to include
   * @param blockGroups The block groups to include
   * @returns The builder instance for chaining
   */
  includeBlockGroups(blockGroups: string[] | null): this {
    this.config.includeBlockGroups = blockGroups;
    return this;
  }

  /**
   * Sets the block groups to exclude
   * @param blockGroups The block groups to exclude
   * @returns The builder instance for chaining
   */
  excludeBlockGroups(blockGroups: string[] | null): this {
    this.config.excludeBlockGroups = blockGroups;
    return this;
  }

  /**
   * Sets the hitbox types to include
   * @param hitboxTypes The hitbox types to include
   * @returns The builder instance for chaining
   */
  includeHitboxTypes(hitboxTypes: string[] | null): this {
    this.config.includeHitboxTypes = hitboxTypes;
    return this;
  }

  /**
   * Sets the hitbox types to exclude
   * @param hitboxTypes The hitbox types to exclude
   * @returns The builder instance for chaining
   */
  excludeHitboxTypes(hitboxTypes: string[] | null): this {
    this.config.excludeHitboxTypes = hitboxTypes;
    return this;
  }

  /**
   * Sets the categories to include
   * @param categories The categories to include
   * @returns The builder instance for chaining
   */
  includeCategories(categories: string[][] | null): this {
    this.config.includeCategories = categories;
    return this;
  }

  /**
   * Sets the categories to exclude
   * @param categories The categories to exclude
   * @returns The builder instance for chaining
   */
  excludeCategories(categories: string[][] | null): this {
    this.config.excludeCategories = categories;
    return this;
  }

  /**
   * Builds and outputs the blockSet configuration
   * This method will sync the JSON file
   */
  build(): void {
    const { outDir } = global();
    const {
      config: { id, ...blockSetConfig },
    } = this;

    syncJson<BlockSetData>(
      `${outDir}/Server/Item/Block/Sets/${id}`,
      toPascal(blockSetConfig as BlockSetConfig),
    );
  }
}

/**
 * Director function that returns a new BlockSetBuilder instance
 * @param id
 * @returns A new builder instance
 * @example
 * blockSet("my-blockSet")
 *   .includeAll(true)
 *   .includeBlockTypes(["stone", "dirt"])
 *   .build();
 */
export function blockSet(id: string): BlockSetBuilder {
  return BlockSetBuilder.create(id);
}
