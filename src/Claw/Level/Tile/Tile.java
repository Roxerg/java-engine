package Claw.Level.Tile;

import Claw.Graphics.Screen;
import Claw.Graphics.Sprite;

public class Tile {
	
	public int x, y;
	public Sprite sprite;
	
	
	public static Tile grass1 = new GrassTile(Sprite.grass1);
	public static Tile grass2 = new GrassTile(Sprite.grass2);
	public static Tile grass3 = new GrassTile(Sprite.grass3);
	public static Tile grass4 = new GrassTile(Sprite.grass4);
	public static Tile grass5 = new GrassTile(Sprite.grass5);
	public static Tile grass6 = new GrassTile(Sprite.grass6);
	public static Tile grass7 = new GrassTile(Sprite.grass7);
	
	public static Tile sand  = new GrassTile(Sprite.sand1);
	public static Tile stone = new GrassTile(Sprite.stone1);
	
	public static Tile nothing = new NothingTile(Sprite.nothing);
	
	public static Tile selection = new SelectionTile(Sprite.selection);
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) {
		
	}
	
	public boolean solid() {
		return false;
	}

}
