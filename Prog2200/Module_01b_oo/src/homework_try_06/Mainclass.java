package homework_try_06;

import java.util.ArrayList;
import java.util.Random;

public class Mainclass {

	public static void main(String[] args) {

		ArrayList<DisplayThing> myStuff = new ArrayList<DisplayThing>();
		DisplayThing t;

		// Make objects
		for (int i = 0; i < 1; i++) {
			t = new Butterfly("Flappy-" + Integer.toString(i), rand(), rand());
			t.start(); // start the thread
			myStuff.add(t);
			t = new Star("Twinky-" + Integer.toString(i), rand(), rand());
			t.start(); // start the thread
			myStuff.add(t);
		}

		// display the object, delay, display again
		// The thread inside the object is moving it forward
		for (int i = 0; i < 10; i++) {
			sleepAlittle(100);
			for (DisplayThing object : myStuff) { // loop through Array
				object.display();
				// object.doYourThing();
				// object.leaveCocoon(); // DisplayThing doesn't know about this method
			}
		}

	}

	static Random R = new Random();

	public static int rand() {
		return R.nextInt(35) + 30;
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
