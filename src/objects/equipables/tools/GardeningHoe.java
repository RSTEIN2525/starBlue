package objects.equipables.tools;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import core.Game;
import objects.entities.Player;
import style.Images;
import terrain.Tile;
import terrain.tiles.GrassTile;

public class GardeningHoe extends Tool
{
	Player p;
	int col = 999;
	int row = 999;
	
	public GardeningHoe(Player p) 
	{
		this.p = p;
	}
	
//	public String getString() 
//	{
//		return "Hoe";
//	}
	
	public int getNum() {
		// For HUD / Game tool determination
		return 1;
	}
	
	public int getQuantity() {
		return 1;
	}
	
	public void mouseDraw(Graphics g) 
	{
		g.fillRect(Mouse.getX(), Mouse.getY(), 20, 20);
	}
	
	public void update() 
	{

	}
	
	public Image getImage() 
	{
		return Images.hoeicon;
	}
	
	public void render(Graphics g) 
	{
		g.setColor(Color.yellow);
	}
	
	public void till(int col, int row, String type) 
	{
		
		if(type.equalsIgnoreCase("GrassTile")) 
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
	
	public int getRowToBeEdited() 
	{
		return row;
	}
	
	public int getColToBeEdited() 
	{
		return col;
	}
}
