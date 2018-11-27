package applet_with_Handlers;

import javax.swing.*;

import java.awt.*;

/**
 * 
 * @author Russ
 * 
 * Swing components
 * http://java.sun.com/docs/books/tutorial/uiswing/components/componentlist.html
 * 
 * 
 */
public class Swing3 extends JApplet {

    private static final long serialVersionUID = 1L;
    Font aFont = new Font("TimesRoman", Font.PLAIN, 20);
    JLabel theLabel = new JLabel("Press the button");
    JButton button = new JButton("Press");
    //
    // Event Handlers
    Wheel_Handler wHandler;
    Component_Handler cHandler;
    Action_Handler aHandler;
    Key_Handler kHandler;
    Mouse_Handler mHandler;
    boolean firstDisplay = true;  // Used to force only one full-screen update

    @Override
    public void init() {
    	
        // Add Container Handler at start, to see if any events fire
        Container_Handler conHandler = new Container_Handler();
        this.addContainerListener(conHandler);

        Env.g = this.getGraphics();
        Env.con = getContentPane();
        Env.con.setLayout(new FlowLayout());

        // add stuff to JPanel
        Env.con.add(button);
        Env.con.add(theLabel);
        Env.con.add(Env.myTextField);
        theLabel.setFont(aFont);

        // Get Context of this Applet
        System.out.println(" Doc Base => " + getDocumentBase().toString());
        System.out.println(" Code Base => " + getCodeBase().toString());
        System.out.println(" Applet Info => " + getAppletInfo().toString());
        System.out.println(" Applet Context => " + getAppletContext().toString());
        System.out.println(" Locale => " + getLocale().toString());

        // Parameters
        String pinfo[][] = getParameterInfo();
        System.out.println(" pinfo[0][0] => " + pinfo);

        // Create listeners, and set them to listen
        cHandler = new Component_Handler();
        this.addComponentListener(cHandler);
        aHandler = new Action_Handler();
        button.addActionListener(aHandler);
        kHandler = new Key_Handler();
        Env.myTextField.addKeyListener(kHandler);
        mHandler = new Mouse_Handler();
        this.addMouseListener(mHandler);
        wHandler = new Wheel_Handler();
        this.addMouseWheelListener(wHandler);

        // Create and start threads
        Env.fluffy1 = new theCat(this, "hello", 5, 50, Color.RED);
        Env.fluffy1.start();

        // Create and display a progress bar
        Env.progressBar = new JProgressBar(0, 50);
        Env.progressBar.setValue(0);
        Env.progressBar.setStringPainted(true);
        Env.progressBar.setIndeterminate(true);
        Env.con.add(Env.progressBar);
        
        JApplet j = this;
        Env.j = this;
        
        
    }

    public void rest(int d) {
        try {
            Thread.sleep(d);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start() {
        Env.fluffy1.activateCat();
        firstDisplay = true;  // Full screen paint again

    }

    @Override
    public void stop() {
        Env.fluffy1.sleepCat();
    }

    @Override
    public void destroy() {
        Env.fluffy1.killCat();
    }


    // The image that will contain everything that has been drawn on
    // bufferGraphics.
    Image offscreen;
  
    @Override
    public void paint(Graphics g) {
     
        // Create an offscreen image to draw on
        // Make it the size of the applet, Declare here if size allowed to change
        offscreen = createImage(getSize().width, getSize().height);
    	
        // offscreen is our off-screen buffer -- an Image object
        // Get its graphics object, for drawing
        Graphics gg = offscreen.getGraphics();
        
        Env.con.paint(gg);
        Env.con.paintAll(gg);
        Env.fluffy1.Paint(gg);

        // Copy the contents of the Image to the on-screen area
        g.drawImage(offscreen, 0, 0, null);

        // We don't need this Graphics object anymore
        gg.dispose();

        //System.out.println("...paint..." + this.getWidth());   // Lot's of printing

    }

    @Override
    public String getAppletInfo() {
        return ("Applet:Swing1;  Author:Russ;  Version:0.02");
    }
}
