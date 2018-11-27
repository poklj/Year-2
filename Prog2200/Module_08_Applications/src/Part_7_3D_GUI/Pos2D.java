package Part_7_3D_GUI;

/**
 * 2 dimensional points. This class is a holder for the x, y points in 2D.
 * Simple zero-default constructor.
 * 
 * @author Russell
 */
public class Pos2D {

	private double x;

	private double y;

	public Pos2D() {
		this.x = 0;
		this.y = 0;
	}

	public Pos2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

}
