package homework_try_02;

public class Mainclass {

	public static void main(String[] args) {
		
		// Make objects
		Butterfly b = new Butterfly("Flappy");	// Use constructor with name
		Star s = new Star();                    // Use no parameters

		// display the objects with the display method
		b.display();
		s.display();
		
		// move objects around
		b.moveDown();
		s.moveRight();

		// display the objects with the display method
		b.display();
		s.display();
		
		// Make the star twinkle
		s.superNova();

		// display the objects
		b.doYourThing();
		s.doYourThing();
		
		// Does s collide with b?	
		boolean collide = b.doesItCollide(s);
		System.out.print("collide="+ collide);
		
		
	}

}
