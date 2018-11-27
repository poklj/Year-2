package Inventory;

import Inventory.ThreadMain;

public class Product {
	public static int id;
	public static String name;
	public static String description;
	private static int inv;

	public Product(int id, String name, String description, int inv) {
		Product.id = id;
		Product.name = name;
		Product.description = description;
		Product.inv = inv;

	}

	public synchronized static String getStaticThreadproduct() {

		return "===Printing inventory ===" +
		// return
				"Product ID: " + Product.id + " , Name:  " + Product.name +

				" , Product Description = " + Product.description + " Inventory = " + Product.inv;
		// return "getStaticThreadproduct()";
	}

	public synchronized static void writeStaticThreadproduct() {

		System.out.println("---Product ID: " + Product.id + " , Name:  " + Product.name +

				" , Product Description = " + Product.description + " Inventory = " + Product.inv);
	}

	public synchronized static void setStaticThreadproduct(int id, String name, String description, int inv) {
		// System.out.println(" =======111========= ");
		Product.id = id;
		// mySleep(100);
		Product.name = name;
		// mySleep(100);
		Product.description = description;
		// mySleep(100);
		Product.inv = inv;
		// mySleep(100);
	}

	// substract quantity to inventory
	public synchronized static boolean sellproduct(int quantity) {
		System.out.println("++++");
		if (quantity >= Product.inv){
			System.out.println(quantity + "...");
			return false;
		}
		
		// yes, we have inventory
		System.out.println("Sorry, the product is out of stock");
		if (quantity <= Product.inv)
			Product.inv = Product.inv - quantity;
		System.out.println("Now we still have:  " + Product.inv);
		// else
		System.out.println("...");
		return true;
	}
//
//	public synchronized static boolean tryGet() {
//
//		// is there inventory>0?
//
//		// yes, try=true, dec count
//
//		// no, try =false
//
//	}

	public static void mySleep(int d) {
		try {
			Thread.sleep(d);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
