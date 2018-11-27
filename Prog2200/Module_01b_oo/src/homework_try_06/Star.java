package homework_try_06;

public class Star extends DisplayThing {

	public Star(String name, int dx, int dy) {
		super(name, dx, dy);
	}

	@Override
	public void doYourThing() {
		System.out.println("Name=" + this.name + " ** Twinkle Twinkle ** ...made it this far...x=" + this.x);
	}

	public void superNova() {
		System.out.println("** Ka-BOOM **");
	}

}
