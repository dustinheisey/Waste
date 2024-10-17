package com.inconvenientdev.waste;

import com.inconvenientdev.waste.block.ModBlocks;
import com.inconvenientdev.waste.fluid.ModFluids;
import com.inconvenientdev.waste.item.ModItems;
import com.inconvenientdev.waste.world.WasteRegion;
import com.inconvenientdev.waste.world.WasteSurfaceRuleData;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

@Mod(Waste.MOD_ID)
public class Waste {

  public static final String MOD_ID = "waste";

  // Register a creative tab
  public static final CreativeModeTab WASTE_TAB = new CreativeModeTab(MOD_ID) {
    @Override
    public ItemStack makeIcon() {
      // Ensure GARBAGE is registered before this is called
      return new ItemStack(ModItems.GARBAGE.get());
    }
  };

  // Initialize Registrate instance and assign the creative tab
  public static final NonNullSupplier<Registrate> REGISTRATE = NonNullSupplier.lazy(() ->
      Registrate.create(MOD_ID).creativeModeTab(() -> WASTE_TAB) // Removed unnecessary casting
  );

  public Waste() {
    IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

    // Register mod events
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
    eventBus.addListener(this::clientSetup);

    // Register mod content (items, blocks, fluids)
    ModItems.register();
    ModBlocks.register();
    ModFluids.register();

    // Register for server and other game events
    MinecraftForge.EVENT_BUS.register(this);
  }

  private void clientSetup(final FMLClientSetupEvent event) {
    // Client-side setup code (e.g., render layers)
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.AMETHYST_RING_BLOCK.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.BATTERY_BLOCK.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.BULLET_BLOCK.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.FILM_BLOCK.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.CAR_PART_BLOCK.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.CIRCUIT_BOARD_BLOCK.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.COPPER_TUBING_BLOCK.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.ELECTRICAL_WIRE_BLOCK.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.FORK_BLOCK.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.KEY_CHAIN_BLOCK.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIGHT_BULB_BLOCK.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.SYRINGE_BLOCK.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.NAIL_BLOCK.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.NECKLACE_BLOCK.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.PAINT_CAN_BLOCK.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.PIPE_BLOCK.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.PLUMBING_JOINT_BLOCK.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.RADIO_BLOCK.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.SCRAP_METAL_BLOCK.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.TIN_CAN_BLOCK.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.TIN_FOIL_BLOCK.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.WRENCH_BLOCK.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.WATCH_BLOCK.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.TOY_BLOCK.get(), RenderType.translucent());

  }

  private void commonSetup(final FMLCommonSetupEvent event) {
    event.enqueueWork(() -> {
      Regions.register(new WasteRegion(new ResourceLocation(MOD_ID, "overworld"), 999999999));
      SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, WasteSurfaceRuleData.makeRules());
    });
  }
}
