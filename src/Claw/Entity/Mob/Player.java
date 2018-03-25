package Claw.Entity.Mob;

import Claw.InputHandler;
import Claw.MouseInputHandler;
import Claw.Graphics.Screen;
import Claw.Graphics.Sprite;

public class Player extends Mob {

	private InputHandler input;
	private MouseInputHandler mouseinput;
	private Sprite sprite;
	private int anim = 0;
	private boolean walking = false;
	public static int initialx = 100, initialy = 100;
	
	
	public Player(InputHandler input) {
		this.input = input;
	}
	
	public Player(int x, int y, InputHandler input, MouseInputHandler mouseinput) {
		this.x = x;
		this.y = y;
		this.input = input;
		this.mouseinput = mouseinput;
		sprite = Sprite.player_front;
	}
	
	public void update() {
		int xa = 0, ya = 0;
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;
		
		if (anim < 5000) anim++; else anim = 0; 
		
		
		if (mouseinput.clicked) {
			shoot();
		}
		
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		}
		else {
			walking = false;
		}
		
	}
	
	public void shoot() {
		
	}
	
	public void render(Screen screen) {
		
		int xcent = x - 8;
		int ycent = y - 8;
		
		if (dir == 2) {
			sprite = Sprite.player_front;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_front_walk;
				}
			}
			
		}
		if (dir == 0) {
			sprite = Sprite.player_back;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_back_walk;
				}
			}
		}
		
		screen.renderPlayer(xcent, ycent, sprite);
		

		
	}
	
	
	
	
}
