package com.pf2.model;

public class SupervisorCentral {
    public boolean emer = false;

    public synchronized void comprobar(){
        while(emer) {
            try{
                wait();
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
                return; 
            }
        }
    }

    public synchronized void activar(int num){
        if(num == 1){
            emer = true;
            IO.println("Emergencia activada");
        }
    }

    public synchronized void desactivar(){
        emer = false;
        IO.println("Emergencia desactivada");
        notifyAll();
    }
}
