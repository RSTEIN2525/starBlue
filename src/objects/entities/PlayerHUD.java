package objects.entities;

import java.awt.RenderingHints.Key;
import java.util.ArrayList;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import core.Game;
import core.Main;
import objects.entities.animals.EnergyBar;
import objects.equipables.items.Items;
import objects.equipables.tools.Tool;
import style.Fonts;
import style.Images;

public class PlayerHUD{
	
	public static int maxInventory = 9;
	int implementedTools = 5;
	public static int offset = (1920/2) - (maxInventory*32);
	String s = "1";
	int numOffset = offset + s.length() * 2 + 5;
	int lastNum;
	public static int objectOffset = 16 + offset;
	Input input;
	toolBarBox tools[] = new toolBarBox[maxInventory]; 
	protected Player p;
	Items swapTool = null;
	int swapToolIndex = 999;
	int lastSeedNum;
	EnergyBar energyBar; 
	int UInum = 0;
	
	protected PlayerHUD(Player p)
	{
		this.p = p;
	}
	
	public void initialSetup() 
	{
		tools[0] = new toolBarBox(p.getHoe(), 0);
		tools[1] = new toolBarBox(p.getScythe(), 1);
		tools[2] = new toolBarBox(p.getCornPack(), 2);
		tools[3] = new toolBarBox(p.getWateringCan(), 3);
		tools[4] = new toolBarBox(null, 4);
		tools[5] = new toolBarBox(null,5);
		tools[6] = new toolBarBox(null,6);
		tools[7] = new toolBarBox(null,7);
		tools[8] = new toolBarBox(null,8);
		energyBar = new EnergyBar(p);
	}
	
	public int findEmptySlot() 
	{
		for(int i = 0; i < tools.length; i++) 
		{
			if(tools[i].getTool() == null)
				return i;
		}
		
		
		System.out.println("Crashed because No Room");
		return -1;
	}
	
	public void panelDraw(Graphics g) 
	{
		g.drawImage(Images.uiPanel, 1920 - 256 - 32, 4);
		g.setColor(Color.white);
		g.setFont(Fonts.mediumFont);
		
		
		int hour = 0;
		String amOrPm;
		
		
		
		int multi = 416;
		
		if(Game.timer <= 10000 && Game.timer > 10000 -  multi)
			hour = 1;
		if(Game.timer <= 10000 - multi && Game.timer > 10000 - multi * 2)
			hour = 2;
		if(Game.timer <= 10000 - multi * 2 && Game.timer > 10000 - multi * 3)
			hour = 3;

		if(Game.timer <= 10000 - multi * 3 && Game.timer > 10000 - multi * 4)
			hour = 4;
		if(Game.timer <= 10000 - multi * 4 && Game.timer > 10000 - multi * 5)
			hour = 5;
		if(Game.timer <= 10000 - multi * 5 && Game.timer > 10000 - multi * 6)
			hour = 6;

		if(Game.timer <= 10000 - multi * 6 && Game.timer > 10000 - multi * 7)
			hour = 7;
		
		
		
		if(Game.timer <= 10000 - multi * 7 && Game.timer > 10000 - multi * 8)
			hour = 8;
		if(Game.timer <= 10000 - multi * 8 && Game.timer > 10000 - multi * 9)
			hour = 9;
		if(Game.timer <= 10000 - multi * 9 && Game.timer > 10000 - multi * 10)
			hour = 10;
		if(Game.timer <= 10000 - multi * 10 && Game.timer > 10000 - multi * 11)
			hour = 11;
		if(Game.timer <= 10000 - multi * 11 && Game.timer > 10000 - multi * 12)
			hour = 12;
		if(Game.timer <= 10000 - multi * 12 && Game.timer > 10000 - multi * 13)
			hour = 1;
		if(Game.timer <= 10000 - multi * 13 && Game.timer > 10000 - multi * 14)
			hour = 2;
		
		if(Game.timer <= 10000 - multi * 14 && Game.timer > 10000 - multi * 15)
			hour = 3;
		if(Game.timer <= 10000 - multi * 15 && Game.timer > 10000 - multi * 16)
			hour = 4;
		if(Game.timer <= 10000 - multi * 16 && Game.timer > 10000 - multi * 17)
			hour = 5;
		if(Game.timer <= 10000 - multi * 17 && Game.timer > 10000 - multi * 18)
			hour = 6;
		if(Game.timer <= 10000 - multi * 18 && Game.timer > 10000 - multi * 19)
			hour = 7;
		
		if(Game.timer <= 10000 - multi * 19 && Game.timer > 10000 - multi * 20)
			hour = 8;
		if(Game.timer <= 10000 - multi * 20 && Game.timer > 10000 - multi * 21)
			hour = 9;
		if(Game.timer <= 10000 - multi * 21 && Game.timer > 10000 - multi * 22)
			hour = 10;
		if(Game.timer <= 10000 - multi * 22 && Game.timer > 10000 - multi * 23)
			hour = 11;
		if(Game.timer <= 10000 - multi * 23 && Game.timer > 10000 - multi * 24)
			hour = 12;
		
		
		if(hour == 12 && !Game.isDay) 
		{
			amOrPm = "am";
		}else if(Game.timer <= 5000 || (hour == 12 && Game.isDay)) 
		{
			amOrPm = "pm";
		}else 
		{
			amOrPm = "am";
		}
		
		
		 String[] digits = Integer.toString(Player.coins).split("");

	        for (int i = 0; i < digits.length; i++) {
	            g.setFont(Fonts.altMediumFont);
	        	g.drawString(digits[i], (float) (1702 + i * 24.1), 1080 -  825 - 60);
	        }
	    
		
		g.setFont(Fonts.mediumFont);
		g.drawString(hour + ":00" + amOrPm, 1700 + 50 , 1080 - 900 - 10 - 60);
		g.drawString("Day: " + Game.numDays, 1700 + 50, 1080-989-10 - 60);
		
	}
	
	public void draw(Graphics g, int corn, int cornSeeds, int tomato, int tomatoSeeds, int blueBerry,
			int blueBerrySeeds, int carrot, int carrotSeeds, int coins) 
	{
		
		//Top Panel
		panelDraw(g);
		
		// Energy Bar
		energyBar.render(g);
		
		
		//Boxes
		drawBoxes(g);
		
		//Tool Bar
		for(int i = 0; i < tools.length; i++) 
		{
			tools[i].draw(g);
			
			
		}
		
		// Tool for swap
		if(swapTool != null && swapTool.getImage() != null)
			g.drawImage(swapTool.getImage(),Mouse.getX(), Main.getScreenHeight() - Mouse.getY());
	}
	
	public void drawInventoryBar(Graphics g) 
	{
		g.setColor(Color.gray);
		g.fillRect(Main.getScreenWidth() - Game.tileSize * 4, 0, Game.tileSize * 4, Game.tileSize * 4);
		
		
		
		
	}
	
	public void drawBoxes(Graphics g) 
	{
		 //Boxes
		for(int i = 0; i < maxInventory; i++) 
		{
			g.setFont(Fonts.fontSmall);
			g.setColor(Color.gray);
			g.drawImage(Images.box,  offset  +  i * Game.tileSize, 1000);
			
			g.setFont(Fonts.fontSmall);
			g.setColor(Color.red);
			g.drawRect(offset + 6  +  UInum * Game.tileSize, 1006, 50,50);
			
			g.setFont(Fonts.fontSmall);
			g.setColor(Color.white);
			g.drawString("" + (i + 1 ), offset + 6 + i * Game.tileSize, 1006);
		}
	}
	
	public void swapTool(GameContainer gc) 
	{
		input = gc.getInput();
		if(input.isMousePressed(Input.MOUSE_RIGHT_BUTTON))//input.isKeyPressed(Input.KEY_Z)
		{

			if(swapTool == null && boxMouseOver() != 999) 
			{
				int bMO = boxMouseOver();
				swapTool = tools[bMO].getTool();
				tools[bMO].setTool(null);
				swapToolIndex = bMO;
			}
			
			else if(swapTool != null && boxMouseOver() != 999) 
			{
				int bMO = boxMouseOver();	
				tools[swapToolIndex].setTool(tools[bMO].getTool());
				tools[bMO].setTool(swapTool);
				swapTool = null;
				
			}
		}
	}
	
	public int boxMouseOver() 
	{
		int mX = Mouse.getX();
		int mY = Mouse.getY();
		
		if(Main.getScreenHeight() - Mouse.getY() > 1016 && Main.getScreenHeight() - Mouse.getY() < 1016 + Game.tileSize) 
		{
			if(mX > 0 * (Game.tileSize) + offset && mX < 0 * (Game.tileSize) + (5/4) * (Game.tileSize) + offset)
				return 0;
			if(mX > 1 * (Game.tileSize) + offset && mX < 1 * (Game.tileSize) + (5/4) * (Game.tileSize) + offset)
				return 1;
			if(mX > 2 * (Game.tileSize) + offset && mX < 2 * (Game.tileSize) + (5/4) * (Game.tileSize) + offset)
				return 2;
			if(mX > 3 * (Game.tileSize) + offset && mX < 3 * (Game.tileSize) + (5/4) * (Game.tileSize) + offset)
				return 3;
			if(mX > 4 * (Game.tileSize) + offset && mX < 4 * (Game.tileSize) + (5/4) * (Game.tileSize) + offset)
				return 4;
			if(mX > 5 * (Game.tileSize) + offset && mX < 5 * (Game.tileSize) + (5/4) * (Game.tileSize) + offset)
				return 5;
			if(mX > 6 * (Game.tileSize) + offset && mX < 6 * (Game.tileSize) + (5/4) * (Game.tileSize) + offset)
				return 6;
			if(mX > 7 * (Game.tileSize) + offset && mX < 7 * (Game.tileSize) + (5/4) * (Game.tileSize) + offset)
				return 7;
			if(mX > 8 * (Game.tileSize) + offset && mX < 8 * (Game.tileSize) + (5/4) * (Game.tileSize) + offset)
				return 8;
			
		}
		
		return 999;
			
	}
	
	public void checkChanges(GameContainer gc) 
	{
		boolean cornOnBar = false;
		boolean carrotOnBar = false;
		boolean blueberryOnBar = false;
		boolean tomatoOnBar = false;
		boolean cornSeedsOnBar = false;
		boolean carrotSeedsOnBar = false;
		boolean tomatoSeedsOnBar = false;
		boolean blueberrySeedsOnBar = false;
		boolean sprinklerOnBar = false;
		boolean eggOnBar = false;
		boolean woolOnBar = false;
		boolean milkOnBar = false;
		boolean pickaxeOnBar = false;
		boolean copperOreOnBar = false;
		
		for(int i = 0; i < tools.length; i++) 
		{
			
			if(tools[i].getTool() != null && tools[i].getTool().getNum() == 6 || swapTool != null && swapTool.getNum() == 6)
				cornOnBar = true;
			if(tools[i].getTool() != null && tools[i].getTool().getNum() == 7 || swapTool != null && swapTool.getNum() == 7)
				carrotOnBar = true;
			if(tools[i].getTool() != null && tools[i].getTool().getNum() == 8 || swapTool != null && swapTool.getNum() == 8)
				blueberryOnBar = true;
			if(tools[i].getTool() != null && tools[i].getTool().getNum() == 9 || swapTool != null && swapTool.getNum() == 9)
				tomatoOnBar = true;
			if(tools[i].getTool() != null && tools[i].getTool().getNum() == 2|| swapTool != null && swapTool.getNum() == 2)
				cornSeedsOnBar = true;
			if(tools[i].getTool() != null && tools[i].getTool().getNum() == 10 || swapTool != null && swapTool.getNum() == 10)
				carrotSeedsOnBar = true;
			if(tools[i].getTool() != null && tools[i].getTool().getNum() == 12 || swapTool != null && swapTool.getNum() == 12)
				blueberrySeedsOnBar = true;
			if(tools[i].getTool() != null && tools[i].getTool().getNum() == 11 || swapTool != null && swapTool.getNum() == 11)
				tomatoSeedsOnBar = true;
			if(tools[i].getTool() != null && tools[i].getTool().getNum() == 13 || swapTool != null && swapTool.getNum() == 13)
				sprinklerOnBar = true;
			if(tools[i].getTool() != null && tools[i].getTool().getNum() == 14 || swapTool != null && swapTool.getNum() == 14)
				eggOnBar = true;
			if(tools[i].getTool() != null && tools[i].getTool().getNum() == 15 || swapTool != null && swapTool.getNum() == 15)
				milkOnBar = true;
			if(tools[i].getTool() != null && tools[i].getTool().getNum() == 16 || swapTool != null && swapTool.getNum() == 16)
				woolOnBar = true;
			if(tools[i].getTool() != null && tools[i].getTool().getNum() == 4 || swapTool != null && swapTool.getNum() == 4)
				pickaxeOnBar = true;
			if(tools[i].getTool() != null && tools[i].getTool().getNum() == 17 || swapTool != null && swapTool.getNum() == 17)
				copperOreOnBar = true;
			
			// Experiment
			
			if(copperOreOnBar == true && p.hasCopper() == false) 
			{
				tools[i].setTool(null);
				return;
			}
			
			if(pickaxeOnBar == true && p.hasPickaxe() == false) 
			{
				tools[i].setTool(null);
				return;
			}
				
				if(sprinklerOnBar == true && !p.hasSprinkler())
			{
				tools[i].setTool(null);
				return;
			}	
				
			if(cornOnBar == true && !p.hasCorn()) 
			{
				tools[i].setTool(null);
				return;
			}
				
			if(carrotOnBar == true && !p.hasCarrot())
			{
				tools[i].setTool(null);
				return;
			}
			
			if(blueberryOnBar == true && !p.hasBlueberry())
			{
				tools[i].setTool(null);
				return;
			}
			
			if(tomatoOnBar == true && !p.hasTomato())
			{
				tools[i].setTool(null);
				return;
			}
			
			if(cornSeedsOnBar == true && !(p.cornSeeds > 0)) 
			{
				tools[i].setTool(null);
				return;
			}
				
			if(carrotSeedsOnBar == true && !(p.carrotSeeds > 0))
			{
				tools[i].setTool(null);
				return;
			}
			
			if(blueberrySeedsOnBar == true && !(p.blueberrySeeds > 0))
			{
				tools[i].setTool(null);
				return;
			}
			
			if(tomatoSeedsOnBar == true && !(p.tomatoSeeds > 0))
			{
				tools[i].setTool(null);
				return;
			}
			
			if(woolOnBar == true && !(p.wool > 0))
			{
				tools[i].setTool(null);
				return;
			}
			
			if(eggOnBar == true && !(p.eggs > 0))
			{
				tools[i].setTool(null);
				return;
			}
			
			if(milkOnBar == true && !(p.milk > 0))
			{
				tools[i].setTool(null);
				return;
			}
			
			
		}
		
		
		if(findEmptySlot() != - 1) 
		{
			if(copperOreOnBar == false && p.hasCopper()) 
			{
				tools[findEmptySlot()].setTool(p.getCopperOre());
				return;
			}
				
			
			if(cornOnBar == false && p.hasCorn())
				{tools[findEmptySlot()].setTool(p.getCornItem());
			return;
		}
			
			if(carrotOnBar == false && p.hasCarrot())
				{tools[findEmptySlot()].setTool(p.getCarrotItem());
			return;
		}
			
			if(blueberryOnBar == false && p.hasBlueberry())
				{tools[findEmptySlot()].setTool(p.getBlueberryItem());
			return;
		}
			
			if(tomatoOnBar == false && p.hasTomato())
			{	tools[findEmptySlot()].setTool(p.getTomatoItem());
			return;
		}
			
			if(cornSeedsOnBar == false && p.cornSeeds > 0)
			{		tools[findEmptySlot()].setTool(p.getCornPack());
			return;
		}
			
			if(carrotSeedsOnBar == false && p.carrotSeeds > 0)
			{	tools[findEmptySlot()].setTool(p.getCarrotPack());
			return;
			}
			if(blueberrySeedsOnBar == false && p.blueberrySeeds > 0)
			{	tools[findEmptySlot()].setTool(p.getBlueberryPack());
			return;
			}
			if(tomatoSeedsOnBar == false && p.tomatoSeeds > 0)
			{	tools[findEmptySlot()].setTool(p.getTomatoPack());
			return;
			}
			if(sprinklerOnBar == false && p.sprinklers > 0) 
			{
				tools[findEmptySlot()].setTool(p.getSprinklerItem());
				return;
			}
			
			if(milkOnBar == false && p.milk > 0) 
			{
				tools[findEmptySlot()].setTool(p.getMilkItem());
				return;
			}
			
			if(eggOnBar == false && p.eggs > 0) 
			{
				tools[findEmptySlot()].setTool(p.getEggItem());
				return;
			}
			
			if(woolOnBar == false && p.wool > 0) 
			{
				tools[findEmptySlot()].setTool(p.getWoolItem());
				return;
			}
			
			if(pickaxeOnBar == false && p.hasPickaxe() == true) 
			{
				tools[findEmptySlot()].setTool(p.getPickaxe());
				return;
			}
			
		}
		
		
		
	} 
	
	public void update(GameContainer gc) 
	{
		//Basic Button Press	
		input = gc.getInput();
		swapTool(gc);
		checkChanges(gc);
		
		// Tool Bar Selection
		if(input.isKeyPressed(Input.KEY_1)) 
		{
			if(tools[0].getTool() != null)
				lastNum = tools[0].getTool().getNum();
			UInum = 0;
		} 
			
		if(input.isKeyPressed(Input.KEY_2)) 
		{
			if(tools[1].getTool() != null)
				lastNum = tools[1].getTool().getNum(); 
			UInum = 1;
		} 
			
		if(input.isKeyPressed(Input.KEY_3)) 
		{
			if(tools[2].getTool() != null)
				lastNum = tools[2].getTool().getNum(); 
			UInum = 2;
		}
			
		if(input.isKeyPressed(Input.KEY_4)) 
		{
			if(tools[3].getTool() != null)	
				lastNum = tools[3].getTool().getNum();
			UInum = 3;
		} 
			
		if(input.isKeyPressed(Input.KEY_5)) 
		{
			if(tools[4].getTool() != null)
				lastNum = tools[4].getTool().getNum();
			UInum = 4;
		} 
			
		if(input.isKeyPressed(Input.KEY_6)) 
		{
			if(tools[5].getTool() != null)
				lastNum = tools[5].getTool().getNum(); 
			UInum = 5;
		} 
			
		if(input.isKeyPressed(Input.KEY_7)) 
		{
			if(tools[6].getTool() != null)
				lastNum = tools[6].getTool().getNum(); 
			UInum = 6;
		} 
			
		if(input.isKeyPressed(Input.KEY_8)) 
		{
			if(tools[7].getTool() != null)
				lastNum = tools[7].getTool().getNum(); 
			UInum = 7;
		} 
			
		if(input.isKeyPressed(Input.KEY_9)) 
		{
			if(tools[8].getTool() != null)
				lastNum = tools[8].getTool().getNum(); 
			UInum = 8;
		} 
			
		
		// Seed Bar Selection
		if(input.isKeyPressed(Input.KEY_E)) 
			lastSeedNum = 1;
		if(input.isKeyPressed(Input.KEY_R)) 
			lastSeedNum = 2;
		if(input.isKeyPressed(Input.KEY_T)) 
			lastSeedNum = 3;
		if(input.isKeyPressed(Input.KEY_Y)) 
			lastSeedNum = 4;
	}
	
	public boolean mouseOver(int x, int y) 
	{
		
		int mX = Mouse.getX();
		int mY = Mouse.getY();
	
		//System.out.println("PLEASE WORK" + x);
		
		if(mX > offset  +  x * Game.tileSize && mX < offset  +  x * Game.tileSize + Game.tileSize + Game.tileSize * (1/4))
			if(Main.getScreenHeight() - Mouse.getY() > y && Main.getScreenHeight() - Mouse.getY() < y + Game.tileSize)
				return true;
		return false;
	}

	
	public int getLastNum() 
	{
		return lastNum;
	}
	
	public int getLastSeedNum() 
	{
		return lastSeedNum;
	}

	
}



