package objects.equipables.tools;

import org.newdawn.slick.Image;

import objects.entities.Player;
import style.Images;

public class CarrotPack extends SeedPack {
	int row = 999;
	int col = 999;
	public CarrotPack(Player p) {
		super(p);
		// TODO Auto-generated constructor stub
	}
	
	public int getNum() {
		// For HUD / Game tool determination
		return 10;
	}
	public int getQuantity() {
		return Player.carrotSeeds;
	}
	
	public void wipe() 
	{
		col = 999;
		row = 999;
	}
	public Image getImage() 
	{
		return Images.carrotSeeds.getScaledCopy(32,32);
	}
	
	public int getSeedType() 
	{
		return 4;
	}
	
	public void plant(int seedCount,  int seedType, String terrainType, int col, int row) 
	 {
		
		 
		 
		 if(terrainType.equalsIgnoreCase("FarmLandTile") && seedCount > 0) 
			{
			
				this.col = col;
				this.row = row;
				this.seedType = seedType;
				System.out.println("Happens, SP class" + getColToBePlanted() + "R:" + getRowToBePlanted());
			}else 
			{
				row = 999;
				col = 999;
			}
	 }
	 
	
	 
	public int getRowToBePlanted() 
	{
		return row;
	}
		
	public int getColToBePlanted() 
	{
		return col;
	}


}
