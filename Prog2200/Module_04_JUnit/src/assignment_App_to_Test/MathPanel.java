package assignment_App_to_Test;

//Imports are listed in full to show what's being used
//could just import javax.swing.* and java.awt.* etc..

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class MathPanel extends JPanel implements ActionListener {

	// Our Math calculations
	private DoMath mathObject;

	// GUI text fields and buttons
	protected JTextField value_1;
	protected JTextField value_2;
	protected JTextField answerText;
	protected JButton multiplyButton;
	protected JButton addButton;
	protected JButton subButton;
	protected JButton divButton;

	public MathPanel() {

		// Set up cat
		mathObject = new DoMath();

		// Set up key-pressed events
		this.setFocusable(true);
		this.requestFocusInWindow();

		// Create text fields and buttons in order that they appear on screen
		value_1 = new JTextField("0", 12);
		value_1.setActionCommand("Variable 1");
		value_1.setToolTipText("Variable 1");
		value_1.setEditable(true);

		// Create button and listen
		addButton = new JButton("Add");
		addButton.setActionCommand("Add");
		addButton.setEnabled(true);
		addButton.addActionListener(this);

		multiplyButton = new JButton("Multiply");
		multiplyButton.setActionCommand("Multiply");
		multiplyButton.setEnabled(true);
		multiplyButton.addActionListener(this);

		subButton = new JButton("Sub");
		subButton.setActionCommand("Sub");
		subButton.setEnabled(true);
		subButton.addActionListener(this);

		divButton = new JButton("Div");
		divButton.setActionCommand("Div");
		divButton.setEnabled(true);
		divButton.addActionListener(this);

		value_2 = new JTextField("0", 12);
		value_2.setActionCommand("Variable 2");
		value_2.setToolTipText("Variable 2");
		value_2.setEditable(true);

		// Answer field
		answerText = new JTextField("0", 12);
		answerText.setEditable(false); // We set this, not user

		// Add button and text components to this container
		// using the default FlowLayout. This order sets the location on the
		// screen
		add(value_1);
		add(addButton);
		add(multiplyButton);
		add(subButton);
		add(divButton);
		add(value_2);
		add(answerText);

	}

	/**
	 * Handle when the button is pressed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Button pressed  => " + e.toString());

		// Update values of text fields
		mathObject.setVar_1(Integer.parseInt(value_1.getText()));
		mathObject.setVar_2(Integer.parseInt(value_2.getText()));

		Integer answer = 0;
		if (e.getActionCommand().matches("Multiply")) {
			answer = mathObject.Multiply();
		}
		if (e.getActionCommand().matches("Add")) {
			answer = mathObject.Add();
		}

		// Set the answer back in last text field
		answerText.setText(answer.toString());

	}
}
