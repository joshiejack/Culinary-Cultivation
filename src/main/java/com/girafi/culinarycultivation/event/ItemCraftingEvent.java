package com.girafi.culinarycultivation.event;

import com.girafi.culinarycultivation.init.ModItems;
import com.girafi.culinarycultivation.item.ItemModFishFood;
import com.girafi.culinarycultivation.item.ItemModMeatFood.MeatType;
import com.girafi.culinarycultivation.item.equipment.tool.ItemCakeKnife;
import com.girafi.culinarycultivation.item.equipment.tool.ItemKitchenKnife;
import com.girafi.culinarycultivation.item.equipment.tool.ItemMeatCleaver;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent;

public class ItemCraftingEvent {

    public static class CraftedEvent {
        @SubscribeEvent
        public void CraftingHandler(ItemCraftedEvent craftedEvent) {
            ItemStack stackKnife = craftedEvent.crafting;
            if (stackKnife != null && stackKnife.getItem() == ModItems.KITCHEN_KNIFE) {
            } else {
                for (int i = 0; i < craftedEvent.craftMatrix.getSizeInventory(); i++) {
                    ItemStack stack = craftedEvent.craftMatrix.getStackInSlot(i);
                    if (stack != null && stack.getItem() instanceof ItemKitchenKnife) {
                        ItemStack itemKnife = new ItemStack(ModItems.KITCHEN_KNIFE, 2, stack.getItemDamage() + 1);

                        if (itemKnife.getItemDamage() >= itemKnife.getMaxDamage()) {
                            itemKnife.stackSize--;
                        }
                        craftedEvent.craftMatrix.setInventorySlotContents(i, itemKnife);
                    }
                }
            }
            ItemStack stackCakeKnife = craftedEvent.crafting;
            if (stackCakeKnife != null && stackCakeKnife.getItem() == ModItems.CAKE_KNIFE) {
            } else {
                for (int i = 0; i < craftedEvent.craftMatrix.getSizeInventory(); i++) {
                    ItemStack stack = craftedEvent.craftMatrix.getStackInSlot(i);
                    if (stack != null && stack.getItem() instanceof ItemCakeKnife) {
                        ItemStack cakeKnife = new ItemStack(ModItems.CAKE_KNIFE, 2, stack.getItemDamage() + 1);

                        if (cakeKnife.getItemDamage() >= cakeKnife.getMaxDamage()) {
                            cakeKnife.stackSize--;
                        }
                        craftedEvent.craftMatrix.setInventorySlotContents(i, cakeKnife);
                    }
                }
            }
            ItemStack stackMeatCleaver = craftedEvent.crafting;
            if (stackMeatCleaver != null && stackCakeKnife.getItem() == ModItems.MEAT_CLEAVER) {
            } else {
                for (int i = 0; i < craftedEvent.craftMatrix.getSizeInventory(); i++) {
                    ItemStack stack = craftedEvent.craftMatrix.getStackInSlot(i);
                    if (stack != null && stack.getItem() instanceof ItemMeatCleaver) {
                        ItemStack meatCleaver = new ItemStack(ModItems.MEAT_CLEAVER, 2, stack.getItemDamage() + 1);

                        if (meatCleaver.getItemDamage() >= meatCleaver.getMaxDamage()) {
                            meatCleaver.stackSize--;
                        }
                        craftedEvent.craftMatrix.setInventorySlotContents(i, meatCleaver);
                    }
                }
            }
        }

        @SubscribeEvent
        public void DrumstickCraftedEvent(ItemCraftedEvent craftedEvent) {
            ItemStack stack = craftedEvent.crafting;
            if (stack != null && stack.getItem() == ModItems.MEAT && stack.getItemDamage() == MeatType.CHICKENNUGGET.getMetaData()) {
                if (!craftedEvent.player.inventory.addItemStackToInventory(new ItemStack(ModItems.MEAT, 1, MeatType.DRUMSTICK.getMetaData()))) {
                    craftedEvent.player.dropItem(new ItemStack(ModItems.MEAT, 1, MeatType.DRUMSTICK.getMetaData()), false);
                }
            }
        }
    }

    public static class AchievementTriggerEvent {
        @SubscribeEvent
        public void ItemSmeltedEvent(ItemSmeltedEvent smeltedEvent) {
            if (smeltedEvent.smelting.getItem() != null && smeltedEvent.smelting.getItem() instanceof ItemModFishFood) {
                smeltedEvent.player.addStat(AchievementList.COOK_FISH);
            }
        }
    }
}