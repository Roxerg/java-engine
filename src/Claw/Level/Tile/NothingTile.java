package Claw.Level.Tile;

import Claw.Graphics.Screen;
import Claw.Graphics.Sprite;

public class NothingTile extends Tile {
	
	public NothingTile(Sprite sprite) {
		super(sprite);
		this.ColorCode = 0x1976D2;
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}


}
