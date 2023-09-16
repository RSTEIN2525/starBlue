package style;



import java.awt.Font;
import org.newdawn.slick.TrueTypeFont;

public class Fonts 
{
	public static TrueTypeFont textFont;
	public static TrueTypeFont titleFont;
	
	public static TrueTypeFont fontSmall;
	public static TrueTypeFont fontLarge;
	
	public static TrueTypeFont slotsFontLarge;
	
	public static TrueTypeFont fontXLarge;
	
	public static TrueTypeFont mediumFont;
	public static TrueTypeFont altMediumFont;
	
	public static TrueTypeFont starBlueValley;
	
	public static void loadFonts() 
	{	
		
		TrueTypeFont starBlueValley = new TrueTypeFont(new Font("res/Stardew_Valley.ttf", Font.PLAIN, 48), false);
		
		
		
		textFont = new TrueTypeFont(new Font("Cooper Black", Font.PLAIN, 50), false);
		
		fontSmall = new TrueTypeFont(new Font("Cooper Black", Font.ROMAN_BASELINE, 14), false);
		fontLarge = new TrueTypeFont(new Font("Cooper Black", Font.ROMAN_BASELINE, 40), false);
		fontXLarge = new TrueTypeFont(new Font("Cooper Black", Font.ROMAN_BASELINE, 50), false);
		
		mediumFont = new TrueTypeFont(new Font("Cooper Black", Font.ROMAN_BASELINE, 30), false);
		altMediumFont = new TrueTypeFont(new Font("Cooper Black", Font.ROMAN_BASELINE, 26), false);

		
	}
}


