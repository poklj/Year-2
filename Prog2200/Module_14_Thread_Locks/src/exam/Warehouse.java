package exam;

import java.util.ArrayList;

public class Warehouse extends Thread {

	ArrayList<Food_item> items = new ArrayList<Food_item>();
	public boolean soldout = false;
	public int totalSales = 0;

	public Warehouse() {
		Banana banana_inv = new Banana();
		Apple apple_inv = new Apple();
		Orange orange_inv = new Orange();
		Potato potato_inv = new Potato();
		Lemon lemon_inv = new Lemon();

		items.add(banana_inv);
		items.add(apple_inv);
		items.add(orange_inv);
		items.add(potato_inv);
		items.add(lemon_inv);

	}

	public void restock() {

		for (Food_item f : items) {
			f.setInventory_count(5);
		}

		System.out.println("~~~~~~~~~~ Warehouse Inventory ~~~~~~~~~~~~~~");
		for (Food_item f : items) {
			this.descFood(f);
		}
		System.out.println("");
	}

	public void descFood(Food_item food) {
		System.out.println("");
		System.out.println("Name: " + food.name);
		System.out.println("Desc: " + food.desc);
		System.out.println("Amount: " + food.getInventory_count());
	}

	public void takeNap(int howLong) {
		try {
			Thread.sleep(howLong);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {

		while (!soldout) {

			takeNap(20);

			// Count remaining
			int total = 0;
			for (Food_item f : items) {
				total = total + f.getInventory_count();
				if (f.getInventory_count()==0) {
					System.out.println();
					System.out.println(f.name + " is sold out!!");
				}
			}

			// Set sold out if all gone
			if (total == 0) {
				soldout = true;
			}

			System.out.println("Total remaining: " + total);
		}

	}

}
