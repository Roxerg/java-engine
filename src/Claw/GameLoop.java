package Claw;

//Ctrl + Shift + O
import java.awt.Canvas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;


import Claw.Graphics.Screen;
import Claw.Level.Level;
import Claw.Level.LevelEditor;
import Claw.Level.RandomLevel;
import Claw.Level.SpawnLevel;
import Claw.InputHandler;
import Claw.MouseInputHandler;
import Claw.Collision.CollisionDetection;
import Claw.Entity.Mob.Gun;
import Claw.Entity.Mob.Player;

public class GameLoop extends Canvas implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public static int windowWidth = 300;
    public static int windowHeight = windowWidth / 16 * 9;
    public static int scale = 3;
    public static String title = "Project Claw";
    public static int initialx = 100, initialy = 100;
    public boolean editorEnabled = false;
	
    public static int levelWidth = 100;
    public static int levelHeight = 100;
    
	private boolean running = false;
	
	private BufferedImage view = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_RGB);
	private int[] px = ((DataBufferInt)view.getRaster().getDataBuffer()).getData();
	
	
	private InputHandler input;
	
	private MouseInputHandler mouseinput;
	private MouseMovementHandler mousemove;
	
	private JFrame frame; 
	private Thread thread;
	private Screen render;
	
	private Level  level;
	private Player player;
	private Gun gun; 
	
	private CollisionDetection collision;
	
	
	public GameLoop() {
		
		
		
		Dimension frameSize = new Dimension(windowWidth * scale, windowHeight * scale); 
		setPreferredSize(frameSize);
		
		render = new Screen(windowWidth, windowHeight);
		
		frame = new JFrame();
		
		input = new InputHandler();
		
		// for map editor
		mouseinput = new MouseInputHandler();
		mousemove = new MouseMovementHandler();
	
		
		//level = new SpawnLevel("/sprites/level.png");
		
		
		
		
		
		
		
		
		addKeyListener(input);
		addMouseListener(mouseinput);
		addMouseMotionListener(mousemove);
		
		// for map editor
		level = new LevelEditor(mouseinput, mousemove, levelWidth, levelHeight, editorEnabled);
		
		
		collision = new CollisionDetection(level.tilecolor, levelWidth, levelHeight);
		player = new Player(initialx, initialy, input, mouseinput, collision);
		gun = new Gun(player, mouseinput, mousemove, collision);
		
		//System.out.println(mouseinput.clicked);
		
	}
	
	
	
	public synchronized void startThread() {
		running = true;
    	thread = new Thread(this, "Display");
    	thread.start();
    }
    
    public synchronized void stopThread() {
    	running = false;
    	try {
    	thread.join();
    	} catch (InterruptedException e) {
    		e.printStackTrace();
    	}
    	}
	
	public void run() {
		
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int ticks = 0;
		System.out.println("Running!");
		
		
		requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta += (now-lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				ticks++;
				delta--;
			}
			draw();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frame.setTitle(title + " | " + ticks + " ups, " + frames + " fps");
				ticks = 0;
				frames = 0;
			}
		}
		
	}
	
	public void tick() {
		
		input.update();
		player.update();
		gun.update();
		
		if (input.saveMap) {
			input.saveMap = false;
			level.saveMapState();
		}
		
		level.update();
		
		
		//collision.update();
		
		//System.out.println("x: " + mousemove.x + " y: " + mousemove.y);
		
		
		
		//xoff = input.xoff;
		//yoff = input.yoff;
		
	}
	
	public void draw() {
		
		BufferStrategy buffstrat = getBufferStrategy();
		if (buffstrat == null) {
			createBufferStrategy(3);
			return;
		}
		
		render.clear();
		
		int xScroll = player.x - render.width/2 ;
		int yScroll = player.y - render.height/2 ;
		
		
		level.render(xScroll, yScroll, render);
		
		
		// for map editor
		if (editorEnabled) {
			level.UpdateMap(xScroll, yScroll);
		}
				
		
		
		
		player.render(render);
		gun.render(render);
		
		//for map editor
		if (editorEnabled) {
			render.renderHUDEditor(level.a, level.b);
		}
		
		
		
		for (int i = 0; i < px.length; i++) {
			px[i] = render.px[i];
		}
		
		Graphics g = buffstrat.getDrawGraphics();
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(view,  0,  0,  getWidth(),  getHeight(), null);
		g.dispose();
		
		buffstrat.show();
		
		
		
		
	}

	
	public static void main(String[] args) {
		GameLoop GameLoop = new GameLoop();
		GameLoop.frame.setResizable(false);
		GameLoop.frame.setTitle(title);
		GameLoop.frame.add(GameLoop);
		GameLoop.frame.pack();
		GameLoop.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameLoop.frame.setLocationRelativeTo(null);
		GameLoop.frame.setVisible(true);
		
		GameLoop.startThread();
	}
	
	
}
