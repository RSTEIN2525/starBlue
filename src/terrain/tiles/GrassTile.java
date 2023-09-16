package terrain.tiles;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import terrain.Tile;
import core.Game;
import style.Images;

public class GrassTile extends Tile
{

	public GrassTile(int x, int y, boolean moisture)
	{
		super(x,y, moisture);
	}
	
	
	public void render(Graphics g, int screenX, int screenY) 
	{
		g.setColor(Color.green);
		g.drawImage(Images.grass,screenX, screenY);	
		
		
		
		
//		g.setColor(Color.black);
//		g.drawRect(screenX, screenY, 64,64);
		
	}
	
	public void altRender(Graphics g) 
	{
		g.setColor(Color.pink);
		g.fillOval(getX(), getY(), 20, 20);
		System.out.println("Happens: " + getX() + " " +getY());
	}
	
	
}
