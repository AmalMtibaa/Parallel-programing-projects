import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;
public class CleanerTask extends Thread {
	private ConcurrentLinkedQueue<Event> concurrentLinkedQueue;
	
	public CleanerTask(ConcurrentLinkedQueue<Event> concurrentLinkedQueue){
		this.concurrentLinkedQueue=concurrentLinkedQueue;
	}
	public void run() {
		while(true){
			Date date = new Date();
			clean(date);
		}
	}
	public  void clean(Date date){
		try{
		int size=concurrentLinkedQueue.size();
		for (int i=0;i<size;i++){
			Event headEvent=this.concurrentLinkedQueue.poll();
			System.out.println("Traitement Event"+headEvent.getEvent());
			if((date.getTime()-headEvent.getDate().getTime())/1000<10) //if period<10 , add in tail
				this.concurrentLinkedQueue.add(headEvent);
			}
		System.out.println("At the date :"+date.getTime()+" the size of the queue is : "+
			this.concurrentLinkedQueue.size());
		Thread.currentThread();
		Thread.sleep(100);
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
}