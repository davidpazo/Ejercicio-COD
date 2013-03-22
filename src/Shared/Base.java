package Shared;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

import entity.Mob;
import entity.Player;

public class Base extends Canvas implements Runnable, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long frameRate = 60;
	private int fps;

	private Level level;
	public Keys keys = new Keys();
	private boolean running;
	private Buttons buttons = new Buttons();
	private MouseHandler mouseHandler = new MouseHandler(buttons);
		
		

	/**
	 * Base class constructor
	 * 
	 * @param width
	 *            screen width
	 * @param height
	 *            screen height
	 */
	public Base() {
		// Add listeners
		this.addKeyListener(new InputHandler(keys));
		this.addMouseMotionListener(mouseHandler);
		this.addMouseListener(mouseHandler);
		// Create the screen

		// Create the level
		createLevel();

	}

	/**
	 * Creates the level
	 */
	private void createLevel() {
		level = new Level();
		level.addEntity(new Player("George", 100, 0, null, keys, buttons ));

		// Timer timer = new Timer();
		// timer.scheduleAtFixedRate(new BaseTimer(), 0, REFRESH_RATE);
	}

	/**
	 * Updates screen objects
	 */
	public void tick() {
		level.tick();
	}

	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 4000, 3000);
		level.render(g);
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void start() {
		Thread thread = new Thread(this);
		thread.setPriority(Thread.MAX_PRIORITY);
		thread.start();
		running = true;
		requestFocus();
	}

	public void stop() {
		running = false;
	}

	public void run() {
		long lastTime = System.nanoTime();
		double unprocessed = 0;
		int frames = 0;
		long lastTimer1 = System.currentTimeMillis();

		int toTick = 0;

		long lastRenderTime = System.nanoTime();
		int min = 999999999;
		int max = 0;

		while (running) {
			double nsPerTick = 1000000000.0 / frameRate;
			boolean shouldRender = false;
			while (unprocessed >= 1) {
				toTick++;
				unprocessed -= 1;
			}

			int tickCount = toTick;
			if (toTick > 0 && toTick < 3) {
				tickCount = 1;
			}
			if (toTick > 20) {
				toTick = 20;
			}

			for (int i = 0; i < tickCount; i++) {
				toTick--;
				tick();
				shouldRender = true;

			}
			BufferStrategy bs = getBufferStrategy();
			if (bs == null) {
				createBufferStrategy(3);
				continue;
			}
			
			if (shouldRender) {
				frames++;
				Graphics g = bs.getDrawGraphics();
				
				render(g);
				long renderTime = System.nanoTime();
				int timePassed = (int) (renderTime - lastRenderTime);
				if (timePassed < min) {
					min = timePassed;
				}
				if (timePassed > max) {
					max = timePassed;
				}
				lastRenderTime = renderTime;
			}
			long now = System.nanoTime();
			unprocessed += (now - lastTime) / nsPerTick;
			lastTime = now;

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
            if (shouldRender) {
                if (bs != null) {
                    bs.show();
                }
            }

			if (System.currentTimeMillis() - lastTimer1 > 1000) {
				lastTimer1 += 1000;
				fps = frames;
				frames = 0;
			}
		}
	}

}
