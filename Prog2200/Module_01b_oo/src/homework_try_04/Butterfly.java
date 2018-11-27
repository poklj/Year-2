package homework_try_04;

public class Butterfly extends DisplayThing {

	public Butterfly(String name) {
		super(name);
	}
	
	public Butterfly(String name, int dx, int dy) {
		super(name, dx, dy);
	}
	
	@Override
	public void doYourThing() {
		System.out.println(" ** Flutter Flutter ** ");
	}

	public void leaveCocoon() {
		System.out.println(" ** EEEEE-rrrrumph ** ");
	}
		
}
