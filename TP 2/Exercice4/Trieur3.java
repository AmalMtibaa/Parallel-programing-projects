package section2;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;


public class Trieur3 extends RecursiveAction {
  private int[] t;
  private int debut, fin;

  private Trieur3(int[] t, int debut, int fin) {
    this.t = t;
    this.debut = debut;
    this.fin = fin;
  }
  
  public Trieur3(int[] t) {
    this.t = t;
    this.debut = 0;
    this.fin = t.length - 1;
  }

  @Override
  protected void compute() {
    if (fin - debut < 2) {
      trierDirectement();
    }
    else {
      int milieu = debut + (fin - debut) / 2;
      invokeAll(new Trieur3(t, debut, milieu), new Trieur3(t, milieu + 1, fin));
      triFusion(debut, fin);
    }
  }

  private void trierDirectement() {
    if (t[debut] > t[fin]) {
      echanger(debut, fin);
    }
  }


  private void echanger(int i, int j) {
    int valeur = t[i];
    t[i] = t[j];
    t[j] = valeur;
  }


  private void triFusion(int debut, int fin) {
    int[] tFusion = new int[fin - debut + 1];
    int milieu = (debut + fin) / 2;
    int i1 = debut, 
        i2 = milieu + 1;
    int iFusion = 0;
    while (i1 <= milieu && i2 <= fin) {
      if (t[i1] < t[i2]) {
        tFusion[iFusion++] = t[i1++];
      }
      else {
        tFusion[iFusion++] = t[i2++]; 
      }
    }
    if (i1 > milieu) {
      for (int i = i2; i <= fin; ) {
        tFusion[iFusion++] = t[i++];
      }
    }
    else {
      for (int i = i1; i <= milieu; ) {
        tFusion[iFusion++] = t[i++];
      }
    }
    // Copie tFusion dans t
    for (int i = 0, j = debut; i <= fin - debut; ) {
      t[j++] = tFusion[i++];
    }
  }
  
  
  public static void main(String[] args) {
	  Random random = new Random();
	    int nb = 10000;
	    int[] t = new int[nb];
	    for (int i = 0; i < nb; i++) {
	      t[i] = random.nextInt(nb);
	    }
	    System.out.println("Before sort :");
	    System.out.println(Arrays.toString(t));
	    ForkJoinPool pool = new ForkJoinPool();
	    pool.invoke(new Trieur3(t));
	    System.out.println("After sort :");
	    System.out.println(Arrays.toString(t));
	    /*for (int i = 0; i < nb; i++) {
		     System.out.print(t[i]+" , ");
		    }*/
	  }
}