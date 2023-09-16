package terrain.tiles;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import terrain.Tile;
import core.Game;
import style.Images;

public class BoulderTile extends Tile
{
	int rand = (int) Math.floor(Math.random() * 100);
	
	public BoulderTile(int x, int y, boolean moisture)
	{
		super(x,y, moisture);
	}

	
	public void render(Graphics g, int screenX, int screenY) 
	{
		if(rand < 34)
			g.drawImage(Images.boulder, screenX,screenY);
		else if(rand <67)
			g.drawImage(Images.boulder2, screenX,screenY);
		else
			g.drawImage(Images.boulder3, screenX,screenY);
	}
	

}	
