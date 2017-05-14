package net.cieloangel.gardencraft.blocks;

import net.minecraft.block.Block;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockModFlower extends BlockFlowerBase {
	
	private String name;
	
	public BlockModFlower(String name) {
		super(name);
	}

	@Override
	@SideOnly(Side.CLIENT)
	// How to position the flowers when placed. Randomly moves them around the block and up and down in height
	public Block.EnumOffsetType getOffsetType() {
		return Block.EnumOffsetType.XYZ;
	}
	
}
