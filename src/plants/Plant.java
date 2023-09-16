package plants;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import terrain.Tile;
import core.Game;
import core.WorldManager;

public class Plant extends WorldManager{
	
	int x;
	int y;
	int time;
	Tile t;
	
	public Plant(int x, int y, int time, Tile t) 
	{
		this.x = x;
		this.y = y;
		this.time = time;
		this.t = t;
	}
	
	public void setTile(Tile t) 
	{
		t.setPlant(this);
	}
	
	public boolean isDay() 
	{
		return Game.isDay;
	}
	
	public int getGrowthStartingTime() 
	{
		return time;
	}
	
	public Tile getTile() 
	{
		return t;
	}
	
	public int getType() 
	{
		return 0;
	}

	public void render(Graphics g, int x , int y) 
	{
		
	}
	
	public void update(int timer) 
	{
		
	}
	
	public void plant(int x, int y, String s) {}
	public int getPlantingX() {return Integer.MAX_VALUE;};
	public int getPlantingY() {return Integer.MAX_VALUE;};
	
	public int getX() 
	{
		return x;
	}
	public int getY() 
	{
		return y;
	}

	public boolean isHarvestable() {
		// TODO Auto-generated method stub
		return false;
	}
}
