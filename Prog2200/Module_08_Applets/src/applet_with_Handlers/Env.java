package applet_with_Handlers;

import java.awt.Container;
import java.awt.Graphics;
import javax.swing.JApplet;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class Env {

    // Allow scope of these fields from JApplet to Handlers
    static Graphics g;
    static Container con;
    static theCat fluffy1;
    static JProgressBar progressBar;
    static JTextField myTextField = new JTextField("Hello", 20);
    static JApplet j;
    
}
