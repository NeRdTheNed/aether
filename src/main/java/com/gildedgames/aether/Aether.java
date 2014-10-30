package com.gildedgames.aether;

import net.minecraft.block.Block;

import com.gildedgames.aether.init.BlocksAether;
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
	}
	
	/** 
	 * Wrapper for registering a Block, can be safely changed at a later date. Should always be used to register blocks within the Aether.
	 * @param block The Block you want to register in Minecraft
	 * @param name The name of the Block you're registering
	 */
	public static void registerBlock(Block block, String name)
	{
		block.setBlockName(name);
		block.setBlockTextureName(Aether.getTextureName(name));
		
		GameRegistry.registerBlock(block, name);
	}
	
	/**
	 * Used to return a mod-friendly texture name for Blocks and Items.
	 * @param name The name of the texture's parent object
	 * @return The object name with the Mod address attached
	 */
	public static String getTextureName(String name)
	{
		return Aether.MOD_ID + ":" + name;
	}
	
}
