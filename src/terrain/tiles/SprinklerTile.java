package terrain.tiles;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import Marketitems.Explosioncluster;
import core.Game;
import style.Images;
import terrain.Tile;

public class SprinklerTile extends Tile {

	Tile rowDown;
	Tile rowUp;
	Tile colRight;
	Tile colLeft;
	Tile upRightDiagonal;
	Tile downRightDiagonal;
	Tile upLeftDiagonal;
	Tile downLeftDiagonal;
	int timer = 30;
	
	public SprinklerTile(int x, int y, Tile t1, Tile t2, Tile t3, Tile t4, Tile t5, Tile t6, Tile t7, Tile t8) {
		super(x,y,t1,t2,t3,t4);
		// TODO Auto-generated constructor stub
		rowDown = t1;
		rowUp = t2;
		colRight = t3;
		colLeft = t4;
		upRightDiagonal = t5;
		downRightDiagonal = t6;
		upLeftDiagonal = t7;
		downLeftDiagonal = t8;
	}
	
	public void updateTiles(Tile t1, Tile t2, Tile t3, Tile t4,Tile t5, Tile t6, Tile t7, Tile t8 ) 
	{
		rowDown = t1;
		rowUp = t2;
		colRight = t3;
		colLeft = t4;
		upRightDiagonal = t5;
		downRightDiagonal = t6;
		upLeftDiagonal = t7;
		downLeftDiagonal = t8;
		
		
	}
	
	public void render(Graphics g, int screenX, int screenY) 
	{
		g.setColor(Color.green);
		g.drawImage(Images.sprinkler,screenX, screenY);	
		
		if(timer > 0)
			timer --;
		
//		if(timer == 0) {
//			
			
			for(int i = 0; i < 9; i++)
				Game.worldManager.explosionclusters.add(new Explosioncluster("water",1,screenX+Game.tileSize/2,screenY+Game.tileSize/2));
			
			timer = 300;
		//}
		
		
		//Make a timer, when hits a certain # start animation
	
	
	
	}
	
	public void update() 
	{
		//System.out.println("D: " + colRight.getY() + " " + colRight.getClass());
	}

}
