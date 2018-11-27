package homework_try_01;

public abstract  class DisplayThing {

	protected String name = "noname";
	
	protected int x, y;

	// constructor with no parameters
	public DisplayThing() {
		this.x = 0;
		this.y = 0;
	}


	// constructor with name as parameter
	public DisplayThing(String name) {
		this.name = name;
		this.x = 0;
		this.y = 0;
	}


	// Getters and Setters
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	
	// Move up/down
	public void moveUp() {
		this.y--;
	}

	public void moveDown() {
		this.y++;
	}

	public void moveLeft() {
		this.x--;
	}

	public void moveRight() {
		this.x++;
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

}
