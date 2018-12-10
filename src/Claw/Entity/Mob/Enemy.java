package Claw.Entity.Mob;

import java.util.ArrayList;
import java.util.Random;

import Claw.Graphics.Screen;
import Claw.Graphics.Sprite;
import Claw.Entity.Particle.Blood;

public class Enemy extends Mob {
	
	protected int health, burp=0;
	protected Player player;
	protected int xa, ya;
	private boolean step = false;
	
	public ArrayList<Blood> bloods;
	
	private boolean alive = true, delete = false;
	
	
	public Enemy(int type, Player player) {
		
		Random rng = new Random();
		
		this.bloods = new ArrayList<Blood>();
		
		int xoff = rng.nextInt(1000);
		int yoff = rng.nextInt(1000);
		
		System.out.println("enemy stuff:");
		System.out.println(xoff + yoff);
		
		if (type == 1) {
			this.health = 100;
		}
		
		
		this.player = player;
		this.xa = 0;
		this.ya = 0;
		if (type == 1) {
			this.sprite = Sprite.ezhik_walk_two;
			this.health = 100;
			this.x = 0 + xoff;
			this.y = 0 + yoff;
			
		}

	}
	
	
	private void SeekAndDestroy() {
		float dist = (float)Math.sqrt(Math.pow(x-player.x-16, 2) + Math.pow(y-player.y-16, 2));
		if (dist > 10) {
			if (super.x+5 < player.x-15) {
				xa=1;
			}
			if (super.x-5 > player.x-15) {
				xa=-1;
			}
			if (super.y+5 < player.y-15) {
				ya=1;
			}
			if (super.y-5 > player.y-15) {
				ya=-1;
			}
			
		}
		else {
			ya = 0;
			xa = 0;
		}
	}
	
	
	public void bleed() {
		
		this.health = this.health - 5;
		
		
		if (health <= 20) {
			splat();
		}
		
		if (health <= 0) {
			this.alive = false;
		}
		
		
		for (int i=0; i<5; i++) {
			bloods.add(new Blood(x, y, true));
		}
		for (int i=0; i<5; i++) {
			bloods.add(new Blood(x, y, false));
		}
		
		
		
	}
	
	private void splat() {
		for (int i=0; i<20; i++) {
			bloods.add(new Blood(x, y, true, 300));
		}
		for (int i=0; i<20; i++) {
			bloods.add(new Blood(x, y, false, 300));
		}
		
	}
	
	
	
	
	
	public void update() {
		burp++;
		SeekAndDestroy();
		
		for (Blood blood : new ArrayList<>(bloods)) {
			blood.update();
			if (blood.isComplete()) {
				bloods.remove(blood);
			}
		}
		
		
		if (xa != 0 || ya != 0) {
			if (burp > 60) {
				this.sprite = Sprite.ezhik_walk_one;
				burp++;
				if (burp == 120) {
					burp = 0;
				}
			}
			else if (burp < 60){
				this.sprite = Sprite.ezhik_walk_two;
				burp++;
			}
		}
		move(xa, ya);
		
			
			/*if ((xa > 0 || ya > 0) && !step) {
				this.sprite = Sprite.ezhik_walk_two;
				step = true;
			}
			else if ((xa > 0 || ya > 0) && step) {
				this.sprite = Sprite.ezhik_walk_one;
				step = false;
			}*/
		

		if (burp > 5000) {
			burp = 0;
		}
		
	}
	
	public void render(Screen screen) {
		
		/*
		if (!isAlive()) {
			for (Blood blood : bloods) {
				blood.render(screen);
			}
		}
		*/
		
		if (isAlive()) {
			screen.renderMob(x+xa, y+ya, sprite);
		}
		else if (bloods.isEmpty()) {
			this.delete = true;
		}
		/*
		if (isAlive()) {
			for (Blood blood : bloods) {
				blood.render(screen);
			}
		}
		*/
	}
	
	
	public boolean isAlive() {
		return this.alive;
	}
	
	public boolean toDelete() {
		return this.delete;
	}
	
	

}
