package Claw.Entity.Particle;

import java.util.ArrayList;
import java.util.Random;

import Claw.Entity.Entity;
import Claw.Graphics.Screen;
import Claw.Graphics.Sprite;

public class Blood extends Entity {

	public int x, y;
	private Sprite sprite;
	private boolean right;
	private int maxx, maxy;
	private boolean complete = false;
	private int counter, duration;
	
	
	
	public Blood(int x, int y, boolean right) {
		this.x = x;
		this.y = y;
		this.right = right;
		ArrayList<Sprite> list = new ArrayList<Sprite>();
		list.add(Sprite.blood1);
		list.add(Sprite.blood2);
		list.add(Sprite.blood3);
		Random rng = new Random();
		this.sprite = list.get(rng.nextInt(list.size()));
		int a = 6+rng.nextInt(10);
		int b = 2+rng.nextInt(20);
		
		if (!right) {
			a *= -1;
			b *= -1;
		}
		
		this.maxx = x+a;
		this.maxy = y+b;
		
		this.duration = 0;
		this.counter = 1;
		
	}
	
	
	// for SPLAT
	public Blood(int x, int y, boolean right, int duration) {
		this.x = x;
		this.y = y;
		this.right = right;
		ArrayList<Sprite> list = new ArrayList<Sprite>();
		list.add(Sprite.blood1);
		list.add(Sprite.blood2);
		list.add(Sprite.blood3);
		Random rng = new Random();
		this.sprite = list.get(rng.nextInt(list.size()));
		int a = 6+rng.nextInt(30);
		int b = 4+rng.nextInt(20);
		
		if (!right) {
			a *= -1;
			b *= -1;
		}
		
		this.maxx = x+a;
		this.maxy = y+b;
		
		this.counter = 1;
		this.duration = duration;
		
		
	}
	
	
	
	
	public void update() {
		// x = 0.5*a*t^2 + v0*t + x0
		this.counter++;
		
		if (right) {
			if (maxx > x) {
				this.x++;
			}
			else if (duration == 0 ){
				this.complete = true;
			}
		}
		else {
			if (maxx < x) {
				this.x--;
			}
			else if (duration == 0) {
				this.complete = true;
			}
		}
		
		if (y < maxy) {
			this.y++;
		}
		
		if (counter == duration) {
			this.complete = true;
		}
		
		
		
	}
	
	
	public void render(Screen screen) {
		screen.renderSprite(x, y, sprite);
	}
	
	public boolean isComplete() {
		return this.complete;
	}
	
	
	
	
}
