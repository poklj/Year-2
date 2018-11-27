package Part_7_3D_GUI;

//Imports are listed in full to show what's being used
//could just import javax.swing.* and java.awt.* etc..
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Acts as the "main line" of the JPanel. Adds some shapes to the screen.
 * 
 * @author Russ
 *
 */
@SuppressWarnings("serial")
public class DrawHere extends JPanel implements ActionListener, MouseMotionListener {

	/**
	 * List of shapes to display
	 */
	private List<shapeBase> shapes = new ArrayList<shapeBase>();

	/**
	 * Initializes the screen, sets up shapes.
	 */
	public DrawHere() {

		// Set background
		this.setBackground(Color.BLACK);

		// 3D Shape object
		shapeBase wire_1 = new MyWire(Color.BLUE, new Pos3D(0, 0, 0), new Pos3D(0.12, 0.30, 0.0), new Pos3D(0, 0, 0),
				new Pos3D(0.01, 0.02, 0.03));

		shapeBase wire_2 = new MyWire(Color.RED, new Pos3D(2, 0, 0), new Pos3D(0.20, -0.13, 0.0), new Pos3D(0, 0, 0),
				new Pos3D(-0.03, 0.02, 0.03));

		shapeBase cube_1 = new Cube(Color.GREEN, new Pos3D(1.5, 1.5, 1.5), new Pos3D(0.0, 0.0, 0.13),
				new Pos3D(0, 0, 0), new Pos3D(-0.03, 0.02, 0.03));

		shapeBase cube_2 = new Cube(Color.ORANGE, new Pos3D(1.5, 1.5, 1.5), new Pos3D(0.20, 0.10, 0.13),
				new Pos3D(0, 0, 0), new Pos3D(-0.03, 0.08, 0.03));

		shapeBase cube_3 = new Cube(Color.RED, new Pos3D(1.5, 1.5, 1.2), new Pos3D(0.20, 0.15, 0.13),
				new Pos3D(0, 0, 0), new Pos3D(-0.03, 0.08, 0.03));

		// put the shapes into the shapes array.
		shapes.add(wire_1);
		shapes.add(wire_2);
		shapes.add(cube_1);
		shapes.add(cube_2);
		shapes.add(cube_3);

		this.setFocusable(true);
		this.requestFocusInWindow();

		// Register for mouse events
		// per
		// https://docs.oracle.com/javase/tutorial/uiswing/events/mousemotionlistener.html
		addMouseMotionListener(this);
	}

	/**
	 * Refresh the screen by calling this method. Ensure there is some mechanism to
	 * repeatedly call this method as needed.
	 * 
	 * This method loops through the shapes to redraw each one.
	 */
	public void paintComponent(Graphics g) {

		// System.out.println("w=" + this.getWidth() + " H=" +
		// this.getHeight());
		Pos2D screenSize = new Pos2D(this.getWidth(), this.getHeight());

		// Setup and clear the buffer
		BufferedImage bufferedImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_BGR);
		Graphics2D g2d = bufferedImage.createGraphics();

		// fill with background color
		g2d.setColor(getBackground());
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

		// Draw the shapes on the screen buffer.
		for (shapeBase s : shapes) {
			s.paintShape(g2d, screenSize);
		}

		// Set the buffer to be visible
		Graphics2D g2dComponent = (Graphics2D) g;
		g2dComponent.drawImage(bufferedImage, null, 0, 0);

	}

	/**
	 * This method is called when the timer fires. The Timer sets off an
	 * "actionPerformed" event every so many milliseconds.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.repaint();

		// Take focus if we don't have it
		if (!this.isFocusOwner()) {
			this.requestFocusInWindow();
		}
	}

	Random R = new Random();

	/**
	 * Small random between -.5 and .5
	 * 
	 * @return
	 */
	private double sm() {
		return R.nextDouble() - 0.5;
	}

	/**
	 * medium random between -2 and 2
	 * 
	 * @return
	 */
	private double med() {
		return (R.nextDouble() * 4) - 2;
	}

	/**
	 * 
	 */
	public void addCube() {
		shapeBase cube = new Cube(Color.BLUE, new Pos3D(med(), med(), med()), new Pos3D(sm(), sm(), sm()),
				new Pos3D(sm(), sm(), sm()), new Pos3D(sm(), sm(), sm()));

		// add to shape arraylist
		shapes.add(cube);
	}

	/**
	 * 
	 */
	public void addWire() {
		shapeBase wire = new MyWire(Color.RED, new Pos3D(med(), med(), med()), new Pos3D(sm(), sm(), sm()),
				new Pos3D(sm(), sm(), sm()), new Pos3D(sm(), sm(), sm()));

		// add to shape arraylist
		shapes.add(wire);
	}

	/**
	 * 
	 */
	public void addPyramid() {
		shapeBase pyramid = new Pyramid(Color.GREEN, new Pos3D(med(), med(), med()), new Pos3D(sm(), sm(), sm()),
				new Pos3D(sm(), sm(), sm()), new Pos3D(sm(), sm(), sm()));

		// add to shape arraylist
		shapes.add(pyramid);
	}

	/**
	 * 
	 */
	public void clear() {
		shapes.clear();

	}

	// Keep track of dragged mouse movement
	int last_Dragged_X;
	int last_Dragged_Y;

	@Override
	public void mouseDragged(MouseEvent arg0) {
		System.out.println("Dragged: X=" + arg0.getX() + "  Y=" + arg0.getY());

//		// Have some fun...
//		int dX = last_Dragged_X - arg0.getX();
//		int dY = last_Dragged_Y - arg0.getY();
//		last_Dragged_X = arg0.getX();      // next iteration
//		last_Dragged_Y = arg0.getY();		
//		//System.out.println("Dragged: dX=" + dX + "  dY=" + dY);
//		for (shapeBase s : shapes) {
//			s.BudgeTranslation((double)(dX/200), (double)(dY/200), 0);
//		}
	}

	
	// Keep track of dragged mouse movement
	private int last_Moved_X;
	private int last_Moved_Y;

	@Override
	public void mouseMoved(MouseEvent arg0) {
		System.out.println("Moved: X=" + arg0.getX() + "  Y=" + arg0.getY());
		
//		// Have some fun...
//		int dX = last_Moved_X - arg0.getX();
//		int dY = last_Moved_Y - arg0.getY();
//		last_Moved_X = arg0.getX();      // next iteration
//		last_Moved_Y = arg0.getY();		
//		//System.out.println("Moved: dX=" + dX + "  dY=" + dY);
//		for (shapeBase s : shapes) {
//			s.BudgeRotation((double)(dX/200), (double)(dY/200), 0);
//		}
	}

}
