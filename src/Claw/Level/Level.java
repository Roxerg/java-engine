package Claw.Level;

import java.util.Random;

import Claw.MouseInputHandler;
import Claw.Graphics.Screen;
import Claw.Graphics.Sprite;
import Claw.Level.Tile.Tile;

public class Level {
	
	protected int width, height;
	protected Tile[] tiles;
	protected int[] tilecolor;
	//protected int[] tiles;
	protected boolean[] selection;
	public int a, b;
	
	
	
	
	
	
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		selection = new boolean[width * height];
		tilecolor = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}
	
	public Level(MouseInputHandler m, int width, int height) {
		this.width = width;
		this.height = height;
		selection = new boolean[width * height];
		//tilesint = new int[width * height];
		tiles = new Tile[width * height];
		//System.out.println(tilesint.length);
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
	
	public void saveMapState() {
		
	}
	
	public void render(int xScroll, int yScroll, Screen screen) {
		
		screen.setOffset(xScroll, yScroll);
		
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + Sprite.nothing.SIZE) >> 4;
		
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + Sprite.nothing.SIZE) >> 4;
		
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				//getTile(x, y).render(x, y, screen);
				if (x + y*16 < 0 || x + y*16 >= 256 ) {
					
					//Tile.nothing.render(x, y, screen);
					//continue;
				}
				//else tiles[x+y*width].render(x, y, screen);
				//tiles[x+y*16].render(x, y, screen);
				getTile(x, y).render(x, y, screen);
				if (isSelected(x, y)) Tile.selection.render(x, y, screen); 
			}
		}
		
	}
	
	public boolean isSelected(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return false;
		else return selection[x+y*width];
		
	}
	
	
	//sand = 0xffffff00;
		// grass = 0xff00ff00;
		// stone = 0xff666666;
		// nothing = 0xff0000ff;
	
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.nothing;
		if (tilecolor[x+y*width] == Tile.grass1.ColorCode) return Tile.grass1;
		if (tilecolor[x+y*width] == Tile.grass2.ColorCode) return Tile.grass2;
		if (tilecolor[x+y*width] == Tile.grass3.ColorCode) return Tile.grass3;
		if (tilecolor[x+y*width] == 0xff666666) return Tile.stone;
		//if (tiles[x+y*width] > 4 && tiles[x+y*width] < 9) return Tile.grass3;
		if (tilecolor[x+y*width] == 0xffffff00) return Tile.sand;
		return Tile.nothing;
	}
	

	public void UpdateMap(int xOff, int yOff) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
