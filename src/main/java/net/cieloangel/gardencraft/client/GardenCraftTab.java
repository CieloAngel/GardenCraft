package net.cieloangel.gardencraft.client;

import net.cieloangel.gardencraft.Reference;
import net.cieloangel.gardencraft.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GardenCraftTab extends CreativeTabs {
	
	public GardenCraftTab() {
		super(Reference.MOD_ID);
		setBackgroundImageName("item_search.png");
	}
	
	@Override
	public Item getTabIconItem() {
		return ModItems.iris;
	}
	
	@Override
	public boolean hasSearchBar() {
		return true;
	}

}
