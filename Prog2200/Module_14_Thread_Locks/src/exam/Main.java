package exam;


public class Main {

	public static void main(String[] args) {
		
		Warehouse w = new Warehouse();
		w.start();
		w.restock();
		
		for (int i = 1; i < 6; i++){
			Salesman s = new Salesman(w,i);
			s.start();
		}
	}
}
