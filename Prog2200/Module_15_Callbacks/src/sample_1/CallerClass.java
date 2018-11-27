package sample_1;

public class CallerClass extends Thread {
	CallBack c;

	public void register(CallBack callback) {
		this.c = callback;
		// later on I can call the callback
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			c.declaredMethod();  // call the callback
		}
	}

}
