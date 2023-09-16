package objects.equipables.tools;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import core.Game;
import core.SlashAnimation;
import core.SlashAnimation;
import objects.entities.Player;
import style.Images;

public class Scythe extends Tool{
	Player p;
	int col = 0;
	int row = 0;
	
	public Scythe(Player p) 
	{
		this.p = p;
	}
	
	public int getQuantity() {
		return 1;
	}
	
	public Image getImage() 
	{
		return Images.scythe;
	}
	
	public void mouseDraw(Graphics g) 
	{
		g.fillRect(Mouse.getX(), Mouse.getY(), 20, 20);
	}
	
	public int getNum() {
		// For HUD / Game tool determination
		return 3;
	}
	
	public String getString() 
	{
		return "Scythe";
	}
	
	public void harvest(int row, int col, String terrainType) 
	{
		if(p.getMousePosition().equalsIgnoreCase("Left"))
			Game.worldManager.slashanimations.add(new SlashAnimation(Player.screenX - Game.tileSize,Player.screenY));
		if(p.getMousePosition().equalsIgnoreCase("Right"))
			Game.worldManager.slashanimations.add(new SlashAnimation(Player.screenX + Game.tileSize,Player.screenY));
		if(p.getMousePosition().equalsIgnoreCase("Down"))
			Game.worldManager.slashanimations.add(new SlashAnimation(Player.screenX ,Player.screenY+ Game.tileSize));
		if(p.getMousePosition().equalsIgnoreCase("Up"))
			Game.worldManager.slashanimations.add(new SlashAnimation(Player.screenX ,Player.screenY- Game.tileSize));
		
		
		if(terrainType.equalsIgnoreCase("FarmLandTile")) 
		{
			this.col = col;
			this.row = row;
		}else 
		{
			row = 999;
			col = 999;
		}
	}
	
	public int getXForHarvest() 
	{
		return col;
	}
	
	public void wipe() 
	{
		System.out.println("SCYTH.WIPE");
		col = 0;
		row = 0;
	}
	
	
	public int getYForHarvest() 
	{
		return row;
	}
}
