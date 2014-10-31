package com.gildedgames.aether.items.materials;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemContinuumOrb extends Item
{
	
	private static Random random = new Random();

	private static ArrayList<Item> banList = new ArrayList<Item>();

	public ItemContinuumOrb()
	{
		super();
		
		this.setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		if (world.isRemote)
		{
			return itemstack;
		}
		
		int count;

		Item item = null;
		
		do
		{
			count = 256 + random.nextInt(32000 - 256);
			
			item = Item.getItemById(count);
		}
		while (item == null || (item != null && item instanceof ItemBlock) || banList.contains(item));

		itemstack = new ItemStack(item);

		return itemstack;
	}

	public static void addBan(Item item)
	{
		banList.add(item);
	}

	public static void removeBan(Item item)
	{
		banList.remove(item);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List infoList, boolean par4)
	{
		infoList.add("\2479Ability: " + "\247rGrants Random Item");
		infoList.add("\2473Use: " + "\247rRight-Click");
	}
	
}
