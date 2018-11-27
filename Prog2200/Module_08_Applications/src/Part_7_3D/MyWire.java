package Part_7_3D;

import java.awt.Color;

/**
 * Creates a 3D wire shape using shapebase.
 * 
 * @author Russ
 *
 */
public class MyWire extends shapeBase {

	/**
	 * Create the shape using parameters, then make the shape and start the
	 * thread running.
	 * 
	 * @param shapeColor
	 * @param location
	 * @param velocity
	 * @param rotation
	 * @param rotation_velocity
	 */
	public MyWire(Color shapeColor, Pos3D location, Pos3D velocity, Pos3D rotation, Pos3D rotation_velocity) {
		super(shapeColor, location, velocity, rotation, rotation_velocity);
	}

	@Override
	protected void make() {

		// Constants for the 3D drawing...makes the shape
		double a1 = 0;
		double a2 = 0.25;
		double a3 = 0.75;

		// define the 3D object...symmetrical using a1,a2,a3
		this.addPoint(new Pos3D(a1, a1, 0));
		this.addPoint(new Pos3D(a2, a2, 0));
		this.addPoint(new Pos3D(a3, -a3, 0));
		this.addPoint(new Pos3D(a3, a3, 0));
		this.addPoint(new Pos3D(a2, -a2, 0));
		this.addPoint(new Pos3D(a1, a1, 0));

		this.addPoint(new Pos3D(-a1, a1, 0));
		this.addPoint(new Pos3D(-a2, a2, 0));
		this.addPoint(new Pos3D(-a3, -a3, 0));
		this.addPoint(new Pos3D(-a3, a3, 0));
		this.addPoint(new Pos3D(-a2, -a2, 0));
		this.addPoint(new Pos3D(-a1, a1, 0));

		this.addPoint(new Pos3D(0, a1, a1));
		this.addPoint(new Pos3D(0, a2, a2));
		this.addPoint(new Pos3D(0, a3, -a3));
		this.addPoint(new Pos3D(0, a3, a3));
		this.addPoint(new Pos3D(0, a2, -a2));
		this.addPoint(new Pos3D(0, a1, a1));

		this.addPoint(new Pos3D(0, -a1, a1));
		this.addPoint(new Pos3D(0, -a2, a2));
		this.addPoint(new Pos3D(0, -a3, -a3));
		this.addPoint(new Pos3D(0, -a3, a3));
		this.addPoint(new Pos3D(0, -a2, -a2));
		this.addPoint(new Pos3D(0, -a1, a1));

		this.addPoint(new Pos3D(a1, 0, a1));
		this.addPoint(new Pos3D(a2, 0, a2));
		this.addPoint(new Pos3D(-a3, 0, a3));
		this.addPoint(new Pos3D(a3, 0, a3));
		this.addPoint(new Pos3D(-a2, 0, a2));
		this.addPoint(new Pos3D(a1, 0, a1));

		this.addPoint(new Pos3D(a1, 0, -a1));
		this.addPoint(new Pos3D(a2, 0, -a2));
		this.addPoint(new Pos3D(-a3, 0, -a3));
		this.addPoint(new Pos3D(a3, 0, -a3));
		this.addPoint(new Pos3D(-a2, 0, -a2));
		this.addPoint(new Pos3D(a1, 0, -a1));

	}

}
