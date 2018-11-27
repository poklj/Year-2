package homework_try_05;

public class Star extends DisplayThing {

	public Star(String name, int dx, int dy) {
		super(name, dx, dy);
	}
	
	@Override
	public void doYourThing() {
		System.out.println(" ** Twinkle Twinkle ** ");
	}

	public void superNova() {
		System.out.println("** Ka-BOOM **");
	}

}
