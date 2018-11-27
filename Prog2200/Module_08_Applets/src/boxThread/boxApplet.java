package boxThread;

/**
 * Assignment:  Threads and Applets
 * 
 * 1) Write a Java applet that has three colored boxes on one side.
 * 2) Each “box” is an object of thread type, and each has it's own color and name
 * 3) Each box attempts to set the center box to it's own color and name
 * 4) As the center box is updated, it is seen on the screen with the new color and text.
 *
 * theBox class has two methods which are synched.  If you take out
 * the "synchronize" keyword on either, you can see the mix-up
 * on the screen as the updates mix between each other.
 *
 * @author Russell Shanahan
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JApplet;

public class boxApplet extends JApplet {

    // The box to update
    theBox myBox;
    // The threads which compete to update the box object
    runningThreads T1, T2, T3;
    // Used to force only one full-screen update
    boolean firstDisplay = true;

    @Override
    public void init() {

        // Create an offscreen image to draw on
        // Make it the size of the applet, this is just perfect larger
        // size could slow it down unnecessary.
        offscreen = createImage(getSize().width, getSize().height);

        // Create the objects and start them
        myBox = new theBox(this, "Fluffy #1", 500, 30, Color.RED);
        myBox.start();

        T1 = new runningThreads(myBox, Color.BLUE, "Blue", 40, 20);
        T2 = new runningThreads(myBox, Color.RED, "Red", 40, 60);
        T3 = new runningThreads(myBox, Color.GREEN, "Green", 40, 100);
        T1.start();
        T2.start();
        T3.start();
    }

    @Override
    public void start() {
        myBox.activateBox();
        firstDisplay = true;  // Full screen paint again
    }

    @Override
    public void stop() {
        myBox.sleepBox();
    }

    @Override
    public void destroy() {
        myBox.killBox();
    }
    // The image that will contain everything that has been drawn on
    // bufferGraphics.
    Image offscreen;

    @Override
    public void paint(Graphics g) {

        // offscreen is our off-screen buffer -- an Image object
        // Get its graphics object, for drawing
        Graphics gg = offscreen.getGraphics();
       
        // Clear full screen area
        gg.setColor(Color.DARK_GRAY);
        gg.fillRect(1, 1, this.getWidth(), this.getHeight());

        // Paint the objects
        myBox.Paint(gg);
        T1.Paint(gg);
        T2.Paint(gg);
        T3.Paint(gg);

        // Copy the contents of the Image to the on-screen area
        g.drawImage(offscreen, 0, 0, null);

        // We don't need this Graphics object anymore
        gg.dispose();

        System.out.println("...paint..." + this.getWidth());   // Lot's of printing

    }

}
