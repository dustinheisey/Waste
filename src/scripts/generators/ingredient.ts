import {
  global,
  syncJson,
  syncLang,
  toPascal,
  type Tab,
} from "hytale-generators";
import type {
  CommonTypes,
  ItemData as BaseItemData,
  ItemTypes,
  MaskVariant,
} from "hytale-generators";

export type ItemData = Required<
  Pick<BaseItemData, CommonTypes | ItemTypes> & {
    PlayerAnimationsId: "Item";
  }
>;

export interface ItemConfig {
  id: string;
  color?: string;
  icon?: boolean;
  name?: string;
  baseName?: string;
  description?: string;
  categories?: Tab[];
  model?: string;
  mask?: string;
  maskVariant?: MaskVariant;
  texture?: string;
  textureOut?: string;
  maxStack?: number;
  quality?: "Common" | "Uncommon" | "Rare" | "Epic" | "Legendary";
  itemLevel?: number;
}

export type ItemInput = string | ItemConfig;

class IngredientBuilder {
  protected config: Partial<ItemConfig> = {};
  protected itemType: string;

  constructor(id: string, itemType: string) {
    this.config.id = id;
    this.itemType = itemType;
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
  quality(
    quality: "Common" | "Uncommon" | "Rare" | "Epic" | "Legendary",
  ): this {
    this.config.quality = quality;
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
      model,
      texture,
      icon,
      name,
      baseName,
      description,
      maxStack,
      quality,
      itemLevel,
    } = this.config as ItemConfig;

    syncJson<ItemData>(
      `${outDir}/Server/Item/Items/Ingredients/${this.itemType}/Ingredient_${this.itemType}_${id}`,
      toPascal({
        translationProperties: {
          name: `server.items.${modId}.Ingredient_${this.itemType}_${id}.name`,
          description: `server.items.${modId}.Ingredient_${this.itemType}_${id}.description`,
        },
        categories: categories ?? [
          "Items.Ingredients",
          `Waste.${this.itemType}`,
        ],
        model: `Items/${model ?? "Item"}.blockymodel`,
        texture: `Items/${texture ?? `${this.itemType}/${id}`}.png`,
        quality: quality ?? "Common",
        itemLevel: itemLevel ?? 10,
        playerAnimationsId: "Item" as const,
        iconProperties: {
          scale: 0.8,
          rotation: [0, 0, 0],
          translation: this.itemType === "Waste" ? [0, -13.5] : [-1, -16],
        },
        tags: {
          type: ["Ingredient"],
        },
        itemEntity: {
          particleSystemId: null as unknown as undefined,
        },
        maxStack: maxStack ?? 100,
        resourceTypes: [{ id: this.itemType + "s" }],
        itemSoundSetId: "ISS_Items_Ingots",
        dropOnDeath: true,
        ...(icon
          ? {
              icon: `Icons/ItemsGenerated/Ingredient_${this.itemType}_${id}.png`,
            }
          : {}),
      }),
    );

    syncLang([
      {
        key: `items.${modId}.Ingredient_${this.itemType}_${id}.name`,
        value: name ?? baseName ?? id.replace(/_/g, " "),
      },
      ...(description
        ? [
            {
              key: `items.${modId}.Ingredient_${this.itemType}_${id}.description`,
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
export function waste(id: string): IngredientBuilder {
  return new IngredientBuilder(id, "Waste");
}

/**
 * Director function that returns a new ScrapBuilder instance
 * @param id
 * @returns A new builder instance
 * @example
 * scrap("Scrap")
 *   .color("#CCCCCC")
 *   .build();
 */
export function scrap(id: string): IngredientBuilder {
  return new IngredientBuilder(id, "Scrap");
}

/**
 * Director function that returns a new TreasureBuilder instance
 * @param id
 * @returns A new builder instance
 * @example
 * treasure("Aluminum_Can")
 *   .color("#CCCCCC")
 *   .quality("Uncommon")
 *   .build();
 */
export function treasure(id: string): IngredientBuilder {
  return new IngredientBuilder(id, "Treasure");
}

/**
 * Function to create multiple ingredients at once
 * @param configs Array of waste configurations (strings or objects)
 * @param func
 */
export function ingredients(
  configs: ItemInput[],
  icon: boolean,
  categories: Tab[],
  func: (id: string) => IngredientBuilder,
): void {
  configs.forEach((config) => {
    if (typeof config === "string") {
      // Handle string input - infer name from ID
      const builder = func(config).icon(icon).categories(categories);
      builder.build();
    } else {
      // Handle object input - use provided config
      const builder = func(config.id).icon(icon).categories(categories);

      // Apply all properties from the config object
      Object.entries(config).forEach(([key, value]) => {
        if (key !== "id") {
          (builder as any)[key](value);
        }
      });

      builder.build();
    }
  });
}

/**
 * Function to create multiple ingredients at once
 * @param configs Array of waste configurations (strings or objects)
 */
export function wastes(icon: boolean, configs: ItemInput[]): void {
  ingredients(configs, icon, ["Items.Ingredients", "Waste.Wastes"], waste);
}

/**
 * Function to create multiple ingredients at once
 * @param configs Array of waste configurations (strings or objects)
 */
export function scraps(icon: boolean, configs: ItemInput[]): void {
  ingredients(configs, icon, ["Items.Ingredients", "Waste.Scraps"], scrap);
}

/**
 * Function to create multiple treasure ingredients at once
 * @param configs Array of treasure configurations (strings or objects)
 */
export function treasures(icon: boolean, configs: ItemInput[]): void {
  ingredients(
    configs,
    icon,
    ["Items.Ingredients", "Waste.Treasures"],
    treasure,
  );
}
