package section1;

public class Test {

	public static void main(String[] args)
	{
		Thread threads[];
		Thread.State status[];

		// Launch 10 threads to do the operation, 5 with the max
		// priority, 5 with the min
		threads = new Thread[10];
		status = new Thread.State[10];
		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(new Calculator());
			if ((i % 2) == 0) {
				threads[i].setPriority(Thread.MAX_PRIORITY);
			} else {
				threads[i].setPriority(Thread.MIN_PRIORITY);
			}
		}
		for (int i = 0; i < 10; i++) {
			threads[i].start();
		}
		System.out.println(threads[0].getThreadGroup());
		ThreadGroup Groupe = new ThreadGroup("Mon groupe");
		Thread Processus = new Thread(Groupe, "Un processus");
	}
}
