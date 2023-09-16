package style.music;

import java.util.ArrayList;

import org.newdawn.slick.SlickException;

public class Sounds {
	
static ArrayList<Song> songs;
static ArrayList<Song> effects;
	
	public static void loadGameMusicFile(Song m) throws SlickException
	{
		m.loadMusic();
	}
	
	public static int random(int min, int max) 
	{		
		return (int) (Math.random() * (max - min + 1)) + min;
	}
	
	public static Song getRandomSong()
	{
		return songs.get(random(0, songs.size()-1));	
	}
	
	public static Song getEffect(int effect)
	{
		return effects.get(effect);
	}
	static void loadSongList() throws SlickException 
	{		
		songs = new ArrayList<Song>();
		songs.add(new Song("res/music/Heftone-Banjo-Orchestra-Music-Bo.ogg"));		
		songs.add(new Song("res/music/Heftone-Banjo-Orchestra-Peaceful.ogg"));
		songs.add(new Song("res/music/Heftone-Banjo-Orchestra-St-Louis.ogg"));	
		songs.add(new Song("res/music/Heftone-Banjo-Orchestra-Whistlin.ogg"));
		// credit to heftone banjo orchestra for music
		// got music on fma
	}
	static void loadEffectList() throws SlickException
	{
		effects = new ArrayList<Song>();
		effects.add(new Song("res/music/tilling-soil-effect.ogg"));
		effects.add(new Song("res/music/swoosh.ogg"));
		effects.add(new Song("res/music/pickaxe.ogg"));
	}
}



