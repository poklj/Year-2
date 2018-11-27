package Part_5_Motion_Sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class DrawHere extends JPanel implements ActionListener {

	private ArrayList<theCat> l = new ArrayList<theCat>();;

	public DrawHere() {

		System.out.println("");

		l.add(new theCat(39, 20, 2, 3, Color.RED, "Sarah"));
		l.add(new theCat(10, 25, 1, 4, Color.ORANGE, "John"));
		l.add(new theCat(10, 25, 2, -1, Color.BLUE, "Bob"));
		l.add(new theCat(10, 25, -2, 1, Color.CYAN, "Sam"));
		l.add(new theCat(10, 25, 3, 1, Color.GREEN, "Mary"));

		for (theCat c : l) {
			c.start(); // Start each thread
			System.out.println("starting..." + c.getName());
		}

		// Set up key-pressed events
		this.addKeyListener(l.get(0)); // arrow keys work on first

		this.setFocusable(true);
		this.requestFocusInWindow();

		// Set up Sound
		try {
			// Open an audio input stream.
			File soundFile = new File("bing.wav");
			//File soundFile = new File("dong.wav");
			//File soundFile = new File("donttouchthis.wav");
			//File soundFile = new File("oomf.wav");
			//File soundFile = new File("oouch.wav");
			AudioInputStream audioIn = AudioSystem
					.getAudioInputStream(soundFile);
			// Get a sound clip resource.
			clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	Clip clip;

	public void paintComponent(Graphics g) {
		// System.out.println("width/Height=" + this.getWidth() + "/"+
		// this.getHeight());

		// Setup and clear the new buffer
		BufferedImage bufferedImage = new BufferedImage(this.getWidth(),
				this.getHeight(), BufferedImage.TYPE_INT_BGR);
		Graphics2D g2d = bufferedImage.createGraphics();
		g2d.setColor(getBackground());
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight()); // fill

		// Draw more "stuff" here...
//		g2d.setColor(Color.BLUE);
//		g2d.draw3DRect(30, 60, 240, 230, true);
//		g2d.setColor(Color.GREEN);
//		g2d.drawLine(220, 270, 340, 370);
//		g2d.setColor(Color.RED);
//		g2d.drawArc(30, 360, 390, 140, 300, 125);
//		g2d.setColor(Color.PINK);
//		g2d.fillRoundRect(400, 400, 90, 100, 30, 50);

		// Draw all cats onto the buffer
		if (l != null) {
			for (theCat c : l) {
				c.Paint(g2d); // Start each thread
			}
		}

		
		// Set the buffer to be visible
		Graphics2D g2dComponent = (Graphics2D) g;
		g2dComponent.drawImage(bufferedImage, null, 0, 0);
	}

	private void playSound() {
		if (clip.isRunning())
			clip.stop(); // Stop the player if it is still running
		clip.setFramePosition(0); // rewind to the beginning
		clip.start(); // Start playing
	}

	/**
	 * This method is called when the timer fires The Timer sets off an
	 * "actionPerformed" event every so many milliseconds.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < l.size(); i++) {
			for (int j = i + 1; j < l.size(); j++) {

				if (l.get(i).close(l.get(i), l.get(j))) {
					l.get(i).bounce();
					playSound();
				}
			}
		}

		this.repaint();
		
		//Take focus if we don't have it
		if (!this.isFocusOwner()) {
			this.requestFocusInWindow();
		}

	}

}
