package core;

import java.util.ArrayList;


import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import Marketitems.Blueberry;
import Marketitems.Blueberryseed;
import Marketitems.Bridge;
import Marketitems.Carrot;
import Marketitems.Carrotseed;
import Marketitems.Chickenitem;
import Marketitems.Coffee;
import Marketitems.CopperOre;
import Marketitems.Corn;
import Marketitems.Cornseed;
import Marketitems.Cowitem;
import Marketitems.Eggitem;
import Marketitems.Explosioncluster;
import Marketitems.Fenceposts;
import Marketitems.MarketItem;
import Marketitems.Milkitem;
import Marketitems.Pickaxe;
import Marketitems.Sheepitem;
import Marketitems.Shoes;
import Marketitems.Sprinkler;
import Marketitems.Tomato;
import Marketitems.Tomatoseed;
import Marketitems.Woolitem;
import objects.entities.Player;
import style.Fonts;
import style.Images;
public  class Market extends BasicGameState 
{	
	private int id;
	private StateBasedGame sbg;	
	public  ArrayList<MarketItem> mItems = new ArrayList<MarketItem>();
	public String test;
	int timer = 0;
	Image coinimage;
	public static int xItemOffset = 500;
	public static int yItemOffset = 360;
	
	public static ArrayList<Explosioncluster> explosionclusters = new ArrayList<Explosioncluster>();
	

	
	public Market(int id) 
	{
		this.id = id;
	}

	public int getID() 
	{
		return id;		
	}
	
	public static int getCornPrice() 
	{
		return 2;
	}
	
	public static int getCarrotPrice() 
	{
		return 23;
	}
	
	public static int getTomatoPrice() 
	{
		return 11;
	}
	
	public static int getBlueberryPrice() 
	{
		return 36;
	}
	
	public static int getWoolPrice() 
	{
		return 10;
	}
	
	public static int getEggPrice() 
	{
		return 15;
	}
	
	public static int getMilkPrice() 
	{
		return 35;
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException 
	{
		
		this.sbg = sbg;
		Images.loadImages();
		mItems.add(new Corn(xItemOffset,yItemOffset, 2));
		mItems.add(new Tomato(xItemOffset+120*1,yItemOffset, 11));
		mItems.add(new Carrot(xItemOffset+120*2,yItemOffset, 23));
		mItems.add(new Blueberry(xItemOffset+120*3,yItemOffset, 36));

		mItems.add(new Cornseed(xItemOffset, yItemOffset + 1 * 120,1));
		mItems.add(new Tomatoseed(xItemOffset+120*1, yItemOffset + 1 * 120,5));
		mItems.add(new Carrotseed(xItemOffset+120*2, yItemOffset + 1 * 120,10));
		mItems.add(new Blueberryseed(xItemOffset + 120*3, yItemOffset + 1 * 120,15));
		
		
		mItems.add(new Cowitem(xItemOffset+120*4, yItemOffset+120 ,20));
		mItems.add(new Chickenitem(xItemOffset+120*5, yItemOffset+120 ,10));
		mItems.add(new Sheepitem(xItemOffset+6*120, yItemOffset +120,15));

		mItems.add(new Milkitem(xItemOffset+120*4, yItemOffset,35));
		mItems.add(new Eggitem(xItemOffset+120*5, yItemOffset,15));
		mItems.add(new Woolitem(xItemOffset+120*6, yItemOffset,25));
		
		mItems.add(new Fenceposts(xItemOffset+120*1, yItemOffset+120*2,50));
		mItems.add(new Sprinkler(xItemOffset,yItemOffset + 120 * 2, 50));
		mItems.add(new Bridge(xItemOffset + 120 * 2, yItemOffset + 120 * 2, 80));
		
		mItems.add(new Pickaxe(xItemOffset + 120 * 3, yItemOffset + 120 * 2, 50));
		mItems.add(new CopperOre(xItemOffset + 120 * 4, yItemOffset + 120 * 2, 15));
		
		mItems.add(new Shoes(xItemOffset+120*5, yItemOffset+120*2,10));
		
		mItems.add(new Coffee(xItemOffset+120*6, yItemOffset+120*2,10));


		coinimage= Images.coin1;
	}


	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{	
		for(MarketItem m: mItems)
			m.update(gc);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException 
	{
		// Background
		g.drawImage(Images.marketBackground,0,0);
		g.drawImage(Images.marketText,400,850);
		g.setColor(new Color(255,200,127));
		g.fillRect(475, 340, 1000, 400);
		g.drawImage(Images.imageBoard,1544,326);
		
		// Coin System
			coinRender(g);
		
	// Items Rendering
			for(MarketItem m: mItems) {
				m.render(g);
			}

for(Explosioncluster e : explosionclusters) {
	
	e.render(g);
}

	}
	
	

	public void coinRender(Graphics g) 
	{
		timer++;
		if(timer==100) {timer = 0;}
		if(timer==0) {
			coinimage = Images.coin1;
			}
		
		if(timer==25) {
			coinimage = Images.coin2;
			}
		
	if(timer==50) {
		coinimage = Images.coin3;
		}

	if(timer==75) {
		coinimage = Images.coin4;
		}
	g.drawImage(coinimage,1850,1000);
	g.setFont(Fonts.fontSmall);
	g.setColor(Color.white);
	g.drawString(Player.coins + "x" , 1818 , 1025);
	
	}

	public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException 
	{
		// This code happens when you enter a gameState.  
	}

	public void leave(GameContainer gc, StateBasedGame sbg) 
	{
		// This code happens when you leave a gameState. 
	}

	public void keyPressed(int key, char c)
	{
		if (key == Input.KEY_ESCAPE) 
	    {
		  sbg.enterState(Main.GAME_ID);
	    }
		// This code happens every time the user presses a key
	}

	public void mousePressed(int button, int x, int y)
	{
		System.out.println("mouse x: "+x+"  mouse y: "+y);
		// This code happens every time the user presses the mouse
	}




}