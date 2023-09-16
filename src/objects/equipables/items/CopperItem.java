package objects.equipables.items;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import objects.entities.Player;
import style.Images;

public class CopperItem extends Items {
Player p;
	
	public CopperItem(Player p) 
	{
		this.p = p;
	}
	
	public int getQuantity() {
		return Player.copper;
	}
	
	
	public Image getImage() 
	{
		//if(hasCorn())
			return Images.copperore.getScaledCopy(32,32);
		//else return null;
	}
	
	public void mouseDraw(Graphics g) 
	{
		g.fillRect(Mouse.getX(), Mouse.getY(), 20, 20);
	}
	
	public int getNum() {
		// For HUD / Game tool determination
		return 17;
	}
	
	public boolean hasCorn() 
	{
		return p.copper > 0;
	}
	
	public int getNumberCorn() 
	{
		return p.copper;
	}
	
	public String getString() 
	{
		return "CopperItem";
	}
}
