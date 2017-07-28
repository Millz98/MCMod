package init;

import items.ItemObsidianingot;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static Item obsidianingot;
	
	//the code below is where you would put ALL of your items (I am assuming JUST items, will have to research) in so that the game can add 
	//them to the initialization process that allows them to be actually placed INTO the game.
	
	
	public static void init() {
		obsidianingot = new ItemObsidianingot();
	}
	
	public static void register() {
		GameRegistry.register(obsidianingot);
	}
	
	public static void registerRenders() {
		registerRender(obsidianingot);
	}
	
	private static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
		
	

}
