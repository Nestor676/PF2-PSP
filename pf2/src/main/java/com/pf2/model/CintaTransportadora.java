package com.pf2.model;

import java.util.concurrent.locks.ReentrantLock;

public class CintaTransportadora {
    ReentrantLock lock = new ReentrantLock();

    public void CintaLlena(){
        lock.lock();
    }

    public void CintaVacia(){
        lock.unlock();
    }
}
