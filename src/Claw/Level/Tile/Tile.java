package Claw.Level.Tile;

import Claw.Graphics.Screen;
import Claw.Graphics.Sprite;

public class Tile {
	
	public int x, y;
	public Sprite sprite;
	public int ColorCode;
	
	
	public static Tile grass1 = new Grass1Tile(Sprite.grass1);
	public static Tile grass2 = new Grass2Tile(Sprite.grass2);
	public static Tile grass3 = new Grass3Tile(Sprite.grass3);
	public static Tile grass4 = new Grass1Tile(Sprite.grass4);
	public static Tile grass5 = new Grass1Tile(Sprite.grass5);
	public static Tile grass6 = new Grass1Tile(Sprite.grass6);
	public static Tile grass7 = new Grass1Tile(Sprite.grass7);
	
	public static Tile sand  = new SandTile(Sprite.sand1);
	public static Tile stone = new StoneTile(Sprite.stone1);
	
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
