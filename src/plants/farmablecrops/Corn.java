package plants.farmablecrops;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import plants.Plant;
import terrain.Tile;
import core.Game;
import style.Images;

public class Corn extends Plant{

	int startingDay = 0;
	int activeDays = 0;
	double growthProgress = 0.00;
	public static double CORN_GROWTH_ON_DAY = 0.50;
	public static boolean first;
	int row;
	int col;
	int x;
	int y;
	private int daysWithoutWater = 0;
	
	public Corn(int row, int col, int time, Tile t) {
		super(row, col, time, t);
		startingDay = time;
		
	}
	
	public void render(Graphics g, int x , int y) 
	{
		//if(canGrow()) 
	//	{
		
			
		
		
			if(growthProgress == 0)
			{
				if(getTile().getMoisture()) 
				{
					g.drawImage(Images.seedsPlanted, x,y);
				}else 
				{
					g.drawImage(Images.drySeedsPlanted, x,y);
				}
			}
				
			else if(growthProgress > 0 && growthProgress <= 0.50)
			{
				if(getTile().getMoisture()) 
				{
					g.drawImage(Images.growingCorn, x, y);
				}else 
				{
					g.drawImage(Images.drycorninitial, x, y);
				}
			}
			
			else if(growthProgress > 0.50 && growthProgress <= 1.00)
			{
				if(getTile().getMoisture()) 
				{
					g.drawImage(Images.grownCorn, x, y);
				}else 
				{
					g.drawImage(Images.drycornfinal, x, y);
				}
			}
			
			
			
			
			
			
			//g.drawString("%: " + growthProgress, x, y);
			//g.drawString("D: " + activeDays, x, y+ 20);
			
//		}else 
//		{
//			g.drawImage(Images.seedsPlanted, x,y);
//		}	
			
			
	}
	
	public void update(int newTime) 
	{
		
		if(Game.changedDayNight) 
		{
			if(getTile().getMoisture()) 
			{
				activeDays = Game.numDays - startingDay;
				
				if(growthProgress < 1) 
					growthProgress = activeDays * CORN_GROWTH_ON_DAY;
			}else 
			{
				startingDay ++;
			}
			System.out.println(startingDay + "C");
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
//			if(Game.changedDayNight && getTile().getMoisture() == true) // && canGrow() 
//			{
//				activeDays = Game.numDays - startingDay - daysWithoutWater ;
//				Game.trigger();
//				first  = true;
//				
//			}else if(first) 
//			{
//				daysWithoutWater ++;
//				first = false;
//			}
//		
//		
//		if(growthProgress < 1) 
//			growthProgress = activeDays * CORN_GROWTH_ON_DAY;
//		
		
	
		
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
	
	public int getType() 
	{
		return 1;
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
