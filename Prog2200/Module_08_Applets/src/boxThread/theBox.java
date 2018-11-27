package boxThread;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JApplet;

public class theBox extends Thread {

    // Used to sleep when minimized
    volatile boolean alive = false;
    volatile boolean active = false;
    // delay between box repaints
    private int delay;
    //  Values altered by running threads
    private volatile String boxText;
    private volatile Color boxColor;
    private volatile int xLocation = 40;
    private volatile int yLocation = 40;
    private int yStart;  // original starting location
    final int shapeSize = 30;
    // Handle to the JApplet
    private JApplet j;

    public theBox(JApplet j, String theText, int delay, int yStart, Color catColor) {
        this.j = j;
        this.boxText = theText;
        this.delay = delay;
        this.yStart = yStart;
        this.xLocation = 0;
        this.yLocation = yStart;
        this.boxColor = catColor;

        System.out.println("Constructor for theBox: " + this.boxText);
    }

    public void killBox() {
        if (alive) {
            alive = false;
        }
    }

    public void activateBox() {
        if (!active) {
            active = true;
        }
    }

    public void sleepBox() {
        if (active) {
            active = false;
        }
    }

//    public void setBoxAttributes(Color c, String t, int x, int y) {
    public synchronized void setBoxAttributes(Color c, String t, int x, int y) {
        this.boxColor = c;
        sleepAlittle(5);
        this.boxText = t;
        sleepAlittle(15);
        this.xLocation = x;
        this.yLocation = y;
    }

    @Override
    public void run() {
        // Initial settings
        //xLocation = 0;
        yLocation = yStart;
        alive = true;
        active = true;

        while (alive == true) {
            while (alive == true && active == true) {
                // Call JApplet repaint to queue a Paint call
                j.repaint();
                sleepAlittle(delay);
            }
            System.out.println(boxText + " sleeping");
            sleepAlittle(2000);
        }

        System.out.println("theBox " + boxText + " is no longer alive");
    }

    private void sleepAlittle(int s) {
        try {
            sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//      void Paint(Graphics g) {
    synchronized void Paint(Graphics g) {
        // Draw new graphic
        g.setColor(boxColor);
        //g.fillOval(xLocation, yLocation, shapeSize, shapeSize);
        g.fillRect(xLocation, yLocation, shapeSize, shapeSize);
        g.drawString(this.boxText, xLocation + 35, yLocation + 15);
    }
}
