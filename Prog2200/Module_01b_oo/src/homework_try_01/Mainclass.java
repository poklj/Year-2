package homework_try_01;

public class Mainclass {

	public static void main(String[] args) {

		// Declare object as Butterfly
		Butterfly b = new Butterfly("Flappy");
		b.display();
		b.doYourThing();
		b.leaveCocoon();
		b.moveDown();
		b.display();

		// Declare object as base class DisplayThing
		 DisplayThing t = new Butterfly("Flappy2");
		 t.display();
		 t.doYourThing();
		 t.moveLeft();
		 t.display();

		// base type cannot do derived type methods because
		// it doesn't know about them.
		//t.leaveCocoon();
	}

}
