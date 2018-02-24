package Claw.Level;

import Claw.MouseInputHandler;
import Claw.MouseMovementHandler;
import Claw.Graphics.Sprite;
import Claw.Level.Tile.Tile;

public class LevelEditor extends Level {
	
	public Tile[] map;
	public Tile[] tilemenu;
	public int xOff = 0, yOff = 0;
	public MouseInputHandler input;
	public MouseMovementHandler move;
	public int SelectedTile = 1;
	
	
	
	
	public LevelEditor(MouseInputHandler input, MouseMovementHandler move, int height, int width) {
		super(input, height, width);
		this.input = input;
		this.move = move;
		//tilemenu[0] = Tile.grass1;
		//tilemenu[1] = Tile.grass2;
		//tilemenu[2] = Tile.stone;
		generateLevelInitial();
	}
	
	public void generateLevelInitial() {
		
		for (int y=0; y<height; y++) {
			for (int x = 0; x < width; x++) {
				selection[x+y*width] = false;
				tiles[x+y*width] = 69;
			}
			
			
		}
		tiles[0] = 1;
		tiles[2] = 1;
		tiles[4] = 1;
		
	}
	
public void resetSelect() {
		
		for (int y=0; y<height; y++) {
			for (int x = 0; x < width; x++) {
				selection[x+y*width] = false;
			}
			
			
		}}
	
	public void update() {
		resetSelect();
		hoverBlock();
		placeBlock();
		
	}
	
	public void UpdateMap(int xOff, int yOff) {
		
		this.xOff = xOff;
		this.yOff = yOff;
		
		//placeBlock();
	}
	
	public void hoverBlock() {
		int pos = a + b*width;
		
		if (pos >= 0 && pos < width*height) selection[pos] = true;
		
	}
	
	public void placeBlock() {
		
		this.a = ((xOff + move.x/3 + Sprite.nothing.SIZE ) >> 4) - 1;
		this.b = ((yOff + move.y/3 + Sprite.nothing.SIZE ) >> 4) - 1;  
		
		if (input.clicked) {
			
				System.out.println(" movex: " + move.x + "movey: " + move.y);
				System.out.println(" inputx: " + input.x + "inputy: " + input.y);
				// TODO: GLOBAL OF HUD ELEMENTS FOR EASILY ADJUSTABLE HUD SIZE
				
				
				
				int ahud = ((move.x/3 + Sprite.nothing.SIZE ) >> 4) - 1;
				int bhud = ((move.y/3 + Sprite.nothing.SIZE ) >> 4) - 1; 
				
				int xhudstart = ((300/2) - 16*2 ) >> 4;
				int xhudend   = ((300/2) + 16*2 ) >> 4;
				int yhud      = ((height-16)*3) >> 4;
				
				
				
				if (input.x>0) {
					System.out.println("width " + width);
					System.out.println("AHUD: " +xhudend+">"+ ahud + ">" + xhudstart +" BHUD: " + bhud + "==" + yhud);
					input.clicked = false;
				}
				
				
				if (ahud >= xhudstart && ahud < xhudend && bhud == yhud) {
					System.out.println("AHUD: " + ahud + " BHUD: " + bhud + " YHUD: " + yhud);
					System.out.println("accessed hud!");
					
					if (ahud == xhudstart) {
						SelectedTile = 1;
						System.out.println("1 selected!");
					}
					if (ahud == xhudstart + 1) {
						SelectedTile = 2;
						System.out.println("2 selected!");
					}
					if (ahud == xhudstart + 2) {
						SelectedTile = 3;
						System.out.println("3 selected!");
					}
					if (ahud == xhudstart + 3) {
						SelectedTile = 4;
						System.out.println("4 selected!");
					}
					if (ahud == xhudstart + 4) {
						SelectedTile = 5;
						System.out.println("5 selected!");
					}
					
					
					input.clicked = false;
					
				}
				else if (a >= 0 && b >= 0 && a < tiles.length && b < tiles.length) {
				
				System.out.println("AHUD: " + ahud + " BHUD: " + bhud + " YHUD: " + yhud);
				tiles[a + b*width] = SelectedTile;
				System.out.println("a: " + a + " b: " + b);
				System.out.println("xOff: " + xOff + " yOff: " + yOff);
				System.out.println("placed at " + a);
				input.clicked = false;
				
				}
			
		}
	}
	
	
	
	

}
