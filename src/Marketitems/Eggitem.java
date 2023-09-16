package Marketitems;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

import core.Game;
import core.Market;
import objects.entities.Player;
import style.Images;

public class Eggitem extends MarketItem {

	public Boolean buyable = false;
	Image i;
	Explosioncluster e;
	
	public Eggitem(int x, int y, int price) {
		super(x, y, price);
		i = Images.egg1.getScaledCopy(size,size);
	}

	


	public void render(Graphics g) {

		
		size = sizeConstant;
		if(mouseOver()) {
			size = (int) (sizeConstant * 1.1);
			
			g.setColor(new Color(201, 165, 91));
			
			
			
			g.fillRect((float )(x-(size*0.05)), (float)((y-(size*0.05))),size,size);
			displaytext( g, "Egg", "sell", "Dont put them all in one basket", Player.eggs, price);
			g.drawImage(i.getScaledCopy(size,size),(float )(x-(size*0.05))+30, 30+(float)(y-(size*0.05)));
			
		}
		else {
			g.setColor(new Color(230, 188, 103));
			g.fillRect(x, y, size, size);
			g.drawImage(i.getScaledCopy(size,size),x+30,y+30);
			
		}
		

		
	} 

//		public void update(GameContainer gc){
//			
//		}
void transaction(GameContainer gc) {

	Input input = gc.getInput();
	if(mouseOver() && input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
		
		if(buyable) {
			
			
		}
		
		else {
			
		if(Player.eggs>0) {
			Player.eggs--;
			Player.coins+=price;
			Game.eggsSold ++ ;
//			e = new   Explosioncluster("blueberry", 10,x,y);
			
			Market.explosionclusters.add(new Explosioncluster("egg",10,x,y));

		}	
		
			
			
		}
		
		
		
	}
	
}

	
	
	
	
	
}
