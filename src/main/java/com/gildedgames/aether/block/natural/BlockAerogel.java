package com.gildedgames.aether.block.natural;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

public class BlockAerogel extends Block
{

	public BlockAerogel()
	{
		super(Material.rock);
		
		this.setHardness(1.0F);
		this.setResistance(2000F);
		this.setLightOpacity(3);
		this.setStepSound(Block.soundTypeStone);
	}

	@Override
	public int getRenderBlockPass()
	{
		return 1;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int x, int y, int z, int side)
	{
		Block block = iblockaccess.getBlock(x, y, z);
		
		return !(block == this || (!iblockaccess.isAirBlock(x, y, z) && block.isOpaqueCube()));
	}
	
}
