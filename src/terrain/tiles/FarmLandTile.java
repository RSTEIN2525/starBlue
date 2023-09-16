package terrain.tiles;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import terrain.Tile;
import core.Game;
import core.WorldManager;
import style.Images;

public class FarmLandTile extends Tile
{
	
	
	public FarmLandTile(int x, int y, boolean moisture)
	{
		super(x,y,moisture);
	}

	public void render(Graphics g, int screenX, int screenY) 
	{
		
		g.setColor(Color.yellow);
		
		if(moisture) 
		{
			g.drawImage(Images.soil,screenX, screenY);
		}else 
		{
			g.drawImage(Images.dryTilledSoil,screenX, screenY);
		}
		
		
	}
	
	public void update() 
	{
		//System.out.println(getMoisture());
	}
}
