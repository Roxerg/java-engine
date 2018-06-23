package Claw.Collision;

import java.util.ArrayList;


import Claw.Entity.Mob.Player;
import Claw.Graphics.Sprite;
import Claw.Level.Tile.Tile;
import Claw.Entity.Mob.*;

public class CollisionDetection {
	
	
	
	//public Player player;
	private ArrayList<Collider> collisions;
	private int width, height;
	private ArrayList<Enemy> enemies;
	
	
	
	// do a separate check to see if the tile that was just placed is a solid one, if so, add it to list.
	public CollisionDetection(int[] tiles, ArrayList<Enemy> enemies, int width, int height) {
		
		//this.player = p;
		collisions = new ArrayList<Collider>(10000);
		this.width = width;
		this.height = height;
		this.enemies = enemies;
		
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				if (tiles[x+y*width] == 0xff666666) {
					collisions.add(new Collider(x*16, y*16));
				}
			}
		}
		
		//collisions.add(new Collider(0, 0));
		
		//for (Collider c : collisions) {
		//	System.out.println("collision! cx: " + c.getX() + " cy: " + c.getY());
		//}
		
	}
	
	
	
	
	public boolean update(int x, int y) {
	
		//System.out.println(x + " " +y );
		double radius = (double)Math.sqrt(Math.pow(Sprite.grass1.SIZE/2, 2) + Math.pow(Sprite.grass1.SIZE/2, 2))*2;
		
		for (Collider c : collisions) {
			//System.out.println(c.getX());
			
			/*if (c.getX() > player.x && c.getX()-16 < player.x 
			 && c.getY()-16 < player.y && c.getY() > player.y) {
				System.out.println("collision! cx: " + c.getX() + "px: " + player.x + " cy: " + c.getY() + " py: " + player.y);
			}*/
			double dist = (double)Math.sqrt(Math.pow(Math.abs(c.getX()+8 - x), 2) + Math.pow(Math.abs(c.getY()+8 - y), 2));
			//System.out.println("dist" + " " + dist);
			if (dist <= radius) {
				//System.out.println(" partial collision! cx: " + c.getX() + "px: " + x + " cy: " + c.getY() + " py: " + y);
				if ((c.getX()+16 > x+8 || c.getX()+16 > x-8) && (c.getX() < x+8 || c.getX() < x-8)
				 && (c.getY() < y+8 || c.getY() < y-8) && (c.getY()+16 > y+8 || c.getY()+16 > y-8)) {
					//System.out.println("collision! cx: " + c.getX() + "px: " + x + " cy: " + c.getY() + " py: " + y);
					return true;
				}
				//System.out.println("collision!" + dist + " " + radius + " " + Sprite.grass1.SIZE);
				//return true;
			}
		}
		return false;
		
	}
	
	public boolean simpleupdate(int x, int y) {
		
		double radius = (double)Math.sqrt(Math.pow(Sprite.grass1.SIZE/2, 2) + Math.pow(Sprite.grass1.SIZE/2, 2))*1.0;
		
		for (Collider c : collisions) {
		
			double dist = (double)Math.sqrt(Math.pow(Math.abs(c.getX() - x), 2) + Math.pow(Math.abs(c.getY() - y), 2));
			
			if (dist <= radius) {
				//System.out.println(" partial collision! cx: " + c.getX() + "px: " + x + " cy: " + c.getY() + " py: " + y);
				//	return true;
				System.out.println("dist" + " " + dist + " radius " + radius);
				return true;
			}
		}
		return false;
		
	}
	
	
	public boolean enemycollision(int x, int y) {
		for (Enemy mob : enemies) {
			int mobx = mob.x;
			int moby = mob.y;
			
			mob.bleed();
			
			if (x < mobx+36 && x > mobx-16 &&  y > moby && y < moby+18) {
				return true;
				
			}
		}
		return false;
	}

}
