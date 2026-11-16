package com.pf2.tasks;

import com.pf2.model.CintaTransportadora;
import com.pf2.model.SupervisorCentral;

public class AGVTask implements Runnable{
    
    CintaTransportadora cinta = new CintaTransportadora();
    SupervisorCentral supervisor = new SupervisorCentral();

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
        }finally{
            cinta.CintaVacia();
        }
    }
}
