package objects.entities;

import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import objects.Objects;
import objects.entities.Entity;
import objects.entities.animals.EnergyBar;
import objects.equipables.items.BlueberryItem;
import objects.equipables.items.CarrotItem;
import objects.equipables.items.CopperItem;
import objects.equipables.items.CornItem;
import objects.equipables.items.EggItem;
import objects.equipables.items.Items;
import objects.equipables.items.MilkItem;
import objects.equipables.items.SprinklerItem;
import objects.equipables.items.TomatoItem;
import objects.equipables.items.WoolItem;
import objects.equipables.tools.BlueberryPack;
import objects.equipables.tools.CarrotPack;
import objects.equipables.tools.CornPack;
import objects.equipables.tools.GardeningHoe;
import objects.equipables.tools.Pickaxe;
import objects.equipables.tools.Scythe;
import objects.equipables.tools.SeedPack;
import objects.equipables.tools.TomatoPack;
import objects.equipables.tools.WateringCan;
import plants.Plant;
import terrain.Tile;
import terrain.tiles.BoulderTile;
import terrain.tiles.FarmLandTile;
import terrain.tiles.GrassTile;
import core.Game;
import core.WorldManager;
import style.Images;
import style.music.AudioManager;

public class Player extends Entity 
{
	int worldX;
	int worldY;
	String directionalOrientation;
	String mousePosition;
	int playerOffset = Game.tileSize / 4;
	public static int screenX;
	public static int screenY;
	int worldTileRowLocation = 0;
	int worldTileColLocation = 0;
	int screenTileRowLocation = 0;
	int screenTileColLocation = 0;
	int mouseTileColLocation = 0;
	int mouseTileRowLocation = 0;
	int mouseDrawX = 0;
	int mouseDrawY = 0;
	final int playerWidth = Game.tileSize / 2;
	final int playerHeight = Game.tileSize / 2;
	GardeningHoe hoe = new GardeningHoe(this);
	CornPack cornPack = new CornPack(this); //CornPack
	TomatoPack tomatoPack = new TomatoPack(this);
	BlueberryPack blueberryPack = new BlueberryPack(this);
	CarrotPack carrotPack = new CarrotPack(this);
	Scythe scythe = new Scythe(this);
	Pickaxe pickaxe = new Pickaxe(this);
	public static int walkingEnergy = 2;
	WateringCan wateringCan = new WateringCan(this);
	Items sprinkler = new SprinklerItem(this);
	Items copperOre = new CopperItem(this);
	public static boolean hasPick = false;
	String tileAboveOfType;
	String tileBehindOfType;
	String tileRightOfType;
	String tileLeftOfType;
	
	public static int cornSeeds = 20;
	public static int sprinklers = 0;
	public static int corn = 0;
	public static int tomatoSeeds = 0;
	public static int tomato = 0;
	public static int blueberrySeeds = 0;
	public static int blueBerry = 0;
	public static int carrotSeeds = 0;
	public static int carrot = 0;
	public static int coins = 0;

	public static int cows = 0; 
	public static int chickens = 0;
	public static int sheep = 0;
	
	public static int copper = 0;
	public static int milk = 0;
	public static int eggs = 0;
	public static int wool = 0;
	public static int shoes = 0;
	public static int coffee = 0;
	PlayerHUD HUD;
	Tile[][] t;
	public static int movementTimer = 0;
	public static int movementInterval = 20;
	float animOffset = 0;
	public static int energy = 300;
	Items cornItem = new CornItem(this);
	Items blueberryItem = new BlueberryItem(this);
	Items tomatoItem = new TomatoItem(this);
	Items carrotItem = new CarrotItem(this);
	Items woolItem = new WoolItem(this);
	Items eggItem = new EggItem(this);
	Items milkItem =new MilkItem(this);
	public static boolean unlockedCameraY = false;
	public static boolean unlockedCameraX = false;
	
	
	public Player()
	{
		worldX = 17 * Game.tileSize;
		worldY = 10 * Game.tileSize;
		screenX = (Game.maxScreenCol / 2) * Game.tileSize;
		screenY = (Game.maxScreenRow / 2) * Game.tileSize;
		HUD = new PlayerHUD(this);
		HUD.initialSetup();
	}
	
	public Items getSprinklerItem() 
	{
		return sprinkler;
	}
	
	public void render(Graphics g) // GOes in Player
	{
		
		
		
		
		animOffset = (float) (movementTimer * 0.05 * Game.tileSize)  ; //* Game.tileSize
		
	
		if(directionalOrientation != null) 
		{
			if(directionalOrientation.equalsIgnoreCase("Left"))
			{
				
				if(animOffset >= 0 && animOffset < 16)
					g.drawImage(Images.playerLeft, screenX, screenY);
				if(animOffset >= 16 && animOffset < 32)
					g.drawImage(Images.farmer2walking1, screenX, screenY);
				if(animOffset >= 32 && animOffset < 48)
					g.drawImage(Images.playerLeft, screenX, screenY);
				if(animOffset >= 48 && animOffset < 64)
					g.drawImage(Images.farmer2walking2, screenX, screenY);
				if(animOffset == 64)
					g.drawImage(Images.playerLeft, screenX, screenY);
			}
				
			if(directionalOrientation.equalsIgnoreCase("Right")) 
			{

				if(animOffset >= 0 && animOffset < 16)
					g.drawImage(Images.playerRight, screenX, screenY);
				if(animOffset >= 16 && animOffset < 32)
					g.drawImage(Images.farmer1walking1, screenX, screenY);
				if(animOffset >= 32 && animOffset < 48)
					g.drawImage(Images.playerRight, screenX, screenY);
				if(animOffset >= 48 && animOffset < 64)
					g.drawImage(Images.farmer1walking2, screenX, screenY);
				if(animOffset == 64)
					g.drawImage(Images.playerRight, screenX, screenY);
			}
			
			
			
				
			if(directionalOrientation.equalsIgnoreCase("Down")) 
			{
				if(animOffset >= 0 && animOffset < 16)
					g.drawImage(Images.playerDown, screenX, screenY);
				if(animOffset >= 16 && animOffset < 32)
					g.drawImage(Images.farmer4walking1, screenX, screenY);
				if(animOffset >= 32 && animOffset < 48)
					g.drawImage(Images.playerDown, screenX, screenY);
				if(animOffset >= 48 && animOffset < 64)
					g.drawImage(Images.farmer4walking2, screenX, screenY);
				if(animOffset == 64)
					g.drawImage(Images.playerDown, screenX, screenY);
			}
				
			if(directionalOrientation.equalsIgnoreCase("Up")) 
			{
				if(animOffset >= 0 && animOffset < 16)
					g.drawImage(Images.playerUp, screenX, screenY);
				if(animOffset >= 16 && animOffset < 32)
					g.drawImage(Images.farmer3walking1, screenX, screenY);
				if(animOffset >= 32 && animOffset < 48)
					g.drawImage(Images.playerUp, screenX, screenY);
				if(animOffset >= 48 && animOffset < 64)
					g.drawImage(Images.farmer3walking2, screenX, screenY);
				if(animOffset == 64)
					g.drawImage(Images.playerUp, screenX, screenY);
			}
			
				
		}else g.drawImage(Images.playerDown, screenX, screenY);

		MouseRender(g);
		//debug(g);
		
		if(energy == 0)
			g.drawImage(Images.sleepsignal, screenX + 16, screenY - 32);
		
		HUD.draw(g,corn, cornSeeds, tomato, tomatoSeeds, blueBerry, blueberrySeeds, carrot, carrotSeeds, coins);
		//HUD.render(g,coins, corn, cornSeeds);
	}
	


	public void newDay(boolean justChanged) 
	{
		if(justChanged) 
		{
			energy = (int) EnergyBar.MAX_ENERGY;
			
			//Later add Show Total $ Earned on the Day
		}
	}

	
	public float getAnimOffset() 
	{
		return animOffset / Game.tileSize;
	}
	
	public String getDirectionOrientation() 
	{
		return directionalOrientation;
	}
	
	public void debug(Graphics g) 
	{
//		g.setColor(Color.black);
//		g.drawString("Row: " + worldTileRowLocation + " Col: " + worldTileColLocation, screenX, screenY + 100);
//		g.drawString(getNonMovableDirections(), screenX, screenY + 60);
//		g.drawString("MPR: " + mouseTileRowLocation + "MPC: " + mouseTileColLocation, screenX, screenY + 80); 
	}
	
	public void update(GameContainer gc) throws SlickException 
	{
		
		
		playerMovement(gc);
		playerToolInteraction(gc, HUD.getLastNum());
		MouseUpdate(gc);
		hoe.update();
		HUD.update(gc);
		unlockCamera(gc);
		worldTileRowLocation = (worldY) / (Game.tileSize);
		worldTileColLocation = (worldX) / (Game.tileSize);
		screenTileRowLocation = (screenY) / (Game.tileSize);
		screenTileColLocation = (screenX) / (Game.tileSize);
		if(movementTimer<movementInterval)
			movementTimer++;
		
		
			
	}
	
	public void unlockCamera(GameContainer gc) 
	{
		int xCameraBound = 16;
		int yCameraBound = 9;
		double offset = (movementTimer * 0.05 );

		if(worldTileColLocation < xCameraBound || worldTileColLocation > Game.maxWorldCol - 1 - xCameraBound) 
		{
			if(directionalOrientation == "Left") 
			{
				screenX = worldX - (int) (offset * 64 - 64) ;
				if(worldX > 1920)
					screenX -= 2176 - 64 * 16;
			}
			
			if(directionalOrientation == "Right") 
			{
				screenX = worldX + (int) (offset * 64 - 64);
				if(worldX > 1920)
					screenX -= 2176 - 64 * 16;
			}

			unlockedCameraX = true;
		}else 
		{
			
			unlockedCameraX = false;
			screenX = (Game.maxScreenCol / 2) * Game.tileSize;
			
		}
		
		if(worldTileRowLocation < yCameraBound || worldTileRowLocation > Game.maxWorldRow - 1 - yCameraBound)
		{
			if(directionalOrientation == "Up") 
			{
				screenY =worldY - (int) (offset * 64 - 64) ;
				if(worldY > 1920) //
					screenY -= 2176 - 64 * 3; //
			}
			
			if(directionalOrientation == "Down") 
			{
				screenY = worldY + (int) (offset * 64 - 64);
				if(worldY > 1920) //
					screenY -= 2176 - 64 * 3; //
			}
			
			unlockedCameraY  = true;
		}else 
		{
			unlockedCameraY = false;
			screenY = (Game.maxScreenRow / 2) * Game.tileSize;
		}
		
		
	}
	
	/*--------------------------------------------------------- Mouse -----------------------------------------------------------------------------*/
	
		public void MouseUpdate(GameContainer gc) 
		{
			Input input = gc.getInput();
			
			if(input.getMouseX() < screenTileColLocation * Game.tileSize) 
			{
				mouseTileColLocation = worldTileColLocation - 1;
				mouseTileRowLocation = worldTileRowLocation;
				mouseDrawX = screenX - Game.tileSize;
				mouseDrawY = screenY;
				mousePosition = "Left";
			}
				
			if(input.getMouseX() > screenTileColLocation * Game.tileSize + Game.tileSize) 
			{
				mouseTileColLocation = worldTileColLocation + 1;
				mouseTileRowLocation = worldTileRowLocation;
				mouseDrawX = screenX + Game.tileSize ;
				mouseDrawY = screenY;
				mousePosition = "Right";
			}
			
			if(input.getMouseY() > screenTileRowLocation * Game.tileSize + Game.tileSize) 
			{
				mouseTileRowLocation = worldTileRowLocation + 1;
				mouseTileColLocation = worldTileColLocation;
				mouseDrawX = screenX;
				
				mouseDrawY =  screenY + Game.tileSize;
			
				mousePosition = "Down";
			}
				
			if(input.getMouseY() < screenTileRowLocation * Game.tileSize) 
			{
				mouseTileRowLocation = worldTileRowLocation - 1;
				mouseTileColLocation = worldTileColLocation;
				mouseDrawX = screenX;
				mouseDrawY =  screenY - Game.tileSize;
				mousePosition = "Up";
			}	
		}
		
		public void MouseRender(Graphics g) 
		{
			int width = 16;
			g.setColor(Color.white);
			g.fillOval(mouseDrawX + playerOffset * 2 - width/2 , mouseDrawY + playerOffset * 2 - width/2, width, width);
			g.setColor(Color.blue);
			
			
//			g.drawString("XLock: " + unlockedCameraX, 300, 300);
//			g.drawString("YLock: " + unlockedCameraY, 300, 320);
			
		}
		
	
	/*--------------------------------------------------------- Input -----------------------------------------------------------------------------*/		
	
	void playerMovement(GameContainer gc) 
	{
		Input input = gc.getInput();
		
		if(input.isKeyDown(Input.KEY_W) && movementTimer == movementInterval) 
		{
			int newY = worldY - Game.tileSize;
			if(!cannotMove(1) && !topBoundMet()) 
			{
				worldY = newY;
				directionalOrientation = "Up";
				movementTimer = 0;
				//energy-=walkingEnergy;
			}
		}
		
		if(input.isKeyDown(Input.KEY_S) && movementTimer == movementInterval) 
		{
			int newY = worldY + Game.tileSize;
			if(!cannotMove(2) && !bottomBoundMet()) 
			{
				worldY = newY;
				directionalOrientation = "Down";
				movementTimer = 0;
				//energy-=walkingEnergy;
			}
			
		} 
		
		if(input.isKeyDown(Input.KEY_A) && movementTimer == movementInterval) 
		{
			int newX = worldX - Game.tileSize;
			if(!cannotMove(3) && !leftBoundMet()) 
			{
				worldX = newX;
				directionalOrientation = "Left";
				movementTimer = 0;
				//energy-=walkingEnergy;
			}
			
		} 
		
		if(input.isKeyDown(Input.KEY_D) && movementTimer == movementInterval) 
		{
			int newX = worldX + Game.tileSize;
			if(!cannotMove(4) && !rightBoundMet()) 
			{
				worldX = newX;
				directionalOrientation = "Right";
				movementTimer = 0;
				//energy-=walkingEnergy;
			}
		}
	}
	
	public String getMousePosition() 
	{
		return mousePosition;
	}
	
	
	void playerToolInteraction(GameContainer gc, int equippedTool) throws SlickException 
	{
		Input input = gc.getInput();
		if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON) && getEnergy() > 0) 
		{
			
			
			
			
			if(equippedTool == 1) //Hoe
			{
				if(mousePosition.equalsIgnoreCase("Up")) 
				{
					hoe.till(mouseTileColLocation, mouseTileRowLocation, tileAboveOfType);
					AudioManager.playEffect(0);
				}
					
				if(mousePosition.equalsIgnoreCase("Down")) 
				{
					hoe.till(mouseTileColLocation, mouseTileRowLocation, tileBehindOfType);	
					AudioManager.playEffect(0);
				}
				if(mousePosition.equalsIgnoreCase("Right")) {
					hoe.till(mouseTileColLocation, mouseTileRowLocation, tileRightOfType);
					AudioManager.playEffect(0);
				}
					
				if(mousePosition.equalsIgnoreCase("Left")) 
				{
					hoe.till(mouseTileColLocation, mouseTileRowLocation, tileLeftOfType);
					AudioManager.playEffect(0);
				}
					
				energy -= hoe.getEnergyExpenditure();
				
			}
			
			if(equippedTool == 13) //Sprinkler
			{
				if(mousePosition.equalsIgnoreCase("Up"))
					((SprinklerItem) sprinkler).place(mouseTileColLocation, mouseTileRowLocation, tileAboveOfType);
				if(mousePosition.equalsIgnoreCase("Down"))
					((SprinklerItem) sprinkler).place(mouseTileColLocation, mouseTileRowLocation, tileBehindOfType);
				if(mousePosition.equalsIgnoreCase("Right"))
					((SprinklerItem) sprinkler).place(mouseTileColLocation, mouseTileRowLocation, tileRightOfType);
				if(mousePosition.equalsIgnoreCase("Left"))
					((SprinklerItem) sprinkler).place(mouseTileColLocation, mouseTileRowLocation, tileLeftOfType);
				energy -= hoe.getEnergyExpenditure();
			}
			
			
			if(equippedTool == 2) // SeedPack
			{
				
//				int num = getLastHUDNum();
				SeedPack seedPack = getCornPack();
//				int seedInput = 0;
//				if(num == 2)
//					seedInput = 1; seedPack = getCornPack();
//				if(num == 10)
//					seedInput = 2; seedPack = getCarrotPack();
//				if(num == 11)
//					seedInput = 3; seedPack = getTomatoPack();
//				if(num == 12)
//					seedInput = 4; seedPack = getBlueberryPack();
				
				
					if(mousePosition.equalsIgnoreCase("Up"))
						seedPack.plant(cornSeeds, seedPack.getSeedType(), tileAboveOfType,mouseTileColLocation, mouseTileRowLocation);
					if(mousePosition.equalsIgnoreCase("Down"))
						seedPack.plant(cornSeeds, seedPack.getSeedType(), tileBehindOfType,mouseTileColLocation, mouseTileRowLocation);
					if(mousePosition.equalsIgnoreCase("Right"))
						seedPack.plant(cornSeeds, seedPack.getSeedType(), tileRightOfType,mouseTileColLocation, mouseTileRowLocation);
					if(mousePosition.equalsIgnoreCase("Left"))
						seedPack.plant(cornSeeds, seedPack.getSeedType(), tileLeftOfType,mouseTileColLocation, mouseTileRowLocation);
					energy -= cornPack.getEnergyExpenditure();		
				
			}
			
			if(equippedTool == 10) 
			{
				SeedPack seedPack = getCarrotPack();
				if(mousePosition.equalsIgnoreCase("Up"))
					seedPack.plant(carrotSeeds, seedPack.getSeedType(), tileAboveOfType,mouseTileColLocation, mouseTileRowLocation);
				if(mousePosition.equalsIgnoreCase("Down"))
					seedPack.plant(carrotSeeds, seedPack.getSeedType(), tileBehindOfType,mouseTileColLocation, mouseTileRowLocation);
				if(mousePosition.equalsIgnoreCase("Right"))
					seedPack.plant(carrotSeeds, seedPack.getSeedType(), tileRightOfType,mouseTileColLocation, mouseTileRowLocation);
				if(mousePosition.equalsIgnoreCase("Left"))
					seedPack.plant(carrotSeeds, seedPack.getSeedType(), tileLeftOfType,mouseTileColLocation, mouseTileRowLocation);
				energy -= cornPack.getEnergyExpenditure();		
			}
			
			if(equippedTool == 11) 
			{
				SeedPack seedPack = getTomatoPack();
				if(mousePosition.equalsIgnoreCase("Up"))
					seedPack.plant(tomatoSeeds, seedPack.getSeedType(), tileAboveOfType,mouseTileColLocation, mouseTileRowLocation);
				if(mousePosition.equalsIgnoreCase("Down"))
					seedPack.plant(tomatoSeeds, seedPack.getSeedType(), tileBehindOfType,mouseTileColLocation, mouseTileRowLocation);
				if(mousePosition.equalsIgnoreCase("Right"))
					seedPack.plant(tomatoSeeds, seedPack.getSeedType(), tileRightOfType,mouseTileColLocation, mouseTileRowLocation);
				if(mousePosition.equalsIgnoreCase("Left"))
					seedPack.plant(tomatoSeeds, seedPack.getSeedType(), tileLeftOfType,mouseTileColLocation, mouseTileRowLocation);
				energy -= cornPack.getEnergyExpenditure();		
			}
			
			if(equippedTool == 12) 
			{
				SeedPack seedPack = getBlueberryPack();
				if(mousePosition.equalsIgnoreCase("Up"))
					seedPack.plant(blueberrySeeds, seedPack.getSeedType(), tileAboveOfType,mouseTileColLocation, mouseTileRowLocation);
				if(mousePosition.equalsIgnoreCase("Down"))
					seedPack.plant(blueberrySeeds, seedPack.getSeedType(), tileBehindOfType,mouseTileColLocation, mouseTileRowLocation);
				if(mousePosition.equalsIgnoreCase("Right"))
					seedPack.plant(blueberrySeeds, seedPack.getSeedType(), tileRightOfType,mouseTileColLocation, mouseTileRowLocation);
				if(mousePosition.equalsIgnoreCase("Left"))
					seedPack.plant(blueberrySeeds, seedPack.getSeedType(), tileLeftOfType,mouseTileColLocation, mouseTileRowLocation);
				energy -= cornPack.getEnergyExpenditure();		
			}
			
			if(equippedTool == 3) // Scythe
			{
				
				// Animation! Go
				
				if(mousePosition.equalsIgnoreCase("Up")) 
				{
					scythe.harvest(mouseTileColLocation, mouseTileRowLocation, tileAboveOfType);
					AudioManager.playEffect(1);
				}
					
				if(mousePosition.equalsIgnoreCase("Down")) 
				{
					scythe.harvest(mouseTileColLocation, mouseTileRowLocation, tileBehindOfType);
					AudioManager.playEffect(1);
				}
					
				if(mousePosition.equalsIgnoreCase("Right")) 
				{
					scythe.harvest(mouseTileColLocation, mouseTileRowLocation, tileRightOfType);
					AudioManager.playEffect(1);
				}
					
				if(mousePosition.equalsIgnoreCase("Left")) 
				{
					scythe.harvest(mouseTileColLocation, mouseTileRowLocation, tileLeftOfType);
					AudioManager.playEffect(1);
				}
					
				energy -= scythe.getEnergyExpenditure();
			}
			
			if(equippedTool == 4) // Pickaxe
			{
				if(mousePosition.equalsIgnoreCase("Up")) 
				{
					pickaxe.harvest(mouseTileColLocation, mouseTileRowLocation, tileAboveOfType);
					AudioManager.playEffect(2);
				}
					
				if(mousePosition.equalsIgnoreCase("Down")) 
				{
					pickaxe.harvest(mouseTileColLocation, mouseTileRowLocation, tileBehindOfType);
					AudioManager.playEffect(2);
				}
				
				if(mousePosition.equalsIgnoreCase("Right")) 
				{
					pickaxe.harvest(mouseTileColLocation, mouseTileRowLocation, tileRightOfType);
					AudioManager.playEffect(2);
				}
					
				if(mousePosition.equalsIgnoreCase("Left")) 
				{
					pickaxe.harvest(mouseTileColLocation, mouseTileRowLocation, tileLeftOfType);
					AudioManager.playEffect(2);
				}
					
				energy -= pickaxe.getEnergyExpenditure();
			}
			
			if(equippedTool == 5) //WateringCan
			{
				if(mousePosition.equalsIgnoreCase("Up"))
					wateringCan.water(gc, mouseTileColLocation, mouseTileRowLocation, tileAboveOfType);
				if(mousePosition.equalsIgnoreCase("Down"))
					wateringCan.water(gc,mouseTileColLocation, mouseTileRowLocation, tileBehindOfType);
				if(mousePosition.equalsIgnoreCase("Right"))
					wateringCan.water(gc,mouseTileColLocation, mouseTileRowLocation, tileRightOfType);
				if(mousePosition.equalsIgnoreCase("Left"))
					wateringCan.water(gc,mouseTileColLocation, mouseTileRowLocation, tileLeftOfType);
				energy -= wateringCan.getEnergyExpenditure();
			}
			
				
				
		}
	}
	
	/*--------------------------------------------------------- Collision -------------------------------------------------------------------------*/	
	
	 public boolean cannotMove(int num) 
	{
		if(num == 1 && tileAboveOfType.equalsIgnoreCase("BoulderTile") || num == 1 && tileAboveOfType.equalsIgnoreCase("HouseTile" ) || num == 1 && tileAboveOfType.equalsIgnoreCase("CopperBoulderTile")
				|| num == 1 && tileAboveOfType.equalsIgnoreCase("WaterTile")) 
			return true;
		if(num == 2 && tileBehindOfType.equalsIgnoreCase("BoulderTile")|| num == 2 && tileBehindOfType.equalsIgnoreCase("HouseTile")| num == 2 && tileBehindOfType.equalsIgnoreCase("WaterTile") || num == 2 && tileBehindOfType.equalsIgnoreCase("CopperBoulderTile"))
			return true;
		if(num == 3 && tileLeftOfType.equalsIgnoreCase("BoulderTile")|| num == 3 && tileLeftOfType.equalsIgnoreCase("HouseTile")| num == 3 && tileLeftOfType.equalsIgnoreCase("WaterTile") || num == 3 && tileLeftOfType.equalsIgnoreCase("CopperBoulderTile"))
			return true;
		if(num == 4 && tileRightOfType.equalsIgnoreCase("BoulderTile")|| num == 4 && tileRightOfType.equalsIgnoreCase("HouseTile")|| num == 4 && tileRightOfType.equalsIgnoreCase("WaterTile") || num == 4 && tileRightOfType.equalsIgnoreCase("CopperBoulderTile"))
			return true;
		return false;
	}
	
	/*---------------------------------------------------------Out of Bounds Computations----------------------------------------------------------*/

	boolean topBoundMet() 
	{
		if(worldTileRowLocation == 0)
			return true;
		return false;
	}
	
	boolean bottomBoundMet() 
	{
		if(worldTileRowLocation == 47)
			return true;
		return false;
	}
	
	boolean rightBoundMet() 
	{
		if(worldTileColLocation == 47)
			return true;
		return false;
	}
	
	boolean leftBoundMet() 
	{
		if(worldTileColLocation == 0)
			return true;
		return false;
	}
	
	/*--------------------------------------------------------- Directional Orientation ------------------------------------------------------------*/	
	
	
	public Tile getTileAbove() 
	{
		if(worldTileRowLocation != Game.maxWorldRow - Game.maxWorldRow)
			return getTile(worldTileColLocation, worldTileRowLocation - 1);
		return null;
	}
	
	public int getTileAboveCol() 
	{
		return worldTileColLocation;
	}
	
	public int getTileAboveRow() 
	{
		if(worldTileRowLocation != Game.maxWorldRow - Game.maxWorldRow)
			return worldTileRowLocation - 1;
		return worldTileRowLocation;
	}
	
	public Tile getTileBelow() 
	{
		if(worldTileColLocation != Game.maxWorldRow)	
			return getTile(worldTileColLocation, worldTileRowLocation + 1);
		return null;
	}
	
	public int getTileBelowCol() 
	{
		return worldTileColLocation;
	}
	
	public int getTileBelowRow() 
	{
		if(worldTileColLocation != Game.maxWorldRow)	
			return worldTileRowLocation + 1;
		return worldTileRowLocation;
	}
	
	public Tile getTileRight() 
	{
		if(worldTileRowLocation != Game.maxWorldCol)
			return getTile(worldTileColLocation + 1, worldTileRowLocation);
		return null;
	}
	
	public int getTileRightOfCol() 
	{
		if(worldTileRowLocation != Game.maxWorldCol)
			return worldTileColLocation + 1;
		return worldTileColLocation;
	}
	
	public int getTileRightOfRow() 
	{
		return worldTileRowLocation;
	}
	
	public Tile getTileLeft() 
	{	
		if(worldTileRowLocation != Game.maxWorldCol - Game.maxWorldCol)
			return getTile(worldTileColLocation - 1, worldTileRowLocation);
		return null;
	}
	
	public int getTileLeftOfCol() 
	{
		if(worldTileRowLocation != Game.maxWorldCol - Game.maxWorldCol)
			return worldTileColLocation - 1;
		return worldTileColLocation;
	}
	
	public int getTileLeftOfRow() 
	{
		return worldTileRowLocation;
	}
	
	public Tile getTileOn() 
	{
		return getTile(worldTileColLocation, worldTileRowLocation);
	}
	
	public String getNonMovableDirections() 
	{
		if(directionalOrientation != null)
		return tileAboveOfType.charAt(0) + "" +tileBehindOfType.charAt(0)  + "" + tileRightOfType.charAt(0) + "" + tileLeftOfType.charAt(0) + "";
		return "null";
	}
	
	public boolean lmbClicked(GameContainer gc) 
	{
		Input input = gc.getInput();
		if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) 
		{
			return true;	
		}
		
		return false;
	}

	/*--------------------------------------------------------- Getters ---------------------------------------------------------------------------*/	

	public int getLastHUDNum() 
	{
		return HUD.getLastNum();
	}
	
	public int getPlayersRow() 
	{
		return worldTileRowLocation;
	}
	
	public int getPlayersCol() 
	{
		return worldTileColLocation;
	}
	
	public int getMouseCol() 
	{
		return mouseTileColLocation;
	}
	
	public int getMouseRow() 
	{
		return mouseTileRowLocation;
	}
	
	public GardeningHoe getHoe() 
	{
		return hoe;
	}
	
	public int getQuantity() 
	{
		return 1;
	}
	
	public SeedPack getCornPack() 
	{
		return cornPack;
	}
	
	public SeedPack getBlueberryPack() 
	{
		return blueberryPack;
	}
	public SeedPack getCarrotPack() 
	{
		return carrotPack;
	}
	public SeedPack getTomatoPack() 
	{
		return tomatoPack;
	}
	
	
	public WateringCan getWateringCan() 
	{
		return wateringCan;
	}
	

	/*--------------------------------------------------------- Setters ---------------------------------------------------------------------------*/		
	public void setTileType(String above, String below, String rightOf, String leftOf) 
	{
		tileAboveOfType = above;
		tileBehindOfType = below;
		tileRightOfType = rightOf;
		tileLeftOfType = leftOf;
	}
	
	public void setTileArray(Tile[][] t) 
	{
		this.t = t;
	}

	public Scythe getScythe() {
		// TODO Auto-generated method stub
		return scythe;
	}
	
	public Pickaxe getPickaxe() 
	{
		return pickaxe;
	}

	public void incrementSeed(int n) 
	{
		// TODO Auto-generated method stub

		if(n == 1)
			cornSeeds --;
		if(n == 2)
			blueberrySeeds --;
		if(n == 3)
			tomatoSeeds --;
		if(n == 4)
			carrotSeeds --;
	}

	public void incrementCrop(int n) {
		// TODO Auto-generated method stub
		
		if(n == 1)
			corn ++;
		if(n == 2)
			blueBerry ++;
		if(n == 3)
			tomato ++;
		if(n == 4)
			carrot ++;
		
	}
	
	public boolean hasPickaxe() 
	{
		return hasPick;
	}
	
	public boolean hasTomato() 
	{
		return tomato > 0;
	}
	
	public boolean hasCarrot() 
	{
		return carrot > 0;
	}
	public boolean hasCorn() 
	{
		return corn > 0;
	}
	public boolean hasBlueberry() 
	{
		return blueBerry > 0;
	}

	public int getEnergy() {
		// TODO Auto-generated method stub
		return energy;
	}

	public Items getCornItem() {
		// TODO Auto-generated method stub
		if(corn > 0)
			return cornItem;
		else return null;
	}
	
	public Items getBlueberryItem() {
		// TODO Auto-generated method stub
		if(blueBerry > 0)
			return blueberryItem;
		else return null;
	}
	public Items getTomatoItem() {
		// TODO Auto-generated method stub
		if(tomato > 0)
			return tomatoItem;
		else return null;
	}
	public Items getCarrotItem() {
		// TODO Auto-generated method stub
		if(carrot > 0)
			return carrotItem;
		else return null;
	}
	
	public Items getMilkItem() {
		// TODO Auto-generated method stub
		if(milk > 0)
			return milkItem;
		else return null;
	}
	
	public Items getEggItem() {
		// TODO Auto-generated method stub
		if(eggs > 0)
			return eggItem;
		else return null;
	}
	
	public Items getWoolItem() {
		// TODO Auto-generated method stub
		if(wool > 0)
			return woolItem;
		else return null;
	}
	
	
	public Items getCopperOre() 
	{
		if(copper > 0)
			return copperOre;
		else return null;
	}
	
	public boolean hasCopper() 
	{
		return copper >  0;
	}
	

	public boolean hasSprinkler() {
		// TODO Auto-generated method stub
		return sprinklers > 0;
	}

	
	

	
	
	
	












}
