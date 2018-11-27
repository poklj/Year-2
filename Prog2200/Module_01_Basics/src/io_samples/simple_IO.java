package io_samples;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class simple_IO {

    public static void main(String[] args) {

        BufferedReader z = new BufferedReader(new InputStreamReader(System.in));

        String s = null;
        System.out.print("Enter a String: ");
        try {
            s = z.readLine();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        System.out.println(" String is : " + s);

        int i = 0;
        Exception myException = new Exception("I Don't like that number");
        System.out.print("Enter a number: ");
        try {
            s = z.readLine();
            i = (int) Integer.parseInt(s);
            if (i == 7) {
                throw myException;
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (Exception e) {
            System.out.println("		Exception: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println(" Number is : " + i);

        System.out.print("  ....Thank-you ");

    }
}
