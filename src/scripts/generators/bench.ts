import { global, toPascal, syncJson, syncLang } from "hytale-generators";
import type {
  CommonTypes,
  ItemData as BaseItemData,
  BlockTypes,
} from "hytale-generators";

export interface BenchConfig {
  id: string;
  name?: string;
  baseName?: string;
  description?: string;
  icon?: boolean;
  maxStack?: number;
  customModel?: string;
  customModelTexture?: {
    texture: string;
    weight: number;
  }[];
  particleColor?: string;
  blockSoundSetId?: string;
  blockParticleSetId?: string;
  outputSlotsCount?: number;
  inputFilterValidIngredients?: boolean;
}

export type BenchInput = string | BenchConfig;

export type BenchData = Required<
  Pick<BaseItemData, CommonTypes | BlockTypes> & {
    PlayerAnimationsId: "Block";
  }
>;

class BenchBuilder {
  protected config: Partial<BenchConfig> = {};
  constructor(id: string) {
    this.config.id = id;
  }

  /**
   * Sets the name for the bench
   * @param name The name value
   * @returns The builder instance for chaining
   */
  name(name: string): this {
    this.config.name = name;
    return this;
  }

  /**
   * Sets the base name for the bench
   * @param baseName The base name value
   * @returns The builder instance for chaining
   */
  baseName(baseName: string): this {
    this.config.baseName = baseName;
    return this;
  }

  /**
   * Sets the description for the bench
   * @param description The description value
   * @returns The builder instance for chaining
   */
  description(description: string): this {
    this.config.description = description;
    return this;
  }

  /**
   * Sets whether to generate an icon for the bench
   * @param icon Whether to generate an icon
   * @returns The builder instance for chaining
   */
  icon(icon: boolean): this {
    this.config.icon = icon;
    return this;
  }

  /**
   * Sets the maximum stack size for the bench
   * @param maxStack The maximum stack size
   * @returns The builder instance for chaining
   */
  maxStack(maxStack: number): this {
    this.config.maxStack = maxStack;
    return this;
  }

  /**
   * Sets the custom model for the bench
   * @param customModel The custom model path
   * @returns The builder instance for chaining
   */
  customModel(customModel: string): this {
    this.config.customModel = customModel;
    return this;
  }

  /**
   * Sets the custom model texture for the bench
   * @param customModelTexture The custom model texture configuration
   * @param texture
   * @returns The builder instance for chaining
   */
  customModelTexture(texture: string): this {
    this.config.customModelTexture = [{ texture, weight: 1 }];
    return this;
  }

  /**
   * Sets the particle color for the bench
   * @param particleColor The particle color
   * @returns The builder instance for chaining
   */
  particleColor(particleColor: string): this {
    this.config.particleColor = particleColor;
    return this;
  }

  /**
   * Sets the block sound set id for the bench
   * @param blockSoundSetId The block sound set id
   * @returns The builder instance for chaining
   */
  blockSoundSetId(blockSoundSetId: string): this {
    this.config.blockSoundSetId = blockSoundSetId;
    return this;
  }

  /**
   * Sets the block particle set id for the bench
   * @param blockParticleSetId The block particle set id
   * @returns The builder instance for chaining
   */
  blockParticleSetId(blockParticleSetId: string): this {
    this.config.blockParticleSetId = blockParticleSetId;
    return this;
  }

  /**
   * Sets the output slots count for the bench
   * @param outputSlotsCount The output slots count
   * @returns The builder instance for chaining
   */
  outputSlotsCount(outputSlotsCount: number): this {
    this.config.outputSlotsCount = outputSlotsCount;
    return this;
  }

  /**
   * Sets whether to filter valid ingredients for the bench
   * @param inputFilterValidIngredients Whether to filter valid ingredients
   * @returns The builder instance for chaining
   */
  inputFilterValidIngredients(inputFilterValidIngredients: boolean): this {
    this.config.inputFilterValidIngredients = inputFilterValidIngredients;
    return this;
  }

  /**
   * Builds and outputs the bench configuration
   * This method will sync the JSON and language files
   */
  build(): void {
    const { modId, outDir } = global();
    const {
      id,
      name,
      baseName,
      description,
      icon,
      customModel,
      customModelTexture,
      particleColor,
      blockSoundSetId,
      blockParticleSetId,
      outputSlotsCount,
      inputFilterValidIngredients,
      maxStack,
    } = this.config as BenchConfig;

    syncJson<BenchData>(
      `${outDir}/Server/Item/Items/Benches/${id}`,
      toPascal({
        translationProperties: {
          name: `server.items.${modId}.${id}.name`,
          description: `server.items.${modId}.${id}.description`,
        },
        icon: icon ? `Icons/ItemsGenerated/${id}.png` : undefined,
        categories: ["Furniture.Benches", "Waste.Tools"],
        blockType: {
          material: "Solid" as const,
          drawType: "Model" as const,
          opacity: "Transparent" as const,
          customModel: customModel || `Blocks/Benches/${id}.blockymodel`,
          customModelTexture: customModelTexture || [
            {
              texture: `Blocks/Benches/${id}.png`,
              weight: 1,
            },
          ],
          variantRotation: "NESW",
          bench: {
            type: "Processing",
            input: [
              {
                filterValidIngredients:
                  inputFilterValidIngredients !== undefined
                    ? inputFilterValidIngredients
                    : true,
              },
            ],
            localOpenSoundEventId: "SFX_Workbench_Open",
            localCloseSoundEventId: "SFX_Workbench_Close",
            completedSoundEventId: "SFX_Workbench_Craft",
            failedSoundEventId: "SFX_Generic_Crafting_Failed",
            benchUpgradeSoundEventId: "SFX_Workbench_Upgrade_Start_Default",
            benchUpgradeCompletedSoundEventId:
              "SFX_Workbench_Upgrade_Complete_Default",
            outputSlotsCount: outputSlotsCount || 6,
            id: id,
          },
          state: {
            id: "processingBench",
          },
          gathering: {
            breaking: {
              gatherType: "Benches",
              dropList: {
                container: {
                  type: "Multiple" as const,
                  containers: [
                    {
                      type: "Single" as const,
                      item: { itemId: id },
                    },
                  ] as const,
                },
              },
            },
          },
          hitboxType: id,
          blockParticleSetId: blockParticleSetId || "Wood",
          particleColor: particleColor || "#6e4a2f",
          support: {
            down: [
              {
                faceType: "Full",
              },
            ],
          },
          blockSoundSetId: blockSoundSetId || "Stone",
          interactions: {
            use: "Open_Processing_Bench",
          },
        },
        playerAnimationsId: "Block" as const,
        iconProperties: {
          scale: 0.5,
          rotation: [22.5, 45, 22.5],
          translation: [1, -17.4],
        },
        tags: {
          type: ["Bench"],
        },
        maxStack: maxStack || 1,
        itemSoundSetId: "ISS_Blocks_Stone",
      }),
    );

    syncLang([
      {
        key: `items.${modId}.${id}.name`,
        value: name ?? baseName ?? id.replace(/_/g, " "),
      },
      ...(description
        ? [
            {
              key: `items.${modId}.${id}.description`,
              value: description,
            },
          ]
        : []),
    ]);
  }
}

/**
 * Director function that returns a new WasteBuilder instance
 * @param id
 * @returns A new builder instance
 * @example
 * waste("Waste")
 *   .color("#CCCCCC")
 *   .build();
 */
export function bench(icon: boolean, id: string): BenchBuilder {
  return new BenchBuilder(id).icon(icon);
}
