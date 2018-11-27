package application_with_Handlers;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;

//Imports are listed in full to show what's being used
//could just import javax.swing.* and java.awt.* etc..

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public class DrawHere extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	Font aFont = new Font("TimesRoman", Font.PLAIN, 20);
	JLabel theLabel = new JLabel("Press the button");
	JButton button = new JButton("Press");

	//
	// Event Handlers
	Wheel_Handler wHandler;
	Component_Handler cHandler;
	Action_Handler aHandler;
	Key_Handler kHandler;
	Mouse_Handler mHandler;
	boolean firstDisplay = true; // Used to force only one full-screen update

	theCat fluffy1;
	static JProgressBar progressBar;
	public static JTextField myTextField = new JTextField("Hello", 20);
	JApplet j;

	public DrawHere() {

		this.setLayout(new FlowLayout()); // force FlowLayout Layout Manager

		// add stuff to JPanel (based on layout set above)
		this.add(button);
		this.add(theLabel);
		this.add(myTextField);
		theLabel.setFont(aFont);

		// Create listeners, and set them to listen

		// Change events for the window
		cHandler = new Component_Handler();
		this.addComponentListener(cHandler);

		// The button
		aHandler = new Action_Handler();
		button.addActionListener(aHandler);

		// Keystrokes
		kHandler = new Key_Handler();

		myTextField.addKeyListener(kHandler);
		myTextField.setEditable(true);

		mHandler = new Mouse_Handler();
		this.addMouseListener(mHandler);

		wHandler = new Wheel_Handler();
		this.addMouseWheelListener(wHandler);

		// Create and start threads
		fluffy1 = new theCat("hello", 5, 50, Color.RED);
		fluffy1.start();

		// Create and display a progress bar
		progressBar = new JProgressBar(0, 50);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		progressBar.setIndeterminate(true);
		this.add(this.progressBar);

		this.setFocusable(true);
		this.requestFocusInWindow();

	}

	public void paintComponent(Graphics g) {

		// Setup and clear the screen
		g.setColor(getBackground());
		g.fillRect(0, 0, this.getWidth(), this.getHeight()); 

		// Draw on the buffer
		fluffy1.Paint(g);

	}

	// public void paintComponent(Graphics g) {
	// // System.out.println("width =" + this.getWidth() + " "+
	// // this.getHeight());
	//
	// // Setup and clear the buffer
	// BufferedImage bufferedImage = new BufferedImage(this.getWidth(),
	// this.getHeight(), BufferedImage.TYPE_INT_BGR);
	// Graphics2D g2d = bufferedImage.createGraphics();
	// g2d.setColor(getBackground());
	// g2d.fillRect(0, 0, this.getWidth(), this.getHeight()); // fill with
	// // background
	// // color
	//
	// // Draw on the buffer
	// fluffy1.Paint(g2d);
	//
	// // Set the buffer to be visible
	// Graphics2D g2dComponent = (Graphics2D) g;
	// g2dComponent.drawImage(bufferedImage, null, 0, 0);
	// }

	/**
	 * This method is called when the timer fires The Timer sets off an
	 * "actionPerformed" event every so many milliseconds.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.repaint();

// Needed this to catch keystrokes in screen, but it breaks text field entry.
// Typically, 2 or more panels would be used to provide full functionality 
		// Take focus if we don't have it
//		if (!this.isFocusOwner()) {
//			this.requestFocusInWindow();
//		}
	}

}
