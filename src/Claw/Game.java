package Claw;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;

//import javax.management.monitor.GaugeMonitor;
import javax.swing.JFrame;

// Main class

public class Game extends JFrame  //implements Runnable{
	{

    int fps = 60;
    
    public static int windowWidth = 300;
    public static int windowHeight = windowWidth / 16 * 9;
    public static int scale = 3;
    boolean isRunning = true;
    int x = 20;
    int y = 20;
    
    //private Thread thread;

    BufferedImage backBuffer;
    Insets insets;

    InputHandler input;
    
    /*
    public synchronized void startThread() {
    	thread = new Thread(this, "Display");
    	thread.start();
    }
    
    public synchronized void stopThread() {
    	try {
    	thread.join();
    	} catch (InterruptedException e) {
    		e.printStackTrace();
    	}
    	}
    	
    */


    public static void main(String[] args) {

        Game level1 = new Game();
        level1.run();
        
        System.exit(0);

    }

    public void run() {

        initialize();

        while(isRunning) {

            long time = System.currentTimeMillis();

            
            update();
            draw();

            time = (1000 / fps) - (System.currentTimeMillis() - time);

            if (time > 0) {
                try {
                    Thread.sleep(time);
                }
                catch(Exception e) {
                    System.out.println(e);
                }
            }
        }

        setVisible(false);

    }
    //pop
    void initialize() {

        backBuffer = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_RGB); 
        //JFrame frame = new JFrame("ayy lmao");
        setTitle("Memes"); 

        insets = getInsets();
        setSize(windowWidth + insets.left + insets.right, windowHeight + insets.top + insets.bottom); 
        setResizable(false); 

        System.out.println("insets.left");
        System.out.println(insets.left);
        System.out.println("insets.right");
        System.out.println(insets.right);
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setVisible(true); 

        input = new InputHandler(this);

    }

    void update() {

        if (input.isKeyDown(KeyEvent.VK_RIGHT)) {
            x += 5;
        }

        if(input.isKeyDown(KeyEvent.VK_LEFT)) {
            x -= 5;
        }

        if(input.isKeyDown(KeyEvent.VK_UP)) {
            y -= 5;
        }

        if(input.isKeyDown(KeyEvent.VK_DOWN)) {
            y += 5;
        }



    }

    void draw() {

        Graphics g = getGraphics(); 
        Graphics bbg = backBuffer.getGraphics();


        bbg.setColor(Color.WHITE); 
        bbg.fillRect(0, 0, windowWidth, windowHeight); 

        bbg.setColor(Color.BLACK); 
        bbg.drawOval(x, y, 20, 20); 

        g.drawImage(backBuffer, insets.left, insets.top, this); 

    }
}