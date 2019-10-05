import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;
//Classe WriterTask
public class WriterTask implements Runnable {
	
	//concurrentLinkedQueue est la structure qui contient les evénements
	private ConcurrentLinkedQueue<Event> concurrentLinkedQueue;
	
	public WriterTask(ConcurrentLinkedQueue<Event> concurrentLinkedQueue) {
		this.concurrentLinkedQueue = concurrentLinkedQueue;
		}

	public void run() {
	// Writes 100 events in deque
	try {
		for(int i=0;i<100;i++){
			Event event=new Event(new Date(),"Event coming from "+
					Thread.currentThread().getName()+" with i= "+i);
			concurrentLinkedQueue.offer(event);
			System.out.println("Adding new Event ="+event.getEvent());
			Thread.currentThread();
			Thread.sleep(100);
		}
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
