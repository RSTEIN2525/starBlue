package objects.equipables.items;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import objects.entities.Player;
import style.Images;

public class MilkItem extends Items{
Player p;
	
	public MilkItem(Player p) 
	{
		this.p = p;
	}
	public int getQuantity() {
		return Player.milk;
	}
	
	
	public Image getImage() 
	{
		//if(hasCorn())
			return Images.milk1.getScaledCopy(32,32);
		//else return null;
	}
	
	public void mouseDraw(Graphics g) 
	{
		g.fillRect(Mouse.getX(), Mouse.getY(), 20, 20);
	}
	
	public int getNum() {
		// For HUD / Game tool determination
		return 15;
	}
	
	public boolean hasCorn() 
	{
		return p.milk > 0;
	}
	
	public int getNumberCorn() 
	{
		return p.milk;
	}
	
	public String getString() 
	{
		return "CornItem";
	}
}
