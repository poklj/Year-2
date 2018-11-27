package Part_3b_Dot_Velocity_Button;

//import java.util.Timer;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * 
 * fast Movement:
 *   Velocity of a dot with arrow keys
 *   1) enable the second button (drawHere line 41)
 *
 */
public class Main_A3b {

	// A timer to refresh the screen
	//static Timer timer = new Timer();
	//static DrawHere d = new DrawHere();

	public static void main(String[] args) {
		
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

	}

}