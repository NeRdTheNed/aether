package com.gildedgames.aether.init;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

import com.gildedgames.aether.Aether;
import com.gildedgames.aether.block.construction.BlockSkyrootPlank;
import com.gildedgames.aether.block.foliage.BlockAetherLeaves;
import com.gildedgames.aether.block.natural.BlockAercloud;
import com.gildedgames.aether.block.natural.BlockAerogel;
import com.gildedgames.aether.block.natural.BlockAetherDirt;
import com.gildedgames.aether.block.natural.BlockAetherGrass;
import com.gildedgames.aether.block.natural.BlockAetherOre;
import com.gildedgames.aether.block.natural.BlockHolystone;
import com.gildedgames.aether.block.natural.BlockIcestone;
import com.gildedgames.aether.block.natural.BlockOldAetherLog;
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
	
	aercloud = new BlockAercloud().setCreativeTab(CreativeTabsAether.blocksNatural),
	
	aerogel = new BlockAerogel().setCreativeTab(CreativeTabsAether.blocksNatural),
	
	aetherLog = new BlockOldAetherLog().setCreativeTab(CreativeTabsAether.blocksNatural),
	
	skyrootPlank = new BlockSkyrootPlank().setCreativeTab(CreativeTabsAether.blocksConstruction),
	
	greenSkyrootLeaves = new BlockAetherLeaves().setCreativeTab(CreativeTabsAether.blocksFoliage),
	
	blueSkyrootLeaves = new BlockAetherLeaves().setCreativeTab(CreativeTabsAether.blocksFoliage),
	
	darkBlueSkyrootLeaves = new BlockAetherLeaves().setCreativeTab(CreativeTabsAether.blocksFoliage),
	
	goldenOakLeaves = new BlockAetherLeaves().setCreativeTab(CreativeTabsAether.blocksFoliage),
	
	purpleCrystalLeaves = new BlockAetherLeaves().setCreativeTab(CreativeTabsAether.blocksFoliage),
	
	ambrosiumOre = new BlockAetherOre(ItemsAether.ambrosiumShard)
	{
		
		@Override
		public int getExperience(IBlockAccess iBlockAccess, int blockMetadata, int fortuneLevel)
		{
			return MathHelper.getRandomIntegerInRange(this.rand, 0, 2);
		}

		@Override
		public int getQuantityDropped(Random rand)
		{
			return MathHelper.getRandomIntegerInRange(this.rand, 1, 2);
		}
		
	},
	
	zaniteOre = new BlockAetherOre(ItemsAether.zaniteGemstone)
	{
		
		@Override
		public int getExperience(IBlockAccess iBlockAccess, int blockMetadata, int fortuneLevel)
		{
			return MathHelper.getRandomIntegerInRange(this.rand, 2, 5);
		}

		@Override
		public int getQuantityDropped(Random rand)
		{
			return 1;
		}
		
	},
	
	gravititeOre = new BlockAetherOre()
	{
		
		@Override
		public int getExperience(IBlockAccess iBlockAccess, int blockMetadata, int fortuneLevel)
		{
			return MathHelper.getRandomIntegerInRange(this.rand, 3, 7);
		}

		@Override
		public int getQuantityDropped(Random rand)
		{
			return 1;
		}
		
	},
	
	continuumOre = new BlockAetherOre(ItemsAether.continuumOrb)
	{
		
		@Override
		public int getExperience(IBlockAccess iBlockAccess, int blockMetadata, int fortuneLevel)
		{
			return MathHelper.getRandomIntegerInRange(this.rand, 3, 7);
		}

		@Override
		public int getQuantityDropped(Random rand)
		{
			return MathHelper.getRandomIntegerInRange(this.rand, 1, 2);
		}
		
	};

	public static void register()
	{
		BlocksAether.ambrosiumOre.setHarvestLevel("pickaxe", 0);
		BlocksAether.zaniteOre.setHarvestLevel("pickaxe", 1);
		BlocksAether.gravititeOre.setHarvestLevel("pickaxe", 2);
		BlocksAether.continuumOre.setHarvestLevel("pickaxe", 3);
		BlocksAether.aetherLog.setHarvestLevel("axe", 0);
		
		Aether.registerBlock(BlocksAether.holystone, "holystone");
		Aether.registerBlock(BlocksAether.aetherDirt, "aetherDirt");
		Aether.registerBlock(BlocksAether.aetherGrass, ItemBlockSubtypes.class, "aetherGrass");
		Aether.registerBlock(BlocksAether.quicksoil, "quicksoil");
		Aether.registerBlock(BlocksAether.icestone, "icestone");
		Aether.registerBlock(BlocksAether.aercloud, ItemBlockSubtypes.class, "aercloud");
		Aether.registerBlock(BlocksAether.aerogel, "aerogel");
		Aether.registerBlock(BlocksAether.aetherLog, ItemBlockSubtypes.class, "aetherLog");
		Aether.registerBlock(BlocksAether.skyrootPlank, "skyrootPlank");
		Aether.registerBlock(BlocksAether.greenSkyrootLeaves, "greenSkyrootLeaves");
		Aether.registerBlock(BlocksAether.blueSkyrootLeaves, "blueSkyrootLeaves");
		Aether.registerBlock(BlocksAether.darkBlueSkyrootLeaves, "darkBlueSkyrootLeaves");
		Aether.registerBlock(BlocksAether.goldenOakLeaves, "goldenOakLeaves");
		Aether.registerBlock(BlocksAether.purpleCrystalLeaves, "purpleCrystalLeaves");
		Aether.registerBlock(BlocksAether.ambrosiumOre, "ambrosiumOre");
		Aether.registerBlock(BlocksAether.zaniteOre, "zaniteOre");
		Aether.registerBlock(BlocksAether.gravititeOre, "gravititeOre");
		Aether.registerBlock(BlocksAether.continuumOre, "continuumOre");
	}
	
}
