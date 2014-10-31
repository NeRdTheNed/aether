package com.gildedgames.aether.items.materials;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.gildedgames.aether.init.BlocksAether;

public class ItemAmbrosiumShard extends Item
{

	public ItemAmbrosiumShard()
	{
		super();
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
	{
		Block block = world.getBlock(x, y, z);
		int oldMetadata = world.getBlockMetadata(x, y, z);

		if (player.canPlayerEdit(x, y, z, par7, stack))
		{
			int newMetadata = 0;
			
			if (block == BlocksAether.aetherGrass && oldMetadata == 0)
			{
				newMetadata = 1;
			}
			else if (block == Blocks.grass)
			{
				newMetadata = 2;
			}
			
			if (newMetadata != 0)
			{
				world.setBlock(x, y, z, BlocksAether.aetherGrass, newMetadata, 2);
				
				if (!player.capabilities.isCreativeMode)
				{
					--stack.stackSize;
				}
				
				return true;
			}
		}

		return false;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List infoList, boolean par4)
	{
		infoList.add("\2479Enchants: " +  "\247rGrass");
		infoList.add("\2473Use:\247r Right-Click Grass");
	}
	
}
