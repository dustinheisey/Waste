package com.inconvenientdev.waste.world;

import com.inconvenientdev.waste.block.ModBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

public class WasteSurfaceRuleData
{
  public static final SurfaceRules.ConditionSource ABOVE_LOWEST = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(-176),0);
  public static final SurfaceRules.ConditionSource ABOVE_LOW = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(-173),0);
  public static final SurfaceRules.ConditionSource ABOVE_MEDIUM = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(-96),0);
  public static final SurfaceRules.ConditionSource ABOVE_HIGH = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(-32),0);
  public static final SurfaceRules.ConditionSource ABOVE_HIGHEST = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(16),0);

  private static final SurfaceRules.RuleSource BEDROCK = SurfaceRules.state(Blocks.BEDROCK.defaultBlockState());
  public static final SurfaceRules.RuleSource BEDROCK_FLOOR = SurfaceRules.ifTrue(ABOVE_LOWEST, SurfaceRules.ifTrue(SurfaceRules.not(ABOVE_LOW), BEDROCK));

  private static final SurfaceRules.RuleSource SOLID_WASTE = makeStateRule(ModBlocks.SOLID_WASTE.get());
  public static final SurfaceRules.RuleSource SOLID_WASTE_LAYER = SurfaceRules.ifTrue(ABOVE_LOW, SurfaceRules.ifTrue(SurfaceRules.not(ABOVE_MEDIUM), SOLID_WASTE));

  private static final SurfaceRules.RuleSource ULTRA_COMPACTED_WASTE = makeStateRule(ModBlocks.ULTRA_COMPACTED_WASTE.get());
  public static final SurfaceRules.RuleSource ULTRA_COMPACTED_WASTE_LAYER = SurfaceRules.ifTrue(ABOVE_MEDIUM, SurfaceRules.ifTrue(SurfaceRules.not(ABOVE_HIGH), ULTRA_COMPACTED_WASTE));

  private static final SurfaceRules.RuleSource COMPACTED_WASTE = makeStateRule(ModBlocks.COMPACTED_WASTE.get());
  public static final SurfaceRules.RuleSource COMPACTED_WASTE_LAYER = SurfaceRules.ifTrue(ABOVE_HIGH, SurfaceRules.ifTrue(SurfaceRules.not(ABOVE_HIGHEST), COMPACTED_WASTE));

  private static final SurfaceRules.RuleSource DENSE_WASTE = makeStateRule(ModBlocks.DENSE_WASTE.get());
  public static final SurfaceRules.RuleSource DENSE_WASTE_LAYER = SurfaceRules.ifTrue(ABOVE_HIGHEST, DENSE_WASTE);

  public static SurfaceRules.RuleSource makeRules()
  {
    return SurfaceRules.sequence(
        BEDROCK_FLOOR,
        SOLID_WASTE_LAYER,
        ULTRA_COMPACTED_WASTE_LAYER,
        COMPACTED_WASTE_LAYER,
        DENSE_WASTE_LAYER
    );
  }

  private static SurfaceRules.RuleSource makeStateRule(Block block)
  {
    return SurfaceRules.state(block.defaultBlockState());
  }
}