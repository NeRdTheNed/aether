package com.gildedgames.aether;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import com.gildedgames.aether.init.BlocksAether;
import com.gildedgames.aether.init.ItemsAether;
import com.gildedgames.aether.server.ServerProxy;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = Aether.MOD_ID, name = "Aether II", version = Aether.VERSION)
public class Aether
{
	
	public static final String MOD_ID = "aether";
	
	public static final String VERSION = "Alpha 1.7.10-1.0";
	
	@Instance(Aether.MOD_ID)
	public static Aether instance;
	
	@SidedProxy(clientSide = "com.gildedgames.aether.client.ClientProxy", serverSide = "com.gildedgames.aether.server.ServerProxy")
	public static ServerProxy proxy;
	
	/**
	 * Returns the game's current networking Side.
	 */
	public static Side getAppState()
	{
		return FMLCommonHandler.instance().getEffectiveSide();
	}

	/**
	 * Returns whether the game's state is Client-Side or not.
	 */
	public static boolean isClient()
	{
		return getAppState() == Side.CLIENT;
	}

	/**
	 * Returns whether the game's state is Server-Side or not.
	 */
	public static boolean isServer()
	{
		return getAppState() == Side.SERVER;
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		BlocksAether.register();
		ItemsAether.register();
	}
	
	/** 
	 * Wrapper for registering a Block, can be safely changed at a later date. Should always be used to register Blocks within the Aether.
	 * @param block The Block you want to register in Minecraft
	 * @param name The unlocalized name of the Block you're registering
	 */
	public static void registerBlock(Block block, String name)
	{
		block.setBlockName(name);
		block.setBlockTextureName(Aether.modAddress() + name);
		
		GameRegistry.registerBlock(block, name);
	}
	
	/** 
	 * Wrapper for registering a Block, can be safely changed at a later date. Should always be used to register Blocks within the Aether.
	 * @param block The Block you want to register in Minecraft
	 * @param itemBlock The ItemBlock used to represent the ItemStack of this Block
	 * @param name The unlocalized name of the Block you're registering
	 */
	public static void registerBlock(Block block, Class<? extends ItemBlock> itemBlock, String name)
	{
		block.setBlockName(name);
		block.setBlockTextureName(Aether.modAddress() + name);
		
		GameRegistry.registerBlock(block, itemBlock, name);
	}
	
	/** 
	 * Wrapper for registering an Item, can be safely changed at a later date. Should always be used to register Items within the Aether.
	 * @param item The Item you want to register in Minecraft
	 * @param name The unlocalized name of the Item you're registering
	 */
	public static void registerItem(Item item, String name)
	{
		item.setUnlocalizedName(name);
		item.setTextureName(Aether.modAddress() + name);
		
		GameRegistry.registerItem(item, name);
	}
	
	/**
	 * Used to represent that a particular ResourceLocation is assigned to the Aether mod.
	 * @return The appropriate address for the Aether mod
	 */
	public static String modAddress()
	{
		return Aether.MOD_ID + ":";
	}
	
}
