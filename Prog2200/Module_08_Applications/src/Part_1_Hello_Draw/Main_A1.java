package Part_1_Hello_Draw;

import javax.swing.JFrame;

/**
 * 
 * Simple Drawing:
 *   Just a simple drawing program
 *
 *Try:
 *  1) Run the program
 *  2) DrawHere -> line 24 to 34 ...draw other stuff on the screen
 *  
 *
 */
public class Main_A1  {
    public static void main (String []args){
    	System.out.println("A");
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,700);
        frame.setVisible(true);
        frame.setContentPane(new DrawHere());
    	System.out.println("B");
    }
    
}