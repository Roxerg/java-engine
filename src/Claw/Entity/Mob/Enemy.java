package Claw.Entity.Mob;

import Claw.Graphics.Screen;
import Claw.Graphics.Sprite;

public class Enemy extends Mob {
	
	protected int health, burp=0;
	protected Player player;
	protected int xa, ya;
	private boolean step = false;
	
	
	
	public Enemy(int type, Player player) {
		
		this.player = player;
		this.xa = 0;
		this.ya = 0;
		if (type == 1) {
			this.sprite = Sprite.ezhik_idle;
			this.health = 100;
			this.x = 0;
			this.y = 0;
			
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
		
	}
	
	
	
	public void update() {
		burp++;
		SeekAndDestroy();
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
	}
	
	

}
