/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectdb_jdo_05;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author W0091766
 */
public class Triangle extends Shape {

    private int x2;
    private int y2;

    private int x3;
    private int y3;

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.println("Triangle ... " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Square.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * @return the x2
     */
    public int getX2() {
        return x2;
    }

    /**
     * @param x2 the x2 to set
     */
    public void setX2(int x2) {
        this.x2 = x2;
    }

    /**
     * @return the y2
     */
    public int getY2() {
        return y2;
    }

    /**
     * @param y2 the y2 to set
     */
    public void setY2(int y2) {
        this.y2 = y2;
    }

    /**
     * @return the x3
     */
    public int getX3() {
        return x3;
    }

    /**
     * @param x3 the x3 to set
     */
    public void setX3(int x3) {
        this.x3 = x3;
    }

    /**
     * @return the y3
     */
    public int getY3() {
        return y3;
    }

    /**
     * @param y3 the y3 to set
     */
    public void setY3(int y3) {
        this.y3 = y3;
    }

    @Override
    public String toString() {
        double a = this.computeArea();
        return "Triangle area = " + a;
    }

    @Override
    public double computeArea() {
        // wrong computation for area, but you get the idea
        area = (double) this.getX1() * x2 / this.getY1();
        return area;
    }
}
