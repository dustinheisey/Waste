package com.inconvenientdev.waste.world;

import com.inconvenientdev.waste.block.ModBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

public class WasteSurfaceRuleData
{
  private static final SurfaceRules.RuleSource WASTE = makeStateRule(ModBlocks.WASTE.get());
  public static final SurfaceRules.RuleSource WASTE_LAYER = SurfaceRules.ifTrue(SurfaceRules.verticalGradient("waste_layer", VerticalAnchor.aboveBottom(224), VerticalAnchor.top()), WASTE);
  private static final SurfaceRules.RuleSource DENSE_WASTE = makeStateRule(ModBlocks.DENSE_WASTE.get());
  public static final SurfaceRules.RuleSource DENSE_WASTE_LAYER = SurfaceRules.ifTrue(SurfaceRules.verticalGradient("dense_waste_layer", VerticalAnchor.aboveBottom(160), VerticalAnchor.aboveBottom(208)), DENSE_WASTE);
  private static final SurfaceRules.RuleSource COMPACTED_WASTE = makeStateRule(ModBlocks.COMPACTED_WASTE.get());
  public static final SurfaceRules.RuleSource COMPACTED_WASTE_LAYER = SurfaceRules.ifTrue(SurfaceRules.verticalGradient("compacted_waste_layer", VerticalAnchor.aboveBottom(112), VerticalAnchor.aboveBottom(160)), COMPACTED_WASTE);
  private static final SurfaceRules.RuleSource ULTRA_COMPACTED_WASTE = makeStateRule(ModBlocks.ULTRA_COMPACTED_WASTE.get());
  public static final SurfaceRules.RuleSource ULTRA_COMPACTED_WASTE_LAYER = SurfaceRules.ifTrue(SurfaceRules.verticalGradient("ultra_compacted_waste_layer", VerticalAnchor.aboveBottom(64), VerticalAnchor.aboveBottom(112)), ULTRA_COMPACTED_WASTE);
  private static final SurfaceRules.RuleSource SOLID_WASTE = makeStateRule(ModBlocks.SOLID_WASTE.get());
  public static final SurfaceRules.RuleSource SOLID_WASTE_LAYER = SurfaceRules.ifTrue(SurfaceRules.verticalGradient("solid_waste_layer", VerticalAnchor.aboveBottom(5), VerticalAnchor.aboveBottom(64)), SOLID_WASTE);
  private static final SurfaceRules.RuleSource BEDROCK = SurfaceRules.state(Blocks.BEDROCK.defaultBlockState());
  public static final SurfaceRules.RuleSource BEDROCK_FLOOR = SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK);

  public static SurfaceRules.RuleSource makeRules()
  {

    // SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
    // SurfaceRules.RuleSource wasteSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, WASTE), DENSE_WASTE);

    return SurfaceRules.sequence(
        BEDROCK_FLOOR,
        SOLID_WASTE_LAYER,
        ULTRA_COMPACTED_WASTE_LAYER,
        COMPACTED_WASTE_LAYER,
        DENSE_WASTE_LAYER,
        WASTE_LAYER
    );
  }

  private static SurfaceRules.RuleSource makeStateRule(Block block)
  {
    return SurfaceRules.state(block.defaultBlockState());
  }
}