package Level;

import Claw.Graphics.Screen;

public class Level {
	
	protected int width, height;
	protected int[] tiles;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
	}
	
	protected void generateLevel() {
		//lmao
	}
	
	private void loadLevel(String path) {
		//ayy
	}
	
	public void update() {
		
	}
	
	private void time() {
		
	}
	
	public void render(int xScroll, int yScroll, Screen screen) {
		
	}
	
	
	
}
