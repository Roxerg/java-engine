package Claw;


//import java.awt.Component;
import java.awt.event.*;


public class InputHandler implements KeyListener {

	public int KEY_ARRAY_SIZE = 256;
	public int xoff = 0, yoff = 0;
	public boolean up, down, left, right;
    boolean[] keys = new boolean[KEY_ARRAY_SIZE];
    
    public int x, y;
    
    public boolean clicked = false;;
    
    /*public InputHandler(Component c) {
        c.addKeyListener(this);
    }*/
    
    public void update() {
    	up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
    	down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
    	left  = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
    	right  = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
    	

    	
    	//if (up) { yoff--; }
    	//if (down) { yoff++; }
    	//if (left) { xoff--; }
    	//if (right) { xoff++; }
    	
    }
    
    

    public boolean isKeyDown(int keyCode) {

        if (keyCode > 0 && keyCode < KEY_ARRAY_SIZE) 
                { 
                        return keys[keyCode]; 
                } 
                
                return false; 

    }

    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() > 0 && e.getKeyCode() < KEY_ARRAY_SIZE) {
            keys[e.getKeyCode()] = true;
        }

    }

    public void keyReleased(KeyEvent e) {

        if (e.getKeyCode() > 0 && e.getKeyCode() < KEY_ARRAY_SIZE) {
            keys[e.getKeyCode()] = false;
        }

    }

    public void keyTyped(KeyEvent e) {

    }
}