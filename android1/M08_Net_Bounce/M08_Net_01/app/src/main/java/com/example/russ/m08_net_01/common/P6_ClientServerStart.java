package com.example.russ.m08_net_01.common;

//import java.util.Timer;

//import android.graphics.Color;

import com.example.russ.m08_net_01.client.AnimalClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

//import javax.swing.JFrame;
//import javax.swing.JOptionPane;

/**
 * Network Client-Server
 * <p/>
 * Steps:
 * 1) run ClientServerStart -> select blank -> makes server
 * 2) run ClientServerStart -> select IP -> makes client that connects to server
 * 3) ball bouncing in client came from server (ServerHandler, line 91)
 * 4) "R" Remove all dots
 * 5) "T" Add a new dot (Turtle)
 * 6) escape ends the program
 * 7) MovingDot line 185 -> Draw name above dot
 * 8) MovingDot line 185 -> Draw picture instead of dot
 * 9) AnimalClient line 185 -> Add "W" warp dots/pictures
 * 10) AnimalClient line 185+ -> Add "B" Bird
 * 11) AnimalClient line 185+ -> Add "U" Bunny
 * 12) AnimalClient line 185+ -> Add "C" Cat
 * 13) AnimalClient line 185+ -> Add "M" Moose
 * 14) Paint Program -> change pictures of Turtle, Bird, ...
 */
public class P6_ClientServerStart {

    public static AnimalClient localClient = null;

    public static void main(String[] args) {

        // Set up jFrame window
//		JFrame frame = new JFrame();

        // Set up if we are server or client
        InetAddress Address = null;
        try {
            Address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        System.out.println("IP Address at => " + Address.toString());

        // Ask user if we are server or client
//		String s = (String) JOptionPane
//				.showInputDialog(frame,
//						"Server IP Address (null means this is server):\n",
//						"Choose Server", JOptionPane.PLAIN_MESSAGE, null, null,
//						Address);


        //String s = "127.0.0.1";  // Hard code Server IP
        String s = "172.16.176.102";  // Hard code Server IP
        //String s = Address.toString();  // Hard code this device as Server

        // if client, comment out server start, hard code server into string
//		System.out.println("We ARE the >>>>>Server<<<<< => ");
//		System.out.println("No Window frames, just Console Output");
//		new ServerHandler().start();

        System.out.println("We ARE the >>>>>Client<<<<< => ");
        System.out.println("Server at => " + s);
        localClient = new AnimalClient(s);


//		if ((s != null) && (s.length() > 0)) {
//			// We are Client, String is server IP
//			System.out.println("We ARE the >>>>>Client<<<<< => ");
//			System.out.println("Server at => " + s);
//			AnimalClient localClient = new AnimalClient(s);
//
////			// Set up jFrame window for drawing
////			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////			frame.setSize(650, 750);
////			frame.setVisible(true);
////			frame.setContentPane(localClient);
////			frame.getRootPane().setBackground(Color.LIGHT_GRAY);
//
//
//		} else {
//			// Blank string....we ARE the server!
//			System.out.println("We ARE the >>>>>Server<<<<< => ");
//			System.out.println("No Window frames, just Console Output");
//			new ServerHandler().start();
//		}

    }
}