package Claw.Level.Tile;

import Claw.Graphics.Screen;
import Claw.Graphics.Sprite;

public class Grass2Tile extends Tile {
		
		public Grass2Tile(Sprite sprite) {
			super(sprite);
			this.ColorCode = 0xff00c900;
		}
		
		public void render(int x, int y, Screen screen) {
			screen.renderTile(x << 4, y << 4, this);
		}
}


