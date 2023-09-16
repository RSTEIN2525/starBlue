package core;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import style.Images;
import style.music.AudioManager;

public class Title extends BasicGameState 
{	
	private int id;
	private StateBasedGame sbg;
	public Title(int id) 
	{
		this.id = id;
	}

	public int getID() 
	{
		return id;		
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException 
	{
		this.sbg = sbg;
		Images.loadImages();
		AudioManager.loadMusic();
		
		
	}


	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{	
		// This is updates your game's logic every frame.  NO DRAWING.
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException 
	{
		g.drawImage(Images.titleScreen, 0,0);
		// This code renders shapes and images every frame.
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
		
		if (key == Input.KEY_SPACE) 
	    {
		  sbg.enterState(Main.GAME_ID);
	    }
		// This code happens every time the user presses a key
	}

	public void mousePressed(int button, int x, int y)
	{
		// This code happens every time the user presses the mouse
	}




}
