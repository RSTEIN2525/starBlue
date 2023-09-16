package objects.equipables.items;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import objects.entities.Player;
import style.Images;

public class CarrotItem extends Items{

	Player p;
	
	public CarrotItem(Player p) 
	{
		this.p = p;
	}
	
	public int getQuantity() {
		return Player.carrot;
	}
	
	
	public Image getImage() 
	{
			return Images.carrot.getScaledCopy(32,32);
	}
	
	public void mouseDraw(Graphics g) 
	{
		g.fillRect(Mouse.getX(), Mouse.getY(), 20, 20);
	}
	
	public int getNum() {
		// For HUD / Game tool determination
		return 7;
	}
	
	public boolean hasCarrot() 
	{
		return p.carrot > 0;
	}
	
	public int getNumberCarrot() 
	{
		return p.carrot;
	}
	
	public String getString() 
	{
		return "TomatoItem";
	}


}
