package Claw.Entity.Projectile;

import java.util.Random;


import Claw.Entity.Entity;
import Claw.Graphics.Screen;
import Claw.Graphics.Sprite;
import Claw.Level.Level;
import Claw.MouseInputHandler;
import Claw.MouseMovementHandler;
import Claw.Collision.CollisionDetection;

public class Bullet extends Entity {
	
	public int x, y;
	public int deltax, deltay;
	public boolean hit;
	
	private int xclick, yclick;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	private Sprite sprite;
	
	private int refresh = 0;
	private int life = 100;
	private CollisionDetection col;
	
	
	
	
	public Bullet(int x, int y, int xs, int ys, CollisionDetection col) {
		
		this.sprite = Sprite.bullet;
		this.x = x;
		this.y = y;
		this.xclick = xs;
		this.yclick = ys;
		this.col = col;
		this.hit = false;
		
		
		if (this.xclick > 450) {
			//this.xclick *= -1;
		}
		if (this.yclick > 250) {
			//this.yclick *= -1;
		}
		//this.yclick = yclick;
		//this.xclick = xclick;
		
		int len = (int)Math.sqrt((xclick-450)*(xclick-450) + (yclick-250)*(yclick-250));
		
		//System.out.println(len);
		
		double temp1 = ((((double)(xclick-450)/(double)len)*10));
		double temp2 = ((((double)(yclick-250)/(double)len)*10));
		
		Random random = new Random();
		

		this.x += random.nextInt(3);
		this.y += random.nextInt(3);
		this.y -= random.nextInt(3);
		
		this.deltay = (int)temp2 + random.nextInt(5);
		this.deltax = (int)temp1 + random.nextInt(3);
		
		this.deltay = (int)temp2 - random.nextInt(2);
		this.deltax = (int)temp1 - random.nextInt(2);
		
		
		
		
		//System.out.println("x: " + deltax + " y: " + deltay);
		
	}
	
	public void update() {
		
		refresh++;
		life--;
		
		if (life<0) this.hit = true;
		
		if (refresh%2 == 0 && !hit) {
			if (!col.simpleupdate(x+deltax, y+deltay)  ) {  //&& !col.update(x-deltax, y-deltay)
			x += deltax;
			y += deltay;
			}
			else {
				this.hit = true;
			}
		}
		
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
