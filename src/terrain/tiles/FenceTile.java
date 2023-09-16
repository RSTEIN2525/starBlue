package terrain.tiles;

import org.newdawn.slick.Graphics;

import core.Game;
import style.Images;

public class FenceTile extends BoulderTile{

	public FenceTile(int x, int y, boolean moisture) {
		super(x, y, moisture);
		this.x = x;
		this.y = y;
		this.playersX = y;
		// TODO Auto-generated constructor stub
	}
	
	public void render(Graphics g, int screenX, int screenY) 
	{

		if((this.x/Game.tileSize==Game.worldManager.startfencei)||(this.x/Game.tileSize==Game.worldManager.endfencei)) {

			if((this.y/Game.tileSize!=Game.worldManager.startfencej)&&(this.y/Game.tileSize!=Game.worldManager.endfencej)) {
		g.drawImage(Images.grass,screenX,screenY);
		
		
		
		if(this.x/Game.tileSize==Game.worldManager.endfencei) {
			
			g.drawImage(Images.fencePostHorizontal.getScaledCopy(64, 100),screenX+46,screenY);
			g.drawImage(Images.fencePostHorizontal.getScaledCopy(64, 100),screenX+46,screenY-32);
			g.drawImage(Images.fencePostHorizontal.getScaledCopy(64, 100),screenX+46,screenY+32);
		}
		else {
			g.drawImage(Images.fencePostHorizontal.getScaledCopy(64, 100),screenX,screenY-32);
			g.drawImage(Images.fencePostHorizontal.getScaledCopy(64, 100),screenX,screenY+32);
		}
			}
			else {
				g.drawImage(Images.grass,screenX,screenY);
				
				if(this.y/Game.tileSize==Game.worldManager.startfencej) {
					g.drawImage(Images.fencepostset.getScaledCopy(64, 64),screenX,screenY);
				}
				else
				g.drawImage(Images.fencepostset.getScaledCopy(64, 64),screenX,screenY+-32);
				
			}
			
		}
		
		else {
			if(this.y/Game.tileSize==Game.worldManager.endfencej) {
				g.drawImage(Images.grass,screenX,screenY);
				g.drawImage(Images.fencepostset.getScaledCopy(64, 64),screenX,screenY-32);	
			}
			else {
			g.drawImage(Images.grass,screenX,screenY);
			g.drawImage(Images.fencepostset.getScaledCopy(64, 64),screenX,screenY);
			}
		}
	}

	
}
