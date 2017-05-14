package net.cieloangel.gardencraft;

public class Reference {
	
	public static final String MOD_ID = "gardencraft";
	public static final String NAME = "GardenCraft";
	public static final String VERSION = "1.10.2-1.0";
	public static final String ACCEPTED_MC_VERSIONS = "[1.10.2]";
	
	public static final String CLIENT_PROXY_CLASS = "net.cieloangel.gardencraft.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "net.cieloangel.gardencraft.proxy.ServerProxy";
	
	public static enum GardenCraftItems {
		IRIS("iris", "ItemIris"),
		HYDRANGEA("hydrangea", "ItemHydrangea");
		
		private String unlocalizedName;
		private String registryName;
		
		GardenCraftItems(String unlocalizedName, String registryName) {
			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;
		}
		
		public String getUnlocalizedName() {
			return unlocalizedName;
		}
		
		public String getRegistryName() {
			return registryName;
		}
	}
	
	public static enum GardenCraftBlocks {
		IRIS("iris", "BlockIris"),
		HYDRANGEA("hydrangea", "BlockHydrangea");
		
		private String unlocalizedName;
		private String registryName;
		
		GardenCraftBlocks(String unlocalizedName, String registryName) {
			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;
		}
		
		public String getUnlocalizedName() {
			return unlocalizedName;
		}
		
		public String getRegistryName() {
			return registryName;
		}
	}
	
	public static enum GardenCraftTileEntities {
		VASE_FLUTED_H_CLAY("","");
		
		private String unlocalizedName;
		private String registryName;
		
		GardenCraftTileEntities(String unlocalizedName, String registryName) {
			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;
		}
		
		public String getUnlocalizedName() {
			return unlocalizedName;
		}
		
		public String getRegistryName() {
			return registryName;
		}
	}

}
