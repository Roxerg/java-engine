package Claw.Level;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import Claw.Level.Tile.Tile;

public class SpawnLevel extends Level {
	
	//private Tile[] tiles;
	private int[] tilecolor;
	
	public SpawnLevel(String path) {
		super(path);
	}
	
	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			int w = width = image.getWidth();
			int h = height = image.getHeight();
			tilecolor = new int[w*h];
			image.getRGB(0, 0, w, h, tilecolor, 0, w);
			
			//generateLevel();
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("level loading failed");
		}
		
		
	}
	
	//sand = 0xffffff00;
	// grass = 0xff00ff00;
	// stone = 0xff666666;
	// nothing = 0xff0000ff;
	
	
	protected void generateLevel() {
		
		
	}
	
}



