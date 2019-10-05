/******************************************************************************
* FILE: omp_hello_world.c
* DESCRIPTION:
*   OpenMP Example - Hello World - C/C++ Version
* AUTHOR: Nour El Houda Ben Youssef
* LAST REVISED: 31/03/2019
******************************************************************************/
#include <omp.h>
#include <stdio.h>
#include <stdlib.h>

int main (int argc, char *argv[])
{
int nthreads, tid;
int valeur1=1000;
int valeur2=2000;
omp_set_num_threads(4);
/* Fork un ensemble de threads ayant chacun sa propre copie des variables */
#pragma omp parallel firstprivate(nthreads, tid,valeur2)
  {

  tid = omp_get_thread_num(); //obtenir l'id du thread
  valeur2++;
  printf("Thread num= %d a valeur1= %d et valeur 2=% d \n", tid, valeur1, valeur2);



  }//Tous les threads rejoignent le thread principal et se terminent

}

