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

public class Sheepitem extends MarketItem {

	public Boolean buyable = true;
	Image i;
	
	public Sheepitem(int x, int y, int price) {
		super(x, y, price);
		i = Images.sheep1.getScaledCopy(size,size);
	}

	


	public void render(Graphics g) {
		
		size = sizeConstant;
		if(mouseOver()) {
			size = (int) (sizeConstant * 1.1);
			
			g.setColor(new Color(201, 165, 91));
			
			
			
			g.fillRect((float )(x-(size*0.05)), (float)((y-(size*0.05))),size,size);

			g.drawImage(i.getScaledCopy(size,size),(float )(x-(size*0.05)), (float)(y-(size*0.05)));
			displaytext( g, "Sheep", "buy", "Produces wool", Player.sheep, price);	
		}
		else {
			g.setColor(new Color(230, 188, 103));
			g.fillRect(x, y, size, size);
			g.drawImage(i.getScaledCopy(size,size),x,y);
			
		}
		
		
		notenoughspace( g);

		
	} 

//		public void update(GameContainer gc){
//			
//		}
	void transaction(GameContainer gc) 
	{
		Input input = gc.getInput();
		boolean purchased = false;
		if(mouseOver() && input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
		
			if(buyable) 
			{
			
				if(Player.coins>=price) 
				{
			
//				Game.worldManager.animals.add(new Cow(Game.tileSize*1,Game.tileSize*1))type name = new type();
				
					// Safe Spawn
				
				
					int startfencei =Game.worldManager.startfencei;
					int endfencei = Game.worldManager.endfencei;
					int startfencej =Game.worldManager.startfencej;
					int endfencej = Game.worldManager.endfencej;
					
					
					for(int i = startfencei + 1;i<=endfencei - 1;i++) 
					{
						for(int j = startfencej + 1; j <= endfencej - 1;j++) 
						{
							if(purchased == false && Game.worldManager.getAnimal(i, j) == null) 
							{
								Game.worldManager.addAnimal(i, j, 2);
								purchased = true;
							}
							
								
						}  
					}
					if(purchased) {
					Player.sheep+=1;
					Player.coins-=price;
					Market.explosionclusters.add(new Explosioncluster("sheep",10,x,y));
						
					}
					else {
						 hasspace = false;
					}
		
		
		
		
		
			}
	
			}
	
		}
	}

	
	
	
	
	
}
