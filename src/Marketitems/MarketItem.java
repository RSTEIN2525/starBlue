package Marketitems;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import core.Main;
import objects.entities.Player;
import style.Fonts;
import style.Images;

public class MarketItem 
{
	public int x;
	public int y;
	public int price;
	public static int sizeConstant =100;
	public int size = sizeConstant;
	
	
	
	
	public int CORNSEEDPRICE = 1;
	public int CORNPRICE = 2;
	public boolean hasspace = true;
	
	public MarketItem(int x, int y, int price)
	{
		this.x = x;
		this.y = y;
		this.price = price;
		Fonts.loadFonts();
	}
	
	public boolean mouseOver() 
	{
		if(Mouse.getX() > x && Mouse.getX() < x + size)
			if(Main.getScreenHeight() - Mouse.getY() > y && Main.getScreenHeight() - Mouse.getY() < y + size)
				return true;
		return false;
	}
	
	public void update(GameContainer gc) 
	{

		Input input = gc.getInput();
		transaction(gc);
//		if(mouseOver() && input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) 
//		{
//			if(s.equalsIgnoreCase("Corn") && Player.corn > 0) 
//			{
//				Player.corn -= 1;
//				Player.coins += CORNPRICE;
//			}
//			
//			if(s.equalsIgnoreCase("CornSeeds") && Player.coins > 0) 
//			{
//				Player.cornSeeds += 1;
//				Player.coins -= CORNSEEDPRICE;
//			} 
//		}
//		
//		if(mouseOver()&&input.isMousePressed(Input.MOUSE_RIGHT_BUTTON)) {
//			
//			if(s.equalsIgnoreCase("Corn") && Player.corn >= 10) 
//			{
//				Player.corn -= 10;
//				Player.coins += (CORNPRICE*10);
//			}
//			
//			if(s.equalsIgnoreCase("CornSeeds") && Player.coins > CORNSEEDPRICE*10) 
//			{
//				Player.cornSeeds += 10;
//				Player.coins -= (CORNSEEDPRICE*10);
//			} 
//		}
		}
	
	
	public void render(Graphics g) 
	{
		size = sizeConstant;
		if(mouseOver()) {
			size = (int) (sizeConstant * 1.1);
			
			g.setColor(new Color(201, 165, 91));
			
			
			
			g.fillRect((float )(x-(size*0.05)), (float)((y-(size*0.05))),size,size);
			
		}
		else {
			g.setColor(new Color(230, 188, 103));
			g.fillRect(x, y, size, size);
		}
//		if(s.equalsIgnoreCase("Corn")) 
//		{
//			
//			g.setColor(Color.white);
//			
//			if(mouseOver()) 
//			{
//
//				displaytext(g, "Corn", "Sell", "Corn is corn", Player.corn, CORNPRICE);
//				g.drawImage(Images.cornShop.getScaledCopy(size,size), (float )(x-(size*0.05)), (float)((y-(size*0.05))));
//			}
//			else {
//				g.drawImage(Images.cornShop.getScaledCopy(size,size), x, y);
//			}
//			
//		}
//		
//		if(s.equalsIgnoreCase("CornSeeds")) 
//		{
//			
//			g.setColor(Color.white);
//			
//			if(mouseOver()) 
//			{
//				g.drawImage(Images.cornSeeds.getScaledCopy(size,size), (float )(x-(size*0.05)), (float)((y-(size*0.05))));
//				displaytext(g, "Corn seeds", "Buy", "Turns into corn", Player.cornSeeds, CORNSEEDPRICE);
//			}
//			else {
//				g.drawImage(Images.cornSeeds.getScaledCopy(size,size), x, y);
//			}
//		}	
		notenoughspace(g);
	}
	
public void notenoughspace(Graphics g) {
		if(!hasspace) {
			g.setFont(Fonts.fontSmall);
			g.setColor(Color.red);
		g.drawString("Not enough fence space", 1563, 636);

		}
	}
	public void displaytext(Graphics g, String name, String buyOrSell, String description, int inStock, int priceSingle) {
		g.setFont(Fonts.fontLarge);
		g.setColor(Color.white);
		g.drawString(name, 1580, 350);
		
		g.setFont(Fonts.fontSmall);
		g.drawString("("+buyOrSell+")", 1570, 335);
		
		g.drawString(description, 1580, 430);
		g.drawString("Amount in stock: "+ inStock, 1580, 480);
		g.drawString(buyOrSell+" Price: "+priceSingle, 1580, 540);
		
		
	}
	
	public void buy(GameContainer gc) {
		
		
		
		
		
		
	}
	
	public void sell(GameContainer gc) {
		
	}
	void transaction(GameContainer gc){
		
		
		
	}
	
	
}
