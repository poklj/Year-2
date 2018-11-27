package OzThread.lock;

public class Data {
	public enum OZpeople {
		SCARECROW, COWARDLYLION, TINMAN
	}

	public enum OZcolors {
		BROWN, YELLOW, SILVER
	}

	public static OZpeople likes;
	public static OZcolors color;

	public Data(OZpeople p, OZcolors c) {
		Data.likes = p;
		Data.color = c;
	}

	public synchronized static String getStaticThreadperson() {
		return "likes= " + Data.likes + " Color= " + Data.color + "\n";
	}

	public synchronized static void setStaticThreadperson(OZpeople p, OZcolors c) {
	//public static void setStaticThreadperson(OZpeople p, OZcolors c) {
				// public synchronized static void setStaticThreadperson(String name, long
		// phone, long cell, String email) {
		Data.likes = p;
		//mySleep(20);
		Data.color = c;
	}

	public static void mySleep(int d) {
		try {
			Thread.sleep(d);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
