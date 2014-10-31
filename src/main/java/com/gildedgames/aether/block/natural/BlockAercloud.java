package com.gildedgames.aether.block.natural;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.gildedgames.aether.Aether;

public class BlockAercloud extends Block
{
	
	public static enum Type
	{
		COLD("aercloudCold")
		{

			@Override
			public int[] getMetadata()
			{
				return new int[] { 0 };
			}

		},
		BLUE("aercloudBlue")
		{

			@Override
			public int[] getMetadata()
			{
				return new int[] { 1 };
			}
			
			@Override
			public void onEntityCollide(World world, Entity entity, int x, int y, int z)
			{
				if (!entity.isRiding() && !entity.isSneaking())
				{
					entity.motionY = 2.0D;

					if (Aether.isClient() && !(entity instanceof EntityFX))
					{
						entity.motionY = 2.0D;
						
						final int splashAmount = 50;
						
						for (int count = 0; count < splashAmount; count++)
						{
							double xOffset = x + rand.nextDouble();
							double yOffset = y + rand.nextDouble();
							double zOffset = z + rand.nextDouble();

							world.spawnParticle("splash", xOffset, yOffset, zOffset, 0, 0, 0);
						}
					}
	
					if (entity instanceof EntityPlayer)
					{
						EntityPlayer player = (EntityPlayer) entity;
	
						if (player.capabilities.isFlying)
						{
							return;
						}
					}
	
					world.playSoundAtEntity(entity, "aether:aemisc.aercloud", 0.35F, world.rand.nextFloat());
				}
				else
				{
					super.onEntityCollide(world, entity, x, y, z);
				}
			}
			
			@Override
			public AxisAlignedBB getCollisionBox(World world, int x, int y, int z)
			{
				return AxisAlignedBB.getBoundingBox(x, y, z, x, y, z);
			}
			
		},
		GOLDEN("aercloudGolden")
		{

			@Override
			public int[] getMetadata()
			{
				return new int[] { 2 };
			}
			
			@Override
			public void onEntityCollide(World world, Entity entity, int x, int y, int z)
			{
				if (!entity.isRiding() && !entity.isSneaking())
				{
					entity.motionY = -1.5D;
				}
				else
				{
					super.onEntityCollide(world, entity, x, y, z);
				}
			}
			
			@Override
			public AxisAlignedBB getCollisionBox(World world, int x, int y, int z)
			{
				return AxisAlignedBB.getBoundingBox(x, y, z, x, y, z);
			}
			
		},
		GREEN("aercloudGreen")
		{

			@Override
			public int[] getMetadata()
			{
				return new int[] { 3 };
			}
			
			@Override
			public void onEntityCollide(World world, Entity entity, int x, int y, int z)
			{
				if (!entity.isRiding() && !entity.isSneaking())
				{
					entity.motionX *= 0.0000000005D;
					entity.motionZ *= 0.0000000005D;
	
					int chance = rand.nextInt(4);
	
					if (chance == 0)
					{
						entity.motionZ = -2.5D;
					}
					else if (chance == 1)
					{
						entity.motionX = +2.5D;
					}
					else if (chance == 2)
					{
						entity.motionZ = +2.5D;
					}
					else if (chance == 3)
					{
						entity.motionX = -2.5D;
					}
				}
				else
				{
					super.onEntityCollide(world, entity, x, y, z);
				}
			}
			
			@Override
			public AxisAlignedBB getCollisionBox(World world, int x, int y, int z)
			{
				return AxisAlignedBB.getBoundingBox(x, y, z, x, y, z);
			}
			
		},
		STORM("aercloudStorm")
		{

			@Override
			public int[] getMetadata()
			{
				return new int[] { 4 };
			}

		};
		
		private static Random rand = new Random();
		
		private static GameSettings settings = Minecraft.getMinecraft().gameSettings;

		protected IIcon icon, opaqueIcon;

		protected String name;
		
		Type(String name)
		{
			this.name = name;
		}

		public void onEntityCollide(World world, Entity entity, int x, int y, int z)
		{
			if (entity.motionY < 0)
			{
				entity.motionY *= 0.005D;
			}
		}
		
		public AxisAlignedBB getCollisionBox(World world, int x, int y, int z)
		{
			return AxisAlignedBB.getBoundingBox(x, y, z, x + 1, y, z + 1);
		}
		
		public static Type get(World world, int x, int y, int z)
		{
			final int blockMetadata = world.getBlockMetadata(x, y, z);
			
			return get(blockMetadata);
		}
		
		public static Type get(int blockMetadata)
		{
			for (Type type : Type.values())
			{
				for (int meta : type.getMetadata())
				{
					if (meta == blockMetadata)
					{
						return type;
					}
				}
			}
				
			return Type.values()[0];
		}

		public void registerBlockIcons(IIconRegister iconRegister)
		{
			String iconName = Aether.modAddress() + this.name;
			
			this.icon = iconRegister.registerIcon(iconName);
			this.opaqueIcon = iconRegister.registerIcon(iconName + "_opaque");
		}

		public IIcon getIcon(int side, int blockMetadata)
		{
			return settings.fancyGraphics ? this.icon : this.opaqueIcon;
		}
		
		public abstract int[] getMetadata();
	}

	public BlockAercloud()
	{
		super(Material.ice);
		
		this.setHardness(0.2F);
		this.setLightOpacity(0);
		this.setStepSound(Block.soundTypeCloth);
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs par2CreativeTabs, List creativeList)
	{
		for (Type type : Type.values())
		{
			creativeList.add(new ItemStack(item, 1, type.getMetadata()[0]));
		}
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		final Type type = Type.get(world, x, y, z);
		
		return type.getCollisionBox(world, x, y, z);
	}
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		final Type type = Type.get(world, x, y, z);
		
		type.onEntityCollide(world, entity, x, y, z);
	}
	
	@Override
	public int damageDropped(int meta)
	{
		return meta;
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int x, int y, int z, int side)
	{
		Block block = iblockaccess.getBlock(x, y, z);
		
		return !(block == this || (!iblockaccess.isAirBlock(x, y, z) && block.isOpaqueCube()));
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@Override
	public int getRenderBlockPass()
	{
		return 1;
	}

	@Override
	public boolean isOpaqueCube()
	{
        return false;
	}
	
	@Override
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
		return Type.get(blockMetadata).getIcon(side, blockMetadata);
	}

}
