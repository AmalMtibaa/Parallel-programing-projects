package Section;


public class Personne extends Thread {

   private String nom;

   Scheduler s;

   public Personne(String nom,Scheduler s){
	      this.nom = nom;
	      this.s=s;
	   }
   
   public void reponse(){
	      try{
	    	  s.repondreQ(nom);
	      }catch (InterruptedException e) {
	         e.printStackTrace();
	      }
   }  
   
   public void run(){
      while(true){
         reponse();
      }
   }
}