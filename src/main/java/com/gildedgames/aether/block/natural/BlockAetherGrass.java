package com.gildedgames.aether.block.natural;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.gildedgames.aether.Aether;
import com.gildedgames.aether.init.BlocksAether;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockAetherGrass extends Block
{
	
	public static IIcon ICON_TOP, ICON_SIDE;
	
	public BlockAetherGrass()
	{
		super(Material.grass);
		
		this.setTickRandomly(true);
		this.setHardness(0.6F);
		this.setStepSound(Block.soundTypeGrass);
	}
	
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
		String iconName = Aether.getTextureName("aetherGrass");
		
		BlockAetherGrass.ICON_TOP = iconRegister.registerIcon(iconName + "_top");
		BlockAetherGrass.ICON_SIDE = iconRegister.registerIcon(iconName + "_side");
	}
    
	@Override
	public IIcon getIcon(int side, int meta)
	{
		if (side == 1)
		{
			return BlockAetherGrass.ICON_TOP;
		}

		if (side == 0)
		{
			return BlocksAether.aetherDirt.getIcon(side, meta);
		}

		return BlockAetherGrass.ICON_SIDE;
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
		
		if (lightValueAbove < 4 && blockAbove.getMaterial().getCanBlockGrass())
		{
			boolean chanceToStay = rand.nextInt(4) != 0;
			
			if (chanceToStay || blockAbove instanceof BlockWall)
			{
				return;
			}
			
			world.setBlock(x, y, z, BlocksAether.aetherDirt);
		}
		else if (world.getBlockLightValue(x, y + 1, z) >= 9)
		{
			int x1 = x + rand.nextInt(3) - 1;
			int y1 = y + rand.nextInt(5) - 3;
			int z1 = z + rand.nextInt(3) - 1;
			
			Block blockNearby = world.getBlock(x1, y1, z1);
			
			blockAbove = world.getBlock(x1, y1 + 1, z1);
			lightValueAbove = world.getBlockLightValue(x1, y1 + 1, z1);
			
			if (blockNearby == BlocksAether.aetherDirt && lightValueAbove >= 4 && !blockAbove.getMaterial().getCanBlockGrass())
			{
				world.setBlock(x1, y1, z1, BlocksAether.aetherGrass);
			}
		}
	}
	
}
