package homework_try_03;

public class Mainclass {

	public static void main(String[] args) {
		
		// Make objects
		Butterfly b = new Butterfly("Flappy", 1, 2);

		// display the objects with the display method
		b.display();
		
		// move objects around
		b.move();
		b.display();
				
		b.move();
		b.display();
				
		b.move();
		b.display();
				
	}

}
