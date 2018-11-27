package Graphics3D_Demo;

/**
 * 
 * 3 dimensional points.  This class is a holder for the x, y, z points in 3D. Simple
 *                   zero-default constructor, and initial value constructor.
 * 
 * @author Russell
 * 
 */
public class pos3D {

	double x;
	double y;
	double z;

	public pos3D() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}

	/**
	 * Setter for the 3D point
	 **/
	public pos3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

}
