package com.pf2.tasks;

import com.pf2.model.CintaTransportadora;

public class AGVTask implements Runnable{
    
    CintaTransportadora cinta = new CintaTransportadora();

    public AGVTask(CintaTransportadora cinta){
        this.cinta = cinta;
    }

    @Override 
    public void run(){
        try{
            cinta.CintaLlena();
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            cinta.inc();
            IO.println("Bateria cargada en la cinta.");
        }finally{
            cinta.CintaVacia();
        }
    }
}
