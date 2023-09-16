package terrain.tiles;

import org.newdawn.slick.Graphics;

import style.Images;
import terrain.Tile;

public class CopperBoulderTile extends Tile{

	int rand = (int) Math.floor(Math.random() * 100);
	
	public CopperBoulderTile(int x, int y, boolean moisture) {
		super(x, y, moisture);
		// TODO Auto-generated constructor stub
	}
	
	
	public void render(Graphics g, int screenX, int screenY) 
	{
		if(rand < 34)
			g.drawImage(Images.copperrock1, screenX,screenY);
		else if(rand <67)
			g.drawImage(Images.copperrock2, screenX,screenY);
		else
			g.drawImage(Images.copperrock3, screenX,screenY);
	}

}
