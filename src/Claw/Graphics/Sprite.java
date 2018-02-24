package Claw.Graphics;

public class Sprite {
	
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet spritesheet;
	
	/* sprite declarations */
	
	public static Sprite player_front = new Sprite(16, 1, 0, SpriteSheet.first);
	public static Sprite player_front_walk = new Sprite(16, 1, 1, SpriteSheet.first);
	public static Sprite player_back = new Sprite(16, 1, 2, SpriteSheet.first);
	public static Sprite player_back_walk = new Sprite(16, 1, 3, SpriteSheet.first);
	
	public static Sprite selection = new Sprite(16, 1, 4 ,SpriteSheet.first);
	
	public static Sprite boogie =  new Sprite(16, 0, 0, SpriteSheet.first);
	public static Sprite skelly =  new Sprite(16, 0, 1, SpriteSheet.first);
	public static Sprite skully =  new Sprite(16, 0, 2, SpriteSheet.first);
	
	//public static Sprite kitty  =  new Sprite(16, 1, 0, SpriteSheet.first);
	public static Sprite uzi    =  new Sprite(16, 1, 1, SpriteSheet.first);
	
	public static Sprite grass1 =  new Sprite(16, 2, 0, SpriteSheet.first);
	public static Sprite grass2 =  new Sprite(16, 2, 1, SpriteSheet.first);
	public static Sprite grass3 =  new Sprite(16, 2, 2, SpriteSheet.first);
	public static Sprite grass4 =  new Sprite(16, 2, 3, SpriteSheet.first);
	public static Sprite grass5 =  new Sprite(16, 2, 4, SpriteSheet.first);
	public static Sprite grass6 =  new Sprite(16, 2, 5, SpriteSheet.first);
	public static Sprite grass7 =  new Sprite(16, 2, 6, SpriteSheet.first);
	
	public static Sprite sand1  =  new Sprite(16, 3, 0, SpriteSheet.first);
	public static Sprite stone1 =  new Sprite(16, 4, 0, SpriteSheet.first);
	
	
	public static Sprite nothing = new Sprite(16, 0x1976D2);
	
	/* ------------------- */
	
	public Sprite(int size, int x, int y, SpriteSheet spritesheet) {
		
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		this.x = x * size;
		this.y = y * size;
		this.spritesheet = spritesheet;
		load();
		
		
	}
	
	public Sprite(int size, int colour) {
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		setColour(colour);
	}
	
	
	private void setColour(int colour) {
		for (int i=0; i< SIZE*SIZE; i++) {
			pixels[i] = colour;
		}
	}
	
	
	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x+y*SIZE] = spritesheet.pixels[(x + this.x) + (y + this.y)*spritesheet.SIZE];
			}
		}
	}
	

}
