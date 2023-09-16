package core;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import style.Images;

public class SlashAnimation {

	public int timer = 0;
	public int x = 0;
	public int y = 0;
	Image i = Images.vanish7;
	ArrayList<Image> images = new ArrayList<Image>();
	
	public int imagenumber = 0;
	public SlashAnimation(int x, int y){
		this.x = x;
		this.y = y;
		
	
		images.add(Images.slash1);
		images.add(Images.slash2);
		images.add(Images.slash3);
		images.add(Images.slash4);
		images.add(Images.slash5);
		images.add(Images.slash6);
		images.add(Images.slash7);
		images.add(Images.slash8);
		images.add(Images.vanish7);

	}
	
	public void render(Graphics g)
	{
	timer+=1;
		if(timer %2==0) {
			if(imagenumber!=8) {
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
