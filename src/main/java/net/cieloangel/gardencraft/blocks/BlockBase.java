package net.cieloangel.gardencraft.blocks;

import net.cieloangel.gardencraft.GardenCraft;
import net.cieloangel.gardencraft.items.ItemModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockBase extends Block implements ItemModelProvider {
	protected String name;
	
	public BlockBase(Material material, String name) {
		super(material);
		
		this.name = name;
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(GardenCraft.CREATIVE_TAB);
	}
	
	@Override
	public void registerItemModel(Item itemBlock) {
		GardenCraft.proxy.registerItemRenderer(itemBlock, 0, name);
	}
	
	@Override
	public BlockBase setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}

	public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos) {
		return false;
	}

}
