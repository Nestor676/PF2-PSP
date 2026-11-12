package com.pf2.model;

import java.util.concurrent.Semaphore;

public class CentralSoldadura {
    public Semaphore sem = new Semaphore(3);
}
