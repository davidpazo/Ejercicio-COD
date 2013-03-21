package Weapons;

public interface Weapon {
	
	int getAmmo();
	int setAmmo();
	int addAmmo();
	
	int fire();
	
	int setDamage();
	int getDamage();
	
	int getBlastRadius();
	int setBlastRadius();
	
}
