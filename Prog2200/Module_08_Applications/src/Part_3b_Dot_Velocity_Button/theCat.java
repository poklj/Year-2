package Part_3b_Dot_Velocity_Button;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

/**
 * 
 * Make a cat that moves x,y position using it's own internal thread and
 * supports handlers for both keystroke and button press events.
 *
 */
public class theCat extends Thread implements KeyListener, ActionListener {

	/**
	 * theCat will start writing on the page (g) using the text in the given
	 * buffer. The delay will determine how fast it writes and the start
	 * Location will determine where to start.
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

	private int yStart; // original starting location

	private Color catColor;
	final int increment = 1;
	final int shapeSize = 40;
	// Declare array of colors (range is 0 to thing.length)
	private int maxSize = 400; // roll-over cat location to zero when they reach
								// maxSize

	public theCat(String theText, int delay, int yStart, Color catColor) {
		this.catName = theText;
		this.delay = delay;
		this.yStart = yStart;
		this.xLocation = 0;
		this.yLocation = yStart;
		this.catColor = catColor;

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

	public void resetName(String s) {
		catName = s;
	}

	public void resetPos() {
		yLocation = (int) (Math.random() * maxSize);
		xLocation = (int) (Math.random() * maxSize);
	}

	public void resetVel() {
		yVel = (int) (Math.random() * 50.0 - 25.0);
		xVel = (int) (Math.random() * 50.0 - 25.0);
	}

	@Override
	public void run() {

		System.out.println("Start theCat: " + this.catName);

		// Initial settings
		xLocation = 0;
		yLocation = yStart;
		cat_alive = true;
		cat_active = true;

		while (cat_alive == true) {
			while (cat_alive == true && cat_active == true) {

				// move based on velocity increment
				xLocation = xLocation + xVel;
				yLocation = yLocation + yVel;

				// Collision with walls
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

	void Paint(Graphics g) {
		// Draw new graphic
		g.setColor(catColor);
		g.fillOval(xLocation, yLocation, shapeSize, shapeSize);
	}

	/**
	 * Handle when a key is pressed
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Keycode=" + e.getKeyCode() + " x loc=" + xLocation
				+ " y loc=" + yLocation);

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

	/**
	 * Handle when the button is pressed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Button pressed  => " + e.toString());

		if (e.getActionCommand().matches("ResetPos")) {
			this.resetPos();
		}
		if (e.getActionCommand().matches("ResetVel")) {
			this.resetVel();
		}

	}
}