package net.cieloangel.gardencraft;

import net.cieloangel.gardencraft.blocks.vases.ContainerVase;
import net.cieloangel.gardencraft.blocks.vases.GuiVase;
import net.cieloangel.gardencraft.blocks.vases.TileEntityVase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ModGuiHandler implements IGuiHandler {
	
	public static final int VASE = 0;
	
	// Return the appropriate instance (or null if there is none) for the given ID, player, world, and position
	@Override
	public Container getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case VASE:
			return new ContainerVase(player.inventory, (TileEntityVase)world.getTileEntity(new BlockPos(x, y, z)));
		default:
			return null;
		}
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case VASE:
				return new GuiVase(getServerGuiElement(ID, player, world, x, y, z), player.inventory);
			default:
				return null;
		}
	}

}
