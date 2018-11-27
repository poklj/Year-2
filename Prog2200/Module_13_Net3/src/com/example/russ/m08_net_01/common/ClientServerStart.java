package com.example.russ.m08_net_01.common;

//import java.util.Timer;

import java.awt.Color;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import server.ServerHandler;
import client.AnimalClient;

/**
 * 
 * Network Client-Server
 * 
 * Steps:
 * 1) run ClientServerStart -> select blank -> makes server
 * 2) run ClientServerStart -> select IP -> makes client that connects to server
 * 3) ball bouncing in client came from server (AnimalServerThread, line 123)
 * 4) not much else is set up...just verify the network path taken
 * 
 * 
 */
public class ClientServerStart {

	public static void main(String[] args) {

//		// Set up jFrame window 
		JFrame frame = new JFrame();

		// Set up if we are server or client
		InetAddress Address = null;
		try {
			Address = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		// Ask user if we are server or client
		String s = (String) JOptionPane
				.showInputDialog(frame,
						"Server IP Address (null means this is server):\n",
						"Choose Server", JOptionPane.PLAIN_MESSAGE, null, null,
						Address);

		if ((s != null) && (s.length() > 0)) {
			// We are Client, String is server IP
			System.out.println("We ARE the >>>>>Client<<<<< => ");
			System.out.println("Server at => " + s);
			AnimalClient d = new AnimalClient(s);

			// Set up jFrame window for drawing
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(650, 750);
			frame.setVisible(true);
			frame.setContentPane(d);
			frame.getRootPane().setBackground(Color.LIGHT_GRAY);

			
		} else {
			// Blank string....we ARE the server!
			System.out.println("We ARE the >>>>>Server<<<<< => ");
			System.out.println("No Window frames, just Console Output");
			new ServerHandler().start();
			
		}

	}

}