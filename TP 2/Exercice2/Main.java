package Section;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Main {
   public static void main(String[] main) throws InterruptedException{
      Lock lock = new ReentrantLock();
      Condition question = lock.newCondition();
      Condition reponse = lock.newCondition();
      Scheduler s =new Scheduler(lock, question, reponse);
      Personne personne = new Personne("personne",s);
      Journaliste journaliste = new Journaliste("journaliste",s);
      journaliste.start();
      personne.start();
   }
}
