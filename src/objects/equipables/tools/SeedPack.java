package objects.equipables.tools;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import objects.entities.Player;
import style.Images;
import terrain.Tile;
import terrain.tiles.FarmLandTile;

public class SeedPack extends Tool 
{
	
	int seedType;
	int row = 999;
	int col = 999;
	Tile[][] t;
	Player p;
	
	public SeedPack(Player p) 
	{
		this.p = p;
	}
	
	
	
	
	public void mouseDraw(Graphics g) 
	{
		g.fillRect(Mouse.getX(), Mouse.getY(), 20, 20);
	}
	
	public int getNum() {
		// For HUD / Game tool determination
		return 2;
	}
	
	public Image getImage() 
	{
		return Images.corn;
	}
	
//	public String getString() 
//	{
//		return "Seed";
//	}
	
	public void update() 
	{
		
	}
	
	public void draw() 
	{
		
	}
	
	public void wipe() 
	{
		col = 999;
		row = 999;
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
	 
	 
	public int getSeedType() 
	{
		return seedType;
	}
	 
	public int getRowToBePlanted() 
	{
		return row;
	}
		
	public int getColToBePlanted() 
	{
		return col;
	}
	
//	public int getPreLoopPlant() 
//	{
//		
//	}
}
