/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.russ.m08_net_01.common.NetColor;
import com.example.russ.m08_net_01.common.NetReader;
import com.example.russ.m08_net_01.common.NetWriter;
import com.example.russ.m08_net_01.common.NetworkAnimal;
import com.example.russ.m08_net_01.common.NetworkCommand;
import com.example.russ.m08_net_01.common.NetworkAnimal.Animal;
import com.example.russ.m08_net_01.common.NetworkCommand.netCommands;

/**
 * 
 * @author Russ
 * @param <E>
 * 
 */
public class ServerHandler extends Thread implements Observer {

	Socket sock = null;
	ServerSocket serverSocket = null;

	private boolean more = true;
	private final Integer serverport = com.example.russ.m08_net_01.common.NetworkAnimal.serverport;

	ArrayList<NetWriter> clients = new ArrayList<NetWriter>();

	public ServerHandler() {
		super("AnimalServer");
		try {
			serverSocket = new ServerSocket(serverport.intValue());
			System.out.println("AnimalServer listening/Getting on port: " + serverSocket.getLocalPort());
		} catch (java.io.IOException e) {
			System.err.println("Could not create datagram socket.");
		}
	}

	Boolean duplicate = false;

	@Override
	public void run() {
		if (serverSocket == null) {
			return;
		}

		while (more) {
			System.out.println("Waiting for next client.....");
			try {
				sock = serverSocket.accept();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// Launch Reader Thread to handle this new client
			NetReader reader = new NetReader(sock);
			// reader.start();
			(new Thread(reader)).start();
			reader.addObserver(this);

			NetWriter writer = new NetWriter(sock);
			writer.start();

			clients.add(writer);
			System.out.println("Writer Array Size: " + clients.size());
			for (NetWriter w : clients) {
				System.out.print(" :: " + w.getIP());
			}

			// Let's get some stuff over at the client as default
			writer.sendThisMsgOnQueue(new NetworkAnimal(NetworkAnimal.Animal.Turtle, rnd(100), rnd(100), rnd(10),
					rnd(10), NetColor.RED, "Russ 1"));

			writer.sendThisMsgOnQueue(new NetworkAnimal(NetworkAnimal.Animal.Turtle, rnd(100), rnd(100), rnd(10),
					rnd(10), NetColor.RED, "Russ 2"));

			writer.sendThisMsgOnQueue(new NetworkAnimal(NetworkAnimal.Animal.Turtle, rnd(100), rnd(100), rnd(10),
					rnd(10), NetColor.RED, "Russ 3"));

			writer.sendThisMsgOnQueue(new NetworkAnimal(NetworkAnimal.Animal.Turtle, rnd(100), rnd(100), rnd(10),
					rnd(10), NetColor.RED, "Russ 4"));

		}

		try {
			serverSocket.close();
		} catch (IOException ex) {
			Logger.getLogger(ServerHandler.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private int rnd(int max) {
		int r = (int) (Math.random() * max);
		return r;
	}

	@Override
	public void update(Observable arg0, Object event) {

		System.out.println("Trigger Class: " + arg0.getClass());
		System.out.println(" event= " + event.toString());

		if (event instanceof com.example.russ.m08_net_01.common.NetworkAnimal) {
			com.example.russ.m08_net_01.common.NetworkAnimal e = new com.example.russ.m08_net_01.common.NetworkAnimal(
					(NetworkAnimal) event);

			// Send new animal to all clients (including sender)
			for (NetWriter w : clients) {
				w.sendThisMsgOnQueue(e);
				System.out.print(" send new animal to " + w.getIP());
			}

		}

		if (event instanceof com.example.russ.m08_net_01.common.NetworkCommand) {
			com.example.russ.m08_net_01.common.NetworkCommand e = new com.example.russ.m08_net_01.common.NetworkCommand(
					(NetworkCommand) event);

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
				// Send new animal to all clients (including sender)
				for (NetWriter w : clients) {
					w.sendThisMsgOnQueue(e);
					System.out.print("send reset to " + w.getIP());
				}
				break;
			default:
				break;

			}

		}

	}

}
