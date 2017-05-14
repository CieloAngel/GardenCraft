package net.cieloangel.gardencraft.init;

import net.cieloangel.gardencraft.blocks.BlockBase;
import net.cieloangel.gardencraft.blocks.BlockFlowerBase;
import net.cieloangel.gardencraft.blocks.BlockModFlower;
import net.cieloangel.gardencraft.blocks.BlockTileEntity;
import net.cieloangel.gardencraft.blocks.vases.BlockVase;
import net.cieloangel.gardencraft.items.ItemModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static BlockFlower iris;
	public static BlockFlower hydrangea;
	public static BlockFlower rose;
	public static BlockVase vaseFlutedClay;
	
	public static void init() {
		iris = register(new BlockModFlower("BlockIris"));
		hydrangea = register(new BlockModFlower("BlockHydrangea"));
		rose = register(new BlockModFlower("BlockRose"));
		vaseFlutedClay = register(new BlockVase("BlockVaseFlutedHClay"));
	}
	
	private static <T extends Block> T register(T block, ItemBlock itemBlock) {
		GameRegistry.register(block);
		
		if (itemBlock != null) {
			GameRegistry.register(itemBlock);
		
			if (block instanceof ItemModelProvider) {
				((ItemModelProvider)block).registerItemModel(itemBlock);
			}
		}
		
		if (block instanceof BlockTileEntity) {
			GameRegistry.registerTileEntity(((BlockTileEntity<?>)block).getTileEntityClass(), block.getRegistryName().toString());
		}
		
		return block;
	}
	
	private static <T extends Block> T register(T block) {
		ItemBlock itemBlock = new ItemBlock(block);
		itemBlock.setRegistryName(block.getRegistryName());
		return register(block, itemBlock);
	}

}
