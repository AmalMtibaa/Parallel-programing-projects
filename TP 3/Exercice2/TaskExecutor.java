package section3;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TaskExecutor{

	public static void main(String[] args) {
		int array[] = new int[1000000];
		ExecutorService executor = Executors.newFixedThreadPool(5);
		   for(int i=0;i<900000;i++)
		   {
			   int j=i;
			   executor.execute(() -> {
				   array[j]++;         
			   });
		   }
		  executor.shutdown();
		Date start = new Date();
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Date end = new Date();
		System.out.printf("Core: Fork/Join: %d\n", (end.getTime() - start.getTime()));

	}
}