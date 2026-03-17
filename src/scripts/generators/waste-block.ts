import type { BlockCfg, HasDrops } from "hytale-generators";
import { builder, fragments, global, json, lang } from "hytale-generators";
import type { SetOptional } from "type-fest";

export type WasteBlockCfg = SetOptional<BlockCfg, "color"> & HasDrops & { textures?: string[]; transition?: boolean };

export const wasteBlock = builder({
  build: (cfg: WasteBlockCfg) => {
    const { modId } = global();
    const { withIcon } = fragments;
    const {
      id,
      icon,
      dropQuality,
      dropQuantity,
      drops,
      transition,
      categories,
      name,
      baseName,
      description,
      maxStack,
      color,
      set,
      group,
      model,
      texture,
      textures,
      gatherType,
      transitionTexture,
      transitionToGroups,
      particleSetId
    } = cfg;

    json(`Server/Item/Items/Blocks/Waste/Waste_Block_${id}`, {
      translationProperties: {
        name: `server.items.${modId}.Waste_Block_${id}.name`,
        description: `server.items.${modId}.Waste_Block_${id}.description`
      },
      ...withIcon(cfg),
      itemLevel: 10,
      maxStack: maxStack ?? 100,
      categories: [...(categories ?? ""), `Waste.Wastes`],
      playerAnimationsId: "Block" as const,
      ...(set ? { set } : {}),
      blockType: {
        material: "Solid" as const,
        drawType: model ? ("Model" as const) : ("Cube" as const),
        ...(group ? { group } : {}),
        ...(model ? { customModel: `${model}.blockymodel` } : {}),
        ...(texture
          ? {
              customModelTexture: [
                {
                  Texture: `${texture}.png`,
                  Weight: 1
                }
              ]
            }
          : {}),
        flags: {},
        gathering: {
          breaking: {
            gatherType: gatherType ?? "Rocks",
            ...(dropQuality ? { quality: dropQuality } : {}),
            ...(dropQuantity ? { quantity: dropQuantity } : {}),
            itemId: drops ?? "Ingredient_Waste_Loose"
          }
        },
        blockParticleSetId: particleSetId ?? "Stone",
        ...(!model
          ? {
              textures: textures?.map((texture, index) => ({
                all: `BlockTextures/${texture}_${(index + 1).toString()}.png`
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
              ]
            }
          : {}),
        particleColor: color ?? "#3d3e3e",
        blockSoundSetId: "Stone",
        ...(transition || (transitionTexture && transitionToGroups)
          ? {
              transitionTexture: `BlockTextures/Waste/${transitionTexture ?? `Transition_Waste_Block_${id}`}.png`,
              transitionToGroups: transitionToGroups ?? ["Stone", "Lava", "Dirt"]
            }
          : {})
      },
      iconProperties: {
        scale: 0.58823,
        rotation: [22.5, 45, 22.5],
        translation: [0, -13.5]
      },
      tags: {
        type: ["Waste"]
      },
      ...(icon ? { icon: `Icons/ItemsGenerated/Waste_Block_${id}.png` } : {}),
      itemSoundSetId: "ISS_Blocks_Soft"
    });

    lang([
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
});
