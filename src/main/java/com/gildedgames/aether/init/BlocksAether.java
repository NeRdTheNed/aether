package com.gildedgames.aether.init;

import net.minecraft.block.Block;

import com.gildedgames.aether.Aether;
import com.gildedgames.aether.block.natural.BlockAercloud;
import com.gildedgames.aether.block.natural.BlockAetherDirt;
import com.gildedgames.aether.block.natural.BlockAetherGrass;
import com.gildedgames.aether.block.natural.BlockHolystone;
import com.gildedgames.aether.block.natural.BlockIcestone;
import com.gildedgames.aether.block.natural.BlockQuicksoil;
import com.gildedgames.aether.item.itemblock.ItemBlockSubtypes;

public class BlocksAether
{

	public final static Block
	
	holystone = new BlockHolystone().setCreativeTab(CreativeTabsAether.blocksNatural),
	
	aetherDirt = new BlockAetherDirt().setCreativeTab(CreativeTabsAether.blocksNatural),
	
	aetherGrass = new BlockAetherGrass().setCreativeTab(CreativeTabsAether.blocksNatural),
	
	quicksoil = new BlockQuicksoil().setCreativeTab(CreativeTabsAether.blocksNatural),
	
	icestone = new BlockIcestone().setCreativeTab(CreativeTabsAether.blocksNatural),
	
	aercloud = new BlockAercloud().setCreativeTab(CreativeTabsAether.blocksNatural);
	
	public static void register()
	{
		Aether.registerBlock(BlocksAether.holystone, "holystone");
		Aether.registerBlock(BlocksAether.aetherDirt, "aetherDirt");
		Aether.registerBlock(BlocksAether.aetherGrass, "aetherGrass");
		Aether.registerBlock(BlocksAether.quicksoil, "quicksoil");
		Aether.registerBlock(BlocksAether.icestone, "icestone");
		Aether.registerBlock(BlocksAether.aercloud, ItemBlockSubtypes.class, "aercloud");
	}
	
}
