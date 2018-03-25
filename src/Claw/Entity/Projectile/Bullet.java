package Claw.Entity.Projectile;

import java.util.Random;


import Claw.Entity.Entity;
import Claw.Graphics.Screen;
import Claw.Graphics.Sprite;
import Claw.Level.Level;
import Claw.MouseInputHandler;

public class Bullet extends Entity {
	
	public int x, y;
	public int deltax, deltay;
	
	private int xclick, yclick;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	private Sprite sprite;
	
	
	
	
	public Bullet(int x, int y, int xclick, int yclick) {
		
		this.sprite = Sprite.skully;
		this.x = x;
		this.y = y;
		this.yclick = yclick;
		this.xclick = xclick;
		
		int len = (int)Math.sqrt(xclick*xclick + yclick*yclick);
		
		System.out.println(len);
		
		double temp1 = ((((double)xclick/(double)len)*10));
		double temp2 = ((((double)yclick/(double)len)*10));
		this.deltay = (int)temp1;
		this.deltax = (int)temp2;
		
		System.out.println("x: " + temp1 + " y: " + temp2);
		
	}
	
	public void update() {
		
		x += deltax;
		y += deltay;
	
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
