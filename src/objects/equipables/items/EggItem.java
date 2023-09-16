package objects.equipables.items;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import objects.entities.Player;
import style.Images;

public class EggItem extends Items{
Player p;
	
	public EggItem(Player p) 
	{
		this.p = p;
	}
	
	public int getQuantity() {
		return Player.eggs;
	}
	
	
	public Image getImage() 
	{
		//if(hasCorn())
			return Images.egg1.getScaledCopy(32,32);
		//else return null;
	}
	
	public void mouseDraw(Graphics g) 
	{
		g.fillRect(Mouse.getX(), Mouse.getY(), 20, 20);
	}
	
	public int getNum() {
		// For HUD / Game tool determination
		return 14;
	}
	
	public boolean hasCorn() 
	{
		return p.eggs > 0;
	}
	
	public int getNumberCorn() 
	{
		return p.eggs;
	}
	
	public String getString() 
	{
		return "CornItem";
	}
}
