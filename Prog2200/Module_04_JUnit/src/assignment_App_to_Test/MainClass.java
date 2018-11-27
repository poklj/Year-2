package assignment_App_to_Test;

import java.awt.Color;

import javax.swing.JFrame;

/**
 * 
 * Demo calculator for demo testing
 *
 */
public class MainClass {

	public static void main(String[] args) {

		// Set up jFrame window for drawing
		JFrame frame = new JFrame("Silk Test App.");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set up our Math Panel
		MathPanel d = new MathPanel();
		frame.setContentPane(d);
		frame.getRootPane().setBackground(Color.LIGHT_GRAY);

		// Size and visible
		frame.setSize(700, 100);
		frame.setVisible(true);
	}
}