package core;

import java.time.DayOfWeek;
import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import Marketitems.Explosioncluster;
import objects.entities.Player;
import objects.entities.Animalproducts.Animalproduct;
import objects.entities.Animalproducts.Egg;
import objects.entities.Animalproducts.Milk;
import objects.entities.Animalproducts.Wool;
import objects.entities.animals.Animal;
import objects.entities.animals.Chicken;
import objects.entities.animals.Cow;
import objects.entities.animals.Sheep;
import plants.Plant;
import plants.farmablecrops.BlueBerry;
import plants.farmablecrops.Carrot;
import plants.farmablecrops.Corn;
import plants.farmablecrops.Tomato;
import style.Images;
import terrain.Tile;
import terrain.tiles.GrassTile;
import terrain.tiles.HouseExtenderTile;
import terrain.tiles.HouseTile;
import terrain.tiles.MarketExtenderTile;
import terrain.tiles.MarketTile;
import terrain.tiles.FarmLandTile;
import terrain.tiles.FenceTile;
import terrain.tiles.BoulderTile;
import terrain.tiles.BridgeTile;
import terrain.tiles.CopperBoulderTile;
import terrain.tiles.SprinklerTile;
import terrain.tiles.WaterTile;

public class WorldManager 
{
	public int startfencei = 2;
	public int endfencei = 5;
	public int startfencej = 4;
	public int endfencej = 10;
	Tile[][] tileBoard;
	String[][] tileTypeBoard;
	Plant[][] plantBoard;
	//david code
		Animalproduct[][] animalproductBoard;
	Animal[][] animalBoard;
	Tile playersTile;
	int playersRow;
	int playersCol;
	int colInfrontOfPlayer;
	int rowInfrontOfPlayer;
	protected int playersX;
	int playersY;
	float playersAnimOffset;
	String playersDirection;
	String s;
	int gameTime;
	boolean timeJustReset = false;
	
	public ArrayList<Vanishanimation> vanishanimations = new ArrayList<Vanishanimation>();
	public ArrayList<Explosioncluster> explosionclusters = new ArrayList<Explosioncluster>();
	public ArrayList<SlashAnimation> slashanimations = new ArrayList<SlashAnimation>();
	
	public WorldManager()
	{
		tileBoard = new Tile[Game.maxWorldRow][Game.maxWorldCol];
		tileTypeBoard = new String[Game.maxWorldRow][Game.maxWorldCol];
		plantBoard = new Plant[Game.maxWorldRow][Game.maxWorldCol];
		animalBoard = new Animal[Game.maxWorldRow][Game.maxWorldCol];
		
		//david code
				animalproductBoard = new Animalproduct[Game.maxWorldRow][Game.maxWorldCol];
	}
	
	public void moistureReset() 
	{
		for(int i = 0; i < Game.maxWorldRow; i++) 
		{
			for(int j = 0; j < Game.maxWorldCol; j++) 
			{	
				tileBoard[i][j].incrementMoisture(false);	
			}
		}	
	}
	
	//david code method
	public void addAnimalproduct(int row, int col, int Animalproducttype) {

		animalproductBoard[row][col] = new Animalproduct(getTile(row,col),col*Game.tileSize,row*Game.tileSize);
		
		
		if(Animalproducttype==1) {
			animalproductBoard[row][col] = new Milk(getTile(row,col),col*Game.tileSize,row*Game.tileSize);
			
		}
		
		if(Animalproducttype==2) {
			animalproductBoard[row][col] = new Egg(getTile(row,col),col*Game.tileSize,row*Game.tileSize);
			
		}
		
		if(Animalproducttype==3) {
			animalproductBoard[row][col] = new Wool(getTile(row,col),col*Game.tileSize,row*Game.tileSize);
			
		}
	}
	
	//new david delete animal method
	
		public void deleteAnimal(int row, int col) {
			if(animalBoard[row][col]!=null) {
			animalBoard[row][col] = null;
			}
			
		}

	
	public void placeSprinkler(int row, int col) 
	{
		Tile rowDown = getTile(row + 1, col);
		Tile rowUp = getTile(row - 1, col);
		Tile colRight = getTile(row, col + 1);
		Tile colLeft = getTile(row, col - 1);
		Tile upRightDiagonal = getTile(row - 1, col + 1);
		Tile downRightDiagonal = getTile(row + 1, col + 1);
		Tile upLeftDiagonal = getTile(row - 1, col - 1);
		Tile downLeftDiagonal = getTile(row + 1, col - 1);
		
		
		tileBoard[row][col] = new SprinklerTile(row * Game.tileSize, col * Game.tileSize,rowDown, 
				 rowUp, colRight, colLeft, upRightDiagonal, downRightDiagonal, upLeftDiagonal, downLeftDiagonal);
		tileTypeBoard[row][col] = "SprinklersTile";
		
		
		
		
//		addMoisture(row + 1, col);
//		addMoisture(row - 1, col);
//		addMoisture(row, col + 1);
//		addMoisture(row, col - 1);
	}
	
	public void continuedSprinkling() 
	{
		int timer = 600;
		boolean cycled = false;
		
		if(timer < 600) 
		{
			timer++;
		}
		
		for(int i = 0; i < Game.maxWorldRow; i++) 
		{
			for(int j = 0; j < Game.maxWorldCol; j++) 
			{
				Tile t;
				
				
				
				
				if(getTileType(i, j).equalsIgnoreCase("SprinklersTile")) 
				{
					
					
					
					addMoisture(i + 1, j);
					addMoisture(i - 1, j);
					addMoisture(i, j + 1);
					addMoisture(i, j - 1);
					cycled = true;
				}
			}
		}
		
		if(cycled == true) 
		{
			timer = 0;
			cycled = false;
		}
		
		
		
	}
	
	public void addAnimal(int row, int col, int animalType) 
	{
		if(animalType == 2)
			animalBoard[row][col] = new Sheep(getTile(row,col), col * Game.tileSize, row * Game.tileSize);
		if(animalType == 1)
			animalBoard[row][col] = new Cow(getTile(row,col), col * Game.tileSize, row * Game.tileSize);
		
		
		if(animalType ==3) {
			animalBoard[row][col] = new Chicken(getTile(row,col), col * Game.tileSize, row * Game.tileSize);
			
		}
	}
	
	public Animal getAnimal(int row, int col) 
	{
		if(animalBoard[row][col] != null)
			return animalBoard[row][col];
		return null;
	}
	
	
	//david code
		public Animalproduct getAnimalproduct(int row, int col) {
			
			if(animalproductBoard[row][col]!=null) {
				
				return animalproductBoard[row][col];
			}
			return null;
		}
	
	public void timeManagement() 
	{
		int earlyMorning = 0;
		int noon = 1200;
		int midNight = 2400;
		int lateNight = 3600;
		
		gameTime ++;
		if(gameTime >= 3600) 
		{
			gameTime = 0;
			timeJustReset = true;	
		}
		timeJustReset = false;
		
		if(gameTime >= earlyMorning && gameTime <= noon) 
		{
			// Whatever we want during morning hours
		}
		
		if(gameTime >= noon && gameTime <= midNight) 
		{
			// Whatever we want during afternoon hours
		}
		
		if(gameTime >= midNight && gameTime <= lateNight) 
		{
			// Whatever we want during  night hours
		}
		
	}
	
	public boolean timeReset() 
	{
		return timeJustReset;
	}
	
	public int getGameTime() 
	{
		return gameTime;
	}
	
	public Plant getPlant(int row, int col) 
	{
		return plantBoard[row][col];
	}
	
	public Tile getTile(int rows, int cols) 
	{
		return tileBoard[rows][cols];
	}
	
	public void harvestPlant(int rows, int cols)
	{
		plantBoard[rows][cols] = null;
	} 
	
	public void addMoisture(int rows, int cols) 
	{
		getTile(rows,cols).incrementMoisture(true);
	}
	
	
	public void tillTile(int rows, int cols) 
	{
		int rand = (int) Math.floor(Math.random() * 100);
		tileBoard[rows][cols] = new FarmLandTile(rows * Game.tileSize, cols * Game.tileSize, false);
		tileTypeBoard[rows][cols] = "FarmLandTile";
	}
	
	public void mine(int rows, int cols) 
	{
		if(getTileType(rows, cols).equalsIgnoreCase("CopperBoulderTile"))
			Player.copper ++;
		
		
		
		
		tileBoard[rows][cols] = new GrassTile(rows * Game.tileSize, cols * Game.tileSize, false);
		tileTypeBoard[rows][cols] = "GrassTile";
	}
	
	public void plantCrop(int rows, int cols, int seedType) 
	{
		if(seedType == 1) // Corn
			plantBoard[rows][cols] = new Corn(rows * Game.tileSize, cols * Game.tileSize, Game.numDays, getTile(rows, cols));
		if(seedType == 2) // BlueBerry
			plantBoard[rows][cols] = new BlueBerry(rows * Game.tileSize, cols * Game.tileSize, Game.numDays, getTile(rows, cols));
		if(seedType == 3) // Tomato
			plantBoard[rows][cols] = new Tomato(rows * Game.tileSize, cols * Game.tileSize,Game.numDays, getTile(rows, cols));
		if(seedType == 4) // Carrot
			plantBoard[rows][cols] = new Carrot(rows * Game.tileSize, cols * Game.tileSize,Game.numDays, getTile(rows, cols));
		
	}
	
	public int getCropType(int rows, int cols) 
	{
		
		return (getPlant(rows, cols).getType());
	}
	
	public String getTileType(int rows, int cols) 
	{
		String s = "";
		if(!(rows == -1 || cols == -1) && !(rows >= 48  || cols >= 48)&&tileTypeBoard[rows][cols]!=null) {
		 s = tileTypeBoard[rows][cols];
		}
		if(s.equalsIgnoreCase("GrassTile")) 
		{
			return "GrassTile";
		}else if(s.equalsIgnoreCase("FarmLandTile")) 
		{
			return "FarmLandTile";
		}else if(s.equalsIgnoreCase("BoulderTile")) 
		{
			return "BoulderTile";
		}else if(s.equalsIgnoreCase("FenceTile"))
		{
			return "FenceTile";
		}else if(s.equalsIgnoreCase("HouseTile"))
		{
			return "HouseTile";
		}else if(s.equalsIgnoreCase("MarketTile")) 
		{
			return "MarketTile";
		}else if(s.equalsIgnoreCase("SprinklersTile")) 
		{
			return "SprinklersTile";
		}else if(s.equalsIgnoreCase("WaterTile")) 
		{
			return "WaterTile";
		}else if(s.equalsIgnoreCase("CopperBoulderTile")) 
		{
			return "CopperBoulderTile";
		}
		else return "NullType";
		
	}
	
	public Boolean delete(int rows, int cols) 
	{
		Tile t = getTile(rows, cols);
		if(t instanceof BoulderTile)
			return true;
		return false;
	}
	
	public String[][] getStringArray()
	{
		return tileTypeBoard;
	}
	
	public Tile[][] getTileArray()
	{
		return tileBoard;
	}
	
	public void firstTimeSetup() 
	{
		
		for(int i = 0; i < Game.maxWorldRow; i++) 
		{
			for(int j = 0; j < Game.maxWorldCol; j++) 
			{
				int rand = (int) Math.floor(Math.random() * 100);
				int riverEndRow = 23;
				
				if(j < riverEndRow) 
				{
					if(rand > 2) 
					{
						tileBoard[i][j] = new GrassTile(j * Game.tileSize, i * Game.tileSize, false);
						tileTypeBoard[i][j] = "GrassTile";
						//plantBoard = null;
					}
						
					if(rand <= 2) 
					{
						tileBoard[i][j] = new BoulderTile(j * Game.tileSize, i * Game.tileSize, false);
						tileTypeBoard[i][j] = "BoulderTile";
						
						int rando = (int) Math.floor(Math.random() * 100);
						if(rando <= 20) 
						{
							tileBoard[i][j] = new CopperBoulderTile(j * Game.tileSize, i * Game.tileSize, false);
							tileTypeBoard[i][j] = "CopperBoulderTile";
						}
						
						//plantBoard = null;
					}
				}else 
				{
					if(rand > 10) 
					{
						tileBoard[i][j] = new GrassTile(j * Game.tileSize, i * Game.tileSize, false);
						tileTypeBoard[i][j] = "GrassTile";
					}else 
					{
						int rando = (int) Math.floor(Math.random() * 100);
						if(rando >= 20) 
						{
							tileBoard[i][j] = new CopperBoulderTile(j * Game.tileSize, i * Game.tileSize, false);
							tileTypeBoard[i][j] = "CopperBoulderTile";
						}else 
						{
							tileBoard[i][j] = new BoulderTile(j * Game.tileSize, i * Game.tileSize, false);
							tileTypeBoard[i][j] = "BoulderTile";
						}
						
					}
				}
				
				
				
				
					
			}
		}
		
		
		tileTypeBoard[12][0] = "MarketTile";
		tileTypeBoard[13][0] = "MarketTile";
		tileTypeBoard[12][1] = "MarketTile";
		tileTypeBoard[13][1] = "MarketTile";
		tileBoard[12][0] = new MarketTile(40 * Game.tileSize, 20 * Game.tileSize, false);
		tileBoard[13][0] = new MarketExtenderTile(41 * Game.tileSize, 20 * Game.tileSize, false);
		tileBoard[12][1] = new MarketExtenderTile(40 * Game.tileSize, 21 * Game.tileSize, false);
		tileBoard[13][1] = new MarketExtenderTile(41 * Game.tileSize, 21 * Game.tileSize, false);
		
		// House Prefab
		
		tileTypeBoard[7][0] = "HouseTile"; 
		tileTypeBoard[8][0] = "HouseTile";
		tileTypeBoard[9][0] = "HouseTile";
		tileTypeBoard[7][1] = "HouseTile"; 
		tileTypeBoard[8][1] = "HouseTile";
		tileTypeBoard[9][1] = "HouseTile";
		tileTypeBoard[7][2] = "HouseTile";
		tileTypeBoard[8][2] = "HouseTile";
		tileTypeBoard[9][2] = "HouseTile";
		tileBoard[7][0] = new HouseTile(7 * Game.tileSize, 0 * Game.tileSize, false);
		tileBoard[8][0] = new HouseExtenderTile(8 * Game.tileSize, 0 * Game.tileSize, false);
		tileBoard[9][0] = new HouseExtenderTile(9 * Game.tileSize, 0 * Game.tileSize, false);
		tileBoard[7][1] = new HouseExtenderTile(7 * Game.tileSize, 1 * Game.tileSize, false);
		tileBoard[8][1] = new HouseExtenderTile(8 * Game.tileSize, 1 * Game.tileSize, false);
		tileBoard[9][1] = new HouseExtenderTile(9 * Game.tileSize, 1 * Game.tileSize, false);
		tileBoard[7][2] = new HouseExtenderTile(7 * Game.tileSize, 2 * Game.tileSize, false);
		tileBoard[8][2] = new HouseExtenderTile(8 * Game.tileSize, 2 * Game.tileSize, false);
		tileBoard[9][2] = new HouseExtenderTile(9 * Game.tileSize, 2 * Game.tileSize, false);


			
		// Lake Prefab
		tileBoard[13][11]=new WaterTile(6 * Game.tileSize, 9 * Game.tileSize, false);	
		tileTypeBoard[13][11] = "WaterTile";
		tileBoard[14][11]=new WaterTile(6 * Game.tileSize, 9 * Game.tileSize, false);	
		tileTypeBoard[14][11] = "WaterTile";
		tileBoard[14][12]=new WaterTile(6 * Game.tileSize, 9 * Game.tileSize, false);	
		tileTypeBoard[14][12] = "WaterTile";
		tileBoard[13][12]=new WaterTile(6 * Game.tileSize, 9 * Game.tileSize, false);	
		tileTypeBoard[13][12] = "WaterTile";
		tileBoard[12][12]=new WaterTile(6 * Game.tileSize, 9 * Game.tileSize, false);	
		tileTypeBoard[12][12] = "WaterTile";
		tileBoard[13][13]=new WaterTile(6 * Game.tileSize, 9 * Game.tileSize, false);	
		tileTypeBoard[13][13] = "WaterTile";
		tileBoard[14][13]=new WaterTile(6 * Game.tileSize, 9 * Game.tileSize, false);	
		tileTypeBoard[14][13] = "WaterTile";
		tileBoard[15][13]=new WaterTile(6 * Game.tileSize, 9 * Game.tileSize, false);	
		tileTypeBoard[15][13] = "WaterTile";
		tileBoard[12][14]=new WaterTile(6 * Game.tileSize, 9 * Game.tileSize, false);	
		tileTypeBoard[12][14] = "WaterTile";
		tileBoard[13][14]=new WaterTile(6 * Game.tileSize, 9 * Game.tileSize, false);	
		tileTypeBoard[13][14] = "WaterTile";
		tileBoard[14][14]=new WaterTile(6 * Game.tileSize, 9 * Game.tileSize, false);	
		tileTypeBoard[14][14] = "WaterTile";
		tileBoard[15][14]=new WaterTile(6 * Game.tileSize, 9 * Game.tileSize, false);	
		tileTypeBoard[15][14] = "WaterTile";
		tileBoard[16][14]=new WaterTile(6 * Game.tileSize, 9 * Game.tileSize, false);	
		tileTypeBoard[16][14] = "WaterTile";
		tileBoard[15][15]=new WaterTile(6 * Game.tileSize, 9 * Game.tileSize, false);	
		tileTypeBoard[15][15] = "WaterTile";
		tileBoard[14][15]=new WaterTile(6 * Game.tileSize, 9 * Game.tileSize, false);	
		tileTypeBoard[14][15] = "WaterTile";
		tileBoard[13][15]=new WaterTile(6 * Game.tileSize, 9 * Game.tileSize, false);	
		tileTypeBoard[13][15] = "WaterTile";
		tileBoard[14][16]=new WaterTile(6 * Game.tileSize, 9 * Game.tileSize, false);	
		tileTypeBoard[14][16] = "WaterTile";
		//
		tileBoard[15][12]=new WaterTile(6 * Game.tileSize, 9 * Game.tileSize, false);	
		tileTypeBoard[15][12] = "WaterTile";
		tileBoard[16][13]=new WaterTile(6 * Game.tileSize, 9 * Game.tileSize, false);	
		tileTypeBoard[16][13] = "WaterTile";
		

		

		// Fence Prefab	
		
			for(int i = startfencei;i<=endfencei;i++) {
				
				for(int j = startfencej; j <= endfencej;j++) {
					
					if(i == startfencei) {
						tileTypeBoard[i][j] = "FenceTile";
					tileBoard[i][j]=new FenceTile(i * Game.tileSize, j * Game.tileSize, false);
					}
					
					if(i == endfencei) {
						tileTypeBoard[i][j] = "FenceTile";
					tileBoard[i][j]=new FenceTile(i * Game.tileSize, j * Game.tileSize, false);
					}
					
					if(j == startfencej) {
						tileTypeBoard[i][j] = "FenceTile";
					tileBoard[i][j]=new FenceTile(i * Game.tileSize, j * Game.tileSize, false);
					}
					
					if(j == endfencej) {
						tileTypeBoard[i][j] = "FenceTile";
					tileBoard[i][j]=new FenceTile(i * Game.tileSize, j * Game.tileSize, false);
					}
					
				}
				
			}
			
			
		// Rock Wall Prefab
			
			for(int i = 0; i < 21; i++)
			{
				
				tileBoard[21][i] = new BoulderTile(i * Game.tileSize, 21 * Game.tileSize, false);
				tileTypeBoard[21][i] = "BoulderTile";
				if(i == 0 || i == 1 || i == 2 || i == 6 || i == 7 || i == 12 || i == 12 || i == 13 || i == 17 || i == 18 || i == 19) 
				{
					tileBoard[20][i] = new BoulderTile(i * Game.tileSize, 21 * Game.tileSize, false);
					tileTypeBoard[20][i] = "BoulderTile";
				}
				
				if(i == 2 || i == 3 ||  i == 4 ||  i== 5 || i == 6 || i == 11 || i == 12 || i == 13 || i == 15 || i == 10|| i == 19 || i == 16 || i == 17) 
				{
					tileBoard[22][i] = new BoulderTile(i * Game.tileSize, 21 * Game.tileSize, false);
					tileTypeBoard[22][i] = "BoulderTile";
				}
				
				
				
			}
			
			
		// Water Prefab
			
			
		
			for(int i = 0; i < Game.maxWorldRow; i++)
			{
				if(i == 47 || i == 23 || i == 24 || i == 25) 
				{
					tileBoard[i][18] = new WaterTile(i * Game.tileSize, 21 * Game.tileSize, false);
					tileTypeBoard[i][18] = "WaterTile";
				}
				
				if(i == 0 || i == 15 || i == 22 || i == 23 ||i == 24 ||i == 25 ||i == 26 || i == 46 ||i == 47 || i == 14) 
				{
					tileBoard[i][19] = new WaterTile(i * Game.tileSize, 21 * Game.tileSize, false);
					tileTypeBoard[i][19] = "WaterTile";
				}
				
				if(i == 36 || i== 37 || i== 37 || i== 45 ||i== 46 ||i== 47 ||i== 20 || i== 21 || i== 22 || i== 23|| i== 24 || i== 25 || i == 13 || i== 26 || i== 27 || i== 28|| i== 1 || i == 38 || i== 0 || i== 16|| i== 15 || i== 14)
				{
					tileBoard[i][20] = new WaterTile(i * Game.tileSize, 21 * Game.tileSize, false);
					tileTypeBoard[i][20] = "WaterTile";
				}
				if(i != 6 && i != 7 && i != 8 && i != 31 && i != 32 && i != 33) 
				{
					tileBoard[i][21] = new WaterTile(i * Game.tileSize, 21 * Game.tileSize, false);
					tileTypeBoard[i][21] = "WaterTile";
				}
				
				
				if(i != 7 && i != 25 && i != 26 && i != 32) 
				{
					tileBoard[i][22] = new WaterTile(i * Game.tileSize, 22 * Game.tileSize, false);
					tileTypeBoard[i][22] = "WaterTile";
				}
				
				if(i != 22 && i != 23 && i != 24 && i != 25 && i != 24 && i != 26 && i!= 27 && i!= 13 && i!=14 && i!= 15&& i!= 36 && i!= 37)
				{
				tileBoard[i][23] = new WaterTile(i * Game.tileSize, 23 * Game.tileSize, false);
				tileTypeBoard[i][23] = "WaterTile";
				}
				
				if(i == 47 || i == 46 || i == 30 || i == 31 || i == 32 || i == 33 || i == 34 || i == 4 || i == 5 || i == 6 || i == 7 || i == 8 || i == 9 || i == 10 || i == 0 || i == 1) 
				{
					tileBoard[i][24] = new WaterTile(i * Game.tileSize, 23 * Game.tileSize, false);
					tileTypeBoard[i][24] = "WaterTile";
				}
				
				if(i == 0 || i == 6 || i ==7 || i == 8 || i == 31 || i == 32 || i == 33) 
				{
					tileBoard[i][25] = new WaterTile(i * Game.tileSize, 23 * Game.tileSize, false);
					tileTypeBoard[i][25] = "WaterTile";	
				}
				
			}
		
		
		
		
		
		
		
		
	}
	
	public void resetfences(){
		
		for(int i = startfencei;i<=endfencei;i++) {
					
					for(int j = startfencej; j <= endfencej;j++) {
						
						if(i == startfencei) {
							tileTypeBoard[i][j] = "GrassTile";
						tileBoard[i][j]=new GrassTile(i * Game.tileSize, j * Game.tileSize, false);
						}
						
						if(i == endfencei) {
							tileTypeBoard[i][j] = "GrassTile";
							tileBoard[i][j]=new GrassTile(i * Game.tileSize, j * Game.tileSize, false);
						}
						
						if(j == startfencej) {
							tileTypeBoard[i][j] = "GrassTile";
							tileBoard[i][j]=new GrassTile(i * Game.tileSize, j * Game.tileSize, false);
						}
						
						if(j == endfencej) {
							tileTypeBoard[i][j] = "GrassTile";
							tileBoard[i][j]=new GrassTile(i * Game.tileSize, j * Game.tileSize, false);
						}
						
					}
					
				}
				
		endfencei+=1;
		for(int i = startfencei;i<=endfencei;i++) {
					
					for(int j = startfencej; j <= endfencej;j++) {
						
						if(i == startfencei) {
							tileTypeBoard[i][j] = "FenceTile";
						tileBoard[i][j]=new FenceTile(i * Game.tileSize, j * Game.tileSize, false);
						}
						
						if(i == endfencei) {
							tileTypeBoard[i][j] = "FenceTile";
							tileBoard[i][j]=new FenceTile(i * Game.tileSize, j * Game.tileSize, false);
						}
						
						if(j == startfencej) {
							tileTypeBoard[i][j] = "FenceTile";
							tileBoard[i][j]=new FenceTile(i * Game.tileSize, j * Game.tileSize, false);
						}
						
						if(j == endfencej) {
							tileTypeBoard[i][j] = "FenceTile";
							tileBoard[i][j]=new FenceTile(i * Game.tileSize, j * Game.tileSize, false);
						}
						
					}}
					
				}

	
	public void setPlayersTile(int x, int y, float f, String direction) 
	{
		playersTile = tileBoard[x][y];
		playersCol = y;
		playersRow = x;
		playersX = playersCol * Game.tileSize;
		playersY = playersRow * Game.tileSize;
		playersAnimOffset = f;
		playersDirection = direction;
	}
	
	

	public void update(GameContainer gc) throws SlickException 
	{
	
		timeManagement();
		//continuedSprinkling();
		
		
		
		for(int i = 0; i < Game.maxWorldRow; i++) 
		{
			for(int j = 0; j < Game.maxWorldCol; j++) 
			{
				tileBoard[i][j].update();
				if(plantBoard[i][j] != null) 
				{
					plantBoard[i][j].setTile(getTile(i,j));
					plantBoard[i][j].update(gameTime);
				}
				
				if(getTileType(i, j).equalsIgnoreCase("SprinklersTile")) 
				{
					
					
					
					
					addMoisture(i + 1, j);
					addMoisture(i - 1, j);
					addMoisture(i, j + 1);
					addMoisture(i, j - 1);
					addMoisture(i - 1, j + 1);
					addMoisture(i - 1, j - 1);
					addMoisture(i + 1, j + 1);
					addMoisture(i + 1, j - 1);
					
					
					// NOTE TO RYAN: ADD TIMER LATER FOR WATERING PARTICLE EFFECT -> Do this in sprinkler tile class
					
					
					
				}
				
				if(getTileType(i,j).equalsIgnoreCase("WaterTile")) 
				{
					
					
					
					
					
						
						if(i - 1 != -1)
							addMoisture(i - 1, j);
						
						
						if(i + 1 < 48)
						addMoisture(i + 1, j);
						
						if(j + 1 < 48)
						addMoisture(i, j + 1);
						
						
						if(j - 1 != -1)
						addMoisture(i, j - 1);
						
					
					
				}
				
				
				
				if(animalBoard[i][j] != null) 
				{
					String above = "";
					String right = "";
					String below = "";
					String left = "";
					if(getTileType(animalBoard[i][j].getRow() - 1, animalBoard[i][j].getCol())!=null) {
					above = getTileType(animalBoard[i][j].getRow() - 1, animalBoard[i][j].getCol());
					}
					
					if(getTileType(animalBoard[i][j].getRow() + 1, animalBoard[i][j].getCol())!= null) {
					 below = getTileType(animalBoard[i][j].getRow() + 1, animalBoard[i][j].getCol());
					}
					if(getTileType(animalBoard[i][j].getRow(), animalBoard[i][j].getCol() + 1)!=null) {
					 right = getTileType(animalBoard[i][j].getRow(), animalBoard[i][j].getCol() + 1);
					}
					
					if(!(i-1 == - 1|| j-1 == -1) && getTileType(animalBoard[i][j].getRow(), animalBoard[i][j].getCol() - 1)!=null) {
					 left = getTileType(animalBoard[i][j].getRow(), animalBoard[i][j].getCol() - 1);
					}
					animalBoard[i][j].setAnimalArray(animalBoard);
					animalBoard[i][j].setStrings(above, below, right, left);
					animalBoard[i][j].update(gc);
					int r = animalBoard[i][j].getRow();
					int c = animalBoard[i][j].getCol();
					Animal a = animalBoard[i][j].getAnimal();
					animalBoard[r][c] = a;
					if(!(r == i && c == j))
						animalBoard[i][j] = null;
				}
					
			}
		}
		
		if(Game.changedDayNight) 
		{
			Game.trigger();
		}
		
				
	}
	
	public void render(Graphics g) 
	{
		for(int i = 0; i < Game.maxWorldRow; i++) 
		{
			for(int j = 0; j < Game.maxWorldCol; j++) 
			{
				
				int worldX = i * Game.tileSize;
				int worldY = j * Game.tileSize;
				int ScreenX = worldX - playersX + Player.screenX;
				int ScreenY = worldY - playersY + Player.screenY;
				int adjustX = 2176 - 64 * 16;
				int adjustY = 2176 - 64 * 3 ;
			
				
				if(Player.unlockedCameraX && Player.unlockedCameraY) 
				{
					if(playersX > 1920)
						worldX -= adjustX;
					
					if(playersY > 1920)
						worldY -= adjustY;
					
					tileBoard[i][j].render(g , worldX ,worldY);
					
					if(plantBoard[i][j] != null) 
					{
						if(playersDirection.equalsIgnoreCase("Left")) 
							plantBoard[i][j].render(g ,  worldX ,worldY);
						if(playersDirection.equalsIgnoreCase("Right")) 
							plantBoard[i][j].render(g ,  worldX ,worldY);
						if(playersDirection.equalsIgnoreCase("Down")) 
							plantBoard[i][j].render(g ,  worldX ,worldY);
						if(playersDirection.equalsIgnoreCase("Up")) 
							plantBoard[i][j].render(g ,  worldX ,worldY);
				
					}
					
					if(animalBoard[i][j] != null) 
					{
						if(playersDirection.equalsIgnoreCase("Left")) 
							animalBoard[i][j].render(g ,  worldX ,worldY);
						if(playersDirection.equalsIgnoreCase("Right")) 
							animalBoard[i][j].render(g , worldX ,worldY);
						if(playersDirection.equalsIgnoreCase("Down")) 
							animalBoard[i][j].render(g ,  worldX ,worldY);
						if(playersDirection.equalsIgnoreCase("Up")) 
							animalBoard[i][j].render(g ,  worldX ,worldY);
				
					}
					
	//david code trying to copy above
					
					if(animalproductBoard[i][j] != null) 
					{
						
						
						
						if(playersDirection.equalsIgnoreCase("Left")) 
							animalproductBoard[i][j].render(g , worldX ,worldY);
						if(playersDirection.equalsIgnoreCase("Right")) 
							animalproductBoard[i][j].render(g ,  worldX ,worldY);
						if(playersDirection.equalsIgnoreCase("Down")) 
							animalproductBoard[i][j].render(g ,  worldX ,worldY);
						if(playersDirection.equalsIgnoreCase("Up")) 
							animalproductBoard[i][j].render(g , worldX ,worldY);
				
						
						
						if(playersRow == j) {
							if(playersCol == i) {
								
								if(animalproductBoard[i][j] instanceof Milk) {
									
									Player.milk+=1;
								}
								else if(animalproductBoard[i][j] instanceof Egg) {
									
									Player.eggs+=1;
								}
								
								else if(animalproductBoard[i][j] instanceof Wool) {
									
									Player.wool+=1;
								}
								animalproductBoard[i][j] = null;

							}
							
						}
					}
					
					
				}
				else if(Player.unlockedCameraX) 
				{
					if(playersDirection == null)
						playersDirection = "Down";
					
					int xCameraBound = 16;
					int yCameraBound = 9;
					
					
					if(playersX > 1920)
						worldX -= adjustX;
					
					
					
						if(playersDirection.equalsIgnoreCase("Left") || playersDirection.equalsIgnoreCase("Right"))
							tileBoard[i][j].render(g , worldX , ScreenY);
						
						if(playersDirection.equalsIgnoreCase("Up")) 
							tileBoard[i][j].render(g , worldX , ScreenY + (int) (playersAnimOffset * 64 - 64));
						if(playersDirection.equalsIgnoreCase("Down")) 
							tileBoard[i][j].render(g , worldX , ScreenY - (int) (playersAnimOffset * 64 - 64));
						
						
						if(plantBoard[i][j] != null) 
						{
							if(playersDirection.equalsIgnoreCase("Left")) 
								plantBoard[i][j].render(g ,  worldX , ScreenY);
							if(playersDirection.equalsIgnoreCase("Right")) 
								plantBoard[i][j].render(g ,  worldX , ScreenY);
							if(playersDirection.equalsIgnoreCase("Down")) 
								plantBoard[i][j].render(g ,  worldX , ScreenY - (int) (playersAnimOffset * 64 - 64));
							if(playersDirection.equalsIgnoreCase("Up")) 
								plantBoard[i][j].render(g ,  worldX , ScreenY + (int) (playersAnimOffset * 64 - 64));
					
						}
						
						if(animalBoard[i][j] != null) 
						{
							if(playersDirection.equalsIgnoreCase("Left")) 
								animalBoard[i][j].render(g , worldX , ScreenY);
							if(playersDirection.equalsIgnoreCase("Right")) 
								animalBoard[i][j].render(g , worldX , ScreenY);
							if(playersDirection.equalsIgnoreCase("Down")) 
								animalBoard[i][j].render(g ,  worldX , ScreenY - (int) (playersAnimOffset * 64 - 64));
							if(playersDirection.equalsIgnoreCase("Up")) 
								animalBoard[i][j].render(g ,  worldX , ScreenY + (int) (playersAnimOffset * 64 - 64));
					
						}
						
		//david code trying to copy above
						
						if(animalproductBoard[i][j] != null) 
						{
							
							
							
							if(playersDirection.equalsIgnoreCase("Left")) 
								animalproductBoard[i][j].render(g , worldX , ScreenY);
							if(playersDirection.equalsIgnoreCase("Right")) 
								animalproductBoard[i][j].render(g ,  worldX , ScreenY);
							if(playersDirection.equalsIgnoreCase("Down")) 
								animalproductBoard[i][j].render(g ,  worldX , ScreenY - (int) (playersAnimOffset * 64 - 64));
							if(playersDirection.equalsIgnoreCase("Up")) 
								animalproductBoard[i][j].render(g , worldX , ScreenY + (int) (playersAnimOffset * 64 - 64));
					
							
							
							if(playersRow == j) {
								if(playersCol == i) {
									
									if(animalproductBoard[i][j] instanceof Milk) {
										
										Player.milk+=1;
									}
									else if(animalproductBoard[i][j] instanceof Egg) {
										
										Player.eggs+=1;
									}
									
									else if(animalproductBoard[i][j] instanceof Wool) {
										
										Player.wool+=1;
									}
									animalproductBoard[i][j] = null;

								}
								
							}
						}
					
					
				}else if(Player.unlockedCameraY) 
				{
					
					
					if(playersDirection == null)
						playersDirection = "Down";
					
					if(playersY > 1920)
						worldY -= adjustY;
					
						if(playersDirection.equalsIgnoreCase("Up") || playersDirection.equalsIgnoreCase("Down"))
							tileBoard[i][j].render(g , ScreenX , worldY);
						
						if(playersDirection.equalsIgnoreCase("Right")) 
							tileBoard[i][j].render(g , ScreenX - (int) (playersAnimOffset * 64 - 64) , worldY);
						if(playersDirection.equalsIgnoreCase("Left")) 
							tileBoard[i][j].render(g , ScreenX + (int) (playersAnimOffset * 64 - 64) , worldY);
						
						if(plantBoard[i][j] != null) 
						{
							if(playersDirection.equalsIgnoreCase("Left")) 
								plantBoard[i][j].render(g ,  ScreenX + (int) (playersAnimOffset * 64 - 64) , worldY);
							if(playersDirection.equalsIgnoreCase("Right")) 
								plantBoard[i][j].render(g ,   ScreenX - (int) (playersAnimOffset * 64 - 64) , worldY);
							if(playersDirection.equalsIgnoreCase("Down")) 
								plantBoard[i][j].render(g ,  ScreenX , worldY);
							if(playersDirection.equalsIgnoreCase("Up")) 
								plantBoard[i][j].render(g ,  ScreenX , worldY);
					
						}
						
						if(animalBoard[i][j] != null) 
						{
							if(playersDirection.equalsIgnoreCase("Left")) 
								animalBoard[i][j].render(g , ScreenX + (int) (playersAnimOffset * 64 - 64) , worldY);
							if(playersDirection.equalsIgnoreCase("Right")) 
								animalBoard[i][j].render(g ,  ScreenX - (int) (playersAnimOffset * 64 - 64) , worldY);
							if(playersDirection.equalsIgnoreCase("Down")) 
								animalBoard[i][j].render(g ,  ScreenX , worldY);
							if(playersDirection.equalsIgnoreCase("Up")) 
								animalBoard[i][j].render(g ,  ScreenX , worldY);
					
						}
						
		//david code trying to copy above
						
						if(animalproductBoard[i][j] != null) 
						{
							
							
							
							if(playersDirection.equalsIgnoreCase("Left")) 
								animalproductBoard[i][j].render(g , ScreenX + (int) (playersAnimOffset * 64 - 64) , worldY);
							if(playersDirection.equalsIgnoreCase("Right")) 
								animalproductBoard[i][j].render(g ,   ScreenX - (int) (playersAnimOffset * 64 - 64) , worldY);
							if(playersDirection.equalsIgnoreCase("Down")) 
								animalproductBoard[i][j].render(g , ScreenX , worldY);
							if(playersDirection.equalsIgnoreCase("Up")) 
								animalproductBoard[i][j].render(g ,ScreenX , worldY);
					
							
							
							if(playersRow == j) {
								if(playersCol == i) {
									
									if(animalproductBoard[i][j] instanceof Milk) {
										
										Player.milk+=1;
									}
									else if(animalproductBoard[i][j] instanceof Egg) {
										
										Player.eggs+=1;
									}
									
									else if(animalproductBoard[i][j] instanceof Wool) {
										
										Player.wool+=1;
									}
									animalproductBoard[i][j] = null;

								}
								
							}
						}
					
				}
				
				else 
				{
					if(playersDirection == null)
						playersDirection = "Down";

					if(playersDirection.equalsIgnoreCase("Left")) 
						tileBoard[i][j].render(g , ScreenX + (int) (playersAnimOffset * 64 - 64), ScreenY);
					if(playersDirection.equalsIgnoreCase("Right")) 
						tileBoard[i][j].render(g , ScreenX - (int) (playersAnimOffset * 64 - 64), ScreenY);
					if(playersDirection.equalsIgnoreCase("Down")) 
						tileBoard[i][j].render(g , ScreenX , ScreenY - (int) (playersAnimOffset * 64  -64));
					if(playersDirection.equalsIgnoreCase("Up")) 
						tileBoard[i][j].render(g , ScreenX , ScreenY + (int) (playersAnimOffset * 64 - 64));
			
					
					
					
					if(plantBoard[i][j] != null) 
					{
						if(playersDirection.equalsIgnoreCase("Left")) 
							plantBoard[i][j].render(g , ScreenX + (int) (playersAnimOffset * 64 - 64), ScreenY);
						if(playersDirection.equalsIgnoreCase("Right")) 
							plantBoard[i][j].render(g , ScreenX - (int) (playersAnimOffset * 64 - 64), ScreenY);
						if(playersDirection.equalsIgnoreCase("Down")) 
							plantBoard[i][j].render(g , ScreenX , ScreenY - (int) (playersAnimOffset * 64  -64));
						if(playersDirection.equalsIgnoreCase("Up")) 
							plantBoard[i][j].render(g , ScreenX , ScreenY + (int) (playersAnimOffset * 64 - 64));
				
					}
					
					if(animalBoard[i][j] != null) 
					{
						if(playersDirection.equalsIgnoreCase("Left")) 
							animalBoard[i][j].render(g , ScreenX + (int) (playersAnimOffset * 64 - 64), ScreenY);
						if(playersDirection.equalsIgnoreCase("Right")) 
							animalBoard[i][j].render(g , ScreenX - (int) (playersAnimOffset * 64 - 64), ScreenY);
						if(playersDirection.equalsIgnoreCase("Down")) 
							animalBoard[i][j].render(g , ScreenX , ScreenY - (int) (playersAnimOffset * 64  -64));
						if(playersDirection.equalsIgnoreCase("Up")) 
							animalBoard[i][j].render(g , ScreenX , ScreenY + (int) (playersAnimOffset * 64 - 64));
				
					}
					
	//david code trying to copy above
					
					if(animalproductBoard[i][j] != null) 
					{
						
						
						
						if(playersDirection.equalsIgnoreCase("Left")) 
							animalproductBoard[i][j].render(g , ScreenX + (int) (playersAnimOffset * 64 - 64), ScreenY);
						if(playersDirection.equalsIgnoreCase("Right")) 
							animalproductBoard[i][j].render(g , ScreenX - (int) (playersAnimOffset * 64 - 64), ScreenY);
						if(playersDirection.equalsIgnoreCase("Down")) 
							animalproductBoard[i][j].render(g , ScreenX , ScreenY - (int) (playersAnimOffset * 64  -64));
						if(playersDirection.equalsIgnoreCase("Up")) 
							animalproductBoard[i][j].render(g , ScreenX , ScreenY + (int) (playersAnimOffset * 64 - 64));
				
						
						
						if(playersRow == j) {
							if(playersCol == i) {
								
								if(animalproductBoard[i][j] instanceof Milk) {
									
									Player.milk+=1;
								}
								else if(animalproductBoard[i][j] instanceof Egg) {
									
									Player.eggs+=1;
								}
								
								else if(animalproductBoard[i][j] instanceof Wool) {
									
									Player.wool+=1;
								}
								animalproductBoard[i][j] = null;

							}
							
						}
					}
				}
			}
				}
				
				
				
					
		for(Vanishanimation v : vanishanimations) {
			v.render(g);
			
		}
		
		for(Explosioncluster e : explosionclusters) {
			e.render(g);
			
		}
		
		for(SlashAnimation s : slashanimations) {
			s.render(g);
			
		}
					//plantBoard[i][j].render(g, ScreenX, ScreenY);
			}

	public void addBridge() {
		// (39 - 40 - 41,20)
		
		tileBoard[39][21] = new BridgeTile(39 * Game.tileSize, 21 * Game.tileSize, false);
		tileTypeBoard[39][21] = "GrassTile";
		tileBoard[40][21] = new HouseExtenderTile(39 * Game.tileSize, 21 * Game.tileSize, false);
		tileTypeBoard[40][21]= "GrassTile";
		tileBoard[41][21] = new HouseExtenderTile(39 * Game.tileSize, 21 * Game.tileSize, false);
		tileTypeBoard[41][21]= "GrassTile";
		tileBoard[39][22] = new HouseExtenderTile(39 * Game.tileSize, 22 * Game.tileSize, false);
		tileTypeBoard[39][22]= "GrassTile";
		tileBoard[40][22] = new HouseExtenderTile(39 * Game.tileSize, 22 * Game.tileSize, false);
		tileTypeBoard[40][22] = "GrassTile";
		tileBoard[41][22] = new HouseExtenderTile(39 * Game.tileSize, 22 * Game.tileSize, false);
		tileTypeBoard[41][22] = "GrassTile";
		tileBoard[39][23] = new HouseExtenderTile(39 * Game.tileSize, 23 * Game.tileSize, false);
		tileTypeBoard[39][23]= "GrassTile";
		tileBoard[40][23] = new HouseExtenderTile(39 * Game.tileSize, 23 * Game.tileSize, false);
		tileTypeBoard[40][23]= "GrassTile";
		tileBoard[41][23] = new HouseExtenderTile(39 * Game.tileSize, 23 * Game.tileSize, false);
		tileTypeBoard[41][23]= "GrassTile";
		
		
		
		
		
	}
		
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

