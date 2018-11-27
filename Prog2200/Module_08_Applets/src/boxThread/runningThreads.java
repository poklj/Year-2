package boxThread;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Loop and set the box values to the values from this thread.
 *
 * @author Russ
 * 
 */
public class runningThreads extends Thread {

    /**
     * This copy of data to use to overwrite
     */
    private String boxText;
    private Color boxColor;
    private int xLocation;
    private int yLocation;
    private theBox b;

    public runningThreads(theBox b, Color c, String t, int x, int y) {
        this.b = b;
        this.boxColor = c;
        this.boxText = t;
        this.xLocation = x;
        this.yLocation = y;
    }

    @Override
    public void run() {
        System.out.println("Start name = " + this.boxText);
        try {
            for (int i = 0; i < 10000; i++) {
                b.setBoxAttributes(boxColor, boxText, xLocation + 50, yLocation);
                System.out.print("Set " + this.boxText + ";  ");
                Thread.sleep(15);
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    void Paint(Graphics g) {
        g.setColor(boxColor);
        g.fillOval(xLocation, yLocation, 30, 30);
    }
}
