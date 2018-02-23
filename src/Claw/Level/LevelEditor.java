package Claw.Level;

import Claw.MouseInputHandler;
import Claw.Graphics.Sprite;
import Claw.Level.Tile.Tile;

public class LevelEditor extends Level {
	
	public Tile[] map;
	public Tile[] tilemenu;
	public int xOff = 0, yOff = 0;
	public MouseInputHandler input;
	
	
	
	
	public LevelEditor(MouseInputHandler input, int height, int width) {
		super(input, height, width);
		this.input = input;
		//tilemenu[0] = Tile.grass1;
		//tilemenu[1] = Tile.grass2;
		//tilemenu[2] = Tile.stone;
		generateLevelInitial();
	}
	
	public void generateLevelInitial() {
		
		for (int y=0; y<height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[0] = 1;
				tiles[2] = 1;
				tiles[4] = 1;
				
				tiles[x+y*width] = 69;
			}
		}
		
	}
	
	public void update() {
		placeBlock();
		
	}
	
	public void UpdateMap(int xOff, int yOff) {
		
		this.xOff = xOff;
		this.yOff = yOff;
		
		placeBlock();
	}
	
	
	public void placeBlock() {
		
		if (input.clicked) {
			if (input.x + xOff > 0 || input.y + yOff > 0) {
				
				
				int a = ((xOff + input.x/3 + Sprite.nothing.SIZE )>> 4) - 1;
				int b = ((yOff + input.y/3 + Sprite.nothing.SIZE ) >> 4) - 1;  
				int g = a + b;
				
				
				tiles[a + b*width] = 1;
				System.out.println("a: " + a + " b: " + b);
				System.out.println("xOff: " + xOff + " yOff: " + yOff);
				System.out.println("placed at " + a);
				input.clicked = false;
				
			}
			
		}
	}
	
	
	
	

}
