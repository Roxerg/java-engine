package Claw.Level;

import Claw.MouseInputHandler;
import Claw.Level.Tile.Tile;

public class LevelEditor extends Level {
	
	public Tile[] map;
	public Tile[] tilemenu;
	public MouseInputHandler input;
	
	
	
	
	public LevelEditor(MouseInputHandler input, int height, int width) {
		super(input, height, width);
		this.input = input;
		//tilemenu[0] = Tile.grass1;
		//tilemenu[1] = Tile.grass2;
		//tilemenu[2] = Tile.stone;
	}
	
	public void generateLevel() {
		
		for (int y=0; y<height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x+y*width] = 69;
			}
		}
		
	}
	
	public void placeBlock() {
		
		if (input.clicked) {
			//tiles[input.x + input.x * height] = 1;
			
		}
	}
	
	
	
	

}
