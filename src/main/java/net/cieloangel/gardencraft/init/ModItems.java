package net.cieloangel.gardencraft.init;

import net.cieloangel.gardencraft.items.ItemBase;
import net.cieloangel.gardencraft.items.ItemModelProvider;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static ItemBase iris;
	public static ItemBase hydrangea;
	
	public static void init() {
		//iris = new ItemIris();
		//hydrangea = new ItemHydrangea();
		iris = register(new ItemBase("ItemIris"));
		hydrangea = register(new ItemBase("ItemHydrangea"));
	}
	
	private static <T extends Item> T register(T item) {
		GameRegistry.register(item);
		
		if (item instanceof ItemModelProvider) {
			((ItemModelProvider)item).registerItemModel(item);
		}
		
		return item;
	}
	
//	public static void register() {
//		GameRegistry.register(iris);
//		GameRegistry.register(hydrangea);
//		
//	}
//	
//	public static void registerRenders() {
//		registerRender(iris);
//		registerRender(hydrangea);
//	}
//	
//	private static void registerRender(Item item) {
//		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
//	}

}
