package Part_7_3D;

import java.awt.Color;

/**
 * Uses the shapebase class to create a 3D cube.
 * 
 * @author Russ
 *
 */
public class Cube extends shapeBase {

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
	public Cube(Color shapeColor, Pos3D location, Pos3D velocity, Pos3D rotation, Pos3D rotation_velocity) {
		super(shapeColor, location, velocity, rotation, rotation_velocity);
	}

	@Override
	protected void make() {

		// Constants for the 3D drawing...makes the shape
		double a1 = 0.3;

		// Top square
		this.addPoint(new Pos3D(a1, a1, a1));
		this.addPoint(new Pos3D(a1, a1, -a1));
		this.addPoint(new Pos3D(a1, -a1, -a1));
		this.addPoint(new Pos3D(a1, -a1, a1));
		this.addPoint(new Pos3D(a1, a1, a1));

		// Bottom square
		this.addLine();
		this.addPoint(new Pos3D(-a1, a1, a1));
		this.addPoint(new Pos3D(-a1, a1, -a1));
		this.addPoint(new Pos3D(-a1, -a1, -a1));
		this.addPoint(new Pos3D(-a1, -a1, a1));
		this.addPoint(new Pos3D(-a1, a1, a1));

		// Lines joining the 2 squares
		this.addLine();
		this.addPoint(new Pos3D(a1, a1, a1));
		this.addPoint(new Pos3D(-a1, a1, a1));

		this.addLine();
		this.addPoint(new Pos3D(a1, a1, -a1));
		this.addPoint(new Pos3D(-a1, a1, -a1));

		this.addLine();
		this.addPoint(new Pos3D(a1, -a1, -a1));
		this.addPoint(new Pos3D(-a1, -a1, -a1));

		this.addLine();
		this.addPoint(new Pos3D(a1, -a1, a1));
		this.addPoint(new Pos3D(-a1, -a1, a1));
	}

}
