package objects.equipables.tools;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

import objects.entities.Player;
import style.Images;

public class WateringCan extends Tool
{
	Player p;
	int col = 0;
	int row = 0;
	
	
	public WateringCan(Player p) 
	{
		this.p = p;
	}
	
	public Image getImage() 
	{
		return Images.wateringcan.getScaledCopy(32,32);
	}
	
	public int getQuantity() {
		return 1;
	}
	
	public String getString() 
	{
		return "Water";
	}
	
	public int getNum() {
		// For HUD / Game tool determination
		return 5;
	}
	
	
	public void mouseDraw(Graphics g) 
	{
		g.fillRect(Mouse.getX(), Mouse.getY(), 20, 20);
	}
	
	public void water(GameContainer gc, int row, int col, String terrainType) 
	{
		if( !(row + col == 0) && terrainType.equalsIgnoreCase("FarmLandTile") ) // && terrainType.equalsIgnoreCase("FarmLandTile")
		{
			this.col = col;
			this.row = row;
			
		}else 
		{
			row = 999;
			col = 999;
		}
	}
	
	public void wipe() 
	{
		col = 999;
		row = 999;
	}
	
	
	public int getXForWatering() 
	{
		return col;
	}
	
	public int getYForWatering() 
	{
		return row;
	}
}
