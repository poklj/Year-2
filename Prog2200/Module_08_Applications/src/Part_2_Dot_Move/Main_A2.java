package Part_2_Dot_Move;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * 
 * Slow Movement:
 *   Motion of a dot with arrow keys
 *
 *Try:
 *  1) Run the program
 *  2) theCat -> line 116 to 126 ... fix the arrow keys 
 *  3) DrawHere -> lines 26,27,31,50 ... add in second cat, c2 
 *
 */
public class Main_A2 {

	// A timer to refresh the screen
	static Timer timer;
	static DrawHere d = new DrawHere();

	public static void main(String[] args) {
		System.out.println("A");
		
		// Set up jFrame window for drawing
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 700);
		frame.setVisible(true);
		frame.setContentPane(d);
		frame.getRootPane().setBackground(Color.LIGHT_GRAY);
		
		// Set up Timer
		timer = new Timer(50, d); // Set time, and this object gets event
		timer.setInitialDelay(100); // Initial wait
		timer.setCoalesce(true); // Don't stack up events
		timer.start(); // Start the timer object
		
		System.out.println("B");
	}

}