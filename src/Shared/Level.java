package Shared;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import entity.Entity;

public class Level {

	private ArrayList<Entity> entities = new ArrayList<Entity>();
	
	/**
	 * Adds an entity
	 * @param e {@link Entity} 
	 */
	public void addEntity(Entity e) {
		entities.add(e);
	}
	
	/**
	 * Removes an entity
	 * @param e {@link Entity} 
	 * @return {@link boolean} returns true if removed
	 */
	public boolean removeEntity(Entity e) {
		return entities.remove(e);
	}
	
	/**
	 * Renders all entities to screen
	 * @param g {@link Graphics2D}
	 */
	public void render(Graphics2D g) {
		for (Entity e : entities) {
			e.render(g);
		}
	}
	
}
