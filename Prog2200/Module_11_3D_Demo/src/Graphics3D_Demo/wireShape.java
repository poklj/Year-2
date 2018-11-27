package Graphics3D_Demo;

import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics2D;
import javax.swing.JApplet;

/**
 * @author Russell @NSCC.description The wireShape allows the definition of a
 *         bent wire in 3D, and the display of this wire on the screen given
 *         the changing angle of perspective.
 *  
 */
public class wireShape extends shapeBase {

    /** the saved shape in 3D co-ordinates */
    List points = new ArrayList();
    private JApplet j;

    /**
     * Constructor for Wireshape.
     * @param j Handle to japplet to force refresh
     */
    wireShape(JApplet j) {
        this.j = j;
    }

    /**
     * Add 3D points to the wire shape. The "user" would call this method
     * several times until the wire if fully defined, with each point of the
     * wire drawn from the last (as in a bent wire)
     */
    void addPoint(pos3D p) {
        points.add(p);
    }
    /** Local 2D version of the wire shape */
    ArrayList points2D = new ArrayList();
    /** Temp variable for line starting point */
    pos2D p1 = null;
    /** Temp variable for line ending point */
    pos2D p2 = null;

    /**
     * Paints the wire shape by converting each point of the 3D shape into 2D,
     * and then drawing the lines in 2D. The principle is that any 2 points in
     * 3D can be converted to 2D, and the 3D line would appear exactly as the
     * 3D line would have appeared in 3D....except it's alot easier to draw it
     * in 2D...right?
     */
    @Override
    protected void paintShape(Graphics2D g) {

        // Empty the old 2D version of the 3D shape
        points2D.clear();

        // convert all 3D points to 2D
        for (int i = 0; i < points.size(); i++) {
            // Get the 3D Point
            pos3D p = (pos3D) points.get(i);
            // convert to it's new 2D position
            pos2D p_new = functionX2D(p);
            // slip in into the list for putting on the screen
            points2D.add(p_new);
        }

        //draw line to each point (line in 3D looks same as line in 2D)
        //a line in 3D translated to 2D still looks like a straight line
        for (int i = 0; i < points.size() - 1; i++) {
            p1 = (pos2D) points2D.get(i);
            //P1 = mapToScreen(p1);
            p2 = (pos2D) points2D.get(i + 1);
            //P2 = mapToScreen(p2);

            g.drawLine((int) p1.x, (int) p1.y, (int) p2.x, (int) p2.y);
        }
    }

    double a, b, c = 0.0;
    @Override
    public void run() {

        while (true) {
            // Get angle, increment, and put it back.
            a = this.getAngle_a();
            a = a + 0.01;
            this.setAngle_a(a);

            this.sleepAlittle(30);

            j.repaint(10, 10, 100, 100);
        }
    }


    private void sleepAlittle(int s) {
        try {
            sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
