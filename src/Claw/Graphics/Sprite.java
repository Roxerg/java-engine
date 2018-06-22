package Claw.Graphics;

public class Sprite {
	
	public final int SIZE;
	public int WIDTH;
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
	
	public static Sprite blood1 = new Sprite(16, 0, 6, SpriteSheet.first);
	public static Sprite blood2 = new Sprite(16, 0, 7, SpriteSheet.first);
	public static Sprite blood3 = new Sprite(16, 0, 8, SpriteSheet.first);
	
	//public static Sprite kitty  =  new Sprite(16, 1, 0, SpriteSheet.first);
	public static Sprite uzi    =  new Sprite(16, 0, 3, SpriteSheet.first);
	public static Sprite uzi2   =  new Sprite(16, 0, 4, SpriteSheet.first);
	public static Sprite bullet =  new Sprite(16, 0, 5, SpriteSheet.first);
	
	public static Sprite grass1 =  new Sprite(16, 2, 0, SpriteSheet.first);
	public static Sprite grass2 =  new Sprite(16, 2, 1, SpriteSheet.first);
	public static Sprite grass3 =  new Sprite(16, 2, 2, SpriteSheet.first);
	public static Sprite grass4 =  new Sprite(16, 2, 3, SpriteSheet.first);
	public static Sprite grass5 =  new Sprite(16, 2, 4, SpriteSheet.first);
	public static Sprite grass6 =  new Sprite(16, 2, 5, SpriteSheet.first);
	public static Sprite grass7 =  new Sprite(16, 2, 6, SpriteSheet.first);
	
	public static Sprite sand1  =  new Sprite(16, 3, 0, SpriteSheet.first);
	public static Sprite stone1 =  new Sprite(16, 4, 0, SpriteSheet.first);
	
	public static Sprite ezhik_walk_one = new Sprite(32, 48, 0, 6, SpriteSheet.first); 
	public static Sprite ezhik_walk_two = new Sprite(32, 48, 1, 6, SpriteSheet.first);
	
	public static Sprite ezhik_hurt = new Sprite(32, 48, 0, 7, SpriteSheet.first);
	public static Sprite ezhik_idle = new Sprite(32, 48, 1, 7, SpriteSheet.first);
	
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
	
	public Sprite(int height, int width, int x, int y, SpriteSheet spritesheet) {
		
		SIZE = height;
		this.WIDTH = width;
		pixels = new int[SIZE*WIDTH];
		this.x = x * width;
		this.y = y * height;
		this.spritesheet = spritesheet;
		loadasym();
		
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
	
	private void loadasym() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < WIDTH; x++) {
				pixels[x+y*WIDTH] = spritesheet.pixels[(x + this.x) + (y + this.y)*spritesheet.SIZE];
			}
		}
	}
	

}
