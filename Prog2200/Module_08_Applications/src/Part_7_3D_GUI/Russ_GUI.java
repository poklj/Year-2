package Part_7_3D_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class Russ_GUI {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Russ_GUI window = new Russ_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Russ_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Layout ... https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		// frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 50));
		// frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
		// frame.getContentPane().setLayout(new FlowLayout(FlowLayout.TRAILING, 5, 5));
		// frame.getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		// ComboBox
		String[] heroStrings = { "Superman", "WonderWoman", "Aquaman", "Batman", "SuperDog" };
		JComboBox<String> comboBox = new JComboBox<>(heroStrings);
		comboBox.setSelectedIndex(4);
		comboBox.setEnabled(true);
		frame.getContentPane().add(comboBox);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		frame.getContentPane().add(rdbtnNewRadioButton);

//		JButton btnNewButton_1 = new JButton("New button");
//		frame.getContentPane().add(btnNewButton_1);
//
//		JButton btnNewButton = new JButton("New button");
//		frame.getContentPane().add(btnNewButton);

		textField = new JTextField();
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnRuss = new JButton("russ");
		btnRuss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("RUSSY was here");

			}
		});
		frame.getContentPane().add(btnRuss);
	}
}
