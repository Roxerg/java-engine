package Claw.Entity.Mob;

import java.util.ArrayList;
import java.util.Random;

import Claw.MouseInputHandler;
import Claw.Entity.Entity;
import Claw.Graphics.Screen;
import Claw.Graphics.Sprite;
import Claw.Level.Level;
import Claw.Entity.Projectile.Bullet;


public class Gun extends Entity {
	
	
	public int x, y;
	private Player player;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	public ArrayList<Bullet> bulletlist;
	private Sprite sprite;
	
	private MouseInputHandler mih;
	
	
	public Gun(Player player, MouseInputHandler mih) {
		this.player = player;
		this.sprite = Sprite.skully;
		this.mih = mih;
		this.bulletlist = new ArrayList<Bullet>();
	}
	
	
	public void shoot() {
		bulletlist.add(new Bullet(x, y));
		System.out.println("shoot!");
		
		// add if statements and shit for
		// dictating firing speed;
	}
	
	public void update() {
		
		x = player.x;
		y = player.y;
		
		for (Bullet b : bulletlist) {
			b.update();
		}
		
		if (mih.pressed) {
			shoot();
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
