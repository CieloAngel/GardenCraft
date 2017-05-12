package net.cieloangel.gardencraft.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
	
	public static void init() {
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.vaseFlutedClay), "C C", "C C", " C ", 'C', Items.CLAY_BALL);
	}

}
