
public class TheX {

	public static void main(String[] args) {

		int max = 20;

		for (int i = 1; i <= max; i++) {
			for (int j = 1; j <= max; j++) {
				if (i == max - j) {
					System.out.print(" ");
				} else {
					System.out.print("#");
				}
			}
			System.out.println();
		}
	}
}
