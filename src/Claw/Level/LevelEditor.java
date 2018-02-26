package Claw.Level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Claw.MouseInputHandler;
import Claw.MouseMovementHandler;
import Claw.Graphics.Sprite;
import Claw.Level.Tile.Tile;

public class LevelEditor extends Level {
	
	public Tile[] map;
	public Tile[] tilemenu;
	//private int[] tilecolor;
	public int xOff = 0, yOff = 0;
	public MouseInputHandler input;
	public MouseMovementHandler move;
	public int SelectedTile = 0xff00ff00;
	
	
	
	
	public LevelEditor(MouseInputHandler input, MouseMovementHandler move, int height, int width) {
		super(input, height, width);
		this.input = input;
		this.move = move;
		//tilemenu[0] = Tile.grass1;
		//tilemenu[1] = Tile.grass2;
		//tilemenu[2] = Tile.stone;
		loadLevelFile("/sprites/level.png");
		loadLevel();
		
	}
	
	public void generateLevelInitial() {
		
		for (int y=0; y<height; y++) {
			for (int x = 0; x < width; x++) {
				selection[x+y*width] = false;
				tiles[x+y*width] = Tile.nothing;
			}
			
			
		}
		tiles[0] = Tile.grass1;
		tiles[2] = Tile.grass4;
		tiles[4] = Tile.grass5;
		
	}
	
	protected void loadLevelFile(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			int w = width = image.getWidth();
			int h = height = image.getHeight();
			tilecolor = new int[w*h];
			image.getRGB(0, 0, w, h, tilecolor, 0, w);
			//generateLevel();
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("level loading failed");
		}
	}
	
	protected void loadLevel() {
		
		System.out.println(width);
		System.out.println(height);
		for (int y=0; y<height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x+y*width] = getTile(x, y);
			}
	}
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
		
		placeBlock();
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
				int yhud      = ((64-16)*3) >> 4;
				
				
				
				if (input.x>0) {
					System.out.println("width " + width);
					System.out.println("AHUD: " +xhudend+">"+ ahud + ">" + xhudstart +" BHUD: " + bhud + "==" + yhud);
					input.clicked = false;
				}
				
				
				if (ahud >= xhudstart && ahud < xhudend && bhud == yhud) {
					System.out.println("AHUD: " + ahud + " BHUD: " + bhud + " YHUD: " + yhud);
					System.out.println("accessed hud!");
					
					if (ahud == xhudstart) {
						SelectedTile = Tile.grass1.ColorCode;
						System.out.println("1 selected!");
					}
					if (ahud == xhudstart + 1) {
						SelectedTile = 0xff00ff00;
						System.out.println("2 selected!");
					}
					if (ahud == xhudstart + 2) {
						SelectedTile = 0xffffff00;
						System.out.println("3 selected!");
					}
					if (ahud == xhudstart + 3) {
						SelectedTile = 0xff66666;
						System.out.println("4 selected!");
					}
					if (ahud == xhudstart + 4) {
						SelectedTile = 0xff00ff00;
						System.out.println("5 selected!");
					}
					
					
					input.clicked = false;
					
				}
				else if (a >= 0 && b >= 0 && a < tiles.length && b < tiles.length) {
				
				System.out.println("AHUD: " + ahud + " BHUD: " + bhud + " YHUD: " + yhud);
				tilecolor[a + b*width] = SelectedTile;
				System.out.println("a: " + a + " b: " + b);
				System.out.println("xOff: " + xOff + " yOff: " + yOff);
				System.out.println("placed at " + a);
				input.clicked = false;
				
				}
			
		}
	}
	
	
	
	

}
