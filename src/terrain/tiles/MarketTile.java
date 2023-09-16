package terrain.tiles;

import org.newdawn.slick.Graphics;

import style.Images;
import terrain.Tile;

public class MarketTile extends Tile{

	public MarketTile(int x, int y, boolean moisture) {
		super(x, y, moisture);
		// TODO Auto-generated constructor stub
	}
	
	public void render(Graphics g, int screenX, int screenY) 
	{
		g.drawImage(Images.marketstall,screenX, screenY);
	}

}
