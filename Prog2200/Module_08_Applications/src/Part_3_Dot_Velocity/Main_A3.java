package Part_3_Dot_Velocity;

//import java.util.Timer;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * 
 * fast Movement:
 *   Velocity of a dot with arrow keys
 *
 *Try:
 *  1) Run the program
 *  2) Velocity added to theCat -> line 91-92; line 133-142  (Fix it)
 *  3) Collision with edge of panel theCat -> line 94-99  (Fix it)
 *
 */
public class Main_A3 {

	// A timer to refresh the screen
	//static Timer timer = new Timer();
	//static DrawHere d = new DrawHere();

	public static void main(String[] args) {
		System.out.println("A");
		
		// Set up jFrame window for drawing
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 700);
		DrawHere d = new DrawHere();
		frame.setContentPane(d);
		frame.getRootPane().setBackground(Color.LIGHT_GRAY);
		frame.setVisible(true);

		// Set up Timer
		Timer timer = new Timer(5, d); // Set time, and this object gets event
		timer.setInitialDelay(100); //
		timer.setCoalesce(true); // Don't stack up events
		timer.start(); // Start the timer object

		System.out.println("B");
	}

}