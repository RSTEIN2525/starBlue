package objects.equipables.items;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import objects.entities.Player;
import style.Images;

public class TomatoItem extends Items{

	Player p;
	
	public TomatoItem(Player p) 
	{
		this.p = p;
	}
	
	public int getQuantity() {
		return Player.tomato;
	}
	
	
	public Image getImage() 
	{
			return Images.tomato.getScaledCopy(32,32);
	}
	
	public void mouseDraw(Graphics g) 
	{
		g.fillRect(Mouse.getX(), Mouse.getY(), 20, 20);
	}
	
	public int getNum() {
		// For HUD / Game tool determination
		return 9;
	}
	
	public boolean hasTomato() 
	{
		return p.tomato > 0;
	}
	
	public int getNumberTomato() 
	{
		return p.tomato;
	}
	
	public String getString() 
	{
		return "TomatoItem";
	}

}
