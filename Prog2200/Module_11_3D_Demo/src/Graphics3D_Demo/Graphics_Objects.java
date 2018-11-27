package Graphics3D_Demo;

/**
 * @author Russell Shanahan
 * 
 * @NSCC.description This JApplet uses two sliders to control the 3D Shape.
 *  
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Graphics_Objects extends JApplet {

    /**
     * Main line class for placing 3D graphics in an Applet.
     */
    private static final long serialVersionUID = 1L;
    // JSliders for changing 3D angle (at bottom of screen)
    JSlider myScroll1;
    JSlider myScroll2;
    // Root container object
    Container c;
    // canvas for 3D painting
    BSMCanvas canvas;

    /**
     * JApplet init()
     */
    @Override
    public void init() {

        try {
            javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
                // Can't use thread from browser....so,
                // need to spawn another thread for JApplet

                public void run() {
                    // Separate thread starts the GUI
                    createGUI();
                }
            });
        } catch (Exception e) {
            // Something went wrong, dump stack
            System.err.println("createGUI didn't successfully complete");
            //e.printStackTrace();
        }
    }

    private void createGUI() {

        // Get the root content pane
        c = getContentPane();

        //Initialize the layout. p1=shape ; p2=controls
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        // Set graphics of shape into p1
        p1.setLayout(new BorderLayout());
        canvas = new BSMCanvas();
        p1.add(canvas);

        // Put the controls into the p2 panel
        p2.setLayout(new FlowLayout());

        // Set a gap between the sliders
        FlowLayout l = (FlowLayout) p2.getLayout();
        l.setHgap(90);

        //slider #1: 0 to 360 degrees, 90 deg. major scale
        myScroll1 = new JSlider(JSlider.HORIZONTAL, 0, 360, 0);
        myScroll1.setMajorTickSpacing(90);
        myScroll1.setMinorTickSpacing(45);
        myScroll1.setPaintTicks(true);
        myScroll1.setPaintLabels(true);
        myScroll1.setName("S1");
        myScroll1.setBorder(BorderFactory.createTitledBorder("S1 - Angle A"));

        //slider #2
        myScroll2 = new JSlider(JSlider.HORIZONTAL, 0, 360, 0);
        myScroll2.setMajorTickSpacing(90);
        myScroll2.setMinorTickSpacing(45);
        myScroll2.setPaintTicks(true);
        myScroll2.setPaintLabels(true);
        myScroll2.setName("S2");
        myScroll2.setBorder(BorderFactory.createTitledBorder("S2 - Angle B"));

        // sliders made, add them to panel 2
        p2.add(myScroll1);
        p2.add(myScroll2);

        // Add both panels to the main frame
        c.add(p1, BorderLayout.CENTER);
        c.add(p2, BorderLayout.SOUTH);

        // Add the listeners to the canvas
        myScroll1.addChangeListener(canvas);
        myScroll2.addChangeListener(canvas);

        // Set up the timer for auto-refresh
        canvas.theTimer();
    }

    @Override
    public void paint(Graphics g) {
        c.paintAll(g);
    }
    // 3D Shape object
    wireShape w1 = new wireShape(this);
    // A timer to refresh the screen
    Timer timer;

    // Canvas for 3D drawing
    class BSMCanvas extends Canvas implements ActionListener, ChangeListener {

        public Graphics2D big;

        public BSMCanvas() {

            // canvas settings
            setBackground(Color.cyan);

            // Constants for the 3D drawing...makes the shape
            double a1 = 0;
            double a2 = 0.25;
            double a3 = 0.75;

            // define the 3D object...symetrical using a1,a2,a3
            w1.addPoint(new pos3D(a1, a1, 0));
            w1.addPoint(new pos3D(a2, a2, 0));
            w1.addPoint(new pos3D(a3, -a3, 0));
            w1.addPoint(new pos3D(a3, a3, 0));
            w1.addPoint(new pos3D(a2, -a2, 0));
            w1.addPoint(new pos3D(a1, a1, 0));

            w1.addPoint(new pos3D(-a1, a1, 0));
            w1.addPoint(new pos3D(-a2, a2, 0));
            w1.addPoint(new pos3D(-a3, -a3, 0));
            w1.addPoint(new pos3D(-a3, a3, 0));
            w1.addPoint(new pos3D(-a2, -a2, 0));
            w1.addPoint(new pos3D(-a1, a1, 0));

            w1.addPoint(new pos3D(0, a1, a1));
            w1.addPoint(new pos3D(0, a2, a2));
            w1.addPoint(new pos3D(0, a3, -a3));
            w1.addPoint(new pos3D(0, a3, a3));
            w1.addPoint(new pos3D(0, a2, -a2));
            w1.addPoint(new pos3D(0, a1, a1));

            w1.addPoint(new pos3D(0, -a1, a1));
            w1.addPoint(new pos3D(0, -a2, a2));
            w1.addPoint(new pos3D(0, -a3, -a3));
            w1.addPoint(new pos3D(0, -a3, a3));
            w1.addPoint(new pos3D(0, -a2, -a2));
            w1.addPoint(new pos3D(0, -a1, a1));

            w1.addPoint(new pos3D(a1, 0, a1));
            w1.addPoint(new pos3D(a2, 0, a2));
            w1.addPoint(new pos3D(-a3, 0, a3));
            w1.addPoint(new pos3D(a3, 0, a3));
            w1.addPoint(new pos3D(-a2, 0, a2));
            w1.addPoint(new pos3D(a1, 0, a1));

            w1.addPoint(new pos3D(a1, 0, -a1));
            w1.addPoint(new pos3D(a2, 0, -a2));
            w1.addPoint(new pos3D(-a3, 0, -a3));
            w1.addPoint(new pos3D(a3, 0, -a3));
            w1.addPoint(new pos3D(-a2, 0, -a2));
            w1.addPoint(new pos3D(a1, 0, -a1));

            w1.start();

        }

        @Override
        public void paint(Graphics g) {
            w1.paintShape((Graphics2D) g);
          
        }
        // The image that will contain everything that has been drawn on
        // bufferGraphics.
        Image offscreen;

        @Override
        public void update(Graphics g) {
            // Removed from original update method.
            //g.clearRect(0, 0, this.getWidth(), this.getHeight());
            //paint(g);


            // offscreen is our off-screen buffer -- an Image object
            // Get its graphics object, for drawing
//            if (offscreen == null) {
                offscreen = createImage(getSize().width, getSize().height);
//                System.out.println("...canvas update..." + this.getWidth());   // Lot's of printing
//            }

            Graphics gg = offscreen.getGraphics();

            // Clear offscreen buffer and paint stuff back on
            gg.clearRect(0, 0, this.getWidth(), this.getHeight());
            paint(gg);
            
            // Copy the contents of the Image to the on-screen area
            g.drawImage(offscreen, 0, 0, null);

            // We don't need this Graphics object anymore
            gg.dispose();
        }

        
        // Event handler for sliders
        public void stateChanged(ChangeEvent e) {

            // Get the event object
            JSlider source = (JSlider) e.getSource();

            // Get the value of the slider
            double sliderValue = (double) source.getValue();
            double local_angle = 2 * 3.1415926536 * sliderValue / 360;

            // Which slider? Set the value to the right one
            if (source.getName().equals("S1")) {
                //w1.setAngle_a(local_angle);
            } else if (source.getName().equals("S2")) {
                w1.setAngle_b(local_angle);
            }

            // Need to refresh the screen for each change
            repaint();
        }

        public void theTimer() {
            timer = new Timer(10, this);
            timer.setInitialDelay(40);
            timer.setCoalesce(true);
            timer.start();
        }

        public void actionPerformed(ActionEvent e) {
//        	System.out.println("** Action=>Repaint");
            repaint();
        }
    }
}
