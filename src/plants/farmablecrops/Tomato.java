package plants.farmablecrops;

import org.newdawn.slick.Graphics;

import core.Game;
import plants.Plant;
import style.Images;
import terrain.Tile;

public class Tomato extends Plant{

	int startingDay = 0;
	int activeDays = 0;
	double growthProgress = 0.00;
	public static double TOMATO_GROWTH_ON_DAY = 0.20;
	int row;
	int col;
	int x;
	int y;
	
	public Tomato(int row, int col, int time, Tile t) {
		super(row, col, time, t);
		startingDay = time;
		
	}
	
	public int getType() 
	{
		return 3;
	}
	
	public void render(Graphics g, int x , int y) 
	{
		
			if(growthProgress >= 0 && growthProgress < 0.40)
			{
				if(getTile().getMoisture()) 
				{
					g.drawImage(Images.seedsPlanted, x,y);
				}else 
				{
					g.drawImage(Images.drySeedsPlanted, x,y);
				}
			}
				
			else if(growthProgress >= 0.40 && growthProgress < 1.00)
			{
				if(getTile().getMoisture()) 
				{
					g.drawImage(Images.tomatoStage1, x, y);
				}else 
				{
					g.drawImage(Images.drytomatoinitial, x, y);
					
				}
			}
			
			else if( growthProgress == 1.00)
			{
				if(getTile().getMoisture()) 
				{
					g.drawImage(Images.tomatoStage2, x, y);
				}else 
				{
					g.drawImage(Images.drytomatofinal, x, y);
				}
			}
			
			//g.drawString("%: " + growthProgress, x, y);
		//	g.drawString("D: " + activeDays, x, y+ 20);
		//	
		
			
			
	}
	
	public void update(int newTime) 
	{
		if(Game.changedDayNight) // && canGrow() 
		{
			activeDays = Game.numDays - startingDay;
		}
		
		if(growthProgress < 1) 
			growthProgress = activeDays * TOMATO_GROWTH_ON_DAY;
		
		
	}
	
	public boolean canGrow() 
	{
		if(getTile().getMoisture() == true ) // && isDay() 
			return true;
		return false;
	}
	
	public boolean isHarvestable() 
	{
		if(growthProgress == 1)//&& getTile().getMoisture() == true
			return true;
		return false;
	}
	
	
	
	
	
	public int getX() 
	{
		return col * Game.tileSize;
	}
	
	public int getY() 
	{
		return row * Game.tileSize;
	}
	
	public void update() 
	{
		
	}
	
}
