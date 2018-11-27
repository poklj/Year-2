package application_with_Handlers;

import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

public class Container_Handler implements ContainerListener {

	public Container_Handler() {
		System.out.println("Constructor Container_Handler");
	}

	public void componentAdded(ContainerEvent arg0) {
		System.out.println(" Container_Handler: componentAdded");
	}

	public void componentRemoved(ContainerEvent arg0) {
		System.out.println(" Container_Handler: componentRemoved");
	}

}
