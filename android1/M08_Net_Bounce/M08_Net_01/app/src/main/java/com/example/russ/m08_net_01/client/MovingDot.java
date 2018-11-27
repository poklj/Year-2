package com.example.russ.m08_net_01.client;

//import android.graphics.Color; // use int
//import java.awt.Graphics;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;

import java.io.File;

import static java.lang.Thread.sleep;
//import javax.swing.ImageIcon;

public class MovingDot extends Thread {

    /**
     * MovingDot will start writing on the page (g) using the text in the given buffer. The delay will determine how fast it writes and the xLocation
     * will determine where to start.
     */
    volatile boolean dot_alive = false;
    volatile boolean dot_active = false;
    private String dot_name;
    protected int delay;


    protected float xPos;
    protected float yPos = 40;

    protected float xVel = 0;
    protected float yVel = 0;



//    protected int xMin = 0;
//    protected int xMax = 1200;
//    protected int yMin = 0;
//    protected int yMax = 700;

    protected int dot_color;
    final int increment = 1;
    final float shapeSize = 40;
    protected int maxSize = 400;

    // <RS> remove image icon capability (for now)
    //ImageIcon ImageIcon;  // display this instead of dot

    public MovingDot() {
    }

    public MovingDot(int xStart, int yStart, int xVel, int yVel,
                     int dotColor, String theFilename) {
        this.delay = 10;
        this.xPos = xStart;
        this.yPos = yStart;
        this.xVel = xVel;
        this.yVel = yVel;

        this.dot_color = dotColor;
        this.dot_name = theFilename;

        // Use icon instead of dot
        //System.out.println(System.getProperty("user.dir"));  // output users "current" directory     
//        File varTmpFile = new File(theFilename + ".jpg");
//        if (varTmpFile.exists()) {
//            ImageIcon = new ImageIcon(theFilename + ".jpg"); //file name as parameter
//        } else {
//            ImageIcon = new ImageIcon("control.jpg");
//        }

        System.out.println("Constructor for MovingDot: " + this.dot_name);
    }

    public void killDot() {
        if (dot_alive) {
            dot_alive = false;
        }
    }

    public void activateDot() {
        if (!dot_active) {
            dot_active = true;
        }
    }

    public void sleepDot() {
        if (dot_active) {
            dot_active = false;
        }
    }

    public void randomDot(String s) {
        yPos = (int) (Math.random() * maxSize); // Somewhere on screen
        xPos = (int) (Math.random() * maxSize);
        yVel = (int) (Math.random() * 10) - 5; // velocity between -5 and 5
        xVel = (int) (Math.random() * 10) - 5;
        dot_name = s;
    }

    @Override
    public void run() {

        System.out.println("Start MovingDot: " + this.dot_name);

        // Initial settings
        dot_alive = true;
        dot_active = true;

        while (dot_alive == true) {
            while (dot_alive == true && dot_active == true) {

                // Always try to decrement the bounce count
                if (justBounced > 0) {
                    justBounced = justBounced - 1;
                }

                // move based on velocity
                xPos = xPos + xVel;
                yPos = yPos + yVel;

                if (xPos > AnimalClient.box_android.xMax) {
                    xVel = -Math.abs(xVel); // force negative
                }
                if (xPos < AnimalClient.box_android.xMin) {
                    xVel = +Math.abs(xVel); // force positive
                }

                if (yPos > AnimalClient.box_android.yMax) {
                    yVel = -Math.abs(yVel); // force negative
                }
                if (yPos < AnimalClient.box_android.yMin) {
                    yVel = +Math.abs(yVel); // force positive
                }

                // If thread loops too fast, MovingDot leaves a "trail"
                sleepAlittle(delay);
            }

            System.out.println(dot_name + " sleeping");
            sleepAlittle(500);
        }

        System.out.println("MovingDot " + dot_name + " is no longer alive");
    }

    final int bounceSetting = 20; // # of times to ignore next bounces
    final float closeVal = shapeSize / 2; // How close to trigger collision
    int justBounced = bounceSetting; // Count down for bounce

    public boolean close(MovingDot a, MovingDot b) {
        boolean isClose = false;

        // Don't bounce multiple times in one collision
        if ((a.justBounced == 0) && (b.justBounced == 0)
                && (Math.abs(a.xPos - b.xPos) < closeVal)
                && (Math.abs(a.yPos - b.yPos) < closeVal)) {
            isClose = true;
            justBounced = bounceSetting;
        }
        return isClose;
    }

    // Reverse velocity when bouncing (go the other way)
    public void bounce() {
        xVel = -xVel;
        yVel = -yVel;
    }

    // Swap x and y velocities...better bounce
    public void bounceBoth(MovingDot other) {
        float temp_xVel = this.xVel;
        float temp_yVel = this.yVel;

        this.xVel = other.xVel;
        this.yVel = other.yVel;

        other.xVel = temp_xVel;
        other.yVel = temp_yVel;
    }

    private void sleepAlittle(int s) {
        try {
            sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    void Paint(Graphics g) {
//        // Draw new graphic
//        g.setColor(dot_color);
//
//        // Change from fillOval to ImageIcon to draw panted JPG
////        ImageIcon.paintIcon(null, g, xPos, yPos);    // Draw JPG
//        g.fillOval(xPos - shapeSize / 2, yPos - shapeSize / 2, shapeSize, shapeSize);
//
////        g.drawChars(dot_name.toCharArray(), 0, dot_name.toCharArray().length,
////                xPos - shapeSize / 2, yPos - shapeSize / 2);
//    }

    public void flipXY() {
        float temp = this.xPos;
        this.xPos = this.yPos;
        this.yPos = temp;
    }

//    @Override
//    public void keyPressed(KeyEvent e) {
//        System.out.println("Keycode=" + e.getKeyCode() + " x loc=" + xPos
//                + " y loc=" + yPos);
//
//        int ch = e.getKeyCode();
//        switch (ch) {
//            case KeyEvent.VK_UP:
//                yVel++;
//                break;
//            case KeyEvent.VK_DOWN:
//                yVel--;
//                break;
//            case KeyEvent.VK_LEFT:
//                xVel--;
//                break;
//            case KeyEvent.VK_RIGHT:
//                xVel++;
//                break;
//            case KeyEvent.VK_ESCAPE:
//                System.exit(0); // end if esc pressed
//                break;
//        }
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//        // System.out.println("B key=" + e.getKeyChar());
//    }
//
//    @Override
//    public void keyTyped(KeyEvent e) {
//        // System.out.println("C key=" + e.getKeyChar());
//    }

}
