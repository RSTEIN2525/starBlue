package objects.entities.animals;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import core.Game;
import core.Vanishanimation;
import objects.entities.Player;
import style.Images;
import terrain.Tile;

public class Sheep extends Cow{

	public Sheep(Tile t, int x, int y) {
		super(t, x, y);
		// TODO Auto-generated constructor stub
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
						health = health -2;

					}
				}
				if(health<=0) {
//System.exit(0);
					Game.worldManager.deleteAnimal(row,col);
					Player.sheep-=1;
					Game.worldManager.vanishanimations.add(new Vanishanimation(x,y));
				}
				g.setColor(Color.blue);
				
			}
	public void render(Graphics g, int x, int y) 
	{
		
if(timer<500) {
			
			g.drawImage(Images.sheep1.getScaledCopy(64,64),x,y);
		
		}
		else {
			g.drawImage(Images.sheep2.getScaledCopy(64,64), x,y);
		}
		
		produce();
		health(g,x,y);

	}
	public void produce(){

			
		if (Game.changedDayNight && Math.random() <= .8)
			health -=10;
	
	
		if (Game.changedDayNight && Math.random() <= 0.33) {
			
			Game.worldManager.addAnimalproduct( row,  col, 3);

		}
	}
}
