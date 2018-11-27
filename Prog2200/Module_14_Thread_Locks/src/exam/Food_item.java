package exam;

public class Food_item {

	public String name;
	public String desc;
	private int inventory_count;

	public Food_item() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public synchronized int getInventory_count() {
		return inventory_count;
	}

	public synchronized void setInventory_count(int inventory_count) {
		this.inventory_count = inventory_count;
	}

	public synchronized int get_some(int how_many) {

		System.out.print("<");

		// Delay here to show it works.
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int amount_gotten = 0;
		if (inventory_count >= how_many) {
			// Take what you can
			amount_gotten = how_many;
			inventory_count = inventory_count - amount_gotten;
		} else {
			// ...or take all that is left, note inventory_count might already be 0
			amount_gotten = inventory_count;
			inventory_count = 0;
		}

		System.out.print(">");

		return amount_gotten;  // might be 0, or some positive number
	}

}
