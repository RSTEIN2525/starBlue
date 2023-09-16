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

public class Milkitem extends MarketItem {

	public Boolean buyable = false;
	Image i;
	Explosioncluster e;
	
	public Milkitem(int x, int y, int price) {
		super(x, y, price);
		i = Images.milk1.getScaledCopy(size,size);
	}

	


	public void render(Graphics g) {

		
		size = sizeConstant;
		if(mouseOver()) {
			size = (int) (sizeConstant * 1.1);
			
			g.setColor(new Color(201, 165, 91));
			
			
			
			g.fillRect((float )(x-(size*0.05)), (float)((y-(size*0.05))),size,size);
			displaytext( g, "Milk", "sell", "Doesnt come with cookies", Player.milk, price);
			g.drawImage(i.getScaledCopy(size,size),(float )(x-(size*0.05)), (float)(y-(size*0.05)));
			
		}
		else {
			g.setColor(new Color(230, 188, 103));
			g.fillRect(x, y, size, size);
			g.drawImage(i.getScaledCopy(size,size),x,y);
			
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
			
		if(Player.milk>0) {
			Player.milk--;
			Player.coins+=price;
//			e = new   Explosioncluster("blueberry", 10,x,y);
			Game.milkSold ++ ;
			Market.explosionclusters.add(new Explosioncluster("milk",10,x,y));

		}	
		
			
			
		}
		
		
		
	}
	
}

	
	
	
	
	
}
