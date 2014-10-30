package com.gildedgames.aether.init;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

import com.gildedgames.aether.Aether;
import com.gildedgames.aether.block.natural.BlockAetherDirt;
import com.gildedgames.aether.block.natural.BlockAetherGrass;
import com.gildedgames.aether.block.natural.BlockHolystone;

public class BlocksAether
{

	public final static Block holystone = new BlockHolystone().setCreativeTab(CreativeTabs.tabBlock);
	
	public final static Block aetherDirt = new BlockAetherDirt().setCreativeTab(CreativeTabs.tabBlock);
	
	public final static Block aetherGrass = new BlockAetherGrass().setCreativeTab(CreativeTabs.tabBlock);
	
	public static void register()
	{
		Aether.registerBlock(BlocksAether.holystone, "holystone");
		Aether.registerBlock(BlocksAether.aetherDirt, "aetherDirt");
		Aether.registerBlock(BlocksAether.aetherGrass, "aetherGrass");
	}
	
}
