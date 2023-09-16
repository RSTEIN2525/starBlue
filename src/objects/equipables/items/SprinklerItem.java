package objects.equipables.items;

import org.newdawn.slick.Image;

import objects.entities.Player;
import style.Images;

public class SprinklerItem extends Items{

	Player p;
	int row = 999;
	int col = 999;
	
	public SprinklerItem(Player p) 
	{
		this.p = p;
	}
	
	public int getQuantity() {
		return Player.sprinklers;
	}
	
	
	public Image getImage() 
	{
			return Images.sprinklerMarket.getScaledCopy(32,32);
	}
	
	public int getNum() {
		// For HUD / Game tool determination
		return 13;
	}
	
	public void wipe() 
	{
		col = 999;
		row = 999;
	}
	
	public void place(int col, int row, String type) 
	{
		
		if(type.equalsIgnoreCase("GrassTile") || type.equalsIgnoreCase("FarmlandTile")) 
		{
			this.col = col;
			this.row = row;
		}else 
		{
			row = 999;
			col = 999;
		}
	
	}
	
	public int getRow() 
	{
		return row;
	}
	
	public int getCol() 
	{
		return col;
	}
}
