package com.pf2.tasks;

import com.pf2.model.CentralSoldadura;
import com.pf2.model.CintaTransportadora;

public class RobotTask implements Runnable{

    private int num;
    CentralSoldadura sol = new CentralSoldadura();
    CintaTransportadora cinta = new CintaTransportadora();

    public RobotTask(int num, CentralSoldadura sol, CintaTransportadora cinta){
        this.num = num;
        this.sol = sol;
        this.cinta = cinta;
    }

    @Override 
    public void run(){
        try{
            try{
                sol.sem.acquire();
            }catch(InterruptedException e){
                e.getMessage();
            }
        }finally{
            cinta.dec();

            if(cinta.bol == false) {
                IO.println("El robot " + num + " no ha podido soldar, por falta de baterias");
            }else{
                IO.println("El robot " + num + " a soldado");
            }
            sol.sem.release();
        }
    }
}