package core;

import java.util.ArrayList;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import objects.entities.Player;
import objects.entities.animals.Animal;
import objects.equipables.items.Items;
import objects.equipables.items.SprinklerItem;
import objects.equipables.tools.CornPack;
import objects.equipables.tools.GardeningHoe;
import objects.equipables.tools.Pickaxe;
import objects.equipables.tools.Scythe;
import objects.equipables.tools.SeedPack;
import objects.equipables.tools.WateringCan;
import plants.Plant;
import terrain.Tile;
import terrain.tiles.FarmLandTile;
import style.Images;

public class Game extends BasicGameState 
{	
	private int id;
	public static int tileSize = 64;
	public static int maxScreenCol = 1920 / tileSize;
	public static int maxScreenRow = 1080 / tileSize;
	public static int maxWorldCol = maxScreenRow * 3; // was maxScreenCol * 3
	public static int maxWorldRow = maxScreenRow * 3;
	public static int worldWidth = tileSize * maxWorldCol;
	public static int worldHeight = tileSize * maxWorldRow;
	public static int cornMaxGrowthTime = 300;
	public static int carrotMaxGrowthTime = 500;
	public static int tomatoMaxGrowthTime = 700;
	public static int blueBerryMaxGrowthTime = 1100;
	boolean sleepConditionCheck;
	private StateBasedGame sbg;
	int lastC = 999;
	int lastR = 999;
	boolean b;
	int nowC;
	int nowR;
	int count = 0;
	int cooldownTimer = 0;
	int col =  999 ;
	int altTimer = 20;
	int row =999 ;
	public static boolean playerPassedOut = false;
	
	
	public static int cornSold = 0;
	public static int tomatoSold = 0;
	public static int blueberrySold = 0;
	public static int carrotSold = 0;
	public static int woolSold = 0;
	public static int milkSold = 0;
	public static int eggsSold = 0;
	public static int copperSold = 0;
	
	//Brady Night Cycle
	public static int timer = 10000 - 2500; // start at 6am
	int opacity = 80;
	int opacity2 = 110;
	int darknessVal = 50;
	public static boolean isDay = true;
	boolean isNight = false;
	public static int numDays = 1;
	public static boolean changedDayNight = false;
	String tileTypeMouseOn = "";
	
	Animal a;
	Player p = new Player();
	public static WorldManager worldManager = new WorldManager();
	boolean sleepCondition = false;

	public Game(int id) 
	{
		this.id = id;
	}
	
	public int getID() 
	{
		return id;		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException 
	{
		gc.setShowFPS(true);
		worldManager.firstTimeSetup();
		Images.loadImages();
		this.sbg=sbg;
	}

	
	
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{	
		
		
		
		worldUpdate(gc);
		playerUpdate(gc);
		toolUpdate(gc);
		dayNightCycleUpdate(gc);
	}
	
	public void dayNightCycleUpdate(GameContainer gc) 
	{
		
		Input input = gc.getInput();
		//if(input.isKeyPressed(Input.KEY_F))
			
		if(timer > 0)
			timer --;
		
		if(timer > 2800) 
		{
			changedDayNight = false;
			isDay = true;
			isNight = false;
		}
			
		
		if(timer <= 2800 && timer > 0)
		{	
			isNight = true;
			isDay = false;
		}
		
		if(timer > 0 && timer < 2800/2 && p.getEnergy() <= 0 || sleepConditionCheck == true)
			sleepCondition = true;
		
		if(timer == 0 || sleepCondition)
		{
			sbg.enterState(Main.RECAP_ID);
			sleepConditionCheck = false;
			sleepCondition = false;
			isNight = false;
			isDay = true;
			opacity = 80;
			numDays ++;
			changedDayNight = true;
			playerPassedOut = false;
			timer = 10000;
			Player.coffee=0;
			
		}
		
		
		
		if(timer % 20 == 0 && opacity > 0 && isDay)
			{
				opacity = opacity - 1;
			}
			if(timer % 10000 == 0)
			{
				opacity2 = 110;
			}
			if(timer % 20 == 0 && opacity2 < 210 && isNight)
			{
				opacity2++;
			}
		
		
		
		
		
		
			
		
		
//		
//		if((isNight && p.getEnergy() == 0))
//			playerPassedOut = true;
//			
//		if(tileTypeMouseOn.equalsIgnoreCase("HouseTile") && input.isKeyPressed(Input.KEY_F))
//		{
//			
//			sleepCondition = true;
//		}
//		
//		if(changedDayNight)
//			worldManager.moistureReset();
//		
//		
//		if(isDay)
//		{
//			timer++;
//			changedDayNight = false;
//		}
//		else if(isNight)
//		{
//			timer--;
//		}
//		if(timer % 20 == 0 && opacity > 0 && isDay)
//		{
//			opacity = opacity - 1;
//		}
//		if(timer % 2400 == 0)
//		{
//			isNight = true;
//			isDay = false;
//			opacity2 = 110;
//		}
//		if(timer % 20 == 0 && opacity2 < 210 && isNight)
//		{
//			opacity2++;
//		}
//		if(playerPassedOut|| sleepCondition == true)
//		{
//			sleepCondition = false;
//			
//			//if(sleepCOndition) -> Day Change animation / state -> Profit State
//			
//			isNight = false;
//			isDay = true;
//			opacity = 80;
//			numDays ++;
//			changedDayNight = true;
//			playerPassedOut = false;
//			cornSold = 0;
//			tomatoSold = 0;
//			blueberrySold = 0;
//			carrotSold = 0;
//			woolSold = 0;
//			milkSold = 0;
//			eggsSold = 0;
//			
//		}
	}
	
	public static void trigger() 
	{
		worldManager.moistureReset();
	}
	
	
	public void worldUpdate(GameContainer gc) throws SlickException 
	{
		worldManager.update(gc);
		worldManager.setPlayersTile(p.getPlayersRow(), p.getPlayersCol(), p.getAnimOffset(), p.getDirectionOrientation());
	}
	
	public void playerUpdate(GameContainer gc) throws SlickException 
	{	
		Input input = gc.getInput();
		p.update(gc);
		
		if(!(p.getMouseCol()<0) && !(p.getMouseRow() < 0))
		tileTypeMouseOn = worldManager.getTileType(p.getMouseCol(), p.getMouseRow());
		
		if(tileTypeMouseOn.equalsIgnoreCase("MarketTile") && input.isKeyPressed(Input.KEY_F))
			sbg.enterState(Main.MARKET_ID);
		
		String above = worldManager.getTileType(p.getTileAboveCol(), p.getTileAboveRow());
		String below = worldManager.getTileType(p.getTileBelowCol(),p.getTileBelowRow());
		String rightOf = worldManager.getTileType(p.getTileRightOfCol(),p.getTileRightOfRow());
		String leftOf = worldManager.getTileType(p.getTileLeftOfCol(),p.getTileRightOfRow());
		p.setTileType(above, below, rightOf, leftOf);
		p.setTileArray(worldManager.getTileArray());
		
		p.newDay(changedDayNight);	
//		if(changedDayNight)
//			sbg.enterState(3);
	}
	
	public void toolUpdate(GameContainer gc) 
	{
		GardeningHoe h = p.getHoe();
		Scythe s = p.getScythe();
		Pickaxe pick = p.getPickaxe();
		SeedPack sP = null;
		WateringCan wC = p.getWateringCan();
//		int col =  999 ;
//		int row =999 ;
		
		
		if(cooldownTimer > 0) 
		{
			cooldownTimer --;
		}
		
		if(p.getLastHUDNum() == 13) // Sprinkler
		{
			Items sI = p.getSprinklerItem();
			
			col = ((SprinklerItem) sI).getCol();
			row = ((SprinklerItem) sI).getRow();
			
			if(!(col == lastC && row == lastR) && !(row == 999 && col == 999)) 
			{
				int oldCol = col;
				int oldRow = row;
				((SprinklerItem) sI).wipe();
				
				//if(worldManager.getPlant(row, col) != null && worldManager.getPlant(row, col).isHarvestable()) 
				{
					
					
					worldManager.placeSprinkler(col,row); 
					p.sprinklers --;
					
				}
			}
			
			lastC = col;
			lastR = row;
	
		}
		
		if(p.getLastHUDNum() == 1) // Hoe
		{
			col = h.getColToBeEdited();
			row = h.getRowToBeEdited();
			if(col != 999 && row != 999) 
				worldManager.tillTile(col,row);  h.wipe();
		}
		
		if(p.getLastHUDNum() == 3) // Scythe
		{
			col = s.getXForHarvest();
			row = s.getYForHarvest();
			
			if(!(col == lastC && row == lastR)) 
			{
				int oldCol = col;
				int oldRow = row;
				s.wipe();
				
				if(worldManager.getPlant(row, col) != null && worldManager.getPlant(row, col).isHarvestable()) 
				{
					
					p.incrementCrop(worldManager.getCropType(row,col));
					worldManager.harvestPlant(row, col); 
					
				}
			}
			
			lastC = col;
			lastR = row;
	
		}
		
		if(p.getLastHUDNum() == 4) // Pickaxe
		{
			col = pick.getXForMining();
			row = pick.getYForMining();
			worldManager.mine(row,col); pick.wipe();
		}
		
		if(p.getLastHUDNum() == 5) // WateringCan
		{
			
			col = wC.getXForWatering();
			row = wC.getYForWatering();
			
			
			if(col != 999 && row!= 999 && worldManager.getTile(row, col).getMoisture() == false) 
			{

				
				if(cooldownTimer == 0) //p.getMouseCol() == col && p.getMouseRow() == row 
				{
					worldManager.addMoisture(row,col); wC.wipe();
					cooldownTimer = 20;
					
				}
					
			
			}
		}	
		
		if(p.getLastHUDNum() == 2 ||p.getLastHUDNum() == 12 || p.getLastHUDNum() == 11 ||p.getLastHUDNum() == 10) // SeedBag
		{
			
			if(p.getLastHUDNum() == 2)
				sP = p.getCornPack(); 
			if(p.getLastHUDNum() == 10)
				sP = p.getCarrotPack();
			if(p.getLastHUDNum() == 11)
				sP = p.getTomatoPack();
			if(p.getLastHUDNum() == 12)
				sP = p.getBlueberryPack();	
			
			
			
			col =  sP.getColToBePlanted();
			row = sP.getRowToBePlanted();
			
		
			
			
			int seedType = sP.getSeedType();
			
			
			
			
			
			if(col != 999 && row != 999) 
			{
				
					
				nowC = col;
				nowR = row;
				
				// Fix Later
				boolean b = worldManager.getPlant(row, col) == null;
				System.out.println(b + ":Check");
				
				if(!(col == lastC && row == lastR)) 
			{
				
				
				if(worldManager.getPlant(row, col) == null) 
				{
					
					worldManager.plantCrop(col,row, seedType); sP.wipe();
					
					if(seedType == 1) // Corn
						p.incrementSeed(1);
					if(seedType == 2) // BlueBerry
						p.incrementSeed(2);
					if(seedType == 3) // Tomato
						p.incrementSeed(3);
					if(seedType ==4) // Carrot
						p.incrementSeed(4);
				}
					
				
				
//					worldManager.plantCrop(col,row);
					lastC = col;
					lastR = row;
				}	
			}
		}
		

		
		
	}
	

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException 
	{
		SeedPack s = p.getCornPack();
		int col = s.getColToBePlanted();
		int row = s.getRowToBePlanted();
		worldManager.render(g);
		p.render(g);
		dayNightRender(g);
	}
	
	public void dayNightRender(Graphics g) 
	{
		if(isDay)
		{
			g.setColor(new Color(255, 220, 0, opacity));
			g.fillRect(0, 0, 1920, 1080);
		}
		if(isNight)
		{
			g.setColor(new Color(darknessVal, darknessVal, darknessVal, opacity2));
			g.fillRect(0, 0, 1920, 1080);
		}
	}
	
	public boolean isDay() 
	{
		return isDay;
	}
	
	public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException 
	{
		
	}

	public void leave(GameContainer gc, StateBasedGame sbg) 
	{
		
	}

	public void keyPressed(int key, char c)
	{
		
	}
	
	public void mousePressed(int button, int x, int y)
	{
		
		// Not Public
		
		
		if(p.getMousePosition().equalsIgnoreCase("down") && worldManager.getTileType(p.getTileBelowCol(),p.getTileBelowRow()).equalsIgnoreCase("HouseTile"))
		{
			sleepConditionCheck = true;
//			sbg.enterState(Main.RECAP_ID);
		}
		if(p.getMousePosition().equalsIgnoreCase("up") && worldManager.getTileType(p.getTileAboveCol(), p.getTileAboveRow()).equalsIgnoreCase("HouseTile"))
		{
			sleepConditionCheck = true;
			//sbg.enterState(Main.RECAP_ID);
		}
		if(p.getMousePosition().equalsIgnoreCase("left") && worldManager.getTileType(p.getTileLeftOfCol(),p.getTileRightOfRow()).equalsIgnoreCase("HouseTile"))
		{
			sleepConditionCheck = true;
			//sbg.enterState(Main.RECAP_ID);
		}
		if(p.getMousePosition().equalsIgnoreCase("right") && worldManager.getTileType(p.getTileRightOfCol(),p.getTileRightOfRow()).equalsIgnoreCase("HouseTile"))
		{
			sleepConditionCheck = true;
			//sbg.enterState(Main.RECAP_ID);
		}
		if(p.getMousePosition().equalsIgnoreCase("down") && worldManager.getTileType(p.getTileBelowCol(),p.getTileBelowRow()).equalsIgnoreCase("MarketTile"))
		{
			sbg.enterState(Main.MARKET_ID);
		}
		if(p.getMousePosition().equalsIgnoreCase("up") && worldManager.getTileType(p.getTileAboveCol(), p.getTileAboveRow()).equalsIgnoreCase("MarketTile"))
		{
			sbg.enterState(Main.MARKET_ID);
		}
		if(p.getMousePosition().equalsIgnoreCase("left") && worldManager.getTileType(p.getTileLeftOfCol(),p.getTileRightOfRow()).equalsIgnoreCase("MarketTile"))
		{
			sbg.enterState(Main.MARKET_ID);
		}
		if(p.getMousePosition().equalsIgnoreCase("right") && worldManager.getTileType(p.getTileRightOfCol(),p.getTileRightOfRow()).equalsIgnoreCase("MarketTile"))
		{
			sbg.enterState(Main.MARKET_ID);
		}


	}
	
	


}
