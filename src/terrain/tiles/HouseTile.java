package terrain.tiles;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import core.Game;
import style.Images;
import terrain.Tile;

public class HouseTile extends Tile{

		
public HouseTile(int x, int y, boolean moisture) {
		super(x, y, moisture);
		// TODO Auto-generated constructor stub
	}

//	public HouseTile(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) 
//	{
//		super(x1,y1,x2,y2,x3,y3,x4,y4);
//	}
	
	public void render(Graphics g, int screenX, int screenY) 
	{
		g.drawImage(Images.playerHouse,screenX, screenY);
		
	}

}
