package homework_try_05;

import java.util.ArrayList;

public class Mainclass {

	public static void main(String[] args) {

		ArrayList<DisplayThing> myStuff = new ArrayList<DisplayThing>();
		DisplayThing t;

		// Make objects
		for (int i = 0; i < 10; i++) {
			t = new Butterfly("Flappy-" + Integer.toString(i), 1, 2);
			//t.start(); // start the thread
			myStuff.add(t);
			t = new Star("Twinky-" + String.valueOf(i), 2, 3);
			//t.start(); // start the thread
			myStuff.add(t);
		}
		
		for (DisplayThing object : myStuff) {
			object.start();
		}

		// display the object, delay, display again
		// The thread inside the object is moving it forward
		for (int i = 0; i < 10; i++) {
			sleepAlittle(500);
			for (DisplayThing object : myStuff) {
				object.display();
				object.doYourThing();          // per derived class
			}
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
