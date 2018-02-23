package Claw;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInputHandler implements MouseListener {
	
	
	public boolean clicked = false;
	public int x, y;
	
	public void update() {
		
	}

	
	public void mouseClicked(MouseEvent e) {
    	
    	if (e.getButton() == MouseEvent.BUTTON1) {
    	clicked = true;
    	x = e.getX();
    	y = e.getY();
    	}
    	else 
    		clicked = false;
    	
    	if (clicked) {
    		System.out.println("x: " + x + " " + "y: " + y );
    	}
    }

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
