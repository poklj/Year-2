package Part_1_Hello_Draw;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * 
 * Small panel class that draws on the screen
 *
 */
@SuppressWarnings("serial")
public class DrawHere extends JPanel {

	public void paintComponent(Graphics g) {
		System.out.println("C");
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.CYAN);
		g2.drawLine(20,20, getWidth(), getHeight());

		g2.setColor(Color.GREEN);
		g2.drawLine(0,getHeight(), getWidth(), 0);

		g2.setColor(Color.BLUE);
		g2.draw3DRect(30, 60, 240, 230, true);
		
		g2.setColor(Color.RED);
		g2.drawArc(30, 360, 390, 140, 300, 125);
		
		g2.setColor(Color.PINK);
		g2.fillRoundRect(100, 100, 90, 100, 30, 50);

		System.out.println("D");

	}
}
