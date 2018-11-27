package OzThread.lock;

public class ThreadMain {

	public static void main(String[] args) {

		Data dorothy = new Data(null, null);
		
		
		for (int i = 0; i != 1000000; i++) { // remove this for a non broken version
		thread Tin = new thread(Data.OZpeople.TINMAN, Data.OZcolors.SILVER);
		Tin.start();

		thread Crow = new thread(Data.OZpeople.SCARECROW, Data.OZcolors.BROWN);
		Crow.start();

		thread Lion = new thread(Data.OZpeople.COWARDLYLION, Data.OZcolors.YELLOW);
		Lion.start();}

		for (int i = 0; i < 1000000; i++) {
			try {
				Thread.sleep(50);
				System.out.println(Data.getStaticThreadperson());
				// String s = Data.getStaticThreadperson();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}
}
