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
	
	
	
	public Enemy(int type, Player player) {
		
		Random rng = new Random();
		
		this.bloods = new ArrayList<Blood>();
		
		int xoff = rng.nextInt(1000);
		int yoff = rng.nextInt(1000);
		
		System.out.println("enemy stuff:");
		System.out.println(xoff + yoff);
		
		this.player = player;
		this.xa = 0;
		this.ya = 0;
		if (type == 1) {
			this.sprite = Sprite.ezhik_idle;
			this.health = 100;
			this.x = 0 + xoff;
			this.y = 0 + yoff;
			
		}

	}
	
	
	private void SeekAndDestroy() {
		if (Math.sqrt(Math.pow(super.x-player.x-16, 2) + Math.pow(super.y-player.y-16, 2)) > 1) {
			if (super.x < player.x-16) {
				xa=1;
			}
			if (super.x > player.x-16) {
				xa=-1;
			}
			if (super.y < player.y-16) {
				ya=1;
			}
			if (super.y > player.y-16) {
				ya=-1;
			}
			
		}
		else {
			ya = 0;
			xa = 0;
		}
	}
	
	
	public void bleed() {
		
		
		for (int i=0; i<5; i++) {
			bloods.add(new Blood(x, y, true));
		}
		for (int i=0; i<5; i++) {
			bloods.add(new Blood(x, y, false));
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
		
		
		if (burp % 2 == 0) {
			move(xa, ya);
			if ((xa > 0 || ya > 0) && !step) {
				this.sprite = Sprite.ezhik_walk_two;
				step = true;
			}
			else if ((xa > 0 || ya > 0) && step) {
				this.sprite = Sprite.ezhik_walk_one;
				step = false;
			}
		}

		if (burp > 5000) {
			burp = 0;
		}
		
	}
	
	public void render(Screen screen) {
		screen.renderMob(x+xa, y+ya, sprite);
		for (Blood blood : bloods) {
			blood.render(screen);
		}
	}
	
	

}
