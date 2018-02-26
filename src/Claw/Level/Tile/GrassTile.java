package Claw.Level.Tile;

import Claw.Graphics.Screen;
import Claw.Graphics.Sprite;

public class GrassTile extends Tile {
	
	
	public GrassTile(Sprite sprite) {
		super(sprite);
		this.ColorCode = 0xff00ff00;
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}

}
