package homework_try_04;

public class Mainclass {

	public static void main(String[] args) {

		// Make objects
		Butterfly b = new Butterfly("Flappy", 1, 2);
		b.start(); // start the thread

		// display the object, delay, display again
		// The thread inside the object is moving it forward
		sleepAlittle(5000);
		b.display();
		//sleepAlittle(500);
		b.display();
		//sleepAlittle(600);
		b.display();
		//sleepAlittle(900);
		b.display();

	}

	// Sleep and catch exception
	public static void sleepAlittle(int milli) {
		try {
			Thread.sleep(milli);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
