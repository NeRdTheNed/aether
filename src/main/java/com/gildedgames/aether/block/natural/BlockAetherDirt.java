package com.gildedgames.aether.block.natural;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockAetherDirt extends Block
{

	public BlockAetherDirt()
	{
		super(Material.ground);
		
		this.setHardness(0.5F);
		this.setStepSound(Block.soundTypeGravel);
	}
	
}
