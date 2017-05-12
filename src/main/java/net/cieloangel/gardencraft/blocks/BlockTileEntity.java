package net.cieloangel.gardencraft.blocks;

import javax.annotation.Nullable;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockTileEntity <TE extends TileEntity> extends BlockBase {
	
	public BlockTileEntity(Material material, String name) {
		super(material, name);
	}
	
	// Return the class the tile entity is in so it can be automatically registered when the block is registered
	public abstract Class<TE> getTileEntityClass();
	
	public TE getTileEntity(IBlockAccess world, BlockPos pos) {
		return (TE)world.getTileEntity(pos);
	}
	
	@Override
	// Tell MC the block gas a tile entity associated with it that need to be created
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}
	
	@Nullable
	@Override
	// A more specific version of the same method from the Block class which is called whenever a new instance of the tile entity
	public abstract TE createTileEntity(World world, IBlockState state);

}
