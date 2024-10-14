package com.inconvenientdev.waste.datagen;

import com.inconvenientdev.waste.block.ModBlocks;
import com.inconvenientdev.waste.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLangProvider extends LanguageProvider {

  public ModLangProvider(DataGenerator gen) {
    super(gen, "waste", "en_us"); // Replace with your actual mod ID
  }

  @Override
  protected void addTranslations() {
    // Creative Tab translation (manual)
    addCreativeTab("wastetab", "Waste");

    // Dynamically generate item translations

    ModItems.ITEM_LANG_TITLES.forEach((item, title) -> add("item.waste." + item.getId().getPath(), title));

    // Dynamically generate block translations
    ModBlocks.BLOCK_LANG_TITLES.forEach((block, title) -> add("block.waste." + block.getId().getPath(), title));
  }

  // Method to add custom Creative Tab translation
  protected void addCreativeTab(String key, String tooltip) {
    add("itemGroup." + key, tooltip);
  }
}
