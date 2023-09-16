package objects.entities.animals;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import core.Game;
import core.Vanishanimation;
import objects.entities.Player;
import style.Images;
import terrain.Tile;

public class Cow extends Animal{
	
	int movementTimer = 0;
	int row;
	int col;
	String tileAbove;
	String tileBelow;
	String tileRight;
	String tileLeft;
	
//
//	public static ArrayList<Animalproduct> milks = new ArrayList<Animalproduct>();
	public Cow(Tile t, int x, int y) 
	{
		super(t,x,y);

		col = getX() / Game.tileSize;
		row = getY() / Game.tileSize;
	}
	
	
	
	public void health(Graphics g, int x, int y) {

		g.setColor(Color.gray);		
				g.fillRect(x,y,Game.tileSize, 5);
				if(health>75) {
				g.setColor(Color.green);
				}
				else if(health>50) {
					g.setColor(Color.yellow);
					
				}
				else if(health>25) {
					g.setColor(Color.orange);
				}
				else {
					g.setColor(Color.red);
				}
				g.fillRect(x, y, (float)health/100*Game.tileSize, 5);
				if(timer %200==0) {

					if(Math.random()<0.5) {
						health = health -1;

					}
				}
				if(health<=0) {
					Game.worldManager.deleteAnimal(row,col);
					Game.worldManager.vanishanimations.add(new Vanishanimation(x,y));
//System.exit(0);
					
					Player.cows-=1;
				}
				g.setColor(Color.blue);
	
			}
	public void render(Graphics g, int x, int y) {
		
		
health(g,x,y);
		if(timer<500) {
			
			g.drawImage(Images.cow1.getScaledCopy(64,64),x,y);
		
		}
		else {
			g.drawImage(Images.cow2.getScaledCopy(64,64), x,y);
		}

	}
	
	public Animal getAnimal() 
	{
		return this;
	}
	
	public void setStrings(String s1, String s2, String s3, String s4) 
	{
		tileAbove = s1;
		tileBelow = s2;
		tileRight = s3;
		tileLeft = s4;
	}
	
	public void update(GameContainer gc) 
	{
		timer();
		produce();
		int rand = (int) (Math.random() * 4) + 1;
		
		
		if(movementTimer > 0)
			movementTimer --;
		
		
		
		if(rand == 1 && movementTimer == 0 && !(tileBelow.equalsIgnoreCase("FenceTile") || tileBelow.equalsIgnoreCase("BoulderTile")) && !hasAnimal(row + 1, col)) 
		{
			row++;
			movementTimer = 60;
		}
		if(rand == 2 && movementTimer == 0 && !(tileAbove.equalsIgnoreCase("FenceTile") || tileAbove.equalsIgnoreCase("BoulderTile")) && !hasAnimal(row - 1, col))
		{
			row--;
			movementTimer = 60;
		}
		if(rand == 3 && movementTimer == 0 && !(tileRight.equalsIgnoreCase("FenceTile") || tileRight.equalsIgnoreCase("BoulderTile")) && !hasAnimal(row, col + 1)) 
		{
			col++;
			movementTimer = 60;
		}
		if(rand == 4&& movementTimer == 0 && !(tileLeft.equalsIgnoreCase("FenceTile") || tileLeft.equalsIgnoreCase("BoulderTile")) && !hasAnimal(row, col - 1))
		{
			col--;
			movementTimer = 60;
		}
		
	}
	
	public int getRow() 
	{
		return row;
	}
	
	public int getCol() 
	{
		return col;
	}
	
public void produce(){
	System.out.println(Animal.timer+ " timer");
		
	if (Game.changedDayNight && Math.random() <= .8)
		health -=10;


	if (Game.changedDayNight && Math.random() <= 0.33) {
		
		Game.worldManager.addAnimalproduct( row,  col, 1);

	}
}
	
}
