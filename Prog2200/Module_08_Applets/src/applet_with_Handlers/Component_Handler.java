package applet_with_Handlers;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class Component_Handler implements ComponentListener {

	public Component_Handler() {
		System.out.println("Constructor Component_Handler");
	}

	public void componentResized(ComponentEvent arg0) {
		System.out.println("Component_Handler componentResized");
	}

	public void componentMoved(ComponentEvent arg0) {
		System.out.println(" Component_Handler componentMoved");
	}

	public void componentShown(ComponentEvent arg0) {
		System.out.println("Component_Handler componentShown");
	}

	public void componentHidden(ComponentEvent arg0) {
		System.out.println("Component_Handler componentHidden");
	}
}
