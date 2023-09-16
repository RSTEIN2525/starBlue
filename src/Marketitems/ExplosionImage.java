package Marketitems;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import style.Images;

public class Explosionimage {

	
	public float x;
	public float y;
	
	public float xspeed;
	public float yspeed;
	
	public Image image;
	
	public String symbol;
	public float rotatenumber;
	public float starty;
	public Explosionimage(float x, float y,String symbol) {
		this.starty = y;
		this.symbol = symbol;
		xspeed = -10+(int)(Math.random()*21);
		yspeed = -20+(int)(Math.random()*11);
		
		this.rotatenumber = (float)(Math.random()-0.5);
		this.x = x;
		this.y = y;
		
		
		if(symbol.equals("chicken")) {
			this.image = Images.chicken1;
		}
		if(symbol.equals("cow")) {
			this.image = Images.cow1;
		}
		if(symbol.equals("sheep")) {
			this.image = Images.sheep1;
		}
		if(symbol.equals("corn")) {
			this.image = Images.cornShop;
		}
		if(symbol.equals("tomato")) {
			this.image = Images.tomato;
		}
		if(symbol.equals("carrot")) {
			this.image = Images.carrot;
		}
		if(symbol.equals("blueberry")) {
			this.image = Images.blueberry;
		}
		
		//seed images
		if(symbol.equals("cornseed")) {
			this.image = Images.cornSeeds;
		}
		if(symbol.equals("carrotseed")) {
			this.image = Images.carrotSeeds;
		}
		if(symbol.equals("blueberryseed")) {
			this.image = Images.blueberrySeeds;
		}
		if(symbol.equals("tomatoseed")) {
			this.image = Images.tomatoSeeds;
		}		
		
		
		
		
		if(symbol.equals("milk")){
			this.image=Images.milk1;
		}
		if(symbol.equals("egg")){
			this.image=Images.egg1;
		}
		if(symbol.equals("wool")){
			this.image=Images.wool1;
		}
		
		if(symbol.equals("rockfragment")) {
			this.image=Images.rockfragment;
		}
		
		if(symbol.equals("copperfragment")) {
			this.image=Images.copperore.getScaledCopy(16,16);
		}
		
		if(symbol.equals("fence")) {
			this.image=Images.fencePostHorizontal;
		}
		if(symbol.equals("water")) {
			this.image = Images.droplet;
			
		}
		
		if(symbol.equals("pickaxe")) {
			this.image = Images.pickaxe.getScaledCopy(64,64);
			
		}
		
		if(symbol.equals("bridge")) {
			this.image = Images.bridge.getScaledCopy(64,64);
			
		}
		
		
		if(symbol.equals("sprinkler")) {
			this.image = Images.sprinklerMarket;
			
		}
		
		if(symbol.equals("coffee")) {
			this.image = Images.coffee.getScaledCopy(100,100);
				
			}
		
		if(symbol.equals("boots")) {
			this.image = Images.boots.getScaledCopy(100,100);
				
			}
		
	}
	
	
//	
//	
//	public Explosionimage(int x, int y,String symbol, int power, boolean leveled) {
//		xspeed = -10+(int)(Math.random()*21);
//		yspeed = -20+(int)(Math.random()*11);
//		
//		this.rotatenumber = (float)(Math.random()-0.5);
//		this.x = x;
//		this.y = y;
//		
//		
//	
//		if(symbol.equals("rockfragment")) {
//			this.image=Images.rockfragment;
//		}
//		
//	}
//	
	
	
	
	public void render(Graphics g) {



if(symbol.equals("rockfragment") || symbol.equalsIgnoreCase("copperfragment")) {
	yspeed=yspeed+(float)1.5;
	x=x+(xspeed/5);
	y=y+(yspeed/3);
	if(y>starty) {
		yspeed = 0;
	
	}
	if(y>starty+10) {
		image = Images.vanish7;
	}
}




if(symbol.equals("water")) {
	
	
	
//	starty +=128*Math.random()-64;

	float baseline = (starty+128);
	yspeed=yspeed+(float)(0.4);
	x=x+(xspeed/5);
	y=y+(yspeed/3);
	if(y>baseline) {
		yspeed = 0;
		image = Images.vanish7;
	}

	
	
	
	
	
	
	
}
else {
	yspeed=yspeed+(float).5;
	x=x+xspeed;
	y=y+yspeed;
}


image.rotate((float).05);
	g.drawImage(image,x,y);
	}
	
}
