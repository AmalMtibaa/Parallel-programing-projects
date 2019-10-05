package Section;

import java.util.Random;

public class Car extends Thread {

	private String name;
	private int place;
	private int sleeping;
	CarParkControl cpc;
	public Car(int num, CarParkControl cpc)
	{
		this.name="Car-"+num;
		this.cpc=cpc;
	}

	
	
	public String getName_() {
		return name;
	}



	public void setName_(String name) {
		this.name = name;
	}



	public int getSleeping() {
		return sleeping;
	}


	public void setSleeping(int sleeping) {
		this.sleeping = sleeping;
	}


	public int getPlace() {
		return place;
	}

	public void setPlace(int place) {
		this.place = place;
	}

	public void run(){
		System.out.println(name+" Starting...");
		 Random r = new Random();
		 sleeping=r.nextInt(5) * 1000;
		 try {
			cpc.arrive(this);
			cpc.depart(this);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		   }
}
