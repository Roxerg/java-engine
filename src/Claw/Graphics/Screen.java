package Claw.Graphics;

import java.util.Random;

public class Screen {
	
	
	public final int MAP_SIZE = 8;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	
	public int[] px;
	public int[] tiles = new int[MAP_SIZE*MAP_SIZE];
	
	private int width, height;
	
	private Random random = new Random();
	
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		px = new int[width * height];
		
		for (int i = 0; i < MAP_SIZE*MAP_SIZE; i++) {
			tiles[i] = random.nextInt(0xffffff);
		}
		
		
	}
	
	public void clear() {
		for (int i = 0; i < px.length; i++) {
			px[i] = 0;
		}
	}
	
	public void render(int xoff, int yoff) {	
		for (int y = 0; y < height; y++) {
			int yp = y + yoff;
			if (yp < 0 || yp >= height) continue;
			for (int x = 0; x < width; x++) {
				int xp = x + xoff;
				if (xp < 0 || xp >= width) continue;
				//int tileIndex = ((xx >> 4) & MAP_SIZE_MASK) + ((yy >> 4) & MAP_SIZE_MASK)* MAP_SIZE;
				//px[x+y*width] = tiles[tileIndex];
				px[xp + yp*width] =  Sprite.kitty.pixels[(x&15)+(y&15)*Sprite.kitty.SIZE];
			}
		}
	}
	
	
	

}
