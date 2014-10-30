package com.gildedgames.aether;

import net.minecraft.init.Blocks;

import com.gildedgames.aether.server.ServerProxy;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
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
	
	public static Side getAppState()
	{
		return FMLCommonHandler.instance().getEffectiveSide();
	}

	public static boolean isClient()
	{
		return getAppState() == Side.CLIENT;
	}

	public static boolean isServer()
	{
		return getAppState() == Side.SERVER;
	}
	
}
