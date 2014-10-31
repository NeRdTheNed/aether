package com.gildedgames.aether.block.natural;

import java.util.List;

import com.gildedgames.aether.Aether;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockOldAetherLog extends BlockLog
{
	
	public static enum Type
	{
		SKYROOT("skyroot"),
		GOLDEN_OAK("goldenOak");
		
		protected String name;
		
		Type(String name)
		{
			this.name = name;
		}
		
		public String getName()
		{
			return this.name;
		}
		
	}
	
    @SideOnly(Side.CLIENT)
    protected IIcon[] sideIcons;
    @SideOnly(Side.CLIENT)
    protected IIcon[] topIcons;

	public BlockOldAetherLog()
	{
		super();
		
		this.setHardness(2.0F);
		this.setStepSound(Block.soundTypeWood);
	}
	
    public static int func_150165_c(int metadata)
    {
        return metadata & 1;
    }

    @SideOnly(Side.CLIENT)
    protected IIcon getSideIcon(int metadataBit)
    {
        return this.sideIcons[metadataBit % this.sideIcons.length];
    }

    @SideOnly(Side.CLIENT)
    protected IIcon getTopIcon(int metadataBit)
    {
        return this.topIcons[metadataBit % this.topIcons.length];
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List creativeList)
    {
        creativeList.add(new ItemStack(item, 1, 0));
        creativeList.add(new ItemStack(item, 1, 1));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.sideIcons = new IIcon[Type.values().length];
        this.topIcons = new IIcon[Type.values().length];

        for (Type type : Type.values())
        {
            this.sideIcons[type.ordinal()] = iconRegister.registerIcon(Aether.modAddress() + type.getName() + "_side");
            this.topIcons[type.ordinal()] = iconRegister.registerIcon(Aether.modAddress() + type.getName() + "_top");
        }
    }

}
