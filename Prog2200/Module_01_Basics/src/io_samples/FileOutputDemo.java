package io_samples;

import java.io.*;

class FileOutputDemo {
	public static void main(String[] arg) {
		PrintWriter fileOut;

		BufferedReader z = new BufferedReader(new InputStreamReader(System.in));

		String s = "";
		System.out.print("Enter a Number: ");
		try {
			s = z.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		System.out.print("  ....Thank-you, and your number is: " + s);

		try {
			fileOut = new PrintWriter(new FileWriter("FileOutputDemo.txt"));

			fileOut.println("Hello!");
			fileOut.println("Number was: " + s);

			fileOut.close();
		} catch (Exception e) {
			System.err
					.println("Error when attempting to open, write to, or close FileOutputDemo.txt");
		}
	}
}
