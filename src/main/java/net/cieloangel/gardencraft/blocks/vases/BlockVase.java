package net.cieloangel.gardencraft.blocks.vases;

import javax.annotation.Nullable;

import net.cieloangel.gardencraft.GardenCraft;
import net.cieloangel.gardencraft.ModGuiHandler;
import net.cieloangel.gardencraft.blocks.BlockBase;
import net.cieloangel.gardencraft.blocks.BlockTileEntity;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class BlockVase extends BlockTileEntity<TileEntityVase> {

	public BlockVase(String name) {
		super(Material.CLAY, name);
	}
	
	@Override
	public BlockVase setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}
	
	@Override
	public Class<TileEntityVase> getTileEntityClass() {
		return TileEntityVase.class;
	}
	
	@Nullable
	@Override
	public TileEntityVase createTileEntity(World world, IBlockState state) {
		return new TileEntityVase();
	}
	
	// Method for placing and retrieving item(s) from the vase
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			TileEntityVase tile = getTileEntity(world, pos);
			IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, side);
			
			// If the player is not sneaking:
			if (!player.isSneaking()) {
				
				// Remove item from vase if player's hand is empty
				if (heldItem == null) {
					player.setHeldItem(hand, itemHandler.extractItem(0, 64, false));
				}
				else {
					// If player's hand is not empty, try to insert item into the vase
					player.setHeldItem(hand, itemHandler.insertItem(0, heldItem, false));
				}
				// Tell MC to save the vase
				tile.markDirty();
			}
			// If the player is sneaking
			else {
				player.openGui(GardenCraft.instance, ModGuiHandler.VASE, world, pos.getX(), pos.getY(), pos.getZ());
			}
		}
		return true;
	}
	
	// Method that drops contents of the vase when broken
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		TileEntityVase tile = getTileEntity(world, pos);
		IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
		ItemStack stack = itemHandler.getStackInSlot(0);
		if (stack != null) {
			EntityItem item = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack);
			world.spawnEntityInWorld(item);
		}
		super.breakBlock(world, pos, state);
	}
	
//	@SideOnly(Side.CLIENT)
//	public BlockRenderLayer getBlockLayer() {
//		return BlockRenderLayer.CUTOUT;
//	}
	
	@Override
	public boolean isOpaqueCube(IBlockState iBlockState) {
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState iBlockState) {
		return false;
	}
	

}
