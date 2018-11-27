package assignment_App_to_Test;

public class About_Lambda {

	/**
	 * This code snippet shows how a lambda expression is used to run a method. In
	 * jUnit, testing for exceptions requires running a method, and catching the
	 * exception raised, and checking if that is the exact exception that was
	 * supposed to be raised.
	 * 
	 * 
	 * Sample taken from:
	 * http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/Lambda-QuickStart/index.html
	 * and use case from:
	 * https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
	 * @throws Exception 
	 * 
	 */
	public static void main(String[] args) throws Exception {

		// how to use Lambda operator
		System.out.println("=== how to use Lambda operator ===");

		// Anonymous Runnable
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("*** Hello world one! ***");
				DoMath m = new DoMath();
				m.setVar_2(6); // so that exception isn't raised
				m.Multiply(); // ignore result
			}
		};

		// Lambda Runnable
		Runnable r2 = () -> System.out.println("*** Hello world two! ***");

		// Lambda Runnable
		Runnable r3 = () -> {
			System.out.println("Hello world three!");
			DoMath m = new DoMath();
			m.setVar_2(6);

			for (int V1 = 0; V1 < 10; V1++) {
				m.setVar_1(V1);
				System.out.println("V1=" + V1 + "   V2=6  Multiply=" + m.Multiply());
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		// Run em! (each finishes before the next starts)
		System.out.println("====== Run each as methods ======");
		r3.run();
		Thread.sleep(20);  // doesn't Interleave
		r1.run();
		r2.run();
		
		
		// OK, that's all, but if you are curious as to 
		// how to make these run as threads...
		System.out.println("====== Run each as threads ======");
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);

		t3.start();
		Thread.sleep(20);  // Interleaves (you might need to tweak sleeps)
		t1.start(); // out of sequence to show interleaving
		t2.start();

	}

}
