package Shared;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import entity.Mob;
import entity.Player;


public class Base extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long REFRESH_RATE = 10;

	private Level level;
	
	/**
	 * Base class constructor
	 * @param width screen width
	 * @param height screen height
	 */
	public Base(int width, int height) {
		setSize(width, height);
		setVisible(true);
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new BaseTimer(), 0, REFRESH_RATE);
		level = new Level() ;
		createLevel();
	}
	
	/**
	 * Creates the level
	 */
	private void createLevel() {
		level.addEntity(new Player("George", 100, 0, null));
	}
	

	/**
	 * Updates screen objects
	 */
	public void update() {
		repaint();
	}
	
	public void paint (Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		level.render(g2);
	}

	/**
	 * Class used to keep call re-draw method
	 * @author jiggy
	 *
	 */
	class BaseTimer extends TimerTask {

		
		public void run() {
			update();
		}
		
	}
	
}
