package homework_try_06;

public class Butterfly extends DisplayThing {

	public Butterfly(String name) {
		super(name);
	}

	public Butterfly(String name, int dx, int dy) {
		super(name, dx, dy);
	}

	@Override
	public void doYourThing() {
		System.out.println("Name=" + this.name + " ** Flutter Flutter ** ...made it this far...x=" + this.x);
	}

	public void leaveCocoon() {
		System.out.println(" ** EEEEE-rrrrumph ** ");
	}

}
