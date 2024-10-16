package com.inconvenientdev.waste.fluid;

import static com.inconvenientdev.waste.Waste.REGISTRATE;

import com.tterrag.registrate.util.entry.FluidEntry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public class ModFluids {

  // Fluid textures
  public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
  public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
  public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");
  // Fluid Entries using Registrate's FluidBuilder
  public static final FluidEntry<ForgeFlowingFluid.Flowing> DIRTY_WATER = REGISTRATE
      .get().fluid("dirty_water_fluid", WATER_STILL_RL, WATER_FLOWING_RL)
      .attributes(builder -> builder
          .density(500)
          .luminosity(0)
          .viscosity(1000)
          .sound(SoundEvents.AMBIENT_UNDERWATER_ENTER)
          .overlay(WATER_OVERLAY_RL)
          .color(0x99B78E5C))
      .register();  // Register the fluid with all attached data
  public static final FluidEntry<ForgeFlowingFluid.Flowing> TOXIC_WASTE = REGISTRATE
      .get().fluid("toxic_waste_fluid", WATER_STILL_RL, WATER_FLOWING_RL)
      .attributes(builder -> builder
          .density(1000)
          .luminosity(15)
          .viscosity(2000)
          .sound(SoundEvents.AMBIENT_UNDERWATER_ENTER)
          .overlay(WATER_OVERLAY_RL)
          .color(0xb343B610))
      .register();
  public static final FluidEntry<ForgeFlowingFluid.Flowing> SLUDGE = REGISTRATE
      .get().fluid("sludge_fluid", WATER_STILL_RL, WATER_FLOWING_RL)
      .attributes(builder -> builder
          .density(3000)
          .luminosity(5)
          .viscosity(6000)
          .sound(SoundEvents.AMBIENT_UNDERWATER_ENTER)
          .overlay(WATER_OVERLAY_RL)
          .color(0xf208070B))
      .register();

  public static void register() {}
}
