package Part_7_3D;

/**
 * 
 * 3 dimensional points. This class is a holder for the x, y, z points in 3D.
 * Simple zero-default constructor, and initial value constructor.
 * 
 * @author Russell
 * 
 */
public class Pos3D {

	private double x;
	private double y;
	private double z;

	public Pos3D() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}

	/**
	 * Setter for the 3D point
	 * @param x x
	 * @param y y
	 * @param z z
	 */
	public Pos3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * get x component
	 * @return x
	 */
	public double getX() {
		return x;
	}

	/**
	 * get y component
	 * @return y
	 */
	public double getY() {
		return y;
	}

	/**
	 * get z component
	 * @return z
	 */
	public double getZ() {
		return z;
	}


	/**
	 * Add the 3D point, no checks.
	 * 
	 * @param P
	 *            amount to add
	 */
	public void add(Pos3D P) {
		this.x += P.x;
		this.y += P.y;
		this.z += P.z;
	}

	/**
	 * Add the 3D velocity, but also negate component if out of bounds. If
	 * out-of-bounds on a direction, then negate velocity and max the location
	 * to that point. This has the effect of keeping shapes on the screen when
	 * resizing to a smaller screen size.
	 * 
	 * @param P
	 *            amount to add
	 * @param bounds
	 *            used to negate, and max-out directional component
	 */
	public void add(Pos3D P, Pos3D bounds) {
		this.x += P.x;
		this.y += P.y;
		this.z += P.z;

		if (this.x > bounds.x) {
			P.x = -P.x;
			this.x = bounds.x;
		}

		if (this.x < -bounds.x) {
			P.x = -P.x;
			this.x = -bounds.x;
		}

		if (this.y > bounds.y) {
			P.y = -P.y;
			this.y = bounds.y;
		}

		if (this.y < -bounds.y) {
			P.y = -P.y;
			this.y = -bounds.y;
		}

		if (this.z > bounds.z) {
			P.z = -P.z;
			this.z = bounds.z;
		}

		if (this.z < -bounds.z) {
			P.z = -P.z;
			this.z = -bounds.z;
		}

	}

}
