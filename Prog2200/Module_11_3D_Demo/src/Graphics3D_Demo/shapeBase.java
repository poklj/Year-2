package Graphics3D_Demo;

import java.awt.Graphics2D;

/**

 * This abstract class is the base for any 3D shape.  
 * This class provides the functions required to translate the 3D 
 * shape to 2D (screen). An inheriting class is expected to implement 
 * it's own pointShape routine, 
 * but can otherwise use the 3D transformation and the getters and setters
 * for the 3D angles. 
 *
 * @author Russell
 *
 */
public abstract class shapeBase extends Thread {

    /** focus determines the percentage of screen used	 */
    private final double focus = 0.75;
    /** xmax determines the size of the screen via x */
    private final double xmax = 250;
    /** ymax determines the size of the screen via y */
    private final double ymax = 250;
    /** angle from Y to X **/
    private double angle_a = 0.0;
    /** angle from X to Z **/
    private double angle_b = 0.0;
    /** angle from Y to Z **/
    private double angle_c = 0.0;

    /** clear the angles to 0 **/
    public void reset_angles() {
        angle_a = 0.0;
        angle_b = 0.0;
        angle_c = 0.0;
    }

    /** refresh the shape on the screen **/
    protected abstract void paintShape(Graphics2D g);

    /** given a 3D position, return a 2D position mapped based on the angles */
    public final pos2D functionX2D(pos3D p) {

        double cx = Math.cos(angle_a);
        double cy = Math.cos(angle_b);
        double cz = Math.cos(angle_c);
        double sx = Math.sin(angle_a);
        double sy = Math.sin(angle_b);
        double sz = Math.sin(angle_c);

        double m00 = cy * cz;
        double m01 = -cy * sz;
        double m02 = sy;
        double m10 = cx * sz + sx * sy * cz;
        double m11 = cx * cz - sx * sy * sz;
        double m12 = -sx * cy;
        double m20 = sx * sz - cx * sy * cz;
        double m21 = sx * cz + cx * sy * sz;
        double m22 = cx * cy;

        double dx = m00 * p.x + m10 * p.y + m20 * p.z;
        double dy = m01 * p.x + m11 * p.y + m21 * p.z;
        double dz = m02 * p.x + m12 * p.y + m22 * p.z;

        // Map the new x,y to the screen
        pos2D new2D_position = new pos2D();
        new2D_position.x = xmax + dx * xmax * focus;
        new2D_position.y = ymax + dy * ymax * focus;

        return new2D_position;
    }
    ;

    /**
     * @return the angle from x to z
     */
    public double getAngle_a() {
        return angle_a;
    }

    /**
     * @return the angle from y to z
     */
    public double getAngle_b() {
        return angle_b;
    }

    /**
     * @param d The angle from x to z.
     */
    public void setAngle_a(double d) {
        angle_a = d;
    }

    /**
     * @param d The angle from y to z.
     */
    public void setAngle_b(double d) {
        angle_b = d;
    }
}