package client;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.example.russ.m08_net_01.common.NetColor;
import com.example.russ.m08_net_01.common.NetReader;
import com.example.russ.m08_net_01.common.NetWriter;
import com.example.russ.m08_net_01.common.NetworkAnimal;
import com.example.russ.m08_net_01.common.NetworkCommand;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("serial")
public class AnimalClient extends JPanel implements ActionListener, Observer,
		KeyListener {

	private ArrayList<theCat> l = new ArrayList<theCat>();;
	private String server;

	private InetAddress address;
	private Socket sock;
	private static final int TIMEOUT = 0; // 0 = no time out

	String myIP;

	NetWriter sender;

	// A timer to refresh the screen
	static Timer timer;

	public AnimalClient(String server) {
		this.server = server;

		try {
			address = (InetAddress.getByName(this.server));
			sock = new Socket(address, com.example.russ.m08_net_01.common.NetworkAnimal.serverport);
			sock.setSoTimeout(TIMEOUT);
			myIP = sock.getLocalAddress().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// SendHandler sender = new SendHandler(sock);
		// sender.start();

		sender = new NetWriter(sock);
		sender.start();

		// Set up Timer callbacks
		timer = new Timer(5, this); // Set time, and this object gets event
		timer.setInitialDelay(20); //
		timer.setCoalesce(true); // Don't stack up events
		timer.start(); // Start the timer object

		// Set up events to handle new animals from Network
		NetReader getter = new NetReader(sock);
		(new Thread(getter)).start();

		// We get incoming network messages
		getter.addObserver(this);

		// we trap our own keystrokes
		this.addKeyListener(this);

	}

	public void paintComponent(Graphics g) {
		// Setup and clear the new buffer
		BufferedImage bufferedImage = new BufferedImage(this.getWidth(),
				this.getHeight(), BufferedImage.TYPE_INT_BGR);
		Graphics2D g2d = bufferedImage.createGraphics();
		g2d.setColor(getBackground());
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight()); // fill

		// Draw all cats onto the buffer
		if (l != null) {
			for (theCat c : l) {
				c.Paint(g2d); // Start each thread
			}
		}

		// Set the buffer to be visible
		Graphics2D g2dComponent = (Graphics2D) g;
		g2dComponent.drawImage(bufferedImage, null, 0, 0);
	}

	/**
	 * This method is called when the timer fires The Timer sets off an
	 * "actionPerformed" event every so many milliseconds.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < l.size(); i++) {
			for (int j = i + 1; j < l.size(); j++) {

				if (l.get(i).close(l.get(i), l.get(j))) {
					l.get(i).bounce();
					// playSound();
				}
			}
		}

		this.repaint();
	}

	@Override
	public void update(Observable arg0, Object event) {

		System.out.println("Trigger Class: " + arg0.getClass());
		System.out.println(" event= " + event.toString());

		if (event instanceof com.example.russ.m08_net_01.common.NetworkAnimal) {
			com.example.russ.m08_net_01.common.NetworkAnimal e = (com.example.russ.m08_net_01.common.NetworkAnimal) event;
			// / Add cat per locations given over net (per event)
			theCat newCat = new theCat(e.pos_x, e.pos_y, e.vel_x, e.vel_y, e.c,
					e.s);
			newCat.start();
			l.add(newCat); // add to arraylist
		}

		if (event instanceof com.example.russ.m08_net_01.common.NetworkCommand) {
			com.example.russ.m08_net_01.common.NetworkCommand e = (com.example.russ.m08_net_01.common.NetworkCommand) event;

			switch (e.getComm()) {
			case Add_Animal:
				break;
			case Change_Movement:
				break;
			case No_Command:
				break;
			case Remove_Animal:
				break;
			case Reset:
				this.removeKeyListener(l.get(0)); // remove key listener
				// clear all animals
				for (theCat c : l) {
					c.killCat(); // force threads to stop
				}
				l.clear(); // clear the arraylist
				break;
			default:
				break;
			}
		}

		// Set up key-pressed events
		if ((l != null) && (l.size() > 0)) {
			this.addKeyListener(l.get(0)); // arrow keys work on first
		}

		this.setFocusable(true);
		this.requestFocusInWindow();

	}

	private int rnd(int max) {
		int r = (int) (Math.random() * max);
		return r;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Network Keycode=" + e.getKeyCode());

		int ch = e.getKeyCode();
		switch (ch) {
		case KeyEvent.VK_R:
			// Reset
			sender.sendThisMsgOnQueue(new NetworkCommand(
					NetworkCommand.netCommands.Reset));
			break;
		case KeyEvent.VK_N:
			// Add Animal
			sender.sendThisMsgOnQueue(new NetworkAnimal(
					NetworkAnimal.Animal.Turtle, rnd(100), rnd(100), rnd(10),
					rnd(10), NetColor.BLUE, myIP,
					NetworkAnimal.NetCommand.Add_Animal));
			break;

		case KeyEvent.VK_ESCAPE:
			System.exit(0); // end if esc pressed
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
