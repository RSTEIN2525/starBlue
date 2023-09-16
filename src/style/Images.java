package style;
import java.io.ObjectInputStream.GetField;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Images 
{
	public static Image box;
	public static Image hoe;
	
	
	
	public static Image corn;
	public static Image carrot;
	public static Image blueberry;
	public static Image tomato;
	
	
	
	public static Image scythe;
	public static Image playerRight;
	public static Image playerLeft;
	public static Image playerUp;
	public static Image playerDown;
	public static Image grass;
	public static Image soil;
	public static Image boulder;
	public static Image boulder2;
	public static Image boulder3;
	
	
	
	public static Image cornSeeds;
	public static Image tomatoSeeds;
	public static Image blueberrySeeds;
	public static Image carrotSeeds;
	public static Image growingCorn;
	public static Image grownCorn;
	public static Image seedsPlanted;
	public static Image pickaxe;
	public static Image cow1;
	public static Image cow2;
	public static Image fencePostHorizontal;
	public static Image fencePostVertical;
	public static Image chicken1;
	public static Image chicken2;
	
	public static Image sheep1;
	public static Image sheep2;
	public static Image sheep3;
	public static Image sheep4;
	
	
	public static Image marketBackground;
	public static Image marketText;
	
	public static Image coin1;
	public static Image coin2;
	public static Image coin3;
	public static Image coin4;
	
	public static Image imageBoard;
	
	public static Image cornShop;
	public static Image titleScreen;
	
	public static Image blueBerryStage1;
	public static Image blueBerryStage2;
	
	public static Image tomatoStage1;
	public static Image tomatoStage2;
	
	public static Image carrotStage1;
	public static Image carrotStage2;
	
//player walkign animations
	
	public static Image farmer1walking1;
	public static Image farmer1walking2;
	public static Image farmer2walking1;
	public static Image farmer2walking2;
	public static Image farmer3walking1;
	public static Image farmer3walking2;
	public static Image farmer4walking1;
	public static Image farmer4walking2;
	
	public static Image wateringcan;
	
	public static Image sleepsignal;
	public static Image playerHouse;
	
	public static Image marketstall;
	public static Image chest;
	
	public static Image hoeicon;
	
	public static Image sprinkler;
	
	//animal product images
	
	public static Image milk1;
	public static Image milk2;
	
	public static Image wool1;
	public static Image wool2;
	
	public static Image egg1;
	public static Image egg2;
	
	//vanish animations
	public static Image vanish1;
	public static Image vanish2;
	public static Image vanish3;
	public static Image vanish4;
	public static Image vanish5;
	public static Image vanish6;
	public static Image vanish7;
	
	//more animations
	
	public static Image fencepostset;
	public static Image coffee;
	public static Image rockfragment;
	
	//
	
	public static Image recapScreen;
	
	public static Image droplet;
	public static Image sprinklerMarket;
	public static Image drySeedsPlanted;
	public static Image dryTilledSoil;
	
	public static Image waterTile;
	public static Image uiPanel;
	
	public static Image copperore;
	public static Image copperrock1;public static Image copperrock2;public static Image copperrock3;
	
	public static Image water;
	public static Image bridge;
	
	public static Image slash0;
	public static Image slash1;
	public static Image slash2;
	public static Image slash3;
	public static Image slash4;
	public static Image slash5;
	public static Image slash6;
	public static Image slash7;
	public static Image slash8;
	public static Image boots;
	
	public static Image drycornfinal;
	public static Image drycarrotfinal;
	public static Image dryblueberryfinal;
	public static Image drytomatofinal;
	public static Image drycorninitial;
	public static Image drycarrotinitial;
	public static Image dryblueberryinitial;
	public static Image drytomatoinitial;
	
	
	public static void loadImages() throws SlickException 
	{
		
		drycornfinal = new Image("res/drycornfinal.png").getScaledCopy(64,64);
		drycornfinal.setFilter(Image.FILTER_NEAREST);
		drycarrotfinal= new Image("res/drycarrotfinal.png").getScaledCopy(64,64);
		drycarrotfinal.setFilter(Image.FILTER_NEAREST);
		dryblueberryfinal= new Image("res/dryblueberryfinal.png").getScaledCopy(64,64);
		dryblueberryfinal.setFilter(Image.FILTER_NEAREST);
		drytomatofinal= new Image("res/drytomatofinal.png").getScaledCopy(64,64);
		drytomatofinal.setFilter(Image.FILTER_NEAREST);
		drycorninitial= new Image("res/drycorninitial.png").getScaledCopy(64,64);
		drycorninitial.setFilter(Image.FILTER_NEAREST);
		drycarrotinitial= new Image("res/drycorninitial.png").getScaledCopy(64,64);
		drycarrotinitial.setFilter(Image.FILTER_NEAREST);
		dryblueberryinitial= new Image("res/dryblueberryinitial.png").getScaledCopy(64,64);
		dryblueberryinitial.setFilter(Image.FILTER_NEAREST);
		drytomatoinitial= new Image("res/drytomatoinitial.png").getScaledCopy(64,64);
		drytomatoinitial.setFilter(Image.FILTER_NEAREST);
		
		slash0 = new Image("res/finalslash.png").getScaledCopy(64,64);
		slash1 = new Image("res/finalslash.png").getScaledCopy(64,64);
		slash1.rotate(50);
		
		slash2 = new Image("res/finalslash.png").getScaledCopy(64,64);
		slash2.rotate(100);
		
		slash3 = new Image("res/finalslash.png").getScaledCopy(64,64);
		slash3.rotate(150);
		
		slash4 = new Image("res/finalslash.png").getScaledCopy(64,64);
		slash4.rotate(200);
		
		slash5 = new Image("res/finalslash.png").getScaledCopy(64,64);
		slash5.rotate(250);

		
		slash6 = new Image("res/finalslash.png").getScaledCopy(64,64);
		slash6.rotate(300);
		
		slash7 = new Image("res/finalslash.png").getScaledCopy(64,64);
		slash7.rotate(350);
		
		slash8 = new Image("res/finalslash.png").getScaledCopy(64,64);
		slash8.rotate(400);
		
		boots = new Image("res/farmerboots.png").getScaledCopy(64,64);
		
		water = new Image("res/water.png").getScaledCopy(64,64);
		water.setFilter(Image.FILTER_NEAREST);
		
		bridge = new Image("res/bridge.png").getScaledCopy(64 * 3, 64 * 3);
		bridge.setFilter(Image.FILTER_NEAREST);
		
		copperore = new Image("res/copperore.png").getScaledCopy(32,32);
		copperore.setFilter(Image.FILTER_NEAREST);
		
		
		copperrock1 = new Image("res/copperrock1.png").getScaledCopy(64,64);
		copperrock1.setFilter(Image.FILTER_NEAREST);
		copperrock2 = new Image("res/copperrock2.png").getScaledCopy(64,64);
		copperrock2.setFilter(Image.FILTER_NEAREST);
		copperrock3 = new Image("res/copperrock3.png").getScaledCopy(64,64);
		copperrock3.setFilter(Image.FILTER_NEAREST);
		
		
		
		uiPanel = new Image("res/uipanel.png");
		uiPanel.setFilter(Image.FILTER_NEAREST);
		
		
		
				drySeedsPlanted = new Image("res/dryseedsplanted.png").getScaledCopy(64,64);
				drySeedsPlanted.setFilter(Image.FILTER_NEAREST);
				
				dryTilledSoil = new Image("res/drytilledsoil.png").getScaledCopy(64,64);
				dryTilledSoil.setFilter(Image.FILTER_NEAREST);
		
		
				sprinklerMarket = new Image("res/sprinklericon.png").getScaledCopy(64,64);
				sprinklerMarket.setFilter(Image.FILTER_NEAREST);
				
				droplet = new Image("res/droplet.png").getScaledCopy(24,24);
				droplet.setFilter(Image.FILTER_NEAREST);
		
		
				recapScreen = new Image("res/recapbackground.png").getScaledCopy(1920,1080);
				recapScreen.setFilter(Image.FILTER_NEAREST);
		
				milk1 = new Image("res/milk1.png").getScaledCopy(64,64);
				milk1.setFilter(Image.FILTER_NEAREST);
				milk2 = new Image("res/milk2.png").getScaledCopy(64,64);
				milk2.setFilter(Image.FILTER_NEAREST);
				
				egg1 = new Image("res/egg1.png").getScaledCopy(64,64);
				egg1.setFilter(Image.FILTER_NEAREST);
				egg2 = new Image("res/egg2.png").getScaledCopy(64,64);
				egg2.setFilter(Image.FILTER_NEAREST);
				
				wool1 = new Image("res/wool1.png").getScaledCopy(64,64);
				wool1.setFilter(Image.FILTER_NEAREST);
				wool2 = new Image("res/wool2.png").getScaledCopy(64,64);
				wool2.setFilter(Image.FILTER_NEAREST);
				
				//vanish animations
				vanish1 = new Image("res/download.png").getScaledCopy(64,64);
				vanish1.setFilter(Image.FILTER_NEAREST);
				
				vanish2 = new Image("res/download (1).png").getScaledCopy(64,64);
				vanish2.setFilter(Image.FILTER_NEAREST);
				
				vanish3 = new Image("res/download (2).png").getScaledCopy(64,64);
				vanish3.setFilter(Image.FILTER_NEAREST);
				
				vanish4 = new Image("res/download (3).png").getScaledCopy(64,64);
				vanish4.setFilter(Image.FILTER_NEAREST);
				
				vanish5 = new Image("res/download (4).png").getScaledCopy(64,64);
				vanish5.setFilter(Image.FILTER_NEAREST);
				
				vanish6 = new Image("res/download (5).png").getScaledCopy(64,64);
				vanish6.setFilter(Image.FILTER_NEAREST);
				
				vanish7 = new Image("res/download (6).png").getScaledCopy(64,64);
				vanish7.setFilter(Image.FILTER_NEAREST);
				
				rockfragment = new Image("res/rockfragment.png").getScaledCopy(64,64);
				rockfragment.setFilter(Image.FILTER_NEAREST);
				
				//
				
				fencepostset = new Image("res/fencepostset.png").getScaledCopy(64,64);
				fencepostset.setFilter(Image.FILTER_NEAREST);
				
				coffee = new Image("res/coffeeclear.png").getScaledCopy(64,64);
				coffee.setFilter(Image.FILTER_NEAREST);
		
		sprinkler = new Image("res/sprinkler.png").getScaledCopy(64,64);
		sprinkler.setFilter(Image.FILTER_NEAREST);
		
		hoeicon = new Image("res/hoeicon.png").getScaledCopy(32,32);
		hoeicon.setFilter(Image.FILTER_NEAREST);
		
		marketstall = new Image("res/marketclick.png").getScaledCopy(64*2,64*2);
		marketstall.setFilter(Image.FILTER_NEAREST);
		
		chest = new Image("res/chest.png").getScaledCopy(64,64);
		chest.setFilter(Image.FILTER_NEAREST);
		
		wateringcan = new Image("res/wateringcan.png").getScaledCopy(64,64);
		wateringcan.setFilter(Image.FILTER_NEAREST);
		
		sleepsignal = new Image("res/sleepsignal.png").getScaledCopy(32,32);
		sleepsignal.setFilter(Image.FILTER_NEAREST);
		
		playerHouse = new Image("res/house.png").getScaledCopy(64*3,64*3); //getScaledCopy(256,256)
		playerHouse.setFilter(Image.FILTER_NEAREST);
		
		blueBerryStage1 = new Image("res/blueberryinitial.png").getScaledCopy(64,64);
		blueBerryStage1.setFilter(Image.FILTER_NEAREST);
		blueBerryStage2 = new Image("res/blueberryfinal.png").getScaledCopy(64,64);
		blueBerryStage2.setFilter(Image.FILTER_NEAREST);
		tomatoStage1 = new Image("res/tomatoinitial.png").getScaledCopy(64,64);
		tomatoStage1.setFilter(Image.FILTER_NEAREST);
		tomatoStage2 = new Image("res/tomatoinitial.png").getScaledCopy(64,64);
		tomatoStage2.setFilter(Image.FILTER_NEAREST);
		carrotStage1 = new Image("res/carrotinitial.png").getScaledCopy(64,64);
		carrotStage1.setFilter(Image.FILTER_NEAREST);
		carrotStage2 = new Image("res/carrotinitial.png").getScaledCopy(64,64);
		carrotStage2.setFilter(Image.FILTER_NEAREST);
		
		
		
		box = new Image("res/box.png");
		hoe = new Image("res/hoe.png");
		corn = new Image("res/corn.png");
		scythe = new Image("res/scythe.png");
		playerRight = new Image("res/farmer1.png").getScaledCopy(64,64);
		playerRight.setFilter(Image.FILTER_NEAREST);
		playerLeft = new Image("res/farmer2.png").getScaledCopy(64,64);
		playerLeft.setFilter(Image.FILTER_NEAREST);
		playerUp = new Image("res/farmer3.png").getScaledCopy(64,64);
		playerUp.setFilter(Image.FILTER_NEAREST);
		playerDown = new Image("res/farmer4.png").getScaledCopy(64,64);
		playerDown.setFilter(Image.FILTER_NEAREST);
		grass = new Image("res/grass.png").getScaledCopy(64,64);
		Images.grass.setFilter(Image.FILTER_NEAREST);
		soil = new Image("res/tilledsoil.png").getScaledCopy(64,64);
		Images.grass.setFilter(Image.FILTER_NEAREST);
		boulder = new Image("res/boulder.png").getScaledCopy(64,64);
		Images.boulder.setFilter(Image.FILTER_NEAREST);
		boulder2 = new Image("res/boulder2.png").getScaledCopy(64,64);
		Images.boulder2.setFilter(Image.FILTER_NEAREST);
		boulder3 = new Image("res/boulder3.png").getScaledCopy(64,64);
		Images.boulder3.setFilter(Image.FILTER_NEAREST);
		
		
		cornSeeds = new Image("res/cornseeds.png").getScaledCopy(64,64);
		Images.cornSeeds.setFilter(Image.FILTER_NEAREST);
		
		tomatoSeeds = new Image("res/tomatoseeds.png").getScaledCopy(64,64);
		Images.tomatoSeeds.setFilter(Image.FILTER_NEAREST);
		
		carrotSeeds = new Image("res/carrotseeds.png").getScaledCopy(64,64);
		Images.carrotSeeds.setFilter(Image.FILTER_NEAREST);
		
		blueberrySeeds = new Image("res/blueberryseeds.png").getScaledCopy(64,64);
		Images.blueberrySeeds.setFilter(Image.FILTER_NEAREST);
		
		
		growingCorn = new Image("res/corninitial.png").getScaledCopy(64,64);
		Images.growingCorn.setFilter(Image.FILTER_NEAREST);
		grownCorn = new Image("res/cornfinal.png").getScaledCopy(64,64);
		Images.grownCorn.setFilter(Image.FILTER_NEAREST);
		seedsPlanted = new Image("res/seedsplanted.png").getScaledCopy(64,64);
		Images.seedsPlanted.setFilter(Image.FILTER_NEAREST);
		pickaxe = new Image("res/pickaxe.png").getScaledCopy(32,32);
		Images.pickaxe.setFilter(Image.FILTER_NEAREST);
		cow1 = new Image("res/cow1.png");
		cow1 = cow1.getScaledCopy(100,100);
		cow1.setFilter(Image.FILTER_NEAREST);
	
	
		cow2 = new Image("res/cow2.png");
		cow2 = cow2.getScaledCopy(100,100);
		cow2.setFilter(Image.FILTER_NEAREST);
		
		
		fencePostHorizontal = new Image("res/fencepost.png");
		fencePostHorizontal = fencePostHorizontal.getScaledCopy(32, 32);
		fencePostHorizontal.setFilter(Image.FILTER_NEAREST);
		
		fencePostVertical= new Image("res/fencepost.png");
		fencePostVertical= fencePostHorizontal.getScaledCopy(32, 32);
		fencePostVertical.setFilter(Image.FILTER_NEAREST);
		fencePostVertical.rotate(90);
		
		
		chicken1 = new Image("res/chicken1.png");
		chicken1 = chicken1.getScaledCopy(100,100);
		chicken1.setFilter(Image.FILTER_NEAREST);
		
		
		chicken2 = new Image("res/chicken2.png");
		chicken2 = chicken2.getScaledCopy(100,100);
		chicken2.setFilter(Image.FILTER_NEAREST);
		
		
		
		marketBackground = new Image("res/marketbackground.png");
		marketBackground = marketBackground.getScaledCopy(1920, 1080);
		marketBackground.setFilter(Image.FILTER_NEAREST);
		
		
		marketText = new Image("res/marketplacetext.png");
		marketText = marketText.getScaledCopy(800, 100);
		marketText.setFilter(Image.FILTER_NEAREST);
		
		
		
		coin1 = new Image("res/coin1.png");
		coin1 = coin1.getScaledCopy(64,64);
		coin1.setFilter(Image.FILTER_NEAREST);
		
		coin2 = new Image("res/coin2.png");
		coin2 = coin2.getScaledCopy(64,64);
		coin2.setFilter(Image.FILTER_NEAREST);
		
		coin3 = new Image("res/coin3.png");
		coin3 = coin3.getScaledCopy(64,64);
		coin3.setFilter(Image.FILTER_NEAREST);
		
		coin4 = new Image("res/coin4.png");
		coin4 = coin4.getScaledCopy(64,64);
		coin4.setFilter(Image.FILTER_NEAREST);
		
		sheep1 = new Image("res/sheep1.png");
		sheep1 = sheep1.getScaledCopy(100,100);
		sheep1.setFilter(Image.FILTER_NEAREST);
		
		sheep2 = new Image("res/sheep2.png");
		sheep2 = sheep2.getScaledCopy(100,100);
		sheep2.setFilter(Image.FILTER_NEAREST);
		
		sheep3 = new Image("res/sheep3.png");
		sheep3 = sheep3.getScaledCopy(100,100);
		sheep3.setFilter(Image.FILTER_NEAREST);
		
		sheep4 = new Image("res/sheep4.png");
		sheep4 = sheep4.getScaledCopy(100,100);
		sheep4.setFilter(Image.FILTER_NEAREST);
		
		imageBoard = new Image("res/marketboard.png");
		imageBoard = imageBoard.getScaledCopy(400,400);
		imageBoard.setFilter(Image.FILTER_NEAREST);
		
		cornShop = new Image("res/cshop.png");
		cornShop = cornShop.getScaledCopy(64,64);
		cornShop.setFilter(Image.FILTER_NEAREST);
		
		carrot = new Image("res/carrotsymbol.png");
		carrot = carrot.getScaledCopy(64,64);
		carrot.setFilter(Image.FILTER_NEAREST);
		
		blueberry = new Image("res/blueberrysymbol.png");
		blueberry = blueberry.getScaledCopy(64,64);
		blueberry.setFilter(Image.FILTER_NEAREST);
		
		tomato = new Image("res/tomatosymbol.png");
		tomato = tomato.getScaledCopy(64,64);
		tomato.setFilter(Image.FILTER_NEAREST);
		
		titleScreen = new Image("res/titlescreen.png");
		titleScreen = titleScreen.getScaledCopy(1920,1080);
		titleScreen.setFilter(Image.FILTER_NEAREST);

		
		
		
		farmer1walking1 = new Image("res/farmer1walking1.png").getScaledCopy(64,64);
		farmer1walking1.setFilter(Image.FILTER_NEAREST);
		farmer1walking2 = new Image("res/farmer1walking2.png").getScaledCopy(64,64);
		farmer1walking2.setFilter(Image.FILTER_NEAREST);
		farmer2walking1 = new Image("res/farmer2walking1.png").getScaledCopy(64,64);
		farmer2walking1.setFilter(Image.FILTER_NEAREST);
		farmer2walking2 = new Image("res/farmer2walking2.png").getScaledCopy(64,64);
		farmer2walking2.setFilter(Image.FILTER_NEAREST);
		farmer3walking1 = new Image("res/farmer3walking1.png").getScaledCopy(64,64);
		farmer3walking1.setFilter(Image.FILTER_NEAREST);
		farmer3walking2 = new Image("res/farmer3walking2.png").getScaledCopy(64,64);
		farmer3walking2.setFilter(Image.FILTER_NEAREST);
		farmer4walking1 = new Image("res/farmer4walking1.png").getScaledCopy(64,64);
		farmer4walking1.setFilter(Image.FILTER_NEAREST);
		farmer4walking2 = new Image("res/farmer4walking2.png").getScaledCopy(64,64);
		farmer4walking2.setFilter(Image.FILTER_NEAREST);



	}

}
