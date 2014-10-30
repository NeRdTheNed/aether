package com.gildedgames.aether.block.natural;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockIcestone extends Block
{
	
	public static final int FREEZE_RADIUS = 3;

	public BlockIcestone()
	{
		super(Material.rock);
		
		this.setTickRandomly(true);
		this.setHardness(3.0F);
		this.setStepSound(Block.soundTypeGlass);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand)
	{
		this.freezeArea(world, x, y, z);
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack)
	{
		this.freezeArea(world, x, y, z);
	}
	
	public void freezeArea(World world, int x, int y, int z)
	{
		if (world.isRemote)
		{
			return;
		}
		
		for (int x1 = x - FREEZE_RADIUS; x1 <= x + FREEZE_RADIUS; x1++)
		{
			for (int y1 = y - FREEZE_RADIUS; y1 <= y + FREEZE_RADIUS; y1++)
			{
				for (int z1 = z - FREEZE_RADIUS; z1 <= z + FREEZE_RADIUS; z1++)
				{
					Block block = world.getBlock(x1, y1, z1);

					if (block == Blocks.flowing_water || block == Blocks.flowing_lava)
					{
						world.setBlock(x1, y1, z1, Blocks.air);
						continue;
					}
					
					if (block == Blocks.water)
					{
						world.setBlock(x1, y1, z1, Blocks.ice);
						continue;
					}

					if (block == Blocks.lava)
					{
						world.setBlock(x1, y1, z1, Blocks.obsidian);
						continue;
					}
				}
			}
		}
	}
	
}
