
public class CalculRunnable implements Runnable {
	
	private int i;
	
	public CalculRunnable(int i){
		this.i=i;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Math.sqrt(i));
	}

}


