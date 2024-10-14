package com.inconvenientdev.waste.datagen;

import com.inconvenientdev.waste.Waste;
import com.inconvenientdev.waste.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

  public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
    super(generator, Waste.MOD_ID, existingFileHelper);
  }

  @Override
  protected void registerModels() {
    // Automatically generate item block models for all blocks stored in BLOCKS_WITH_ITEM_MODELS
    ModItems.ITEMS_WITH_MODELS.forEach(this::simpleItem);
  }

  // Method to generate a simple item model
  private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
    return withExistingParent(item.getId().getPath(), new ResourceLocation("item/generated")).texture(
      "layer0",
      new ResourceLocation(Waste.MOD_ID, "item/" + item.getId().getPath())
    );
  }
}
