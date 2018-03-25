package Claw.Entity.Mob;

import java.util.ArrayList;
import java.util.Random;

import Claw.MouseInputHandler;
import Claw.MouseMovementHandler;
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
	
	
	public Gun(Player player, MouseInputHandler mih, MouseMovementHandler mmh) {
		this.player = player;
		this.sprite = Sprite.skully;
		this.mih = mih;
		this.mmh = mmh;
		this.bulletlist = new ArrayList<Bullet>();
		
	}
	
	
	public void shoot(int xs, int ys) {
		
		//int xs, ys;
		
		if (mmh.xs != 0) {
			xs = mmh.xs;
		}
		else {
			xs = mmh.x;
		}
		
		if (mmh.ys != 0) {
			ys = mmh.ys;
		}
		else {
			ys = mmh.y;
		}
		
		bulletlist.add(new Bullet(x, y, xs, ys));
		//System.out.println("shoot!");
		//System.out.println(mih.y);
		//System.out.println(mih.x);
		
		// add if statements and shit for
		// dictating firing speed;
	}
	
	public void update() {
		
		x = player.x;
		y = player.y;
		
		for (Bullet b : bulletlist) {
			b.update();
		}
		
		
		this.xs = mmh.x;
		this.ys = mmh.y;
		
		if (mih.pressed) {
			shoot(mih.x, mih.y);
		}
		
	}
	
	public void render(Screen screen) {
		
		
		screen.renderSprite(x, y, sprite);
		
		for (Bullet b : bulletlist) {
			b.render(screen);
		}
		
	}
	
	public void remove() {
		removed = true;
	}
	
	public boolean isRemoved() {
		return removed;
	}

}
