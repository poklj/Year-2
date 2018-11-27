package Part_7_3D_GUI;

//import java.util.Timer;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Acts as starter for main line JPanel class, initializing the JPanel using the
 * DrawHere class.
 * 
 * Try:
 * 1) Add a new shape class ... a larger cube .. BigCube class
 * 2) Add a new shape ... a smaller cube .. LittleCube
 * 3) Add a new shape ... Pyramid
 * 4) Add a key listener to add functionality:
 *  	- "p" adds Pyramid ... random initial settings.
 *  	- "c" adds Cube, "b" BigCube, "l" LittleCube
 *      - "w" adds Wire
 * 5) Shapes collide with each other.
 * 6) Sound when Shapes collide with each other.
 * 
 * @author Russ
 *
 */
public class P7_SimpleDraw {

	// A timer to refresh the screen
	static Timer timer;
	static DrawHere d = new DrawHere();

	public static void main(String[] args) {

		// Set up jFrame window for drawing
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(750, 750);
		frame.setVisible(true);
		frame.setContentPane(d);

		frame.getRootPane().setBackground(Color.LIGHT_GRAY);

		// Set up Timer
		timer = new Timer(10, d); // Set time, and this object gets event
		timer.setInitialDelay(100); //
		timer.setCoalesce(true); // Don't stack up events
		timer.start(); // Start the timer object
	}
}
