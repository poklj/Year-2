package applet_with_Handlers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse_Handler implements MouseListener {

	public void mouseClicked(MouseEvent arg0) {
		System.out.println("mouseClicked " + arg0.toString());
	}

	public void mousePressed(MouseEvent arg0) {
		System.out.println("mousePressed " + arg0.toString());
	}

	public void mouseReleased(MouseEvent arg0) {
		System.out.println("mouseReleased " + arg0.toString());
	}

	public void mouseEntered(MouseEvent arg0) {
		System.out.println("mouseEntered " + arg0.toString());
	}

	public void mouseExited(MouseEvent arg0) {
		System.out.println("mouseExited " + arg0.toString());
	}

}
