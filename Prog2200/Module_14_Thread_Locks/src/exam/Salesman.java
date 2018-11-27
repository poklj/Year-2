package exam;

public class Salesman extends Thread {

	private int Empnum;
	int[] items_sold;

	Warehouse w;

	public Salesman(Warehouse w, int Empnum) {
		this.Empnum = Empnum;
		items_sold = new int[w.items.size()];  // size taken from warehouse
		this.w = w;
	}

	@Override
	public void run() {
		try {

			System.out.println("Salesman #" + this.getEmpnum() + "  Starting");
			while (w.soldout == false) {
				// w.sellFood();

				int random_num = (int) (Math.random() * w.items.size());
				
				System.out.println("S" + this.getEmpnum() + "=" + w.items.get(random_num).getName());
								
				Food_item food_to_get = w.items.get(random_num);
				// hard-coded to sell 1 at a time
				int amount_got = food_to_get.get_some(1);

				items_sold[random_num] = items_sold[random_num] + amount_got;
				
				if (amount_got>0) {
					System.out.print(".");
				} else {
					System.out.print("x");
				}

				Thread.sleep(25);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.print("Salesmen " + this.getEmpnum()
				+ " has sold a total of ...");
		for (int i = 0; i < items_sold.length; i++) {
			Food_item f = w.items.get(i);
			System.out.println(f.name + "  " + f.desc + "  "
					+ items_sold[i]);
		}

	}

	// Getters and Setters
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public int getEmpnum() {
		return Empnum;
	}

	public void setEmpnum(int empnum) {
		Empnum = empnum;
	}

}
