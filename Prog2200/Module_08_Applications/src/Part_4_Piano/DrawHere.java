package Part_4_Piano;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
 * 
 * The class, DrawHere, sets up to draw on the Panel 
 *
 */
@SuppressWarnings("serial")
public class DrawHere extends JPanel implements ActionListener {

	public DrawHere() {

		// Declare one Piano
		Piano p = new Piano();

		// Set up key-pressed events, on the Piano
		this.addKeyListener(p); // arrow keys work on first

		// Need these or else we don't capture keystrokes
		this.setFocusable(true);
		this.requestFocusInWindow();
		
		System.out.println("Panel set up");
	}

	/**
	 * This method does the double-buffer draw
	 */
	public void paintComponent(Graphics g) {
		// Setup and clear the new buffer
		BufferedImage bufferedImage = new BufferedImage(this.getWidth(),
				this.getHeight(), BufferedImage.TYPE_INT_BGR);
		Graphics2D g2d = bufferedImage.createGraphics();
		g2d.setColor(getBackground());
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight()); // fill

		// Draw on the buffer
		// If we draw something, we do it here.

		// Set the new buffer to be visible
		Graphics2D g2dComponent = (Graphics2D) g;
		g2dComponent.drawImage(bufferedImage, null, 0, 0);
	}

	/**
	 * This method is called when the timer fires. The Timer sets off an
	 * "actionPerformed" event every so many milliseconds.  We just want
	 * to repaint every so often.
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
