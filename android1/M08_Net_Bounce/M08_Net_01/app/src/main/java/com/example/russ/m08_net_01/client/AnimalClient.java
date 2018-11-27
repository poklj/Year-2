package com.example.russ.m08_net_01.client;

//import javax.swing.JPanel;
//import javax.swing.Timer;

import android.graphics.Canvas;

import com.example.russ.m08_net_01.common.NetColor;
import com.example.russ.m08_net_01.common.NetReader;
import com.example.russ.m08_net_01.common.NetWriter;
import com.example.russ.m08_net_01.common.NetworkAnimal;
import com.example.russ.m08_net_01.common.NetworkCommand;

import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

//import android.graphics.Color;  // use int for now
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public class AnimalClient implements Observer {

    private ArrayList<MovingDot_Android> localBalls = new ArrayList<MovingDot_Android>();

    private String server;

    private InetAddress address;
    private Socket sock;
    private static final int TIMEOUT = 0; // 0 = no time out

    String myIP;

    NetWriter sender;

    // A timer to refresh the screen
//    static Timer timer;

    public AnimalClient(String server) {
        this.server = server;

        try {
            // Need INTERNET permission
            //java.lang.SecurityException: Permission denied (missing INTERNET permission?)
            address = (InetAddress.getByName(this.server));
            sock = new Socket(address, NetworkAnimal.serverport);
            sock.setSoTimeout(TIMEOUT);
            myIP = sock.getLocalAddress().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // SendHandler sender = new SendHandler(sock);
        // sender.start();
        sender = new NetWriter(sock);
        sender.start();

//        // Set up Timer callbacks
//        timer = new Timer(5, this); // Set time, and this object gets event
//        timer.setInitialDelay(20); //
//        timer.setCoalesce(true); // Don't stack up events
//        timer.start(); // Start the timer object


        // Set up events to handle new animals from Network
        NetReader getter = new NetReader(sock);
        (new Thread(getter)).start();

        // We get incoming network messages
        getter.addObserver(this);

        // we trap our own keystrokes
//        this.addKeyListener(this);

    }

    static protected Box_Android box_android;

    public void setBox(Box_Android box) {
        AnimalClient.box_android = box;
    }

    public void onDrawAll(Canvas canvas) {
        // Draw the components
        box_android.draw(canvas);
        for (MovingDot_Android b : localBalls) {
            b.draw(canvas);  //draw each ball in the list
            //b.moveWithCollisionDetection(box);  // Update the position of the ball
        }
    }


//    public void paintComponent(Graphics g) {
//        // Setup and clear the new buffer
//        BufferedImage bufferedImage = new BufferedImage(this.getWidth(),
//                this.getHeight(), BufferedImage.TYPE_INT_BGR);
//        Graphics2D g2d = bufferedImage.createGraphics();
//        g2d.setColor(getBackground());
//        g2d.fillRect(0, 0, this.getWidth(), this.getHeight()); // fill
//
//        // Draw all MovingDots onto the buffer
//        if (localBalls != null) {
//            for (MovingDot c : localBalls) {
//                c.Paint(g2d); // Start each thread
//            }
//        }
//
//        // Set the buffer to be visible
//        Graphics2D g2dComponent = (Graphics2D) g;
//        g2dComponent.drawImage(bufferedImage, null, 0, 0);
//    }

//    /**
//     * This method is called when the timer fires The Timer sets off an "actionPerformed" event every so many milliseconds.
//     */
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//        for (int i = 0; i < localBalls.size(); i++) {
//            for (int j = i + 1; j < localBalls.size(); j++) {
//
//                if (localBalls.get(i).close(localBalls.get(i), localBalls.get(j))) {
//                    localBalls.get(i).bounce();
//                    //playSound();
//                }
//            }
//        }
//
//        this.repaint();
//    }

    @Override
    public void update(Observable arg0, Object event) {

        System.out.println("Trigger Class: " + arg0.getClass());
        System.out.println(" event= " + event.toString());

        if (event instanceof NetworkAnimal) {
            NetworkAnimal e = (NetworkAnimal) event;
            // / Add MovingDot per locations given over net (per event)
            MovingDot_Android newDot = new MovingDot_Android(e.pos_x, e.pos_y, e.vel_x, e.vel_y, e.c.getColor(),
                    e.s);
            newDot.start();
            localBalls.add(newDot); // add to arraylist
        }

        if (event instanceof NetworkCommand) {
            NetworkCommand e = (NetworkCommand) event;

            switch (e.getComm()) {
                case Add_Animal:
                    break;
                case Change_Movement:
                    // flip x-y for all animals
                    for (MovingDot c : localBalls) {
                        c.flipXY();
                    }
                    break;
                case No_Command:
                    break;
                case Remove_Animal:
                    break;
                case Reset:
                    //this.removeKeyListener(localBalls.get(0)); // remove key listener
                    // clear all animals
                    for (MovingDot c : localBalls) {
                        c.killDot(); // force threads to stop
                    }
                    localBalls.clear(); // clear the arraylist
                    break;
                default:
                    break;
            }
        }

//        // Set up key-pressed events
//        if ((localBalls != null) && (localBalls.size() > 0)) {
//            this.addKeyListener(localBalls.get(0)); // arrow keys work on first
//        }
//
//        this.setFocusable(true);
//        this.requestFocusInWindow();

    }

    private int rnd(int max) {
        int r = (int) (Math.random() * max);
        return r;
    }

    public int ballCount(){
        return localBalls.size();
    }

    public void resetAll() {
        sender.sendThisMsgOnQueue(new NetworkCommand(
                NetworkCommand.netCommands.Reset));
    }

    public void newBird(float x, float y, float dx, float dy) {
        sender.sendThisMsgOnQueue(new NetworkAnimal(
                NetworkAnimal.Animal.Bird, (int) x, (int) y, (int) dx, (int) dy,
                NetColor.BLUE, NetworkAnimal.Animal.Bird.toString()));
    }


//    @Override
//    public void keyPressed(KeyEvent e) {
//        System.out.println("Network Keycode=" + e.getKeyCode());
//
//        int ch = e.getKeyCode();
//        switch (ch) {
//            case KeyEvent.VK_R:
//                // Reset
//                sender.sendThisMsgOnQueue(new NetworkCommand(
//                        NetworkCommand.netCommands.Reset));
//                break;

//            case KeyEvent.VK_W:
//                // Reset
//                sender.sendThisMsgOnQueue(new NetworkCommand(
//                        NetworkCommand.netCommands.Change_Movement));
//                break;
//
//            case KeyEvent.VK_B:
//                // Add Animal
//                sender.sendThisMsgOnQueue(new NetworkAnimal(
//                        NetworkAnimal.Animal.Bird, rnd(100), rnd(100), 1 + rnd(12),
//                        1 + rnd(12), Color.BLUE, NetworkAnimal.Animal.Bird.toString()));
//                break;
//
//            case KeyEvent.VK_U:
//                // Add Animal
//                sender.sendThisMsgOnQueue(new NetworkAnimal(
//                        NetworkAnimal.Animal.Bunny, rnd(100), rnd(100), 1 + rnd(6),
//                        1 + rnd(6), Color.WHITE, NetworkAnimal.Animal.Bunny.toString()));
//                break;
//
//            case KeyEvent.VK_C:
//                // Add Animal
//                sender.sendThisMsgOnQueue(new NetworkAnimal(
//                        NetworkAnimal.Animal.Cat, rnd(100), rnd(100), 1 + rnd(3),
//                        1 + rnd(3), Color.BLACK, NetworkAnimal.Animal.Cat.toString()));
//                break;
//
//            case KeyEvent.VK_M:
//                // Add Animal
//                sender.sendThisMsgOnQueue(new NetworkAnimal(
//                        NetworkAnimal.Animal.Moose, rnd(100), rnd(100), 1 + rnd(5),
//                        1 + rnd(5), Color.PINK, NetworkAnimal.Animal.Moose.toString()));
//                break;
//
//            case KeyEvent.VK_T:
//                // Add Animal
//                sender.sendThisMsgOnQueue(new NetworkAnimal(
//                        NetworkAnimal.Animal.Turtle, rnd(100), rnd(100), 1 + rnd(2),
//                        1 + rnd(2), Color.GREEN, NetworkAnimal.Animal.Turtle.toString()));
//                break;
//
//            case KeyEvent.VK_ESCAPE:
//                System.exit(0); // end if esc pressed
//                break;
//        }
//    }

//    @Override
//    public void keyReleased(KeyEvent e) {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void keyTyped(KeyEvent e) {
//        // TODO Auto-generated method stub
//
//    }

}
