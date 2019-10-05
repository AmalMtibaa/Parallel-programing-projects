package Section;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;



public class Scheduler {
	private Scanner sc = new Scanner(System.in);
	Boolean attendre = false;
	private Lock verrou;
	private Condition question, reponse;
	
	public Scheduler(Lock verrou, Condition question, Condition reponse)
	{
		this.verrou=verrou;
		this.question=question;
		this.reponse=reponse;
	}
	
	 public void poserQ(String nom) throws InterruptedException 
     { 
         while (true) 
         { 
        	 
        	 verrou.lock();
      	      try{
      	    	 while (attendre==true) 
      	    		question.await();
                 System.out.println("La question de "+nom+" : ");
                 sc.nextLine();
                 attendre = true;
                 reponse.signalAll();

      	      }catch (InterruptedException e) {
      	         e.printStackTrace();
      	      }finally{
      	         verrou.unlock();
      	      }
         } 
     } 
	 
	 public void repondreQ(String nom) throws InterruptedException 
     { 
         while (true) 
         { 
        	 verrou.lock();
   	      try{
   	    	 while (attendre==false) 
                 reponse.await();
             System.out.println("La reponse de "+nom+" : ");
             sc.nextLine();
             attendre = false;
             question.signalAll();
   	      }catch (InterruptedException e) {
   	         e.printStackTrace();
   	      }finally{
   	         verrou.unlock();
   	      }
         } 
     } 
}
