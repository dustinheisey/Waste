import {
  blockSet,
  type BlockSetCfg,
  buildingBlock,
  type BuildingBlockCfg,
  type Flatten,
  palette,
  resourceType,
  type ResourceTypeCfg
} from "hytale-generators";
import type { Cfg, HasRecipes } from "../index.types.ts";
import { recipes } from "../index.types.ts";

export const registerBlocks = () => {
  const resourceTypes: Flatten<BlockSetCfg & ResourceTypeCfg> = [
    { id: "Plastic", includeBlockTypes: [`Block_Plastic*`, `Bricks_Plastic*`] },
    { id: "Fabric", includeBlockTypes: [`Block_Fabric*`, `Bricks_Fabric*`] },
    { id: "Refractory", includeBlockTypes: [`Block_Refractory*`, `Bricks_Refractory*`] },
    { id: "High_Refractory", includeBlockTypes: [`Block_High_Refractory*`, `Bricks_High_Refractory*`] }
  ];

  const blocks: Cfg<BuildingBlockCfg & HasRecipes<"builders" | "alchemy" | "furnace">> = {
    patch: [
      {
        id: "Block_Plastic",
        name: "Plastic Block",
        color: "#37689F",
        resourceType: "Plastics",
        builders: { input: "$Plastics", output: `Block_Plastic` }
      },
      {
        id: "Bricks_Plastic_Assorted",
        name: "Assorted Plastic Bricks",
        color: "#444444",
        resourceType: "Plastics",
        model: "Blocks/Bricks_Plastic_Assorted",
        texture: "Blocks/Bricks_Plastic_Assorted",
        builders: { input: "$Plastics", output: `Bricks_Plastic_Assorted` }
      },
      ...palette({ id: "Plastic", icon: true, exclude: ["block", "assortedBlock", "assortedBricks"] })
    ],
    city: [
      {
        id: "Bricks_Fabric_Assorted",
        name: "Assorted Fabric Bricks",
        color: "#742729",
        resourceType: "Fabrics",
        builders: { input: "$Fabrics", output: `Bricks_Fabric_Assorted` }
      },
      ...palette({ id: "Fabric", icon: true, include: ["colorBricks"] })
    ],
    factory: [
      {
        id: "Soil_Clay_Refractory",
        name: "Refractory Clay",
        color: "#742729",
        resourceType: "Soils",
        alchemy: {
          input: [
            "Soil_Clay",
            "3x Ingredient_Dust_Silicon",
            "Ingredient_Dust_Rusty_Iron",
            "Ingredient_Dust_Aluminum",
            "Ingredient_Water_Essence"
          ],
          output: "Soil_Clay_Refractory"
        },
        furnace: { output: "Ingredient_Bar_Refractory_Brick" }
      },
      {
        id: "Soil_Clay_High_Refractory",
        name: "High Refractory Clay",
        color: "#742729",
        resourceType: "Soils",
        alchemy: {
          input: [
            "Soil_Clay_Refractory",
            "2x Ingredient_Dust_Silicon",
            "2x Ingredient_Dust_Rusty_Iron",
            "4x Ingredient_Dust_Aluminum",
            "Ingredient_Water_Essence"
          ],
          output: "Soil_Clay_High_Refractory"
        },
        furnace: { output: "Ingredient_Bar_High_Refractory_Brick" }
      },
      {
        id: "Stone_Refractory",
        name: "Refractory Stone",
        color: "#742729",
        resourceType: "Refractorys",
        builders: { input: "$Refractorys", output: `Stone_Refractory` }
      },
      {
        id: "Bricks_Refractory",
        name: "Refractory Bricks",
        color: "#742729",
        resourceType: "Refractorys",
        builders: { input: "$Refractorys", output: `Bricks_Refractory` }
      },
      {
        id: "Stone_High_Refractory",
        name: "High Refractory Stone",
        color: "#742729",
        resourceType: "High_Refractorys",
        builders: { input: "$High_Refractorys", output: `Stone_High_Refractory` }
      },
      {
        id: "Bricks_High_Refractory",
        name: "High Refractory Bricks",
        color: "#742729",
        resourceType: "High_Refractorys",
        builders: { input: "$High_Refractorys", output: `Bricks_High_Refractory` }
      },
      {
        id: "Stone_Porcelain",
        name: "Porcelain",
        color: "#742729",
        resourceType: "Porcelains",
        builders: { input: "$Porcelains", output: `Stone_Porcelain` }
      },
      {
        id: "Bricks_Porcelain",
        name: "Porcelain Bricks",
        color: "#742729",
        resourceType: "Porcelains",
        builders: { input: "$Porcelains", output: `Bricks_Porcelain` }
      },
      ...palette({ id: "Refractory", icon: true, include: ["colorBlocks", "colorBricks"] })
    ]
  };

  resourceType.many(resourceTypes.map(item => ({ ...item, id: `${item.id}s` }))).build();
  blockSet.many(resourceTypes).build();
  buildingBlock.many(blocks).defaults({ icon: true }).build();
  recipes("", blocks);
};
