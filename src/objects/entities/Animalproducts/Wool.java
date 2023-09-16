package objects.entities.Animalproducts;

import org.newdawn.slick.Graphics;

import core.Game;
import style.Images;
import terrain.Tile;

public class Wool extends Animalproduct {

	int x;
	int y;
Tile t;
	
	
	public Wool(Tile t, int x, int y) {
		super(t, x, y);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	
	
	public void render(Graphics g, int xpos, int ypos){
		g.drawImage(Images.wool1.getScaledCopy(50,50),xpos+10,ypos+10);
	}
	
	public void goaway() {
		// TODO Auto-generated method stub
		x=99999;
		y=99999;
	}
	
}
