package Inventory;

import java.util.HashMap;

public class Inventory {
	
	
	
	//substract quantity to inventory
//	public void sellproduct(int quantity, int inv) {
//		System.out.println("++++");
//		if (quantity >= Product.inv)
//			System.out.println(quantity+"...");
//		System.out.println("Sorry, the product is out of stock");
//		if  (quantity <= Product.inv)
//			Product.inv = Product.inv - quantity;
//			System.out.println("Now we still have:  " + Product.inv);
////		else
//			System.out.println("...");
//	}
	
	//add quantity to invotory
	public void buyproduct(int quantity,int inv) {
		inv = quantity+inv;
		
		System.out.println("Thank you for shopping!");
	}
	
	
	public static void main(String[] args) {
		
		HashMap< String, Integer> hashmap = new HashMap< String,Integer>();
		hashmap.put("Pen", 10);
		hashmap.put("Notebook", 15);
		hashmap.put("Ink", 8);
		hashmap.put("Backpack", 20);
		hashmap.put("Ruler", 3);
		System.out.println("In Stock: "+hashmap);
		
		
		final Inventory Invt = new Inventory();

		
		
		
		ThreadMain a = new ThreadMain(01,"Pen", "A red pen", 10) {
			public void cal() {
				//Invt.sellproduct(2, 10);
				System.out.println("===" + Invt);
				//did not go in this function
				
			}
		};
		a.start();
		ThreadMain b = new ThreadMain(02,"Notebook", "Database design notbook", 15 );
		b.start();
		ThreadMain c = new ThreadMain(03,"Ink", "A bottle of blue ink", 8 );
		c.start();
		ThreadMain d = new ThreadMain(04, "Backpack", "Nike", 20 );
		d.start();
		ThreadMain e = new ThreadMain(05,"Ruler", "Plastic", 3 );
		e.start();
		
		
		
		for (int i=0; i<3; i++) {
			System.out.println(Product.getStaticThreadproduct());
		}
		try {
			Thread.sleep(100);
			System.out.println(Product.getStaticThreadproduct());
		}catch (InterruptedException e1) {
            e1.printStackTrace();
        }
	}

}
