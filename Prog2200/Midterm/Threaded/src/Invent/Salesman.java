package Invent;


public class Salesman extends Thread {

	
	private InventoryItem Sellthis;
	private String seller;
	public int salesmade = 0;
	
	public Salesman(InventoryItem i, String name) {
		this.Sellthis = i;
		this.seller = name;
	}
	
	public void PrintSales(){
		System.out.println(this.seller +" sold " + this.salesmade + this.Sellthis.name + "At days end");
	}
	
	@Override
	public void run() {
		try {
            for (int i = 0; i < 3; i++) {
            	//sell something
            	if(Sellthis.sellproduct(1)) {
            		//This will happen about the same time that another seller comes in to sell, This is normal
            		System.out.println(seller +" Sold");
            		this.salesmade++;
            	} else {
            		break;
            	}
            }
            PrintSales();

                //Thread.sleep(75);
       } catch (Exception e) {
           System.out.println("Exception: " + e.getMessage());
       }
		
	} 
}
