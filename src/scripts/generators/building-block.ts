import {
  global,
  resourceType,
  syncJson,
  syncLang,
  toPascal,
  type BlockTexture,
  type Tab,
} from "hytale-generators";
import type {
  CommonTypes,
  ItemData as BaseItemData,
  BlockTypes,
  MaskVariant,
} from "hytale-generators";

export type BuildingBlockData = Required<
  Pick<BaseItemData, CommonTypes | BlockTypes> & {
    PlayerAnimationsId: "Block";
  }
>;

export interface BuildingBlockConfig {
  id: string;
  color: string;
  quality?: "Common" | "Uncommon" | "Rare" | "Epic" | "Legendary";
  transitionTexture?: string;
  transitionToGroups?: string[];
  gatherType?: string;
  drop?: string;
  resourceType?: string;
  set?: string;
  group?: string;
  particleSetId?: string;
  textureOverride?: BlockTexture[];
  icon?: boolean;
  name?: string;
  baseName?: string;
  description?: string;
  categories?: Tab[];
  model?: string;
  mask?: string;
  customModel?: string;
  customModelTexture?: {
    texture: string;
    weight: number;
  }[];
  maskVariant?: MaskVariant;
  textureOut?: string;
  maxStack?: number;
  itemLevel?: number;
}

export type BlockInput = string | BuildingBlockConfig;

class BuildingBlockBuilder {
  protected config: Partial<BuildingBlockConfig> = {};

  constructor(id: string) {
    this.config.id = id;
  }

  /**
   * Sets the color for the item
   * @param color The color value
   * @returns The builder instance for chaining
   */
  color(color: string): this {
    this.config.color = color;
    return this;
  }

  /**
   * Sets whether to generate an icon
   * @param icon Whether to generate an icon
   * @returns The builder instance for chaining
   */
  icon(icon: boolean): this {
    this.config.icon = icon;
    return this;
  }

  /**
   * Sets the name for the item
   * @param name The name value
   * @returns The builder instance for chaining
   */
  name(name: string): this {
    this.config.name = name;
    return this;
  }

  /**
   * Sets the base name for the item
   * @param baseName The base name value
   * @returns The builder instance for chaining
   */
  baseName(baseName: string): this {
    this.config.baseName = baseName;
    return this;
  }

  /**
   * Sets the description for the item
   * @param description The description value
   * @returns The builder instance for chaining
   */
  description(description: string): this {
    this.config.description = description;
    return this;
  }

  /**
   * Sets the categories for the item
   * @param categories The categories array
   * @returns The builder instance for chaining
   */
  categories(categories: Tab[]): this {
    this.config.categories = categories;
    return this;
  }

  /**
   * Sets the model for the item
   * @param model The model path
   * @returns The builder instance for chaining
   */
  model(model: string): this {
    this.config.model = model;
    return this;
  }

  /**
   * Sets the mask for the item
   * @param mask The mask path
   * @returns The builder instance for chaining
   */
  mask(mask: string): this {
    this.config.mask = mask;
    return this;
  }

  /**
   * Sets the mask variant for the item
   * @param maskVariant The mask variant
   * @returns The builder instance for chaining
   */
  maskVariant(maskVariant: MaskVariant): this {
    this.config.maskVariant = maskVariant;
    return this;
  }

  /**
   * Sets the maximum stack size for the item
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
   * Sets the quality for the item
   * @param quality The quality level
   * @returns The builder instance for chaining
   */
  quality(
    quality: "Common" | "Uncommon" | "Rare" | "Epic" | "Legendary",
  ): this {
    this.config.quality = quality;
    return this;
  }

  /**
   * Sets the transitionTexture for the item
   * @param transitionTexture The transitionTexture level
   * @returns The builder instance for chaining
   */
  transitionTexture(transitionTexture: string): this {
    this.config.transitionTexture = transitionTexture;
    return this;
  }

  /**
   * Sets the transitionToGroups for the item
   * @param transitionToGroups The transitionToGroups level
   * @returns The builder instance for chaining
   */
  transitionToGroups(transitionToGroups: string[]): this {
    this.config.transitionToGroups = transitionToGroups;
    return this;
  }

  /**
   * Sets the transitionToGroups for the item
   * @param transitionToGroups The transitionToGroups level
   * @returns The builder instance for chaining
   */
  transition(): this {
    this.config.transitionTexture = `BlockTextures/Waste/Transition_Waste_Block_${this.config.id}.png`;
    this.config.transitionToGroups = ["Stone", "Lava", "Dirt"];
    return this;
  }

  /**
   * Sets the gatherType for the item
   * @param gatherType The gatherType level
   * @returns The builder instance for chaining
   */
  gatherType(gatherType: string): this {
    this.config.gatherType = gatherType;
    return this;
  }

  /**
   * Sets the drop for the item
   * @param drop The drop
   * @returns The builder instance for chaining
   */
  drop(drop: string): this {
    this.config.drop = drop;
    return this;
  }

  /**
   * Sets the resourceType for the item
   * @param resourceType The resourceType
   * @returns The builder instance for chaining
   */
  resourceType(resourceType: string): this {
    this.config.resourceType = resourceType;
    return this;
  }

  /**
   * Sets the blockset for the item
   * @param set The blockset
   * @returns The builder instance for chaining
   */
  set(set: string): this {
    this.config.set = set;
    return this;
  }

  /**
   * Sets the group for the item
   * @param group The group
   * @returns The builder instance for chaining
   */
  group(group: string): this {
    this.config.group = group;
    return this;
  }

  /**
   * Sets the particleSetId for the item
   * @param particleSetId The particleSetId
   * @returns The builder instance for chaining
   */
  particleSetId(particleSetId: string): this {
    this.config.particleSetId = particleSetId;
    return this;
  }

  /**
   * Sets the textureOverride for the item
   * @param textureOverride The textureOverride
   * @returns The builder instance for chaining
   */
  texture(textureOverride: BlockTexture[]): this {
    this.config.textureOverride = textureOverride;
    return this;
  }

  /**
   * Sets the item level for the item
   * @param itemLevel The item level
   * @returns The builder instance for chaining
   */
  itemLevel(itemLevel: number): this {
    this.config.itemLevel = itemLevel;
    return this;
  }

  /**
   * Builds and outputs the item configuration
   * This method will sync the JSON, language, and texture files
   */
  build(): void {
    const { modId, outDir } = global();
    const {
      id,
      categories,
      icon,
      name,
      baseName,
      description,
      maxStack,
      color,
      set,
      group,
      particleSetId,
      textureOverride,
      resourceType,
      customModel,
      customModelTexture,
      gatherType,
      transitionTexture,
      transitionToGroups,
    } = this.config as BuildingBlockConfig;

    syncJson<BuildingBlockData>(
      `${outDir}/Server/Item/Items/Blocks/Building/${id}`,
      toPascal({
        translationProperties: {
          name: `server.items.${modId}.${id}.name`,
          description: `server.items.${modId}.${id}.description`,
        },
        itemLevel: 10,
        maxStack: maxStack ?? 100,
        ...(icon ? { icon: `Icons/ItemsGenerated/${id}.png` } : {}),
        categories: [...(categories ?? ""), `Waste.Blocks`],
        playerAnimationsId: "Block" as const,
        ...(set ? { set } : {}),
        blockType: {
          material: "Solid" as const,
          drawType: customModel ? ("Model" as const) : ("Cube" as const),
          ...(group ? { group } : {}),
          ...(customModel ? { customModel } : {}),
          ...(customModelTexture ? { customModelTexture } : {}),
          flags: {},
          gathering: {
            breaking: {
              gatherType: gatherType ?? "Rocks",
            },
          },
          blockParticleSetId: particleSetId ?? "Stone",
          ...(!customModel
            ? {
                textures: textureOverride ?? [
                  {
                    all: `BlockTextures/Building/${id}.png`,
                  },
                ],
              }
            : {}),
          particleColor: color ?? "#3d3e3e",
          blockSoundSetId: "Stone",
          ...(transitionTexture && transitionToGroups
            ? {
                transitionTexture,
                transitionToGroups,
              }
            : {}),
        },
        tags: {
          type: ["Rock"],
        },
        ...(resourceType
          ? {
              resourceTypes: [
                {
                  id: resourceType,
                },
              ],
            }
          : {}),
        itemSoundSetId: "ISS_Blocks_Stone",
      }),
    );

    syncLang([
      {
        key: `items.${modId}.${id}.name`,
        value: name ?? `${baseName ?? id.replace(/_/g, " ")}`,
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
export function buildingBlock(icon: boolean, id: string): BuildingBlockBuilder {
  return new BuildingBlockBuilder(id).icon(icon);
}

/**
 * Function to create multiple waste blocks at once
 * @param configs Array of waste configurations (strings or objects)
 */
export function buildingBlocks(icon: boolean, configs: BlockInput[]): void {
  configs.forEach((config) => {
    if (typeof config === "string") {
      const builder = buildingBlock(icon, config);
      builder.build();
    } else {
      const builder = buildingBlock(icon, config.id);

      Object.entries(config).forEach(([key, value]) => {
        if (key !== "id") {
          (builder as any)[key](value);
        }
      });

      builder.build();
    }
  });
}
