package net.cieloangel.gardencraft.proxy;

import net.cieloangel.gardencraft.Reference;
import net.cieloangel.gardencraft.init.ModBlocks;
import net.cieloangel.gardencraft.init.ModItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {
	
	public void init() {
	}
	
	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Reference.MOD_ID + ":" + id, "inventory"));
	}
	
	public String localize(String unlocalized, Object... args) {
		return I18n.format(unlocalized, args);
	}

}
