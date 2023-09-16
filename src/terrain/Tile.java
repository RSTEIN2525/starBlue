package terrain;

import org.newdawn.slick.Graphics;

import plants.Plant;
import core.Game;
import core.WorldManager;

public class Tile extends WorldManager
{
	protected int x;
	protected int y;
	Plant p;
	protected boolean moisture;
	int x1; int y1; int x2; int y2; int x3; int y3; int x4; int y4;
	
	public Tile(int x, int y, boolean moisture)
	{
		this.x = x;
		this.y = y;
		this.moisture = moisture;
	}
	
	public Tile(int x, int y, Tile t1, Tile t2, Tile t3, Tile t4) 
	{
		this.x = x;
		this.y = y;
	}
	
	public Tile(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) 
	{
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
		this.x4 = x4;
		this.y4 = y4;
	}
	
	public int getX1() 
	{
		return x1;
	}
	public int getX2() 
	{
		return x2;
	}
	public int getX3() 
	{
		return x3;
	}
	public int getX4() 
	{
		return x4;
	}
	
	public int getY1() 
	{
		return y1;
	}
	public int getY2() 
	{
		return y2;
	}
	public int getY3() 
	{
		return y3;
	}
	public int getY4() 
	{
		return y4;
	}
	
	
	
	
	public int getX() 
	{
		return x;
	}
	
	public Tile getTile(int row, int col) 
	{
		return getTile(row,col);
	}
	
	public int getY() 
	{
		return y;
	}
	
	public boolean getMoisture() 
	{
		return moisture;
	}
	
	public void incrementMoisture(boolean n) 
	{
		moisture = n;
	}
	
	public String tileType() 
	{
		return "Default Class";
	}
	
	public void setPlant(Plant p) 
	{
		this.p = p; 
	}
	
	public Plant getPlant() 
	{
		return p;
	}
	
	
	public void render(Graphics g, int screenX, int screenY) 
	{
		g.drawRect(screenX, screenY, Game.tileSize, Game.tileSize);
	}
	
	public void update() 
	{
		
	}
}
