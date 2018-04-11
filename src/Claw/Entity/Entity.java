package Claw.Entity;

import java.util.Random;

import Claw.Graphics.Screen;
import Claw.Level.Level;

public abstract class Entity {
	
	public int x, y;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	public boolean collision;
	
	public void update() {
		
	}
	
	public void render(Screen screen) {
		
	}
	
	public void remove() {
		removed = true;
	}
	
	public boolean isRemoved() {
		return removed;
	}
	
	public boolean collision() {
		
		
		return false;
	}

}
