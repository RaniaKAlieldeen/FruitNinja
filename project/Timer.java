package project;

public class Timer extends Thread{
	@Override
	public void run() {
	while(Controller.getController1().getcounter()>=0) {
		System.out.println(Controller.getController1().getcounter());
		Controller.getController1().setCounter(Controller.getController1().getcounter()-1);
		
		try {
			
			Timer.sleep(1000);
			
		
		}catch(Exception ex) {
			
			System.out.println(ex);
			
		}
		
	}
		
	}
	

}
