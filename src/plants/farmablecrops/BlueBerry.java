package plants.farmablecrops;

import org.newdawn.slick.Graphics;

import core.Game;
import plants.Plant;
import style.Images;
import terrain.Tile;

public class BlueBerry extends Plant {

	int startingDay = 0;
	int activeDays = 0;
	double growthProgress = 0.01;
	public static double BlueBerry_GROWTH_ON_DAY = 0.34;
	int row;
	int col;
	int x;
	int y;
	
	public BlueBerry(int row, int col, int time, Tile t) {
		super(row, col, time, t);
		startingDay = time;
		
	}
	public int getType() 
	{
		return 2;
	}
	public void render(Graphics g, int x , int y) 
	{
		
			if(growthProgress >= 0.00 && growthProgress < 0.50)
			{
				if(getTile().getMoisture()) 
				{
					g.drawImage(Images.seedsPlanted, x,y);
				}else 
				{
					g.drawImage(Images.drySeedsPlanted, x,y);
				}
			}	
			else if(growthProgress >= 0.50 && growthProgress < 1.00)
			{
				if(getTile().getMoisture()) 
				{
					g.drawImage(Images.blueBerryStage1, x, y);
				}else 
				{
					g.drawImage(Images.dryblueberryinitial, x, y);
				}
			}
			else if(growthProgress >= 1.00)
			{
				if(getTile().getMoisture()) 
				{
					g.drawImage(Images.blueBerryStage2, x, y);
				}else 
				{
					g.drawImage(Images.dryblueberryfinal, x, y);
				}
			}
			
		//	g.drawString("%: " + growthProgress, x, y);
		//	g.drawString("D: " + activeDays, x, y+ 20);
			
	}
	
	public void update(int newTime) 
	{

		if(Game.changedDayNight) // && canGrow() 
		{
			activeDays = Game.numDays - startingDay;
		}
		
		if(growthProgress < 1) 
			growthProgress = activeDays * BlueBerry_GROWTH_ON_DAY;
		
		
	}
	
	public boolean canGrow() 
	{
		if(getTile().getMoisture() == true)
			return true;
		return false;
	}
	
	public boolean isHarvestable() 
	{
		if(growthProgress >= 1)//&& getTile().getMoisture() == true
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
