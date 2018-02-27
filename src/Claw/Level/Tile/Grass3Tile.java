package Claw.Level.Tile;

import Claw.Graphics.Screen;
import Claw.Graphics.Sprite;

public class Grass3Tile extends Tile {
	
	public Grass3Tile(Sprite sprite) {
		super(sprite);
		this.ColorCode = 0xff48ef48;
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}

}
