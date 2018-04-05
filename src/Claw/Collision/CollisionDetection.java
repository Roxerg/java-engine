package Claw.Collision;

import java.util.ArrayList;

import Claw.Entity.Mob.Player;
import Claw.Graphics.Sprite;
import Claw.Level.Tile.Tile;

public class CollisionDetection {
	
	
	
	private Player player;
	private ArrayList<Collider> collisions;
	private int width, height;
	
	
	
	// do a separate check to see if the tile that was just placed is a solid one, if so, add it to list.
	public CollisionDetection(Player p, int[] tiles, int width, int height) {
		
		this.player = p;
		collisions = new ArrayList<Collider>(1000);
		this.width = width;
		this.height = height;
		
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				if (tiles[x+y*width] == 0xff666666) {
					collisions.add(new Collider(x*16, y*16));
				}
			}
		}
		
		for (Collider c : collisions) {
			System.out.println("collision! cx: " + c.getX() + " cy: " + c.getY());
		}
		
	}
	
	
	
	
	public void update() {
		
		for (Collider c : collisions) {
			
			//System.out.println(c.getX());
			
			if (c.getX() > player.x && c.getX()-16 < player.x 
			 && c.getY()-16 < player.y && c.getY() > player.y) {
				System.out.println("collision! cx: " + c.getX() + "px: " + player.x + " cy: " + c.getY() + " py: " + player.y);
			}
			
		}
		
	}

}
