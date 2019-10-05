package Section;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import section2.Job;

public class CarParkControl {

	protected int spaces;
	
	protected int capacity;
	
	protected Car cars[];

	Semaphore sem;
	
	CarParkControl(int n) {
	capacity = n;
	spaces = n;
	cars=new Car[n];
	sem = new Semaphore(n);
	}
	
	public int reserver()
	{
		for(int i =0;i<capacity;i++)
			if(cars[i]==null)
				return i;	
		return -1;
	}
	
	
	
	void arrive(Car car) throws InterruptedException {
		 try {
			 int verif;
			 sem.acquire();
		       synchronized(this)	{
		    	   		verif =reserver();
		        		car.setPlace(verif);
		        		cars[verif]=car;
		        		spaces--;
						System.out.println(car.getName_()+" entrée...");
		        	}
		       Thread.sleep(cars[verif].getSleeping());
		    } catch(InterruptedException e) {
		        e.printStackTrace();
		    }
	}
	
	void depart(Car car) throws InterruptedException {
		 synchronized(this)	{
		    		int pos =car.getPlace();
		    		cars[pos]=null;
		    		spaces++;
					System.out.println(car.getName_()+" sortie...");
		    	}
		    sem.release();
		    
	}
	
	public static void main(String args[]) {
		CarParkControl carpark = new CarParkControl(4);
		Thread thread[]=new Thread[10];
		for (int i=0; i<10; i++)
			thread[i]=new Car(i,carpark);
		for (int i=0; i<10; i++)
			thread[i].start();
		
	}
}
