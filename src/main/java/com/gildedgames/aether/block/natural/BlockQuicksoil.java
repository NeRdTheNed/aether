
package com.gildedgames.aether.block.natural;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockQuicksoil extends Block
{

	public BlockQuicksoil()
	{
		super(Material.sand);
		
		this.slipperiness = 1.23F;
		this.setHardness(0.5F);
		this.setStepSound(Block.soundTypeSand);
	}
	
}
