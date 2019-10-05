package Section;


public class Journaliste extends Thread{
   private String nom;
   Scheduler s;

   
   public Journaliste(String nom, Scheduler s){
	      this.nom = nom;
	      this.s=s;
	   }
   
   public void question(){
      try{
    	  s.poserQ(nom);
      }catch (InterruptedException e) {
         e.printStackTrace();}
   }  
   
   public void run(){
      while(true){
        question();
      }
   }
}