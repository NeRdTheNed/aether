package com.gildedgames.aether.block.construction;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockSkyrootPlank extends Block
{

	public BlockSkyrootPlank()
	{
		super(Material.wood);
	
		this.setHardness(2.0F);
		this.setResistance(5F);
		this.setStepSound(Block.soundTypeWood);
	}
	
}