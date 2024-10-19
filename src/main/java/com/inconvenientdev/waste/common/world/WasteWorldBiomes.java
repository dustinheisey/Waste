package com.inconvenientdev.waste.common.world;

import javax.annotation.Nullable;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.sounds.Music;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;

public class WasteWorldBiomes
{
  @Nullable
  private static final Music NORMAL_MUSIC = null;

  protected static int calculateSkyColor(float color)
  {
    float $$1 = color / 3.0F;
    $$1 = Mth.clamp($$1, -1.0F, 1.0F);
    return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
  }

  private static Biome biome(Biome.Precipitation precipitation, Biome.BiomeCategory category, float temperature, float downfall, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder, @Nullable Music music)
  {
    return biome(precipitation, category, temperature, downfall, 4159204, 329011, spawnBuilder, biomeBuilder, music);
  }

  private static Biome biome(Biome.Precipitation precipitation, Biome.BiomeCategory category, float temperature, float downfall, int waterColor, int waterFogColor, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder, @Nullable Music music)
  {
    return (new Biome.BiomeBuilder()).precipitation(precipitation).biomeCategory(category).temperature(temperature).downfall(downfall).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(waterColor).waterFogColor(waterFogColor).fogColor(12638463).skyColor(calculateSkyColor(temperature)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(music).build()).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
  }

  private static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder)
  {
    BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
    BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
    BiomeDefaultFeatures.addDefaultSprings(builder);
    BiomeDefaultFeatures.addSurfaceFreezing(builder);
  }

  public static Biome garbageDump()
  {
    MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
    spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 10, 1, 4)); // Toxic Slimes
    spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 10, 1, 4)); // Waste Crawlers

    BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
    globalOverworldGeneration(biomeBuilder);
    // Add unique garbage blocks
    //biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, WasteConfiguredFeatures.GARBAGE_HEAPS);

    //BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
    //BiomeDefaultFeatures.addSwampClayDisk(biomeBuilder);
    // Toxic pools and occasional garbage structures
    //biomeBuilder.addFeature(GenerationStep.Decoration.LAKES, WasteConfiguredFeatures.TOXIC_SLUDGE_LAKE);
    return biome(Biome.Precipitation.NONE, Biome.BiomeCategory.PLAINS, 1.5F, 0.0F, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
  }


  public static Biome garbagePatch()
  {
    MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

    BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
    globalOverworldGeneration(biomeBuilder);
    // Floating plastic debris
    //biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, WasteConfiguredFeatures.FLOATING_DEBRIS);
    //biomeBuilder.addFeature(GenerationStep.Decoration.LAKES, WasteConfiguredFeatures.OIL_SLICKS);
    return biome(Biome.Precipitation.RAIN, Biome.BiomeCategory.OCEAN, 0.2F, 0.9F, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
  }


  public static Biome trashMountain()
  {
    MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
    spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.IRON_GOLEM, 5, 1, 1)); // Junk Beasts
    spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 5, 1, 4)); // Scavenger Ghouls

    BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

    //BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
    //BiomeDefaultFeatures.addSwampClayDisk(biomeBuilder);

    globalOverworldGeneration(biomeBuilder);
    // Towers of compacted trash
    //biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, WasteConfiguredFeatures.TRASH_TOWERS);
    return biome(Biome.Precipitation.NONE, Biome.BiomeCategory.MOUNTAIN, 0.8F, 0.1F, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
  }


  public static Biome abandonedCity()
  {
    MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
    spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 10, 1, 2)); // Toxic Elementals
    spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 8, 1, 3)); // Mutant Rats

    BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

    //BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
    //BiomeDefaultFeatures.addSwampClayDisk(biomeBuilder);

    globalOverworldGeneration(biomeBuilder);
    // Toxic waste pools and ruins
    //biomeBuilder.addFeature(GenerationStep.Decoration.LAKES, WasteConfiguredFeatures.TOXIC_WASTE_POOL);
    //biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, WasteConfiguredFeatures.INDUSTRIAL_RUINS);
    return biome(Biome.Precipitation.RAIN, Biome.BiomeCategory.DESERT, 0.8F, 0.5F, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
  }


  public static Biome industrialWaste()
  {
    MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
    spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 10, 1, 2)); // Toxic Elementals
    spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 8, 1, 3)); // Mutant Rats

    BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

    //BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
    //BiomeDefaultFeatures.addSwampClayDisk(biomeBuilder);

    globalOverworldGeneration(biomeBuilder);
    // Toxic waste pools and ruins
    //biomeBuilder.addFeature(GenerationStep.Decoration.LAKES, WasteConfiguredFeatures.TOXIC_WASTE_POOL);
    //biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, WasteConfiguredFeatures.INDUSTRIAL_RUINS);
    return biome(Biome.Precipitation.RAIN, Biome.BiomeCategory.DESERT, 1.5F, 0.3F, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
  }

}

