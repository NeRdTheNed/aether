package com.gildedgames.aether.init;

import net.minecraft.item.Item;

import com.gildedgames.aether.Aether;
import com.gildedgames.aether.items.materials.ItemContinuumOrb;

public class ItemsAether
{
	
	public static final Item
	
	ambrosiumShard = new Item().setCreativeTab(CreativeTabsAether.materials),
	
	zaniteGemstone = new Item().setCreativeTab(CreativeTabsAether.materials),
	
	continuumOrb = new ItemContinuumOrb().setCreativeTab(CreativeTabsAether.materials),
	
	goldenAmber = new Item().setCreativeTab(CreativeTabsAether.materials);

	public static void register()
	{
		Aether.registerItem(ItemsAether.ambrosiumShard, "ambrosiumShard");
		Aether.registerItem(ItemsAether.zaniteGemstone, "zaniteGemstone");
		Aether.registerItem(ItemsAether.continuumOrb, "continuumOrb");
		Aether.registerItem(ItemsAether.goldenAmber, "goldenAmber");
	}
	
}
