package net.cieloangel.gardencraft;

import net.cieloangel.gardencraft.client.GardenCraftTab;
import net.cieloangel.gardencraft.init.ModBlocks;
import net.cieloangel.gardencraft.init.ModItems;
import net.cieloangel.gardencraft.init.ModRecipes;
import net.cieloangel.gardencraft.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_MC_VERSIONS)

public class GardenCraft {
	
	public static final GardenCraftTab CREATIVE_TAB = new GardenCraftTab();
	
	@Instance
	public static GardenCraft instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println(Reference.NAME + " is planting its seeds...");
		
		ModBlocks.init();
		ModItems.init();
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new ModGuiHandler());
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		System.out.println(Reference.NAME + " is growing strong...");
		ModRecipes.init();
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
		System.out.println(Reference.NAME + " is ready for harvesting...");
	}

}
