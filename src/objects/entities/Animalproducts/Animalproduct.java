package objects.entities.Animalproducts;



import org.newdawn.slick.Graphics;

import core.Game;
import objects.entities.Player;
import style.Images;
import terrain.Tile;

public class Animalproduct {

	
	
	int x;
	int y;
Tile t;
	
	
	public Animalproduct(Tile t , int x,int y){
		this.t = t;
		this.x = x;
		this.y = y;
		
		
	}
	public void render(Graphics g, int xpos, int ypos){
g.drawRect(xpos, ypos, Game.tileSize, Game.tileSize);
		g.drawImage(Images.milk1.getScaledCopy(32,32),xpos,ypos);
	}
	public void goaway() {
		// TODO Auto-generated method stub
		x=99999;
		y=99999;
	}
	
	
}
