package Marketitems;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import core.Main;
import style.Images;

public class Explosioncluster {

	
	int x;
	int y;
	String symbol;
	int amount;
	
	ArrayList<Explosionimage> explosionimages = new ArrayList<Explosionimage>();
	
	
	public Explosioncluster(String symbol, int amount, int x, int y){
		
		this.x = x;
		this.y = y;
		this.symbol = symbol;
		

		for(int i = 0; i<amount;i++) {
			
			explosionimages.add((new Explosionimage(this.x,this.y,symbol)));
			
		}
	}
//	
//	public Explosioncluster(String symbol, int count, int x, int y, int power, boolean leveled) {
//
//		this.x = x;
//		this.y = y;
//		this.symbol = symbol;
//
//		for(int i = 0; i<amount;i++) {
//			
//			explosionimages.add((new Explosionimage(this.x,this.y,symbol,power,leveled)));
//			
//		}
//	}

	public void render(Graphics g) {

//		for(Explosionimage e : explosionimages) {
//			e.render(g);
//			
//			if(e.y>Main.getScreenHeight()) {
//				explosionimages.remove(e);
//				
//			}
//		}
		
		
		for(int i = 0;i<explosionimages.size();i++) {
			if((explosionimages.get(i)!=null)&&(explosionimages.size()>3)) {
			explosionimages.get(i).render(g);
			
			if(!symbol.equals("water")) {
			if(explosionimages.get(i).y>Main.getScreenHeight()) {
				explosionimages.remove(i);
				if(y!=0) {
				i--;
				}
				
			}
			}

		}

		}
	}
	


	
	
	
}


