package objects.equipables.items;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import objects.entities.Player;
import style.Images;

public class CornItem extends Items{

	Player p;
	
	public CornItem(Player p) 
	{
		this.p = p;
	}
	

	
	
	public int getQuantity()
	{
		return Player.corn;
	}
	
	public Image getImage() 
	{
		//if(hasCorn())
			return Images.cornShop.getScaledCopy(32,32);
		//else return null;
	}
	
	public void mouseDraw(Graphics g) 
	{
		g.fillRect(Mouse.getX(), Mouse.getY(), 20, 20);
	}
	
	public int getNum() {
		// For HUD / Game tool determination
		return 6;
	}
	
	public boolean hasCorn() 
	{
		return p.corn > 0;
	}
	
	public int getNumberCorn() 
	{
		return p.corn;
	}
	
	public String getString() 
	{
		return "CornItem";
	}
}
