package Part_4_Piano;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 
 * Piano class takes a bunch of notes and plays them
 * when keyboard keys are pressed.
 *
 */
public class Piano implements KeyListener {

	// These Note objects will be each note
	Note Do, Ra, Me, Fa, So, La, Ti, Do2, Ra2;

	// Constructor sets up each Note from WAV file.
	Piano() {
		// Set up each note from WAV file
		Do = new Note("Do.WAV");
		
		//Ra = new Note("Do.WAV");
		//Me = new Note("Do.WAV");
		//Fa = new Note("Do.WAV");
		//So = new Note("Do.WAV");
		//La = new Note("Do.WAV");
		//Ti = new Note("Do.WAV");
		//Do2 = new Note("Do.WAV");
		//Ra2 = new Note("Do.WAV");

		Ra = new Note("Ra.WAV");
		Me = new Note("Me.WAV");
		Fa = new Note("Fa.WAV");
		So = new Note("So.WAV");
		La = new Note("La.WAV");
		Ti = new Note("Ti.WAV");
		Do2 = new Note("Do2.WAV");
		Ra2 = new Note("Ra2.WAV");
		
		System.out.println("Piano set up");
	}

	/**
	 * Keypressed...Play note based on which key pressed.
	 * Layout is keyboard asdfghjkl  playing Do and up.
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Keycode=" + e.getKeyCode());

		int ch = e.getKeyCode();
		switch (ch) {
		case KeyEvent.VK_A:
			Do.play();
			break;
		case KeyEvent.VK_S:
			Ra.play();
			break;
		case KeyEvent.VK_D:
			Me.play();
			break;
		case KeyEvent.VK_F:
			Fa.play();
			break;
		case KeyEvent.VK_G:
			So.play();
			break;
		case KeyEvent.VK_H:
			La.play();
			break;
		case KeyEvent.VK_J:
			Ti.play();
			break;
		case KeyEvent.VK_K:
			Do2.play();
			break;
		case KeyEvent.VK_L:
			Ra2.play();
			break;
		case KeyEvent.VK_ESCAPE:
			System.exit(0); // end if esc pressed
			break;
		}
	}

	// These must be here, but they are not used
	@Override
	public void keyReleased(KeyEvent e) {
		// System.out.println("B key=" + e.getKeyChar());
	}

	// These must be here, but they are not used
	@Override
	public void keyTyped(KeyEvent e) {
		// System.out.println("C key=" + e.getKeyChar());
	}

}
