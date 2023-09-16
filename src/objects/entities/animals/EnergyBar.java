package objects.entities.animals;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import core.Game;
import core.Main;
import objects.entities.Player;
import objects.entities.PlayerHUD;
import style.Fonts;

public class EnergyBar extends PlayerHUD {

	public static float MAX_ENERGY = 300;
	float Offset = MAX_ENERGY / 6;
	int borderOffset = 10;
	
	public EnergyBar(Player p) {
		super(p);
		// TODO Auto-generated constructor stub
	}
	
	public void render(Graphics g) 
	{
		g.setFont(Fonts.fontSmall);
		g.setColor(Color.blue);
		String str = p.getEnergy() + "/" + (int)MAX_ENERGY;
		if(p.getEnergy() > 0)
		{
			g.drawString(str ,Main.getScreenWidth() - MAX_ENERGY / 5 - Offset, Main.getScreenHeight() - MAX_ENERGY / 2 - Offset - 20);
		}
		else g.drawString(0 + "/" + (int)MAX_ENERGY ,Main.getScreenWidth() - MAX_ENERGY / 5 - Offset, Main.getScreenHeight() - MAX_ENERGY / 2 - Offset - 20);
		
		//Vessel
		g.setColor(Color.black);
		g.fillRect(Main.getScreenWidth() - MAX_ENERGY / 5 - Offset - borderOffset/2, Main.getScreenHeight()
				- MAX_ENERGY / 2 - Offset - borderOffset/2,  MAX_ENERGY / 5 + borderOffset, MAX_ENERGY / 2 + borderOffset);
		
		//GreyUnderBox
		g.setColor(Color.gray);
		g.fillRect(Main.getScreenWidth() - MAX_ENERGY / 5 - Offset, Main.getScreenHeight()
				- MAX_ENERGY / 2 - Offset,  MAX_ENERGY / 5, MAX_ENERGY / 2);
		
		//Energy
		float boxHeight = MAX_ENERGY / 2;
		float energyFraction =  p.getEnergy() / MAX_ENERGY;
		float generalY = Main.getScreenHeight() - boxHeight - Offset;
		float drawY = boxHeight + generalY - (boxHeight * energyFraction); //  (1 + (energyFraction / boxHeight)) * generalY
		float height = (generalY + boxHeight) - drawY;
		
		
		//g.drawString("Energy: " + p.getEnergy() + " Frac: " + energyFraction + "GenY: " + generalY + "drawY: " + drawY + "Height: " + height, 300	,300);

		g.setColor(Color.blue);
		if(energyFraction > 0)
		g.fillRect(Main.getScreenWidth() - MAX_ENERGY / 5 - Offset, drawY, MAX_ENERGY / 5, height);
	
	}

}


