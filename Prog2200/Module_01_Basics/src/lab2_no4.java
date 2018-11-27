
public class lab2_no4 {

	public static void main(String[] args) {

		for (int i = 1; i <= 20; i++) { // runs through numbers 1 - 20

			// move white space to right a little more each iteration
			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}

			System.out.print(i + " ");
			System.out.print(1 / i + " ");
			try {
				System.out.print(1 / (i - 12) + " ");
			} catch (Exception e) { // catches error when i = 0
				System.out.print("i =" + i + ". Cannot divide by zero. " + e);
			} finally {
				System.out.println();
			}
		}
	}
}
