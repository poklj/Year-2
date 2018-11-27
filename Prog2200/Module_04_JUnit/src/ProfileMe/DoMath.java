/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProfileMe;

/**
 *
 * @author w0091766
 */
public class DoMath {

    public void busy1(double inc) {

        for (double d = 0.0; d < Math.PI; d = d + inc) {
            System.out.println("d=" + d + "   cos=" + Math.cos(d));
        }
    }

    public void busy2(double inc) {

        for (double d = 0.0; d < Math.PI; d = d + inc) {
            System.out.println("d=" + d + "   cos=" + Math.cos(d));
            System.out.println("random1=" + (int) (50 * Math.random()));
            System.out.println("random2=" + 50 * (int) Math.random());
        }
    }

    // calculate COS using Math package
    public double myCOS1(double x) {
        double cos = 0;
        cos = Math.cos(x);
        System.out.println("cos1("+x+")" + cos);
        return cos;
    }

    // calculate COS using series
    public double myCOS2(double x) {
        double cos = 0;
        cos = 1 - x * x / (1 * 2) + x * x * x * x / (1 * 2 * 3 * 4);
        System.out.println("cos2("+x+")" + cos);
        return cos;
    }

    // calculate COS using series
    public double myCOS3(double x) {
        double cos = 0;
        cos = 1 - x * x / (1 * 2) + x * x * x * x / (1 * 2 * 3 * 4)
                - x * x * x * x * x * x / (1 * 2 * 3 * 4 * 5 * 6);
        System.out.println("cos2("+x+")" + cos);
        return cos;
    }
}
