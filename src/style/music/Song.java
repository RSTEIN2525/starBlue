package style.music;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class Song {
	private String file;
	private Music music;
	private Sound effect;
	
	Song(String file)
	{
		this.file = file;
	}
	
	public void loadMusic() throws SlickException
	{		
		music = new Music(file);
		music.loop();
	}
	public void loadEffect() throws SlickException
	{
		effect = new Sound(file);
		effect.play();
	}
	public boolean isLoaded()
	{
		return music != null;
	}
}





