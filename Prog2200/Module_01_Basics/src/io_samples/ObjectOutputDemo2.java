package io_samples;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputDemo2 {

	/**
	 * After this program is run the first time, the file is created, and you can
	 * comment out the write portion, and just read the file contents.
	 * 
	 * You can open the file with notepad++ and read some contents (strings), but
	 * integers are saved in binary format, not strings.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		BufferedReader z = new BufferedReader(new InputStreamReader(System.in));

		// Get myString
		String s = "";
		System.out.print("Enter myString: ");
		try {
			s = z.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("  ....Thank-you, ...now saving as a file ");

		// Instantiate Serializable Object for writing to disk
		SerClass n = new SerClass();
		n.setX(24); // hard-code some sample numbers
		n.setY(35);
		n.setMyString(s); // use string entered
		System.out.println("Write -> n.s = " + n.getMyString() + " X = " + n.getX() + " Y = " + n.getY());

		// Output
		FileOutputStream fout;
		try {
			fout = new FileOutputStream("FileOutputDemo2.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(n);
			oos.flush();
			oos.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// Input same data back into a different object
		ObjectInputStream objectinputstream = null;
		SerClass m = new SerClass();
		try {
			FileInputStream streamIn = new FileInputStream("FileOutputDemo2.ser");
			objectinputstream = new ObjectInputStream(streamIn);
			m = (SerClass) objectinputstream.readObject();
			objectinputstream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (objectinputstream != null) {
				try {
					objectinputstream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println();
		System.out.println("Read -> m.s = " + m.getMyString() + " X = " + m.getX() + " Y = " + m.getY());

	}

}
