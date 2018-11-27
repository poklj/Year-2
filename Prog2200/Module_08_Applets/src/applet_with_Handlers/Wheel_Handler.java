package applet_with_Handlers;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Wheel_Handler implements MouseWheelListener {

	public Wheel_Handler() {
		System.out.println("Constructor Wheel_Handler");
	}

	public void mouseWheelMoved(MouseWheelEvent arg0) {
		System.out.println("Wheel_Handler: " + arg0.toString());
	}
}
