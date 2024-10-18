package com.inconvenientdev.waste.world;

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
      builder.replaceBiome(Biomes.PLAINS , WasteBiomes.GARBAGE_DUMP);
      builder.replaceBiome(Biomes.SUNFLOWER_PLAINS , WasteBiomes.GARBAGE_DUMP);
      builder.replaceBiome(Biomes.SNOWY_PLAINS , WasteBiomes.GARBAGE_DUMP);
      builder.replaceBiome(Biomes.ICE_SPIKES , WasteBiomes.GARBAGE_DUMP);
      builder.replaceBiome(Biomes.SWAMP , WasteBiomes.GARBAGE_DUMP);
      builder.replaceBiome(Biomes.FOREST , WasteBiomes.GARBAGE_DUMP);
      builder.replaceBiome(Biomes.FLOWER_FOREST , WasteBiomes.GARBAGE_DUMP);
      builder.replaceBiome(Biomes.BIRCH_FOREST , WasteBiomes.GARBAGE_DUMP);
      builder.replaceBiome(Biomes.DARK_FOREST , WasteBiomes.GARBAGE_DUMP);
      builder.replaceBiome(Biomes.OLD_GROWTH_BIRCH_FOREST , WasteBiomes.GARBAGE_DUMP);
      builder.replaceBiome(Biomes.OLD_GROWTH_PINE_TAIGA , WasteBiomes.GARBAGE_DUMP);
      builder.replaceBiome(Biomes.OLD_GROWTH_SPRUCE_TAIGA , WasteBiomes.GARBAGE_DUMP);
      builder.replaceBiome(Biomes.TAIGA , WasteBiomes.GARBAGE_DUMP);
      builder.replaceBiome(Biomes.SNOWY_TAIGA , WasteBiomes.GARBAGE_DUMP);
      builder.replaceBiome(Biomes.SAVANNA_PLATEAU , WasteBiomes.GARBAGE_DUMP);
      builder.replaceBiome(Biomes.WINDSWEPT_FOREST , WasteBiomes.GARBAGE_DUMP);
      builder.replaceBiome(Biomes.WINDSWEPT_SAVANNA , WasteBiomes.GARBAGE_DUMP);
      builder.replaceBiome(Biomes.JUNGLE , WasteBiomes.GARBAGE_DUMP);
      builder.replaceBiome(Biomes.SPARSE_JUNGLE , WasteBiomes.GARBAGE_DUMP);
      builder.replaceBiome(Biomes.BAMBOO_JUNGLE , WasteBiomes.GARBAGE_DUMP);
      builder.replaceBiome(Biomes.MEADOW , WasteBiomes.GARBAGE_DUMP);
      builder.replaceBiome(Biomes.GROVE , WasteBiomes.GARBAGE_DUMP);
      builder.replaceBiome(Biomes.MUSHROOM_FIELDS , WasteBiomes.GARBAGE_DUMP);
      builder.replaceBiome(Biomes.DRIPSTONE_CAVES , WasteBiomes.GARBAGE_DUMP);
      builder.replaceBiome(Biomes.LUSH_CAVES , WasteBiomes.GARBAGE_DUMP);

      builder.replaceBiome(Biomes.SNOWY_SLOPES , WasteBiomes.TRASH_MOUNTAIN);
      builder.replaceBiome(Biomes.FROZEN_PEAKS , WasteBiomes.TRASH_MOUNTAIN);
      builder.replaceBiome(Biomes.JAGGED_PEAKS , WasteBiomes.TRASH_MOUNTAIN);
      builder.replaceBiome(Biomes.STONY_PEAKS , WasteBiomes.TRASH_MOUNTAIN);
      builder.replaceBiome(Biomes.WINDSWEPT_HILLS , WasteBiomes.TRASH_MOUNTAIN);
      builder.replaceBiome(Biomes.WINDSWEPT_GRAVELLY_HILLS , WasteBiomes.TRASH_MOUNTAIN);

      builder.replaceBiome(Biomes.BADLANDS , WasteBiomes.INDUSTRIAL_WASTE);
      builder.replaceBiome(Biomes.ERODED_BADLANDS , WasteBiomes.INDUSTRIAL_WASTE);
      builder.replaceBiome(Biomes.WOODED_BADLANDS , WasteBiomes.INDUSTRIAL_WASTE);

      builder.replaceBiome(Biomes.DESERT , WasteBiomes.ABANDONED_CITY);
      builder.replaceBiome(Biomes.SAVANNA , WasteBiomes.ABANDONED_CITY);

      builder.replaceBiome(Biomes.BEACH , WasteBiomes.GARBAGE_PATCH);
      builder.replaceBiome(Biomes.SNOWY_BEACH , WasteBiomes.GARBAGE_PATCH);
      builder.replaceBiome(Biomes.STONY_SHORE , WasteBiomes.GARBAGE_PATCH);
      builder.replaceBiome(Biomes.WARM_OCEAN , WasteBiomes.GARBAGE_PATCH);
      builder.replaceBiome(Biomes.LUKEWARM_OCEAN , WasteBiomes.GARBAGE_PATCH);
      builder.replaceBiome(Biomes.DEEP_LUKEWARM_OCEAN , WasteBiomes.GARBAGE_PATCH);
      builder.replaceBiome(Biomes.OCEAN , WasteBiomes.GARBAGE_PATCH);
      builder.replaceBiome(Biomes.DEEP_OCEAN , WasteBiomes.GARBAGE_PATCH);
      builder.replaceBiome(Biomes.COLD_OCEAN , WasteBiomes.GARBAGE_PATCH);
      builder.replaceBiome(Biomes.DEEP_COLD_OCEAN , WasteBiomes.GARBAGE_PATCH);
      builder.replaceBiome(Biomes.FROZEN_OCEAN , WasteBiomes.GARBAGE_PATCH);
      builder.replaceBiome(Biomes.DEEP_FROZEN_OCEAN , WasteBiomes.GARBAGE_PATCH);
    });
  }
}