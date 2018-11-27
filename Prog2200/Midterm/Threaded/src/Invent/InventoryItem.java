package Invent;



public class InventoryItem {
	
	public int id;
	public String name;
	public String description;
	private int inv;
	
	public InventoryItem(int id, String name, String description, int inv) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.inv = inv; //Amount We have
		
		System.out.println("We have: " + this.inv + this.name);
	}
	
	
	public synchronized boolean sellproduct(int quantity) {
		if (quantity > this.inv){
			System.out.println("Sorry, We don't have enough of " + this.name + " to fill the request");
			return false;
		}
		// yes, we have inventory
		if (quantity <= this.inv) {
			this.inv = this.inv - quantity;
		} else // If we get here, Something went HORRIBLY wrong (Concurrency break)
			System.out.println("Sorry, the product is out of stock");
		Sleep(1000);
		return true;
	}
	
	public synchronized int getProductAmount() {
		return this.inv; 
	}
	
	/**
	 * Processor func
	 * @param d
	 */
	public static void Sleep(int d) {
		try {
			Thread.sleep(d);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
