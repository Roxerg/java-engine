package Claw.Level;

import Claw.MouseInputHandler;
import Claw.Graphics.Screen;
import Claw.Graphics.Sprite;
import Claw.Level.Tile.Tile;

public class Level {
	
	protected int width, height;
	protected int[] tiles;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
	}
	
	public Level(MouseInputHandler m, int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		System.out.println(tiles.length);
	}
	
	protected void generateLevel() {
		
	}
	
	protected void loadLevel(String path) {
		//ayy
	}
	
	public void update() {
		
	}
	
	private void time() {
		
	}
	
	public void render(int xScroll, int yScroll, Screen screen) {
		
		screen.setOffset(xScroll, yScroll);
		
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + Sprite.nothing.SIZE) >> 4;
		
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + Sprite.nothing.SIZE) >> 4;
		
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}
		
		
		
		
	}
	
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.nothing;
		if (tiles[x+y*width] == 1) return Tile.grass1;
		if (tiles[x+y*width] == 2) return Tile.grass2;
		//if (tiles[x+y*width] > 4 && tiles[x+y*width] < 9) return Tile.grass3;
		if (tiles[x+y*width] == 3) return Tile.grass4;
		if (tiles[x+y*width] == 4) return Tile.grass5;
		if (tiles[x+y*width] == 5) return Tile.grass6;
		if (tiles[x+y*width] == 6) return Tile.grass7;
		return Tile.nothing;
	}

	public void UpdateMap(int xOff, int yOff) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
