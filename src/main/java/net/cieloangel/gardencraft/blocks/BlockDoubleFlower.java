package net.cieloangel.gardencraft.blocks;

import javax.annotation.Nonnull;

import net.minecraft.block.BlockDoublePlant;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockDoubleFlower extends BlockDoublePlant {
	
	@Override
	public boolean canHarvestBlock (IBlockAccess world, @Nonnull BlockPos pos, @Nonnull EntityPlayer player) {
		return true;
	}

}
