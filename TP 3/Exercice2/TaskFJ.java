package section3;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

public class TaskFJ extends RecursiveAction {
	private final int array[];
	private final int start, end;

	public TaskFJ(int array[], int start, int end) {
		this.array = array;
		this.start = start;
		this.end = end;
	}

	protected void compute() {
		if (end - start > 1000) {
			int mid = (start + end) / 2;
			TaskFJ task1 = new TaskFJ(array, start, mid);
			TaskFJ task2 = new TaskFJ(array, mid, end);
			task1.fork();
			task2.fork();
			task1.join();
			task2.join();
		} else {
			for (int i = start; i < end; i++) {
				array[i]++;
				try {
					TimeUnit.MILLISECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		int array[] = new int[1000000];
		TaskFJ taskFJ = new TaskFJ(array, 1,200000);
		ForkJoinPool pool = new ForkJoinPool();
		Date start = new Date();
		pool.execute(taskFJ);
		pool.shutdown();

		try {
			pool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Date end = new Date();
		System.out.printf("Core: Fork/Join: %d\n", (end.getTime() - start.getTime()));

	}
}