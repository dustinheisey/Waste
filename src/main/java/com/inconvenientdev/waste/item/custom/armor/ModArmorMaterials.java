package com.inconvenientdev.waste.item.custom.armor;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public enum ModArmorMaterials implements ArmorMaterial {
  SCRAP("scrap", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.1F, Ingredient.of(Items.IRON_INGOT));

  private static final int[] DURABILITY_PER_SLOT = new int[]{13, 15, 16, 11};
  private final String name;
  private final int durabilityMultiplier;
  private final int[] slotProtections;
  private final int enchantmentValue;
  private final SoundEvent sound;
  private final float toughness;
  private final float knockbackResistance;
  private final Ingredient repairIngredient;

  ModArmorMaterials(String name, int durabilityMultiplier, int[] slotProtections, int enchantmentValue, SoundEvent sound, float toughness, float knockbackResistance, Ingredient repairIngredient) {
    this.name = name;
    this.durabilityMultiplier = durabilityMultiplier;
    this.slotProtections = slotProtections;
    this.enchantmentValue = enchantmentValue;
    this.sound = sound;
    this.toughness = toughness;
    this.knockbackResistance = knockbackResistance;
    this.repairIngredient = repairIngredient;
  }

  @Override
  public int getDurabilityForSlot(EquipmentSlot slot) {
    return DURABILITY_PER_SLOT[slot.getIndex()] * this.durabilityMultiplier;
  }

  @Override
  public int getDefenseForSlot(EquipmentSlot slot) {
    return this.slotProtections[slot.getIndex()];
  }

  @Override
  public int getEnchantmentValue() {
    return this.enchantmentValue;
  }

  @Override
  public SoundEvent getEquipSound() {
    return this.sound;
  }

  @Override
  public Ingredient getRepairIngredient() {
    return this.repairIngredient;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public float getToughness() {
    return this.toughness;
  }

  @Override
  public float getKnockbackResistance() {
    return this.knockbackResistance;
  }
}
