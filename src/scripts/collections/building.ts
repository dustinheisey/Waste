import {
  blockSet,
  type BlockSetCfg,
  type BuilderRecipeCfg,
  builders,
  buildingBlock,
  type BuildingBlockCfg,
  type Flatten,
  flatten,
  makeBuilding,
  type NoId,
  palette,
  resourceType,
  type ResourceTypeCfg
} from "hytale-generators";

const resourceTypes: Flatten<BlockSetCfg & ResourceTypeCfg> = [
  { id: "Plastic", includeBlockTypes: [`Block_Plastic*`, `Brick_Plastic*`] },
  { id: "Fabric", includeBlockTypes: [`Block_Fabric*`, `Brick_Fabric*`] }
];

const buildingBlocks: Flatten<
  BuildingBlockCfg & { building?: NoId<BuilderRecipeCfg>; builders?: NoId<BuilderRecipeCfg>[] }
> = [
  {
    id: "Block_Plastic",
    name: "Plastic Block",
    icon: true,
    color: "#37689F",
    resourceType: `Plastics`,
    builders: [makeBuilding(`Ingredient_Bar_Plastic`, `Block_Plastic`), makeBuilding(`$Plastics`, `Block_Plastic`)]
  },
  {
    id: "Bricks_Plastic_Assorted",
    name: "Assorted Plastic Bricks",
    color: "#444444",
    icon: true,
    resourceType: "Plastics",
    model: "Blocks/Bricks_Plastic_Assorted",
    texture: "Blocks/Bricks_Plastic_Assorted"
  },
  {
    id: "Bricks_Fabric_Assorted",
    name: "Assorted Fabric Bricks",
    color: "#742729",
    icon: true,
    resourceType: "Fabrics",
    builders: [
      makeBuilding(`Ingredient_Bar_Fabric`, `Bricks_Fabric_Assorted`),
      makeBuilding(`$Fabrics`, `Bricks_Fabric_Assorted`)
    ]
  },
  ...palette({ id: "Plastic", icon: true, exclude: ["block", "assortedBlock", "assortedBricks"] }),
  ...palette({ id: "Fabric", icon: true, include: ["colorBricks"] })
];

export const registerBuildingBlocks = () => {
  resourceType.many(resourceTypes.map(item => ({ ...item, id: `${item.id}s` }))).build();
  blockSet.many(resourceTypes).build();
  buildingBlock.many(buildingBlocks).defaults({ icon: true }).build();

  builders
    .many(
      flatten(buildingBlocks.filter(cfg => cfg.building && !cfg.builders)).flatMap(item => {
        if (typeof item === "string") return [];
        if (!item.building) return [];
        return [
          {
            id: item.id,
            ...item.building
          }
        ];
      })
    )
    .build();

  builders
    .many(
      flatten(buildingBlocks.filter(cfg => cfg.builders && !cfg.building)).flatMap(item => {
        if (typeof item === "string") return [];
        if (!item.builders) return [];
        return item.builders.map(build => ({
          id: item.id,
          ...build
        }));
      })
    )
    .build();
};
