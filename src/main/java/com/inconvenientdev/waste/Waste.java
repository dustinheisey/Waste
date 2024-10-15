package com.inconvenientdev.waste;

import com.inconvenientdev.waste.block.ModBlocks;
import com.inconvenientdev.waste.fluid.ModFluids;
import com.inconvenientdev.waste.item.ModItems;
import com.inconvenientdev.waste.world.WasteRegion;
import com.inconvenientdev.waste.world.WasteSurfaceRuleData;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Waste.MOD_ID)
public class Waste {

  public static final String MOD_ID = "waste";

  // Directly reference a slf4j logger
  private static final Logger LOGGER = LogUtils.getLogger();

  public Waste() {
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
    IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

    ModItems.register(eventBus);
    ModBlocks.register(eventBus);
    ModFluids.register(eventBus);

    eventBus.addListener(this::commonSetup);
    eventBus.addListener(this::clientSetup);

    // Register ourselves for server and other game events we are interested in
    MinecraftForge.EVENT_BUS.register(this);
  }

  private void clientSetup(final FMLClientSetupEvent event) {
    ItemBlockRenderTypes.setRenderLayer(ModFluids.SLUDGE_BLOCK.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(ModFluids.SLUDGE_FLUID.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(ModFluids.SLUDGE_FLOWING.get(), RenderType.translucent());
  }


  private void commonSetup(final FMLCommonSetupEvent event)
  {
    event.enqueueWork(() ->
    {
      Regions.register(new WasteRegion(new ResourceLocation(MOD_ID, "overworld"), 999999999));

      // Register our surface rules
      SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, WasteSurfaceRuleData.makeRules());
    });
  }
}
