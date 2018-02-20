package Claw.Graphics;

public class Sprite {
	
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet spritesheet;
	
	/* sprite declarations */
	
	public static Sprite boogie =  new Sprite(16, 0, 0, SpriteSheet.first);
	public static Sprite kitty  =  new Sprite(16, 1, 0, SpriteSheet.first);
	public static Sprite grass1 =  new Sprite(16, 2, 0, SpriteSheet.first);
	
	
	
	
	/* ------------------- */
	
	public Sprite(int size, int x, int y, SpriteSheet spritesheet) {
		
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		this.x = x * size;
		this.y = y * size;
		this.spritesheet = spritesheet;
		load();
		
		
	}
	
	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x+y*SIZE] = spritesheet.pixels[(x + this.x) + (y + this.y)*spritesheet.SIZE];
			}
		}
	}
	

}
