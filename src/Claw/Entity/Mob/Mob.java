package Claw.Entity.Mob;

import Claw.Entity.Entity;
import Claw.Graphics.Sprite;

public abstract class Mob extends Entity {
	
	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	
	public void move() {
		
	}
	
	public void update() {
		
	}
	
	private boolean collision() {
		return false;
	}
	
	

}
