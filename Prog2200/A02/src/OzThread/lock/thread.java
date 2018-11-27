package OzThread.lock;

public class thread extends Thread {

	public Data.OZpeople person;
	public Data.OZcolors color;

	public thread(Data.OZpeople p, Data.OZcolors c) {
		this.person = p;
		this.color = c;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 1000000; i++) {
				Data.setStaticThreadperson(this.person, this.color);
				// System.out.println("Loop thread " + i + " "+ this.name);
				Thread.sleep(30);
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}

}
