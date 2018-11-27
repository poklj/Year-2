package homework_try_01;

public class Butterfly extends DisplayThing {

	public Butterfly(String name) {
		super(name);
	}
	
	@Override
	public void doYourThing() {
		System.out.println(" ** Flutter Flutter ** ");
	}

	public void leaveCocoon() {
		System.out.println(" ** EEEEE-rrrrumph ** ");
	}
		
}
