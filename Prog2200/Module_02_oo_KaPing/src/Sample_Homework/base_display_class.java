package Sample_Homework;

public class base_display_class {

	private int start_pos;
	private int length;
	private char ch = 'X';

	public base_display_class(char ch, int start_pos, int length) {
		this.ch = ch;
		this.start_pos = start_pos;
		this.length = length;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getStart_pos() {
		return start_pos;
	}

	public void setStart_pos(int start_pos) {
		this.start_pos = start_pos;
	}

	public boolean does_it_collide(base_display_class o2) {

		System.out.println("This=>" + this.toString() + "  object=>" + o2.toString());

		if (this == o2) {
			// Don't compare object with itself
			System.out.println("Same as me!!!");
		}

		int i = o2.length;

		if ((this.start_pos >= o2.start_pos) && (this.start_pos + this.length <= o2.start_pos)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Print the display object in it's place
	 */
	public void printit() {
		for (int i = 0; i < this.start_pos; i++) {
			System.out.print(" ");
		}

		for (int i = 0; i < this.length; i++) {
			System.out.print(ch);
		}
		System.out.println();
	}

	public String toString() {
		return "Pos=>" + this.start_pos + "  Length=>" + this.length;
	}

}
