package plants.farmablecrops;

import org.newdawn.slick.Graphics;

import core.Game;
import plants.Plant;
import style.Images;
import terrain.Tile;

public class Carrot extends Plant {

	int startingDay = 0;
	int activeDays = 0;
	double growthProgress = 0.01;
	public static double BlueBerry_GROWTH_ON_DAY = 0.34;
	int row;
	int col;
	int x;
	int y;
	boolean watered = false;
	
	public Carrot(int row, int col, int time, Tile t) {
		super(row, col, time, t);
		startingDay = time;
		
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
				g.drawImage(Images.carrotStage1, x, y);
			}else 
			{
				g.drawImage(Images.drycarrotinitial, x, y);
			}
		}
		else if(growthProgress >= 1.00)
		{
			if(getTile().getMoisture()) 
			{
				g.drawImage(Images.carrotStage2, x, y);
			}else 
			{
				g.drawImage(Images.drycarrotfinal, x, y);
			}
		}
		
		
		
		
		
		
			
		
			
			
	}
	
	public void update(int newTime) 
	{
		
		if(getTile().getMoisture())
			watered = true;
		

		if(getTile().getMoisture() == true) 
		{
			System.out.println("HALJsflkJSDLKFj;lkasjdflkajsdf");
			if(Game.changedDayNight) // && canGrow() 
			{
				activeDays = Game.numDays - startingDay;
			}
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
	
	
	public int getType() 
	{
		return 4;
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
