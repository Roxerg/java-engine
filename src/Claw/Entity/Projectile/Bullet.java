package Claw.Entity.Projectile;

import java.util.Random;


import Claw.Entity.Entity;
import Claw.Graphics.Screen;
import Claw.Graphics.Sprite;
import Claw.Level.Level;
import Claw.MouseInputHandler;
import Claw.MouseMovementHandler;

public class Bullet extends Entity {
	
	public int x, y;
	public int deltax, deltay;
	
	private int xclick, yclick;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	private Sprite sprite;
	
	
	
	
	public Bullet(int x, int y, int xs, int ys) {
		
		this.sprite = Sprite.skully;
		this.x = x;
		this.y = y;
		this.xclick = xs;
		this.yclick = ys;
		
		
		if (this.xclick > 450) {
			//this.xclick *= -1;
		}
		if (this.yclick > 250) {
			//this.yclick *= -1;
		}
		//this.yclick = yclick;
		//this.xclick = xclick;
		
		int len = (int)Math.sqrt((xclick-450)*(xclick-450) + (yclick-250)*(yclick-250));
		
		System.out.println(len);
		
		double temp1 = ((((double)(xclick-450)/(double)len)*10));
		double temp2 = ((((double)(yclick-250)/(double)len)*10));
		this.deltay = (int)temp2;
		this.deltax = (int)temp1;
		
		System.out.println("x: " + deltax + " y: " + deltay);
		
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
