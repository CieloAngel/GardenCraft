package net.cieloangel.gardencraft.blocks;

import javax.annotation.Nonnull;

import net.cieloangel.gardencraft.GardenCraft;
import net.cieloangel.gardencraft.items.ItemModelProvider;
import net.cieloangel.gardencraft.lib.LibFlowers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockFlower.EnumFlowerColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFlowerBase extends BlockFlower implements ItemModelProvider {
	
protected String name;
	
	public BlockFlowerBase(String name) {
		super();
		this.name = name;
		
		setRegistryName(name);
		setUnlocalizedName(name);
		setSoundType(SoundType.PLANT);
		setHardness(0.0F);
	}
	
	@Override
	public void registerItemModel(Item itemFlower) {
		GardenCraft.proxy.registerItemRenderer(itemFlower, 0, name);
	}
	
	@Override
	public BlockFlowerBase setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}

	public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos) {
		return true;
	}
	
	@Nonnull
	@Override
	public BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, getTypeProperty(), LibFlowers.COLOR);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(LibFlowers.COLOR).getMetadata();
	}
	
	
	public IBlockState getActualState(@Nonnull IBlockState state, IBlockAccess world, BlockPos pos) {
		return state.withProperty(type, EnumFlowerType.POPPY);
	}

	@Override
	// Not the actual flower color
	public EnumFlowerColor getBlockType() {
		return EnumFlowerColor.RED;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	// How to position the flowers when placed. Randomly moves them around the block and up and down in height
	public Block.EnumOffsetType getOffsetType() {
		return Block.EnumOffsetType.XZ;
	}

}
