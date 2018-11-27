package Part_3_Dot_Velocity;

//Imports are listed in full to show what's being used
//could just import javax.swing.* and java.awt.* etc..

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public class DrawHere extends JPanel implements ActionListener {

	TheDot c1;

	public DrawHere() {

		System.out.println("");
		
		// Set up cat
		c1 = new TheDot("cat 1", 20, 70, Color.ORANGE);
		c1.start();
		
		//Set up key-pressed events
		this.addKeyListener(c1);
		
		this.setFocusable(true);
		this.requestFocusInWindow();

	}

	public void paintComponent(Graphics g) {
		//System.out.println("width =" + this.getWidth() + "   "+ this.getHeight());
		
		// Setup and clear the buffer
		BufferedImage bufferedImage = new BufferedImage(this.getWidth(),
				this.getHeight(), BufferedImage.TYPE_INT_BGR);
		Graphics2D g2d = bufferedImage.createGraphics();
		g2d.setColor(getBackground());
		g2d.fillRect(0,  0,  this.getWidth(),  this.getHeight());  //fill with background color

		// Draw on the buffer
		c1.Paint(g2d);

		// Set the buffer to be visible
		Graphics2D g2dComponent = (Graphics2D) g;
		g2dComponent.drawImage(bufferedImage, null, 0, 0);
	}

	
	/**
	 * This method is called when the timer fires
	 * The Timer sets off an "actionPerformed" event
	 * every so many milliseconds.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.repaint();

		//Take focus if we don't have it
		if (!this.isFocusOwner()) {
			this.requestFocusInWindow();
		}

	}

	
}
