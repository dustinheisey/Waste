package com.inconvenientdev.waste.world;

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
    BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
    BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
    BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
    BiomeDefaultFeatures.addDefaultSprings(builder);
    BiomeDefaultFeatures.addSurfaceFreezing(builder);
  }

  public static Biome dump()
  {
    MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
    BiomeDefaultFeatures.desertSpawns(spawnBuilder);

    BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
    BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
    globalOverworldGeneration(biomeBuilder);
    BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
    BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
    BiomeDefaultFeatures.addDefaultFlowers(biomeBuilder);
    BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
    BiomeDefaultFeatures.addDesertVegetation(biomeBuilder);
    BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
    BiomeDefaultFeatures.addDesertExtraVegetation(biomeBuilder);
    BiomeDefaultFeatures.addDesertExtraDecoration(biomeBuilder);
    return biome(Biome.Precipitation.NONE, Biome.BiomeCategory.DESERT, 2.0F, 0.0F, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
  }

  public static Biome garbagePatch()
  {
    MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
    spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.GOAT, 5, 1, 3));
    BiomeDefaultFeatures.commonSpawns(spawnBuilder);

    BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
    globalOverworldGeneration(biomeBuilder);
    BiomeDefaultFeatures.addFrozenSprings(biomeBuilder);
    BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
    BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
    BiomeDefaultFeatures.addExtraEmeralds(biomeBuilder);
    BiomeDefaultFeatures.addInfestedStone(biomeBuilder);
    return biome(Biome.Precipitation.SNOW, Biome.BiomeCategory.MOUNTAIN, -0.7F, 0.9F, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
  }

  public static Biome trashMountain()
  {
    MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
    spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.GOAT, 5, 1, 3));
    BiomeDefaultFeatures.commonSpawns(spawnBuilder);

    BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
    globalOverworldGeneration(biomeBuilder);
    BiomeDefaultFeatures.addFrozenSprings(biomeBuilder);
    BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
    BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
    BiomeDefaultFeatures.addExtraEmeralds(biomeBuilder);
    BiomeDefaultFeatures.addInfestedStone(biomeBuilder);
    return biome(Biome.Precipitation.SNOW, Biome.BiomeCategory.MOUNTAIN, -0.7F, 0.9F, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
  }

  public static Biome garbageCave()
  {
    MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
    spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.GOAT, 5, 1, 3));
    BiomeDefaultFeatures.commonSpawns(spawnBuilder);

    BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
    globalOverworldGeneration(biomeBuilder);
    BiomeDefaultFeatures.addFrozenSprings(biomeBuilder);
    BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
    BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
    BiomeDefaultFeatures.addExtraEmeralds(biomeBuilder);
    BiomeDefaultFeatures.addInfestedStone(biomeBuilder);
    return biome(Biome.Precipitation.SNOW, Biome.BiomeCategory.MOUNTAIN, -0.7F, 0.9F, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
  }
}

