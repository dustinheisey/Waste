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



      // Simple example:
      // Replace the Vanilla desert with our hot_red biome
      builder.replaceBiome(Biomes.PLAINS , WasteBiomes.DUMP);
      builder.replaceBiome(Biomes.SUNFLOWER_PLAINS , WasteBiomes.DUMP);
      builder.replaceBiome(Biomes.SNOWY_PLAINS , WasteBiomes.DUMP);
      builder.replaceBiome(Biomes.ICE_SPIKES , WasteBiomes.DUMP);
      builder.replaceBiome(Biomes.DESERT , WasteBiomes.DUMP);
      builder.replaceBiome(Biomes.SWAMP , WasteBiomes.DUMP);
      builder.replaceBiome(Biomes.FOREST , WasteBiomes.DUMP);
      builder.replaceBiome(Biomes.FLOWER_FOREST , WasteBiomes.DUMP);
      builder.replaceBiome(Biomes.BIRCH_FOREST , WasteBiomes.DUMP);
      builder.replaceBiome(Biomes.DARK_FOREST , WasteBiomes.DUMP);
      builder.replaceBiome(Biomes.OLD_GROWTH_BIRCH_FOREST , WasteBiomes.DUMP);
      builder.replaceBiome(Biomes.OLD_GROWTH_PINE_TAIGA , WasteBiomes.DUMP);
      builder.replaceBiome(Biomes.OLD_GROWTH_SPRUCE_TAIGA , WasteBiomes.DUMP);
      builder.replaceBiome(Biomes.TAIGA , WasteBiomes.DUMP);
      builder.replaceBiome(Biomes.SNOWY_TAIGA , WasteBiomes.DUMP);
      builder.replaceBiome(Biomes.SAVANNA , WasteBiomes.DUMP);
      builder.replaceBiome(Biomes.SAVANNA_PLATEAU , WasteBiomes.DUMP);
      builder.replaceBiome(Biomes.WINDSWEPT_FOREST , WasteBiomes.DUMP);
      builder.replaceBiome(Biomes.WINDSWEPT_SAVANNA , WasteBiomes.DUMP);
      builder.replaceBiome(Biomes.JUNGLE , WasteBiomes.DUMP);
      builder.replaceBiome(Biomes.SPARSE_JUNGLE , WasteBiomes.DUMP);
      builder.replaceBiome(Biomes.BAMBOO_JUNGLE , WasteBiomes.DUMP);
      builder.replaceBiome(Biomes.MEADOW , WasteBiomes.DUMP);
      builder.replaceBiome(Biomes.GROVE , WasteBiomes.DUMP);
      builder.replaceBiome(Biomes.MUSHROOM_FIELDS , WasteBiomes.DUMP);

      builder.replaceBiome(Biomes.SNOWY_SLOPES , WasteBiomes.TRASH_MOUNTAIN);
      builder.replaceBiome(Biomes.FROZEN_PEAKS , WasteBiomes.TRASH_MOUNTAIN);
      builder.replaceBiome(Biomes.JAGGED_PEAKS , WasteBiomes.TRASH_MOUNTAIN);
      builder.replaceBiome(Biomes.STONY_PEAKS , WasteBiomes.TRASH_MOUNTAIN);
      builder.replaceBiome(Biomes.WINDSWEPT_HILLS , WasteBiomes.TRASH_MOUNTAIN);
      builder.replaceBiome(Biomes.WINDSWEPT_GRAVELLY_HILLS , WasteBiomes.TRASH_MOUNTAIN);
      builder.replaceBiome(Biomes.BADLANDS , WasteBiomes.TRASH_MOUNTAIN);
      builder.replaceBiome(Biomes.ERODED_BADLANDS , WasteBiomes.TRASH_MOUNTAIN);
      builder.replaceBiome(Biomes.WOODED_BADLANDS , WasteBiomes.TRASH_MOUNTAIN);

      builder.replaceBiome(Biomes.RIVER , WasteBiomes.GARBAGE_PATCH);
      builder.replaceBiome(Biomes.FROZEN_RIVER , WasteBiomes.GARBAGE_PATCH);
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

      builder.replaceBiome(Biomes.DRIPSTONE_CAVES , WasteBiomes.GARBAGE_CAVE);
      builder.replaceBiome(Biomes.LUSH_CAVES , WasteBiomes.GARBAGE_CAVE);


      // More complex example:
      // Replace specific parameter points for the frozen peaks with our cold_blue biome
      /*
      List<Climate.ParameterPoint> frozenPeaksPoints = new ParameterPointListBuilder()
          .temperature(Temperature.ICY, Temperature.COOL, Temperature.NEUTRAL)
          .humidity(Humidity.ARID, Humidity.DRY, Humidity.NEUTRAL, Humidity.WET, Humidity.HUMID)
          .continentalness(Continentalness.span(Continentalness.COAST, Continentalness.FAR_INLAND), Continentalness.span(Continentalness.MID_INLAND, Continentalness.FAR_INLAND))
          .erosion(Erosion.EROSION_0, Erosion.EROSION_1)
          .depth(Depth.SURFACE, Depth.FLOOR)
          .weirdness(Weirdness.HIGH_SLICE_VARIANT_ASCENDING, Weirdness.PEAK_VARIANT, Weirdness.HIGH_SLICE_VARIANT_DESCENDING)
          .build();

      frozenPeaksPoints.forEach(point -> builder.replaceBiome(point, TestBiomes.COLD_BLUE));
       */
    });
  }
}