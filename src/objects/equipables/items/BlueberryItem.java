package objects.equipables.items;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import objects.entities.Player;
import style.Images;

public class BlueberryItem extends Items{

	Player p;
	
	public BlueberryItem(Player p) 
	{
		this.p = p;
	}
	
	public int getQuantity() {
		return Player.blueBerry;
	}
	
	
	public Image getImage() 
	{
			return Images.blueberry.getScaledCopy(32,32);
	}
	
	public void mouseDraw(Graphics g) 
	{
		g.fillRect(Mouse.getX(), Mouse.getY(), 20, 20);
	}
	
	public int getNum() {
		// For HUD / Game tool determination
		return 8;
	}
	
	public boolean hasBlueberry() 
	{
		return p.blueBerry > 0;
	}
	
	public int getNumberBlueberry() 
	{
		return p.blueBerry;
	}
	
	public String getString() 
	{
		return "TomatoItem";
	}

}
