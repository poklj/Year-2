package com.example.russ.m08_net_02.client;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;

import java.awt.event.KeyEvent;

public class theCat extends Thread implements KeyListener {

	/**
	 * theCat will start writing on the page (g) using the text in the given
	 * buffer. The delay will determine how fast it writes and the xLocation
	 * will determine where to start.
	 */
	volatile boolean cat_alive = false;
	volatile boolean cat_active = false;
	private String catName;
	private int delay;
	private int xLocation;
	private int yLocation = 40;

	private int xVel = 0;
	private int yVel = 0;

	private int xMin = 0;
	private int xMax = 600;
	private int yMin = 0;
	private int yMax = 700;

	private Color catColor;
	final int increment = 1;
	final int shapeSize = 40;
	// Declare array of colors (range is 0 to thing.length)
	private int maxSize = 400; // roll-over cat location to zero when they reach
								// maxSize

	public theCat(int xStart, int yStart, int xVel, int yVel, int catColor,
			String theText) {
		this.delay = 10;
		this.xLocation = xStart;
		this.yLocation = yStart;
		this.xVel = xVel;
		this.yVel = yVel;
		
		this.catColor = new Color(catColor, true);  // create color from Alpha-rgb int
		this.catName = theText;

		System.out.println("Constructor for theCat: " + this.catName);
	}

	public void killCat() {
		if (cat_alive) {
			cat_alive = false;
		}
	}

	public void activateCat() {
		if (!cat_active) {
			cat_active = true;
		}
	}

	public void sleepCat() {
		if (cat_active) {
			cat_active = false;
		}
	}

	public void resetCat(String s) {
		yLocation = (int) (Math.random() * maxSize);
		xLocation = (int) (Math.random() * maxSize);
		catName = s;
	}

	@Override
	public void run() {

		System.out.println("Start theCat: " + this.catName);

		// Initial settings
		cat_alive = true;
		cat_active = true;

		while (cat_alive == true) {
			while (cat_alive == true && cat_active == true) {

				if (justBounced > 0) {
					justBounced = justBounced - 1;
				}

				// move based on increment
				// xLocation = (xLocation + increment) % maxSize;
				xLocation = xLocation + xVel;
				yLocation = yLocation + yVel;

				if (xLocation > xMax) {
					xVel = -xVel;
				}
				if (xLocation < xMin) {
					xVel = -xVel;
				}

				if (yLocation > yMax) {
					yVel = -yVel;
				}
				if (yLocation < yMin) {
					yVel = -yVel;
				}

				// If thread loops too fast, the cat leaves a "trail"
				sleepAlittle(delay);
			}

			System.out.println(catName + " sleeping");
			sleepAlittle(500);
		}

		System.out.println("theCat " + catName + " is no longer alive");
	}

	private void sleepAlittle(int s) {
		try {
			sleep(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void Paint(Graphics g) {
		// Draw new graphic
		g.setColor(catColor);
		g.fillOval(xLocation - shapeSize / 2, yLocation - shapeSize / 2,
				shapeSize, shapeSize);
		g.drawChars(catName.toCharArray(), 0, catName.toCharArray().length,
				xLocation - shapeSize / 2, yLocation - shapeSize / 2);
	}

	@Override
	public void keyPressed(KeyEvent e) {
//		System.out.println("Keycode=" + e.getKeyCode() + " x loc=" + xLocation
//				+ " y loc=" + yLocation);

		int ch = e.getKeyCode();
		switch (ch) {
		case KeyEvent.VK_UP:
			yVel++;
			break;
		case KeyEvent.VK_DOWN:
			yVel--;
			break;
		case KeyEvent.VK_LEFT:
			xVel--;
			break;
		case KeyEvent.VK_RIGHT:
			xVel++;
			break;
		case KeyEvent.VK_SPACE: //toggle color
			if (catColor == Color.red) {
				catColor = Color.BLACK;
			} else {
				catColor = Color.red;
			}
			break;

		case KeyEvent.VK_ESCAPE:
			System.exit(0); // end if esc pressed
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// System.out.println("B key=" + e.getKeyChar());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// System.out.println("C key=" + e.getKeyChar());
	}

	final int bounceSetting = 10; // # of times to ignore next bounces
	final int closeVal = shapeSize / 2; // How close to trigger collision
	int justBounced = bounceSetting; // Count down var for bounce

	public boolean close(theCat a, theCat b) {
		boolean isClose = false;

		// Don't bounce multiple times in one collision
		if ((justBounced == 0)
				&& (Math.abs(a.xLocation - b.xLocation) < closeVal)
				&& (Math.abs(a.yLocation - b.yLocation) < closeVal)) {
			isClose = true;
			justBounced = bounceSetting;
			// System.out.println("Collide="+a.xLocation +" "+ b.xLocation
			// +" "+a.yLocation +" "+ b.yLocation);
		}
		return isClose;
	}

	public void bounce() {
		xVel = -xVel;
		yVel = -yVel;
	}
}