package core;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import objects.entities.Player;
import style.Fonts;
import style.Images;

public class Recap extends BasicGameState{

	int id;
	private StateBasedGame sbg;
	int totalEarned;
	boolean first = true;
	
	public Recap(int id) 
	{
		this.id = id;
		
		
	}
	
	public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException 
	{
		// This code happens when you enter a gameState.  
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException 
	{
		this.sbg = sbg;          	        
	}

	
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException 
	{
		
		//Background
		g.drawImage(Images.recapScreen, 0, 0);
		
		//Sold:
		String afterNum;
		int adjDays = Game.numDays + 1;
		
		if (adjDays % 10 == 1 && adjDays != 11) {
		     afterNum = "st";
		    } else if (adjDays % 10 == 2 && adjDays != 12) {
		      afterNum = "nd";
		    } else if (adjDays % 10 == 3 && adjDays != 13) {
		      afterNum = "rd";
		    } else {
		      afterNum = "th";
		    }
		
		g.setColor(Color.white);
		g.setFont(Fonts.fontXLarge);
		g.drawString("7:00 AM, The " + (Game.numDays + 1) + afterNum + " Day of Spring", 590, (1080 - 815));
		
		
		g.setColor(Color.red);
		g.setFont(Fonts.fontSmall);
		if(Game.playerPassedOut)
			g.drawString("You Passed Out From Exhaustion" ,  650, (1080 - 815 + 65));
		
		g.setColor(Color.white);
		g.setFont(Fonts.fontLarge);
		g.drawString("Corn Sold: "+ Game.cornSold + "x" , 545, (1080 - 645));
		g.drawString("Carrots Sold: " + Game.carrotSold + "x" , 1035, (1080 - 645));
		g.drawString("Blueberries Sold: " + Game.blueberrySold + "x" , 545, (1080 - 645 + 85));
		g.drawString("Tomatoes Solds: " + Game.tomatoSold + "x" , 1035, (1080 - 645 + 85));
		g.drawString("Wool Sold: " + Game.woolSold + "x" , 545, (1080 - 645 + 2 * 85));
		g.drawString("Eggs Sold: " + Game.eggsSold + "x", 1035, (1080 - 645 + 2 * 85));
		g.drawString("Milk Sold: " + Game.milkSold + "x" , 545, (1080 - 645 + 3 * 85));
		g.drawString("Ore Sold: " + Game.copperSold + "x", 1035, (1080 - 645 + 3 * 85));
		
		int money =  (Game.cornSold * Market.getCornPrice() + Game.carrotSold * Market.getCarrotPrice()
		+ Game.tomatoSold * Market.getTomatoPrice() + Game.blueberrySold * Market.getBlueberryPrice()) + Game.woolSold * Market.getWoolPrice() 
		+ Game.eggsSold * Market.getEggPrice() + Game.milkSold * Market.getMilkPrice() + Game.copperSold * 25;
		
		if(first) 
		{
			totalEarned += money;
			first = false;
		}
		
		g.drawString("Profit On The Day: " + money +"c" , 545, (1080 - 645 + 4 * 85));
		
		
		g.drawString("Lifetime Earnings: " + totalEarned + "c", 650 + 128 - 32 , 1080 - 645 - 85);
		g.setFont(Fonts.fontLarge);
		g.drawString("Space to Continue", 545 + (545/2) - 45, (1080 - 645 + 5 * 85));
	}

	
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException 
	{
		Input input = arg0.getInput();
		if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON) ) 
		{
			
			System.out.println("Mouse X: " + Mouse.getX() + "Mouse Y: " + Mouse.getY());
		}
		
	}

	public void leave(GameContainer gc, StateBasedGame sbg) 
	{
		// This code happens when you leave a gameState. 
		Game.cornSold = 0;
		Game.tomatoSold = 0;
		Game.blueberrySold = 0;
		Game.carrotSold = 0;
		Game.woolSold = 0;
		Game.milkSold = 0;
		Game.eggsSold = 0;
		first = true;
		//Game.trigger();
	}
	
	public void keyPressed(int key, char c)
	{
		if (key == Input.KEY_SPACE) 
	    {
		  sbg.enterState(Main.GAME_ID);
	    }
		// This code happens every time the user presses a key
	}
	
	public int getID() 
	{
		return id;
	}

}
