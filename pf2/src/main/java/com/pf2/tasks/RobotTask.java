package com.pf2.tasks;

import com.pf2.model.CentralSoldadura;

public class RobotTask implements Runnable{

    private int num;
    CentralSoldadura sol = new CentralSoldadura();

    public RobotTask(int num, CentralSoldadura sol){
        this.num = num;
        this.sol = sol;
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
            IO.println("El robot " + num + " a soldado");
            sol.sem.release();
        }
    }
}