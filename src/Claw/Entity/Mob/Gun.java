package Claw.Entity.Mob;

import java.util.ArrayList;
import java.util.Random;

import Claw.MouseInputHandler;
import Claw.MouseMovementHandler;
import Claw.Collision.CollisionDetection;
import Claw.Entity.Entity;
import Claw.Graphics.Screen;
import Claw.Graphics.Sprite;
import Claw.Level.Level;
import Claw.Entity.Projectile.Bullet;


public class Gun extends Entity {
	
	
	public int x, y, xs, ys;
	private Player player;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	public ArrayList<Bullet> bulletlist;
	private Sprite sprite;
	
	private MouseInputHandler mih;
	private MouseMovementHandler mmh;
	private CollisionDetection col;
	private int refresh = 0;
	
	
	public Gun(Player player, MouseInputHandler mih, MouseMovementHandler mmh, CollisionDetection col) {
		this.player = player;
		this.sprite = Sprite.uzi;
		this.mih = mih;
		this.mmh = mmh;
		this.col = col;
		this.bulletlist = new ArrayList<Bullet>();
		
	}
	
	
	public void shoot(int xs, int ys) {
		
		int a;
		
		if (mmh.x <450) {
			a = x-6;
		}
		else {
			a = x+6;
		}
		
		if (mmh.x != 0) {
			xs = mmh.x; 
		}
		
		if (mmh.y != 0) {
			ys = mmh.y;
		}
		
		bulletlist.add(new Bullet(a, y-1, xs, ys, col));
		//System.out.println("shoot!");
		//System.out.println(mih.y);
		//System.out.println(mih.x);
		
		// add if statements and shit for
		// dictating firing speed;
	}
	
	public void update() {
		
		
		if (mmh.x < 450) {
			x = player.x-12;
			y = player.y-4;
			this.sprite = Sprite.uzi;
		}
		else {
			x = player.x-1;
			y = player.y-4;
			this.sprite = Sprite.uzi2;
		}
		
		for (Bullet b : bulletlist) {
			b.update();
			if (b.hit) b = null;
		}
		
		
		this.xs = mmh.x;
		this.ys = mmh.y;
		 
		refresh++;
		
		if (mih.pressed && refresh%5 == 2) {
			
			//System.out.println(mmh.x);
			if (mmh.x < 450) {
				shoot(mih.x-3, mih.y);
			}
			else {
				shoot(mih.x+3, mih.y);
			}
			
		}
		
		if (refresh > 200) {
			refresh = 0;
		}
		
	}
	
	public void render(Screen screen) {
		
		//if (player.front) {
		screen.renderSprite(x, y, sprite);
		//}
		//else {
		//	screen.renderSprite(x, y, sprite);
		//}
		
		
		for (Bullet b : bulletlist) {
			if (!b.hit) b.render(screen);
		
		}
		
	}
	
	public void remove() {
		removed = true;
	}
	
	public boolean isRemoved() {
		return removed;
	}

}
