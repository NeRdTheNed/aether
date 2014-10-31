package com.gildedgames.aether.block.foliage;

import net.minecraft.block.BlockLeaves;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockAetherLeaves extends BlockLeaves
{

	private IIcon normalIcon;

	private IIcon opaqueIcon;

	public BlockAetherLeaves()
	{
		super();
	}

	@Override
	public int getRenderColor(int i)
	{
		return 0xffffff;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.normalIcon = iconRegister.registerIcon(this.getTextureName());
		this.opaqueIcon = iconRegister.registerIcon(this.getTextureName() + "_opaque");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata)
	{
		this.setGraphicsLevel(Minecraft.getMinecraft().gameSettings.fancyGraphics);
		return this.field_150121_P ? this.normalIcon : this.opaqueIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getBlockColor()
	{
		return 16777215;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
	{
		return 16777215;
	}

	@Override
	public String[] func_150125_e()
	{
		return null;
	}
}