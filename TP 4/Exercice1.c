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
omp_set_num_threads(7);
/* Fork un ensemble de threads ayant chacun sa propre copie des variables */
#pragma omp parallel private(nthreads, tid)
  {


  tid = omp_get_thread_num(); //obtenir l'id du thread
  printf("Hello World du thread num= %d\n", tid); //Imprimer l'Id de Thread


  if (tid == 0) //Seule le thread maitre fait ces instructions
    {
    nthreads = omp_get_num_threads();
    printf("Nombre des threads = %d\n", nthreads);
    }

  }//Tous les threads rejoignent le thread principal et se terminent

}

