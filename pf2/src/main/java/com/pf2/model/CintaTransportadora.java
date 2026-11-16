package com.pf2.model;

import java.util.concurrent.locks.ReentrantLock;

public class CintaTransportadora {
    private ReentrantLock lock = new ReentrantLock();
    public boolean bol = true;
    private int baterias = 0; 

    public void CintaLlena(){
        lock.lock();
    }

    public void CintaVacia(){
        lock.unlock();
    }

    public synchronized void inc(){
        baterias++;
    }

    public synchronized void dec(){
        if(baterias > 0){
            bol = true;
            baterias--;
        }else{
            bol = false;
        }
    }

    public synchronized int getBaterias(){
        return baterias;
    }
}
