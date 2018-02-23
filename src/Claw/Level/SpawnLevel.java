package Claw.Level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Claw.Level.Tile.Tile;

public class SpawnLevel extends Level {
	
	private Tile[] tiles;
	private int[] levelPixels;
	
	public SpawnLevel(String path) {
		super(path);
	}
	
	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			tiles = new Tile[w * h];
			image.getRGB(0, 0, w, h, levelPixels, 0, w);
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("level loading failed");
		}
		
		
	}
	
	protected void generateLevel() {
		
	}
	


}
