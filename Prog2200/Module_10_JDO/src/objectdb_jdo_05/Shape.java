/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectdb_jdo_05;

import java.awt.Color;

/**
 *
 * @author W0091766
 */
public abstract class Shape extends Thread {
//private static final long serialVersionUID = 1L;

    private int id;
    private int x1;
    private int y1;
    private Color c;

    
    @Override
    public void run(){
    
        for(int i=0; i<10; i++){
            System.out.println("Shape ... " + i );
        }
        
        
    }
    
    
    /**
     * @return the x1
     */
    public int getX1() {
        return x1;
    }

    /**
     * @param x1 the x1 to set
     */
    public void setX1(int x1) {
        this.x1 = x1;
    }

    /**
     * @return the y1
     */
    public int getY1() {
        return y1;
    }

    /**
     * @param y1 the y1 to set
     */
    public void setY1(int y1) {
        this.y1 = y1;
    }

    /**
     * @return the c
     */
    public Color getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(Color c) {
        this.c = c;
    }

    transient double area;
    //double area;
    public abstract double computeArea();

}
