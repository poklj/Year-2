package application_with_Handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Key_Handler implements KeyListener {

	public Key_Handler() {
		System.out.println("Constructor Key_Handler");
	}

	public void keyTyped(KeyEvent arg0) {
		System.out.println("keyTyped " + arg0.toString());
		System.out.println("keyTyped "+arg0.getKeyCode());
	}

	public void keyPressed(KeyEvent arg0) {
		System.out.println("keyPressed " + arg0.toString());
		System.out.println("keyPressed "+arg0.getKeyCode());
	}

	public void keyReleased(KeyEvent arg0) {
		System.out.println("keyReleased " + arg0.toString());
		System.out.println("keyReleased "+arg0.getKeyCode());
	}

}