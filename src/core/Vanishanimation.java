package core;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import style.Images;

public class Vanishanimation {

	public int timer = 0;
	public int x = 0;
	public int y = 0;
	Image i = Images.vanish7;
	ArrayList<Image> images = new ArrayList<Image>();
	
	public int imagenumber = 0;
	public Vanishanimation(int x, int y){
		this.x = x;
		this.y = y;
		
	
		images.add(Images.vanish1);
		images.add(Images.vanish2);
		images.add(Images.vanish3);
		images.add(Images.vanish4);
		images.add(Images.vanish5);
		images.add(Images.vanish6);
		images.add(Images.vanish7);
	}
	
	public void render(Graphics g)
	{
	timer+=1;
		if(timer %2==0) {
			if(imagenumber!=6) {
			imagenumber+=1;
			}
//			else {
//				imagenumber = 0;
//			}
		}
		i = images.get(imagenumber);
		
		g.drawImage(i,x,y);
		
		
	}
	
}
