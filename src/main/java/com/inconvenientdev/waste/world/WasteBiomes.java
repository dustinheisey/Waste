package com.inconvenientdev.waste.world;

import com.inconvenientdev.waste.Waste;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class WasteBiomes
{
  public static final ResourceKey<Biome> DUMP = register("dump");
  public static final ResourceKey<Biome> GARBAGE_PATCH = register("garbage_patch");
  public static final ResourceKey<Biome> TRASH_MOUNTAIN = register("trash_mountain");
  public static final ResourceKey<Biome> GARBAGE_CAVE = register("garbage_cave");

  private static ResourceKey<Biome> register(String name)
  {
    return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(Waste.MOD_ID, name));
  }
}