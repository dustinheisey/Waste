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
  }

  public static final RegistryObject<FlowingFluid> DIRTY_WATER_FLUID
      = FLUIDS.register("dirty_water_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.DIRTY_WATER_PROPERTIES));

  public static final RegistryObject<FlowingFluid> DIRTY_WATER_FLOWING
      = FLUIDS.register("dirty_water_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.DIRTY_WATER_PROPERTIES));

  public static final RegistryObject<FlowingFluid> TOXIC_WASTE_FLUID
      = FLUIDS.register("toxic_waste_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.TOXIC_WASTE_PROPERTIES));

  public static final RegistryObject<FlowingFluid> TOXIC_WASTE_FLOWING
      = FLUIDS.register("toxic_waste_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.TOXIC_WASTE_PROPERTIES));

  public static final RegistryObject<FlowingFluid> SLUDGE_FLUID
      = FLUIDS.register("sludge_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.SLUDGE_PROPERTIES));

  public static final RegistryObject<FlowingFluid> SLUDGE_FLOWING
      = FLUIDS.register("sludge_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.SLUDGE_PROPERTIES));


  public static final ForgeFlowingFluid.Properties DIRTY_WATER_PROPERTIES = new ForgeFlowingFluid.Properties(
      () -> DIRTY_WATER_FLUID.get(), () -> DIRTY_WATER_FLOWING.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
      .density(500).luminosity(5).viscosity(1000).sound(SoundEvents.AMBIENT_UNDERWATER_ENTER).overlay(WATER_OVERLAY_RL)
      .color(0x338A4E1A)).slopeFindDistance(2).levelDecreasePerBlock(1)
      .block(ModFluids.DIRTY_WATER_BLOCK).bucket(ModItems.DIRTY_WATER_BUCKET);

  public static final ForgeFlowingFluid.Properties TOXIC_WASTE_PROPERTIES = new ForgeFlowingFluid.Properties(
      () -> TOXIC_WASTE_FLUID.get(), () -> TOXIC_WASTE_FLOWING.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
      .density(1000).luminosity(15).viscosity(2000).sound(SoundEvents.AMBIENT_UNDERWATER_ENTER).overlay(WATER_OVERLAY_RL)
      .color(0xb343B610)).slopeFindDistance(2).levelDecreasePerBlock(1)
      .block(ModFluids.TOXIC_WASTE_BLOCK).bucket(ModItems.TOXIC_WASTE_BUCKET);

  public static final ForgeFlowingFluid.Properties SLUDGE_PROPERTIES = new ForgeFlowingFluid.Properties(
      () -> SLUDGE_FLUID.get(), () -> SLUDGE_FLOWING.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
      .density(3000).luminosity(5).viscosity(6000).sound(SoundEvents.HONEY_DRINK).overlay(WATER_OVERLAY_RL)
      .color(0xf208070B)).slopeFindDistance(2).levelDecreasePerBlock(1)
      .block(ModFluids.SLUDGE_BLOCK).bucket(ModItems.SLUDGE_BUCKET);

  public static final RegistryObject<LiquidBlock> DIRTY_WATER_BLOCK = ModBlocks.BLOCKS.register("dirty_water",
      () -> new LiquidBlock(() -> ModFluids.DIRTY_WATER_FLUID.get(), BlockBehaviour.Properties.of(Material.WATER)
          .noCollission().strength(1f).noDrops()));

  public static final RegistryObject<LiquidBlock> TOXIC_WASTE_BLOCK = ModBlocks.BLOCKS.register("toxic_waste",
      () -> new LiquidBlock(() -> ModFluids.TOXIC_WASTE_FLUID.get(), BlockBehaviour.Properties.of(Material.WATER)
          .noCollission().strength(50f).noDrops()));

  public static final RegistryObject<LiquidBlock> SLUDGE_BLOCK = ModBlocks.BLOCKS.register("sludge",
      () -> new LiquidBlock(() -> ModFluids.SLUDGE_FLUID.get(), BlockBehaviour.Properties.of(Material.LAVA)
          .noCollission().strength(100f).noDrops()));
}