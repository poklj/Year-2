package sample_2;

public class CallerClass2 extends Thread{

	ChangeSize mySavedCallBackSource;
	public void register(ChangeSize callback) {
		mySavedCallBackSource = callback;
	}

	public void run(){
		
		for(int i=0;i<20;i++){
			
			mySavedCallBackSource.SetHeight(i*11);
			mySavedCallBackSource.SetWidth(i*21);
			
			try {
				Thread.sleep(110);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	
}
