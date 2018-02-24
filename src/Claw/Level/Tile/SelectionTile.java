package Claw.Level.Tile;

import Claw.Graphics.Screen;
import Claw.Graphics.Sprite;

public class SelectionTile extends Tile {

	public SelectionTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
}
