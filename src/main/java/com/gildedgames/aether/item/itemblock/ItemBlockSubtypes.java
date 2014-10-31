package com.gildedgames.aether.item.itemblock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockSubtypes extends ItemBlock
{

	public ItemBlockSubtypes(Block block)
	{
		super(block);
		
		this.setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		int i = itemstack.getItemDamage();

		return this.getUnlocalizedName() + i;
	}

	@Override
	public int getMetadata(int damage)
	{
		return damage;
	}
	
}
