package objects.entities;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.tests.xml.Item;

import core.Game;
import objects.equipables.items.Items;
import objects.equipables.tools.Tool;
import style.Fonts;
import style.Images;

public class toolBarBox  {
	
	Items t;
	int index;
	int width = Game.tileSize/2;
	String str;
	
	
	toolBarBox(Items t, int index) 
	{	
		this.t = t;
		this.index = index;
		str = t + "";
	}
	
	public void draw(Graphics g) 
	{
		g.setFont(Fonts.fontSmall);
		
		
		if(t != null && t.getImage() != null) 
		{
			//g.drawString(t.getString() ,index * Game.tileSize + PlayerHUD.objectOffset, 984);
			//g.fillRect(index * Game.tileSize + PlayerHUD.objectOffset, 1016, width, width);
			g.drawImage(t.getImage(),index * Game.tileSize + PlayerHUD.objectOffset, 1016);
			
			
			if(!(t.getNum() == 1 || t.getNum() == 3|| t.getNum() == 4 || t.getNum() == 5))
			g.drawString(t.getQuantity() + "x",index * Game.tileSize+ 16 + PlayerHUD.objectOffset, 1064 - 20);
		}
			
		
		
	}
	
	public Items getTool() 
	{
		return t;
	}
	
	public int getIndex() 
	{
		return index;
	}

	public void setTool(Items items) {
		// TODO Auto-generated method stub
		this.t = items;
	}

}
