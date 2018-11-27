package Part_7_3D;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This abstract class is the base for any 3D shape. This class provides (1)the
 * functions required to translate the 3D shape to 2D (screen) and (2)the data
 * structure to contain the shape data.
 * 
 * This class allows the spinning and moving of the shape, and facilitates this
 * by supplying a default Thread which constantly updates movement based on
 * initial speed and rotation.
 * 
 * An inheriting class is expected to implement it's own make() method, but can
 * otherwise use the 3D transformation and the getters and setters for the 3D
 * angles. The built-in run() method simply updates the movement and rotation.
 *
 * @author Russell
 *
 */
public abstract class shapeBase extends Thread {

	/**
	 * Color of the lines of this shape.
	 */
	protected Color shapeColor;

	/**
	 * 3D location of this shape.
	 */
	protected Pos3D location;

	/**
	 * 3D velocity of this shape.
	 */
	protected Pos3D velocity;

	/**
	 * 3D rotation of the shape. X=angle from Y to X. Y=angle from X to Z.
	 * Z=angle from Y to Z
	 */
	protected Pos3D rotation;

	/**
	 * 3D rotation of the shape
	 */
	protected Pos3D rotation_velocity;

	/** focus determines the zoom scale of screen used */
	private double focus = 50;
	/** x_scale is the size of the screen via x */
	private double x_scale;
	/** y_scale is the size of the screen via y */
	private double y_scale;

	/**
	 * Every 3D shape is a list of 3D lines
	 **/
	private List<pointSet> lines = null;
	private int line_index = 0;

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
	public shapeBase(Color shapeColor, Pos3D location, Pos3D velocity, Pos3D rotation, Pos3D rotation_velocity) {
		super(); // Constructor for Thread
		this.shapeColor = shapeColor;
		this.location = location;
		this.velocity = velocity;
		this.rotation = rotation;
		this.rotation_velocity = rotation_velocity;

		// Set up first data line
		pointSet temp_pointSet = new pointSet();
		lines = new ArrayList<pointSet>();
		lines.add(temp_pointSet);
		line_index = 0; // points to current line

		// now make my shape, and start the thread
		this.make();
		this.start();
	}

	/**
	 * Inheriting class provides a make() method for building whatever shape.
	 */
	protected abstract void make();

	/**
	 * Add a 3D Point to the current line
	 * 
	 * @param p
	 *            3D point to add to the line.
	 */
	protected void addPoint(Pos3D p) {
		lines.get(line_index).add(p);
	}

	/**
	 * Add a new line to the list of lines drawn and increment the line_index so
	 * that new points get added to this line.
	 */
	protected void addLine() {
		pointSet temp_pointSet = new pointSet();
		lines.add(temp_pointSet);
		line_index = line_index + 1; // points to new, current line
	}

	/**
	 * private temp variables...faster if declared once. Used to draw the 3D
	 * shape onto the 2D screen.
	 */
	private List<Pos2D> points2D = new ArrayList<Pos2D>();
	private Pos2D p1 = null;
	private Pos2D p2 = null;

	/**
	 * Paints the wire shape by converting each point of the 3D shape into 2D,
	 * and then drawing the lines in 2D. The principle is that any 2 points in
	 * 3D can be converted to 2D, and the 3D line would appear exactly as the 3D
	 * line would have appeared in 3D....except it's alot easier to draw it in
	 * 2D...right?
	 */
	protected void paintShape(Graphics2D g, Pos2D screenSize) {

		// Set scale per incoming screen size, which may be
		// resized while running.
		x_scale = screenSize.getX() / 2.0;
		y_scale = screenSize.getY() / 2.0;

		// Put the pen down in this shapes' colour.
		g.setColor(this.shapeColor);

		/**
		 * Loop for each line in lines.
		 */
		for (pointSet temp_pointSet : lines) {

			// Empty the old 2D version of the 3D shape
			points2D.clear();

			/**
			 * Loop for each point in the line.
			 */
			for (Pos3D p : temp_pointSet) {
				// Get the 3D Point and convert to 2D position
				Pos2D p_new = functionX2D(p);
				// slip in into the list for putting on the screen
				points2D.add(p_new);
			}

			/**
			 * draw line to each point (line in 3D looks same as line in 2D) a
			 * line in 3D translated to 2D still looks like a straight line
			 */
			for (int i = 0; i < points2D.size() - 1; i++) {
				p1 = (Pos2D) points2D.get(i);
				p2 = (Pos2D) points2D.get(i + 1);
				g.drawLine((int) p1.getX(), (int) p1.getY(), (int) p2.getX(), (int) p2.getY());
			}
		}
	}

	/**
	 * Given a 3D position, return a 2D position mapped based on the location,
	 * rotation angles, and scale.
	 * 
	 * @param p
	 *            incoming 3D point.
	 * @return outgoing 2D position matching location and rotation of 3D point.
	 */
	private final Pos2D functionX2D(Pos3D p) {

		// Adjust for rotation (spin)
		double cx = Math.cos(rotation.getX());
		double cy = Math.cos(rotation.getY());
		double cz = Math.cos(rotation.getZ());
		double sx = Math.sin(rotation.getX());
		double sy = Math.sin(rotation.getY());
		double sz = Math.sin(rotation.getZ());

		// Create rotation matrix
		double m00 = cy * cz;
		double m01 = -cy * sz;
		double m02 = sy;
		double m10 = cx * sz + sx * sy * cz;
		double m11 = cx * cz - sx * sy * sz;
		double m12 = -sx * cy;
		double m20 = sx * sz - cx * sy * cz;
		double m21 = sx * cz + cx * sy * sz;
		double m22 = cx * cy;

		// Apply rotation matrix to x,y,z point
		double dx = m00 * p.getX() + m10 * p.getY() + m20 * p.getZ();
		double dy = m01 * p.getX() + m11 * p.getY() + m21 * p.getZ();
		double dz = m02 * p.getX() + m12 * p.getY() + m22 * p.getZ();

		// Adjust for location translation (moving around)
		dx = dx + this.location.getX();
		dy = dy + this.location.getY();
		dz = dz + this.location.getZ();

		// Use only resulting x,y ...drop z. Hence 3D to 2D.
		Pos2D new2D_position = new Pos2D();
		new2D_position.setX(x_scale + dx * focus);
		new2D_position.setY(y_scale + dy * focus);
		return new2D_position;
	}

	/**
	 * Default run() method moves and rotates. Inheriting class can override
	 * this method with a specific behavior if needed.
	 */
	@Override
	public void run() {

		while (true) {
			// move and rotate per speeds
			this.translate(location, velocity);
			this.rotate(rotation, rotation_velocity);

			this.sleepAlittle(30);
		}
	}

	/**
	 * Move the location with a check for moving off the screen. This call is
	 * suitable for location movement.
	 * 
	 * @param location
	 *            original 3D location.
	 * @param velocity
	 *            How much to move by.
	 */
	private void translate(Pos3D location, Pos3D velocity) {
		Pos3D box = new Pos3D(x_scale / focus, x_scale / focus, x_scale / focus);
		location.add(velocity, box);
	}

	/**
	 * Move the rotation with no check for rotating too much. This call is
	 * suitable for rotation movement as it can continue around harmlessly.
	 * 
	 * @param rotation
	 *            original 3D rotation amount
	 * @param rotation_velocity
	 *            How much to rotate by.
	 */
	private void rotate(Pos3D rotation, Pos3D rotation_velocity) {
		rotation.add(rotation_velocity);
	}

	/**
	 * Wait for an amount of milliseconds
	 * 
	 * @param s
	 *            Number of milliseconds to wait.
	 */
	private void sleepAlittle(int s) {
		try {
			sleep(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}