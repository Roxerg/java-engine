package Claw.Entity.Projectile;

import java.util.Random;


import Claw.Entity.Entity;
import Claw.Graphics.Screen;
import Claw.Graphics.Sprite;
import Claw.Level.Level;
import Claw.MouseInputHandler;

public class Bullet extends Entity {
	
	public int x, y;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	private Sprite sprite;
	
	
	public Bullet(int x, int y) {
		
		this.sprite = Sprite.skully;
		this.x = x;
		this.y = y;
		
	}
	
	public void update() {
		
		x += 7;
	
	}
	
	public void render(Screen screen) {
		
		screen.renderSprite(x, y, sprite);
		
	}
	
	public void remove() {
		removed = true;
	}
	
	public boolean isRemoved() {
		return removed;
	}

}
