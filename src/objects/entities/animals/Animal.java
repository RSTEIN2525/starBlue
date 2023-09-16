package objects.entities.animals;

import java.sql.Time;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import core.Game;
import objects.entities.Entity;
import terrain.Tile;

public class Animal extends Entity{
	int health = 100;
	Tile t;
	int col = getX() / Game.tileSize;
	int row = getY() / Game.tileSize;
	Animal[][] a;
int x = 0;
int y = 0;
	public static int timer = 0;
	public Animal (Tile t, int x, int y) 
	{
		this.t = t;
		this.x = x;
		this.y = y;
	}
	
	
	
	public void render(Graphics g, int x, int y)
	{
		
	}
	
	public void setAnimalArray(Animal[][] a)  
	{
		this.a = a;
	}
	
	public void setStrings(String s, String z, String q, String e) {}
	
	public int getRow() 
	{
		return 0;
	}
	
	public Animal[][] getAnimalArray()
	{
		return a;
	}
	
	public boolean hasAnimal(int row, int col) 
	{
//		if(getAnimal(row, col) != null)
//			return true;
//		return false;
		
		return(a[row][col] != null);
		
		
	}
	
	public int getCol() 
	{
		return 0;
	}
	
	public Animal getAnimal() 
	{
		return this;
	}
	
	public void update(GameContainer gc) 
	{
		timer();
		produce();
		
		
		
	}
	
public void produce(){
	
		
	}
	
	public int getX() 
	{
		return x;
	}
	
	public int getY() 
	{
		return y;
	}
	
	public Tile getTile() 
	{
		return t;
	}
	public void timer() {
		
		timer++;
		if(timer>3000) {
			timer=0;
		}
		
	}
	
}
