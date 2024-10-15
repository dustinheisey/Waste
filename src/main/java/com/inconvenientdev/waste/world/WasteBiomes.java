package com.inconvenientdev.waste.world;

import com.inconvenientdev.waste.Waste;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class WasteBiomes
{
  public static final ResourceKey<Biome> GARBAGE_DUMP = register("garbage_dump");
  public static final ResourceKey<Biome> GARBAGE_PATCH = register("garbage_patch");
  public static final ResourceKey<Biome> TRASH_MOUNTAIN = register("trash_mountain");
  public static final ResourceKey<Biome> INDUSTRIAL_WASTE = register("industrial_waste");
  public static final ResourceKey<Biome> ABANDONED_CITY = register("abandoned_city");

  private static ResourceKey<Biome> register(String name)
  {
    return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(Waste.MOD_ID, name));
  }
}