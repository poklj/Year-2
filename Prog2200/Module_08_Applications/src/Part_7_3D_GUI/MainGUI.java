package Part_7_3D_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUI {

	private JFrame frame;

	// A timer to refresh the screen
	static Timer timer;

	// JFrame for drawing
	static DrawHere d = new DrawHere();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 749, 643);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnCube = new JButton("Cube");
		btnCube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				d.addCube();
			}
		});
		btnCube.setBounds(10, 26, 89, 23);
		frame.getContentPane().add(btnCube);

		JButton btnWire = new JButton("Wire");
		btnWire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d.addWire();
			}
		});
		btnWire.setBounds(10, 60, 89, 23);
		frame.getContentPane().add(btnWire);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d.clear();
			}
		});
		btnClear.setBounds(10, 453, 89, 23);
		frame.getContentPane().add(btnClear);

		// Substitute our "d" JPanel for the one auto-created
		//JPanel panel = new JPanel();
		d.setBounds(101, 11, 622, 582);
		frame.getContentPane().add(d);

		// Set up Timer
		timer = new Timer(10, d); // Set time, and this object gets event
		
		JButton btnPyramid = new JButton("Pyramid");
		btnPyramid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				d.addPyramid();
			}
		});
		btnPyramid.setBounds(10, 94, 89, 23);
		frame.getContentPane().add(btnPyramid);
		timer.setInitialDelay(100); //
		timer.setCoalesce(true); // Don't stack up events
		timer.start(); // Start the timer object
	}
}
