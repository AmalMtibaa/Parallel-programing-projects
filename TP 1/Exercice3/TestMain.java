import java.util.concurrent.ConcurrentLinkedQueue;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		  ConcurrentLinkedQueue<Event> queue = new ConcurrentLinkedQueue<Event>();
	      Thread writerTask1 = new Thread(new WriterTask(queue));
	      Thread writerTask2 = new Thread(new WriterTask(queue));
	      Thread writerTask3 = new Thread(new WriterTask(queue));
	      Thread writerTask4 = new Thread(new WriterTask(queue));

	      Thread cleanerTask = new Thread(new CleanerTask(queue));
	      
	   
	      writerTask1.start();
	      writerTask2.start();
	      writerTask3.start();
	      writerTask4.start();
	      
	      cleanerTask.start();
	}

}
