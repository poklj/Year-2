package module_07_applets;

/**
 * Basic JApplet Refer to:
 * http://java.sun.com/docs/books/tutorial/deployment/applet/index.html
 *
 * @author Russell Shanahan
 */
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JApplet;

public class Simple extends JApplet {

    theCat fluffy1 = new theCat(this, "Fluffy #1", 5, 50, Color.RED);
    theCat fluffy2;
    boolean firstDisplay = true;  // Used to force only one full-screen update

    @Override
    public void init() {
        fluffy1 = new theCat(this, "Fluffy #1", 5, 50, Color.RED);
        fluffy1.start();

        fluffy2 = new theCat(this, "Fluffy #2", 25, 50, Color.blue);
        fluffy2.start();

        this.setSize(700, 300);
    }

    @Override
    public void start() {
        fluffy1.activateCat();
        fluffy2.activateCat();
        firstDisplay = true;  // Full screen paint again
    }

    @Override
    public void stop() {
        fluffy1.activateCat();
        fluffy2.activateCat();
    }

    @Override
    public void destroy() {
        fluffy1.killCat();
        fluffy2.killCat();
    }

    /**
     * In this version of paint, We'll display only what we want, when we want.
     * We remove the call to the super class, so no other components are
     * automatically painted...we need to call any paint method that needs
     * repainting.
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        //super.paint(g); // Call superclass method...causes full refresh of screen
        setBackground(Color.LIGHT_GRAY);

        if (firstDisplay) {
            // Clear the background of the whole screen only first time
            setBackground(Color.LIGHT_GRAY);
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(1, 1, this.getWidth(), this.getHeight());
            
            int tempW = this.getWidth();
            int tempH = this.getHeight();
            
            firstDisplay = false;  // Full screen paint no more

            System.out.println("### First ###");
        }

        // Paint whatever we have on the screen
        fluffy1.Paint(g);
        fluffy2.Paint(g);

    }
}
