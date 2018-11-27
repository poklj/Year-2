/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applet_with_Handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *implements ActionListener
 * @author Russ
 */
public class Action_Handler implements ActionListener {
    private int count = 0;

    public Action_Handler() {
        System.out.println("Constructor Action_Handler");
    }

    //override
    public void actionPerformed(ActionEvent e) {
        // Reset fields per user entered settings
        String myField = Env.myTextField.getText();
        System.out.println("Text is " + myField);
        Env.fluffy1.resetCat("Fluffy1 " + myField);

        System.out.println("Action_Handler actionPerformed");
        System.out.println("Action: " + e.toString());
        System.out.println("Action getSource: " + e.getSource());
        System.out.println("Action getID: " + e.getID());
        System.out.println("Action getWhen: " + e.getWhen());
        System.out.println("Action getModifiers: " + e.getModifiers());
        System.out.println("Action getActionCommand: " + e.getActionCommand());

        // Set the progress bar to dertermined and inc on count
        Env.progressBar.setIndeterminate(false);
        Env.progressBar.setMaximum(100); // Max progress at 100
        Env.progressBar.setValue(count++); // Start progress at 0

    }
}
