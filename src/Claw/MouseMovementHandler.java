package Claw;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MouseMovementHandler extends MouseMotionAdapter {
	
	public int x = 0, y = 0;
	public int xs = 0, ys = 0;
	
	public void mouseMoved(MouseEvent e) {
		
		this.x = e.getX();
    	this.y = e.getY();
	}
	
	public void mouseDragged(MouseEvent e) {
		this.x = e.getX();
		this.y = e.getY();
	}


}
