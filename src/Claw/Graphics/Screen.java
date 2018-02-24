package Claw.Graphics;

import java.util.Random;

import Claw.Entity.Mob.Player;
import Claw.Level.Tile.Tile;

public class Screen {
	
	
	public final int MAP_SIZE = 8;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	
	public int xOffset, yOffset;
	
	public int[] px;
	public int[] tiles = new int[MAP_SIZE*MAP_SIZE];
	
	public int width, height;
	
	private Random random = new Random();
	
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		px = new int[width * height];
		
		for (int i = 0; i < MAP_SIZE*MAP_SIZE; i++) {
			tiles[i] = random.nextInt(0xffffff);
		}
		
		
	}
	
	public void clear() {
		for (int i = 0; i < px.length; i++) {
			px[i] = 0;
		}
	}
	
	/*
	public void render(int xoff, int yoff) {	
		for (int y = 0; y < height; y++) {
			int yp = y + yoff;
			if (yp < 0 || yp >= height) continue;
			for (int x = 0; x < width; x++) {
				int xp = x + xoff;
				if (xp < 0 || xp >= width) continue;
				//int tileIndex = ((xx >> 4) & MAP_SIZE_MASK) + ((yy >> 4) & MAP_SIZE_MASK)* MAP_SIZE;
				//px[x+y*width] = tiles[tileIndex];
				px[xp + yp*width] =  Sprite.stone1.pixels[(x&15)+(y&15)*Sprite.stone1.SIZE];
			}
		}
	}
	*/
	
	
	
	public void renderHUDEditor(int x, int y) {
		for (int aa = 0; aa < Sprite.nothing.SIZE; aa++) {
			for (int bb = 0; bb < Sprite.nothing.SIZE; bb++) {
				px[(width/2)+ bb - 16*2 + (height-16+aa)*width] = Tile.stone.sprite.pixels[bb + aa*Tile.grass2.sprite.SIZE];
				px[(width/2)+ bb - 16 + (height-16+aa)*width] = Tile.grass2.sprite.pixels[bb + aa*Tile.grass2.sprite.SIZE];
				px[(width/2)+ bb + (height-16+aa)*width] = Tile.grass1.sprite.pixels[bb + aa*Tile.grass1.sprite.SIZE];
				px[(width/2)+ bb + 16 + (height-16+aa)*width] = Tile.grass4.sprite.pixels[bb + aa*Tile.grass2.sprite.SIZE];
				px[(width/2)+ bb + 16*2 + (height-16+aa)*width] = Tile.grass5.sprite.pixels[bb + aa*Tile.grass2.sprite.SIZE];
				px[(width/2)+ bb + 16*3 + (height-16+aa)*width] = 0x1976D2;
				
			}
		}
		
	}
	
	public void renderHUD() {
		for (int aa = 0; aa < Sprite.nothing.SIZE; aa++) {
			for (int bb = 0; bb < Sprite.nothing.SIZE; bb++) {
				
				//px[(width/2)+ bb - 16*2 + (height-16+aa)*width] = Tile.stone.sprite.pixels[bb + aa*Tile.grass2.sprite.SIZE];
				//px[(width/2)+ bb - 16 + (height-16+aa)*width] = Tile.grass2.sprite.pixels[bb + aa*Tile.grass2.sprite.SIZE];
				//px[(width/2)+ bb + (height-16+aa)*width] = Tile.grass1.sprite.pixels[bb + aa*Tile.grass1.sprite.SIZE];
				//px[(width/2)+ bb + 16 + (height-16+aa)*width] = Tile.grass4.sprite.pixels[bb + aa*Tile.grass2.sprite.SIZE];
				//px[(width/2)+ bb + 16*2 + (height-16+aa)*width] = Tile.grass5.sprite.pixels[bb + aa*Tile.grass2.sprite.SIZE];
				//px[(width/2)+ bb + 16*3 + (height-16+aa)*width] = 0x1976D2;
				
			}
		}
		
	}



	public void renderTile(int xp, int yp, Tile tile) {
		
		xp -= xOffset;
		yp -= yOffset;
		
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < tile.sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int colour = tile.sprite.pixels[x+y*tile.sprite.SIZE];
				if (colour != 0xffFF00FF) px[xa+ya*width] = colour;
			}
		}
	
	}
	
	public void renderPlayer(int xp, int yp, Sprite sprite) {
		
		xp -= xOffset;
		yp -= yOffset;
		
		for (int y = 0; y < sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int colour = sprite.pixels[x + y * sprite.SIZE];
				if (colour != 0xffFF00FF) px[xa+ya*width] = colour ;
				
				// for sprite flip, iterate through pixels in reverse order.
				
			}
		}
		
	}
	
	
	
	public void setOffset(int xOffset, int yOffset) {
		
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		
	}











}





