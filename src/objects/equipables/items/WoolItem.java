package objects.equipables.items;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import objects.entities.Player;
import style.Images;

public class WoolItem extends Items{
Player p;
	
	public WoolItem(Player p) 
	{
		this.p = p;
	}
	
	public Image getImage() 
	{
		//if(hasCorn())
			return Images.wool1.getScaledCopy(32,32);
		//else return null;
	}
	
	public int getQuantity() {
		return Player.wool;
	}
	
	
	public void mouseDraw(Graphics g) 
	{
		g.fillRect(Mouse.getX(), Mouse.getY(), 20, 20);
	}
	
	public int getNum() {
		// For HUD / Game tool determination
		return 16;
	}
	
	public boolean hasCorn() 
	{
		return p.wool > 0;
	}
	
	public int getNumberCorn() 
	{
		return p.wool;
	}
	
	public String getString() 
	{
		return "CornItem";
	}
}
