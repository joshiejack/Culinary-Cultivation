package com.Girafi.culinarycultivation.item;

import com.Girafi.culinarycultivation.reference.Paths;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.util.Set;

public class ItemSugarCaneHarvester extends ItemTool {

    private static final Set EFFECTIVE_ON = Sets.newHashSet(new Block[]{Blocks.reeds});

    public ItemSugarCaneHarvester(ToolMaterial material) {
        super(2.0F, material, EFFECTIVE_ON);
        setUnlocalizedName(Paths.ModAssets + "sugarCaneHarvester");
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World world, Block block, BlockPos pos, EntityLivingBase living) {
        EntityPlayer player = (EntityPlayer) living;

        if ((double) block.getBlockHardness(world, pos) != 0.0D) {
            stack.damageItem(1, living);
        }
        /*if (block != null && block == Blocks.reeds) {
            int meta = world.getBlockMetadata(pos);
            boolean b = block.canHarvestBlock((EntityPlayer) living, 0) == false;
            block.harvestBlock(world, player, x, y + 2, z, meta);
            block.harvestBlock(world, player, x, y - 1, z, meta);
            world.setBlockToAir(pos);

        }*/
        return true;
    }
}