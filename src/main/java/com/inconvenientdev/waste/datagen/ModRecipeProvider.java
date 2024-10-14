package com.inconvenientdev.waste.datagen;

import com.inconvenientdev.waste.block.ModBlocks;
import java.util.function.Consumer;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

  public ModRecipeProvider(DataGenerator pGenerator) {
    super(pGenerator);
  }

  @Override
  protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
    ShapedRecipeBuilder.shaped(ModBlocks.COMPACTED_WASTE.get())
      .define('E', ModBlocks.DENSE_WASTE.get())
      .pattern("EE")
      .pattern("EE")
      .pattern("EE")
      .unlockedBy(
        "has_dense_waste",
        inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.COMPACTED_WASTE.get()).build())
      )
      .save(pFinishedRecipeConsumer);

    ShapelessRecipeBuilder.shapeless(ModBlocks.DENSE_WASTE.get())
      .requires(ModBlocks.COMPACTED_WASTE.get())
      .unlockedBy(
        "has_compacted_waste",
        inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.COMPACTED_WASTE.get()).build())
      )
      .save(pFinishedRecipeConsumer);
  }
}
