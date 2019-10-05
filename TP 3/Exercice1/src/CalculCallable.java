import java.util.concurrent.Callable;

public class CalculCallable implements Callable<String> {

	private int i;
	
	public CalculCallable(int i){
		this.i=i;
	}
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return String.valueOf(Math.sqrt(i));
	}

}
