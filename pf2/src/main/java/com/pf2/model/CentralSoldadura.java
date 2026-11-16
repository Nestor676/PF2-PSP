package com.pf2.model;

import java.util.concurrent.Semaphore;

public class CentralSoldadura {
    public Semaphore sem = new Semaphore(3);
    public Semaphore mutex = new Semaphore(1);

    public int getEstacionesOcupadas(){
        return 3 - sem.availablePermits();
    }

    public int getEstacionesLibres(){
        return sem.availablePermits();
    }   
}
