package startHere;

import ProfileMe.DoMath;

public class ProfileMain {

    private static DoMath d = new DoMath();

    public static void main(String[] args) {


        // Double
        for (int i = 0; i < 10; i++) {
            d.busy1(0.01);
        }
        for (int i = 0; i < 10; i++) {
            d.busy2(0.001);
        }


        // COS
        for (int i = 0; i < 10000; i++) {
            for (double x = 0; x < Math.PI; x = x + Math.PI / 10) {
                d.myCOS1(x);
            }
            for (double x = 0; x < Math.PI; x = x + Math.PI / 10) {
                d.myCOS2(x);
            }
            for (double x = 0; x < Math.PI; x = x + Math.PI / 10) {
                d.myCOS3(x);
            }
        }

        // Show difference in the calculations
        for (double x = 0; x < Math.PI; x = x + Math.PI / 10) {
            //d.myCOS1(x);
            System.out.println("cos1( " + x + ") = " + d.myCOS1(x) + "cos3( " + x + ") = " + d.myCOS3(x)
                    + " difference = " + (d.myCOS1(x) - d.myCOS3(x)));
        }


    }
}
