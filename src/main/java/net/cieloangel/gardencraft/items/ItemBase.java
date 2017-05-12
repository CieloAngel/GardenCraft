package net.cieloangel.gardencraft.items;

import net.cieloangel.gardencraft.GardenCraft;
import net.cieloangel.gardencraft.client.GardenCraftTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements ItemModelProvider {
	
	protected String name;
	
	public ItemBase(String name) {
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(GardenCraft.CREATIVE_TAB);
	}
	
	@Override
	public void registerItemModel(Item item) {
		GardenCraft.proxy.registerItemRenderer(this, 0, name);
	}
	
	@Override
	public ItemBase setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}

}
