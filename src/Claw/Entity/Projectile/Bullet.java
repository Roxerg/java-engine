package Claw.Entity.Projectile;

import java.util.Random;


import Claw.Entity.Entity;
import Claw.Graphics.Screen;
import Claw.Level.Level;
import Claw.MouseInputHandler;

public class Bullet extends Entity {
	
	public int x, y;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	
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

}
