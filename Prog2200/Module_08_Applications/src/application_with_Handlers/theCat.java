package application_with_Handlers;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JApplet;

public class theCat extends Thread {

    /**
     * theCat will start writing on the applet page (g) using the text in the
     * given buffer. The delay will determine how fast it wtites and the
     * xLocation will determine where to start.
     */
    volatile boolean cat_alive = false;
    volatile boolean cat_active = false;
    private String catName;
    private int delay;
    private int xLocation;
    private int yLocation = 40;
    private int xOldLocation;
    private int yOldLocation;
    private int yStart;  // original starting location

    private Color catColor;
    final int increment = 1;
    final int shapeSize = 40;
    // Declare array of colors (range is 0 to thing.length)
    private int maxSize = 400;  // roll-over cat location to zero when they reach maxSize

    public theCat( String theText, int delay, int yStart, Color catColor) {
        this.catName = theText;
        this.delay = delay;
        this.yStart = yStart;
        this.xLocation = 0;
        this.yLocation = yStart;
        this.xOldLocation = xLocation;
        this.yOldLocation = 0;
        this.catColor = catColor;

        System.out.println("Constructor for theCat: " + this.catName);
    }

    public void killCat() {
        if (cat_alive) {
            cat_alive = false;
        }
    }

    public void activateCat() {
        if (!cat_active) {
            cat_active = true;
        }
    }

    public void sleepCat() {
        if (cat_active) {
            cat_active = false;
        }
    }

    public void resetCat(String s) {
        yLocation = (int) (Math.random() * maxSize);
        xLocation = (int) (Math.random() * maxSize);
        catName = s;
    }

    @Override
    public void run() {

        System.out.println("Start theCat: " + this.catName);

        // Initial settings
        xLocation = 0;
        yLocation = yStart;
        cat_alive = true;
        cat_active = true;

        while (cat_alive == true) {
            while (cat_alive == true && cat_active == true) {

                // save old location for grey-out.
                xOldLocation = xLocation;
                yOldLocation = yLocation;

                // move based on increment
                xLocation = (xLocation + increment) % maxSize;

                // If thread loops too fast, the cat leaves a "trail"
                sleepAlittle(delay);
            }

            System.out.println(catName + " sleeping");
            sleepAlittle(500);
        }

        System.out.println("theCat " + catName + " is no longer alive");
    }

    private void sleepAlittle(int s) {
        try {
            sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void Paint(Graphics g) {
        // Grey old graphic...don't need this if paint clears screen for us
        //g.setColor(Color.LIGHT_GRAY);
        //g.fillOval(xOldLocation, yOldLocation, shapeSize, shapeSize);

        // Draw new graphic
        g.setColor(catColor);
        g.fillOval(xLocation, yLocation, shapeSize, shapeSize);
    }
}