package com.girafi.culinarycultivation.inventory;

import com.girafi.culinarycultivation.util.NBTHelper;
import com.girafi.culinarycultivation.util.reference.Paths;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.common.util.Constants;

import javax.annotation.Nullable;

public class InventoryItem extends InventoryBasic {
    private final int stackLimit;
    private final ItemStack invItem;
    private final ItemStack[] inventory;

    public InventoryItem(ItemStack inventoryItem, String name, int size, int stackLimit) {
        super(I18n.translateToLocal(Paths.MOD_ASSETS + "container." + name), true, size);
        this.invItem = inventoryItem;
        this.inventory = new ItemStack[size];
        this.stackLimit = stackLimit;

        NBTHelper.getTag(invItem);
        this.readFromNBT();
    }

    public InventoryItem(ItemStack inventoryItem, String name, int size) {
        this(inventoryItem, name, size, 64);
    }

    public void readFromNBT() {
        NBTTagList items = this.invItem.getTagCompound().getTagList("ItemInventory", Constants.NBT.TAG_COMPOUND);

        for (int index = 0; index < items.tagCount(); index++) {
            NBTTagCompound compound = items.getCompoundTagAt(index);
            int slot = compound.getInteger("Slot");

            if (slot >= 0 && slot < getSizeInventory()) {
                this.inventory[slot] = NBTHelper.readItemStack(compound);
            }
        }
    }

    public void writeToNBT() {
        NBTTagList items = new NBTTagList();

        for (int index = 0; index < getSizeInventory(); index++) {
            ItemStack stack = this.getStackInSlot(index);

            if (stack != null) {
                NBTTagCompound compound = new NBTTagCompound();
                compound.setInteger("Slot", index);
                NBTHelper.writeItemStack(stack, compound);
                items.appendTag(compound);
            }
        }
        this.invItem.getTagCompound().setTag("ItemInventory", items);
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return inventory[index];
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        ItemStack stack = getStackInSlot(index);

        if (stack != null) {
            if (stack.stackSize > count) {
                stack = stack.splitStack(count);
                this.markDirty();
            } else {
                this.setInventorySlotContents(index, null);
            }
        }
        return stack;
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        ItemStack stack = getStackInSlot(index);
        this.setInventorySlotContents(index, null);
        return stack;
    }

    @Override
    public void setInventorySlotContents(int index, @Nullable ItemStack stack) {
        this.inventory[index] = stack;

        if (stack != null && stack.stackSize > getInventoryStackLimit()) {
            stack.stackSize = getInventoryStackLimit();
        }
        this.markDirty();
    }

    @Override
    public int getInventoryStackLimit() {
        return this.stackLimit;
    }

    @Override
    public void markDirty() {
        for (int index = 0; index < getSizeInventory(); index++) {
            if (getStackInSlot(index) != null && getStackInSlot(index).getItem() != null && getStackInSlot(index).stackSize == 0) {
                this.inventory[index] = null;
            }
        }
        this.writeToNBT();
    }
}