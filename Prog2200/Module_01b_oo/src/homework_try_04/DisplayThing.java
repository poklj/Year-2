package homework_try_04;

public abstract  class DisplayThing extends Thread {

	protected String name = "noname";
	
	protected int x, y;        // Position
	protected int dx, dy;      // Change in Position (velocity)

	// constructor with no parameters
	public DisplayThing() {
		this.x = 0;
		this.y = 0;
	}

	// constructor with name as parameter
	public DisplayThing(String name) {
		this.name = name;
		this.x = 0;         // always start at 0,0 Position 
		this.y = 0;
	}

	// constructor with name as parameter
	public DisplayThing(String name, int dx, int dy) {
		this.name = name;
		this.x = 0;         // always start at 0,0 Position 
		this.y = 0;
		this.dx = dx;
		this.dy = dy;
	}
	
	// Move per velocity
	public void move() {
		this.x = this.x + this.dx;
		this.y = this.y + this.dy;
	}

	// move a bunch of times when started
	public void run() {
		Boolean landed = false;
		while (!landed) {
			this.sleepAlittle(10);  // allow delay or it zips to end
			this.move();
			if (y==0) {
				landed = true;}
		}
		
		
		for(int i=0; i<1000; i++) {   // loop a bunch, tweak this for longer/shorter
			this.sleepAlittle(10);  // allow delay or it zips to end
			this.move();
		}			
	}
	
	// abstract doYourThing method
	public abstract void doYourThing();

	
	public void display() {
		System.out.println("Name=" + this.name + 
				" Class=" + this.getClass() + 
				" X=" + this.x +
				" Y=" + this.y );
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
