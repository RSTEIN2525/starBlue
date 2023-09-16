package terrain.tiles;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import style.Images;
import terrain.Tile;

public class BridgeTile extends Tile
{
	public BridgeTile(int x, int y, boolean moisture) 
	{
		super(x,y,moisture);
	}
	
	public void render(Graphics g, int screenX, int screenY) 
	{
		g.drawImage(Images.bridge, screenX, screenY);
	}
}
