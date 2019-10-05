import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
	
	
	public static void main(String[] args) throws Exception{
		
		//-------------------- Exercice1 ---------------------------
		ExecutorService exec= Executors.newCachedThreadPool();
		
		for(int i=0;i<5;i++){ //5 Threads
			int j=i;
			exec.execute(()->{
				int start=j*2000;
				int end=start+2000;
				for(int k=j+1;k<=end;k++){
					System.out.println(Math.sqrt(k));
				}
			
			});
		}
		//------------------- Exercice 2 -------------------------
		
		ExecutorService exec1= Executors.newCachedThreadPool();
		List<Runnable> runnables=new ArrayList<Runnable>();
		for(int i=0;i<=10000;i++){
			runnables.add(new CalculRunnable(i));
		}
		
		for(int i=0;i<10000;i++){
			exec1.execute(runnables.get(i));
		}
		
		//---------------------- Exercie 3 ------------------------
		
		ExecutorService exec2= Executors.newCachedThreadPool();
		List<Callable<String>> callables=new ArrayList<Callable<String>>();
		
		for(int i=0;i<=10000;i++){
			callables.add(new CalculCallable(i));
		}
		
		ArrayList<Future<String>> futures=new ArrayList<Future<String>>();
		
		for(int i=0;i<=10000;i++){
			futures.add(exec2.submit(callables.get(i)));
		}
		
		System.out.println("something");
		
		
		for(int i=0;i<=10000;i++){
			System.out.println(futures.get(i).get()) ;
		}
		
		
	}

}
