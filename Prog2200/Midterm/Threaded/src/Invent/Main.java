package Invent;

public class Main {
	public static void main(String[] args) {
		InventoryItem apple = new InventoryItem(1, "Apple", "A fruit", 10);
	
		Salesman s1 = new Salesman(apple, "s1");
		Salesman s2 = new Salesman(apple, "s2");
		Salesman s3 = new Salesman(apple, "s3");
		Salesman s4 = new Salesman(apple, "s4");
		Salesman s5 = new Salesman(apple, "s5");
	
		s1.start();
		s2.start();
		s3.start();
		s4.start();
		s5.start();
		
	}
}
