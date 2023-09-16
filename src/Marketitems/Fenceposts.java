package Marketitems;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

import core.Game;
import core.Market;
import objects.entities.Player;
import objects.entities.animals.Animal;
import objects.entities.animals.Cow;
import style.Images;

public class Fenceposts extends MarketItem {

	public Boolean buyable = true;
	Image i;
	
	public Fenceposts(int x, int y, int price) {
		super(x, y, price);
		i = Images.fencepostset.getScaledCopy(size,size);
	}

	


	public void render(Graphics g) {
		
		size = sizeConstant;
		if(mouseOver()) {
			size = (int) (sizeConstant * 1.1);
			
			g.setColor(new Color(201, 165, 91));
			
			
			
			g.fillRect((float )(x-(size*0.05)), (float)((y-(size*0.05))),size,size);

			g.drawImage(i.getScaledCopy(size,size),(float )(x-(size*0.05)), (float)(y-(size*0.05)));
			displaytext( g, "Fenceposts", "buy", "5 more spaces for animals", Player.cows, price);	
		}
		else {
			g.setColor(new Color(230, 188, 103));
			g.fillRect(x, y, size,size);
			g.drawImage(i.getScaledCopy(size,size),x,y);
			
		}
		


		
	} 

//		public void update(GameContainer gc){
//			
//		}
	void transaction(GameContainer gc) 
	{
		Input input = gc.getInput();
		if(mouseOver() && input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
		
			if(buyable) 
			{
			
				if(Player.coins>=price) 
				{
			
				
					Player.coins-=price;
					Market.explosionclusters.add(new Explosioncluster("fence",10,x,y));

						Game.worldManager.resetfences();
							
						
		
		
		
			}
	
			}
	
		}
	}
}
	
	
	
	
	

