package Claw.Entity.Mob;

import Claw.InputHandler;
import Claw.MouseInputHandler;
import Claw.Collision.CollisionDetection;
import Claw.Graphics.Screen;
import Claw.Graphics.Sprite;

public class Player extends Mob {

	private InputHandler input;
	private MouseInputHandler mouseinput;
	private Sprite sprite;
	private int anim = 0;
	private boolean walking = false;
	private int health;
	private CollisionDetection col;
	
	//public static int initialx = 100, initialy = 100;
	
	public boolean front = true;
	
	public Player(InputHandler input) {
		this.input = input;
	}
	
	public Player(int x, int y, InputHandler input, MouseInputHandler mouseinput, CollisionDetection col) {
		this.x = x;
		this.y = y;
		this.input = input;
		this.col = col;
		this.health = 5;
		this.mouseinput = mouseinput;
		sprite = Sprite.player_front;
	}
	
	public void update() {
		int xa = 0, ya = 0;
		
		//collision = col.update(x, y);
		
		
		//skating
		/*
		if (true) {
			if (input.up && col.update(x, y--)) ya--;
			if (input.down && col.update(x, y++)) ya++;
			if (input.left && col.update(x--, y)) xa--;
			if (input.right && col.update(x++, y)) xa++;
		}
		*/
		
		if (true) {
			if (input.up) ya-=2;
			if (input.down) ya+=2;
			if (input.left) xa-=2;
			if (input.right) xa+=2;
		}
		
		
		if (anim < 5000) anim++; else anim = 0; 
		
		
		if (mouseinput.clicked) {
			shoot();
		}
		
		if ((xa != 0 || ya != 0)) {
			if (!col.update(xa+x, ya+y)) {
				move(xa, ya);
				walking = true;
			}
			else {
				if (!col.update(xa+x, y)) {
					move(xa, 0);
					walking = true;
				}
				else if (!col.update(x, ya+y)) {
					move(0, ya);
					walking = true;
				}
			}
			//else if (!col.update(xa, ya+y)) {
			//	move(0, ya);
			//	walking = true;
			//}
			//move(xa, ya);
		}
		else {
			walking = false;
			//System.out.println("x: " + x + " y: "+ y);
		}
		
	}
	
	public void shoot() {
		
	}
	
	public void render(Screen screen) {
		
		int xcent = x - 8;
		int ycent = y - 8;
		
		if (dir == 2) {
			this.front = true;
			sprite = Sprite.player_front;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_front_walk;
				}
			}
			
		}
		if (dir == 0) {
			this.front = false;
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
