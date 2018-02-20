package Claw.Level.Tile;

import Claw.Graphics.Screen;
import Claw.Graphics.Sprite;

public class GrassTile extends Tile {
	
	public GrassTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x, y, this);
	}

}
