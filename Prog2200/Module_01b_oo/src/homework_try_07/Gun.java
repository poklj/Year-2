package homework_try_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gun {

	private int dx, dy;

	public int getDx() {
		return dx;
	}

	public int getDy() {
		return dy;
	}

	public Gun() {

		BufferedReader z = new BufferedReader(new InputStreamReader(System.in));

		String s = null;
		System.out.print("Enter a dx: ");
		try {
			s = z.readLine();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		dx = (int) Integer.parseInt(s);

		System.out.print("Enter a dy: ");
		try {
			s = z.readLine();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		dy = (int) Integer.parseInt(s);

	}

}
