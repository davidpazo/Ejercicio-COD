package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Shared.Buttons;
import Shared.Keys;
import Weapons.Weapon;

public class Player extends Mob implements I_Player, MouseListener {

	private int XP;
	private Keys keys;
	private Buttons buttons;
	private AffineTransform identity = new AffineTransform();
	BufferedImage spaceshipImage;

	public Player(String playerName, int MAX_HP, int XP,
			ArrayList<Weapon> weapons, Keys keys, Buttons buttons) {
		super(playerName, MAX_HP, weapons);
		this.keys = keys;
		this.buttons = buttons;
		direction = 180;
		X_POS = 100;
		Y_POS = 100;
		setSpeed(2);
		
		setXP(XP);
	}

	public void tick() {

		if (buttons.leftClick.isPressed()) {
			setDirection(buttons.leftClick.getX(), buttons.leftClick.getY());
			if (buttons.leftDrag.isPressed())
				setDirection(buttons.leftDrag.getX(), buttons.leftDrag.getY());
		}
		if (buttons.rightClick.isPressed())
			System.out.println("Right click");
		if (keys.down.isDown)
			moveDown(true);
		if (keys.up.isDown)
			moveUp(true);
		if (keys.left.isDown)
			moveLeft(true);
		if (keys.right.isDown)
			moveRight(true);
	}

	public void render(Graphics g) {
		try {
			spaceshipImage = ImageIO.read(new File(
					"res/images/spaceship_small.png"));
			AffineTransform tx = new AffineTransform();

			tx.rotate(-Math.toRadians(direction), spaceshipImage.getWidth() / 2,
					spaceshipImage.getHeight() / 2);

			AffineTransformOp op = new AffineTransformOp(tx,
					AffineTransformOp.TYPE_BILINEAR);
			spaceshipImage = op.filter(spaceshipImage, null);
			Graphics2D g2d = (Graphics2D) g;
			g2d.drawImage(spaceshipImage, X_POS, Y_POS, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
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

	public void setLevel(int level) {
		// TODO Auto-generated method stub

	}

	public int getLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse clicked");
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
