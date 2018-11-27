package homework_try_07;

public class Mainclass {

	public static void main(String[] args) {

		DisplayThing t;

		Gun g = new Gun();
		t = new Butterfly("Flappy", g.getDx(), g.getDy());
		t.start();

		// display the object, delay, display again
		// The thread inside the object is moving it forward
		for (int i = 0; i < 10; i++) {
			sleepAlittle(100);
			t.display();
		}

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
