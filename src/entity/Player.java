package entity;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.lang.model.element.PackageElement;

import Weapons.Weapon;

public class Player extends Mob implements I_Player{
	
	private int XP;
	
	public Player(String playerName, int MAX_HP, int XP, ArrayList<Weapon> weapons) {
		super(playerName, MAX_HP, weapons);
		
		setXP(XP);
		
	}
	
	public void render(Graphics2D g) {
		g.drawString(name, 200, 200);
	}
	
	public void setXP(int XP) {
		this.XP = XP;
	}

	public int getXP() {
		return XP;
	}

	public void addXP(int XP) {
		this.XP += XP;
	}

	@Override
	public void setLevel(int level) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
