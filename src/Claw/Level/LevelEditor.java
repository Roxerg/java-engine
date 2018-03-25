package Claw.Level;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Claw.MouseInputHandler;
import Claw.MouseMovementHandler;
import Claw.Entity.Mob.Player;
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
	public boolean edit;
	
	
	
	
	public LevelEditor(MouseInputHandler input, MouseMovementHandler move, int height, int width, boolean edit) {
		super(input, height, width);
		this.input = input;
		this.move = move;
		this.edit = edit;
		//this.xOff = initx;
		//this.yOff = inity;
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
		
		
		//let edit map if level editor is enabled
		if (edit) {
			resetSelect();
			hoverBlock();
			placeBlock();
		}
		
	}
	
	public void UpdateMap(int xOff, int yOff) {
		
		if (edit) {
		this.xOff = xOff;
		this.yOff = yOff;
		
		placeBlock();
		}
	}
	
	public void hoverBlock() {
		int pos = a + b*width;
		
		if (pos >= 0 && pos < width*height) selection[pos] = true;
		
	}
	
	public void placeBlock() {
		
		this.a = (( xOff + move.x/3 + Sprite.nothing.SIZE ) >> 4) - 1;
		this.b = (( yOff + move.y/3 + Sprite.nothing.SIZE ) >> 4) - 1;  
		
		if (input.clicked) {
			
				//System.out.println(" movex: " + move.x + "movey: " + move.y);
				System.out.println(" inputx: " + input.x + "inputy: " + input.y);
				// TODO: GLOBAL OF HUD ELEMENTS FOR EASILY ADJUSTABLE HUD SIZE
				
				
				
				int ahud = ((move.x/3 + Sprite.nothing.SIZE ) >> 4) - 1;
				int bhud = ((move.y/3 + Sprite.nothing.SIZE ) >> 4) - 1; 
				
				
				// DEFINES THE WIDTH OF THE MENU (16*x)
				int xhudstart = ((300/2) - 16*2 ) >> 4;
				int xhudend   = ((300/2) + 16*4 ) >> 4;
				int yhud      = ((64-16)*3) >> 4;
				
				
				
				if (input.x>0) {
					//System.out.println("width " + width);
					//System.out.println("AHUD: " +xhudend+">"+ ahud + ">" + xhudstart +" BHUD: " + bhud + "==" + yhud);
					input.clicked = false;
				}
				
				
				// DEFINES THE SELECTIONS OF THE MENU
				
				if (ahud >= xhudstart && ahud < xhudend && bhud == yhud) {
					//System.out.println("AHUD: " + ahud + " BHUD: " + bhud + " YHUD: " + yhud);
					//System.out.println("accessed hud!");
					
					if (ahud == xhudstart) {
						SelectedTile = Tile.grass1.ColorCode;
						System.out.println("1 selected!");
					}
					if (ahud == xhudstart + 1) {
						SelectedTile = Tile.grass2.ColorCode;
						System.out.println("2 selected!");
					}
					if (ahud == xhudstart + 2) {
						SelectedTile = Tile.sand.ColorCode;
						System.out.println("3 selected!");
					}
					if (ahud == xhudstart + 3) {
						SelectedTile = Tile.stone.ColorCode;
						System.out.println("4 selected!");
					}
					if (ahud == xhudstart + 4) {
						SelectedTile = Tile.grass3.ColorCode;
						System.out.println("5 selected!");
					}
					if (ahud == xhudstart + 5) {
						SelectedTile = Tile.nothing.ColorCode;
						System.out.println("6 selected!");
					}
					
					input.clicked = false;
					
				}
				else if (a >= 0 && b >= 0 && a < tiles.length && b < tiles.length) {
				
				//System.out.println("AHUD: " + ahud + " BHUD: " + bhud + " YHUD: " + yhud);
				tilecolor[a + b*width] = SelectedTile;
				System.out.println("a: " + a + " b: " + b);
				//System.out.println("xOff: " + xOff + " yOff: " + yOff);
				//System.out.println("placed at " + a);
				input.clicked = false;
				
				}
	
			
		}
	}
	
	
	public void saveMapState() {
		
		System.out.println("MAP SAVED!");
		
		BufferedImage map = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				map.setRGB(x, y, tilecolor[x+y*width]);
			}
		}
		
		File outputfile = new File("res/sprites/level.png");
		try {
			ImageIO.write(map, "png", outputfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public int hex2RGB(int x) {
		return 0;
	}
	


	
	
	

}
