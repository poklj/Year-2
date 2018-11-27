package Inventory;


public class ThreadMain extends Thread{
	
	public int id;
	public String name;
	public String description;
	public int inv;
	
	





	public ThreadMain(int id, String name, String description, int inv){
		this.id=id;
		this.name=name;
		this.description = description;
		this.inv= inv;
		
	}
	
	
	@Override
	public void run() {
		
        System.out.println("Print Inventory: id = " + this.id + " , Name: "+ this.name + " , description" + this.description + " , Inventory: "+this.inv);
        try {
            for (int i = 0; i < 1; i++) {
               
                //Product.setStaticThreadproduct(this.id, this.name, this.description, this.inv);
            	
            	int quantity = 1;
            	if (Product.sellproduct(quantity)) {
            		// sold something
            		
            	}

                //Thread.sleep(75);
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
		
	}

}
