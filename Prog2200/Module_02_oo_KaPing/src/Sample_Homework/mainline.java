package Sample_Homework;

import java.util.Random;

public class mainline {
	
	// private static Random rnd = new Random();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random rnd = new Random();
		
		///// for loop
				
		Ball b = new Ball( rnd.nextInt(80) );
		Paddle p = new Paddle(rnd.nextInt(80), rnd.nextInt(15)+5);
		

		System.out.println("=========================");
		p.printit();
		b.printit();
		
		//if (b.getStart_pos()>p.getStart_pos()){
		if (b.does_it_collide(p))  {
			/// returned true....collided
			System.out.println("Ka-Ping");
		}
		
		
		///////

	}

}
