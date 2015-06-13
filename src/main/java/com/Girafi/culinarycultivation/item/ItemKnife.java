package com.Girafi.culinarycultivation.item;

import com.Girafi.culinarycultivation.creativetab.CreativeTab;
import com.Girafi.culinarycultivation.init.ModItems;
import com.Girafi.culinarycultivation.reference.Paths;
import com.Girafi.culinarycultivation.reference.Reference;
import com.google.common.collect.Sets;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

import java.util.Set;

public class ItemKnife extends ItemTool
{

    private static final Set EFFECTIVE_ON = Sets.newHashSet(new Block[]{});

    public ItemKnife(Item.ToolMaterial material)
    {
        super(3.0F, material, EFFECTIVE_ON);
        setUnlocalizedName(Paths.ModAssets + "knife");
        setTextureName(Paths.ModAssets + "knife");
        setCreativeTab(CreativeTab.CulinaryCultivation_Tab);
        maxStackSize=1;
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.damageItem(1, attacker);
        return true;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, Block blockIn, int x, int y, int z, EntityLivingBase playerIn) {
        if ((double) blockIn.getBlockHardness(worldIn, x, y, z) != 0.0D) {
            stack.damageItem(2, playerIn);
        }

        return true;
    }

    @Override
    public int getItemEnchantability() {return this.toolMaterial.WOOD.getHarvestLevel();
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldRotateAroundWhenRendering()
    {
        return true;
    }

}