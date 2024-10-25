package com.inconvenientdev.waste.common.world;

import java.util.function.Consumer;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;

public class WasteRegion extends Region
{
  public WasteRegion(ResourceLocation name, int weight)
  {
    super(name, RegionType.OVERWORLD, weight);
  }

  @Override
  public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper)
  {
    this.addModifiedVanillaOverworldBiomes(mapper, builder -> {
      builder.replaceBiome(Biomes.PLAINS, WasteBiomes.ABANDONED_CITY);
      builder.replaceBiome(Biomes.SUNFLOWER_PLAINS, WasteBiomes.ABANDONED_CITY);
      builder.replaceBiome(Biomes.SNOWY_PLAINS, WasteBiomes.ABANDONED_CITY);
      builder.replaceBiome(Biomes.ICE_SPIKES, WasteBiomes.ABANDONED_CITY);
      builder.replaceBiome(Biomes.SWAMP, WasteBiomes.ABANDONED_CITY);
      builder.replaceBiome(Biomes.FOREST, WasteBiomes.ABANDONED_CITY);
      builder.replaceBiome(Biomes.FLOWER_FOREST, WasteBiomes.ABANDONED_CITY);
      builder.replaceBiome(Biomes.BIRCH_FOREST, WasteBiomes.ABANDONED_CITY);
      builder.replaceBiome(Biomes.DARK_FOREST, WasteBiomes.ABANDONED_CITY);
      builder.replaceBiome(Biomes.OLD_GROWTH_BIRCH_FOREST, WasteBiomes.ABANDONED_CITY);
      builder.replaceBiome(Biomes.OLD_GROWTH_PINE_TAIGA, WasteBiomes.ABANDONED_CITY);
      builder.replaceBiome(Biomes.OLD_GROWTH_SPRUCE_TAIGA, WasteBiomes.ABANDONED_CITY);
      builder.replaceBiome(Biomes.TAIGA, WasteBiomes.ABANDONED_CITY);
      builder.replaceBiome(Biomes.SNOWY_TAIGA, WasteBiomes.ABANDONED_CITY);
      builder.replaceBiome(Biomes.SAVANNA_PLATEAU, WasteBiomes.ABANDONED_CITY);
      builder.replaceBiome(Biomes.WINDSWEPT_FOREST, WasteBiomes.ABANDONED_CITY);
      builder.replaceBiome(Biomes.WINDSWEPT_SAVANNA, WasteBiomes.ABANDONED_CITY);
      builder.replaceBiome(Biomes.JUNGLE, WasteBiomes.ABANDONED_CITY);
      builder.replaceBiome(Biomes.SPARSE_JUNGLE, WasteBiomes.ABANDONED_CITY);
      builder.replaceBiome(Biomes.BAMBOO_JUNGLE, WasteBiomes.ABANDONED_CITY);
      builder.replaceBiome(Biomes.MEADOW, WasteBiomes.ABANDONED_CITY);
      builder.replaceBiome(Biomes.GROVE, WasteBiomes.ABANDONED_CITY);
      builder.replaceBiome(Biomes.MUSHROOM_FIELDS, WasteBiomes.ABANDONED_CITY);
      builder.replaceBiome(Biomes.DRIPSTONE_CAVES, WasteBiomes.ABANDONED_CITY);
      builder.replaceBiome(Biomes.LUSH_CAVES, WasteBiomes.ABANDONED_CITY);

      // builder.replaceBiome(Biomes.SNOWY_SLOPES, WasteBiomes.ABANDONED_CITY);
      // builder.replaceBiome(Biomes.FROZEN_PEAKS, WasteBiomes.ABANDONED_CITY);
      // builder.replaceBiome(Biomes.JAGGED_PEAKS, WasteBiomes.ABANDONED_CITY);
      // builder.replaceBiome(Biomes.STONY_PEAKS, WasteBiomes.ABANDONED_CITY);
      // builder.replaceBiome(Biomes.WINDSWEPT_HILLS, WasteBiomes.ABANDONED_CITY);
      // builder.replaceBiome(Biomes.WINDSWEPT_GRAVELLY_HILLS, WasteBiomes.ABANDONED_CITY);

      builder.replaceBiome(Biomes.BADLANDS, WasteBiomes.ABANDONED_CITY);
      builder.replaceBiome(Biomes.ERODED_BADLANDS, WasteBiomes.ABANDONED_CITY);
      builder.replaceBiome(Biomes.WOODED_BADLANDS, WasteBiomes.ABANDONED_CITY);

      // builder.replaceBiome(Biomes.DESERT, WasteBiomes.ABANDONED_CITY);
      // builder.replaceBiome(Biomes.SAVANNA, WasteBiomes.ABANDONED_CITY);

      // builder.replaceBiome(Biomes.BEACH, WasteBiomes.ABANDONED_CITY);
      // builder.replaceBiome(Biomes.SNOWY_BEACH, WasteBiomes.ABANDONED_CITY);
      // builder.replaceBiome(Biomes.STONY_SHORE, WasteBiomes.ABANDONED_CITY);
      // builder.replaceBiome(Biomes.WARM_OCEAN, WasteBiomes.ABANDONED_CITY);
      // builder.replaceBiome(Biomes.LUKEWARM_OCEAN, WasteBiomes.ABANDONED_CITY);
      // builder.replaceBiome(Biomes.DEEP_LUKEWARM_OCEAN, WasteBiomes.ABANDONED_CITY);
      // builder.replaceBiome(Biomes.OCEAN, WasteBiomes.ABANDONED_CITY);
      // builder.replaceBiome(Biomes.DEEP_OCEAN, WasteBiomes.ABANDONED_CITY);
      // builder.replaceBiome(Biomes.COLD_OCEAN, WasteBiomes.ABANDONED_CITY);
      // builder.replaceBiome(Biomes.DEEP_COLD_OCEAN, WasteBiomes.ABANDONED_CITY);
      // builder.replaceBiome(Biomes.FROZEN_OCEAN, WasteBiomes.ABANDONED_CITY);
      // builder.replaceBiome(Biomes.DEEP_FROZEN_OCEAN, WasteBiomes.ABANDONED_CITY);
    });
  }
}