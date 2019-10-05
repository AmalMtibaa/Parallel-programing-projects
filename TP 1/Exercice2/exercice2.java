import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main extends Thread {
    private String Salutation;
    private int attente;
    private int number;
    public Main(String Salutation) {
        this.Salutation=Salutation;
    }
    public void run() {
        for (int i =1; i< 1000; i++)
            pw.println(i + " " + Salutation );

    }
    private static PrintWriter pw;
    public static void main(String[] args) throws IOException {
        Main thread1, thread2, thread3;
        // N'oubliez pas de changer l'emplacement du fichier log !
        pw=new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\HP\\Desktop\\output.txt",true)));
        thread1=new Main("Bonjour ");
        thread2=new Main("Bonsoir ");
        thread3=new Main("à demain ");
        pw.println("Je suis le main 🙂");
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pw.println("main terminé");
        //pw.close();
        System.exit(0);
    }
}