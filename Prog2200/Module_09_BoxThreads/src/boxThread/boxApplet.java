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

    @Override
    public void paint(Graphics g) {
        super.paint(g); // Call superclass method...causes full refresh of screen
        setBackground(Color.LIGHT_GRAY);

        if (firstDisplay) {
            // Clear the background of the whole screen only first time
            setBackground(Color.LIGHT_GRAY);
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(1, 1, this.getWidth(), this.getHeight());
            firstDisplay = false;  // Full screen paint no more

            System.out.println("### First ###");
        }

        // Paint the objects
        myBox.Paint(g);
        T1.Paint(g);
        T2.Paint(g);
        T3.Paint(g);
    }
}
