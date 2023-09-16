package objects.equipables.tools;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import Marketitems.Explosioncluster;
import core.Game;
import objects.entities.Player;
import style.Images;
import terrain.tiles.FarmLandTile;

public class Pickaxe extends Tool {
	
	Player p;
	int col;
	int row;
	boolean fullyMined = false;
	
	public Pickaxe(Player p) 
	{
		this.p = p;
	}
	
	public Image getImage() 
	{
		return Images.pickaxe;
	}
	
	public int getQuantity() {
		return 1;
	}
	
	public void mouseDraw(Graphics g) 
	{
		g.fillRect(Mouse.getX(), Mouse.getY(), 20, 20);
	}
	
	public int getNum() {
		// For HUD / Game tool determination
		return 4;
	}
	
	public String getString() 
	{
		return "Pick";
	}
	
	public void harvest(int row, int col, String terrainType) 
	{
		
		if(terrainType.equalsIgnoreCase("BoulderTile") || terrainType.equalsIgnoreCase("CopperBoulderTile") || terrainType.equalsIgnoreCase("FarmLandTile") || terrainType.equalsIgnoreCase("SprinklersTile")) 
		{
			this.col = col;
			this.row = row;
			if(p.getMousePosition().equalsIgnoreCase("Left")) 
			{
				if(terrainType.equalsIgnoreCase("BoulderTile"))
					Game.worldManager.explosionclusters.add(new Explosioncluster("rockfragment",10,Player.screenX - Game.tileSize,Player.screenY));
				else if(terrainType.equalsIgnoreCase("CopperBoulderTile")) 
					Game.worldManager.explosionclusters.add(new Explosioncluster("copperfragment",10,Player.screenX - Game.tileSize,Player.screenY));
			}
			
			
				
			if(p.getMousePosition().equalsIgnoreCase("Right")) 
			{
				if(terrainType.equalsIgnoreCase("BoulderTile"))
					Game.worldManager.explosionclusters.add(new Explosioncluster("rockfragment",10,Player.screenX + Game.tileSize,Player.screenY));
				else if(terrainType.equalsIgnoreCase("CopperBoulderTile")) 
					Game.worldManager.explosionclusters.add(new Explosioncluster("copperfragment",10,Player.screenX + Game.tileSize,Player.screenY));
			}
				
			if(p.getMousePosition().equalsIgnoreCase("Down")) 
			{
				if(terrainType.equalsIgnoreCase("BoulderTile"))
					Game.worldManager.explosionclusters.add(new Explosioncluster("rockfragment",10,Player.screenX,Player.screenY + Game.tileSize));
				else if(terrainType.equalsIgnoreCase("CopperBoulderTile")) 
					Game.worldManager.explosionclusters.add(new Explosioncluster("copperfragment",10,Player.screenX,Player.screenY + Game.tileSize));
			}
				
			if(p.getMousePosition().equalsIgnoreCase("Up")) 
			{
				if(terrainType.equalsIgnoreCase("BoulderTile"))
					Game.worldManager.explosionclusters.add(new Explosioncluster("rockfragment",10,Player.screenX,Player.screenY - Game.tileSize));
				else if(terrainType.equalsIgnoreCase("CopperBoulderTile")) 
					Game.worldManager.explosionclusters.add(new Explosioncluster("copperfragment",10,Player.screenX,Player.screenY - Game.tileSize));
			}
				
			
			
			
			//Game.worldManager.explosionclusters.add(new Explosioncluster("rockfragment",10,row*Game.tileSize,col*Game.tileSize));



		}else 
		{
			row = 999;
			col = 999;
		}
	}
	
	public void wipe() 
	{
		col = 0;
		row = 0;
	}
	
	
	
	public int getXForMining() 
	{
		return col;
	}
	
	public int getYForMining() 
	{
		return row;
	}

}
