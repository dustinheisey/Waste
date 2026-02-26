import type { Pascal } from "hytale-generators";
import { global, syncJson, toPascal } from "hytale-generators";

export type Vector3d = { x: number; y: number; z: number };
export interface HitboxConfig {
  id: string;
  min: Vector3d;
  max: Vector3d;
}

export type HitboxData = Pascal<{
  boxes: {
    min: Vector3d;
    max: Vector3d;
  }[];
}>;

/**
 * Builder class for creating hitbox configurations
 */
class HitboxBuilder {
  private config: HitboxConfig;

  /**
   * Creates a new HitboxBuilder instance
   * @param id
   * @returns A new builder instance
   */
  static create(id: string): HitboxBuilder {
    return new HitboxBuilder(id);
  }

  private constructor(id: string) {
    this.config = {
      id,
      min: { x: 0, y: 0, z: 0 },
      max: { x: 1, y: 1, z: 1 },
    };
  }

  /**
   * Sets the minimum coordinates for the hitbox
   * @param x The x coordinate
   * @param y The y coordinate (optional, defaults to x)
   * @param z The z coordinate (optional, defaults to x)
   * @returns The builder instance for chaining
   */
  min(x: number, y?: number, z?: number): this {
    this.config.min = z && y ? { x, y, z } : { x, y: x, z: x };
    return this;
  }

  /**
   * Sets the maximum coordinates for the hitbox
   * @param x The x coordinate
   * @param y The y coordinate (optional, defaults to x)
   * @param z The z coordinate (optional, defaults to x)
   * @returns The builder instance for chaining
   */
  max(x: number, y?: number, z?: number): this {
    this.config.max = z && y ? { x, y, z } : { x, y: x, z: x };
    return this;
  }

  /**
   * Builds and outputs the hitbox configuration
   * This method will sync the JSON file
   */
  build(): void {
    syncJson<HitboxData>(
      `${global().outDir}/Server/Item/Block/Hitboxes/${this.config.id}`,
      toPascal({
        boxes: [{ min: this.config.min, max: this.config.max }],
      }),
    );
  }
}

/**
 * Director function that returns a new HitboxBuilder instance
 * @param id
 * @returns A new builder instance
 * @example
 * hitbox()
 *   .min(0, 0, 0)
 *   .max(2, 2, 2)
 *   .build();
 */
export function hitbox(id: string): HitboxBuilder {
  return HitboxBuilder.create(id);
}
