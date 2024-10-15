package com.inconvenientdev.waste.fluid;

import com.inconvenientdev.waste.Waste;
import com.inconvenientdev.waste.block.ModBlocks;
import com.inconvenientdev.waste.item.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
  public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
  public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
  public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

  public static final DeferredRegister<Fluid> FLUIDS
      = DeferredRegister.create(ForgeRegistries.FLUIDS, Waste.MOD_ID);

  public static void register(IEventBus eventBus) {
    FLUIDS.register(eventBus);
  }  public static final RegistryObject<FlowingFluid> SLUDGE_FLUID
      = FLUIDS.register("sludge_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.SLUDGE_PROPERTIES));

  public static final RegistryObject<FlowingFluid> SLUDGE_FLOWING
      = FLUIDS.register("sludge_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.SLUDGE_PROPERTIES));


  public static final ForgeFlowingFluid.Properties SLUDGE_PROPERTIES = new ForgeFlowingFluid.Properties(
      SLUDGE_FLUID, SLUDGE_FLOWING, FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
      .density(3000).luminosity(5).viscosity(6000).sound(SoundEvents.HONEY_DRINK).overlay(WATER_OVERLAY_RL)
      .color(0xbffcba03)).slopeFindDistance(2).levelDecreasePerBlock(1)
      .block(ModFluids.SLUDGE_BLOCK).bucket(ModItems.SLUDGE_BUCKET);

  public static final RegistryObject<LiquidBlock> SLUDGE_BLOCK = ModBlocks.BLOCKS.register("sludge",
      () -> new LiquidBlock(ModFluids.SLUDGE_FLUID, BlockBehaviour.Properties.of(Material.LAVA)
          .noCollission().strength(100f).noDrops()));
}