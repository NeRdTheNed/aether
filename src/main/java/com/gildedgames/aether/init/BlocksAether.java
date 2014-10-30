package com.gildedgames.aether.init;

import net.minecraft.block.Block;

import com.gildedgames.aether.Aether;
import com.gildedgames.aether.block.natural.BlockAetherDirt;
import com.gildedgames.aether.block.natural.BlockAetherGrass;
import com.gildedgames.aether.block.natural.BlockHolystone;
import com.gildedgames.aether.block.natural.BlockQuicksoil;

public class BlocksAether
{

	public final static Block
	
	holystone = new BlockHolystone().setCreativeTab(CreativeTabsAether.blocksNatural),
	
	aetherDirt = new BlockAetherDirt().setCreativeTab(CreativeTabsAether.blocksNatural),
	
	aetherGrass = new BlockAetherGrass().setCreativeTab(CreativeTabsAether.blocksNatural),
	
	quicksoil = new BlockQuicksoil().setCreativeTab(CreativeTabsAether.blocksNatural);
	
	public static void register()
	{
		Aether.registerBlock(BlocksAether.holystone, "holystone");
		Aether.registerBlock(BlocksAether.aetherDirt, "aetherDirt");
		Aether.registerBlock(BlocksAether.aetherGrass, "aetherGrass");
		Aether.registerBlock(BlocksAether.quicksoil, "quicksoil");
	}
	
}
