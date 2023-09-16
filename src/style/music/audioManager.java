package style.music;

import org.newdawn.slick.SlickException;

public class AudioManager {
	static Song gameMusic;
	static Song curEffect;

	public static void loadMusic() throws SlickException 
	{
		Sounds.loadSongList();
		Sounds.loadEffectList();
		setRandomGameMusic();
		playGameMusic();
	}
	
	public static Song getGameMusic()
	{
		return gameMusic;
	}
	public static Song getGameEffect()
	{
		return curEffect;
	}
	
	public static void setRandomGameMusic() throws SlickException
	{		
		gameMusic = Sounds.getRandomSong();
	}
	public static void playGameMusic() throws SlickException
	{
		if(gameMusic == null)
		{
			setRandomGameMusic();
		}
			
		if(!gameMusic.isLoaded())
		{
			gameMusic.loadMusic();
		}			
	}
	public static void playEffect(int effect) throws SlickException
	{
		curEffect = Sounds.getEffect(effect);
			
		if(!curEffect.isLoaded())
		{
			curEffect.loadEffect();
		}			
	}
}



