package Claw;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MouseInputHandler implements MouseListener {
	
	
	public boolean clicked = false;
	public boolean pressed = false;
	public int x, y;

	
	public void update() {

	}
	
	public void mouseClicked(MouseEvent e) {
    	
    	if (e.getButton() == MouseEvent.BUTTON1) {
    	clicked = true;
    	this.x = e.getX();
    	this.y = e.getY();
    	}
    	else 
    		clicked = false;
    	
    	if (clicked) {
    		System.out.println("x: " + x + " " + "y: " + y );
    	}
    }

	@Override
	public void mousePressed(MouseEvent e) {
		this.pressed = true;
		this.x = e.getX();
		this.y = e.getY();
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.pressed = false;
		this.x = e.getX();
		this.y = e.getY();
	
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
