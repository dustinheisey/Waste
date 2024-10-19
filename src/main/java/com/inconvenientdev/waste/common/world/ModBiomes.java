package com.inconvenientdev.waste.common.world;

import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBiomes
{
  @SubscribeEvent
  public static void registerBiomes(RegistryEvent.Register<Biome> event)
  {
    IForgeRegistry<Biome> registry = event.getRegistry();
    registry.register(WasteWorldBiomes.garbageDump().setRegistryName(WasteBiomes.GARBAGE_DUMP.location()));
    registry.register(WasteWorldBiomes.garbagePatch().setRegistryName(WasteBiomes.GARBAGE_PATCH.location()));
    registry.register(WasteWorldBiomes.trashMountain().setRegistryName(WasteBiomes.TRASH_MOUNTAIN.location()));
    registry.register(WasteWorldBiomes.industrialWaste().setRegistryName(WasteBiomes.INDUSTRIAL_WASTE.location()));
    registry.register(WasteWorldBiomes.abandonedCity().setRegistryName(WasteBiomes.ABANDONED_CITY.location()));

  }
}