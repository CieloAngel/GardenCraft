package net.cieloangel.gardencraft.blocks.vases;

import net.cieloangel.gardencraft.Reference;
import net.cieloangel.gardencraft.init.ModBlocks;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiVase extends GuiContainer {
	
	private InventoryPlayer playerInv;
	private static final ResourceLocation BG_TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures,gui/vase.png");
	
	// Constructor
	// Pass the container to the super-constructor so that GuiContainer can render the slots and handle interaction with them
	public GuiVase (Container container, InventoryPlayer playerInv) {
		super(container);
		this.playerInv = playerInv;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		// reset GL color to solid white
		GlStateManager.color(1, 1, 1, 1);
		// Bind the background texture specified in BG_TEXTURE to MC's rendering engine, so when a rectangle with a texture is rendered, the correct texture is used
		mc.getTextureManager().bindTexture(BG_TEXTURE);
		// Calculate the X and Y positions to draw the texture at in the center of the screen
		// Takes half the width and height of the screen and subtracts half the x and y size of the gui.
		// Gives the position of the upper left hand corner of the GUI
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		// Draw the rectangle at the X and Y positions and starts the rendering at (0,0) of the UV position with the overall size of the rectangle
		drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String name = I18n.format(ModBlocks.vaseFlutedClay.getUnlocalizedName() + ".name");
		fontRendererObj.drawString(name, xSize / 2 - fontRendererObj.getStringWidth(name) / 2, 6, 0x404040);
		fontRendererObj.drawString(playerInv.getDisplayName().getUnformattedText(), 8, ySize - 94, 0x404040);
	}
	
}
