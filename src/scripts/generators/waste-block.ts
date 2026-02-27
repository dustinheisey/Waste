import type { ItemData as BaseItemData, BlockTypes, CommonTypes, MaskVariant } from "hytale-generators";
import { global, syncJson, syncLang, toPascal, type Tab } from "hytale-generators";

export type WasteBlockData = Required<
  Pick<BaseItemData, CommonTypes | BlockTypes> & {
    PlayerAnimationsId: "Block";
  }
>;

export interface WasteBlockConfig {
  id: string;
  color: string;
  quality?: "Common" | "Uncommon" | "Rare" | "Epic" | "Legendary";
  transitionTexture?: string;
  transitionToGroups?: string[];
  gatherType?: string;
  drop?: string;
  dropQuantity?: number;
  dropQuality?: number;
  icon?: boolean;
  name?: string;
  baseName?: string;
  description?: string;
  categories?: Tab[];
  model?: string;
  mask?: string;
  maskVariant?: MaskVariant;
  textures?: string[];
  texture?: string;
  textureOut?: string;
  maxStack?: number;
  itemLevel?: number;
}

export type WasteBlockInput = string | WasteBlockConfig;

class WasteBlockBuilder {
  protected config: Partial<WasteBlockConfig> = {};

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
   * Sets the texture for the item
   * @param texture The texture path
   * @returns The builder instance for chaining
   */
  texture(texture: string): this {
    this.config.texture = texture;
    return this;
  }

  /**
   * Sets the textures for the item
   * @param textures The textures path
   * @returns The builder instance for chaining
   */
  textures(textures: string[]): this {
    this.config.textures = textures;
    return this;
  }

  /**
   * Sets the output texture path for the item
   * @param textureOut The output texture path
   * @returns The builder instance for chaining
   */
  textureOut(textureOut: string): this {
    this.config.textureOut = textureOut;
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
   * Sets the quality for the item
   * @param quality The quality level
   * @returns The builder instance for chaining
   */
  quality(quality: "Common" | "Uncommon" | "Rare" | "Epic" | "Legendary"): this {
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
   * @param drop The drop level
   * @returns The builder instance for chaining
   */
  drop(drop: string): this {
    this.config.drop = drop;
    return this;
  }

  /**
   * Sets the dropQuantity for the item
   * @param dropQuantity The dropQuantity level
   * @returns The builder instance for chaining
   */
  dropQuantity(dropQuantity: number): this {
    this.config.dropQuantity = dropQuantity;
    return this;
  }

  /**
   * Sets the dropQuality for the item
   * @param dropQuality The dropQuality level
   * @returns The builder instance for chaining
   */
  dropQuality(dropQuality: number): this {
    this.config.dropQuality = dropQuality;
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
      textures,
      icon,
      name,
      baseName,
      description,
      maxStack,
      color,
      quality,
      gatherType,
      transitionTexture,
      transitionToGroups,
      drop,
      dropQuality,
      dropQuantity
    } = this.config as WasteBlockConfig;

    syncJson<WasteBlockData>(
      `${outDir}/Server/Item/Items/Blocks/Waste/Waste_Block_${id}`,
      toPascal({
        translationProperties: {
          name: `server.items.${modId}.Waste_Block_${id}.name`,
          description: `server.items.${modId}.Waste_Block_${id}.description`
        },
        categories: [...(categories ?? ""), `Waste.Wastes`],
        playerAnimationsId: "Block" as const,
        quality: quality ?? "Common",
        blockType: {
          material: "Solid" as const,
          drawType: "Cube" as const,
          group: "Waste",
          flags: {},
          gathering: {
            breaking: {
              gatherType: gatherType ?? "Rocks",
              ...(dropQuality ? { quality: dropQuality } : {}),
              ...(dropQuantity ? { quantity: dropQuantity } : {}),
              itemId: drop ?? "Ingredient_Waste_Waste"
            }
          },
          blockParticleSetId: "Sand",
          textures: textures?.map((texture, index) => ({
            all: `BlockTextures/${texture}_${(index++).toString()}.png`
          })) ?? [
            {
              all: `BlockTextures/Waste/Waste_Block_${id}_1.png`
            },
            {
              all: `BlockTextures/Waste/Waste_Block_${id}_2.png`
            },
            {
              all: `BlockTextures/Waste/Waste_Block_${id}_3.png`
            },
            {
              all: `BlockTextures/Waste/Waste_Block_${id}_4.png`
            }
          ],
          particleColor: color ?? "#3d3e3e",
          blockSoundSetId: "Gravel",
          cubeShadingMode: "Flat",
          ...(transitionTexture && transitionToGroups
            ? {
                transitionTexture,
                transitionToGroups
              }
            : {})
        },
        iconProperties: {
          scale: 0.58823,
          rotation: [22.5, 45, 22.5],
          translation: [0, -13.5]
        },
        ...(icon ? { icon: `Icons/ItemsGenerated/Waste_Block_${id}.png` } : {}),
        tags: {
          type: ["Waste"]
        },
        maxStack: maxStack ?? 100,
        itemSoundSetId: "ISS_Blocks_Soft"
      })
    );

    syncLang([
      {
        key: `items.${modId}.Waste_Block_${id}.name`,
        value: name ?? `${baseName ?? id.replace(/_/g, " ")} Waste Block`
      },
      ...(description
        ? [
            {
              key: `items.${modId}.Waste_Block_${id}.description`,
              value: description
            }
          ]
        : [])
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
export function wasteBlock(icon: boolean, id: string): WasteBlockBuilder {
  return new WasteBlockBuilder(id).icon(icon);
}

/**
 * Function to create multiple waste blocks at once
 * @param configs Array of waste configurations (strings or objects)
 */
export function wasteBlocks(icon: boolean, configs: WasteBlockInput[]): void {
  configs.forEach(config => {
    if (typeof config === "string") {
      const builder = wasteBlock(icon, config);
      builder.build();
    } else {
      const builder = wasteBlock(icon, config.id);

      Object.entries(config).forEach(([key, value]) => {
        if (key !== "id") {
          (builder as any)[key](value);
        }
      });

      builder.build();
    }
  });
}
