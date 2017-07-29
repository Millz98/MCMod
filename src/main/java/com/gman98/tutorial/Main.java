package com.gman98.tutorial;

import com.gman98.tutorial.proxy.CommonProxy;

import init.ModItems;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION, acceptedMinecraftVersions = Main.ACCEPTED_VERSIONS)
public class Main {
// this main class is also the reference for the mod. 
    public static final String MODID = "gtm";
    public static final String MODNAME = "Tutorial Mod";
    public static final String VERSION = "1.0";
    public static final String ACCEPTED_VERSIONS = "[1.11.2]";
    
    public static final String CLIENT_PROXY_CLASS = "com.gman98.tutorial.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "com.gman98.tutorial.proxy.ServerProxy";
    
    //Below is where you will have to add each item in separate.
    //Keep the item names in () all lowercase like "itemobsidianingot"
    public static enum TutorialItems
    {
    	OBSIDIANINGOT("obsidianingot", "itemobsidianingot");
    	
    	private String unlocalizedName;
    	private String registryName;
    	
    	
    	TutorialItems(String unlocalizedName, String registryName)
    	{
    		
    	this.unlocalizedName = unlocalizedName;
    	this.registryName = registryName;
    	}
    	
    	public String getUnlocalizedName() 
    	{
    		return unlocalizedName;
    		
    	}
    	
    	public String getRegistryName() {
    		return registryName;
    	}
    }
    
    @Instance
    public static Main instance;

    @SidedProxy(clientSide = Main.CLIENT_PROXY_CLASS, serverSide = Main.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;
    
    //Below is where you need to put everything that you want loaded into the game as its starting like items, probably entities down the road too. 
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	
    	ModItems.init();
    	ModItems.register();
    }

    @EventHandler
    public void Init(FMLInitializationEvent event) {
    	proxy.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }
}