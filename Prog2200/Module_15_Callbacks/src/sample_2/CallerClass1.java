package sample_2;

public class CallerClass1 extends Thread{

	ChangeSize mySavedCallBackSource;
	public void register(ChangeSize callback) {
		mySavedCallBackSource = callback;
	}

	public void run(){
		
		for(int i=0;i<20;i++){
			
			mySavedCallBackSource.SetHeight(i*10);
			mySavedCallBackSource.SetWidth(i*20);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
				
	}
		
}
