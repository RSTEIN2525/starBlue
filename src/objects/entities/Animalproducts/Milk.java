package objects.entities.Animalproducts;

import org.newdawn.slick.Graphics;

import core.Game;
import style.Images;
import terrain.Tile;

public class Milk extends Animalproduct {

	int x;
	int y;
Tile t;
	
	
	public Milk(Tile t, int x, int y) {
		super(t, x, y);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	
	
	public void render(Graphics g, int xpos, int ypos){



		g.drawImage(Images.milk1.getScaledCopy(32,32),xpos+10,ypos+10);
	}
	
	public void goaway() {
		// TODO Auto-generated method stub
		x=99999;
		y=99999;
	}
	
}
