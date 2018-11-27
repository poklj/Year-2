package Part_4_Piano;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * 
 * Piano:
 *   Plays a Piano, using WAV files saved in local directory
 *
 *Try:
 *  1) Run the program - press asdfghjkl
 *  2) What's wrong...check Piano -> line 20 to 37
 *  3) Fix the piano and run it...play the ouch-piano!
 *
 */
public class Main_A4 {

	// A timer to refresh the screen
	static Timer timer;
	static DrawHere d = new DrawHere();

	public static void main(String[] args) {
		System.out.println("A");

		// Set up jFrame window for drawing
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650, 750);
		frame.setContentPane(d);
		frame.getRootPane().setBackground(Color.LIGHT_GRAY);
		frame.setVisible(true);

		// Set up Timer to kick in the DrawHere object
		timer = new Timer(5, d); // Set time, and this object gets event
		timer.setInitialDelay(100); //
		timer.setCoalesce(true); // Don't stack up events
		timer.start(); // Start the timer object

		//System.out.println("B");
	}

}