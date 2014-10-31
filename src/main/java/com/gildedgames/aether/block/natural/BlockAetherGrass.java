package com.gildedgames.aether.block.natural;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.gildedgames.aether.Aether;
import com.gildedgames.aether.init.BlocksAether;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockAetherGrass extends Block
{
	
	public static enum Type
	{
		
		AETHER("aetherGrass", 0, false)
		{
			@Override
			public IIcon getBottomIcon(int side, int blockMetadata)
			{
				return BlocksAether.aetherDirt.getIcon(side, blockMetadata);
			}
		},
		ENCHANTED_AETHER("enchantedAetherGrass", 1, true)
		{
			@Override
			public IIcon getBottomIcon(int side, int blockMetadata)
			{
				return BlocksAether.aetherDirt.getIcon(side, blockMetadata);
			}
		},
		ENCHANTED("enchantedGrass", 2, true)
		{
			@Override
			public IIcon getBottomIcon(int side, int blockMetadata)
			{
				return Blocks.dirt.getIcon(side, blockMetadata);
			}
		};
		
		protected String name;
		
		protected IIcon top, side;
		
		protected int blockMetadata;
		
		protected boolean isEnchanted;
		
		Type(String name, int blockMetadata, boolean isEnchanted)
		{
			this.name = name;
			this.blockMetadata = blockMetadata;
			this.isEnchanted = isEnchanted;
		}
		
		public String getName()
		{
			return this.name;
		}

		public void registerBlockIcons(IIconRegister iconRegister)
		{
			String iconName = Aether.modAddress() + this.getName();
    		
    		this.top = iconRegister.registerIcon(iconName + "_top");
    		this.side = iconRegister.registerIcon(iconName + "_side");
		}
		
		public IIcon getTopIcon()
		{
			return this.top;
		}
		
		public IIcon getSideIcon()
		{
			return this.side;
		}
		
		public boolean isEnchanted()
		{
			return this.isEnchanted;
		}
		
		public int getMetadata()
		{
			return this.blockMetadata;
		}
		
		public static Type get(int blockMetadata)
		{
			for (Type type : Type.values())
			{
				if (type.blockMetadata == blockMetadata)
				{
					return type;
				}
			}
				
			return Type.values()[0];
		}
		
		public abstract IIcon getBottomIcon(int side, int blockMetadata);

	}
	
	public static final int REQUIRED_LIGHT = 9, MINIMUM_LIGHT = 4, MAX_OPACITY = 2;
	
	public BlockAetherGrass()
	{
		super(Material.grass);
		
		this.setTickRandomly(true);
		this.setHardness(0.6F);
		this.setStepSound(Block.soundTypeGrass);
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs creativeTabs, List creativeList)
	{
		for (Type type : Type.values())
		{
			creativeList.add(new ItemStack(item, 1, type.getMetadata()));
		}
	}
	
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
    	for (Type type : Type.values())
    	{
    		type.registerBlockIcons(iconRegister);
    	}
	}
    
	@Override
	public IIcon getIcon(int side, int blockMetadata)
	{
		final int TOP = 1;
		final int BOTTOM = 0;
		
		final Type type = Type.get(blockMetadata);
		
		if (side == TOP)
		{
			return type.getTopIcon();
		}

		if (side == BOTTOM)
		{
			return type.getBottomIcon(side, blockMetadata);
		}
		
		return type.getSideIcon();
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand)
	{
		if (world.isRemote)
		{
			return;
		}
		
		Block blockAbove = world.getBlock(x, y + 1, z);
		int lightValueAbove = world.getBlockLightValue(x, y + 1, z);
		int lightOpacityAbove = world.getBlockLightOpacity(x, y + 1, z);
		
		if (lightValueAbove < MINIMUM_LIGHT && lightOpacityAbove > MAX_OPACITY)
		{
			final boolean chanceToStay = rand.nextInt(4) != 0;
			
			if (chanceToStay || blockAbove instanceof BlockWall)
			{
				return;
			}
			
			world.setBlock(x, y, z, BlocksAether.aetherDirt);
		}
		else if (lightValueAbove >= REQUIRED_LIGHT)
		{
			for (int growCount = 0; growCount < 4; ++growCount)
            {
				int x1 = x + rand.nextInt(3) - 1;
				int y1 = y + rand.nextInt(5) - 3;
				int z1 = z + rand.nextInt(3) - 1;
				
				Block blockNearby = world.getBlock(x1, y1, z1);
				
				blockAbove = world.getBlock(x1, y1 + 1, z1);
				lightValueAbove = world.getBlockLightValue(x1, y1 + 1, z1);
				lightOpacityAbove = world.getBlockLightOpacity(x1, y1 + 1, z1);
				
				if (blockNearby == BlocksAether.aetherDirt && lightValueAbove >= MINIMUM_LIGHT && lightOpacityAbove <= MAX_OPACITY)
				{
					world.setBlock(x1, y1, z1, BlocksAether.aetherGrass);
				}
            }
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		super.randomDisplayTick(world, x, y, z, random);
		
		final int blockMetadata = world.getBlockMetadata(x, y, z);
		Type type = Type.get(blockMetadata);

		if (random.nextInt(4) == 0 && type.isEnchanted())
		{
			if (world.isRemote)
			{
				for (int count = 0; count < 6; count++)
				{
					
					//FMLClientHandler.instance().getClient().effectRenderer.addEffect(obj);
				}
			}
		}
	}
	
}
