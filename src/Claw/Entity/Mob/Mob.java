package Claw.Entity.Mob;

import Claw.Entity.Entity;
import Claw.Graphics.Sprite;

public abstract class Mob extends Entity {
	
	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	
	public void move(int xx, int yy) {
		
		if (yy < 0) dir = 0;
		//if (xx > 0) dir = 1;
		if (yy > 0) dir = 2;
		//if (xx < 0) dir = 3;
		
		if(!collision()) {
			x += xx;
			y += yy;
		}
		
		
	}
	
	public void update() {
		
	}
	
	private boolean collision() {
		return false;
	}
	
	

}
