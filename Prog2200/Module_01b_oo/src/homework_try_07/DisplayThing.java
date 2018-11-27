package homework_try_07;

public abstract class DisplayThing extends Thread {

	protected String name = "noname";

	protected int x, y; // Position
	protected int dx, dy; // Change in Position (velocity)
	protected int ddx, ddy; // Change in Velocity (Acceleration)

	// constructor with no parameters
	public DisplayThing() {
		this.x = 0;
		this.y = 0;
	}

	// constructor with name as parameter
	public DisplayThing(String name) {
		this.name = name;
		this.x = 0; // always start at 0,0 Position
		this.y = 0;
	}

	// constructor with name as parameter
	public DisplayThing(String name, int dx, int dy) {
		this.name = name;
		this.x = 0; // always start at 0,0 Position
		this.y = 0;
		this.dx = dx;
		this.dy = dy;
		this.ddx = 0; // Slight down gravity
		this.ddy = -1;
	}

	// Move per velocity
	public void move() {
		// Change position
		this.x = this.x + this.dx;
		this.y = this.y + this.dy;
		// Change velocity per gravity
		this.dx = this.dx + this.ddx;
		this.dy = this.dy + this.ddy;
	}

	Boolean landed = false;

	// move a bunch of times when started
	public void run() {

		while (!landed) {
			this.sleepAlittle(10); // allow delay or it zips to end
			this.move();
			if (y < 0) {
				landed = true;
			}
		}
		this.doYourThing();
	}

	// abstract doYourThing method
	public abstract void doYourThing();

	public void display() {
		// System.out.println("Name=" + this.name + " Class=" + this.getClass() + " X="
		// + this.x + " Y=" + this.y);
		if (!landed) {
//			System.out.println("Name=" + this.name + ", X=" + this.x + ", Y=" + this.y + ", dX=" + this.dx + ", dY="
//					+ this.dy + ", ddX=" + this.ddx + ", ddY=" + this.ddy);
			System.out.println("Name=" + this.name + ", " + this.x + ", " + this.y + ", " + this.dx + ", "
					+ this.dy + ", " + this.ddx + ", " + this.ddy);
		}
	}

	// Collision method
	public boolean doesItCollide(DisplayThing other) {
		System.out.println("x=" + this.x + "y=" + this.y + " other x = " + other.x + "other y" + other.y);
		return false;
	}

	// Sleep and catch exception
	public void sleepAlittle(int milli) {
		try {
			Thread.sleep(milli);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
