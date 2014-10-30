package com.gildedgames.aether.init;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

import com.gildedgames.aether.Aether;
import com.gildedgames.aether.block.BlockHolystone;

public class BlocksAether
{

	public final static Block holystone = new BlockHolystone().setCreativeTab(CreativeTabs.tabBlock);
	
	public static void register()
	{
		Aether.registerBlock(BlocksAether.holystone, "holystone");
	}
	
}
