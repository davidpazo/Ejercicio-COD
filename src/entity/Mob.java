package entity;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import Weapons.Weapon;

public class Mob extends Entity implements I_Mob  {

	protected String name;
	protected int HP;
	protected int MAX_HP;
	@SuppressWarnings("unused")
	private ArrayList<Weapon> weaponsList;
	private int X_POS;
	private int Y_POS;
	private int speed;
	private int direction;

	 /**
	 * Creates a player
	 * 
	 * @param name
	 *            {@link String} Player name
	 * @param HP
	 *            {@link int} Start health
	 * @param XP
	 *            {@link int}Start XP
	 * @param weapons
	 *            ArrayList of {@link Weapon} that the player will start with
	 */
	public Mob(String name, int MAX_HP, ArrayList<Weapon> weapons) {
		super();
		setWeapons(weapons);
		setName(name);
		setMaxHP(MAX_HP);
		setHP(MAX_HP);
	}

	public void setHP(int HP) {
		this.HP = HP;
	}

	public int getHP() {
		return HP;
	}

	public void addHP(int HP) {
		this.HP = this.HP += HP > MAX_HP ? MAX_HP : this.HP + HP;
	}

	public void setMaxHP(int MAX_HP) {
		this.MAX_HP = MAX_HP;
	}


	public int getXPosition() {
		return X_POS;
	}

	public int getYPosition() {
		return Y_POS;
	}

	public void setSpeed(int SPD) {
		this.speed = SPD;
	}

	public void increaseSpeed(int SPD_UP) {
		speed += SPD_UP;
	}

	public void decreaseSpeed(int SPD_DOWN) {
		speed -= SPD_DOWN;
	}

	public void moveLeft(boolean LFT) {
		if (LFT) {
			X_POS -= speed;
		}

	}

	public void moveRight(boolean RGT) {
		if (RGT) {
			X_POS += speed;
		}
	}

	public void moveUp(boolean UP) {
		if (UP) {
			Y_POS -= speed;
		}
	}

	public void moveDown(boolean DWN) {
		if (DWN) {
			Y_POS += speed;
		}
	}

	public void setDirection(int dir) {
		direction = dir;
	}

	public void setDirection(int x, int y) {
		direction = (int) Math
				.toDegrees(Math.atan((Math.abs(this.Y_POS - y) / Math
						.abs(this.X_POS - x))));
	}

	public int getDirection() {
		return direction;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setWeapons(ArrayList<Weapon> WPN) {
		weaponsList = WPN;
	}

	@Override
	public void render(Graphics g) {
			g.drawString(name, 300, 300);
	}

}
